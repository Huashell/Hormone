package com.example.hormone.security.fliter;

import com.example.hormone.entity.User;
import com.example.hormone.service.UserService;
import com.example.hormone.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
//@Slf4j
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//    @Resource
//    private UserService userDetailsService;
//    @Resource
//    private JwtTokenUtil jwtTokenUtil;
//    @Value("${jwt.tokenHeader}")
//    private String tokenHeader;
//    @Value("${jwt.tokenHead}")
//    private String tokenHead;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request , HttpServletResponse response , FilterChain chain) throws ServletException, IOException {
//        String authHeader = request.getHeader(this.tokenHeader);
//
//        if (null != authHeader && authHeader.startsWith(this.tokenHead)) {
//            String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
//
//            Claims body = jwtTokenUtil.getPayload(authToken);
//            String userid = (String) body.get("userid");
//            log.info("checking username:{}", userid);
//
//            if (null != userid && null == SecurityContextHolder.getContext().getAuthentication()) {
//                User userDetails = this.userDetailsService.getMessageByUserId(userid);
//
//                if (jwtTokenUtil.parseToken(authToken)) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    log.info("authenticated user:{}", userid);
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}