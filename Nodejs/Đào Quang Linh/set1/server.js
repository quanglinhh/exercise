const express = require("express");

const app = express();

app.use(express.json());



app.get("/", (req, res) => {
  res.json({ message: "Hello World" });
});

require("./app/routes/users.routes.js")(app);
// database
const db = require("./app/models");


db.sequelize.sync();

const PORT = process.env.PORT || 8085;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}.`);
});