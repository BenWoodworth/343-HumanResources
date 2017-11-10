package swen343.hr.models

import java.sql.Date

/**
 * Created by ben on 11/9/17.
 */
data class Session(
        val token: String,
        val user: User,
        val ipAddress: String?,
        val expiration: Date?
)