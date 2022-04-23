package com.olx.masterdata;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class OlxMasterDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterDataApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapping() {
		return new ModelMapper();
	}
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("com.olx.masterdata"))
				.paths(PathSelectors.any())
				.build().apiInfo(getInfo());
	}
	
	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo = new ApiInfo("Swagger Restful Api Documentation",
				"This page given REST API Documentation for Stock", 
				"2.5", "My Teams of Service", 
				new Contact("Suraj Singh", "http://surajsingh.com", "surajsingh@gmail.com"), 
				"GPL", 
				"http://gpl.org"
				,new ArrayList<VendorExtension>());
		return apiInfo;
	} 
}
