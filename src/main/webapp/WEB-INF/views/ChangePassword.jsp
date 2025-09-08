<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
body {
	background-color: #e0f7fa;
	font-family: Arial, sans-serif;
}

.login-container {
	background-color: #fff;
	padding: 25px 30px;
	margin: 80px auto;
	width: 350px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
}

h2 {
	text-align: center;
	color: #333;
}

label {
	display: block;
	margin-top: 15px;
	color: #555;
}

input[type="email"], input[type="password"] ,input[type="text"]{
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #0288d1;
	color: white;
	border: none;
	padding: 10px;
	margin-top: 20px;
	width: 100%;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0277bd;
}
</style>
</head>
<body>

	<div class="login-container">
		${error }
		<h2>Change Password</h2>
		<form action="changepassword" method="post">

			<label for="password">Password:</label> <input type="password"
				name="password" id="password" required> <label for="otp">OTP:</label>
			<input type="text" name="otp" /> <input type="submit" value="Update Password">
		</form>
		<div>
			New User? <a href="signup">Register</a> | Forget Password? <a
				href="forgetpassword">Help!</a>
		</div>
	</div>

</body>
</html>
