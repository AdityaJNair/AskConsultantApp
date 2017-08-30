import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import ChatItem from './components';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<ChatItem />, div);
});
