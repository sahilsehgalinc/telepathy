<%-- 
  - Author(s): Platform Z
  - Date: 09/19/2016
  - Copyright Notice: Platform Z
  - @(#)
  - Description: This is for Login as role based (Teacher,Super Hero,Parent,Principal)
  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>Login</title>
<link rel="icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/NewStyles/images/favicon.ico">
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/NewStyles/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/NewStyles/css/daisynav.css">
<link id="style_components" rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/NewStyles/css/components.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/NewStyles/css/bootstrap.min.css">
	 <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	 <%-- <link href="<%=request.getContextPath()%>/NewStyles/css/style.css" rel="stylesheet"> --%>
    <link href="<%=request.getContextPath()%>/NewStyles/css/the-styles.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/NewStyles/css/inner-pages-style.css" rel="stylesheet">
    <link rel="stylesheet"
	href="<%=request.getContextPath()%>/NewStyles/css/jquery.fancybox.css?v=2.1.5"
	type="text/css" media="screen" />
	 
	<%-- <link href="<%=request.getContextPath()%>/NewStyles/css/index.css" rel="stylesheet"> --%>
	
	<style>
	.help-block{
	color: #a94442 !important;
	margin-top:0px !important;
	}
	</style>
</head>

<body class="img_full">
	 <nav class="navbar navbar-default navbar-fixed-top navbar-transparent">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand ie-logo" href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath()%>/NewStyles/images/ie-logo.png"></a>
        </div>
        <!-- <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Default</a></li>
            <li><a href="../navbar-static-top/">Static top</a></li>
            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
          </ul>
        </div> -->

        <!--/.nav-collapse -->
      </div>
    </nav>
		 <section class="center_section">
		  <div class="container-fluid">
        <div cass="row">
            <div class="col-md-4 col-md-offset-4"> 
             <div class="col-md-12 pull-left mB60 text-center">

                    <div class="col-md-6 text-right"> <a href="<%=request.getContextPath()%>/loginNew" class="btn btn_with_shadow">LOGIN</a><!-- <a href="#!" class="btn_with_shadow">LOGIN</a> --></div>
                    <div class="col-md-6 text-left"><a href="<%=request.getContextPath()%>/signupUser" class="btn btn_with_shadow">START JOURNEY</a><!-- <a href="#!" class="btn_with_shadow">START JOURNEY</a> --></div>
                </div> 
			<form name='f' id="f" class="login_form pull-left col-md-10 col-md-offset-1"
				action="<c:url value='j_spring_security_check'/>" method='POST'>
				<div class="containerSmall">
					<!-- <div class="pracProgress_hdr">
						<h2>Login</h2>
						<div class="green_line_btm"></div>
					</div>
					<div class="clr"></div> -->
					<div class="Login-wrap">
						<div class="Login-inner">
							<div class="loginTop">
								<c:if test="${not empty param.error}">
									<div class="loginTopLeft">
										<label>&nbsp;</label>
									</div>
									<div class="loginTopRight">
										<div style="color: #a94442;" id="loginError">
											<span>Email or Password is incorrect.</span>
										</div>
									</div>
								</c:if>
								<%
									session.removeAttribute("error");
								%>
								<c:if test="${forgotRequest}">
									<div class="loginTopLeft">
										<label>&nbsp;</label>
									</div>
									<div class="loginTopRight">
										<div style="color: #02a451;" id="loginError">
											<span>An email has been sent to the email address you
												provided with a link to reset your password.</span>
										</div>
									</div>
								</c:if>
								<%
									session.removeAttribute("forgotRequest");
								%>
							</div>
							<div class="loginTop">
								<!-- <div class="form-group">
									<label>Email</label>
								</div> -->
								<!-- <div class="loginTopRight">
									<div class="contact-row">
										<div class="outer-field-wrap"> -->
											 <div class="form-group">
												<input type="text" placeholder="Email" id="username"
													name="username" class="form-control custom_input_field"> <input type="hidden"
													name="j_username" id="email">
											</div>
										<!-- </div>
									</div>
								</div> -->
							</div>
							<div class="loginTop">
								<!-- <div class="loginTopLeft">
									<label>Password</label>
								</div> -->
								<!-- <div class="loginTopRight">
									<div class="contact-row">
										<div class="outer-field-wrap"> -->
											<div class="form-group">
												<input type="password" placeholder="Password" id="password"
													name="password" class="form-control custom_input_field"> <input type="hidden"
													name="j_password" id="j_password">
											</div>
										<!-- </div>
									</div>
								</div> -->
							</div>
							<%-- <div class="loginTop">
								<div class="loginTopLeft">&nbsp;</div>
								<div class="loginTopRight">
									<label> <input type="checkbox"
										name="_spring_security_remember_me" id="remember">
										Remember Me
									</label> <a href="<%=request.getContextPath()%>/forgotpassword"
										title="Forgot Password?">Forgot Password?</a>
								</div>
							</div> --%>
							
							 <div class="form-group row">
                          <div class="col-sm-6">
                            <div class="form-check">
                              <label class="form-check-label custom_chk_box_pR">
                                <input class="form-check-input" type="checkbox" name="_spring_security_remember_me" id="remember"> Remember Me
                              </label>
                            </div>
                          </div>
                          <div class="col-sm-6 text-right">
                            <a href="<%=request.getContextPath()%>/forgotpassword"
										title="Forgot Password?" class="forgot_link">Forgot Password?</a>
                          </div>
                        </div>

						<!-- 	<div class="loginTop mtop20">
								<div class="loginTopLeft">&nbsp;</div> -->
								<div class="col-md-12 text-center">
									<input type="button" onclick="checkRole();readCookie();"
										class="submit-btn fl btn btn_with_shadow" value="LOGIN" id="loginButton">
										<%-- <a class="btnstart" style="max-width: none;color: white;text-transform: uppercase;text-decoration: none; font-size:15px;" href="<%=request.getContextPath()%>/get-started"
										>Get Started</a> --%>
								</div>
							<!-- </div> -->
							<script type="text/javascript">
                    			function readCookie(){
		                     		var email = $('#username').val();
		                    		if ($('#remember').is(':checked')) {
		                    			localStorage.usrname = $('#username').val();
		                                localStorage.pass = $('#password').val();
		                                localStorage.chkbx = $('#remember').val();
		                    		}
                    			}
                    
                    	</script>
						</div>
					</div>
				</div>
			</form>
			</div>
			</div>
			</div>
		</section>
	

	<div id="roleCheck" style="display: none;" class="wrapper">
		<div class="pracProgress_hdr">
			<h2>Choose Role</h2>
			<div class="green_line_btm"></div>
			<div class="clr"></div>
		</div>
		<div class="check-select-out-new">
			<div class="check-select background-none full-width margin-top-ten">
				<ul id="multipleUserLogin">
				</ul>
			</div>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/NewStyles/js/jquery.min.js"
		type="text/javascript"></script>
		<script
		src="<%=request.getContextPath()%>/NewStyles/js/bootstrap.min.js"></script>
		

<script type="text/javascript"
	src="<%=request.getContextPath()%>/NewStyles/js/jquery.fancybox.pack.js?v=2.1.5"></script>
	<%-- <%@include file="footer.jsp"%> --%>
	<script
		src="<%=request.getContextPath()%>/NewStyles/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/NewStyles/js/jquery.daisynav.min.js"></script>
	<script type="text/javascript">	
	jQuery(document).ready
	(function($){
		$("#username").focus();
		 $("#login").click(function(e) {
		        $(".login_panel").toggle();
		        e.stopPropagation();
		    });

		    $(document).click(function(e) {
		        if (!$(e.target).is('.login_panel, .login_panel *')) {
		            $(".login_panel").hide();
		        }
		    });
		
		 if (localStorage.chkbx && localStorage.chkbx != '') {
	            $('#remember').attr('checked', 'checked');
	            $('#username').val(localStorage.usrname);
	            $('#password').val(localStorage.pass);
	        } else {
	            $('#remember').removeAttr('checked');
	            $('#username').val('');
	            $('#password').val('');
	        }

	        $('#remember').click(function() {

	            if ($('#remember').is(':checked')) {
	                // save username and password
	                localStorage.usrname = $('#username').val();
	                localStorage.pass = $('#password').val();
	                localStorage.chkbx = $('#remember').val();
	            } else {
	                localStorage.usrname = '';
	                localStorage.pass = '';
	                localStorage.chkbx = '';
	            }
	        });
		
		 $('.login_form').validate({
             errorElement: 'span', //default input error message container
             errorClass: 'help-block', // default input error message class
             focusInvalid: false, // do not focus the last invalid input
             ignore: "",
             rules: {
            	 username:{
             		required: true
             	},
             	password:{
             		required: true
             	}
             },

             invalidHandler: function(event, validator) { //display error alert on form submit   
             },

             highlight: function(element) { // hightlight error inputs
                 $(element)
                     .closest('.outer-field').addClass('has-error'); // set error class to the control group
                 $(element)
                     .closest('.fullrow').addClass('has-error'); // set error class to the control group
             },

             success: function(label) {
                 label.closest('.outer-field').removeClass('has-error');
                 label.remove();
             },

             errorPlacement: function(error, element) {
                 if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                     error.insertAfter($('#register_tnc_error'));
                 } else if (element.closest('.input-icon').size() === 1) {
                     error.insertAfter(element.closest('.input-icon'));
                 } else {
                     error.insertAfter(element);
                 }
             },

             submitHandler: function(form) {
                	 form.submit();      	   
             }
         });
		setTimeout(function(){ $("#loginError").remove(); }, 3000);
		$("#eamil").blur(function(event) {
			setTimeout(function(){ jQuery("#loginError").remove(); }, 3000);
		});
		$("#password").blur(function(event) {
			setTimeout(function(){ jQuery("#loginError").remove(); }, 3000);
		}); 
		 
		// Login on Enter key
		$("#password").keypress(function (e) {
		    if (e.which == 13) {
		    	$("#loginButton").click();
		    }
		});
		
	});
