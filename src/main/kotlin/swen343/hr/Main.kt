package swen343.hr

import com.google.inject.*
import swen343.hr.dependencies.*

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ModuleHumanResources(
            ConfigProperties(ConfigPropertiesUpdater())
    ))
    val humanResources = injector.getInstance(HumanResources::class.java)

    humanResources.start()
}

private class ModuleHumanResources(
        private val config: Config
) : Module {

    override fun configure(binder: Binder?) {
        binder?.apply {
            if (config.useDummyServices) {
                bind(EmployeeService::class.java).to(EmployeeServiceDummy::class.java)
                bind(UserService::class.java).to(UserServiceDummy::class.java)
            }
        }
    }

    @Provides
    @Singleton
    fun provideConfig() = config
}
