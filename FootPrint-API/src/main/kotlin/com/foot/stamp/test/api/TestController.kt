package com.foot.stamp.test.api

import com.foot.stamp.error.code.GlobalErrorCode
import com.foot.stamp.error.exception.CustomException
import com.foot.stamp.test.spec.TestControllerSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class TestController : TestControllerSpec {
    @Autowired
    val jdbcTemplate: JdbcTemplate? = null

    @GetMapping("/test")
    override fun success(): ResponseEntity<String> {
        val sql = "SELECT 'Success' FROM dual"
        return ResponseEntity.ok(jdbcTemplate?.queryForObject(sql))
    }

    @GetMapping("/error")
    override fun error(): ResponseEntity<String> {
        throw CustomException(GlobalErrorCode.INTERNAL_SERVER_ERROR)
    }
}
