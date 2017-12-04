package swen343.hr.controllers

import com.google.inject.Inject
import spark.kotlin.RouteHandler
import swen343.hr.dependencies.TemplateLoader
import swen343.hr.util.RouteUtil

abstract class RequestHandler<TData>(
        vararg val permissions: String
) {

    @Inject protected lateinit var routeUtil: RouteUtil
    @Inject protected lateinit var templateLoader: TemplateLoader

    operator fun invoke(routeHandler: RouteHandler) {
        authorize(routeHandler)

        handleRequest(
                dataMapper(routeHandler),
                routeHandler
        )
    }

    abstract protected val dataMapper: RouteHandler.() -> TData

    protected fun authorize(routeHandler: RouteHandler) {
        routeUtil.requirePerms(routeHandler, *permissions)
    }

    abstract fun handleRequest(data: TData, routeHandler: RouteHandler): Any

    abstract class Basic(
            vararg permissions: String
    ) : RequestHandler<Unit>(*permissions) {

        override val dataMapper: RouteHandler.() -> Unit = {}

        final override fun handleRequest(data: Unit, routeHandler: RouteHandler): Any {
            return handleRequest(routeHandler)
        }

        abstract fun handleRequest(routeHandler: RouteHandler): Any
    }
}
