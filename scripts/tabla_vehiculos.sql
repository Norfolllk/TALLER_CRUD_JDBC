CREATE TABLE vehiculos(
    placa VARCHAR(10) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio INT NOT NULL,
    precio decimal NOT NULL, -- double no existe en postgresql, usamos decimal
    color VARCHAR(30),
    disponible BOOLEAN NOT NULL
);

select * from vehiculos;

INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
VALUES ('PDA-1234', 'KIA', 'Soluto', 2020, 18000, 'Blanco', true);
