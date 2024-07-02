const mongoose = require("mongoose");

const timeRangeSchema = new mongoose.Schema(
  {
    start: String, // Could be 'HH:MM' format
    end: String, // Could be 'HH:MM' format
  },
  { _id: false }
); // Prevents Mongoose from creating an _id for sub-documents

const participantAvailabilitySchema = new mongoose.Schema(
  {
    participantId: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "User",
      required: true,
    },
    participantName: {
      type: String,
      required: true,
    },
    activityId: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "Activity",
      required: true,
    },
    monday: [timeRangeSchema],
    tuesday: [timeRangeSchema],
    wednesday: [timeRangeSchema],
    thursday: [timeRangeSchema],
    friday: [timeRangeSchema],
    saturday: [timeRangeSchema],
    sunday: [timeRangeSchema],
  },
  { timestamps: true }
);

module.exports = mongoose.model(
  "ParticipantAvailability",
  participantAvailabilitySchema
);
