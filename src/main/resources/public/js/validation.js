function validateForm() {
    var name = document.forms["addUserForm"]["firstName"].value;
    var last = document.forms["addUserForm"]["lastName"].value;
    var department = document.forms["addUserForm"]["department"].value;
    if (name == "") {
        alert("Name must be filled out");
        return false;
    }
    else if (last == "") {
        alert("Last name must be filled out");
        return false;
    }
    else if (department == "") {
        alert("Please enter a valid department");
        return false;
    }
}