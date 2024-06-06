package com.foot.stamp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StampApplication

fun main(args: Array<String>) {
    runApplication<StampApplication>(*args)
}
