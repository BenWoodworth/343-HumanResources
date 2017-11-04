<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Create an employee</Title>
<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Create a new employee</h3>
                </div>
                <div class="panel-body">
                    <div class="row">


                        <div class=" col-md-9 col-lg-9 ">
                            <form method="post" name="addUserForm" onsubmit="return validateForm()">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>*Username:</td>
                                        <td>
                                            <input type="text" name="username"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>*Password:</td>
                                        <td>
                                            <input type="password" name="password"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>*First name:</td>
                                        <td>
                                            <input type="text" name="firstName"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>*Last name:</td>
                                        <td>
                                            <input type="text" name="lastName"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Title:</td>
                                        <td>
                                            <input type="text" name="title"><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>*Department:</td>
                                        <td>
                                            <input type="text" name="department" list="departments" >
                                            <datalist id="departments">
                                                <option value="Human Resources">
                                                <option value="Sales">
                                                <option value="Accounting">
                                                <option value="Manufacturing">
                                                <option value="Customer Support">
                                            </datalist>
                                            <br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Salary</td>
                                        <td>
                                            <input type="text" name="salary"><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Phone Number:</td>
                                        <td>
                                            <input type="text" name="phoneNumber"><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Email:</td>
                                        <td>
                                            <input type="text" name="email"><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Address:</td>
                                        <td>
                                            <input type="text" name="address"><br>
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
</html>