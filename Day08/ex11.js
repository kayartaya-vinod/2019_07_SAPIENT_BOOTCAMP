const { MongoClient } = require('mongodb');
const url = 'mongodb://localhost:27017';

MongoClient.connect(url, { useNewUrlParser: true })
    .then(conn => conn.db('trainingdb'))
    .then(db => db.collection('contacts'))
    .then(contacts => contacts.findOne())
    .then(c1 => console.log(c1))
    .catch(err => console.log(err));