package swen343.hr

import swen343.hr.dependencies.ResourceTemplateLoader

fun main(args: Array<String>) {

    val hr = HumanResources(
            templateLoader = ResourceTemplateLoader()
    )

    hr.start()
}
