package swen343.hr.controllers

import com.google.inject.Inject
import spark.kotlin.RouteHandler
import swen343.hr.models.User
import swen343.hr.util.RouteUtil

abstract class RequestHandler<TData>(
        vararg val permissions: String
) {

    @Inject private lateinit var routeUtil: RouteUtil

    fun handleRequest(routeHandler: RouteHandler) {
        authorize(routeHandler)

        handleRequest(
                mapRequest(routeHandler),
                routeUtil.user(routeHandler)
        )
    }

    fun authorize(routeHandler: RouteHandler) {
        routeUtil.requirePerms(routeHandler, *permissions)
    }

    abstract fun mapRequest(routeHandler: RouteHandler): TData

    abstract fun handleRequest(data: TData, sessionUser: User?)
}
