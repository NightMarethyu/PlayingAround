import React, { useState, useCallback } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import WeeklyCalendar from "./helperComponents/weeklyCalendar";
import { convertUserAvailabilitytoAPI } from "../scripts/timeParserAPI";
import "../stylesheets/calendar.css";

const AddAvailability = () => {
  const { id } = useParams();

  const [availability, setAvailability] = useState({
    sunday: [],
    monday: [],
    tuesday: [],
    wednesday: [],
    thursday: [],
    friday: [],
    saturday: [],
  });

  const prepData = useCallback(() => {
    const token = localStorage.getItem("token");
    const activityId = id;
    const userAvail = convertUserAvailabilitytoAPI(availability);

    console.log(availability);
    console.log(userAvail);

    const formattedData = {
      activityId,
      availability: userAvail,
    };

    console.log(formattedData);

    axios.post(`${process.env.REACT_APP_API_URL}/availability/${id}`, formattedData, {
      headers: {
        Authorization: `Bearer ${token}`,
      }
    })
      .then(response => console.log('Success:', response))
      .catch(error => console.error('Error:', error))
  }, [availability, id]);

  return (
    <div>
      <h1 className="display-1">Add Availability</h1>
      <WeeklyCalendar prepareAndSubmitAvailabilityData={prepData} setAvailability={setAvailability} />
    </div>
  );
};

export default AddAvailability;