CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    ruc VARCHAR(11) UNIQUE
);

CREATE TABLE IF NOT EXISTS palcos (
    id_palco INT PRIMARY KEY AUTO_INCREMENT,
    nombre_palco VARCHAR(255) NOT NULL,
    aforo INT NOT NULL,
    ubicacion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS reservas (
    id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_palco INT NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_final TIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_palco) REFERENCES palcos(id_palco)
);