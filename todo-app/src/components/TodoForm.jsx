import React, { Component } from 'react';

class TodoForm extends Component {

    btnHandler = async (evt) => {
        evt.preventDefault();
        let { tfTodoText } = this.refs;
        if(tfTodoText.value.trim()==='') return;
        
        await this.props.addTodo(tfTodoText.value);
        tfTodoText.value = '';
        tfTodoText.focus();
    };

    render() {
        return (

            <div>
                <form className="form" onSubmit={this.btnHandler}>
                    <div className="row">
                        <div className="col-sm-8">
                            <input type="text" ref="tfTodoText" className="form-control" />
                        </div>
                        <div className="col-sm-4">
                            <button className="btn btn-primary btn-block">
                                Add TODO
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}

export default TodoForm;