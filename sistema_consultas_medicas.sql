-- Criar o banco
CREATE DATABASE IF NOT EXISTS sistema_consultas_medicas;
USE sistema_consultas_medicas;

CREATE TABLE paciente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    data_nascimento DATE
);


CREATE TABLE medico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(20)
);


CREATE TABLE consulta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    data_consulta DATETIME NOT NULL,
    observacoes TEXT,
    
    CONSTRAINT fk_consulta_paciente FOREIGN KEY (paciente_id)
        REFERENCES paciente(id) ON DELETE CASCADE,
    CONSTRAINT fk_consulta_medico FOREIGN KEY (medico_id)
        REFERENCES medico(id) ON DELETE CASCADE
);

CREATE TABLE receita (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consulta_id BIGINT NOT NULL,
    medicamentos TEXT NOT NULL,
    posologia TEXT NOT NULL,
    CONSTRAINT fk_receita_consulta FOREIGN KEY (consulta_id)
        REFERENCES consulta(id) ON DELETE CASCADE
);

INSERT INTO paciente (nome, cpf, email, telefone, endereco, data_nascimento)
VALUES
('João da Silva', '111.111.111-11', 'joao@example.com', '11999999999', 'Rua A, 123', '1990-05-10'),
('Maria Oliveira', '222.222.222-22', 'maria@example.com', '21988888888', 'Av B, 456', '1985-08-22');

INSERT INTO medico (nome, crm, especialidade, email, telefone)
VALUES
('Dr. Roberto Mendes', '123456', 'Cardiologia', 'roberto@hospital.com', '11988887777'),
('Dra. Ana Souza', '654321', 'Dermatologia', 'ana@hospital.com', '11999887766');

INSERT INTO consulta (paciente_id, medico_id, data_consulta, status, observacoes)
VALUES
(1, 1, '2025-01-15 14:30:00', 'AGENDADA', 'Paciente relatou dor no peito.'),
(2, 2, '2025-01-16 10:00:00', 'AGENDADA', 'Consulta de rotina dermatológica.'),
(1, 2, '2025-01-20 09:00:00', 'AGENDADA', 'Consulta para avaliação de manchas na pele.'),
(2, 1, '2025-01-25 11:00:00', 'CANCELADA', 'Paciente cancelou por conflito de horário.');

INSERT INTO receita (consulta_id, medicamentos, posologia)
VALUES
(1,
 'AAS 100mg; Losartana 50mg',
 'AAS: tomar 1 comprimido ao dia pela manhã.
  Losartana: 1 comprimido a cada 12 horas.'
),

(2,
 'Pomada de Hidrocortisona 1%; Protetor Solar FPS 50',
 'Hidrocortisona: aplicar 2x ao dia por 7 dias.
  Protetor solar: aplicar a cada 3 horas durante o dia.'
),

(3,
 'Cetirizina 10mg; Creme antifúngico',
 'Cetirizina: tomar 1 comprimido à noite por 10 dias.
  Creme: aplicar na área afetada 2x ao dia por 14 dias.'
),

(4,
 'Nenhum medicamento prescrito (consulta cancelada)',
 'Sem posologia.');

