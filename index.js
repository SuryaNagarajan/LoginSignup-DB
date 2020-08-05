var express = require('express');
var bodyParser=require('body-parser');
var mongoose=require('mongoose');
var routes=require('./src/routes/homeroutes');
const MongoClient = require('mongodb');


var app=express();

mongoose.connect('mongodb+srv://Surya:Surya2004@cluster0.0sutd.mongodb.net/Surya?retryWrites=true&w=majority',{
    useCreateIndex:true,
    useNewUrlParser:true,
    useUnifiedTopology:true
});



mongoose.connection.on('connected',()=>{
    console.log('Connected to mongodb');
});

mongoose.connection.on('error',(err)=>{
    console.log(err);
});

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());
app.use(routes);


app.listen(3000,function()
{
    console.log('Listening to port: 3000');
});



