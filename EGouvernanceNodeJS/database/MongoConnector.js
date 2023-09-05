"use strict";

const { MongoClient , ServerApiVersion } = require('mongodb');
const uri = "mongodb+srv://egov:DtB99SG4xs19dogY@egovcluster0.msjh3wb.mongodb.net/?retryWrites=true&w=majority";

const client = new MongoClient(uri, {
    serverApi: {
      version: ServerApiVersion.v1,
      strict: true,
      deprecationErrors: true,
    }
  });

module.exports = client;