<#import "lib/utils.ftl" as u>


<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>
    <A class="btn btn-primary btn-mid" role="button"  href="users/add">Add Employee</A>
    <A class="btn github-button" role="button" href="https://github.com/BenWoodworth/343-HumanResources" style="float: right">
        <i class="fa fa-github" aria-hidden="true"></i>
        Repository
    </A>
    <br></br>
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
        <#list users as employee>
        <tr>
            <td><a href="users/profile/${employee.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.firstName}</a></td>
            <td><a href="users/profile/${employee.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.lastName}</a></td>
            <td><a href="users/profile/${employee.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.email}</a></td>
            <td><a href="users/profile/${employee.username}" title="${employee.firstName} ${employee.lastName}'s profile" >${employee.department}</a></td>
            <td>

                <button title="Delete employee" onclick="removeEmployee('${employee.username}')">-</button>
                    <A class="btn icon" title="Edit employee" role="button" href="users/edit/${employee.username}" >
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </A>



            </td>
        </tr>
        </#list>
        </tbody>0
    </table>
</div>
<script src="/js/employeeList.js"></script>
</body>
</html>
