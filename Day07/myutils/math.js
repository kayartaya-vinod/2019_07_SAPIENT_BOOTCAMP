// module name relative to Day07 is
// ./myutils/math

// module.exports by default is equals to {}
// to which we can add one or more properties

console.log('this===module.exports is', this === module.exports);
// the above statements prints 'true'
// because of this module.exports.factorial is same as this.factorial

module.exports.AUTHOR_NAME = 'Vinod Kumar';
module.exports.AUTHOR_EMAILS = ['vinod@vinod.co',
    'vinodkumar.kayartaya@publicissapient.com']

module.exports.factorial = (num) => {
    if (num <= 1) return 1;
    else return (num * this.factorial(num - 1));
}

module.exports.square = (num) => num * num;
module.exports.cube = (num) => num * num * num;