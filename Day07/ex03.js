const math = require('./myutils/math');

// console.log(math);
let n = 5;
let f = math.factorial(n);
console.log(`Factorial of ${n} is ${f}`);
console.log(`Square of ${n} is ${math.square(n)}`);
console.log(`Cube of ${n} is ${math.cube(n)}`);
console.log(`Author infor: ${math.AUTHOR_NAME} (${math.AUTHOR_EMAILS})`);

