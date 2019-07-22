import React, { Component } from 'react';

class Todo extends Component {

    statusChangeHandler = async () => {
        let { status } = this.props.todo;
        let { todo } = this.props;
        if (status === 'open') {
            todo.status = 'closed';
        }
        else {
            todo.status = 'open';
        }
        this.props.updateTodo(todo);
    }

    priorityChangeHandler = async () => {
        let { priority } = this.props.todo;
        let { todo } = this.props;
        switch (priority) {
            case 1: todo.priority = 3; break;
            case 3: todo.priority = 5; break;
            case 5: todo.priority = 1; break;
            default:
        }
        this.props.updateTodo(todo);
    }
    render() {
        let {
            text,
            status
        } = this.props.todo;

        let priority = 'Low', priorityClass = '', statusClass = '';
        switch (this.props.todo.priority) {
            case 1: priorityClass = 'btn-block btn btn-warning'; priority = 'Low'; break;
            case 3: priorityClass = 'btn-block btn btn-success'; priority = 'Medium'; break;
            case 5: priorityClass = 'btn-block btn btn-danger'; priority = 'High'; break;
            default:
        }

        switch (status) {
            case 'open': statusClass = 'btn-block btn btn-primary'; break;
            case 'closed': statusClass = 'btn-block btn btn-danger'; break;
            default:
        }

        return (
            <div className="list-group-item">
                <div className="row">
                    <div className="col-md-8">
                        {text}
                    </div>
                    <div className="col-md-2">
                        <button className={statusClass} onClick={this.statusChangeHandler}>{status}</button>
                    </div>
                    <div className="col-md-2">
                        <button className={priorityClass} onClick={this.priorityChangeHandler}>{priority}</button>
                    </div>
                </div>



            </div>
        );
    }
}

export default Todo;