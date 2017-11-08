<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit ${fields.firstName} ${fields.lastName}</Title>
<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
        </div>


        <div class="panel panel-info">
            <div class="panel-heading" >
                <h3 class="panel-title">${employee.firstName} ${employee.lastName}</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3 col-lg-3 " align="center">
                        <#--<img alt="User Pic"-->
                             <#--src="https://ritpedia.rit.edu/images/0/0f/KennethMartinez.jpg"-->
                             <#--class="img-circle img-responsive">-->
                    </div>
                    <form method="post" name="addUserForm" onsubmit="validateForm()">
                        <@u.validation_errors/>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>

                                <tr>
                                    <td>First name:</td>
                                    <td>
                                        <input type="text" name="firstName" value="${fields.firstName}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Last name:</td>
                                    <td>
                                        <input type="text" name="lastName" value="${fields.lastName}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Title:</td>
                                    <td>
                                        <input type="text" name="title" value="${fields.title}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Department:</td>
                                    <td>
                                        <input type="text" name="department" value="${fields.department}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Salary</td>
                                    <td>
                                        <input type="number" name="salary" value="${fields.salary}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Address:</td>
                                    <td>
                                        <input type="text" name="address" value="${fields.address}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Phone Number:</td>
                                    <td>
                                        <input type="text" name="phoneNumber" value="${fields.phoneNumber}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Email:</td>
                                    <td>
                                        <input type="email" name="email" value="${fields.email}"><br>
                                    </td>
                                </tr>


                                </tbody>
                            </table>


                        </div>

                        <input class="btn btn-primary btn-mid" type="submit" value="Save"/>
                        <a class="btn github-button" role="button" href="/employees/view/${employee.user.username}">Cancel</a>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>
</div>
<script src="/js/validation.js"></script>
</body>
</html>


