
module.exports = (sequelize, Sequelize) => {
    const User = sequelize.define("users", {
      firstName: {
        type: Sequelize.STRING,
        
      },
      lastName:{
        type:Sequelize.STRING
      },
      mobileNumber:{
        type:Sequelize.STRING,
        validate: {
          is: /^\d{10}$/
        }
      },
      username:{
        type:Sequelize.STRING
       
      },
      password:{
        type:Sequelize.STRING
      },
    });
      
    return User;
  };





  

