<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
        <div class="container">

                <#if sessionUser??>
                    <h2>Welcome back, ${sessionUser.username}!</h2>
                <div class="container">

                            <h3>Please choose a Silo:</h3>

                    <div class="container">
                        <div class="row">
                            <A class="btn btn-warning btn-lg btn-responsive col-4 center-block" style="height: 200px" role="button"  href="/employees">Human Resources</A>
                            <A class="btn btn-primary btn-lg btn-responsive col-4 center-block" style="height: 200px" role="button"  href="http://sales.kennuware.com">Sales</A>
                            <A class="btn btn-secondary btn-lg btn-responsive col-4 text-center" style="height: 200px" role="button"  href="http://inventory.kennuware.com">Inventory</A>
                        </div>
                        <div class="row">
                            <A class="btn btn-info btn-lg btn-responsive col-4 text-center" style="height:200px" role="button"  href="http://accounting.kennuware.com">Accounting</A>
                            <A class="btn btn-success btn-lg btn-responsive col-4 text-center" style="height:200px"  role="button"  href="http://manufacturing.kennuware.com">Manufacturing</A>
                            <A class="btn btn-danger btn-lg btn-responsive col-4 text-center" style="height: 200px" role="button"  href="http://support.kennuware.com">Customer Support</A>
                        </div>
                    </div>

                </div>
                <#else>
                    <h2>Welcome to KennUware</h2>
                    <form class="form-signin" method="post" action="/auth/login">
                        <label for="input-username" class="sr-only">Username</label>
                        <input type="text" name="username" id="input-username" class="form-control" placeholder="Username" required autofocus>
                        <label for="input-password" class="sr-only">Password</label>
                        <input type="password" name="password" id="input-password" class="form-control" placeholder="Password" required>
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
                    </form>
                    <A href="users/register">Need an Account?</A>
                </#if>
        </div>

</body>
</html>






