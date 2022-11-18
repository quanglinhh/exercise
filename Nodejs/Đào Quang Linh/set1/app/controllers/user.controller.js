
const db = require("../models/index");
const User = db.user;


exports.create = (req, res) => {
    // Validate request
    if (!req.body) {
      res.status(400).send({
        message: "Content can not be empty!"
      });
    }
    User.create({
        firstName : req.body.firstName,
        lastName : req.body.lastName,
        mobileNumber : req.body.mobileNumber,
        username : req.body.username,
        password : req.body.password
      })
      .then(user =>{
        res.send({message: "the new user generated"});
      }).catch(err=>{
        res.status(501).send({message: err.message});
      });
  };


  // Retrieve all Tutorials from the database (with condition).
exports.findAll = (req, res) => {
    User.findAll().then((data) => res.send(data))
  };
  
  



