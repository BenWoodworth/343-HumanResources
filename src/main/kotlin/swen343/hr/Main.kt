package swen343.hr

import swen343.hr.dependencies.TemplateLoaderResource
import swen343.hr.dependencies.WebFrameworkSpark
import swen343.hr.dependencies.EmployeeServiceDummy

fun main(args: Array<String>) {

    val controller = WebFrameworkSpark(
            templateLoader = TemplateLoaderResource(),
            employeeService = EmployeeServiceDummy()
    )

    val humanResources = HumanResources(
            controller = controller
    )

    humanResources.start()
}
