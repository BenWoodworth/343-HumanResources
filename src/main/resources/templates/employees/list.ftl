<#import "../lib/utils.ftl" as u>

<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
<@u.nav_bar/>
<div class="container">

    <h2>Kennuware Employee Table</h2>


    <br></br>
    <div class="col-xs-8 col-xs-offset-2">
        <div class="input-group">
            <div class="input-group-btn search-panel">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    <span id="search_concept">Filter by</span> <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#department">Department</a></li>
                    <li><a href="#salary">Salary</a></li>
                    <li><a href="#position">Position</a></li>
                    <li class="divider"></li>
                    <li><a href="#all">Anything</a></li>
                </ul>
            </div>
            <input type="hidden" name="search_param" value="all" id="search_param">
            <input type="text" class="form-control" name="x" placeholder="Search term...">
                <button class="btn btn-primary" type="button">
                    <i class="fa fa-search" aria-hidden="true"></i>
                </button>

        </div>
    </div>
    <br></br>
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

                <form onsubmit="return confirm('Do you want to delete this employee?');" method="POST" action="/employees/delete/${employee.user.username}">
                    <input type="submit" title="Delete employee" value="-"/>
                    <script type="text/javascript" src="/js/employeeList.js"></script>
                    <A class="btn icon" title="Edit employee" role="button" href="employees/edit/${employee.user.username}">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </A>
                </form>


            </td>
        </tr>
        </#list>
        <script src="/js/filter.js"></script>
        <script src="/js/employeeList.js"></script>
        </tbody>
    </table>
</div>

</body>
<@u.footer/>
</html>
