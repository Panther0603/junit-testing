package com.junittestingdemo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "open-api",version = "1.0",description = "user-management",contact = @Contact(
                    name = "Mohit",email = "mohit@gmail.com"
                )
        )
)
public class OpenAPIConfig {


}
