const fs = require('fs');
const path = require('path');

const filename = path.join(__dirname, '..', 'Day07', 'ex01.js');

// deprecated function; use fs.stat() or fs.access() instead
fs.exists(filename, (exists) => {
    if (exists) {
        console.log('File exists')
        console.log('Before calling fs.readFile(...)')
        fs.readFile(filename, 'utf-8', (err, data) => {
            if (err) throw err;
            console.log(data);
        });
        console.log('After calling fs.readFile(...)')
    }
    else {
        console.log('File does not exist!');
    }
});