package swen343.hr.dependencies

import com.google.inject.ImplementedBy

/**
 * Created by ben on 10/16/17.
 */
@ImplementedBy(WebFrameworkSpark::class)
interface WebFramework {

    fun initialize()
}