const { MongoClient } = require('mongodb');
const url = 'mongodb://localhost:27017';

const getOneContact = async () => {
    const conn = await MongoClient.connect(url, { useNewUrlParser: true });
    const db = conn.db('trainingdb');
    const contacts = db.collection('contacts');
    const c1 = await contacts.findOne();
    console.log(c1);
    conn.close();
}

getOneContact()
    .then(() => console.log('Done!'))
    .catch(err => console.log(err));

console.log('End of script!');