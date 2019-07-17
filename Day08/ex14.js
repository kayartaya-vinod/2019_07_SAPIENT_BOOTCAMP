const { getContactById } = require('./services/mongodb-contact-service');

const id = '5d2ef4e90809a383895304b9';

getContactById(id)
    .then(data => console.log(data))
    .catch(err => console.log('error --> ', err));