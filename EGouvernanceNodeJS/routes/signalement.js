"use strict";

let express = require('express');
let router = express.Router();
let mongo = require('../database/MongoConnector');

router.get('/', async function (req,res,next){
    try {
        let limit = 10;
        let page = req.query.page || 0;
        await mongo.connect();
        let data = await mongo.db('egov').collection('signalement').find().limit(limit).skip(page*limit).toArray();
        await mongo.close();
        res.send({status:200,content:data});
    } catch (error) {
        res.send({status:400,content:error});
    }
});

router.post('/',async function(req,res,next){
    try {
        await mongo.connect();
        let data = await mongo.db('egov').collection('signalement').insertOne(req.body);
        await mongo.close();
        res.send({status:200,content:data});
    } catch (error) {
        res.send({status:400,content:error});
    }
});

module.exports = router;