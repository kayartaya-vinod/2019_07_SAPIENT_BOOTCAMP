const os = require('os');
const slugify = require('slugify');

console.log('typeof slugify is', typeof slugify)

const str = 'This is an example node.js code by Vinod Kumar (vinod@vinod.co)';
console.log(slugify(str));

console.log('typeof os is', typeof os);
console.log('current os architecture is', os.arch)
// const cpus = os.cpus();
// console.log(cpus)