const fs = require('fs');
const path = require('path');

const filename = path.join(__dirname, 'names.txt');

const names = `Vinod
Shyam
John Doe
Jane Doe
`;

const options = {
    flag: 'a'
};
fs.writeFile(filename, names, options, (err) => {
    if(err) {
        throw err;
    }
    console.log('Names were written to the file.');
});
console.log('End of script!');