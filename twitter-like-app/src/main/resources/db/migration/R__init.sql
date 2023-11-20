
-- Drop Tables --
DROP TABLE IF EXISTS T_messages;
DROP TABLE IF EXISTS SubscriberProducer;
DROP TABLE IF EXISTS T_users;

-- Create the user table --
CREATE TABLE T_users (
    uid INT NOT NULL,
    u_name VARCHAR(255) NOT NULL,
    u_role VARCHAR(20) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY(uid)
);

-- Establish Subscriptions --
CREATE TABLE SubscriberProducer (
    SP_ID INT NOT NULL,
    subscriberId INT NOT NULL,
    producerId INT NOT NULL,
    CONSTRAINT PK_subscriber PRIMARY KEY(SP_ID),
    CONSTRAINT FK_Subscriber_ID FOREIGN KEY(subscriberId) REFERENCES T_users(uid),
    CONSTRAINT FK_Producer_ID FOREIGN KEY(producerId) REFERENCES T_users(uid)
);

-- Create the T_messages table --
CREATE TABLE T_messages (
    mid INT NOT NULL,
    uid INT NOT NULL,
    contents TEXT NOT NULL,
    CONSTRAINT PK_messages PRIMARY KEY(mid),
    CONSTRAINT FK_uid FOREIGN KEY(uid) REFERENCES T_users(uid)
);
--- insert users ---
INSERT INTO t_users( uid, u_name, u_role ) VALUES( 101, 'Kamelia.P', 'Producer' );
INSERT INTO t_users( uid, u_name, u_role ) VALUES( 102, 'John.D', 'Producer' );
INSERT INTO t_users( uid, u_name, u_role ) VALUES( 103, 'Blake.L', 'Subscriber' );
INSERT INTO t_users( uid, u_name, u_role ) VALUES( 104, 'Ryan.R', 'Subscriber' );

--- insert subscriber-producer ---
INSERT INTO subscriberProducer( SP_ID, subscriberid, producerid ) VALUES( 1, 103, 101 );
INSERT INTO subscriberproducer( SP_ID, subscriberid, producerid ) VALUES( 2, 103, 102 );
INSERT INTO subscriberproducer( SP_ID, subscriberid, producerid ) VALUES( 3, 104, 101 );
INSERT INTO subscriberproducer( SP_ID, subscriberid, producerid ) VALUES( 4, 104, 102 );

--- insert message ---
INSERT INTO t_messages ( mid, uid, contents) VALUES( 10001, 101, 'This is a message from producer 101, Kamelia');
INSERT INTO t_messages ( mid, uid, contents) VALUES( 10002, 102, 'This is a message from producer 102, John');
INSERT INTO t_messages ( mid, uid, contents) VALUES( 10003, 103, 'This is a message from subscriber 103, Blake');
INSERT INTO t_messages ( mid, uid, contents) VALUES( 10004, 104, 'This is a message from subscriber 104, Ryan');
INSERT INTO t_messages ( mid, uid, contents) VALUES( 10005, 101, 'This is a secomd message from producer 101, Kamelia');
