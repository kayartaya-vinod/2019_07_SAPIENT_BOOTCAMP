// module: services/file-contact-service
const fs = require('fs');
const path = require('path');
const filename = path.join(__dirname, 'contacts.json');

let data = [];
if (fs.existsSync(filename)) {
    data = JSON.parse(fs.readFileSync(filename, 'utf8'));
}

const requiredFields = ['firstname', 'email', 'phone', 'city'];

class ContactService {

    constructor() {
    }

    getContactById(id, callbackFn) {
        // throw an error only for callbackFn
        // all other communication is done via callbackFn
    }

    deleteContact(id, callbackFn) {
        // throw an error only for callbackFn
        // all other communication is done via callbackFn
    }

    updateContact(contact, callbackFn) {
        // contact must have all the required fields and 'id' field as well
    }

    // our asynchronous function
    getAllContacts(options, callbackFn) {
        if (!callbackFn || typeof callbackFn !== 'function') {
            throw new Error('callbackFn was not supplied or was not a function!');
        }

        setTimeout(() => {
            let { pageNum = 1, pageSize = 10,
                sortBy = 'id', sortOrder = 'asc' } = options;

            if (typeof pageNum !== 'number' || typeof pageSize !== 'number') {
                let err = { code: 1003, message: 'either pageNum or pageSize was not a number' };
                callbackFn(err);
                return;
            }

            let begin = (pageNum - 1) * pageSize;
            let end = begin + pageSize;
            let newData = data.slice(begin, end);
            callbackFn(null, newData);
        }, 0);
    }

    addNewContact(contact, callbackFn) {
        if (!callbackFn || typeof callbackFn !== 'function') {
            throw new Error('callbackFn was not supplied or was not a function!');
        }

        // to make our function as asynchronous from this point forward,
        // we use the setTimeout, builtin asynchronous function with a 
        // delay of 0
        setTimeout(() => {
            if (!contact || typeof contact !== 'object') {
                let err = { code: 1001, message: 'contact was not supplied or was not an object!' };
                callbackFn(err); // first arg to the callback is an error
                return;
            }
            const missingFields = [];
            requiredFields.forEach(f => {
                if (!(f in contact)) {
                    missingFields.push(f);
                }
            });
            if (missingFields.length) {
                let err = { code: 1002, message: 'required fields ' + missingFields.join(', ') + ' missing' }
                callbackFn(err);
                return;
            }

            // generate the id
            if (data.length === 0) {
                contact._id = 1;
            }
            else {
                contact._id = Math.max(...data.map(c => c._id)) + 1;
            }
            // push the contact object to 'data'
            data.push(contact);
            // write the 'data' in JSON format to the file
            fs.writeFile(filename, JSON.stringify(data), (err) => {
                if (err) {
                    callbackFn(err);
                    return;
                }
                callbackFn(null, { ...contact });
            });
        }, 0);
    }
}

module.exports = new ContactService();