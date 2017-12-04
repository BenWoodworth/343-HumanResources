<#import "lib/utils.ftl" as u>

<html>

<title>Welcome to KennUWare</title>
<#--<h2 class="text-center">Welcome back, ${sessionUser.username}</h2>-->

<@u.head/>
<body>
<script src="/js/konami.js"></script>
<div class="container" style="padding-top: 50px">
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <p>Some text in the modal.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col" align="left">
                <h4 id="welcome"> Welcome back, ${sessionUser.username}!</h4>
            </div>
            <div class="col" align="right">
                <a type="button" class="btn btn-primary" href="/auth/sign-out">Sign Out</a>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row" style="padding-left: 50 px; padding-right: 50px ">
            <div class="col col-lg-4">
            </div>
            <div class="col col-lg-4">
                <h2>Please choose a Silo</h2>
            </div>
            <div class="col col-lg-4">
            </div>
        </div>
        <div class="row" style="padding-left: 50 px; padding-right: 50px ">
            <div class="col col-lg-4">
                <A class="btn btn-warning " style="height:200px; width: 300px; padding-top: 100px" role="button"  href="/employees/">Human Resources</A>
            </div>
            <div class="col col-lg-4">
                <A class="btn btn-primary" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://sales.kennuware.com">Sales</A>
            </div>

            <div class="col col-lg-4">
                <A class="btn btn-secondary" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://inventory.kennuware.com">Inventory</A>
            </div>
        </div>
        <div class="row" style="padding-top: 50px; padding-left: 50 px; padding-right: 50px">
            <div class="col col-lg-4">
                <A class="btn btn-info " style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://accounting.kennuware.com">Accounting</A>
            </div>
            <div class="col col-lg-4">
                <A class="btn btn-success" style="height:200px; width: 300px; padding-top: 100px"  href="http://manufacturing.kennuware.com:8080">Manufacturing</A>
            </div>
            <div class="col col-lg-4">
                <A class="btn btn-danger" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://support.kennuware.com">Customer Support</A>
            </div>
        </div>
    </div>
</div>
</body>
<@u.footer/>
</html>