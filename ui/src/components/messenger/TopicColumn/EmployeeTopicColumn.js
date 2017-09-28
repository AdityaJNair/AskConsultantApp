import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields/TextField'
import { ExpansionList, ExpansionPanel } from 'react-md/lib/ExpansionPanels';
import { List, ListItem } from 'react-md/lib/Lists';
import Button from 'react-md/lib/Buttons/Button';
import {development, strategyAndOperations, everydayDeloitte, humanCapital, technology} from "../../../containers/dumb/Admin/topics";

class EmployeeTopicColumn extends Component {
    expandList() {
        var topicList = document.getElementById("topics_a");
        if(topicList.style.display == null){
            topicList.style.display = "none";
        }else{
            topicList.style.display == null;
        }
    };

    getLabel=(e,parent,child)=>{
        console.log("INSIDE ITEM");
    }



    render() {

        // var techItems =[];
        // for{var i =0; i<technology.length; i++}
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
                    <ExpansionList>

                        <ExpansionPanel label="Technology" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {/*<ListItem*/}
                                    {/*primaryText="Inbox"*/}
                                    {/*parentList="Technology"*/}
                                    {/*childListVal="Inbox"*/}
                                    {/*onClick={this.getLabel.bind(this)}/>*/}
                                {/*<ListItem primaryText="Sent Mail" />*/}
                                {technology.map((item) => {
                                    return <ListItem primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                    <ExpansionPanel label="General" footer={null}>
                        <p>others(15)</p>
                    </ExpansionPanel>
                    </ExpansionList>
                </div>

            </div>

        );
    }
}


export default EmployeeTopicColumn;