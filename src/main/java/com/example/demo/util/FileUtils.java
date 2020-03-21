package com.example.demo.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * @author:DaYu
 * @date:2020/3/21-12:55
 * */
public class FileUtils {

    public static Boolean uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        FileOutputStream out = null;
        try {

            File targetFile = new File(filePath);

            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            out.close();
        }
    }
}