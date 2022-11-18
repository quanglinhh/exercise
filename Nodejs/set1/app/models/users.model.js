
module.exports = (sequelize, Sequelize) => {
    const User = sequelize.define("users", {
      firstName: {
        type: Sequelize.STRING,
        
      },
      lastName:{
        type:Sequelize.STRING
      },
      mobileNumber:{
        type:Sequelize.STRING
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





  

