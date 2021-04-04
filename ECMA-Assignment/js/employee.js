//this function add actionlistner on all input field of employee registration form 
//if input field data validated than show next form field
let validateForm = () => {
    //fetching all form field.
    let allFormFields = document.querySelectorAll(".input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('change', (event) => {
            let inputField = formField;
            let parent = formField.parentElement;
            console.log(parent);
            let nextInputField = parent.nextElementSibling;

            //if user press enter
            if (event.key = 'Enter') {
                switch (inputField.id) {

                    case 'name-field':
                        if (isValidName(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `Hi  ${document.getElementById("name-field").value} ! Can i know your gender`;
                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Name";
                        }
                        break;

                    case 'gender-field':
                        //show next form field
                        setNextVisible(parent, nextInputField);
                        document.getElementById("user-text").innerHTML = `${document.getElementById("name-field").value} ! Can i know your email`;
                        break;

                    case 'email-field':
                        if (isValidEmail(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${document.getElementById("name-field").value} ! please enter password`;

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Email";
                        }
                        break;

                    case 'password-field':
                        if (isValidPassword(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${document.getElementById("name-field").value} !  please varify password`;

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Invalid Password";
                        }
                        break;

                    case 'cpassword-field':
                        if (isValidConfirmPassword(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${document.getElementById("name-field").value} ! please enter your mobile number`;

                        }
                        else {
                            document.getElementById("error-text").innerHTML = "Password Not Match";
                        }
                        break;

                    case 'tel-field':
                        if (isValidTelNumber(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Thank you " + `${document.getElementById("name-field").value} !  Registartion Id : A-102`;

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


//this function add actionlistner on all input field of employee registration form 
//if input field data is not as per condition than make bounbry color to red else default
let animatedForm = () => {
    let allFormFields = document.querySelectorAll(".input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('input', (event) => {
            let inputField = formField;
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

//this function hide current form field and next form visible
let setNextVisible = (parent, nextInputField) => {
    parent.classList.add('inactive');
    nextInputField.classList.remove('inactive');
}


//function to validate name
let isValidName = (name) => {

    let isValid = false;
    name = name.trim();
    let regexTestResult = /^([a-zA-Z ]{2,})$/.test(name);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

//function to validate email

let isValidEmail = (email) => {

    let isValid = false;
    let regexTestResult = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

//function to validate password

let isValidPassword = (password) => {

    let isValid = false;
    let regexTestResult = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(password);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

//function to validate confirm-password

let isValidConfirmPassword = (confirmPassword) => {

    let password = document.getElementById("password-field").value;
    let isValid = false;
    let regexTestResult = password == confirmPassword;
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

//function to validate mobile number

let isValidTelNumber=(telNumber)=> {

    let isValid = false;
    let regexTestResult = /^([0-9]{8,10})$/.test(telNumber);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}


validateForm();
animatedForm();