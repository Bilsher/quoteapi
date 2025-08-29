
INSERT IGNORE INTO Users(userID,login,password) VALUES (1,'Ivan', '1234');
INSERT IGNORE INTO Users(userID,login,password) VALUES (2,'Petr', '2454');
INSERT IGNORE INTO Users(userID,login,password) VALUES (3,'Sasha', '3665');
INSERT IGNORE INTO Users(userID,login,password) VALUES (4,'Valera', '7634');
INSERT IGNORE INTO Users(userID,login,password) VALUES (5,'Danil', '8623');

INSERT IGNORE INTO UsersQuote(quoteID,quoteText,userID) VALUES (1,'i wrote some quote to test a thing',1);
INSERT IGNORE INTO UsersQuote(quoteID,quoteText,userID) VALUES (2,'some quote 2',2);
INSERT IGNORE INTO UsersQuote(quoteID,quoteText,userID) VALUES (3,'quote by Sasha',3);
INSERT IGNORE INTO UsersQuote(quoteID,quoteText,userID) VALUES (4,'bruh......',4);
INSERT IGNORE INTO UsersQuote(quoteID,quoteText,userID) VALUES (5,'.....test quote.....',5);


