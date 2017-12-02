<#import "navbar.ftl" as navbar>
<#import "utils.ftl" as util>
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
<@util.footer/>
</html>

</#macro>