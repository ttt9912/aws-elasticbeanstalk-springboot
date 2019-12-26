import React from 'react';
import './App.css';

function App() {
    return (
        <HelloMessage name="Thomas"/>
    );
}

function HelloMessage(props) {
    return (
        <div>
            Hello {props.name}
        </div>
    );
}

export default App;
