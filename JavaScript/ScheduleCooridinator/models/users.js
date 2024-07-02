const mongoose = require("mongoose");

const Schema = mongoose.Schema;

const userSchema = new Schema({
  // UserID, LastName, FirstName, Username, Email, password, Created, Updated, SocialMediaName, Role
  lastName: { type: String, maxLength: 100 },
  firstName: { type: String, maxLength: 100 },
  username: { type: String, required: true, maxLength: 100, unique: true },
  email: { type: String, required: true, unique: true },
  password: { type: String, required: true },
  created: { type: Date, default: Date.now },
  updated: { type: Date, default: Date.now },
  socialMediaName: { type: String },
  role: {
    type: String,
    enum: ["Admin", "User"],
    default: "User",
  },
});

userSchema.virtual("url").get(function () {
  return "/user/" + this._id;
});

userSchema.methods.isAdmin = function () {
  return this.role === "Admin";
};

module.exports = mongoose.model("User", userSchema);
