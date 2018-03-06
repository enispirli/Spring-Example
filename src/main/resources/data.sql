insert into user(id, username, name,surname) values(1,'enispirli','Elif Nur ','Ispirli');
insert into user(id, username, name,surname) values(2,'grhn','Gurhan ','Kucuk');
insert into user(id, username, name,surname) values(3,'sekernida','Nida ','Seker');

insert into category(id,name) values(1,'aile');
insert into category(id,name) values(2,'bilim');
insert into category(id,name) values(3,'programlama');

insert into post(id, title, text,categoryid,userid) values(1,'Ailenin Önemi','jladşdlmlçdmşldşdööd ',1,1);
insert into post(id, title, text,categoryid,userid) values(2,'Bilimin Önemi','jladşdlmlçdmşldşdööd ',2,2);
insert into post(id, title, text,categoryid,userid) values(3,'Java Dersleri','jladşdlmlçdmşldşdööd ',3,2);

insert into comment(id,text,userid,postid) values(1,'Ailenin Önemi',1,1);
insert into comment(id,text,userid,postid) values(2,'Java',1,3);
insert into comment(id,text,userid,postid) values(3,'Javada Loop',2,3);