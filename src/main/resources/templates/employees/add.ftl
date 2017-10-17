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
                            <table class="table table-user-information">
                                <tbody>

                                <tr>
                                    <td>Title:</td>
                                    <td>
                                        <input type="text" name="title"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Department:</td>
                                    <td>
                                        <input type="text" name="department"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Salary</td>
                                    <td>
                                        <input type="text" name="salary"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Address:</td>
                                    <td>
                                        <input type="text" name="title"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Phone Number:</td>
                                    <td>
                                        <input type="text" name="title"><br>
                                    </td>
                                </tr>

                                <tr>
                                    <td>Email:</td>
                                    <td>
                                        <input type="text" name="title"><br>
                                    </td>
                                </tr>


                                </tbody>
                            </table>

                            <A class="btn btn-primary btn-mid" role="button" type="submit" value="Submit" href="../">Save</A>
                        </div>

                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</html>