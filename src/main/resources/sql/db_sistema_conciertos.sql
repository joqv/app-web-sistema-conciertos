create schema db_sistema_conciertos;

use db_sistema_conciertos;

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    ruc VARCHAR(11) UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    estado VARCHAR(20) DEFAULT 'ACTIVO',
    rol VARCHAR(20) NOT NULL DEFAULT 'USUARIO'
);

CREATE TABLE palcos (
    id_palco INT PRIMARY KEY AUTO_INCREMENT,
    nombre_palco VARCHAR(255) NOT NULL,
    aforo INT NOT NULL,
    ubicacion VARCHAR(255),
    estado VARCHAR(20) DEFAULT 'ACTIVO'
);

CREATE TABLE reservas (
    id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_palco INT NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_final TIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
    activo VARCHAR(10) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_palco) REFERENCES palcos(id_palco)
);



DELIMITER //

CREATE PROCEDURE listarUsuariosActivos()
BEGIN
    SELECT * FROM usuarios WHERE estado = 'ACTIVO';
END //

DELIMITER ;



DELIMITER //

CREATE PROCEDURE listarPalcosActivos()
BEGIN
    SELECT * FROM palcos WHERE estado = 'ACTIVO';
END //

DELIMITER ;