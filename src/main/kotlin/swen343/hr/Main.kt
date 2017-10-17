package swen343.hr

import swen343.hr.controllers.ResourceTemplateLoader
import swen343.hr.controllers.SparkController

fun main(args: Array<String>) {

    val controller = SparkController(
            templateLoader = ResourceTemplateLoader()
    )

    val humanResources = HumanResources(
            controller = controller
    )

    humanResources.start()
}
