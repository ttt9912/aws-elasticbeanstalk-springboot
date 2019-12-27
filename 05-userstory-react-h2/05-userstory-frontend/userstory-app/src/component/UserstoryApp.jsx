import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import UserstoryListComponent from './userstory/UserstoryListComponent';
import UserstoryAddComponent from './userstory/UserstoryAddComponent';
import UserstoryUpdateComponent from './userstory/UserstoryUpdateComponent';

class UserstoryApp extends Component {
    render() {
        return (
            <Router>
                <div>
                    <h1>Userstory Application</h1>
                    <Switch>
                        <Route path="/" exact component={UserstoryListComponent}/>
                        <Route path="/userstories" exact component={UserstoryListComponent}/>
                        <Route path="/userstories/edit/:id" component={UserstoryUpdateComponent}/>
                        <Route path="/userstories/add" component={UserstoryAddComponent}/>
                    </Switch>
                </div>
            </Router>
        )
    }
}

export default UserstoryApp;