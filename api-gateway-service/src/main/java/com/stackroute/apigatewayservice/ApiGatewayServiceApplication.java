package com.stackroute.apigatewayservice;

import com.stackroute.zuulfilters.ErrorFilter;
import com.stackroute.zuulfilters.PostFilter;
import com.stackroute.zuulfilters.PreFilter;
import com.stackroute.zuulfilters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}

