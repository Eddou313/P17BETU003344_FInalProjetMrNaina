DROP DATABASE Exam;
CREATE DATABASE Exam;
USE Exam;

create table economie_user(
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    username TEXT,
    mdp TEXT
);

create table economie_prevision(
    id_prevision INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT,
    libelle TEXT,
    montant DECIMAL(10,2),
    FOREIGN KEY (id_user) REFERENCES economie_user(id_user)
);

create table economie_depense(
    id_depense INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT,
    id_prevision INT,
    montant DECIMAL(10,2),
    FOREIGN KEY (id_user) REFERENCES economie_user(id_user),
    FOREIGN KEY (id_prevision) REFERENCES economie_prevision(id_prevision)
);

insert into economie_user (username,mdp) VALUES ("user1@gmail.com","1234"); 