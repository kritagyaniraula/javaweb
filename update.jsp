<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Update</h2>
					
						<form method="post" action="Update" class="register-form"
							id="register-form">
							
							
							
							<div class="form-group">
								<label for="cemail"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="cemail" id="cemail"
									placeholder="Enter current password" required="required"/>
							</div>
							
							<p><p>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="update Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="update Email" required="required"/>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="update Password" required="required" />
							</div>
							
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="update Contact no" required="required"/>
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Update" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="index.jsp" class="signup-image-link">Back To Dashboard
							</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	
	
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


<script type="text/javascript">


var status = document.getElementById("status").value;
if(status == "failed")
	{
	swal("Sorry","Account Has Failded To Update","failed");
	}
	
if(status == "sucess")
{
swal("Congrats","Account Has Been Updated ","failed");
}

</script>

</body>
</html>