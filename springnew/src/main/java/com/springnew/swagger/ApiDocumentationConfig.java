package com.springnew.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Springnew Resources",
                version = "V12.0.12",
                title = "Springnew Resource API",
                contact = @Contact(
                   name = "Springnew Team", 
                   email = "rapidx@hexaware.com", 
                   url = "http://www.hexaware.com"
                ),
                license = @License(
                   name = "Springnew 2.0", 
                   url = "http://www.hexaware.com/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.springnew.org")
)
public interface ApiDocumentationConfig {

}