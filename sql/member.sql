USE jsp2;

CREATE TABLE member
(
    id          VARCHAR(50) PRIMARY KEY,
    password    VARCHAR(100) NOT NULL,
    nick_name   VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(2000),
    inserted    DATETIME     NOT NULL DEFAULT NOW()
);

SELECT *
FROM jsp2.member;

ALTER TABLE member
    CHANGE COLUMN nick_name nickName VARCHAR(100) NOT NULL UNIQUE;

