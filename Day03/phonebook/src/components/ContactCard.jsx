import React, { Component } from 'react';

// a stateful component is a class that 
// must inherit from React.Component class, 
// and must overrider a method called render,
// which must return a JSX
class ContactCard extends Component {

    render() {

        // let name = 'Vinod';
        // let email = 'vinod@vinod.co';
        // let phone = '9731424784';

        let { firstname,
            lastname,
            email,
            phone,
            picture } = this.props.data;

        return (
            <div className="card" style={{ width: '250px', float: 'left' }}>
                < img src={picture} className="card-img-top" alt={firstname} />
                <div className="card-body">
                    <h5 className="card-title">
                        {firstname} {lastname}
                    </h5>
                    <p>{email}</p>
                    <p>{phone}</p>
                </div>
            </div >
        );
    }

}

export default ContactCard;