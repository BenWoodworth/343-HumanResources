package swen343.hr.dependencies

import com.google.inject.Singleton
import swen343.hr.models.Employee

@Singleton
class AccountingServiceHttp : AccountingService {

    override fun requestPayroll(employee: Employee): Boolean {
        TODO("Waiting for Accounting implementation")
    }

    override fun getBudget(): Int {
        TODO("Waiting for Accounting implementation")
    }
}