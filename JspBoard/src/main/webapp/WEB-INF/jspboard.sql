CREATE TABLE jspboard (
    board_id NUMBER(10),
    board_title VARCHAR2(100),
    board_writer VARCHAR2(50),
    board_writer_ip_addr VARCHAR2(15),
    board_password VARCHAR2(30),
    board_content VARCHAR2(2000),
    board_write_date DATE,
    board_view_count NUMBER(10) default 0,
    board_pos_count NUMBER(6) default 0,
    board_neg_count NUMBER(6) default 0
);

CREATE SEQUENCE jspboard_board_id_seq NOCACHE NOCYCLE;