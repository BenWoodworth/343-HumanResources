//action="employees/delete/

function removeEmployee(employeeId){
    if (confirm("Are you sure you want to remove this employee?")) {
        window.location.href = "employees/delete/"+ employeeId;
    }
}