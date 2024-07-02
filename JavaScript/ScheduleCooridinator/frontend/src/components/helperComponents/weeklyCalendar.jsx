import React, { useState } from 'react';
import DayScheduler from './dayScheduler';

const daysOfWeek = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday'];

const WeeklyCalendar = ({ prepareAndSubmitAvailabilityData, setAvailability }) => {
  const [selectedDay, setSelectedDay] = useState({
    sunday: [],
    monday: [],
    tuesday: [],
    wednesday: [],
    thursday: [],
    friday: [],
    saturday: [],
  });

  const updateSelectedHoursForDay = (day, timeRanges) => {
    setSelectedDay(prev => {
      const updatedAvailabilty = { ...prev, [day]: timeRanges };
      setAvailability(updatedAvailabilty);
      return updatedAvailabilty;
    });
  }

  return (
    <>
      <div className="calendar-container">
        {daysOfWeek.map((day) => (
          <DayScheduler day={day} key={day} finalizeHoursSelection={(timeRanges) => updateSelectedHoursForDay(day, timeRanges)} />
        ))}
      </div>
      <button onClick={prepareAndSubmitAvailabilityData} className='btn btn-success btn-shadow'>Submit</button>
    </>
  )
};

export default WeeklyCalendar;