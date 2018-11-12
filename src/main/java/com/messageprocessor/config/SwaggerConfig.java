package com.messageprocessor.config;

import com.messageprocessor.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * purpose : Configuration class for swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String USER_NAME = "Jyoti Verma";
    private static final String USER_EMAIL = "jyotiverma.decipher@gmail.com";
    private static final String USER_URL = "https://github.com/jyotivermadecipher";
    private static final String BASE_PACKAGE = Constants.BASE_PACKAGE + ".controller";

    /**
     * Configures swagger for accessing controllers
     * @return Docket
     */
    @Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getMetaData());
    }

    private ApiInfo getMetaData() {
        return new ApiInfo(
                "Message Processing Rest Api",
                "Rest api for Message Processing",
                "1.0",
                StringUtils.EMPTY,
                new Contact(USER_NAME, USER_URL, USER_EMAIL), StringUtils.EMPTY, StringUtils.EMPTY);
    }
}
