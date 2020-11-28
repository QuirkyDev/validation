CREATE TABLE IF NOT EXISTS gebruiker (
    id int not null AUTO_INCREMENT,
    voornaam varchar(50) not null,
    familienaam varchar(50) not null,
    email varchar(100) not null,
    primary key (id)
);

insert into gebruiker (voornaam, familienaam, email)
values ('Joeri', 'Verlooy', 'joeri.verlooy@thomasmore.be');