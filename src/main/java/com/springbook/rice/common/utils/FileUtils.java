package com.springbook.rice.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具包
 */
public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){

        // 生成新的文件名
        //String realPath = path + "/" + FileNameUtils.getFileName(fileName);

        //使用原文件名
        String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    public static JSONPhotos uploadPhotos(MultipartFile file){
        JSONPhotos jsonPhotos=new JSONPhotos();
        // 要上传的目标文件存放路径
        String localPath = "D:/工作文档/IDEA/Photos";
        // 上传成功或者失败的提示
        String s;
        if (file.getOriginalFilename().split("\\\\").length!=1){
           s = file.getOriginalFilename().split("\\\\")[file.getOriginalFilename().split("\\\\").length - 1];
        }else {
            s=file.getOriginalFilename();
        }

        System.out.println(s);
        if (FileUtils.upload(file, localPath, s)){
            // 上传成功，给出页面提示
            jsonPhotos.setMsg("上传成功！");
            jsonPhotos.setUrl("/photos/"+s);

        }else {
            jsonPhotos.setMsg("上传失败！");

        }
        return jsonPhotos;
    }

}
