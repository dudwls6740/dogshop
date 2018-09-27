DROP TABLE dog purge;
create table dog(
	id number primary key,
	kind varchar2(12),
	price number,
	image varchar2(20),
	country varchar2(12),
	height number,
	weight number,
	content varchar2(400),
	readcount number 
);


create sequence dog_se start with 1 nocache;

insert into dog values(1, 'Çªµé','10000','pu','ÇÁ¶û½º','1','20','ÇªµéÇªµé ±Í¿©¿ö¿ä',0);
insert into dog values(2, 'Ç³»ê°³','20000','pung','ÇÑ±¹','2','10','Ç³»êÇ³»ê ±Í¿©¿ö¿ä',0);
insert into dog values(3, 'Áøµµ°³','30000','jin','ÇÑ±¹','3','50','ÁøµµÁøµµ ±Í¿©¿ö¿ä',0);
insert into dog values(4, '»ð»ì°³','40000','sap','ÇÑ±¹','2','20','»ð»ì»ð»ì ±Í¿©¿ö¿ä',0);

commit