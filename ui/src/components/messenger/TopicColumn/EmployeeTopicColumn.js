import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields/TextField'
import { ExpansionList, ExpansionPanel } from 'react-md/lib/ExpansionPanels';
import { List, ListItem } from 'react-md/lib/Lists';
import Button from 'react-md/lib/Buttons/Button';

class EmployeeTopicColumn extends Component {
    expandList() {
        var topicList = document.getElementById("topics_a");
        if(topicList.style.display == null){
            topicList.style.display = "none";
        }else{
            topicList.style.display == null;
        }
    };
    render() {
        return (
            <div id="employee_Topic_Column">
                <div id="topic_searchField">
                    <TextField
                        id="searchField"
                        label="Search"
                        lineDirection="center"
                        placeholder="Search term goes here"
                        className="md-cell md-cell--bottom"
                    />
                </div>

                <div id="topics_field">
                    <Button raised label="Topic A" onClick={this.expandList}/>
                    <List id="topics_a" className="md-cell md-paper md-paper--1">
                        <ListItem primaryText="Topic1" />
                        <ListItem primaryText="Topic2" />
                        <ListItem primaryText="Topic3" />
                    </List>
                </div>

            </div>

        );
    }
}


export default EmployeeTopicColumn;