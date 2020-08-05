require('../models/user');
var express = require('express');
var route=express.Router();
var mongoose=require('mongoose');
var User=mongoose.model('User');


route.get('/',(req,res)=>{
    res.send("Hello!!!");
})

route.post('/signup',async (req,res)=>{
    var email = req.body.email;
    var password = req.body.password;
    try{
    var user = new User({email:email,password:password});
    await user.save();
    return res.send("Account Created")
    }catch(err){
        return res.send(err);
    }

})

route.post('/signin',async (req,res)=>{
    var email = req.body.email;
    var password = req.body.password;
    try{
    var user = await User.findOne({email});
    if(user.password === password) return res.send("Logged IN Successfully")
    else return res.send("Invalid credentials");
    }catch{
        return res.send("Create an account and then try logging in");
    }


})

module.exports = route;