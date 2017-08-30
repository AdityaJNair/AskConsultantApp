import React, { Component } from 'react';

class SearchFilter extends Component {
    render(){
        return (
            <div id="search_filter">
                <intput type="text" id="searchBar"/>
                <div>Filter dropdown</div>
            </div>
        )
    }
}

export default SearchFilter;