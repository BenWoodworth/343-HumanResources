<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit ${user.username} | ${employee.firstName} ${employee.lastName}</Title>
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
                    <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                        src="https://ritpedia.rit.edu/images/0/0f/KennethMartinez.jpg"
                                                                        class="img-circle img-responsive"></div>

                    <form action="submit" method="post" name="addUserForm" onsubmit="validateForm()">
                        <input type="hidden" name="username" value="${employee.user.username}">

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>


                                <tr>
                                    <td>Username:</td>
                                    <td>
                                        <input type="text" name="title" value="${user.username}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Password:</td>
                                    <td>
                                        <input type="text" name="title" value="${user.passwordHash}">
                                    </td>
                                </tr>

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
                                    <td>Permissions:</td>
                                    <td>
                                        <input type="text" name="title" value="${user.permissions}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Email:</td>
                                    <td>
                                        <input type="text" name="email" value="${employee.email}"><br>
                                    </td>
                                </tr>
                                </tbody>
                            </table>


                        </div>

                        <input class="btn btn-primary btn-mid" type="submit" value="Save"/>
                        <a class="btn github-button" role="button" href="../profile/${employee.user.username}">Cancel</a>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>
</div>
<script src="/js/validation.js"></script>
</html>
