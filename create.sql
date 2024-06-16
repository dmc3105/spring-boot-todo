create database todo_db;
use todo_db;
create table tasks (status tinyint check (status between 0 and 1), date datetime(6), id bigint not null, description varchar(255), title varchar(255), primary key (id)) engine=InnoDB;
create table tasks_seq (next_val bigint) engine=InnoDB;
insert into tasks_seq values ( 1 );
