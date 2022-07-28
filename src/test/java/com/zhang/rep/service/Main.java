package com.zhang.rep.service;
import com.zhang.rep.controller.BaseController;
import com.zhang.rep.entity.User;
import com.zhang.rep.entity.hp.PageInformation;
import com.zhang.rep.service.impl.hE.HelpEncapsulating;
import com.zhang.rep.service.impl.hE.HelpEncapsulatingImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.HandlerInterceptor;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;

public class Main {



    public static void main(String[] args)
            throws Exception {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
//            Calendar calendar = Calendar.getInstance();
//            calendar.get(Calendar.YEAR);
//            calendar.get(Calendar.MONTH);
//            calendar.get(Calendar.DATE);
        InetAddress addr = InetAddress.getLocalHost();

        Date date = new Date();
        long time = date.getTime();
        String s = String.valueOf(time);
        System.out.println(time);
        String substring = s.substring(4);
        System.out.println(substring);
        System.out.println(addr);

        System.out.println(SpringVersion.getVersion());

        System.out.println(System.getProperty("user.dir"));

        BigDecimal bigDecimal = new BigDecimal(500);
        BigDecimal bigDecimal1 = new BigDecimal(200);
        System.out.println(bigDecimal1.subtract(bigDecimal));

////
//        User user = new User();
//        user.setUsername("asda");
//        System.out.println(user.getUsername());
//        String id = "1231";
//        System.out.println("id=" + id);
//        System.out.println(user);
//        System.out.println(user.toString());
//        Date date = new Date();
//        long time = date.getTime();
//        System.out.println(time);
//        String timeID = String.valueOf(time);
//        System.out.println(timeID.substring(timeID.length() - 8));
//        System.out.println("QYRr7NKFe7ddP286");

    }
}