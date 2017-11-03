package swen343.hr.dependencies

/**
 * Created by ben on 11/3/17.
 */
interface HashService {

    fun hash(string: String): List<Byte>
}