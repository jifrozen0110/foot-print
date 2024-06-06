package com.foot.stamp.testcontainers

import com.foot.stamp.testcontainers.TestContainersConfig.Companion.isSQLInit
import org.springframework.boot.sql.init.DatabaseInitializationMode
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.junit.jupiter.Container
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean

@TestConfiguration
class TestContainersConfig {
    companion object {
        private const val ORACLE_SID = "xe"
        private const val ORACLE_USER = "system"
        private const val ORACLE_PASSWORD = "oracle"

        private val isSQLInit = AtomicBoolean(false)

        @JvmStatic
        @Container
        val oracleContainer: GenericContainer<*> =
            GenericContainer("konempty/oracle-db-19c:latest")
                .withExposedPorts(1521)
                .withEnv("ORACLE_SID", ORACLE_SID)
                .withEnv("ORACLE_USER", ORACLE_USER)
                .withEnv("ORACLE_PASSWORD", ORACLE_PASSWORD)
                .waitingFor(Wait.forLogMessage(".*DATABASE IS READY TO USE!.*", 1))
    }

    internal class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            CompletableFuture.allOf(
                CompletableFuture.runAsync { oracleContainer.start() },
            ).get()

            val properties =
                mapOf(
                    "spring.datasource.url" to "jdbc:oracle:thin:@//" + oracleContainer.host + ":" +
                        oracleContainer.getMappedPort(1521) +
                        "/" + ORACLE_SID,
                    "spring.datasource.username" to ORACLE_USER,
                    "spring.datasource.password" to ORACLE_PASSWORD,
                    "spring.sql.init.mode" to (if (isSQLInit.get()) DatabaseInitializationMode.NEVER else DatabaseInitializationMode.ALWAYS).toString(),
                )
            isSQLInit.set(true)

            TestPropertyValues.of(properties).applyTo(configurableApplicationContext.environment)
        }
    }
}
