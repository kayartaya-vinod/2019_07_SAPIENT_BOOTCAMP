const { addNewContact } = require('./services/file-contact-service');

let c1 = {
    firstname: 'John',
    lastname: 'Doe',
    email: 'johndoe@xmpl.com',
    phone: '5568924333',
    city: 'Dallas',
    state: 'Texas',
    country: 'USA'
};

// addNewContact();
// addNewContact(null, () => { });
// addNewContact({}, () => { });

addNewContact(c1, (err, newContact) => {
    if (err) {
        console.log('Error', err);
    }
    else {
        console.log(newContact);
    }
});