package swen343.hr

fun main(args: Array<String>) {

    val hr = HumanResources(
            templateLoader = ResourceTemplateLoader()
    )

    hr.start()
}
