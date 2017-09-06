import React, { Component } from 'react';
import './stylesheet/ChatItem.css'

import Avatar from 'react-md/lib/Avatars/Avatar'
import Chip from 'react-md/lib/Chips'
import ListItem from 'react-md/lib/Lists/ListItem'
import MenuButton from 'react-md/lib/Menus/MenuButton'


class ChatItem extends Component {
    render(){
        return (
            <div className="chat-item">
                <div id="chatItem_top">
                    <div id = "question_title">
                        <h1>Title</h1>
                    </div>
                    <div id = "question_menu">
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
                </div>


                <div id="chatItem_mid">
                    <div id = "question_content">
                        <p>Question content</p>
                    </div>

                    <div id = "question_timestamp">
                        <p>8:15 04/09/2017</p>
                    </div>
                </div>
                <div id="chatItem_bottom">
                    <div id = "question_hashtag">
                        <Chip className="chat-item-hashtags" label="#hashtag" />
                    </div>
                </div>



            </div>
        )
    }
}
/*
<div id = "avatar">
    <a className="chat-avatar" href="#"><Avatar random>J</Avatar></a>
</div>
<div id = "question_title">
    <h1>Title</h1>
</div>
<div id = "question_menu">
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
    <div id = "question_content">
        <p>Question content</p>

        <div id = "question_timestamp">
            <p>8:15 04/09/2017</p>
        </div>
    </div>

    <div id = "question_hashtag">
    <Chip className="chat-item-hashtags" label="#hashtag" />
    </div>*/
export default ChatItem;