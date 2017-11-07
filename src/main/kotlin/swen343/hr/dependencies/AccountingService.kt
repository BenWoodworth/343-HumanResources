package swen343.hr.dependencies

import com.google.inject.ImplementedBy
import swen343.hr.models.Employee

@ImplementedBy(AccountingServiceHttp::class)
interface AccountingService {

    /**
     * Get this department's budget.
     */
    fun getBudget(): Int

    /**
     * Request for an employee's salary to be taken out of
     * the department's budget.
     *
     * @return `true` iff the request was successful
     */
    fun requestPayroll(employee: Employee): Boolean
}