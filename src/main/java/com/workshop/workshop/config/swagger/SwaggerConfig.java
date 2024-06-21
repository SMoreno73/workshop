package com.workshop.workshop.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Sebastian Moreno",
                        url = "https://github.com/SMoreno73",
                        email = "sebastianmorenoecheverri@gmail.com"
                ),
                title = "Documentation: Performance test Api",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080/api/v1")
        }
)
public class SwaggerConfig {
}
