select placa, marca, modelo, anio, precio, color, disponible from vehiculos;

update vehiculos set
marca = 'KIA',
modelo = 'Sportage',
anio = 2012,
precio = 11000,
color = 'azul',
disponible = true
where placa = 'PDA-1236';

delete from vehiculos where placa = 'PDA-1235';

ALTER TABLE vehiculos
ADD kilometraje INT;

select * from vehiculos;