<form method="post" enctype="multipart/form-data">
    <input type="file" name="document">
    <input type="submit" value="Upload">
</form>

<#list documents as document>
    <button>delete</button>
    <a href="${document.name}">${document.name}</a>:
    ${document.size}
    <br/>
</#list>
