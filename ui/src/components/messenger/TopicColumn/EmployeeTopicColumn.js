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
                    <ExpansionPanel label="Technology" footer={null}>
                        <p>Strategy(3)</p>
                        <p>Analytics Information(5)</p>
                        <p>System Integration(5)</p>
                    </ExpansionPanel>
                    <ExpansionPanel label="General" footer={null}>
                        <p>others(15)</p>
                    </ExpansionPanel>
                </div>

            </div>

        );
    }
}


export default EmployeeTopicColumn;