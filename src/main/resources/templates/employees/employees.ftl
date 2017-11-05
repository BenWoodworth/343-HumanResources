<#import "../lib/utils.ftl" as u>


<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>
    <a class="btn btn-primary btn-mid" role="button"  href="employees/add">Add Employee</a>
    <br>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
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
            <td><a href="employees/profile/${employee.user.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.firstName}</a></td>
            <td><a href="employees/profile/${employee.user.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.lastName}</a></td>
            <td><a href="employees/profile/${employee.user.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.email}</a></td>
            <td><a href="employees/profile/${employee.user.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.department}</a></td>
            <td>

                <button title="Delete employee" onclick="removeEmployee('${employee.user.username}')">-</button>
                    <A class="btn icon" title="Edit employee" role="button" href="employees/edit/${employee.user.username}" >
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </A>



            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<script src="/js/employee-list.js"></script>
</body>
</html>
