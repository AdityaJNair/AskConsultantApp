import React from 'react'
import { Route, Redirect } from 'react-router-dom'
import { connect } from 'react-redux'

class MessageRoute extends React.Component {
    render() {
        const {component: Component, pending, logged, ...rest } = this.props
        return (
            <Route {...rest} render={props => {
                if (pending) {
                    return <div>Loading</div>
                }
                return (logged
                        ? <Component {...props}/>
                        : <Redirect to='/'/>
                )
            }} />
        )
    }
}

const mapStateToProps = ({loginInfo}) => ({
    pending: loginInfo.pending,
    logged: loginInfo.pending !== ''
})

export default connect(mapStateToProps)(MessageRoute)