package com.example.demo.dao;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.support.ManagedMap;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {

    private Result () {}

    public static String success( String name , String data ){
       Map<String,Object> map =new HashMap<>();
        map.put(name,data);
        map.put("code",0);
        return JSONObject.toJSONString(map);
    }

    public static String fail(){
        Map<String,Object> map =new HashMap<>();
        map.put("code",1);
        return JSONObject.toJSONString(map);
    }
}
