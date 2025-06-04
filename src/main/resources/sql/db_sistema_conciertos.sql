CREATE TABLE IF NOT EXISTS usuarios (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    ruc VARCHAR(11) UNIQUE
);

CREATE TABLE IF NOT EXISTS palcos (
    idPalco INT PRIMARY KEY AUTO_INCREMENT,
    nombrePalco VARCHAR(255) NOT NULL,
    aforo INT NOT NULL,
    ubicacion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS reservas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idUsuario INT NOT NULL,
    idPalco INT NOT NULL,
    fecha DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFinal TIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idPalco) REFERENCES palcos(idPalco)
);