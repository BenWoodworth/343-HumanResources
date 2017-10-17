<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Create an employee</Title>
<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
            <A href="edit-employee" >Edit Profile</A>

        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Create employee</h3>
                </div>
                <div class="panel-body">
                    <div class="row">


                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>

                                <tr>
                                    <td>Title:</td>
                                    <td><form>

                                        <input type="text" name="title"><br>

                                    </form></td>
                                </tr>

                                <tr>
                                    <td>Department:</td>
                                    <td>Human Resources</td>
                                </tr>

                                <tr>
                                    <td>Salary</td>
                                    <td>$1,000,000</td>
                                </tr>

                                <tr>
                                    <td>Address:</td>
                                    <td>Somewhere</td>
                                </tr>

                                <tr>
                                    <td>Phone Number:</td>
                                    <td>123-456-789</td>
                                </tr>

                                <tr>
                                    <td>Email:</td>
                                    <td><a href="mailto:bla@rit.edu">bla@rit.edu</a></td>
                                </tr>


                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</html>