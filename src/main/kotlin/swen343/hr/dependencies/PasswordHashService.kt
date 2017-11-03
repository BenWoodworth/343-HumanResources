package swen343.hr.dependencies

/**
 * Created by ben on 11/3/17.
 */
interface PasswordHashService {

    fun hashPassword(password: String): List<Byte>
}