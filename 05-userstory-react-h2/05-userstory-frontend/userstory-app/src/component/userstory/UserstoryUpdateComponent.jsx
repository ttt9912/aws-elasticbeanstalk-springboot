import React, {Component} from 'react';
import UserstoryDataService from '../../service/UserstoryDataService';
import {ErrorMessage, Field, Form, Formik} from 'formik';
import moment from 'moment'

class UserstoryUpdateComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            username: '',
            description: '',
            targetDate: '',
            isDone: false
        };

        this.submit = this.submit.bind(this);
        this.validate = this.validate.bind(this);
    }

    submit(values) {
        const userstory = {
            id: this.state.id,
            username: values.username,
            description: values.description,
            targetDate: values.targetDate,
            isDone: values.isDone
        };

        console.log(userstory);

        UserstoryDataService.update(userstory).then(
            () => this.props.history.push("/userstories")
        );
    }

    componentDidMount() {
        UserstoryDataService.findById(this.state.id).then(
            response => {
                console.log(response);

                this.setState(
                    {
                        username: response.data.username,
                        description: response.data.description,
                        targetDate: moment(response.data.targetDate).format('YYYY-MM-DD'),
                        isDone: response.data.isDone
                    }
                );

                console.log(this.state);
            }
        );
    }

    validate(values) {
        let errors = {};

        if (!values.description) {
            errors.description = 'Enter a Description';
        } else if (values.description.length < 3) {
            errors.description = 'Enter at least 3 Characters in Description';
        }

        return errors;
    }

    render() {
        const {id, username, description, targetDate, isDone} = this.state;
        console.log('state ' + this.state.targetDate);
        return (
            <div>
                <h3>Update Userstory {id}</h3>
                <div className="container">
                    <Formik initialValues={{username, description, targetDate, isDone}}
                            onSubmit={this.submit}
                            validate={this.validate}
                            validateOnChange={false}
                            validateOnBlur={false}
                            enableReinitialize={true}>
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description"/>
                                    </fieldset>
                                    <ErrorMessage name="description" component="div" className="alert alert-warning"/>
                                    <fieldset className="form-group">
                                        <label>Target Date</label>
                                        <Field className="form-control" type="date" name="targetDate"/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Username</label>
                                        <Field className="form-control" type="text" name="username"/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Done</label>
                                        <Field className="form-control" type="checkbox" name="isDone"/>
                                    </fieldset>

                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>
        )
    }
}

export default UserstoryUpdateComponent