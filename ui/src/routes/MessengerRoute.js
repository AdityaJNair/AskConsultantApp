import React from 'react'
import { Route, Redirect } from 'react-router-dom'
import { connect } from 'react-redux'

class MessengerRoute extends React.Component {
    render() {
        const {component: Component, pending, logged, ...rest } = this.props
        return (
            <Route {...rest} render={props => {
                if (pending) {
                    return <div>Loading</div>
                }
                return logged
                // if the user does not login,redirect to index.
                // if the user has logged in, display the authorized page
                    ? <Component {...props}/>
                    : <Redirect to='/'/>

            }} />
        )
    }
}

const mapStateToProps = ({loginInfo}) => ({
    pending: loginInfo.pending,
    
    logged: loginInfo.token !== ''
})

export default connect(mapStateToProps)(MessengerRoute)