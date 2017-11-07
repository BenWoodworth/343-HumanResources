//action="employees/delete/

function removeEmployee(username){
    if (confirm("Are you sure you want to remove this employee?")) {
        window.location.href = "employees/delete/"+ username;
    }
}