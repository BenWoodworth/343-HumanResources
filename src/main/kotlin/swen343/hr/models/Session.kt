package swen343.hr.models

import java.util.*

/**
 * Created by ben on 11/9/17.
 */
data class Session(
        val sessionId: String,
        val user: User,
        val expiration: Date
)