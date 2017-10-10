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
            this.props.sendText(this.props.userid, this.props.conversationid, this.state.inputValue, this.props.sentbydisplayname)
            this.setState({
                inputValue: ''
            })
        }

    }

    handleSendWithEnter (event) {
        console.log(`this.props.sentbydisplayname: ${this.props.sentbydisplayname}`)
        let key = event.which || event.keyCode || event.charCode
        // add the function that when the user press the Enter, and "shift Enter" to insert a 
        //  new line. 
        if (key === 13 && this.state.inputValue !== '' && this.state.inputValue !== '\n') {
            if (!event.shiftKey) {
                this.props.sendText(this.props.userid, this.props.conversationid, this.state.inputValue, this.props.sentbydisplayname)
                this.setState({
                    inputValue: ''
                })
            }
        }
        if ( this.state.inputValue === '\n') {
            this.setState({
                inputValue: ''
            })
        }
        event.preventDefault()
    }

    render () {
        // when enter another conversation, the reset the input field.
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
                        onKeyUp={ e => this.handleSendWithEnter(e)}

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