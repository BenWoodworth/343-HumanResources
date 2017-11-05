package swen343.hr.util

import spark.Session
import swen343.hr.models.User

/**
 * Get the user currently logged in.
 */
fun Session?.user(): User? = this?.attribute<User>("user")

/**
 * Set the user currently logged in.
 */
fun Session?.user(user: User?) = this?.attribute("user", user)