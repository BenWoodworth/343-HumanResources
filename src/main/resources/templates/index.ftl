<#import "lib/utils.ftl" as u>

<html>
<@u.head/>
<body>
<div class="container">
    <h2>Kennuware Employee Table</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
            <#list employees as employee>
            <tr>
                <button>-</button>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</body>
</html>
