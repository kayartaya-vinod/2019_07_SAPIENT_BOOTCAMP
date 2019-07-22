import React, { Component } from 'react';
import './App.css';
import AppHeader from './components/AppHeader';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';
const baseUrl = 'http://localhost:5000/api/todos/';

class App extends Component {

  state = { todos: [] };

  async componentDidMount() {
    const resp = await fetch(baseUrl);
    const todos = await resp.json();
    this.setState({ todos });
  }

  addTodo = async (todoText) => {
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ 'text': todoText })
    };
    const resp = await fetch(baseUrl, options);
    const todo = await resp.json();
    this.setState({ todos: [...this.state.todos, todo] });
  }
  updateTodo = async (todo) => {
    const options = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(todo)
    };
    const resp = await fetch(baseUrl, options);
    const updatedTodo = await resp.json();
    let { todos } = this.state;
    let index = todos.findIndex(t => t._id === updatedTodo._id);
    todos[index] = updatedTodo;
    this.setState({ todos });
  }

  render() {
    return (
      <div className="row">
        <div className="col-md-2"></div>
        <div className="col">
          <br /><br />
          <AppHeader />
          <br />
          <TodoForm addTodo={this.addTodo} />
          <br />
          <TodoList todos={this.state.todos} updateTodo={this.updateTodo} />
        </div>
        <div className="col-md-2"></div>
      </div>
    );
  }
}

export default App;
