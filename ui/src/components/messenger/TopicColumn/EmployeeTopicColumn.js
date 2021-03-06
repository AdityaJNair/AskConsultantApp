import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields/TextField'
import { ExpansionList, ExpansionPanel } from 'react-md/lib/ExpansionPanels';
import { List, ListItem } from 'react-md/lib/Lists';
import Button from 'react-md/lib/Buttons/Button';
import {employeeConvoTopics, technology, development, strategyAndOperations, everydayDeloitte, humanCapital} from "../../../containers/dumb/Admin/topics";

import {setEmployeePrefTopics,updateEmployeeConversations, setActiveTopics } from "../../../actions/leftTabActions"
import {initMessageFromServer} from "../../../actions/messengerAction";


//This class holds the UI and logic for the topics column for employees
class EmployeeTopicColumn extends Component {
    expandList() {
        var topicList = document.getElementById("topics_a");
        if(topicList.style.display == null){
            topicList.style.display = "none";
        }else{
            topicList.style.display == null;
        }
    };

    //Before the UI has been shown, open the subtopic that the employees prefer
    componentWillMount(){
        this.props.dispatch(setEmployeePrefTopics(this.props.userID));
    }

    changeActiveTopics = (subTopic, topic) =>{
        this.props.dispatch(updateEmployeeConversations(this.props.userID, topic, subTopic.item, true))
            .then((success)=> {
                if(success)
                    this.props.dispatch(initMessageFromServer(this.props.userID, this.props.conversationid))
        })
        this.props.dispatch(setActiveTopics(topic,subTopic));

    }

    showAllConversations = () =>{
        this.props.dispatch(updateEmployeeConversations(this.props.userID, 'All',''));
        this.props.dispatch(setActiveTopics('All',''));
    }



    render(){
        return (
            <div id="employee_Topic_Column">

                <div id="topics_field">
                    <div id="showall_button">
                        <Button label="Show All Alive Conversations" raised primary className="md-button" onClick={() => {this.showAllConversations()}}/>
                    </div>

                    <ExpansionList>
                        <ExpansionPanel label="Development" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {development.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Development")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                        <ExpansionPanel label="Everyday Deloitte" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {everydayDeloitte.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Everyday Deloitte")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                        <ExpansionPanel label="Human Capital" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {humanCapital.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Human Capital")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                        <ExpansionPanel label="Strategy and Operations" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {strategyAndOperations.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Strategy and Operations")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                        <ExpansionPanel label="Technology" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {technology.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Technology")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                    </ExpansionList>
                </div>

            </div>

        );
    }
}
export default EmployeeTopicColumn;
