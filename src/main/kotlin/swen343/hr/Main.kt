package swen343.hr

import spark.kotlin.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun main(args: Array<String>) {
    port(1234)

    get("/") {
        createHTML().html {
            head {
                title("Welcome to HR!")
            }

            body {
                +"Hello, world!"
                br

                +"Your IP is ${request.ip()}"
                br

                +"How are you doing today?"
            }
        }
    }
}
