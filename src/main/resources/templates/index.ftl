<#import "lib/utils.ftl" as u>

<html>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>
    <A class="btn btn-primary btn-mid" role="button"  href="employees/add">Add Employee</A>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th></th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink">
        <#list employees as employee>
        <tr>
            <td><a href="employees/profile">${employee.firstName}</a></td>
            <td><a href="employees/profile">${employee.lastName}</a></td>
            <td><a href="employees/profile">${employee.email}</a></td>
            <td><button>-</button></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>
