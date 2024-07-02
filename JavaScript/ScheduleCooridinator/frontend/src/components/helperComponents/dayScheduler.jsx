import React from 'react';
import SelectableList from './selectableList'; // Adjust the import path as necessary
import { capitalizeFirstLetter } from '../../scripts/helpers';

const hours = Array.from({ length: 48 }, (_, i) => `${Math.floor(i / 2)}:${i % 2 === 0 ? '00' : '30'}`); // Generate hours from 0:00 to 23:00

const DayScheduler = ({ day, finalizeHoursSelection }) => {

  return (
    <div>
      <div key={day} className='day-column' style={{ cursor: 'pointer', marginBottom: '10px' }}>
        <h3 className='day-header' >{capitalizeFirstLetter(day)}</h3>
        <SelectableList items={hours} onSelectionFinalize={finalizeHoursSelection} day={day} />
      </div>
    </div>
  );
};

export default DayScheduler;
