const ParticipantAvailability = require("../models/participantAvailability");
const asyncHandler = require("express-async-handler");

// Create availability using post request
exports.availability_create_post = asyncHandler(async (req, res, next) => {
  const { availability, activityId } = req.body;
  const { monday, tuesday, wednesday, thursday, friday, saturday, sunday } =
    availability;
  const participantId = req.user._id;
  const participantName = req.user.username;

  try {
    const avail = new ParticipantAvailability({
      participantId,
      participantName,
      activityId,
      monday,
      tuesday,
      wednesday,
      thursday,
      friday,
      saturday,
      sunday,
    });
    await avail.save();
    res.json(avail);
  } catch (error) {
    console.error(error);
    return res.status(500).json({ error: "Internal server error" });
  }
});

// Read all availabilities related to an activity using get request
exports.availability_list = asyncHandler(async (req, res, next) => {
  const activityId = req.params.activityId;
  const availabilities = await ParticipantAvailability.find({ activityId });
  res.json(availabilities);
});

// Update availability using patch request
exports.availability_update_patch = asyncHandler(async (req, res, next) => {
  const { monday, tuesday, wednesday, thursday, friday, saturday, sunday } =
    req.body;

  const avail = await ParticipantAvailability.findById(req.params.id);
  if (!avail) {
    return res.status(404).json({ error: "Availability not found" });
  }

  if (req.user.id !== avail.participantId) {
    return res.status(403).json({ error: "Access denied" });
  }

  await ParticipantAvailability.findByIdAndUpdate(req.params.id, {
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday,
  });

  const updatedAvail = await ParticipantAvailability.findById(req.params.id);
  res.json(updatedAvail);
});

// Delete availability using delete request
exports.availability_delete = asyncHandler(async (req, res, next) => {
  const avail = await ParticipantAvailability.findById(req.params.id);
  if (!avail) {
    return res.status(404).json({ error: "Availability not found" });
  }

  if (req.user.id !== avail.participantId) {
    return res.status(403).json({ error: "Access denied" });
  }

  await ParticipantAvailability.findByIdAndDelete(req.params.id);
  res.json(avail);
});
