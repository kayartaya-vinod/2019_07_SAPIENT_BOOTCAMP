import React, { Component } from 'react';
import { render } from 'react-dom';

class EventDemoApp extends Component {

    state = {}

    testFn = (x) => {
        console.log('testFn was called with argument', x);
        return ()=> {
            console.log('this is from another function at', new Date())
        }
    }

    render() {
        return (
            <div>
                <h1>Events demo</h1>
                <button onClick={this.testFn}>Call the testFn function</button>
                <button onClick={this.testFn('vinod')} >Call testFn with custom argument</button>
                <button onClick={() => this.testFn(Math.random())} >Call testFn with custom argument</button>
            </div>
        );
    }
}

render(<EventDemoApp />, document.getElementById('root'));