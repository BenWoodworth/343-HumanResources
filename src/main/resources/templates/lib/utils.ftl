<#macro head>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/css/jasny-bootstrap.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/js/jasny-bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</#macro>

<#macro nav_bar>
<nav class="navbar navbar-toggleable-md navbar-inverse" style="background-color: #444444;">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">KennUWare HR</a>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">
                        <i class="fa fa-building" aria-hidden="true"></i>
                    Silos
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employees/">
                    <i class="fa fa-briefcase" aria-hidden="true"></i>
                    Employees
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/users/">
                    <i class="fa fa-users" aria-hidden="true"></i>
                    Users
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://github.com/BenWoodworth/343-HumanResources">
                    <i class="fa fa-github" aria-hidden="true"></i>
                    Github
                </a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class=" nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user" aria-hidden="true"></i>
                ${sessionUser.username}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/users/view/${sessionUser.username}/">Profile</a>
                    <a class="dropdown-item" href="/employees/view/${sessionUser.username}/">Employee</a>
                    <a class="dropdown-item" href="/auth/sign-out/">Sign Out</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
</#macro>

<#macro validation_errors>
    <#if validation??>
        <#list validation.errors as error>
            <div class="validation-message">${error}</div>
        </#list>
    </#if>
</#macro>

<#macro footer>
    <footer>
        <div class="container">
            <hr>
            <div class="row">
                <div class="col col-lg-4">
                </div>
                <div class="col col-lg-4">
                    <center><p>&copy; 2017 - KennUWare Corp.</p></center>
                </div>
                <div class="col col-lg-4">
                </div>
            </div>
        </div>
    </footer>
</#macro>