</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/NewStyles/js/jquery.flexisel.js"></script>
	<script defer
		src="<%=request.getContextPath()%>/NewStyles/js/jquery.flexslider.js"></script>

	<script type="text/javascript">
    	$("#flexiselDemo3").flexisel({
        visibleItems: 5,
        animationSpeed: 1000,
        autoPlay: true,
        autoPlaySpeed: 3000,            
        pauseOnHover: true,
        enableResponsiveBreakpoints: true,
        responsiveBreakpoints: { 
            portrait: { 
                changePoint:480,
                visibleItems: 1
            }, 
            landscape: { 
                changePoint:640,
                visibleItems: 2
            },
            tablet: { 
                changePoint:768,
                visibleItems: 3
            }
        }
    });
    $(window).load(function(){
		
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });	  
});
	
</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/NewStyles/js/jquery.sticky.js"></script>
	<script>
    $(window).load(function(){
      $("#header").sticky({ topSpacing: 0 });
    });
    
    function checkRole(){
    	var email = $("#username").val();
    	var url='<%=request.getContextPath()%>/checkRoleMultiple';
    	
if($("#f").valid()){
    	$.ajax({
             url:url,
             method:'GET',
             async :false,
             data:{email:email},
             success:function(response){
           	 if(response.modelMap.categories.length==0){
            	 $("#f").submit();
            	 }
            	 else{
            		 var userOptions='';
                	 userOptions+='<ul>';
                	 $.each( response.modelMap.categories, function(index,value) {
                		 var sizeOfArrray = response.modelMap.categories.length;
                		 if(sizeOfArrray>1){
                			 if(value.categoryId==3)
                				 {
                				 userOptions+='<li class="width33 role-select mbtm30">'+
                    			 '<a onclick="submitFormWithRole('+value.categoryId+');" class="hero_role'+value.categoryId+'"></a><p>'+value.schoolName+'</p></li>';
                				 }
                			 else
                				 {
                			 userOptions+='<li class="width33 role-select mbtm30">'+
                			 '<a onclick="submitFormWithRole('+value.categoryId+');" class="hero_role'+value.categoryId+'"></a></li>';
                				 }
                			 
                			  //show dialog
          					 $.fancybox({
          						 'minWidth':600,
          						 'padding':45,
          						 'minHeight':150,
          					     'autoScale': true,
          					     'autoDimensions': true,
          					     'centerOnScroll': true,
          					     'href' : '#roleCheck'
          					  });
          					
          				}else{
          					//submit form
          					if(value.migratedUser=="Y" && value.joinedUser=="NA"){
          						window.location.href="<%=request.getContextPath()%>/newPassword?uid="+ value.userId;
															} else {
																$("#j_password").val($("#password").val());
																$("#email").val($("#username").val());
																$("#f").submit();
															}
														}
													});

									userOptions += '</ul>';
									$("#multipleUserLogin").html(userOptions);
								}
							}
						});
			}
		}

		function submitFormWithRole(roleId) {
			$("#j_password").val($("#password").val());
			$("#email").val($("#username").val() + ";" + roleId);
			$("#f").submit();
		}
	</script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-73908394-1', 'auto');
		ga('require', 'displayfeatures');
		ga('send', 'pageview');
	</script>
</body>
</html>
