// this module's name is the name of this file - 'ex01'

// this function is a local (private) member of this module
function greet(name = 'friend', city = 'your city') {
    console.log(`Hello ${name}, how's weather in ${city}?`);
}

greet();
greet('John');
greet('Vinod', 'Bangalore');

module.exports = greet;