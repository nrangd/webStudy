CREATE TABLE somethings (
    st_id number(10) primary key,
    st_str1 varchar2(100),
    st_str2 varchar2(100),
    st_date date,
    st_number number(10)
);

create sequence somethings_id_seq 
    start with 1
    increment by 1
    nocache nocycle;