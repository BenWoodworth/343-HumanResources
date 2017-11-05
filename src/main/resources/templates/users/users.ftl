<#import "../lib/utils.ftl" as u>


<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
<div class="container">
    <div class="span2 account-info">

        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Account
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="">My Profile</a></li>
                <li><a href="">user Profile</a></li>
                <li><a href="/auth/sign-out">Sign Out</a></li>

            </ul>
        </div>
    </div>
    <h2>Kennuware User Table</h2>

    <a class="btn btn-primary btn-mid" role="button"  href="users/add">Add user</a>
    <br></br>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Department</th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink">
        <#list users as user>
        <tr>
            <td><a href="users/profile/${user.username}" title="${user.username}" >${user.username}</a></td>
            <td><a href="users/profile/${user.username}" title="${user.username}" >${user.password}</a></td>
            <td><a href="users/profile/${user.username}" title="${user.username}" >${user.permissions}</a></td>
            <td>

                <button title="Delete user" onclick="removeuser('${user.username}')">-</button>
                <A class="btn icon" title="Edit user" role="button" href="users/edit/${user.username}" >
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                </A>



            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<script src="/js/user-list.js"></script>
</body>
</html>
