<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>Log in</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="../css/AdminLTE.css" rel="stylesheet" type="text/css" />
			 <link href="../css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="../css/Validation.css" rel="stylesheet" type="text/css"  />
<style>
.form-control {
    font-size: 13px;
    height: 34px;
    margin-bottom: 5px;
    width: 100%;
}

/* Fix dropdown menu for small screens to display correctly on small screens */
@media screen and (max-width: 767px) {
 
   .form-control{
    width:100%;
	float:none;
	
}

}
@media screen and (max-width: 480px) {
.form-group {
    margin-bottom: 1em;
}
}
</style>
       
    </head>
    <body class="bg-black">
        <div class="form-box" id="login-box">
            <div class="header">Inventory System Login</div>
            <form id="userloginform" action="Authentication.html" method="post">
                <div class="body bg-gray">
               		<s:if test="hasActionErrors()">
					   <div class="errors">
					      <s:actionerror/>
					   </div>
					</s:if>
                    <div class="form-group">
                        <input type="text" name="user.userName" class="form-control" placeholder="User Name"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="user.password" class="form-control" placeholder="Password"/>
                    </div>          
                   
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">Login</button>                     
                </div>
            </form>
        </div>


        <!-- jQuery 2.0.2 -->
       <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		   <script src="../js/bootstrap.min.js" type="text/javascript"></script>
		    <!-- AdminLTE App -->
        <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
       
		 <!-- AdminLTE for demo purposes -->
        <script src="../js/AdminLTE/demo.js" type="text/javascript"></script>
		 <script src="../js/jquery-ui.js" type="text/javascript"></script>       
		 <script type="text/javascript" src="../js/jquery.validate.js"></script>
		  <!-- jQuery UI 1.10.3 -->
        <script src="../js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->      
        <!-- iCheck -->
  		<script type="text/javascript" src="../js/indexvalidation.js"></script>     

    </body>
</html>