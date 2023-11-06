package com.microservice.zuul.filters;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PostFilter.class);
	
	@Override
	public String filterType() {
		return "post";
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1000;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		List<Pair<String, String>> responseHeaders = ctx.getZuulResponseHeaders();
		
		log.info("ENTRANDO A FILTRO POST");
		log.info(String.format("ZuulRequestHeaders after adding X-Request-ID header (added-uuid-in-prefilter) -> %s", ctx.getZuulRequestHeaders()));
		
        if (responseHeaders != null) {
            log.info("Before removing the Date header:");
        	for (Pair<String, String> header : responseHeaders) {
        		log.info(String.format("Response Header -> %s : %s", header.first(), header.second()));
            }
            
            responseHeaders.removeIf(header -> "Date".equalsIgnoreCase(header.first()));
            
            log.info("After removing the Date header:");
            for (Pair<String, String> header : responseHeaders) {
            	log.info(String.format("Response Header -> %s : %s", header.first(), header.second()));
            }
        }        

		return null;
	}
}
