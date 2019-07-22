const { MongoClient } = require('mongodb');

const url = 'mongodb://localhost';

module.exports.getAllTodos = async () => {
    const conn = await MongoClient.connect(url, { useNewUrlParser: true });
    const db = conn.db('assessment1');
    const todos = db.collection('todos');
    const todoList = await todos.find().toArray();
    conn.close();
    return todoList;
};

module.exports.addTodo = async (todoText) => {
    if (!todoText || typeof todoText !== 'string' || todoText.length < 10) {
        throw 'todo text must be a string of at least 10 letters.';
    }
    const conn = await MongoClient.connect(url, { useNewUrlParser: true });
    const db = conn.db('assessment1');
    const todos = db.collection('todos');
    const todo = { text: todoText, status: 'open', priority: 3 };
    const resp = await todos.insertOne(todo);
    todo._id = resp.insertedId;
    conn.close();
    return todo;
};

module.exports.updateTodo = async (todo) => {
    const conn = await MongoClient.connect(url, { useNewUrlParser: true });
    const db = conn.db('assessment1');
    const todos = db.collection('todos');
    await todos.updateOne({ _id: todo._id }, todo);
    conn.close();
    return todo;
};