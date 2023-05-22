DROP DATABASE IF EXISTS participantes;
CREATE database participantes;
use participantes;
create table datos(
nombre varchar (30) primary key,
apellidos varchar (50),
telefono int,
idolo varchar (50));

insert into datos values("Rosa","Fernandez Gomez",111111111,"Lebron James");
insert into datos values("Juan","Garcia Tejero",222222222,"Stephen Curry");
insert into datos values("Antonio","Sanchez Perez",333333333,"Luka Doncic");
select * from datos order by nombre;
