package com.company.poc.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@ComponentScan(basePackages = ["com.company.poc"])
internal class HeroServiceApplication

fun main(args: Array<String>) {
    runApplication<HeroServiceApplication>(*args)
}
