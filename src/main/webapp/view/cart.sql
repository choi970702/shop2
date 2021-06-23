
create table cart
(
    c_idx number not null primary key,
    p_num varchar2(15) not null,
    p_name varchar2(50) not null,
    p_price number not null,
    p_saleprice number not null,
    amount number not null,
    id varchar2(50) not null
);

create SEQUENCE cart_seq
INCREMENT by 1
start with 1;




