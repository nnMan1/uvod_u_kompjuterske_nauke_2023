function myFunction(element) {
    element +=2
}

const myArray = [
    {
        name: 'Marko',
        surname: 'Markovic'
    },
    {
        name: 'Ana',
        surname: 'Jankovic'
    },
    {
        name: 'Sanja',
        surname: 'Jovanovic'
    },
    {
        name: 'aaa',
        surname: 'bbb'
    }
];

const myArray2 = [1, 2, 3, 4]

myArray.forEach(element => {
    element.name = element.name.replace('aa', 'S')
})

console.log(myArray)



