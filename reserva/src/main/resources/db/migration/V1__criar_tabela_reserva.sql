CREATE TABLE reserva (
 id SERIAL PRIMARY KEY,
 data_hora TIMESTAMP NOT NULL,
 sala_id INT NOT NULL,
 usuario_id INT NOT NULL

);

-- Impede reservas duplicadas para a mesma sala no mesmo horário
CREATE UNIQUE INDEX uq_reserva_sala_datahora
    ON reserva (sala_id, data_hora);
