const Activity = require("../models/activity");
const asyncHandler = require("express-async-handler");

// Create Activity using post request
exports.activity_create_post = asyncHandler(async (req, res, next) => {
  var activity = new Activity(req.body);
  activity.coordinatorID = req.user.id;
  activity.coordinatorName = req.user.username;
  await activity.save();
  res.json(activity);
});

// Read all activities using get request
exports.activity_list = asyncHandler(async (req, res, next) => {
  const page = parseInt(req.query.page) || 1;
  const limit = parseInt(req.query.limit) || 9; // Default to 9 items per page
  const skip = (page - 1) * limit;

  const activities = await Activity.find().skip(skip).limit(limit);
  const totalActivities = await Activity.countDocuments();
  const totalPages = Math.ceil(totalActivities / limit);

  res.json({ activities, totalPages });
});

// Read one activiity using get request
exports.activity_detail = asyncHandler(async (req, res, next) => {
  const activity = await Activity.findById(req.params.id);
  res.json(activity);
});

// Update activity using put request
exports.activity_update_patch = asyncHandler(async (req, res, next) => {
  await Activity.findByIdAndUpdate(req.params.id, req.body);
  const updatedActivity = await Activity.findById(req.params.id);
  res.json(updatedActivity);
});

// Delete activity using delete request
exports.activity_delete = asyncHandler(async (req, res, next) => {
  const activity = await Activity.findByIdAndDelete(req.params.id);
  res.json(activity);
});
