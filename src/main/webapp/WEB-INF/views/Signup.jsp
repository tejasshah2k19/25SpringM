<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        .signup-container {
            background-color: #fff;
            padding: 20px 30px;
            margin: 50px auto;
            width: 400px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
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

        input[type="text"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .gender-options {
            margin-top: 5px;
        }

        .gender-options input {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            margin-top: 20px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="signup-container">
    <h2>Signup Form</h2>
    <form action="register" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" required>

        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" required>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required>

        <label>Gender:</label>
        <div class="gender-options">
            <input type="radio" name="gender" value="Male" id="male" required>
            <label for="male">Male</label>

            <input type="radio" name="gender" value="Female" id="female">
            <label for="female">Female</label>

            <input type="radio" name="gender" value="Other" id="other">
            <label for="other">Other</label>
        </div>

        <label for="city">City:</label>
        <select name="city" id="city" required>
            <option value="">-- Select City --</option>
            <option value="Mumbai">Mumbai</option>
            <option value="Delhi">Delhi</option>
            <option value="Bangalore">Bangalore</option>
            <option value="Ahmedabad">Ahmedabad</option>
            <option value="Hyderabad">Hyderabad</option>
        </select>

        <input type="submit" value="Sign Up">
    </form>
</div>

</body>
</html>
