package com.example.hormone.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @param
 * @return
 **/
@Data
@Component
public class SecurityProperties {

    /**
     * Request Headers ： Authorization
     */
    private String header;

    /**
     * 令牌前缀，最后留个空格 Bearer
     */
    @Value("${jwt.token-start-with}")
    private String tokenStartWith;

    /**
     * 必须使用最少88位的Base64对该令牌进行编码
     */
    @Value("${jwt.base64-secret}")
    private String base64Secret;

    /**
     * 令牌过期时间 此处单位/毫秒
     */
    @Value("${jwt.token-validity-in-seconds}")
    private Long tokenValidityInSeconds;

    /**
     * 在线用户 key，根据 key 查询 redis 中在线用户的数据
     */
    @Value("${jwt.online-key}")
    private String onlineKey;

    /**
     * 验证码 key
     */
    @Value("${jwt.code-key}")
    private String codeKey;

    /**
     * token 续期检查
     */
    @Value("${jwt.detect}")
    private Long detect;

    /**
     * 续期时间
     */
    @Value("${jwt.renew}")
    private Long renew;

    public String getTokenStartWith() {
        return tokenStartWith + " ";
    }
}
