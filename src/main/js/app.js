import React, { useState, useEffect } from 'react';
import client from './client';
import { pathOr } from 'ramda';
import EmployeeList from './components/EmployeeList';

const GET_METHOD = 'GET';
const EMPLOYEES_DATA_PATH = ['entity', '_embedded', 'employeeList'];
const EMPLOYEES_API_PATH = '/api/employees';

const App = () => {
	const [employees, updateEmployees] = useState([]);

	useEffect(() => {
		client({ method: GET_METHOD, path: EMPLOYEES_API_PATH }).done(response => {
			updateEmployees(pathOr([], EMPLOYEES_DATA_PATH, response));
		});
	}, []);

	return (
		<EmployeeList employees={employees} />
	);
};

export default App;