package com.foot.stamp

import com.foot.stamp.testcontainers.TestContainersConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@ContextConfiguration(initializers = [TestContainersConfig.Initializer::class])
@SpringBootTest
class StampDomainApplicationTests {
    @Test
    fun contextLoads() {
    }
}
