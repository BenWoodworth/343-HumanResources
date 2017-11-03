package swen343.hr

import com.google.inject.*
import swen343.hr.dependencies.*

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ModuleHumanResources())
    val humanResources = injector.getInstance(HumanResources::class.java)

    humanResources.start()
}

private class ModuleHumanResources : Module {

    override fun configure(binder: Binder?) {
        binder?.apply {
            // TODO Bind based off the "useDummyServices" config option
            bind(EmployeeService::class.java).to(EmployeeServiceDummy::class.java)
            bind(UserService::class.java).to(UserServiceDummy::class.java)
        }
    }
}
