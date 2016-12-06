package org.pan.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by QiPan on 2016/12/5.
 */
public class UploadAction  extends ActionSupport{

    @Setter@Getter
    private List<File> photos;
    @Setter@Getter
    private List<String> photosContentType;
    @Setter@Getter
    private List<String> photosFileName;
    @Setter@Getter
    private List<String> userName;

    public String testUpload() throws IOException {
        System.out.println("userName: "+userName);
        System.out.println("photos: "+photos);
        System.out.println("photosFileName: "+ photosFileName);
        System.out.println("photosContentType: "+photosContentType);

        // 将文件传到服务器根目录下upload文件下
        // 获取ServletContext
        ServletContext servletContext = ServletActionContext.getServletContext();
        //获取真实路径
        String realPath = servletContext.getRealPath("/upload");
        System.out.println(realPath);
        File uploadFile = new File(realPath);
        //判断路径是否存在
        if (!uploadFile.exists()){
            //不存在创建
            uploadFile.mkdir();
        }
        for (int i = 0; i < photos.size(); i++) {
            UUID uuid = UUID.randomUUID();
            FileUtils.copyFile(photos.get(i), new File(realPath + "/" + uuid + photosFileName.get(i)));
        }
        return SUCCESS;
    }
}
