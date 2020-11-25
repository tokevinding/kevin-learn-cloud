package com.kevin.cloud.client.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin
 * @date 2020-07-25 19:11:07
 * @desc Swagger启用
 */
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.host:localhost}")
    private String swaggerHost;
    @Value("${swagger.scheme:localhost:${server.port}}")
    private String swaggerScheme;
    @Value("${swagger.basepath:/}")
    private String basePath;

    @Value("${swagger.desc:提供给后台管理的API}")
    private String desc;
    @Value("${system.default.author:Kevin}")
    private String author;
    @Value("${swagger.scan.basePackage:com.kevin.cloud.client.controller}")
    private String scanBasePackage;

    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(author + "'s API文档")
                .description(desc)
                .version("1.0")
                .build();

        Set<String> set = new HashSet<>();
        set.add(swaggerScheme);

        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHost)
                .pathMapping(basePath)
                .protocols(set)
//          .ignoredParameterTypes(Pageable.class)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(scanBasePackage))
                .paths(PathSelectors.any())
                .build();
    }
}