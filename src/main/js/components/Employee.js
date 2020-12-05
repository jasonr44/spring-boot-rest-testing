import React from 'react';

const Employee = ({ employee: { firstName, lastName, description, role } = {} }) => {
  return (
    <tr>
      <td>{firstName}</td>
      <td>{lastName}</td>
      <td>{role}</td>
      <td>{description}</td>
    </tr>
  );
};

export default Employee;