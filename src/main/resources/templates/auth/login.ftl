<#import "../lib/template.ftl" as template>
<#import "../lib/utils.ftl" as u>
<@u.head/>
<@template.template title="Login - KennUWare" showNav=false>
    <#if sessionUser??>
        <h2>You are already logged in</h2>
    <#else>
    <div class="container">
        <div class="row">
            <div class="col">

            </div>
            <div class="col">
                <form class="form-signin" method="post">
                    <h2 class="form-signin-heading">KennUWare Login</h2>
                    <@u.validation_errors/>
                    <br/>
                    <label for="input-username" class="sr-only">Username</label>
                    <input type="text" name="username" id="input-username" class="form-control" placeholder="Username" required autofocus>

                    <label for="input-password" class="sr-only">Password</label>
                    <input type="password" name="password" id="input-password" class="form-control" placeholder="Password" required>
                    <br/>
                    <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
                </form>
            </div>
            <div class="col">

            </div>
        </div.
    </div>
    </#if>
</@template.template>
