const express = require('express');
const bodyParser = require('body-parser');
const { getAllTodos, addTodo, updateTodo } = require('./services/mongodb-todo-service');

const port = 5000;
const app = express();
app.use(bodyParser.json());

app.use((req, resp, next)=>{
    resp.set('Access-Control-Allow-Origin', '*');
    resp.set('Access-Control-Allow-Headers', '*');
    resp.set('Access-Control-Allow-Methods', 'GET,POST,PUT,DELETE');
    next();
})

app.get('/api/todos', (req, resp) => {
    getAllTodos()
        .then(data => resp.json(data))
        .catch(err => resp.json(err));
});

app.post('/api/todos', (req, resp) => {
    addTodo(req.body.text)
        .then(data => resp.json(data))
        .catch(err => resp.json(err));
});

app.put('/api/todos', (req, resp) => {
    updateTodo(req.body)
        .then(data => resp.json(data))
        .catch(err => resp.json(err));
});


app.listen(port, () => console.log(`server started http://localhost:${port}/api/todos/`));