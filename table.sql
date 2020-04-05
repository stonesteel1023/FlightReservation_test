drop table RESERVATION;

create table RESERVATION(


flight_number varchar2(20) primary key,
origin_airport varchar2(10),
destination_airport varchar2(10),
carrier varchar2(20),
price number(5),
day varchar2(10),
time varchar2(10),
duration varchar2(10),
available_seat number(3)



);