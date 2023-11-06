package com.microservice.zuul.filters;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PreFilter.class);
	
	@Override
	public String filterType() {
		return "pre";
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
		
		log.info("ENTRANDO A FILTRO PRE");
		
		log.info(String.format("ZuulRequestHeaders before adding X-Request-ID header (added-uuid-in-prefilter) -> %s", ctx.getZuulRequestHeaders()));
		ctx.addZuulRequestHeader("added-uuid-in-prefilter", UUID.randomUUID().toString());
		
		return null;
	}
}
