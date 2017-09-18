create database kyz_imobiliaria;
use kyz_imobiliaria;
INSERT INTO tipo_imovel(descricao, condominio) VALUES
('casa',false),
('apartamento', true),
('casa em condomínio', true),
('sala comercial', true),
('ponto comercial', false);

select * from profissional_permissoes;
describe profissional_permissoes;


insert into profissional(email,password) values('pedro','123');

select * from role;

insert into role(id, role) values(1,'ROLE_PROFISSIONAL'),(2,'ROLE_CLIENTE');

show tables;