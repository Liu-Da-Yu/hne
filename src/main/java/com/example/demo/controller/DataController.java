package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.util.FileUtils;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@RestController
public class DataController {

    @Autowired
    InfoDao infoDao;

    @Autowired
    ProductDao productDao;

    @PostMapping("/commitInfo")
    public String commitInfo(Info info){

        try {
            info.setCreateDate(new Date());
            info.setUuid(UUID.randomUUID().toString());
            Info save = infoDao.save(info);
            return "success";
        }catch (Exception e){
            return "success!!!";
        }
    }

    @PostMapping("/getAllData")
    public String getAllData(){
        try {
            List<Info> all = infoDao.findAll();
            return JSONObject.toJSONString(all);
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping("/addProduct")
    public String addProduct( Product product ){
        try {
            product.setId( UUID.randomUUID().toString() );
            product.setCreateTime(new Date().toLocaleString());
            Product save = productDao.save(product);
        }catch (Exception e){
            return null;
        }
        return "success";
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("file")MultipartFile file ){

        try {

            if( file.isEmpty()){ return ""; }

            String originalFilename = file.getOriginalFilename();

            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            String fileName = UUID.randomUUID().toString()+"." + suffix;

            String filePath = ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ")+ "/productImg/";

            Boolean writePictureflag = FileUtils.uploadFile(file.getBytes(),filePath,fileName);

            if(writePictureflag){
                return Result.success( "imgId" , fileName );
            }

            return null ;
        }catch (FileSizeLimitExceededException ee){
            return Result.fail();
        }
        catch (Exception e){
            return null;
        }
    }
}
