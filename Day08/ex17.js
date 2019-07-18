// a very basic HTTP request handler example
const { createServer } = require('http'); // one of the core modules
const process = require('process');
const fs = require('fs');
const path = require('path');

const server = createServer((req, resp) => {
    console.log('Some client called from address: ' + req.connection.remoteAddress);

    let filename = '404.html';
    switch (req.url) {
        case '/':
        case '/home':
            filename = 'home.html';
            break;
        case '/about':
            filename = 'about.html';
            break;
    }
    filename = path.join(__dirname, 'www', filename);
    fs.readFile(filename, 'utf8', (err, data)=>{
        resp.end(data);
    });
});


const port = process.env.PORT || 4000;
server.listen(port,
    () => console.log(`server started at http://10.150.120.40:${port}`));