// a basic example of express middleware to handle HTTP client requests

const express = require('express'); // 3rd party modules, found in node_modules
const process = require('process');
const path = require('path');
const service = require('./services/mongodb-contact-service');
const bodyParser = require('body-parser');

const app = express(); // equivalent of http.server
const port = 4000

// app.use --> uses a middleware that processes the incoming request before
// reaching the intended resource.
const webroot = path.join(__dirname, 'www');
app.use(express.static(webroot));

// middleware to convert the req.body (POST/PUT/PATCH methods only)
app.use(bodyParser.json());

// a middleware is a function that recieves 3 parameters: request, response, and next
// where use the request, generate a response and invoke the next middleware/hanlder
app.use((req, resp, next) => {
    console.log('reached the CORS middleware...');
    resp.set('Access-Control-Allow-Origin', '*');
    resp.set('Access-Control-Allow-Methods', 'GET,POST,PUT,DELETE');
    resp.set('Access-Control-Allow-Headers', '*');
    next(); // pass the control to the next available middleware/handler
})

// map http GET request for the url '/api/contacts/' to respond with JSON 
// representation of contacts using the mongodb-contacts-service
app.get('/api/contacts/', (req, resp) => {
    service.getAllContacts()
        .then(data => resp.json(data));
});

// handler for HTTP DELETE method
app.delete('/api/contacts/:id', (req, resp) => {
    let id = req.params['id'];
    service.deleteContact(id)
        .then(() => resp.end('Contact deleted successfully!'))
        .catch(() => resp.end('There was an error!'));
});

// npm i body-parser
// const bodyParser = require('body-parser');
// app.use(bodyParser.json());
app.post('/api/contacts/', (req, resp) => {
    service.addNewContact(req.body)
        .then(data => resp.json(data))
        .catch(err => console.log(err));
})

app.listen(port, () => console.log(`server started at http://localhost:${port}`))