package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("public-api")
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.ashokit.rest"))
					.paths(PathSelectors.any()).build();
	}

	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ashok IT API")
				.description("Ashok IT API reference for developers")
				.termsOfServiceUrl("http://www.ashokit.in")
				.contact(new Contact("Ashok IT", "www.ashokit.in", "ashokitschool@gmail.com"))
				.license("Ashok IT License")
				.licenseUrl("ashokitschool@gmail.com")
				.version("1.0")
				.build();
	}

}