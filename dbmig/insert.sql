ALTER TABLE addresses AUTO_INCREMENT = 1;
ALTER TABLE filials AUTO_INCREMENT = 1;
ALTER TABLE types AUTO_INCREMENT = 1;
ALTER TABLE companies AUTO_INCREMENT = 1;

insert into addresses (post_index,city,street,house,flat)
VALUES ('195000','St.Petersburg','Nevsky pr','1A','-'),
       ('101000','Moskow','Arbat','1A','-'),
       ('185000','Samara','Aviatsionnaya st.','1A','-'),
       ('101000','Moskow','Nagorny pr.','18','-');

insert into filials( company_id, name, address_id)
VALUES(1,'filial 1',1),
      (1,'filial 2',3);
insert into types(name)
VALUES('OOO');
insert into companies(name,type_id,address_id)
    VALUES('company one',1,2),
    ('company two',1,4);