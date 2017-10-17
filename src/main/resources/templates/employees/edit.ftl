<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit Kenneth Martinez</Title>
<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
        </div>



        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Kenneth Martinez</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://ritpedia.rit.edu/images/0/0f/KennethMartinez.jpg" class="img-circle img-responsive"> </div>


                    <div class=" col-md-9 col-lg-9 ">
                        <table class="table table-user-information">
                            <tbody>
                            <form type="put">
                            <tr>
                                <td>Title:</td>
                                <td>
                                    <input type="text" name="title" value="${employee.title}">
                                </td>
                            </tr>

                            <tr>
                                <td>Department:</td>
                                <td>
                                    <input type="text" name="department" value="${employee.department}">
                                </td>
                            </tr>

                            <tr>
                                <td>Salary</td>
                                <td>
                                    <input type="text" name="salary" value="${employee.salary}">
                                </td>
                            </tr>

                            <tr>
                                <td>Address:</td>
                                <td>
                                    <input type="text" name="address" value="${employee.address}">
                                </td>
                            </tr>

                            <tr>
                                <td>Phone Number:</td>
                                <td>
                                    <input type="text" name="phoneNumber" value="${employee.phoneNumber}">
                                </td>
                            </tr>

                            <tr>
                                <td>Email:</td>
                                <td>
                                    <input type="text" name="email" value="${employee.email}"><br>
                                </td>
                            </tr>

                            </form>
                            </tbody>
                        </table>


                    </div>

                    <A class="btn btn-primary btn-mid" role="button" type="submit" value="Save" href="../profile/${employee.id}">Save</A>
                </div>
            </div>


        </div>
    </div>
</div>
</div>
</html>