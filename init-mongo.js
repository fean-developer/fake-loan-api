// MongoDB initialization script
db = db.getSiblingDB('fake-loan-db');

// Create collections with indexes
db.createCollection('users');
db.users.createIndex({ "email": 1 }, { unique: true });
db.users.createIndex({ "_id": 1 }, { unique: true });

db.createCollection('loans');
db.loans.createIndex({ "_id": 1 },{ unique: true });
db.loans.createIndex({ "account": 1 });


print('Database initialized successfully!');
