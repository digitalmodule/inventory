<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
       <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <link href="../css/jquery-ui.css" rel="stylesheet" type="text/css" />
        <link href="../css/Validation.css" rel="stylesheet" type="text/css"  />
        
        <style type="text/css">
            <!--
            .form-control1 {    width:75%;
                                height:25px;
                                font-size:13px;
                                margin-bottom:5px;
            }
            .form-group1 {   /* margin-bottom: 0px;*/
                margin-top:2px;
            }
            -->
        </style>
    </head>
   
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="#" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Inventory System
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">                                      
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span><s:property value="user.firstName"/>&nbsp;<s:property value="user.lastName"/><i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- Menu Footer-->
                                <li class="user-footer bg-light-blue">                                    
                                    <div class="pull-right">
                                        <a href="../common/Logout.html" class="btn btn-danger">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <!-- div class="pull-left image">
                            <img src="../img/avatar3.png" class="img-circle" alt="User Image" />
                        </div-->
                        <div class="pull-left info">
                            <p>Hello, <s:property value="user.firstName"/>&nbsp;<s:property value="user.lastName"/></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form >
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form-->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="#">
                                <i class="fa fa-dashboard"></i> <span id="inventoryMenuId">Inventory</span>
                            </a>
                        </li>                       
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <!-- Main content -->
                <section class="content" id="contentDivId">

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- add new calendar event modal -->


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
		
            
        <!-- AdminLTE App -->
		  <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../js/jquery-ui.js" type="text/javascript"></script>       
        <script type="text/javascript" src="../js/jquery.validate.js"></script>
		<script type="text/javascript" src="../js/slimScroll/jquery.slimscroll.js"></script>
        <!-- jQuery UI 1.10.3 -->
        
        <script type="text/javascript" src="../js/jquery.livequery.min.js"></script>        <!-- Bootstrap -->      
        <!-- iCheck -->
        <script type="text/javascript" src="../js/jquery.form.js"></script>  
        <script type="text/javascript" src="../js/jquery.UIBlock.js"></script>
        <script type="text/javascript" src="../js/jquery.noty.packaged.min.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
    
        <script type="text/javascript">
            var customerSelectNoty;
            $(document).ready(function()
            {
                $(document).off("click", '#inventoryMenuId').on("click", "#inventoryMenuId", function(e)
                {
                    $("#contentDivId").load("../inventory/LaunchInventory.html");
                });
                $("#inventoryMenuId").trigger("click");
            });
			 $(document).ajaxStart(function() { 
            $.blockUI({ message: '<h1><img src="../img/busy.gif" class="loadingimags" /> Just a moment...</h1>' }); 
            $(document).ajaxStop($.unblockUI);
			 
        });
	
        </script>
    </body>
</html>