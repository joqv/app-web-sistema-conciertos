USE db_sistema_conciertos;

INSERT INTO usuarios (nombre_usuario, telefono, ruc) VALUES
('Juan Pérez', '987654321', '10123456789'),
('María García', '998877665', '10987654321'),
('Carlos Sánchez', '912345678', '10112233445'),
('Ana Torres', '934567890', '10556677889'),
('Luis Ramirez', '956789012', '10998877665');

INSERT INTO palcos (nombre_palco, aforo, ubicacion) VALUES
('Palco VIP Principal', 10, 'Zona A, Fila 1'),
('Palco Lateral Izquierdo', 6, 'Zona B, Sección 2'),
('Palco Lateral Derecho', 6, 'Zona B, Sección 3'),
('Palco Familiar', 8, 'Zona C, Nivel Superior'),
('Palco Ejecutivo', 4, 'Zona A, Fila 2');

INSERT INTO reservas (id_usuario, id_palco, fecha, hora_inicio, hora_final, estado) VALUES
(1, 1, '2025-06-10', '19:00:00', '23:00:00', 'Confirmada'),
(2, 3, '2025-06-12', '18:30:00', '22:30:00', 'Pendiente'),
(3, 2, '2025-06-15', '20:00:00', '00:00:00', 'Confirmada'),
(1, 4, '2025-06-18', '17:00:00', '21:00:00', 'Confirmada'),
(4, 1, '2025-06-20', '19:00:00', '23:00:00', 'Cancelada'),
(5, 5, '2025-06-22', '21:00:00', '01:00:00', 'Confirmada');