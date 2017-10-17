package swen343.hr.controllers

import spark.Spark.path
import spark.kotlin.port
import spark.kotlin.staticFiles
import swen343.hr.dependencies.Controller
import swen343.hr.dependencies.TemplateLoader

/**
 * Created by ben on 10/16/17.
 */
class SparkController(
        private val templateLoader: TemplateLoader
) : Controller {

    override fun initialize() {
        port(1234)

        staticFiles.location("/public")

        path("", IndexController(templateLoader))
    }
}