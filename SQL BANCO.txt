create database fabrica_queijos;

use fabrica_queijos;

create table cliente(

	cpf varchar(14) primary key,
    nome varchar(60),
    telefone varchar(20),
    endereço varchar(60),
    instagram varchar(30),
    email varchar(30),
    facebook varchar(30),
    cartao varchar(20)

);

create table queijo(

	id_queijo varchar(20) primary key,
    lote varchar(20),
    tipo varchar(20),
    valor_venda float,
    peso float,
    data_fabricacao date   

);

create table pedido(

	id_pedido varchar(20) primary key,
    cpf varchar(14),
    data date,
    prazo_entrega integer,
    foreign key (cpf) references cliente(cpf)
    
);
    
create table queijo_pedido(

	id_queijo_pedido varchar(20),
    id_pedido varchar(20),
    id_queijo varchar(20),
    quantidade integer,
    foreign key (id_pedido) references pedido(id_pedido),
    foreign key (id_queijo) references queijo(id_queijo)
    
);

