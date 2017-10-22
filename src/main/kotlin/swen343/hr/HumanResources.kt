package swen343.hr

import com.google.inject.Inject
import swen343.hr.dependencies.WebFramework

/**
 * Created by ben on 10/16/17.
 */
class HumanResources @Inject constructor(
        private val controller: WebFramework
) {

    fun start() {
        controller.initialize()
    }
}