function validateVehicleForm() {
    var allFormFields = document.querySelectorAll(".vehicle-input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('change', (event) => {
            var inputField = formField;
            var parent = formField.parentElement;
           
            var nextInputField = parent.nextElementSibling;

            

            if (event.key = 'Enter') {
                switch (inputField.id) {

                    case 'vehicle-company':
                        if (isValidVehicleName(inputField.value)) {
                            
                            setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Which vehicle do you have";
                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Name";
                        }
                        // console.log(event.key);
                        break;


                    case 'vehicle-type':
                        setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        document.getElementById("vehicle-text").innerHTML =   "Please Enter Vehicle Number";
                        break;

                    case 'vehicle-number':
                        if (isValidVehicleNumber(inputField.value)) {
                            console.log("han");
                            setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML =   "Please Enter Employee ID";

                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Number";
                        }
                        break;

                    case 'emp-id':
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-text").innerHTML =   "Please Enter Identification Details";
                        break;

                    case 'vehicle-identification':
                        document.getElementById("vehicle-text").innerHTML =   "Thank You";
                        setNextVisible(parent, nextInputField);
                        document.getElementById("price-button").classList.remove("inactive");
                        break;

                }

            }
        });
    });

}



function animatedVehicleForm() {
    var allFormFields = document.querySelectorAll(".vehicle-input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('input', (event) => {
            var inputField = formField;
            switch (inputField.id) {

                case 'vehicle-company':
                    if (isValidVehicleName(inputField.value)) {
                      
                        inputField.style.border = " solid 2px rgb(10, 65, 216)";
                    }
                    else {
                        inputField.style.border = "solid 2px red";
                    }
                    break;


                case 'vehicle-number':
                    if (isValidVehicleNumber(inputField.value)) {

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



function isValidVehicleName(name) {

    var isValid = false;
    name = name.trim();
    let regexTestResult = /^([a-zA-Z0-9]{2,})$/.test(name);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

function isValidVehicleNumber(vehicleNumber) {

    var isValid = false;
    vehicleNumber = vehicleNumber.trim();
    let regexTestResult = /^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$/.test(vehicleNumber);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

animatedVehicleForm();
validateVehicleForm();