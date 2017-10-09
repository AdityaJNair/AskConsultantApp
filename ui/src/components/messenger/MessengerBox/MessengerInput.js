import React, { Component } from 'react';
import Button from 'react-md/lib/Buttons/Button';
import TextField from 'react-md/lib/TextFields';
import './stylesheet/MessengerTextComponent.css'
import './stylesheet/MessageWindow.css'

class MessengerInput extends Component {

    constructor () {
        super()
        this.state = {
            inputValue: '',
            conversationid: ''
        }
    }

    handleInputChange (value) {
        this.setState({
            inputValue: value
        })
    }

    handleSend () {
        if (this.state.inputValue !== '') {
            this.props.sendText(this.props.userid, this.props.conversationid, this.state.inputValue)
        }
        this.setState({
            inputValue: ''
        })
    }

    render () {
        if (this.state.conversationid !== this.props.conversationid) {
            this.setState({
                conversationid: this.props.conversationid,
                inputValue: ''
            })
        }
        return (
            <div id="messenger-text-area">
                <div id="textFieldEnter">
                    <TextField
                        id="helpMultiline"
                        placeholder="Type a message..."
                        rows={1}
                        maxRows={7}
                        fullwidth={false}
                        className="md-cell md-cell--top"
                        value={this.state.inputValue}
                        onChange={this.handleInputChange.bind(this)}
                    />
                    {/*//The first parameter of the onChange function is the value*/}
                </div>
                <div id="buttonsend" onClick={this.handleSend.bind(this)} >
                    <Button Button icon secondary >send</Button>
                </div>
            </div>
        )
    }
}

export default MessengerInput