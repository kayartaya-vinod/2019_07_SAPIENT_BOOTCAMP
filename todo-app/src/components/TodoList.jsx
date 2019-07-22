import React, { Component } from 'react';
import Todo from './Todo';
class TodoList extends Component {

    render() {
        let { todos } = this.props;
        let todoItems = todos.map(t => <Todo {...this.props} key={t._id} todo={t} />)
        return (
            <ul className="list-group">
                {todoItems}
            </ul>
        );
    }
}

export default TodoList;