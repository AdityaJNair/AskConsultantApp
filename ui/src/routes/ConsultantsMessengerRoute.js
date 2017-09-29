import React from 'react'
import { Route, Redirect } from 'react-router-dom'
import { connect } from 'react-redux'

class ConsultantsMessengerRoute extends React.Component {
    render () {
        const {component: Component, pending, logged, ...rest } = this.props
        console.log(`ConsultantsMessengerRoute: ${logged}`)
        return (
            <Route {...rest} render={props => {
                if (pending) {
                    return <div>Loading</div>
                }
                return logged
                    ? <Component {...props}/>
                    : <Redirect to='/consultants'/>
            }}>
            </Route>
        )
    }
}

const mapStateToProps = ({loginInfo}) => ({
    pending: loginInfo.pending,
    logged: loginInfo.token !== ''
})

export default connect(mapStateToProps)(ConsultantsMessengerRoute)