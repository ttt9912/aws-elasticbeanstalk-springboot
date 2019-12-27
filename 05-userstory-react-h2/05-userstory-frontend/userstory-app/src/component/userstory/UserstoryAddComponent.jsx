import React, {Component} from 'react';
import {ErrorMessage, Field, Form, Formik} from 'formik';
import UserstoryDataService from '../../service/UserstoryDataService';

class UserstoryAddComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            description: '',
        };

        this.onSubmit = this.onSubmit.bind(this);
        this.validate = this.validate.bind(this);
    }

    onSubmit(values) {
        const userstory = {
            description: values.description
        };

        UserstoryDataService.create(userstory).then(
            () => this.props.history.push("/userstories")
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
        const description = this.state.description;

        return (
            <div>
                <h3>Add Userstory</h3>
                <div className="container">
                    <Formik initialValues={{description}}
                            onSubmit={this.onSubmit}
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

export default UserstoryAddComponent