package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Spring Boot Swagger Configuration")
        .description("\"Swagger configuration for application\"")
        .version("1.1.0")
        .license("Apache 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
        .build();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  //    @Bean
  //    public void addViewControllers() {
  //        ViewControllerRegistry registry = null;
  //        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
  //        registry.addRedirectViewController("/api/swagger-resources/configuration/ui",
  // "/swagger-resources/configuration/ui");
  //        registry.addRedirectViewController("/api/swagger-resources/configuration/security",
  // "/swagger-resources/configuration/security");
  //        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
  //    }
  //
  //    @Bean
  //    public void addResourceHandlers() {
  //        ResourceHandlerRegistry registry = null;
  //
  // registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
  //
  // registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  //    }
}
