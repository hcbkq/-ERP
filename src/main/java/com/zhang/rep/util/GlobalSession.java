package com.zhang.rep.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GlobalSession {

    private final ConcurrentHashMap<String,HttpSession> SESSION_MAP = new ConcurrentHashMap<>();


    public void set(String key,HttpSession request){
        this.SESSION_MAP.put(key, request);
    }

    public HttpSession get(String key){
        return this.SESSION_MAP.get(key);
    }
}
