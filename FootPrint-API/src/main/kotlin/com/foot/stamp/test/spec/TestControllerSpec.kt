package com.foot.stamp.test.spec

import com.foot.stamp.config.swagger.SwaggerTag
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = SwaggerTag.TEST)
internal interface TestControllerSpec {
    @Operation(
        description = "테스트 API",
        parameters = [Parameter(name = "testId", description = "테스트", required = true, example = "Hello")],
    )
    fun success(): ResponseEntity<String>

    @Operation(
        description = "테스트 Error API",
    )
    fun error(): ResponseEntity<String>
}
