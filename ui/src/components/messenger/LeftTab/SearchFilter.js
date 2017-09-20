import React, { Component } from 'react';
import SelectField from 'react-md/lib/SelectFields/SelectField'
import TextField from 'react-md/lib/TextFields/TextField'
import Style from './stylesheet/SearchFilter.css'

class SearchFilter extends Component {
    render(){
        return (
            <div id="search_filter">
                <div id="search_field">
                    <div id="search_field_expand">
                        <TextField
                            id="searchField"
                            label="Search"
                            lineDirection="center"
                            placeholder="Search term goes here"
                            className="md-cell md-cell--bottom"
                            />
                    </div>
                </div>
                <div id="filter_dropdown">
                    <SelectField
                        id="sort-by"
                        label="Sort by..."
                    />
                </div>
            </div>
        )
    }
}

export default SearchFilter;