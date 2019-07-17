const { addNewContact } = require('./services/mongodb-contact-service');

const c1 = {
    "firstname": "Teresa",
    "lastname": "Purnell",
    "email": "tpurnell0@reuters.com",
    "gender": "Female",
    "phone": "4137421105",
    "address": "80 Aberg Trail",
    "city": "Springfield",
    "state": "Massachusetts",
    "country": "United States",
    "dob": "8/26/1998"
};

addNewContact(c1)
    .then(id => console.log(id))
    .catch(err => console.log(err));