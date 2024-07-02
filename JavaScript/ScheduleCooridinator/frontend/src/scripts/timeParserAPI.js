// Helper function to convert a time string to minutes
const timeToMinutes = (time) => {
  const [hours, minutes] = time.split(":").map(Number);
  return hours * 60 + minutes;
};

// Helper function to convert minutes to a time string
const minutesToTime = (minutes) => {
  const hours = Math.floor(minutes / 60);
  const mins = minutes % 60;
  return `${hours.toString().padStart(2, "0")}:${mins
    .toString()
    .padStart(2, "0")}`;
};

// Function to convert half-hour increments back to time ranges
const convertIncrementsToRanges = (increments) => {
  const ranges = [];
  let currentStart = null;
  let previousTime = null;

  increments.forEach((time, index) => {
    const minutes = timeToMinutes(time);
    if (currentStart === null) {
      currentStart = minutes;
    } else if (previousTime !== null && minutes - previousTime > 30) {
      ranges.push({
        start: minutesToTime(currentStart),
        end: minutesToTime(previousTime + 30),
      });
      currentStart = minutes;
    }

    if (index === increments.length - 1) {
      ranges.push({
        start: minutesToTime(currentStart),
        end: minutesToTime(minutes),
      });
    }

    previousTime = minutes;
  });

  return ranges;
};

// Main function to convert processed data back to availability format
const convertUserAvailabilitytoAPI = (processedData) => {
  const availability = {};

  for (const day in processedData) {
    availability[day] = convertIncrementsToRanges(processedData[day]);
  }

  return availability;
};

// Export the helper functions
export { convertUserAvailabilitytoAPI };
