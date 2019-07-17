const fs = require('fs'); // core module (file system operations)
const path = require('path'); // core module (path operations)

const filename = path.join(__dirname, '..', 'Day07', 'ex01.js');
// console.log('filename is', filename);

if(fs.existsSync(filename)) {
    console.log('File exists')
    // reading synchronously
    const content = fs.readFileSync(filename, 'utf-8')
    console.log(content)
}
else {
    console.log('Filename is invalid')
}