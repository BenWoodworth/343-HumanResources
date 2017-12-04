<#import "../lib/utils.ftl" as u>

<html>
<@u.head/>
<title>Welcome to HR!</title>

<body>
    <@u.nav_bar/>
    <div class="container">
        <br/>
        <div class="row">
            <div class="col">
                <center>
                    <form method="post" enctype="multipart/form-data">
                        <input type="file" name="document">
                        <input type="submit" value="Upload">
                    </form>

                    <#list documents as document>
                        <button>delete</button>
                        <a href="${document.name?url}">${document.name}</a>:
                        ${document.size}
                        <br/>
                    </#list>
                </center>
            </div>
        </div>
    </div>
</body>
<@u.footer/>
</html>