<#import "lib/utils.ftl" as u>

<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>
    <A class="btn btn-primary btn-mid" role="button"  href="employees/add">Add Employee</A>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>Email</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink">
        <#list employees as employee>
        <tr>
            <td><a href="employees/profile/${employee.id}">${employee.firstName}</a></td>
            <td><a href="employees/profile/${employee.id}">${employee.lastName}</a></td>
            <td><a href="employees/profile/${employee.id}">${employee.email}</a></td>
            <td>
                <form action="employees/delete/${employee.id}" type="get">
                    <input type="submit" value="-" />
                </form>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>
