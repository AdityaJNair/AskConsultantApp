import React, { Component } from 'react';
import './ChatItem.css'

import Avatar from 'react-md/lib/Avatars/Avatar'
import Chip from 'react-md/lib/Chips'
import ListItem from 'react-md/lib/Lists/ListItem'
import MenuButton from 'react-md/lib/Menus/MenuButton'


class ChatItem extends Component {
    render(){
        return (
            <div className="chat-item">
                <MenuButton
                    className="chat-item-menu"
                    icon
                    buttonChildren="more_vert"
                    tooltipLabel="Open some menu"
                >
                    <ListItem primaryText="Item One" />
                    <ListItem primaryText="Item Two" />
                    <ListItem primaryText="Item Three" />
                    <ListItem primaryText="Item Four" />
                </MenuButton>
                <a className="chat-avatar" href="#"><Avatar random>J</Avatar></a>
                <ul>
                    <li className="chat-item-list-item">Primary Text</li>
                    <li className="chat-item-list-item">Secondary Text</li>
                    <li className="chat-item-list-item">Timestamp</li>
                </ul>
                <Chip className="chat-item-hashtags" label="#hashtag" />
            </div>
        )
    }
}

export default ChatItem;