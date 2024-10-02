var message = "Hello, World";
console.log(message);
var person = {
    firstName: "Nazi",
    //lastName: "Doh",
    height: 5,
    //weight: 155,
    age: 2,
    run: function () {
    },
    eat: function () {
        throw new Error("Function not implemented.");
    }
};
var Animal = /** @class */ (function () {
    function Animal(name, age, dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
    }
    Animal.prototype.getName = function () {
        return this.name;
    };
    Animal.prototype.setName = function (name) {
        this.name = name;
    };
    Animal.prototype.getAge = function () {
        return this.age;
    };
    Animal.prototype.setAge = function () {
        this.age = (new Date().getFullYear() - this.dob.getFullYear());
    };
    Animal.prototype.getDob = function () {
        return this.dob.getDate();
    };
    Animal.prototype.setDob = function (dob) {
        this.dob = dob;
    };
    return Animal;
}());
var hamster = new Animal("Tali", 5, new Date("03-21-2021"));
console.table(hamster);
hamster.setAge();
console.table(hamster);
function identity(person) {
    return person.firstName;
}
console.log(identity(person));
