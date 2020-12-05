import React from 'react';
import Employee from './Employee';
import { pathOr } from 'ramda';

const LINKS_SELF_REF_PATH = ['_links', 'self', 'href'];

const createDefaultKey = ({ name = '' }, idx) => `${name}_${idx}`;

const EmployeeList = ({ employees = [], }) => {

  return (
    <table>
      <tbody>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Role</th>
          <th>Description</th>
        </tr>
        {employees.map((employee, idx) =>
          <Employee
            key={pathOr(createDefaultKey(employee, idx), LINKS_SELF_REF_PATH, employee)}
            employee={employee}
          />
        )}
      </tbody>
    </table>
  );
};

export default EmployeeList;