//this let add actionlistner on all input field of vehicle registration form 
//if input field data validated than show next form field
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    Vehicle.prototype.validateVehicleForm = function () {
        //fetching all form field.
        var _this = this;
        var allFormFields = document.querySelectorAll(".vehicle-input-field");
        allFormFields.forEach(function (formField) {
            formField.addEventListener('change', function () {
                var inputField = formField;
                var parent = formField.parentElement;
                var nextInputField = parent.nextElementSibling;
                switch (inputField.id) {
                    case 'vehicle-company':
                        if (_this.isValidVehicleName(inputField.value)) {
                            _this.company = inputField.value;
                            //show next form field
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Which vehicle do you have";
                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Name";
                        }
                        break;
                    case 'vehicle-type':
                        _this.type = inputField.value;
                        _this.setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Vehicle Number";
                        break;
                    case 'vehicle-number':
                        _this.number = inputField.value;
                        if (_this.isValidVehicleNumber(inputField.value)) {
                            _this.setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Please Enter Employee ID";
                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Number";
                        }
                        break;
                    case 'emp-id':
                        _this.empID = inputField.value;
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        _this.setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Identification Details";
                        break;
                    case 'vehicle-identification':
                        _this.identification = inputField.value;
                        document.getElementById("vehicle-text").innerHTML = "Thank You";
                        _this.setNextVisible(parent, nextInputField);
                        document.getElementById("price-button").classList.remove("inactive");
                        break;
                }
            });
        });
    };
    Vehicle.prototype.setNextVisible = function (parent, nextInputField) {
        parent.classList.add('inactive');
        nextInputField.classList.remove('inactive');
    };
    //let to validate vehicle name
    Vehicle.prototype.isValidVehicleName = function (name) {
        var isValid = false;
        name = name.trim();
        var regexTestResult = /^([a-zA-Z0-9 ]{2,})$/.test(name);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    //let to validate vehicle number
    Vehicle.prototype.isValidVehicleNumber = function (vehicleNumber) {
        var isValid = false;
        vehicleNumber = vehicleNumber.trim();
        var regexTestResult = /^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$/.test(vehicleNumber);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    };
    return Vehicle;
}());
var vehicle = new Vehicle();
vehicle.validateVehicleForm();
