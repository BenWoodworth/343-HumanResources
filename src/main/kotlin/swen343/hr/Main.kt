package swen343.hr

import com.google.inject.*
import swen343.hr.dependencies.*

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ModuleHumanResources())
    val humanResources = injector.getInstance(HumanResources::class.java)

    humanResources.start()
}

private class ModuleHumanResources : Module {

    override fun configure(binder: Binder?) {}

    @Provides
    @Singleton
    fun provideEmployeeService(hrProperties: HrProperties): EmployeeService {
        return if (hrProperties.development) {
            EmployeeServiceDummy()
        } else {
            EmployeeServiceJdbc()
        }
    }
}
