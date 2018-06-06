package org.pan.lombok.annotation;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;
import org.pan.lombok.annotation.Getter;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * 自定义编译时的注解处理器
 * @author Qipan.G:
 * @since 2018/6/6 13:55
 */
@SupportedAnnotationTypes("org.pan.lombok.annotation.Getter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GetterProcessor extends AbstractProcessor {

    /**
     * 主要是用来在编译期打log用的
     */
    private Messager messager;

    /**
     * 提供了待处理的抽象语法树
     */
    private JavacTrees trees;

    /**
     * 封装了创建AST节点的一些方法
     */
    private TreeMaker treeMaker;

    /**
     * 提供了创建标识符的方法
     */
    private Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //利用roundEnv的getElementsAnnotatedWith方法过滤出被Getter这个注解标记的类，并存入set
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Getter.class);
        set.forEach(element -> {
            //遍历这个set里的每一个元素，并生成jCTree这个语法树
            JCTree jcTree = trees.getTree(element);
            //创建一个TreeTranslator，并重写其中的visitClassDef方法，这个方法处理遍历语法树得到的类定义部分jcClassDecl
            jcTree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {

                    //创建一个jcVariableDeclList保存类的成员变量
                    List<JCTree.JCVariableDecl> jcVariableDeclList = List.nil();

                    //遍历jcTree的所有成员(包括成员变量和成员函数和构造函数)，过滤出其中的成员变量，并添加进jcVariableDeclList
                    for (JCTree tree : jcClassDecl.defs) {
                        if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                            JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl) tree;
                            jcVariableDeclList = jcVariableDeclList.append(jcVariableDecl);
                        }
                    }

                    // 将jcVariableDeclList的所有变量转换成需要添加的getter方法，并添加进jcClassDecl的成员中
                    jcVariableDeclList.forEach(jcVariableDecl -> {
                        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.getName() + " has been processed");
                        // 调用默认的遍历方法遍历处理后的jcClassDecl
                        jcClassDecl.defs = jcClassDecl.defs.prepend(makeGetterMethodDecl(jcVariableDecl));
                    });
                    //利用上面的TreeTranslator去处理jcTree
                    super.visitClassDef(jcClassDecl);
                }
            });
        });
        return true;
    }

    private JCTree.JCMethodDecl makeGetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {

        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.getName())));
        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());
        return treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC), getNewMethodName(jcVariableDecl.getName()), jcVariableDecl.vartype, List.nil(), List.nil(), List.nil(), body, null);
    }

    private Name getNewMethodName(Name name) {
        String s = name.toString();
        return names.fromString("get" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }

}
