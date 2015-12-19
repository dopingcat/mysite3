CREATE TABLE FILE_BOARD (
board_no     NUMBER(8),
file_name    VARCHAR2(100) NOT NULL,
origin_name  VARCHAR2(100) NOT NULL,
reg_date     DATE NOT NULL,
constraint "file_board_pk"  primary key(board_no, file_name)
);