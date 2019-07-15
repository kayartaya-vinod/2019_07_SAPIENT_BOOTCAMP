import React, { Component } from 'react';
import './ContactCard.css';

// a stateful component is a class that 
// must inherit from React.Component class, 
// and must overrider a method called render,
// which must return a JSX
class ContactCard extends Component {

    render() {

        // let name = 'Vinod';
        // let email = 'vinod@vinod.co';
        // let phone = '9731424784';

        let { id,
            firstname,
            lastname,
            email,
            phone,
            picture } = this.props.data;

        return (
            <div className="col-sm-6 col-md-4">
                <div className="card">
                    < img src={picture} className="card-img-top" alt={firstname} />
                    <div className="card-body">
                        <h5 className="card-title">
                            {firstname} {lastname}
                        </h5>
                        <div>
                            <button
                                onClick={() => {
                                    this.props.editContact(this.props.data);
                                }}
                                className="btn btn-link text-primary">&#9998;</button>
                            <button
                                onClick={() => {
                                    if (window.confirm('Are you sure to delete this?')) {
                                        this.props.deleteContact(id);
                                    }
                                }}
                                className="btn btn-link text-danger">&times;</button>
                        </div>
                        <p>{email}</p>
                        <p>{phone}</p>
                    </div>
                </div >
            </div>
        );
    }

}

export default ContactCard;