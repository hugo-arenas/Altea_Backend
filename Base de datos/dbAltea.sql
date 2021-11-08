/* Proyecto Altea Emotional
    GRUPO 2
    Script base de datos 
*/
CREATE TABLE Empresa(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Correo varchar(100),
    Contraseña varchar(100)
);


CREATE TABLE Patologia(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100),
    recomendacion varchar(100)
);

CREATE TABLE Superusuario(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Correo varchar(100),
    Contraseña varchar(100)
);

CREATE TABLE Noticia(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

CREATE TABLE Chatbot(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);


CREATE TABLE Consejo(
    ID SERIAL PRIMARY KEY,
    Descripcion varchar(100)
);

CREATE TABLE Sintomas(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

/*Tabla Respuesta Chatbot*/
CREATE TABLE RespChat(
    ID SERIAL PRIMARY KEY,
    Descripcion varchar(100)
);

/*Tabla Respuesta usuario*/
CREATE TABLE RespUs(
    ID SERIAL PRIMARY KEY,
    Descripcion varchar(100)
);

CREATE TABLE Usuario(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    edad int,
    Correo varchar(100),
    Contraseña varchar(100)
);

CREATE TABLE Estadistica(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripción varchar(100)
);

/* TABLA CON LLAVES FORANEAS*/

CREATE TABLE Usuario_Empresa(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Empresa SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Empresa) REFERENCES Empresa (id)
);

CREATE TABLE Empresa_Estadistica(
    id SERIAL PRIMARY KEY,

    id_Empresa SERIAL,
    id_Estadistica SERIAL,
    FOREIGN KEY (id_Empresa) REFERENCES Empresa (id),
    FOREIGN KEY (id_Estadistica) REFERENCES Estadistica (id)
);


CREATE TABLE Patologia_Sintomas(
    id SERIAL PRIMARY KEY,

    id_Patologia SERIAL,
    id_Sintomas SERIAL,
    FOREIGN KEY (id_Patologia) REFERENCES Patologia (id),
    FOREIGN KEY (id_Sintomas) REFERENCES Sintomas (id)
);

CREATE TABLE Usuario_Sintoma(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Sintoma SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Sintoma) REFERENCES Sintoma (id)
);

CREATE TABLE Usuario_Patologia(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Patologia SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Patologia) REFERENCES Patologia (id)
);

CREATE TABLE Usuario_Noticia(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Noticia SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Noticia) REFERENCES Noticia (id)
);

CREATE TABLE Superusuario_Estadistica(
    id SERIAL PRIMARY KEY,

    id_Superusuario SERIAL,
    id_Estadistica SERIAL,
    FOREIGN KEY (id_Superusuario) REFERENCES Superusuario (id),
    FOREIGN KEY (id_Estadistica) REFERENCES Estadistica (id)
);

CREATE TABLE Usuario_Consejo(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Consejo SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Consejo) REFERENCES Consejo (id)
);

