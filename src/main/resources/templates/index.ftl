<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
    <h2>Welcome to KennUware</h2>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-3" align="center">
                <#if sessionUser??>
                    Welcome back, ${sessionUser.username}!<br>

                    <a href="/auth/sign-out">Sign out</a>.
                <#else>
                    You are not logged in!<br>

                    Please <a href="/auth/login">login</a>
                    or <a href="/auth/register">register</a>.
                </#if>
            </div>
        </div>
    </div>

</body>
</html>






