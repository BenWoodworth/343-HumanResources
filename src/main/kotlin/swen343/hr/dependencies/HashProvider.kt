package swen343.hr.dependencies

import com.google.inject.ImplementedBy

/**
 * Created by ben on 11/3/17.
 */
@ImplementedBy(HashProviderSha256::class)
interface HashProvider {

    fun hash(string: String): String

    fun hash(bytes: ByteArray): String
}