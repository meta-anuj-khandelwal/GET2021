var Parking = /** @class */ (function () {
    function Parking() {
        this.cyclePrices = {
            "daily": 5,
            "monthly": 100,
            "yearly": 500
        };
        this.motorcyclePrices = {
            "daily": 10,
            "monthly": 200,
            "yearly": 1000
        };
        this.fourwheelerPrices = {
            "daily": 20,
            "monthly": 500,
            "yearly": 3500
        };
    }
    Parking.prototype.print = function () {
        console.log(this.cyclePrices.daily);
    };
    return Parking;
}());
