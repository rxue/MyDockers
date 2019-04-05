use admin
db.createUser(
    {
        user: "reader", 
        pwd: "reader", 
        roles:[{ role: "read", db: "masterdata"}]
    }
);
