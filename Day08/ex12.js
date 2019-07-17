const { MongoClient } = require('mongodb');
const url = 'mongodb://localhost'; // port defaults to 27017

MongoClient.connect(url, (err, conn) => {
    if (err) throw err;
    const db = conn.db('trainingdb');
    const contacts = db.collection('contacts');
    contacts.findOne((err, c1) => {
        conn.close();
        if (err) throw err;
        console.log(c1);
    })
})