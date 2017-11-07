<#import "lib/utils.ftl" as u>

<html>
<title>Welcome to KennUWare</title>
<@u.head/>
<body>
<div class="container" style="padding-top: 50px">
    <h2>Please choose a Silo</h2>


    <div class="container">
        <div class="row">
            <A class="btn btn-warning btn-lg btn-responsive col-4 center-block" style="height: 200px; padding-top: 100px" role="button"  href="/employees">Human Resources</A>
            <A class="btn btn-primary btn-lg btn-responsive col-4 center-block" style="height: 200px; padding-top: 100px" role="button"  href="http://sales.kennuware.com">Sales</A>
            <A class="btn btn-secondary btn-lg btn-responsive col-4 text-center" style="height: 200px; padding-top: 100px" role="button"  href="http://inventory.kennuware.com">Inventory</A>
        </div>
        <div class="row" style="padding-top: 50px">
            <A class="btn btn-info btn-lg btn-responsive col-4 text-center" style="height:200px; padding-top: 100px" role="button"  href="http://accounting.kennuware.com">Accounting</A>
            <A class="btn btn-success btn-lg btn-responsive col-4 text-center" style="height:200px; padding-top: 100px"  role="button"  href="http://manufacturing.kennuware.com">Manufacturing</A>
            <A class="btn btn-danger btn-lg btn-responsive col-4 text-center" style="height: 200px; padding-top: 100px" role="button"  href="http://support.kennuware.com">Customer Support</A>
        </div>
    </div>



</div>
</body>
</html>