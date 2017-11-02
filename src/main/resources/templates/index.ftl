<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
<div class="container">

    <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Kennuware Login!</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
    </form>
    <A href="register">Need an Account?</A>
</div>
</body>
</html>