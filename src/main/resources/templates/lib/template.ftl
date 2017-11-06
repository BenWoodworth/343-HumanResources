<#import "navbar.ftl" as navbar>
<#macro template title showNav>

<html>
<head>

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
</import>