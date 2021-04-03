function displayPrice() {
    document.getElementById("parking-prices").classList.remove("inactive");
    var ele = document.getElementsByName('vehicle-type');

    var selectedVehicle;
    console.log(ele);
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked)
            selectedVehicle = (ele[i].value);
    }
    console.log(selectedVehicle);

    cyclePrices = {
        "daily": 5,
        "monthly": 100,
        "yearly": 500
    };
    motorcyclePrices = {
        "daily": 10,
        "monthly": 200,
        "yearly": 1000
    };
    fourwheelerPrices = {
        "daily": 20,
        "monthly": 500,
        "yearly": 3500
    };


    var allFormFields = document.querySelectorAll(".price");


    var priceSelectedVehicle;
    switch (selectedVehicle) {
        case 'Cycle':
            priceSelectedVehicle = cyclePrices;
            break;
        case 'Motor Cycle':
            priceSelectedVehicle = motorcyclePrices;
            break;
        case 'Four Wheeler':
            priceSelectedVehicle = fourwheelerPrices;
            break;
    }


    var element = document.getElementsByName('currency');

    var selectedCurrency;
    for (i = 0; i < element.length; i++) {
        if (element[i].checked)
            selectedCurrency = (element[i].value);
    }
    switch (selectedCurrency) {
        case "YEN":
            priceSelectedVehicle = usdToYen(priceSelectedVehicle);
            break;
    }


    for (plan = 0; plan < 3; plan++) {
        allFormFields[plan].getElementsByTagName("h3")[0].innerHTML = selectedVehicle;

        switch (plan) {
            case 0:
                allFormFields[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['daily'] + "/day";
                break;
            case 1:
                allFormFields[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['monthly'] + "/month";
                break;
            case 2:
                allFormFields[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['yearly'] + "/year";
                break;

        }

    }
}



function usdToYen(vehiclePrice) {
    vehiclePrice['daily'] = 110 * vehiclePrice['daily'];
    vehiclePrice['monthly'] = 110 * vehiclePrice['monthly'];
    vehiclePrice['yearly'] = 110 * vehiclePrice['yearly'];
    return vehiclePrice;
}