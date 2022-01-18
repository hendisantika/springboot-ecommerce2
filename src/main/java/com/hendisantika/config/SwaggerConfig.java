package com.hendisantika.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.40
 */
@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hendisantika"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo getApiInfo() {
//        Contact contact = new Contact("hendisantika", "https://linktr.ee/hendisantika", "hendisantika@yahoo.co.id");
//        return new ApiInfoBuilder()
//                .title("ECommerce API")
//                .description("Documentation Ecommerce API")
//                .version("1.0.0")
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
//                .contact(contact)
//                .build();
//    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("ecommerce")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application" +
            "-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("ECommerce Application API")
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }
}
