-- Drop Table if they are existed
DROP TABLE IF EXISTS userProfile ;
DROP TABLE IF EXISTS Lotto ;
DROP TABLE IF EXISTS Administrator;
DROP TABLE IF EXISTS sys_transaction;

CREATE TABLE userProfile (
    user_Id SERIAL PRIMARY KEY,
    user_Name VARCHAR(100) NOT NULL,
    user_Email VARCHAR(50) NOT NULL,
    user_Password VARCHAR (12) NOT NULL,
);

CREATE TABLE Lotto (
    lotto_Id SERIAL PRIMARY KEY,
    lotto_Number VARCHAR(6) NOT NULL,
    lotto_Status VARCHAR ("Available","On_Hold", "Completed" ) NOT NULL,
    lotto_Date TIMESTAMP;
);

CREATE TABLE Administrator (
    admin_Id SERIAL PRIMARY KEY,
    admin_Name VARCHAR NOT NULL,
    admin_Email VARCHAR NOT NULL,
    admin_Password VARCHAR NOT NULL,
);

CREATE TABLE sys_transaction (
    transaction_Id SERIAL PRIMARY KEY,
    create_Date TIMESTAMP,
    update_Date TIMESTAMP,
    transaction_Status VARCHAR,
    void_Status VARCHAR,
    void_Date TIMESTAMP,
    purchase_Date TIMESTAMP,
    return_Date TIMESTAMP,
    user_Id INT,
    lotto_Id INT,
    ref_Id VARCHAR,
);
-- Initial Data
INSERT INTO userProfile(user_Name, user_Email, user_Password) VALUES ('Keane Kodewa', 'keane@gmail.com', "s3xyboi69");
INSERT INTO Lotto(lotto_Number,lotto_Status) VALUES ('123456', "Available");
INSERT INTO Administrator(admin_Name,admin_Email,admin_Password) VALUES ('admin','hottestadmin@gmail.com','misterhotadmin');