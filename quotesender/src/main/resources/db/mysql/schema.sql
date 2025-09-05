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

CREATE TABLE IF NOT EXISTS User_votes (
    vote_id integer AUTO_INCREMENT PRIMARY KEY,
    user_id integer NOT NULL,
    quote_id integer NOT NULL,
    vote_type VARCHAR(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(userID) ON DELETE CASCADE,
    FOREIGN KEY (quote_id) REFERENCES UsersQuote(quoteID) ON DELETE CASCADE,
    UNIQUE KEY unique_user_quote (user_id, quote_id)
);