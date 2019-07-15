import React, { Component } from 'react';
const defaultValues = {
    id: undefined, dob: '',
    firstname: '', lastname: '', email: '', phone: '',
    address: '', city: 'Bangalore', state: 'Karnataka', country: 'India',
    picture: 'http://www.biswanathcollege.in/images/staff/maleUser.png',
    gender: 'Male'
};

class ContactForm extends Component {

    state = { ...defaultValues, editingDataLoaded: false }

    static getDerivedStateFromProps(props, state) {

        if(state.reset) {
            // happens every time the Reset button is clicked
            return {...defaultValues, reset: false};
        }

        let { isEditing, editingContact } = props;
        if ((isEditing && !state.editingDataLoaded) || (state.id !== editingContact.id)) {
            // first condition ensures that the editingContact becomes the state
            // only once, and the second condition ensures that new data can be 
            // loaded on editing a different contact 
            return { ...editingContact, editingDataLoaded: true };
        }
        else {
            return { ...state }
        }
    }

    resetForm = () => {
        this.setState({ reset: true });
    }

    tfChangeHandler = (evt) => {
        let { name, value } = evt.target;
        this.setState({ [name]: value });
    }

    submitHandler = (evt) => {
        // evt is the event object corresponding to the
        // submit event, fired when (1) you clicked the submit button
        // (2) you pressed enter key on any input elements
        evt.preventDefault(); // do not submit to HTTP SERVER
        this.props.addContact({ ...this.state });
        // clear the form elements by restting the state
        this.setState({ ...defaultValues });


    }
    render() {
        return (
            <div>
                <h5 className="text-center">Add / Update contact details</h5>
                <form onSubmit={this.submitHandler}>

                    <div>
                        <label>
                            <input type="radio" name="gender"
                                checked={this.state.gender === 'Male'}
                                value="Male"
                                onChange={this.tfChangeHandler} /> &nbsp; Male
                        </label>
                        &nbsp;  &nbsp;  &nbsp;
                        <label>
                            <input type="radio" name="gender"
                                value="Female"
                                checked={this.state.gender === 'Female'}
                                onChange={this.tfChangeHandler} /> &nbsp; Female
                        </label>
                    </div>
                    <div>
                        <label htmlFor="firstname">Firstname</label>
                        <input type="text" id="firstname" autoFocus
                            value={this.state.firstname}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="firstname" />
                    </div>

                    <div>
                        <label htmlFor="lastname">Lastname</label>
                        <input type="text" id="lastname"
                            value={this.state.lastname}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="lastname" />
                    </div>

                    <div>
                        <label htmlFor="phone">Phone number</label>
                        <input type="tel" id="phone"
                            value={this.state.phone}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="phone" />
                    </div>

                    <div>
                        <label htmlFor="email">Email address</label>
                        <input type="email" id="email"
                            value={this.state.email}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="email" />
                    </div>

                    <div>
                        <label htmlFor="dob">Date of birth</label>
                        <input type="date" id="dob"
                            value={this.state.dob}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="dob" />
                    </div>

                    <div>
                        <label htmlFor="address">Address</label>
                        <input type="text" id="address"
                            value={this.state.address}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="address" />
                    </div>

                    <div>
                        <label htmlFor="city">City</label>
                        <input type="text" id="city"
                            value={this.state.city}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="city" />
                    </div>

                    <div>
                        <label htmlFor="state">State</label>
                        <input type="text" id="state"
                            value={this.state.state}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="state" />
                    </div>

                    <div>
                        <label htmlFor="country">Country</label>
                        <input type="text" id="country"
                            value={this.state.country}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="country" />
                    </div>

                    <div>
                        <label htmlFor="picture">Picture (URL)</label>
                        <input type="text" id="picture"
                            value={this.state.picture}
                            onChange={this.tfChangeHandler}
                            className="form-control" name="picture" />
                    </div>

                    <br />
                    <button className="btn btn-primary">Save changes</button>
                    <button type="button"
                        style={{marginLeft: '10px'}}
                        onClick={this.resetForm}
                        className="btn btn-secondary">Rest form</button>
                </form>
            </div>

        );
    }
}

export default ContactForm;