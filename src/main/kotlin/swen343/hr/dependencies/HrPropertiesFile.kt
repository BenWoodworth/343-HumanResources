package swen343.hr.dependencies

import com.google.inject.Singleton

/**
 * Created by ben on 10/23/17.
 */
@Singleton
class HrPropertiesFile : HrProperties {

    override val development = true // TODO

    override val port = 1234 // TODO
}