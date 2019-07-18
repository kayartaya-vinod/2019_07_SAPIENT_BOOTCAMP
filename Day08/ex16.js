const { getAllContacts } = require('./services/mongodb-contact-service');

getAllContacts({sortBy: 'city', sortOrder: 'desc'})
    .then(data => console.log(data))
    .catch(err => console.log(err));