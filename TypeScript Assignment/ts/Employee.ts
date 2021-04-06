class Employee {

    private name: string;
    private gender: string;
    private email: string;
    private password: string;
    private mobile: string;




    validateEmployeeForm(): void {
        let allFormFields = document.querySelectorAll(".input-field") as NodeListOf<Element>;
        allFormFields.forEach(formField => {
            formField.addEventListener('change', () => {
                let inputField = formField as HTMLInputElement;
                let parent = formField.parentElement as HTMLDivElement;
                let nextInputField = parent.nextElementSibling as HTMLDivElement;


                let inputF = document.getElementById("name-field") as HTMLInputElement;
                let userName: string = inputF.value;

                switch (inputField.id) {
                    case 'name-field':
                        if (this.isValidName(inputField.value)) {

                            this.name = inputField.value;
                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `Hi  ${userName} ! Can i know your gender`;
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Name";
                        }
                        break;

                    case 'gender-field':
                        this.gender = inputField.value;

                        //show next form field
                        this.setNextVisible(parent, nextInputField);
                        document.getElementById("user-text").innerHTML = `${userName} ! Can i know your email`;
                        break;

                    case 'email-field':
                        if (this.isValidEmail(inputField.value)) {
                            this.email = inputField.value;

                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${userName} ! please enter password`;

                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Email";
                        }
                        break;

                    case 'password-field':
                        if (this.isValidPassword(inputField.value)) {
                            this.password = inputField.value;

                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${userName} !  please varify password`;

                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Password";
                        }
                        break;

                    case 'cpassword-field':
                        if (this.isValidConfirmPassword(inputField.value)) {
                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = `${userName} ! please enter your mobile number`;
                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Password Not Match";
                        }
                        break;

                    case 'tel-field':
                        if (this.isValidTelNumber(inputField.value)) {
                            this.mobile = inputField.value;
                            //show next form field
                            this.setNextVisible(parent, nextInputField);
                            document.getElementById("error-text").innerHTML = "";
                            document.getElementById("user-text").innerHTML = "Thank you " + `${userName} !  Registartion Id : A-102`;

                        }
                        else {
                            inputField.style.border = " solid 2px red";
                            document.getElementById("error-text").innerHTML = "Invalid Mobile Number";
                        }
                        break;

                }

            });
        });

        allFormFields[3].addEventListener('input', () => {
            let passwordValueField = document.getElementById("password-field") as HTMLInputElement;
            let passwordValue = passwordValueField.value;
            if (this.isValidPassword(passwordValue)) {
                if (passwordValue.length < 10) {
                    passwordValueField.style.border = " solid 2px orange";
                } else {
                    passwordValueField.style.border = " solid 2px green";
                }
            }
            else {
                passwordValueField.style.border = " solid 2px red";

            }
        });
    }

    setNextVisible(parent: HTMLDivElement, nextInputField: HTMLDivElement): void {
        parent.classList.add('inactive');
        nextInputField.classList.remove('inactive');
    }


    //function to validate name
    isValidName(name: string): boolean {
        let isValid: boolean = false;
        name = name.trim();
        let regexTestResult: boolean = /^([a-zA-Z ]{2,})$/.test(name);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

    //function to validate email

    isValidEmail(email: string): boolean {
        let isValid: boolean = false;
        let regexTestResult: boolean = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

    //function to validate password

    isValidPassword(password: string): boolean {

        let isValid: boolean = false;
        let regexTestResult: boolean = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(password);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

    //function to validate confirm-password

    isValidConfirmPassword(confirmPassword: string): boolean {
        let inputF = document.getElementById("password-field") as HTMLInputElement;

        let password: string = inputF.value;
        let isValid: boolean = false;
        let regexTestResult: boolean = password == confirmPassword;
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }

    //function to validate mobile number

    isValidTelNumber(telNumber: string): boolean {

        let isValid: boolean = false;
        let regexTestResult: boolean = /^([0-9]{8,10})$/.test(telNumber);
        if (regexTestResult) {
            isValid = true;
        }
        return isValid;
    }


}

const emp = new Employee();
emp.validateEmployeeForm();

