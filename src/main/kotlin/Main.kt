import spark.kotlin.*

fun main(args: Array<String>) {
    val http = ignite()

    http.port(1234)

    http.get("/") {
        """
        <html>
        <body>
            Hello, world!<br />

            Your IP address is ${request.ip()}<br />

            How are you doing today?
        </body>
        </html>
        """
    }
}
