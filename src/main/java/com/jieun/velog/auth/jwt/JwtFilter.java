package com.jieun.velog.auth.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("..................doFilter called");
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String token = request.getHeader("authorization");
        log.info("token : {}", token);

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
            return;
        } else {
            if (token == null || !token.startsWith("Bearer ")) {
                throw new ServletException("Authorization Failed");
            }
        }

        if (token != null && !token.equals("")) {    // 헤더에 토큰이 존재하는 경우
            if (jwtProvider.validateToken(token)) {
                JwtContext.setUserInfo(jwtProvider.parseJws(token));
                filterChain.doFilter(request, response);
            } else {
                throw new RuntimeException("Invalid Token");
            }
        } else {    // 헤더에 토큰이 없는 경우
            throw new RuntimeException("Authorization Failed");
        }

        filterChain.doFilter(request, response);
    }
}
