<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit ${user.username} </Title>
<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">
        <div class="col-md-53 toppad  pull-right col-md-offset-3 ">
        </div>


        <div class="panel panel-info">
            <div class="panel-heading">
                <h2 class="panel-title">${user.username}</h2>
            </div>
            <div class="panel-body">
                <div class="row">

                    <form method="post" name="addUserForm">
                        <input type="hidden" name="id" value="${user.id}">

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>


                                <tr>
                                    <td>Username:</td>
                                    <td>
                                        <input type="text" name="username" value="${fields.username}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>New password:</td>
                                    <td>
                                        <input type="password" name="newPassword" value="">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Confirm new password:</td>
                                    <td>
                                        <input type="password" name="newPasswordConfirm" value="">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Permissions:</td>
                                    <td>
                                        <textarea type="text"
                                                  name="permissions"
                                                  cols="40"
                                                  rows="10">${fields.permissions}</textarea>
                                    </td>
                                </tr>


                                </tbody>
                            </table>


                        </div>
                        <div class="center-button">
                            <input class="btn btn-primary btn-mid" type="submit" value="Save"/>
                            <a class="btn github-button" role="button" href="../view/${user.username}">Cancel</a>
                        </div>
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
