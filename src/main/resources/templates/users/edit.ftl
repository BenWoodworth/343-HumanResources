<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit ${user.username} </Title>
<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
        </div>


        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">${user.username}</h3>
            </div>
            <div class="panel-body">
                <div class="row">

                    <form action="submit" method="post" name="addUserForm" onsubmit="validateForm()">
                        <input type="hidden" name="id" value="${user.id}">

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>


                                <tr>
                                    <td>Username:</td>
                                    <td>
                                        <input type="text" name="username" value="${user.username}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Password hash:</td>
                                    <td>
                                        <input type="text" name="passwordHash" value="${user.passwordHash}">
                                    </td>
                                </tr>

                                <tr>
                                    <td>Permissions:</td>
                                    <td>
                                        <textarea type="text"
                                                  name="permissions"
                                                  cols="40"
                                                  rows="10">${permissions}</textarea>
                                    </td>
                                </tr>


                                </tbody>
                            </table>


                        </div>

                        <input class="btn btn-primary btn-mid" type="submit" value="Save"/>
                        <a class="btn github-button" role="button" href="../view/${user.username}">Cancel</a>
                    </form>
                </div>
            </div>


        </div>
    </div>
</div>
</div>
<script src="/js/validation.js"></script>
</html>
