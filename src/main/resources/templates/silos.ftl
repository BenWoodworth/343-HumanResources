<#import "lib/utils.ftl" as u>

<html>
<title>Welcome to KennUWare</title>
<@u.head/>
<body>
<div class="container" style="padding-top: 50px">
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
                <A class="btn btn-warning " style="height:200px; width: 300px; padding-top: 100px" role="button"  href="/employees">Human Resources</A>
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
                <A class="btn btn-success" style="height:200px; width: 300px; padding-top: 100px"  href="http://manufacturing.kennuware.com">Manufacturing</A>
            </div>
            <div class="col col-lg-4">
                <A class="btn btn-danger" style="height:200px; width: 300px; padding-top: 100px" role="button"  href="http://support.kennuware.com">Customer Support</A>
            </div>
        </div>
    </div>



</div>
</body>
</html>