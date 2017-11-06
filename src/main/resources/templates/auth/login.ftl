<#import "/lib/template.ftl" as template>
<#import "/lib/utils.ftl" as u>
<@template.template title="Login" showNav=false>
    <#if sessionUser??>
        <h2>You are already logged in</h2>
    <#else>
        <form class="form-signin" method="post">
            <h2 class="form-signin-heading">KennUWare Login</h2>
            <@u.validation_errors/>
            <label for="input-username" class="sr-only">Username</label>
            <input type="text" name="username" id="input-username" class="form-control" placeholder="Username" required autofocus>
            <label for="input-password" class="sr-only">Password</label>
            <input type="password" name="password" id="input-password" class="form-control" placeholder="Password" required>
            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
        </form>
    </#if>
</@template.template>