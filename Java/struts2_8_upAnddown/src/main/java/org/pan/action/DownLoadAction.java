package org.pan.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;

/**
 * Created by QiPan on 2016/12/5.
 */
public class DownLoadAction extends ActionSupport{
    //通常以下这几个参数会在Action 中提供
    @Setter@Getter
    private String contentType;
    @Setter@Getter
    private long contentLength;
    @Setter@Getter
    private String contentDisposition;
    @Setter@Getter
    private InputStream inputStream;

    public String testDownLoad() throws FileNotFoundException, UnsupportedEncodingException {
        //获取ServletContext
        ServletContext servletContext = ServletActionContext.getServletContext();
        //获取文件的路径
        String realPath = servletContext.getRealPath("/WEB-INF/file/至少还有你.mp3");
        //获取文件的流
        inputStream = new FileInputStream(realPath);
        //设置文件的类型
        contentType = servletContext.getMimeType(realPath);
        //获取文件的长度
        contentLength = new File(realPath).length();
        //设置文件名
        String fileName = "至少还有你.mp3";
        fileName = new String(fileName.getBytes("gbk"),"iso8859-1");
        contentDisposition = "attachment;filename="+fileName;
        return SUCCESS;
    }
}
