import React, { Component } from 'react';
import './ChatItem.css'
import Chip from 'react-md/lib/Chips'
import MenuButton from 'react-md/lib/Menus/MenuButton'
import ListItem from 'react-md/lib/Lists/ListItem'

class ChatItem extends Component {
    render(){
        return (
            <div id="chat-item">
                <div id="question">Question</div>

                <MenuButton
                    id="vert-menu"
                    icon
                    buttonChildren="more_vert"
                    className="menu-example"
                    tooltipLabel="Open some menu"
                >
                    <ListItem primaryText="Item One" />
                    <ListItem primaryText="Item Two" />
                    <ListItem primaryText="Item Three" />
                    <ListItem primaryText="Item Four" />
                </MenuButton>                <div>Last Message</div>
                <Chip label="#hashtag" />
                <div>Last time message sent</div>
            </div>
        )
    }
}

export default ChatItem;