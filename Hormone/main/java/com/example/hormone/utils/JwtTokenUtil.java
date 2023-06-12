package com.example.hormone.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenUtil {

    //默认密钥
    public final static String DEFAULT_SECRET_KEY = "innovation_practice_course_assignment_todo_list";

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(DEFAULT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    //设置Claim
    public Claims setClaims(Integer userId, String username) {
        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        claims.put("username", username);
        return claims;
    }

    //构造token
    public String createToken(Claims claims) {
        //默认设置七天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 60 * 60 * 24 * 7);
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(calendar.getTime())
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
        return token;
    }

    //解析token判断是否过期,过期为false，未过期为true
    public Boolean parseToken(String token) {
        boolean flag = false;
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token);
            flag = true;
        } catch (JwtException e) {
            System.out.println(e.getMessage());;
        }
        return flag;
    }

    //获取header
    public JwsHeader getHeader(String token) {
        Boolean exceptionJudge = parseToken(token);
        JwsHeader header = null;
        if (exceptionJudge) {
            header = Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getHeader();
        }else {
            log.info("token已过期");
        }
        return header;
    }
    //获取payload
    public Claims getPayload(String token) {
        Boolean exceptionJudge = parseToken(token);
        Claims body = null;
        if (exceptionJudge) {
            body = Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

        }else {
            System.out.println("token已过期");
        }
        return body;
    }
    //获取时间数据
    public Object getExceptionTime(String token) {
        Boolean exceptionJudge = parseToken(token);
        Claims body = null;
        if (exceptionJudge) {
            body = Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }else {
            System.out.println("token已过期");
        }
        Object exp = body.get("exp");
        return exp;
    }

}
