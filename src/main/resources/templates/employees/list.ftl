<#import "../lib/utils.ftl" as u>

<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
<@u.nav_bar/>
<div class="container">

    <h2>Kennuware Employee Table</h2>

    <a class="btn btn-primary btn-mid" role="button" href="/employees/add">Add Employee</a>
    <br></br>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>Username</th>
            <th>First</th>
            <th>Last</th>
            <th>Email</th>
            <th>Department</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink">
        <#list employees as employee>
        <tr>
            <td><a href="employees/view/${employee.user.username}"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.user.username}</a></td>
            <td><a href="employees/view/${employee.user.username}"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.firstName}</a></td>
            <td><a href="employees/view/${employee.user.username}"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.lastName}</a></td>
            <td><a href="employees/view/${employee.user.username}"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.email}</a></td>
            <td><a href="employees/view/${employee.user.username}"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.department}</a></td>
            <td>

                <form method="POST" action="/employees/delete/${employee.user.username}">
                    <input type="submit" title="Delete employee" value="-"/>
                    <A class="btn icon" title="Edit employee" role="button" href="employees/edit/${employee.user.username}">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </A>
                </form>


            </td>
        </tr>
        </#list>
        <script src="/js/employeeList.js"></script>
        </tbody>
    </table>
</div>

</body>
<@u.footer/>
</html>
