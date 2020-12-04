import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom';
import client from './client';

const App = (props) => {
	const [employees, updateEmployees] = useState([]);

	useEffect(() => {
		client({ method: 'GET', path: '/api/employees' }).done(response => {
			updateEmployees({ employees: response.entity._embedded.employees });
		});
	}, []);

	return (
		<EmployeeList employees={employees} />
	);
};

export default App;