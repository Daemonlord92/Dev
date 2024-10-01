// 1 way of declaring functions
function sayHello() {
    console.log("Hello, World")
}

//2 Arrow Function
const koko = () => {

}

//3 Constructor Function

const multiply = new Function('a', 'b', 'return a * b')

console.log(multiply(3, 5))

//Hoisting

greet()


function greet() {
    console.log("Hello, Selwin")
}

//Anonymous Function

(function  () {
    console.log("I'm an unnamed function")
})()

// function scoped/ Global access
// 
var example1

//block scoped
//not redclarable
let example2

example2 = 1
console.log(example2)
example2 = "Syed"
console.log(example2)


//blocked scoped
// not reassignable
const example3 = "BillyBobJoe"
//example3 = "Joe"


// function Animal() {
//     const speak = "Hello"

//     function getSpeak() {
//         console.log(speak)
//         console.log(example3)
//     }
// }

function add(a, b) {
    return a + b
}

console.log(add(4, "Hello"))

// function fetchData() {
//     fetch("https://rickandmortyapi.com/api/character", {
//         method: 'GET'
//     }).then(res => res.json())
//     .then(data => console.table(data.results))
//     .catch(err => console.error(err))
// }
// fetchData()
console.log("hello")

const car = {
    "engine": "V6 Engine",
    "transmission": "Automatic",
    "mileage": 122000,
    "doors": 5,
    "battery": "15v Battery"
}

console.log(car.engine)
console.log(car["engine"])

car.color = "blue"

console.table(car)

delete car.mileage

console.table(car)

function Car(engine, make, model) {
    this.engine = engine
    this.make = make
    this.model = model
    this.start = function() {
        console.log(this.engine + " is started")
    }
}

const car2 = new Car("V8 engine", "Chevy", "Corvette")

console.table(car2)

class Vehicle {
    constructor(engine, make, model) {
        this.engine = engine
        this.make = make
        this.model = model
    }

    start() {
        console.log(this.engine + " is started")
    }
}

const car3 = new Vehicle("HEMI", "Ford", "F150")

console.table(car3)

car3.start()

Vehicle.prototype.stop = function() {
    console.log(this.engine + " has stopped")
}

car3.stop()

class Animal {
    constructor(name) {
        this.name = name
    }

    speak() {
        console.log(this.name + " makes a noise.")
    }
}

class Dog extends Animal {
    speak() {
    console.log(this.name + " barks!")
    }
}

const dog = new Dog("Rime")

dog.speak()

console.log(Object.keys(dog))

console.log(Object.values(dog))

let arr = [10, "hello", {"name":"Mohammad"}]

console.table(arr)

arr.push({"name":"Nikita"})

arr.shift()
console.table(arr)

let name = arr.find((x) => {
    return x.name === "Bob"
})

console.log(name)

arr.forEach((x) => {
    console.log(x)
})

function fetchAnimals() {
    return new Promise((resolve, reject) => {
        console.log("Fetching simple animal data....")

        setTimeout(() => {
            const data = {"name":"Rime", "animalType":"dog", "speak": () => console.log("Rime Barks")}
            if (data) {
                resolve(data)
            } else {
                reject("ANIMAL DATA LOST RUN FOR THE HILLS")
            }
        }, 2000)
    })
}

console.log(fetchAnimals())

fetchAnimals()
    .then(res => {
        console.log(res)
    })
    .catch(err => console.error(err))

