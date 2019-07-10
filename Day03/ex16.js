// template string:
const name = 'Vinod';
const city = 'Bangalore';

const message = `${name} lives in ${city}`;
console.log(message);

// arrow functions:
const greet = (name) => `Hello ${name}, how are you today?`;
console.log('greet function returned', greet('Vinod'));

// practical uses of arrow functions:
const nums = [10, 22, 213, 21, 45, 456, 120, 11, 39, 55];
let searchNum = 456;
let index = nums.findIndex(n => n === searchNum);
console.log(`${searchNum} is found at index ${index}`);

searchNum = 46;
index = nums.findIndex(n => n === searchNum);
console.log(`${searchNum} is found at index ${index}`);

const evenNums = nums.filter(n => n % 2 === 0);
console.log('Even numbers', evenNums);

const numsOver50 = nums.filter(n => n >= 50);
console.log('Numbers >= 50 are', numsOver50);

const squares = nums.map(n => n * n);
console.log(squares);

const names = ['Vinod', 'Shyam', 'John', 'Jane'];
const codes = names.map((n, i) => `${n.toUpperCase().substr(0, 3)}-${i}`);
console.log(codes);

// object destructuring
const p1 = { fullname: 'Vinod Kumar', email: 'vinod@vinod.co', 
    phone: '9731424784', country: 'Bharath' };
// let fullname = p1.fullname;
// let email = p1.email;
// let phone = p1.phone;
let { fullname, email, phone, state } = p1;
console.log('fullname', fullname);
console.log('email', email);
console.log('phone', phone);
console.log('state', state);

function sayHello({ phone, fullname, country='India' }) {
    console.log(`Name = ${fullname}, phone = ${phone}, countr=${country}`);
}
sayHello(p1);