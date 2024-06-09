dependencies {

    // testContainers
    testImplementation("org.testcontainers:testcontainers:1.19.8")
    testImplementation("org.testcontainers:junit-jupiter:1.19.8")
    testImplementation("org.testcontainers:oracle-xe:1.19.8")
    testImplementation("io.kotest.extensions:kotest-extensions-testcontainers:2.0.2")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")

    // DB 설정
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.oracle.database.jdbc:ojdbc10:19.21.0.0")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}
