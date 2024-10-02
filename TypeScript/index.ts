let message: string = "Hello, World"

console.log(message)

interface Person {
    firstName: string
    lastName?: string
    height: number
    weight?: number
    age: number
    hair?: string
    run?: () => void
    eat: () => string 
}

const person: Person = {
    firstName: "Nazi",
    //lastName: "Doh",
    height: 5,
    //weight: 155,
    age: 2,
    run: function (): void {
        
    },
    eat: function (): string {
        throw new Error("Function not implemented.")
    }
}

class Animal {
    //Field Variable
    private name: string
    private age: number
    private dob: Date

    constructor(name: string, age:number, dob:Date){
        this.name = name
        this.age = age
        this.dob = dob
    }

    public getName(): string {
        return this.name
    }

    public setName(name: string): void {
        this.name = name
    }

    public getAge(): number {
        return this.age
    }

    public setAge(): void {
        this.age = (new Date().getFullYear() - this.dob.getFullYear())
    }

    public getDob(): number {
        return this.dob.getDate()
    }

    public setDob(dob:Date): void {
        this.dob = dob
    }
}

let hamster = new Animal("Tali", 5, new Date("03-21-2021"))

console.table(hamster)

hamster.setAge()

console.table(hamster)


function identity<T>(person: T):T {
    return person
}


console.log(identity<Person>(person))

identity<Animal>(hamster)