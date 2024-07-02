const mongoose = require("mongoose");
const ActivityCategories = require("../frontend/src/activityCategories");

const Schema = mongoose.Schema;

const activitySchema = new Schema({
  //ActivityID, ActivityName, CoordinatorID, AvailableUntil, StartDate, Category
  activityName: { type: String, required: true, maxLength: 100 },
  startDate: { type: Date, default: Date.now },
  availableUntil: { type: Date },
  category: {
    type: String,
    enum: ActivityCategories,
  },
  coordinatorID: { type: Schema.Types.ObjectId, ref: "Users" },
  coordinatorName: { type: String },
});

activitySchema.virtual("url").get(function () {
  return "/activity/" + this._id;
});

module.exports = mongoose.model("Activity", activitySchema);
