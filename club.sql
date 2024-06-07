CREATE TABLE socio (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
	apellidos VARCHAR(100),
	dni CHAR(9) UNIQUE NOT NULL,
	edad INT,
	direccion VARCHAR(100)
);

INSERT INTO socio(nombre, apellidos, dni, edad, direccion) VALUES
	('Azahara', 'Romero Schulte', '29564481M', 20, 'Calle Seguiriya, 35'),
	('Aitana', 'Romero Schulte', '12345678A', 18, 'Calle Seguiriya, 35'),
	('Carmen', 'Schulte', '87654321C', 52, 'Calle Seguiriya, 25');

CREATE TABLE barco (
	id INT PRIMARY KEY AUTO_INCREMENT,
	matricula VARCHAR(100) UNIQUE NOT NULL,
	marca VARCHAR(100),
	color VARCHAR(100),
	numero_amarre INT,
	cuota DECIMAL(10,2),
	id_socio INT,
	CONSTRAINT fk_id_socio FOREIGN KEY (id_socio) REFERENCES socio(id)
);

INSERT INTO barco(matricula, marca, color, numero_amarre, cuota, id_socio) VALUES
	('12345A', 'Mercedes', 'Negro', 2, 100000.00, 3),
	('54321B', 'BMW', 'Azul', 4, 500000.00, 2),
	('24680P', 'Renault', 'Rojo', 6, 200000.00, 1);


CREATE TABLE salida (
	id INT PRIMARY KEY AUTO_INCREMENT,
	fecha_hora_salida TIMESTAMP,
	destino VARCHAR(100),
	patron_nombre VARCHAR(100),
	id_barco INT,
	CONSTRAINT fk_id_barco FOREIGN KEY (id_barco) REFERENCES barco(id)
);

INSERT INTO salida(fecha_hora_salida, destino, patron_nombre, id_barco) VALUES
	('2024-06-01 08:00:00', 'Isla Bonita', 'Carlos Martinez', 1),
	(' 2024-06-02 09:30:00', 'Puerto Azul', 'Ana Lopez', 2),
	('2024-06-03 15:45:00', 'Playa Dorada', 'Luis Fernandez', 3);