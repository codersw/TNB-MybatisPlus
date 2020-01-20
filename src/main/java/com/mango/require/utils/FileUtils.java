package com.mango.require.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 */
public class FileUtils extends org.apache.commons.io.FileUtils{

    /**
     * 文件上传
     * @param file
     * @param uploadPath
     * @return
     * @throws Exception
     */
    public static String uploadFile(MultipartFile file, String uploadPath) throws Exception {
        mkdirIfNotExits(uploadPath);
        String fileName = file.getOriginalFilename();
        String uuid= CommonUtils.UUID();
        //创建输出文件对象
        File outFile = new File(uploadPath  + uuid + getFileType(fileName));
        //拷贝文件到输出文件对象
        file.transferTo(outFile);
        return uuid + getFileType(fileName);
    }

    public static void saveFile(File file, String dir) throws Exception{
        BufferedWriter writer = null;
        //写入

    }

    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName) {
        if(fileName!=null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }

    /**
     * 创建目录
     * @param filePath
     */
    private static void mkdirIfNotExits(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 创建文件夹
     * @param filePath
     * @throws IOException
     */
    private static void createFileIfNotExits(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
