<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">

    <form class="form-signin" method="post">
        <h2 class="form-signin-heading">KennUWare Login</h2>
        <label for="input-username" class="sr-only">Username</label>
        <input type="text" id="input-username" class="form-control" placeholder="Username" required autofocus>
        <label for="input-password" class="sr-only">Password</label>
        <input type="password" id="input-password" class="form-control" placeholder="Password" required>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
    </form>
    <A href="register">Need an Account?</A>
</div>
</body>
</html>