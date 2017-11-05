<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
        <div class="container">
             <h2>Welcome to KennUware</h2>
                <#if sessionUser??>
                <div class="container">

                            <h2>Please choose a Silo</h2>

                            <A class="btn btn-primary btn-mid" role="button"  href="http://sales.kennuware.com">Sales</A>
                            <A class="btn btn-primary btn-mid" role="button"  href="http://inventory.kennuware.com">Inventory</A>
                            <A class="btn btn-primary btn-mid" role="button"  href="http://manufacturing.kennuware.com">Manufacturing</A>
                            <A class="btn btn-primary btn-mid" role="button"  href="http://accounting.kennuware.com">Accounting</A>
                            <A class="btn btn-primary btn-mid" role="button"  href="/employees">Human Resources</A>
                            <A class="btn btn-primary btn-mid" role="button"  href="http://support.kennuware.com">Customer Support</A>

                </div>
                <#else>
                    <form class="form-signin" method="post" action="/auth/login">
                        <label for="input-username" class="sr-only">Username</label>
                        <input type="text" name="username" id="input-username" class="form-control" placeholder="Username" required autofocus>
                        <label for="input-password" class="sr-only">Password</label>
                        <input type="password" name="password" id="input-password" class="form-control" placeholder="Password" required>
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
                    </form>
                    <A href="register">Need an Account?</A>
                </#if>
        </div>

</body>
</html>






