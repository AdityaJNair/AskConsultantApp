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
                <a className="chat-avatar" href="#"><Avatar random>J</Avatar></a>
                <ul>
                    <li>Primary Text</li>
                    <li>Secondary Text</li>
                    <li>Timestamp</li>
                </ul>
                <Chip className="chat-item-hashtags" label="#hashtag" />
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
            </div>
        )
    }
}

export default ChatItem;