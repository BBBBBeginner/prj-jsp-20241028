USE jsp2;

CREATE TABLE board
(
    id       VARCHAR(30)  NOT NULL,
    title    VARCHAR(100) NOT NULL,
    content  VARCHAR(500) NOT NULL,
    Writer   VARCHAR(100) NOT NULL,
    inserted DATETIME     NOT NULL DEFAULT NOW()
);

SELECT *
FROM board;

ALTER TABLE board
    CHANGE COLUMN Writer writer VARCHAR(100);

ALTER TABLE board
    CHANGE COLUMN id id INT PRIMARY KEY AUTO_INCREMENT;

SELECT COUNT(*)
FROM jsp2.board;

INSERT INTO board
    (title, content, writer)
SELECT title, content, writer
FROM board;



