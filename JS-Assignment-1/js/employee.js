function validateForm() {
    var allFormFields = document.querySelectorAll(".input-field");
    // /console.log(allFormFields);
    allFormFields.forEach(formField => {
        formField.addEventListener('change', (event) => {
            var inputField = formField;
            var parent = formField.parentElement;
            console.log(parent);
            var nextInputField = parent.nextElementSibling;

            // console.log(inputField.value);
            // console.log(inputField.id);

            if (event.key = 'Enter') {
                switch (inputField.id) {

                    case 'name-field':
                        if (isValidName(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Hi " + document.getElementById("name-field").value + "! Can i know your gender";
                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Name";
                        }
                        // console.log(event.key);
                        break;

                    case 'gender-field':
                        console.log("han");
                        setNextVisible(parent, nextInputField);
                        document.getElementById("user-text").innerHTML = document.getElementById("name-field").value + "! Can i know your email";


                        break;

                    case 'email-field':
                        if (isValidEmail(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = document.getElementById("name-field").value + " please enter password";

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Email";
                        }
                        break;

                    case 'password-field':
                        if (isValidPassword(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = document.getElementById("name-field").value + " please varify password";

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Password";
                        }
                        break;

                    case 'cpassword-field':
                        if (isValidConfirmPassword(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = document.getElementById("name-field").value + " please enter your mobile number";

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Password Not Match";
                        }
                        break;

                    case 'tel-field':
                        if (isValidTelNumber(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Thank you " + document.getElementById("name-field").value +" Registartion Id : A-102";

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Mobile Number";
                        }
                        break;

                }

            }
        });
    });

}



function animatedForm() {
    var allFormFields = document.querySelectorAll(".input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('input', (event) => {
            var inputField = formField;
            switch (inputField.id) {

                case 'name-field':
                    if (isValidName(inputField.value)) {
                      
                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;



                case 'email-field':
                    if (isValidEmail(inputField.value)) {

                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;

                case 'password-field':
                    if (isValidPassword(inputField.value)) {

                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;

                case 'cpassword-field':
                    if (isValidConfirmPassword(inputField.value)) {

                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;

                case 'tel-field':
                    if (isValidTelNumber(inputField.value)) {

                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;
            }


        });
    });






}


function setNextVisible(parent, nextInputField) {
    parent.classList.add('inactive');
    nextInputField.classList.remove('inactive');
}



function isValidName(name) {

    var isValid = false;
    name = name.trim();
    let regexTestResult = /^([a-zA-Z ]{2,})$/.test(name);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

function isValidEmail(email) {

    var isValid = false;
    let regexTestResult = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

function isValidPassword(password) {

    var isValid = false;
    let regexTestResult = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(password);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

function isValidConfirmPassword(confirmPassword) {

    var password = document.getElementById("password-field").value;
    var isValid = false;
    let regexTestResult = password == confirmPassword;
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

function isValidTelNumber(telNumber) {

    var isValid = false;
    let regexTestResult = /^([0-9]{8,10})$/.test(telNumber);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}


validateForm();
animatedForm();