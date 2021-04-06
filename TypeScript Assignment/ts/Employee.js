var Employee = /** @class */ (function () {
    function Employee() {
    }
    Employee.prototype.validateEmployeeForm = function () {
        var _this = this;
        var allFormFields = document.querySelectorAll(".input-field");
        allFormFields.forEach(function (formField) {
            formField.addEventListener('change', function () {
                var inputField = formField;
                var parent = formField.parentElement;
                var nextInputField = parent.nextElementSibling;
                var inputF = document.getElementById("name-field");
                var userName = inputF.value;
                switch (inputField.id) {
                    case 'name-field':
                        if (_this.isValidName(inputField.value)) {
                            _this.name = inputField.value;
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Hi  " + userName + " ! Can i know your gender";
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Name";
                        }
                        break;
                    case 'gender-field':
                        _this.gender = inputField.value;
                        //show next form field
                        _this.setNextVisible(parent, nextInputField);
                        document.getElementById("user-text").innerHTML = userName + " ! Can i know your email";
                        break;
                    case 'email-field':
                        if (_this.isValidEmail(inputField.value)) {
                            _this.email = inputField.value;
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = userName + " ! please enter password";
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Email";
                        }
                        break;
                    case 'password-field':
                        if (_this.isValidPassword(inputField.value)) {
                            _this.password = inputField.value;
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = userName + " !  please varify password";
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Password";
                        }
                        break;
                    case 'cpassword-field':
                        if (_this.isValidConfirmPassword(inputField.value)) {
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = userName + " ! please enter your mobile number";
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Password Not Match";
                        }
                        break;
                    case 'tel-field':
                        if (_this.isValidTelNumber(inputField.value)) {
                            _this.mobile = inputField.value;
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Thank you " + (userName + " !  Registartion Id : A-102");
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Mobile Number";
                        }
                        break;
                }
            });
        });
        allFormFields[3].addEventListener('input', function () {
            console.log("as");
            var passwordValueField = document.getElementById("password-field");
            var passwordValue = passwordValueField.value;
            if (_this.isValidPassword(passwordValue)) {
                if (passwordValue.length < 10) {
                    passwordValueField.style.border = " solid 2px orange";
                }
                else {
                    passwordValueField.style.border = " solid 2px green";
                }
            }
            else {
                passwordValueField.style.border = " solid 2px red";
            }
        });
    };
    Employee.prototype.setNextVisible = function (parent, nextInputField) {
        parent.classList.add('inactive');
        nextInputField.classList.remove('inactive');
    };
    //function to validate name
    Employee.prototype.isValidName = function (name) {
        var isValid = false;
        name = name.trim();
        var regexTestResult = /^([a-zA-Z ]{2,})$/.test(name);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    //function to validate email
    Employee.prototype.isValidEmail = function (email) {
        var isValid = false;
        var regexTestResult = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    //function to validate password
    Employee.prototype.isValidPassword = function (password) {
        var isValid = false;
        var regexTestResult = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(password);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    //function to validate confirm-password
    Employee.prototype.isValidConfirmPassword = function (confirmPassword) {
        var inputF = document.getElementById("password-field");
        var password = inputF.value;
        var isValid = false;
        var regexTestResult = password == confirmPassword;
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    //function to validate mobile number
    Employee.prototype.isValidTelNumber = function (telNumber) {
        var isValid = false;
        var regexTestResult = /^([0-9]{8,10})$/.test(telNumber);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    return Employee;
}());
var emp = new Employee();
emp.validateEmployeeForm();
