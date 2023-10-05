drop schema if exists spring;

drop user if exists 'user'@'localhost'; create schema spring;
create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';
use spring;
create table jog_jogo (
 jog_id bigint primary key auto_increment,
 jog_titulo varchar(100) not null,
 jog_estudio varchar(100) not null,
 jog_data_hora_lancamento datetime not null,
 jog_classificacao varchar(3) ,
 jog_duracao_media float
);
insert into jog_jogo (jog_titulo, jog_estudio, jog_data_hora_lancamento)
values ('God Of War', 'Santa Monica', '2005-03-22 00:00:00');
insert into jog_jogo(jog_titulo, jog_estudio, jog_data_hora_lancamento,jog_classificacao,jog_duracao_media)
 values ('Hogwarts Legacy', 'Avalanche', '2023-02-10 00:00:00', '12', 25);
