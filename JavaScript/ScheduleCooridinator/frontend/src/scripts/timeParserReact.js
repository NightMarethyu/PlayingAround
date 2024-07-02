// Helper function to convert time string to minutes
const timeToMinutes = (time) => {
  const [hours, minutes] = time.split(":").map(Number);
  return hours * 60 + minutes;
};

// Helper function to convert minutes to time string
const minutesToTime = (minutes) => {
  const hours = Math.floor(minutes / 60);
  const mins = minutes % 60;
  return `${hours.toString().padStart(2, "0")}:${mins
    .toString()
    .padStart(2, "0")}`;
};

// Function to check if two time ranges overlap
const rangesOverlap = (range1, range2) => {
  return (
    timeToMinutes(range1.start) < timeToMinutes(range2.end) &&
    timeToMinutes(range2.start) < timeToMinutes(range1.end)
  );
};

// Function to merge overlapping time ranges
const mergeTimeRanges = (ranges) => {
  ranges.sort((a, b) => timeToMinutes(a.start) - timeToMinutes(b.start));
  const merged = [];
  let currentRange = ranges[0];

  for (let i = 1; i < ranges.length; i++) {
    if (rangesOverlap(currentRange, ranges[i])) {
      currentRange.end =
        timeToMinutes(currentRange.end) > timeToMinutes(ranges[i].end)
          ? currentRange.end
          : ranges[i].end;
    } else {
      merged.push(currentRange);
      currentRange = ranges[i];
    }
  }
  merged.push(currentRange);
  return merged;
};

// Function to break down time ranges into half-hour increments
const breakdownTimeRanges = (ranges) => {
  const brokenDown = [];
  ranges.forEach((range) => {
    let currentTime = timeToMinutes(range.start);
    const endTime = timeToMinutes(range.end);

    while (currentTime < endTime) {
      brokenDown.push(minutesToTime(currentTime));
      currentTime += 30; // Move to the next half-hour increment
    }
  });
  return brokenDown;
};

// Main function to process the availability data
const processAvailabilityData = (availability) => {
  const processedData = {};

  for (const day in availability) {
    const mergedRanges = mergeTimeRanges(availability[day]);
    processedData[day] = breakdownTimeRanges(mergedRanges);
  }

  return processedData;
};

// Export the main function
export { processAvailabilityData };
