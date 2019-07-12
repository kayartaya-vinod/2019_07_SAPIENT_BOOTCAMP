import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';

// 'refs' is a member of a react stateful component only
class RefsDemoApp extends Component {

    state = { message: '' }

    render() {
        return (
            // .container>h1.alert.alert-info{Refs Demo}
            <div className="container">
                <h1 className="alert alert-info">Refs Demo</h1>
                {/* .row>.col*2 */}
                <div className="row">
                    <div className="col">
                        <input type="text" ref="username"
                            className="form-control"
                            placeholder="Enter your name" />
                    </div>
                    <div className="col">
                        <input type="text" ref="city"
                            className="form-control"
                            placeholder="Enter your city" />
                    </div>
                </div>
                <br />
                <button className="btn btn-primary"
                    onClick={() => {
                        // object destructuring
                        let { username, city } = this.refs;
                        let message = `${username.value} lives in ${city.value}`;
                        this.setState({ message });
                        username.value = city.value = '';
                        username.focus();
                    }}>Submit</button>

                <p>{this.state.message}</p>
            </div>
        );
    }
}

ReactDOM.render(<RefsDemoApp />, document.getElementById('root'));