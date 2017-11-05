<html>
<head></head>
<body>
<#if sessionUser??>
    Welcome back, ${sessionUser.username}!<br>

    <a href="/auth/sign-out">Sign out</a>.
<#else>
    You are not logged in!<br>

    Please <a href="/auth/login">login</a>
    or <a href="/auth/register">register</a>.
</#if>
</body>
</html>






