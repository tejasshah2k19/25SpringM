 <!DOCTYPE html>
<html>
<head>
    <title>New Employee</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center">New Employee Form</h2>
    <form action="saveemp" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" name="firstName" id="firstName" value="${emp.firstName}"  >
            	${result.getFieldError("firstName").getDefaultMessage() }
            	[${emp.firstName}${emp.firstName.length()}]
            </div>
            <div class="form-group col-md-6">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" name="lastName" id="lastName" value="${emp.lastName}" >
            	${result.getFieldError("lastName").getDefaultMessage() }
           
            </div>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" id="email"  >
         	${result.getFieldError("email").getDefaultMessage() }
           
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password"  >
             	${result.getFieldError("password").getDefaultMessage() }
           
            </div>
            <div class="form-group col-md-6">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"  >
             	${result.getFieldError("confirmPassword").getDefaultMessage() }
           
            </div>
           
        </div>

        <div class="form-group">
            <label for="mpin">MPIN (4 digits)</label>
            <input type="text" maxlength="4" class="form-control" name="mpin" id="mpin"    >
         	${result.getFieldError("mpin").getDefaultMessage() }
           
        </div>

        <div class="form-group">
            <label>Gender</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderMale" value="Male"  >
                <label class="form-check-label" for="genderMale">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="Female">
                <label class="form-check-label" for="genderFemale">Female</label>
            </div>
              	${result.getFieldError("gender").getDefaultMessage() }
           
        </div>

        <div class="form-group">
            <label>Hobbies</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="hobby" value="WhatsApp" id="hobbyWhatsapp">
                <label class="form-check-label" for="hobbyWhatsapp">WhatsApp</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="hobby" value="Instagram" id="hobbyInstagram">
                <label class="form-check-label" for="hobbyInstagram">Instagram</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="hobby" value="Twitter" id="hobbyTwitter">
                <label class="form-check-label" for="hobbyTwitter">Twitter</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="hobby" value="Facebook" id="hobbyFacebook">
                <label class="form-check-label" for="hobbyFacebook">Facebook</label>
            </div>
  	${result.getFieldError("hobby").getDefaultMessage() }
           
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <select class="form-control" name="city" id="city"  >
                <option value="">-- Select City --</option>
                <option value="Ahmedabad">Ahmedabad</option>
                <option value="Surat">Surat</option>
                <option value="Rajkot">Rajkot</option>
                <option value="Gandhinagar">Gandhinagar</option>
            </select>
            	${result.getFieldError("city").getDefaultMessage() }
        </div>

        <button type="submit" class="btn btn-primary btn-block">Submit</button>
    </form>
</div>
</body>
</html>
