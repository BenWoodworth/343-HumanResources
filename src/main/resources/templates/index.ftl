<#import "lib/utils.ftl" as u>
<html>
<title>Welcome to HR!</title>
<@u.head/>
<body>
        <div class="container">

                <#if sessionUser??>
                    <h2>Welcome back, ${sessionUser.username}!</h2>



                    <div class="container" style="padding-top: 50px">
                        <div class="container-fluid">
                            <div class="row" style="padding-left: 50 px; padding-right: 50px ">
                                <div class="col col-lg-4">
                                </div>
                                <div class="col col-lg-4">
                                    <h2>Please choose a Silo</h2>
                                </div>
                                <div class="col col-lg-4">
                                </div>
                            </div>
                            <div class="row" style="padding-left: 50 px; padding-right: 50px ">
                                <div class="col col-lg-4">
                                    <A class="btn btn-warning " style="height:200px; width: 300px; padding-top: 100px" role="button"  href="/employees">Human Resources</A>
                                </div>
                                <div class="col col-lg-4">
                                    <A class="btn btn-primary" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://sales.kennuware.com">Sales</A>
                                </div>

                                <div class="col col-lg-4">
                                    <A class="btn btn-secondary" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://inventory.kennuware.com">Inventory</A>
                                </div>
                            </div>
                            <div class="row" style="padding-top: 50px; padding-left: 50 px; padding-right: 50px">
                                <div class="col col-lg-4">
                                    <A class="btn btn-info " style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://accounting.kennuware.com">Accounting</A>
                                </div>
                                <div class="col col-lg-4">
                                    <A class="btn btn-success" style="height:200px; width: 300px; padding-top: 100px"  href="http://manufacturing.kennuware.com">Manufacturing</A>
                                </div>
                                <div class="col col-lg-4">
                                    <A class="btn btn-danger" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://support.kennuware.com">Customer Support</A>
                                </div>
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

<@u.footer/>
</html>






