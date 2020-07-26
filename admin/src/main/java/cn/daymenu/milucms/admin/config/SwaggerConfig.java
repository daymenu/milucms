package cn.daymenu.milucms.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author madison
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);
    private ApiInfo initApiInfo() {
        Contact contact = new Contact("milucms", "http://phpcap.com","hanjian2018@126.com");
        return new ApiInfo("麋鹿不迷路",
                "麋鹿不迷路 admin api",
                "1.0",
                "http://phpcap.com",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    @Bean
    public Docket restfulApi() {
        LOGGER.info("http://localhost:8080/admin/swagger-ui.html");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .pathMapping("")
                .select()
                .build()
                .apiInfo(initApiInfo());
    }
}
