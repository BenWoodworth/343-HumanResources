//action="users/delete/

function removeUser(username){
    if (confirm("Are you sure you want to remove this user?")) {
        window.location.href = "users/delete/"+ username;
    }
}