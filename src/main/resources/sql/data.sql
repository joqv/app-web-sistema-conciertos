USE db_sistema_conciertos;

-- Insertar roles
INSERT INTO roles (nombre) VALUES ('ADMINISTRADOR'), ('USUARIO');

-- Insertar usuarios
INSERT INTO usuarios (nombre_usuario, telefono, ruc, email, password, estado, rol) VALUES
('Juan Pérez', '987654321', '10123456789', 'juan@example.com', 'juanperez12345', 'ACTIVO', 'ADMINISTRADOR'),
('María García', '998877665', '10987654321', 'maria@example.com', 'mariagarcia12345', 'ACTIVO', 'USUARIO'),
('Carlos Sánchez', '912345678', '10112233445', 'carlos@example.com', 'carlossanchez12345', 'ACTIVO', 'USUARIO'),
('Ana Torres', '934567890', '10556677889', 'ana@example.com', 'anatorres12345', 'ACTIVO', 'USUARIO'),
('Luis Ramirez', '956789012', '10998877665', 'luis@example.com', 'luisramirez12345', 'ACTIVO', 'USUARIO');

-- Insertar palcos
INSERT INTO palcos (nombre_palco, aforo, ubicacion) VALUES
('Palco VIP Principal', 10, 'Zona A, Fila 1'),
('Palco Lateral Izquierdo', 6, 'Zona B, Sección 2'),
('Palco Lateral Derecho', 6, 'Zona B, Sección 3'),
('Palco Familiar', 8, 'Zona C, Nivel Superior'),
('Palco Ejecutivo', 4, 'Zona A, Fila 2');

-- Insertar reservas
INSERT INTO reservas (id_usuario, id_palco, fecha, hora_inicio, hora_final, estado, activo) VALUES
(1, 1, '2025-06-25', '19:00:00', '21:00:00', 'Confirmada', 'ACTIVO'),
(2, 3, '2025-06-27', '18:30:00', '20:30:00', 'Pendiente', 'ACTIVO'),
(3, 2, '2025-06-30', '14:20:00', '16:20:00', 'Confirmada', 'ACTIVO'),
(1, 4, '2025-07-04', '15:0:00', '17:00:00', 'Confirmada', 'ACTIVO'),
(4, 1, '2025-07-05', '10:00:00', '12:00:00', 'Cancelada', 'ACTIVO'),
(5, 5, '2025-07-08', '17:00:00', '19:00:00', 'Confirmada', 'ACTIVO');
