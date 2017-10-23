package swen343.hr.dependencies

import com.google.inject.ImplementedBy

/**
 * Created by ben on 10/23/17.
 */
@ImplementedBy(HrPropertiesFile::class)
interface HrProperties {

    val development: Boolean

    val port: Int
}