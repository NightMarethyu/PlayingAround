const bcrypt = require("bcryptjs");
const saltRounds = 10;

async function hashPassword(password) {
  try {
    const salt = await bcrypt.genSalt(saltRounds);
    const hash = await bcrypt.hash(password, salt);
    return hash; // Store this hash in the database
  } catch (error) {
    console.error("Hashing error:", error);
    throw error;
  }
}

module.exports = hashPassword;
