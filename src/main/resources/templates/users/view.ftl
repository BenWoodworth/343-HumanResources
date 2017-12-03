<#import "../lib/utils.ftl" as u>
<html>
<@u.head/>
<Title>Edit ${user.username} </Title>
<body>
<@u.nav_bar/>
<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
        </div>


        <div class="panel panel-info">
            <div class="panel-heading">
                <h2 class="panel-title">${user.username}</h2>
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
                                    <td>${user.username}</td>

                                </tr>
                                <td>Password:</td>
                                <td><b>*******</b></td>
                                </tr>

                                <tr>
                                    <td>Permissions:</td>

                                    <td>

                                    <#if permissions?has_content>
                                        <#list permissions as permission>
                                            <code>${permission}</code><br/>
                                        </#list>
                                    <#else>
                                        <i class="text-muted">None</i>
                                    </#if>

                                    </td>
                                </tr>


                                </tbody>
                            </table>

                        </div>

                        <div class="center-button">
                            <a class="btn btn-primary btn-mid" role="button" href="../edit/${user.username}">Edit</a>
                            <a class="btn btn-primary btn-mid" role="button" href="/users">Back</a>
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
<@u.footer/>
</html>
