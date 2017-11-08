<#import "navbar.ftl" as navbar>
<#macro template title showNav>

<html>
<head>
    <title>${title}</title>
</head>
<body>
    <#if showNav>
        <@navbar/>
    </#if>

    <div>
        <#nested>
    </div>
</body>
</html>

</#macro>