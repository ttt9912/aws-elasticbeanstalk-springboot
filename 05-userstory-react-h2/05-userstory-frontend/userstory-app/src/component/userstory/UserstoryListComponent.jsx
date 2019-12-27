import React, {Component} from 'react';
import UserstoryDataService from '../../service/UserstoryDataService';

class UserstoryListComponent extends Component {

    constructor(props) {
        super(props);

        // 'state' object - stateful component
        this.state = {
            userstories: [],
            message: null
        };

        // Any method in a react component should be bound to 'this'
        this.refreshUserstories = this.refreshUserstories.bind(this);
        this.deleteUserstory = this.deleteUserstory.bind(this);
        this.updateUserstory = this.updateUserstory.bind(this);
        this.addUserstory = this.addUserstory.bind(this);
    }

    // react lifecycle method
    componentDidMount() {
        this.refreshUserstories();
    }

    refreshUserstories() {
        UserstoryDataService.findAll().then(
            response => {
                console.log(response.data);
                this.setState({userstories: response.data})
            }
        );
    }

    deleteUserstory(id) {
        UserstoryDataService.delete(id).then(
            response => {
                this.setState({message: `Delete of Userstory ${id} Successful`});
                this.refreshUserstories();
            }
        );
    }

    updateUserstory(id) {
        // navigate to '/userstories/:id'
        this.props.history.push(`/userstories/edit/${id}`)
    }

    addUserstory() {
        this.props.history.push(`/userstories/add`);
    }

    render() {
        return (
            <div className="container">
                <h3>All Userstories</h3>
                {
                    this.state.message && <div className="alert alert-success">{this.state.message}</div>
                }
                <table className="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Description</th>
                        <th>targetDate</th>
                        <th>isDone</th>
                        <th/>
                        <th>
                            <button className="btn btn-success"
                                    onClick={this.addUserstory}>Add
                            </button>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.userstories.map(
                            userstory =>
                                <tr key={userstory.id}>
                                    <td>{userstory.id}</td>
                                    <td>{userstory.username}</td>
                                    <td>{userstory.description}</td>
                                    <td>{userstory.targetDate}</td>
                                    <td>{userstory.isDone.toString()}</td>
                                    <td>
                                        <button className="btn btn-success"
                                                onClick={() => this.updateUserstory(userstory.id)}>Update
                                        </button>
                                    </td>
                                    <td>
                                        <button className="btn btn-warning"
                                                onClick={() => this.deleteUserstory(userstory.id)}>Delete
                                        </button>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserstoryListComponent;