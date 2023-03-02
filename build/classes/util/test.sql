create table customer(
	id int not null,
	name varchar(20) not null,
	age int,
	email varchar(50)
);

create table users(
	id varchar(20) not null,
	name varchar(30) not null,
	title varchar(30) not null,
	txt varchar(70) not null,
	email varchar(30)
)

insert into users values ('id1', 'name1', 'title1', 'txt1', 'email1');
insert into users values ('id2', 'name2', 'title2', 'txt2', 'email2');
insert into users values ('id3', 'name3', 'title3', 'txt3', 'email3');
insert into users values ('id4', 'name4', 'title4', 'txt4', 'email4');

insert into users values('user1','KIMJS','test1@naver.com');
select * from users


delete from users where id=null
drop table users

