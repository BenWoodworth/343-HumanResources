<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Registration</Title>
<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h2 class="panel-title">Register to KennUWare</h2>
                </div>
                <div class="panel-body">
                    <div class="row">


                        <div class=" col-md-9 col-lg-9 ">
                            <form method="post" name="registrationForm" onsubmit="return validateRegistration()">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Username:</td>
                                        <td>
                                            <input type="text" name="username"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Password:</td>
                                        <td>
                                            <input type="password" name="password"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Permissions:</td>
                                        <td>
                                            <textarea name="permissions" cols="40" rows="10"></textarea>
                                        </td>
                                    </tr>


                                    </tbody>
                                </table>

                                <input type="submit" class="btn btn-primary btn-mid" value="Save">
                            </form>
                        </div>

                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<script src="/js/validation.js"></script>
</body>
<@u.footer/>
</html>