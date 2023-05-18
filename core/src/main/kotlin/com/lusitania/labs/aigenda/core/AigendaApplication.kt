package com.lusitania.labs.aigenda.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.lusitania.labs.aigenda"])
class AigendaApplication

fun main() {
    runApplication<AigendaApplication>()
}
