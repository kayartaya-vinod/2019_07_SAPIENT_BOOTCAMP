let p1 = {
    name: 'Vinod',
    email: 'vinod@vinod.co',
    phone: '9731424784',
    city: 'Bangalore'
};

let nums = [10, 20, 30, 40, 50];

let p2 = { ...p1, city: 'Chennai', email: 'vinodkayartaya@publicissapient.com' };

console.log(p1);
console.log(p2);

let [a, b, ...c] = nums; // rest operator
// a = 10, b = 20, c = [30, 40, 50]
console.log('a', a);
console.log('b', b);
console.log('c', c);


let { name: newName, ...p3 } = p1; // rest operator
console.log('newName', newName);
console.log('p3', p3);

// construct a new array using an existing array via spread operator
let newArray = [...nums, 123, 345, 666];
console.log('newArray', newArray);