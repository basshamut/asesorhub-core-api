package com.asesorhub.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = [
    "com.asesorhub.api.persistance.advisor.repository"
])
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
