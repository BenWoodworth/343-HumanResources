package swen343.hr

import swen343.hr.controllers.ResourceTemplateLoader
import swen343.hr.controllers.SparkController
import swen343.hr.dependencies.EmployeeServiceDummy

fun main(args: Array<String>) {

    val controller = SparkController(
            templateLoader = ResourceTemplateLoader(),
            employeeService = EmployeeServiceDummy()
    )

    val humanResources = HumanResources(
            controller = controller
    )

    humanResources.start()
}
