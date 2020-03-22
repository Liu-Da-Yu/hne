package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.util.FileUtils;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@RestController
public class DataController {

    @Autowired
    InfoDao infoDao;

    @Autowired
    ProductDao productDao;

    //保存用户提交的数据
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

    //获取所有用户提交的数据
    @PostMapping("/getAllData")
    public String getAllData(){
        try {
            List<Info> all = infoDao.findAll();
            return JSONObject.toJSONString(all);
        }catch (Exception e){
            return null;
        }
    }

    //添加产品
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

    //上传图片
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

    //查询产品
    @PostMapping("/getProducts")
    public String getProducts(@RequestParam("where") String where ){

        List<Product> all;
        try {

            if( StringUtils.isEmpty( where ) ){

                //查询所有
                all = productDao.findAll();

            }else{

                //根据条件查询
                Product example = new Product();
                example.setParent(where);
                Example<Product> ex = Example.of(example);
                all = productDao.findAll(ex);
            }

            if( all != null ){
                for (Product product : all) {
                    product.setInfoText("");
                    product.setInfoImgUrl("");
                    product.setParent("");
                    String url = product.getImgUrl();
                    if( !StringUtils.isEmpty(url)){
                        String[] split = url.split(";");
                        product.setImgUrl( split[1] + "" );
                    }
                }
            }

            return Result.success("data",all);

        }catch (Exception e){
            return Result.fail();
        }
    }

    //查询产品
    @PostMapping("/getProductById")
    public String getProductById(@RequestParam("id") String id ){

        try {

            //根据条件查询
            Product example = new Product();
            example.setId(id);
            Example<Product> ex = Example.of(example);
            List<Product> all = productDao.findAll(ex);
            return Result.success("data",all);

        }catch (Exception e){
            return Result.fail();
        }

    }
}
