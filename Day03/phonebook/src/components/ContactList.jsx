import React from 'react';
import ContactCard from './ContactCard';

// this is a stateless component

// A component (stateless or stateful) is re-rendered, whenever
// 1. the state of the stateful component is changed (via setState method)
// 2. the components receives new props from the parent (stateless/stateful)
export default function (props) {

    // convert each contact in the array 'data' into a ContactCard component
    let output = props.data.map((c) => <ContactCard key={c._id}
        data={c} deleteContact={props.deleteContact}
        editContact={props.editContact} />);
    return (
        <div className="row">
            {output}
        </div>

    );
}