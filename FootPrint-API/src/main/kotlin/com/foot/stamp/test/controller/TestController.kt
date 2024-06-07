package com.foot.stamp.test.controller

import com.foot.stamp.test.spec.TestControllerSpec
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/test")
class TestController : TestControllerSpec {
    @GetMapping("/test")
    override fun success(test: String): ResponseEntity<String> {
        return ResponseEntity.ok(test)
    }
}
