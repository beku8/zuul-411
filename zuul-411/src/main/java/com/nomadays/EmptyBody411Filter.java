package com.nomadays;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 
 * Browser is setting content-length to -1 when DELETE/PATCH requests
 * are sent with empty request body.
 * This would turn into Transfer-Coding: Chunked & result in 411 error.
 * 
 * see for more here https://github.com/spring-cloud/spring-cloud-netflix/issues/1894
 * 
 * @author beku
 *
 */
@Component
public class EmptyBody411Filter extends OncePerRequestFilter {
  
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    logger.info("int {} long {}",request.getContentLength(), request.getContentLengthLong());
    if ("DELETE".equalsIgnoreCase(request.getMethod()) && request.getContentLengthLong() == -1) {
      logger.info("wrapping request");
      HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(request) {
        @Override
        public int getContentLength() {
          return 0;
        }

        @Override
        public long getContentLengthLong() {
          return 0l;
        }
      };
      filterChain.doFilter(wrappedRequest, response);
    } else {
      filterChain.doFilter(request, response);
    }
  }

}
