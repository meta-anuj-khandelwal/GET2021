//this let add actionlistner on all input field of vehicle registration form 
//if input field data validated than show next form field

let validateVehicleForm=()=> {
    //fetching all form field.

    let allFormFields = document.querySelectorAll(".vehicle-input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('change', (event) => {
            let inputField = formField;
            let parent = formField.parentElement;

            let nextInputField = parent.nextElementSibling;


            //if user press enter
            if (event.key = 'Enter') {
                switch (inputField.id) {

                    case 'vehicle-company':
                        if (isValidVehicleName(inputField.value)) {
                            //show next form field
                            setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Which vehicle do you have";
                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Name";
                        }
                        break;


                    case 'vehicle-type':
                        setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Vehicle Number";
                        break;

                    case 'vehicle-number':
                        if (isValidVehicleNumber(inputField.value)) {
                            setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Please Enter Employee ID";

                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Number";
                        }
                        break;

                    case 'emp-id':
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Identification Details";
                        break;

                    case 'vehicle-identification':
                        document.getElementById("vehicle-text").innerHTML = "Thank You";
                        setNextVisible(parent, nextInputField);
                        document.getElementById("price-button").classList.remove("inactive");
                        break;

                }

            }
        });
    });

}

//this let add actionlistner on all input field of vehicle registration form 
///if input field data is not as per condition than make bounbry color to red else default
let animatedVehicleForm=()=> {
    let allFormFields = document.querySelectorAll(".vehicle-input-field");
    allFormFields.forEach(formField => {
        formField.addEventListener('input', (event) => {
            let inputField = formField;
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


//let to validate vehicle name
let isValidVehicleName=(name)=> {

    let isValid = false;
    name = name.trim();
    let regexTestResult = /^([a-zA-Z0-9 ]{2,})$/.test(name);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

//let to validate vehicle number
let isValidVehicleNumber=(vehicleNumber) =>{

    let isValid = false;
    vehicleNumber = vehicleNumber.trim();
    let regexTestResult = /^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$/.test(vehicleNumber);
    if (regexTestResult) {
        isValid = true;
    }
    return isValid;
}

animatedVehicleForm();
validateVehicleForm();