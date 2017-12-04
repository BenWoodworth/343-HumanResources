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

                    <form method="post" enctype="multipart/form-data">
                        <input type="file" name="document">
                        <input type="submit" value="Upload">
                    </form>

                    <#list documents as document>
                        <a href="${document.name?url}">${document.name}</a>:
                        ${document.size}
                        <form  onsubmit="return confirm('Do you really want to delete ${document.name}?');" method="POST" action="delete/${employee.user.username}/documents/${document.name}/">
                            <input type="submit" title="Delete document" value="Delete"/>
                        </form>
                        <br/>
                    </#list>
            </div>
        </div>
    </div>
</body>
<@u.footer/>
</html>