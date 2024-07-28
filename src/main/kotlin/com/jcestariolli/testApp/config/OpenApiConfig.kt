package com.jcestariolli.testApp.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Test APP",
        version = "1.0",
        description = "Application to practice and validate architectural concepts"
    )
)
class OpenApiConfig