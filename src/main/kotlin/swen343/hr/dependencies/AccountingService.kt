package swen343.hr.dependencies

import com.google.inject.ImplementedBy

@ImplementedBy(AccountingServiceHttp::class)
interface AccountingService {

    fun getBudget(): Int
}