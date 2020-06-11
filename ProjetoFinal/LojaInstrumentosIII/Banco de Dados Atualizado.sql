create database if not exists lojainstrumentos;
use lojainstrumentos;

create table tbl_cliente (
  pk_id_cliente smallint auto_increment not null,
  cli_nome varchar(40) not null,
  cli_cpf varchar(15)unique not null,
  cli_endereco varchar(40) not null,
  cli_bairro varchar(30) not null,
  cli_cidade varchar(30) not null,
  cli_uf char(02) not null,
  cli_cep varchar(9) not null,
  cli_telefone varchar(15) not null,
  primary key(pk_id_cliente));

 

 create table tbl_produto (
  pk_id_produto smallint auto_increment not null,
  pro_nome varchar(100) not null,
  pro_valor double not null,
  pro_estoque int(11) not null,
  primary key(pk_id_produto));
 
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão 7 cordas',2200,20);
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão acustico',1300,20);
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão 12 cordas',15000,20);
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão de aço',800,20);
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão de nylon',600,20);
  insert into tbl_produto (pro_nome,pro_valor,pro_estoque)
values('violão estudante',900,20);            

 
 
  create table tbl_vendas (
  pk_id_vendas smallint auto_increment not null,
  fk_cliente bigint(20) REFERENCES tbl_cliente (pk_id_cliente),
  ven_data_venda date not null,
  ven_valor_liquido double not null,
  ven_valor_bruto double not null,
  ven_desconto double not null,
  primary key(pk_id_vendas));
 
 
 
  CREATE TABLE tbl_vendas_produtos (
  pk_id_venda_produto smallint auto_increment not null,
  fk_produto bigint(20) REFERENCES tbl_produto (pk_id_produto),
  fk_vendas bigint(20) REFERENCES tbl_vendas (pk_id_vendas),
  ven_pro_valor double not null,
  ven_pro_quantidade int(11) not null,
  primary key (pk_id_venda_produto));