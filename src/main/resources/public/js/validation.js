function validateForm() {
    var name = document.forms["addUserForm"]["firstName"].value;
    var last = document.forms["addUserForm"]["lastName"].value;
    var department = document.forms["addUserForm"]["department"].value;
    var username = document.forms["addUserForm"]["username"].value;
    var password = document.forms["addUserForm"]["password"].value;

    if (name === "") {
        alert("Name must be filled out");
        return false;
    }
    if (last === "") {
        alert("Last name must be filled out");
        return false;
    }
    if (department === "") {
        alert("Please enter a valid department");
        return false;
    }
    if (username === "") {
        alert("Username cannot be empty");
        return false;
    }
    if (password === "") {
        alert("Password cannot be empty");
        return false;
    }
}

function validateRegistration() {
    var username = document.forms["registrationForm"]["username"].value;
    var password = document.forms["registrationForm"]["password"].value;

    if (username === "") {
        alert("Username must be filled out");
        return false;
    }
    if (password === "") {
        alert("Password must be filled out");
        return false;
    }
}