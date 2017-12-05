<#import "../lib/utils.ftl" as u>

<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
    <@u.nav_bar/>
    <div class="container">
        <br/>
        <div class="row">
            <div class="col" align="center">
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
            <div class="col" align="center">

                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="file" name="document">
                        <button type="submit" value="Upload">Upload</button>
                    </div>
                </form>
                <br/>
                <table class="table table-striped table-bordered table-hover" data-link="row">
                    <thead>
                    <tr>
                        <th>Document Name </th>
                        <th>Document Size</th>
                        <th>Options</th>
                    </tr>
                    </thead>
                    <tbody data-link="row" class="rowlink" id="myTable">
                        <#list documents as document>
                            <tr>
                                <td><a href="download/${document.name?url}">${document.name}</a></td>
                                <td><a href="download/${document.name?url}">${document.size}</a></td>
                                <td>
                                    <form onsubmit="return confirm('Do you really want to delete ${document.name}?');" method="POST" action="delete/${document.name?url}">
                                        <button type="submit" class="btn btn-danger" title="Delete document">Delete</button>
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
        </div>
    </div>
</body>
<@u.footer/>
</html>