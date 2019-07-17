const { getAllContacts } = require('./services/file-contact-service');


let options = { pageSize: 'asd', pageNum: 2 };

getAllContacts(options, (err, data) => {
    if (err) {
        console.log(err);
    }
    else {
        console.log(data);
    }
});