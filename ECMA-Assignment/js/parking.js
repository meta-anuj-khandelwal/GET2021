//this function display dailym, monthly and yearly price of selected vehicle 
let displayPrice=()=> {
    //making parking-prices division visible
    document.getElementById("parking-prices").classList.remove("inactive");

    let vehicleTypeField = document.getElementsByName('vehicle-type');

    let selectedVehicle;

    for (index = 0; index < vehicleTypeField.length; index++) {
        if (vehicleTypeField[index].checked)
            selectedVehicle = (vehicleTypeField[index].value);
    }

    const cyclePrices = {
        "daily": 5,
        "monthly": 100,
        "yearly": 500
    };
    const motorcyclePrices = {
        "daily": 10,
        "monthly": 200,
        "yearly": 1000
    };
    const fourwheelerPrices = {
        "daily": 20,
        "monthly": 500,
        "yearly": 3500
    };


    let priceDivisons = document.querySelectorAll(".price");


    let priceSelectedVehicle;
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


    let selectedCurrencyOption = document.getElementsByName('currency');

    let selectedCurrency;
    for (index = 0; index < selectedCurrencyOption.length; index++) {
        if (selectedCurrencyOption[index].checked)
            selectedCurrency = (selectedCurrencyOption[index].value);
    }
    switch (selectedCurrency) {
        case "YEN":
            priceSelectedVehicle = usdToYen(priceSelectedVehicle);
            break;
    }


    for (plan = 0; plan < 3; plan++) {
        priceDivisons[plan].getElementsByTagName("h3")[0].innerHTML = selectedVehicle;

        switch (plan) {
            case 0:
                priceDivisons[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['daily'] + "/day";
                break;
            case 1:
                priceDivisons[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['monthly'] + "/month";
                break;
            case 2:
                priceDivisons[plan].getElementsByClassName("circle")[0].innerHTML = priceSelectedVehicle['yearly'] + "/year";
                break;

        }

    }
}


//this function covert usd price to yen
let usdToYen=(vehiclePrice)=> {
    vehiclePrice['daily'] = 110 * vehiclePrice['daily'];
    vehiclePrice['monthly'] = 110 * vehiclePrice['monthly'];
    vehiclePrice['yearly'] = 110 * vehiclePrice['yearly'];
    return vehiclePrice;
}