package swen343.hr

import swen343.hr.dependencies.Controller

/**
 * Created by ben on 10/16/17.
 */
class HumanResources(
        private val controller: Controller
) {

    fun start() {
        controller.initialize()
    }
}