<#import "../lib/utils.ftl" as u>
<html>
    <@u.head/>
    <Title>Kenneth Martinez</Title>
    <div class="container">
        <div class="row">
            <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
            </div>




                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">${employee.firstName} ${employee.lastName}</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src=${employee.picture} width="140" height="180"> </div>


                            <div class=" col-md-9 col-lg-9 ">
                                <table class="table table-user-information">
                                    <tbody>

                                    <tr>
                                        <td>Title:</td>
                                        <td>${employee.title}</td>
                                    </tr>

                                    <tr>
                                        <td>Department:</td>
                                        <td>${employee.department}</td>
                                    </tr>

                                    <tr>
                                        <td>Salary</td>
                                        <td>${employee.salary}</td>
                                    </tr>

                                    <tr>
                                        <td>Address:</td>
                                        <td>${employee.address}</td>
                                    </tr>

                                    <tr>
                                        <td>Phone Number:</td>
                                        <td>${employee.phoneNumber}</td>
                                    </tr>

                                    <tr>
                                        <td>Email:</td>
                                        <td><a href="mailto:${employee.email}">${employee.email}</a></td>
                                    </tr>


                                    </tbody>
                                </table>


                            </div>
                        </div>

                    </div>

                    <A class="btn btn-primary btn-mid" role="button" href="../edit/${employee.username}" >Edit Profile</A>
                    <A class="btn btn-primary btn-mid" role="button" href="/" >Back</A>
                </div>


        </div>
    </div>
</html>