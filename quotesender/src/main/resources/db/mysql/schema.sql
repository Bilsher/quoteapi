CREATE TABLE IF NOT EXISTS Users(
    userID integer AUTO_INCREMENT PRIMARY Key,
    login varchar(255) not NULL,
    password varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS UsersQuote(
    quoteID integer AUTO_INCREMENT PRIMARY Key,
    likes integer DEFAULT(0),
    dislikes integer DEFAULT(0),
    quoteText varchar(255) not NULL,
    userID integer,
    FOREIGN key (userID) REFERENCES Users(userID)
);
