import React, { Component } from 'react';
import ReactDOM from 'react-dom'
import AppHeader from './components/AppHeader'
// React must be imported if you are using JSX

import 'jquery';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import ContactList from './components/ContactList';
import ContactForm from './components/ContactForm';

var baseUrl = 'http://localhost:4000/api/contacts/';

// A component created using a funciton is called stateless component
// A component created using a class is called stateful component
class App extends Component {

    state = { contacts: [], editingContact: {}, isEditing: false }

    constructor() {
        super(); // must invoke superclass constructor
        this.deleteContact = this.deleteContact.bind(this);
    }

    editContact = (editingContact) => {
        this.setState({isEditing: true, editingContact});
        console.log('editing contact for', editingContact)
    }

    addContact = (contact) => {
        const options = {
            method: 'POST',
            body: JSON.stringify(contact),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch(baseUrl, options)
            .then(resp => resp.json())
            .then(data => {
                let contacts = [data, ...this.state.contacts];
                this.setState({ contacts });
            });
    }

    // deleteContact function 
    deleteContact(id) {
        // Intentionally written as regular (not arrow) function.
        // Must be bound with the current object (instanceof App).
        // Refer the constructor.

        fetch(baseUrl + id, { method: 'DELETE' })
            .then(() => {
                const contacts = [...this.state.contacts]; // shallow copy
                const index = contacts.findIndex(c => c._id === id);
                contacts.splice(index, 1);
                this.setState({ contacts });
            })
            .catch(err => console.error(err));


    }

    componentDidMount() {
        // this is a lifecycle function of a stateful component
        // which gets executed after the component is mounted on the UI
        // after the first render, which generally is used for making
        // ajax calls to get data and call the setState method

        fetch(baseUrl)
            .then(resp => resp.json())
            .then(data => {
                data.sort((c1, c2) => c2._id - c1._id);
                this.setState({ contacts: data })
            })
            .catch(err => console.log(err));
    }

    render() {
        return <div>
            <AppHeader title="Phonebook App - V1.0" />
            <div className="container">
                {/* .row>.col-md-3+.col */}
                <div className="row">
                    <div className="col-md-3">
                        <ContactForm
                            isEditing={this.state.isEditing}
                            editingContact={this.state.editingContact}
                            addContact={this.addContact} />
                    </div>
                    <div className="col">
                        <ContactList
                            editContact = {this.editContact}
                            data={this.state.contacts}
                            deleteContact={this.deleteContact} />

                    </div>
                </div>
            </div>
        </div>;
    }
}

ReactDOM.render(<App />, document.getElementById('root'));
