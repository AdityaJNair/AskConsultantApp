import React, { Component } from 'react';
import TextField from 'react-md/lib/TextFields/TextField'
import { ExpansionList, ExpansionPanel } from 'react-md/lib/ExpansionPanels';
import { List, ListItem } from 'react-md/lib/Lists';
import Button from 'react-md/lib/Buttons/Button';
import {employeeConvoTopics, technology, development, strategyAndOperations, everydayDeloitte, humanCapital} from "../../../containers/dumb/Admin/topics";
import {setEmployeePrefTopics, updateEmployeeConversations, setActiveTopics } from "../../../actions/leftTabActions"

class EmployeeTopicColumn extends Component {
    expandList() {
        var topicList = document.getElementById("topics_a");
        if(topicList.style.display == null){
            topicList.style.display = "none";
        }else{
            topicList.style.display == null;
        }
    };

    componentWillMount(){
        this.setPrefTopics();
    }


    getLabel=(e,parent,child)=>{
        console.log("INSIDE ITEM");
    }

    setPrefTopics = () =>{
        this.props.dispatch(setEmployeePrefTopics());
    }

    changeActiveTopics = (subTopic, topic) =>{
        console.log("changing active topics");
        this.props.dispatch(updateEmployeeConversations(this.props.userID, topic, subTopic.item));
        this.props.dispatch(setActiveTopics(topic,subTopic));
    }



    render(){

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
                        <ExpansionPanel label="Strategy & Operations" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                                {strategyAndOperations.map((item) => {
                                    return <ListItem onClick={() => {this.changeActiveTopics({item}, "Strategy & Operations")}}  primaryText={item} />
                                })}
                            </List>
                        </ExpansionPanel>
                        <ExpansionPanel label="Technology" footer={null}>
                            <List className="md-cell md-paper md-paper--1">
                               , {technology.map((item) => {
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
