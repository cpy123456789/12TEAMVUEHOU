package com.example.youngpioneer.utils;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javafx.beans.binding.ObjectExpression;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//加密处理工具类
public class JwtUtil {
    static final String SECRET = "thisa";//密钥


    //token处理
    public static String generateToken(String username){
      Map<String, Object> map =   new HashMap<String,Object>();
      map.put("username",username);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 86_400_000L))//24H
                .signWith(SignatureAlgorithm.ES256, SECRET)
                .compact();
        return "berer" + jwt;
    }

    public static void validateToken(String token){
        Map<String,Object> body =  Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace("berer",""))
                .getBody();
        for (Object value : body.values()) {
            System.out.println(value);
        }
    }
}
