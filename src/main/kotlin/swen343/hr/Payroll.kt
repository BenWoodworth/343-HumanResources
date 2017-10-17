package swen343.hr

interface Payroll {
    /**
     * Function dedicated to viewing an employee's payroll. Takes in an employee
     *
     * @param employee - The employee of subject viewing their payroll.
     */
    fun viewPayroll(employee: Employee)

    /**
     * Function dedicated to actually paying the employee his or her paycheck.
     *
     * @param employee - The employee of subject is paid money for his or her time.
     */
    fun payPaycheck(employee: Employee)

    /**
     * Function dedicated to holding any bonus pay that the user has .
     *
     * @param employee - The employee of subject has a set bonus for their next paycheck
     */
    fun bonusPay()

}