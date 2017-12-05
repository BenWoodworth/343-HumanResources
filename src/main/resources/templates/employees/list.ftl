<#import "../lib/utils.ftl" as u>

<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">
        <div class="col" align="center">
            <h2>Kennuware Employee Table</h2>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col">
            <div class="input-group">
                <input type="hidden" name="search_param" value="all" id="search_param">
                <input type="text" class="form-control" name="x"  id="myInput" placeholder="Search term...">
                <button class="btn btn-primary" type="button">
                    <i class="fa fa-search" aria-hidden="true"></i>
                </button>
            </div>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col">
            <a class="btn btn-primary btn-mid" role="button" href="add/">Add Employee</a>
        </div>
        <div class="col">
        </div>
        <div class="col" align="right">

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
                Pay Employees
            </button>


            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Do you want to want to pay all of KenUWare's Employees?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Naw Fam!</button>
                            <button type="button" class="btn btn-success" data-dismiss="modal" method="POST" action="pay-all/" >Heck Yea!</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br/>
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
        <tbody data-link="row" class="rowlink" id="myTable">
        <#list employees as employee>
        <tr>
            <td><a href="view/${employee.user.username}/"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.user.username}</a></td>
            <td><a href="view/${employee.user.username}/"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.firstName}</a></td>
            <td><a href="view/${employee.user.username}/"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.lastName}</a></td>
            <td><a href="view/${employee.user.username}/"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.email}</a></td>
            <td><a href="view/${employee.user.username}/"
                   title="${employee.firstName} ${employee.lastName}'s profile">${employee.department}</a></td>
            <td>

                <form  onsubmit="return confirm('Do you really want to delete ${employee.firstName} ${employee.lastName}?');" method="POST" action="delete/${employee.user.username}/">
                    <input type="submit" title="Delete employee" value="-"/>
                    <A class="btn icon" title="Edit employee" role="button" href="edit/${employee.user.username}/">
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

    <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</div>

</body>
<@u.footer/>
</html>
