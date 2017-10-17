<#import "lib/utils.ftl" as u>

<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>

    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink">
        <#list employees as employee>
        <tr>
            <td><a href="employees/profile/${employee.id}">${employee.firstName}</a></td>
            <td><a href="employees/profile/${employee.id}">${employee.lastName}</a></td>
            <td><a href="employees/profile/${employee.id}">${employee.email}</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
    <A class="btn btn-primary btn-mid" role="button"  href="employees/add">Add Employee</A>
</div>
</body>
</html>
