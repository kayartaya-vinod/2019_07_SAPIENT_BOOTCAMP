import React, { Component } from 'react';
import ReactDOM from 'react-dom';

import 'bootstrap/dist/css/bootstrap.css';
import './CalculatorApp.css';

class CalculatorApp extends Component {
    state = { results: [] };

    doCalculation = (operator) => {
        let { num1, num2 } = this.refs;
        let n1 = num1.value;
        let n2 = num2.value;

        if (!n1 || !n2) return;

        let result = undefined;
        n1 = parseFloat(n1);
        n2 = parseFloat(n2);
        switch (operator) {
            case '+':
                result = `${n1} + ${n2} = ${n1 + n2}`;
                break;
            case '-':
                result = `${n1} - ${n2} = ${n1 - n2}`;
                break;
            case '*':
                result = `${n1} * ${n2} = ${n1 * n2}`;
                break;
            case '/':
                result = `${n1} / ${n2} = ${n1 / n2}`;
                break;
            case '%':
                result = `${n1} % ${n2} = ${n1 % n2}`;
                break;
            case '^':
                result = `${n1} ^ ${n2} = ${Math.pow(n1, n2)}`;
                break;
            default:
        }
        if (result) {
            this.setState({ results: [result, ...this.state.results] });
        }
    }

    deleteResult = (index) => {
        let { results } = this.state;
        results.splice(index, 1);
        this.setState({ results });
    }

    clearResults = () => {
        this.setState({ results: [] });
    }
    render() {
        let results;

        results = this.state.results.map((r, i) => (
        <div key={i} className="list-group-item">
            {r} &nbsp;
                <span className="clickable pull-right" role="img" aria-label="delete"
                onClick={() => this.deleteResult(i)}>&#10060;</span>
        </div>))

        return (
            <div>
                <h1 className="alert alert-primary text-center">Calculator App</h1>
                <div className="row">
                    <div className="col"></div>
                    <div className="col">
                        <input type="number" autoFocus placeholder="enter number 1" ref="num1" className="form-control" />
                        <br />
                        <input type="number" placeholder="enter number 2" ref="num2" className="form-control" />
                        <br />
                        <div className="row">
                            <button onClick={() => this.doCalculation('+')} className="col btn btn-info">+</button>
                            <button onClick={() => this.doCalculation('-')} className="col btn btn-info">-</button>
                            <button onClick={() => this.doCalculation('*')} className="col btn btn-info">*</button>
                            <button onClick={() => this.doCalculation('/')} className="col btn btn-info">/</button>
                            <button onClick={() => this.doCalculation('%')} className="col btn btn-info">%</button>
                            <button onClick={() => this.doCalculation('^')} className="col btn btn-info">^</button>
                        </div>

                        <button className="btn btn-link text-danger"
                            onClick={this.clearResults}>Clear all results</button>
                        <br />
                        <ul className="list-group">
                            {results}
                        </ul>
                    </div>
                    <div className="col"></div>
                </div>
            </div>
        );
    }
}

ReactDOM.render(<CalculatorApp />, document.getElementById('root'));