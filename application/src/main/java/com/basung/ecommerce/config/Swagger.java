package com.basung.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket createRestApi() {

	  //添加head参数start
	  ParameterBuilder tokenPar = new ParameterBuilder();
	  List<Parameter> pars = new ArrayList<Parameter>();
	  tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
	  pars.add(tokenPar.build());
	  //添加head参数end

	  Docket docket = new Docket(DocumentationType.SWAGGER_2)
		    .apiInfo(apiInfo())
		    .select()
		    .apis(RequestHandlerSelectors.basePackage("com.basung.ecommerce"))
		    .paths(PathSelectors.any())
		    .build();

	  docket.globalOperationParameters(pars);

	  return docket;
    }

    private ApiInfo apiInfo() {
	  return new ApiInfoBuilder()
		    .title("spring boot利用swagger构建api文档")
		    .description("简单优雅的restful风格")
		    .termsOfServiceUrl("http://www.basung.com")
		    .version("1.0")
		    .build();
    }


}
