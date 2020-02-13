import React, {useState, useEffect} from 'react';

const Customer=(props)=>{
    // variable to store state of a customer
    const [customer, setCustomer] = useState({});
    useEffect(() => {
        fetch("Customers/1", {
            method: "get",
            headers: new Headers({
                accept: "Application/JSON",
                Authorization: "Basic " + btoa("user:admin")
            })
        })
        .then(function(response) {
            //response is plain encoded text
            if (response.status !== 200) {
                console.log("Looks like there was a problem. Status Code: " + response.status);
                return;
            }
            //convert text to json
            response.json().then(function(data) {
                setCustomer(data);
            });
        })
        .catch(function(err) {
            console.log("Fetch Error : ", err);
        });
    }, []);
    
    return (
        <div>
            <h2>Customer {props.id} data</h2>
            <div>{JSON.stringify(customer)}</div>
            <div>
                <label>First name</label>
                <input type="text" value={customer.firstName}/>
            </div>
        </div>
    )
}

export default Customer;