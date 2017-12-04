<#import "../lib/utils.ftl" as u>


<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">
        <div class="col" align="center">
            <h2>Kennuware User Table</h2>
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
            <a class="btn btn-primary btn-mid" role="button"  href="add/">Add user</a>
        </div>
        <div class="col">
        </div>
        <div class="col" align="right">
        </div>
    </div>

    <br/>
    <table class="table table-striped table-bordered table-hover" data-link="row">
        <thead>
        <tr>
            <th>Username</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody data-link="row" class="rowlink" id="myTable">
        <#list users as user>
        <tr>
            <td><a href="view/${user.username}/" title="${user.username}" >${user.username}</a></td>


            <td>

                <form onsubmit="return confirm('Do you want to delete this user?');" method="POST" action="delete/${user.username}/">
                    <input type="submit" title="Delete user" value="-"/>
                    <script type="text/javascript" src="/js/userList.js"></script>
                    <A class="btn icon" title="Edit employee" role="button" href="edit/${user.username}/">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </A>
                </form>



            </td>
        </tr>
        </#list>
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
<script src="/js/userList.js"></script>
</body>
<@u.footer/>
</html>
