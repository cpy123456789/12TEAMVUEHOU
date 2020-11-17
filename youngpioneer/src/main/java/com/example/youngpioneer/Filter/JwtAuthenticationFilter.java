package com.example.youngpioneer.Filter;

import com.example.youngpioneer.utils.JwtUtil;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
@WebFilter(urlPatterns = "/*")
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (isProtectedUrl(httpServletRequest)){
            String token = httpServletRequest.getHeader("Authorization");
            token = URLDecoder.decode(token);
            //通过工具类检车jwt，不合法或者已经过期，直接返回
            JwtUtil.validateToken(token);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        } else {
            httpServletResponse.sendError(httpServletResponse.SC_UNAUTHORIZED,"error");
            return;
        }


    }
    //我们对/api 的接口检查 jwt,
    public boolean isProtectedUrl(HttpServletRequest request){
        boolean b = pathMatcher.match("/*/token/*/", request.getServletPath());
        return b;
    }

}
