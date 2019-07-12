import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';

// Every class based component has these important builtin members:
// 1. state --> represents the state (data) maintained by this component 
// 2. props --> represents the data sent by its parent component
// 3. refs  --> repersents references to HTML input elements like Textfields
class StatefulComponentDemo extends Component {

    state = { num: 0 }

    // arrow functions are always bound with the component instance
    incrementNum = () => {
        console.log('Before increment, num is ', this.state.num);
        this.setState({ num: this.state.num + 1 }, ()=>{
            console.log('After increment, num is ', this.state.num);
        });
    }

    // regular function have to be explicitly bound to the component instance
    // <button onClick={this.decrementNum.bind(this)} >...</button>
    decrementNum() {
        console.log('Before decrement, num is ', this.state.num);
        this.setState({ num: this.state.num - 1 }, () => {
            console.log('After decrement, num is ', this.state.num);
        });
    }

    // constructor() {
    //     super();
    // const intervalId = setInterval(() => {
    //     // this.state.num++;
    //     this.setState({ num: this.state.num + 1 });
    //     console.log('this.state.num is', this.state.num);
    // }, 1000);
    // console.log('intervalId', intervalId);
    // }
    render() {
        return (
            <div className="container">
                <h1 className="alert alert-info">{this.props.title}</h1>
                <hr />
                <p>The value of state.num is {this.state.num}</p>
                <button className="btn btn-primary"
                    onClick={this.incrementNum} >Increment</button>
                &nbsp;&nbsp;&nbsp;
                <button className="btn btn-secondary"
                    onClick={this.decrementNum.bind(this)} >Decrement</button>
            </div>
        );
    }
}

ReactDOM.render(<StatefulComponentDemo title="Stateful component demo" />,
    document.getElementById('root'));