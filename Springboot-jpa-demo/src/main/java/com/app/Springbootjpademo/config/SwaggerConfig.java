package com.app.Springbootjpademo.config;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Component
@OpenAPIDefinition(info = @Info(title = "Merchant API",version = "1.0",description = "Merchant Api UI"))
public class SwaggerConfig {

}
