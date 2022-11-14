
const Customer = require("../model/customer.model")

//Create and save new Customer
exports.create = (req,res)=>{
    if(!req.body){
        res.status(400).send({
            message:"Content cannot be empty!"
        })
    }
    //Create a Customer
    const customer = new Customer({
        name: req.body.name,
        email:req.body.email,
        age:req.body.age || false
    })

    //Save Customer in the database
    Customer.create(customer,(err,data)=>{
        if(err)
        res.status(500).send({
            message:
            err.message||"Some error occurred while create the Customer"
        })
        else res.send(data)
    })
}

//Get all Customer
exports.findAll = (req,res)=>{
    const name = req.query.name

    Customer.findAll(name,(err,data)=>{
        if(err)
        res.status(500).send({
            message:
                err.message||'Some error occured'
        })
        else res.send(data)
    })

}
