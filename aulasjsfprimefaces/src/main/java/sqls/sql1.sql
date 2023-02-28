create table entidade(
	ent_codigo bigint not null,
	ent_inativo boolean not null,
	ent_login character varying(20),
	ent_senha character varying(20),
	
	constraint entidade_pk primary key(ent_codigo),
	constraint entidade_ent_login_key unique(ent_login)
)

create table entidadeacesso(
	ent_codigo bigint not null,
	esa_codigo character varying (70),
	
	constraint ent_codigo_fkey foreign key (ent_codigo)
	references entidade (ent_codigo)
	match simple on update no action on delete no action
)

INSERT INTO entidade(
	ent_codigo, ent_inativo, ent_login, ent_senha)
	VALUES (1, false, 'admin', '123');
	
INSERT INTO entidade(
	ent_codigo, ent_inativo, ent_login, ent_senha)
	VALUES (2, true, 'luan', '123');
	
INSERT INTO entidadeacesso(
	ent_codigo, esa_codigo)
	VALUES (1, 'ADMIN');

INSERT INTO entidadeacesso(
	ent_codigo, esa_codigo)
	VALUES (1, 'USER');

INSERT INTO entidadeacesso(
	ent_codigo, esa_codigo)
	VALUES (2, 'USER');
	
select ent_login as username, ent_senha as password, true as enable
from entidade
where ent_inativo=false
and upper(ent_login)=upper(?)

select u.ent_login as username, p.esa_codigo as authority
from entidade u
join entidadeacesso p
on u.ent_codigo=p.ent_codigo
where ent_inativo=false
and upper(ent_login)=upper(?)