// import specific member from the module
// ES6 style
// import {getAllContacts, getContactById} from './services/array-contact-service'

// CommonJS style
const getAllContacts = require('./services/array-contact-service').getAllContacts;
const getContactById = require('./services/array-contact-service').getContactById;

const service = require('./services/array-contact-service');

// service.createNewContact();
// service.updateContact();

// const contacts = getAllContacts(pageNum=4, pageSize=20);
// console.log(contacts)

const c1 = getContactById(101);
console.log(c1);