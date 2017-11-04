package swen343.hr.dependencies

import com.google.inject.ImplementedBy

/**
 * Created by ben on 11/3/17.
 */
@ImplementedBy(HashServiceSha256::class)
interface HashService {

    fun hash(string: String): String
}