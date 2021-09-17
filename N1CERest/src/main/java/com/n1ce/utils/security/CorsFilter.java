package com.n1ce.utils.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

import com.n1ce.utils.Constants;
import com.n1ce.utils.Utility;

@WebFilter(urlPatterns = {"/*"})
public class CorsFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);
    
    @Value("${logging.version}")
    private String loggingVersion;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	
    	String username;

        try {

        	MDC.put(Constants.VERSION, loggingVersion);
            MDC.put(Constants.ID_TRANSACTION, Utility.generateRandom(20));

            if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {

                HttpServletResponse response = (HttpServletResponse) res;
                HttpServletRequest request = (HttpServletRequest) req;
                
                Map<String, String> mapHeader = Utility.getHeadersInfo(request);

//                logger.debug("Mappa CORS FILTER: " + mapHeader.toString());

                username = mapHeader.get(Constants.X_USERNAME);

                MDC.put(Constants.USER, username);
                logger.debug("Start Verify CorsFilter");
                logger.info("Call USER: {}, METHOD: {}", username, request.getMethod());

                // Access-Control-Allow-Origin
                response.addHeader("Access-Control-Allow-Origin", "*");

                // Access-Control-Max-Age
                response.addHeader("Access-Control-Max-Age", "3600");

                // Access-Control-Allow-Credentials
                response.addHeader("Access-Control-Allow-Credentials", "true");

                // Access-Control-Allow-Methods
                response.addHeader("Access-Control-Allow-Methods", "POST, GET, DELETE,PUT,OPTIONS");

                // Access-Control-Allow-Headers
                response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization, x_username");
                response.addHeader("Access-Control-Expose-Headers", "x_username");

                response.addHeader("If-Modified-Since", "Mon, 26 Jul 1997 05:00:00 GMT");
                response.addHeader("Cache-Control", "no-cache");
                //OPTIONS: method preflight
                if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    chain.doFilter(req, res);
                }
            }
        } catch (Exception e) {
            logger.error("The error is: ", e);
        } finally {
            logger.debug("End Verify CorsFilter");
            MDC.remove(Constants.ID_TRANSACTION);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
