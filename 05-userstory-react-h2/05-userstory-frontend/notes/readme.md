# React
Can be used for web apps or native apps

- **react-dom** dependency - Web Apps
- **react-native** dependency - Native Apps

## Scaffolding

### Create App
`$ npx create-react-app <app name>`

### npm Commands
`$ npm start`  
starts dev server on port 3000  

`$ npm run build`  
bundles app into a compressed set of js files for production 
(because it's not efficient to have tons of js files)

`$ npm test`  
starts test runner

## Frameworks
**axios**: Promise based REST client

**react-router-dom**: Routing

**formik**: Forms

### Add framework
`$ npm add axios`

adds the dependencies to package.json

## CSS

### Add Bootstrap
add to App.css:  
`@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);`

# React Components

## Component Lifecylce Methods
`componentDidMount()` - similar to ngOnInit()

`componentDidUpdate()`, `componentWillUnmount()`

![alt](img/react-lifecycle-methods.png)

## Class Components

### JSX
Writing HTML inside a .js file 
without any `createElement()` and/or `appendChild()` methods.  

JSX converts HTML tags into react elements.

JSX is optional and not required to use React but makes it 
easier to write React applications.

#### Babel
- convert JSX to pure JS
- convert JS to lower JS versions

### Stateless Component
Input data that is passed into the component can be accessed 
by `render()` via `this.props`  

```javascript
function App() {
    return (
        <HelloMessage name="Thomas" />
    );
}

class HelloMessage extends React.Component {
    render() {
        return (
            // JSX
            <div>
                Hello {this.props.name}
            </div>
        );
    }
}
```
App.js

### Stateful Components
A component can maintain internal state data 
(accessed via `this.state`). 

When a component’s state data changes, the rendered 
markup will be updated by re-invoking `render()`.

## Function Components
Function instead of Class. Simpler.

```javascript
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
```

# Forms, Themes

### Formik

### React Bootstrap
https://react-bootstrap.github.io/

### Material Design

# Misc

### Untyped method parameters
This is Javascript, not Typescript. Method Parameters
have no types (dynamic type system).

### Access Path Variables
`this.props.match.params.<variable name>`