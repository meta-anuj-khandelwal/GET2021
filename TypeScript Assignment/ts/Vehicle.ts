//this let add actionlistner on all input field of vehicle registration form 
//if input field data validated than show next form field
class Vehicle {

    private company: string;
    private type: string;
    private number: string;
    private empID: string;
    private identification: string;


    validateVehicleForm(): void {
        //fetching all form field.

        let allFormFields = document.querySelectorAll(".vehicle-input-field") as NodeListOf<Element>;
        allFormFields.forEach(formField => {
            formField.addEventListener('change', () => {
                let inputField = formField as HTMLInputElement;
                let parent = formField.parentElement as HTMLDivElement;
                let nextInputField = parent.nextElementSibling as HTMLDivElement;
                switch (inputField.id) {

                    case 'vehicle-company':
                        if (this.isValidVehicleName(inputField.value)) {
                            this.company = inputField.value;
                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Which vehicle do you have";

                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Name";
                        }
                        break;


                    case 'vehicle-type':
                        this.type = inputField.value;
                        this.setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Vehicle Number";
                        break;

                    case 'vehicle-number':
                        this.number = inputField.value;
                        if (this.isValidVehicleNumber(inputField.value)) {
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("vehicle-error-text").innerHTML = "";
                            document.getElementById("vehicle-text").innerHTML = "Please Enter Employee ID";


                        }
                        else {
                            document.getElementById("vehicle-error-text").innerHTML = "Invalid Vehicle Number";
                        }
                        break;

                    case 'emp-id':
                        this.empID = inputField.value;
                        document.getElementById("vehicle-error-text").innerHTML = "";
                        this.setNextVisible(parent, nextInputField);
                        document.getElementById("vehicle-text").innerHTML = "Please Enter Identification Details";
                        break;

                    case 'vehicle-identification':
                        this.identification = inputField.value;
                        document.getElementById("vehicle-text").innerHTML = "Thank You";
                        this.setNextVisible(parent, nextInputField);
                        document.getElementById("price-button").classList.remove("inactive");
                        break;

                }

            });
        });

    }

    setNextVisible(parent: HTMLDivElement, nextInputField: HTMLDivElement): void {
        parent.classList.add('inactive');
        nextInputField.classList.remove('inactive');
    }



    //let to validate vehicle name
    isValidVehicleName(name: string): boolean {

        let isValid: boolean = false;
        name = name.trim();
        let regexTestResult: boolean = /^([a-zA-Z0-9 ]{2,})$/.test(name);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

    //let to validate vehicle number
    isValidVehicleNumber(vehicleNumber): boolean {

        let isValid: boolean = false;
        vehicleNumber = vehicleNumber.trim();
        let regexTestResult: boolean = /^[A-Z]{2}\s[0-9]{2}\s[A-Z]{2}\s[0-9]{4}$/.test(vehicleNumber);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

}


const vehicle=new Vehicle();
vehicle.validateVehicleForm();