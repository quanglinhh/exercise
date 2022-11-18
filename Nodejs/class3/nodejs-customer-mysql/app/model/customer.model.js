const sql = require("./db")

//constructor
const Customer = function(customer){
    this.name = customer.name,
    this.email = customer.email,
    this.age = customer.age;
}

Customer.create = (newCustomer, result)=>{
    sql.query("INSERT INTO customer SET ?",newCustomer, (err,res)=>{
        if(err){
            console,console.log("error: ",err)
            result(err,null)
            return
        }

        console.log("created tutorial ",{id:res.insertId,...newCustomer})
        result(null,{id:res.insertId,...newCustomer})
    })
}

Customer.findAll =(name,result)=>{
    let query = "SELECT * FROM customer"
    if(name){
        query += `WHERE name LIKE '%${name}'`
    }
    sql.query(query,(err,res)=>{
        if(err){
            console.log("error: ",err)
            result(null,err)
            return
        }
        console.log("tutorial: ",res)
        result(null,res)
    })
}

Customer.delete=(name)=>{
    let query = "DELETE FROM customer" 
    if(name){
        query +=`WHERE name LIKE'%${name}'` 
    }
    sql.query(query,(err,res)=>{
        result(null,res)
    })
}
module.exports =Customer;