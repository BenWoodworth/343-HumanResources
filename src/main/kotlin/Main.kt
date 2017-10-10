import spark.Spark.*

fun main(args: Array<String>) {
    port(1234)

    get("/") { request, _ ->
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
