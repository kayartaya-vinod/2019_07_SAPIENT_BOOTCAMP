// a basic example of express middleware to handle HTTP client requests

const express = require('express'); // 3rd party modules, found in node_modules
const process = require('process');
const path = require('path');
const service = require('./services/mongodb-contact-service');

const app = express(); // equivalent of http.server
const port = process.env.PORT || 4000

// app.use --> uses a middleware that processes the incoming request before
// reaching the intended resource.
const webroot = path.join(__dirname, 'www');
app.use(express.static(webroot));

// map http GET request for the url '/api/contacts/' to respond with JSON 
// representation of contacts using the mongodb-contacts-service
const baseUrl = '/api/contacts/';
app.get(baseUrl, (req, resp) => {
    service.getAllContacts()
        .then(data => resp.json(data));
});

app.listen(port, () => console.log(`server started at http://localhost:${port}`))