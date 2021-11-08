-- Usuario
INSERT INTO Usuario (Nombre, edad, Correo, Contrasenia)
VALUES ('Octavio','22','octavio@correo.cl','octavio');
INSERT INTO Usuario (Nombre, edad, Correo, Contrasenia)
VALUES ('Martin','22','martin@correo.cl','martin');
INSERT INTO Usuario (Nombre, edad, Correo, Contrasenia)
VALUES ('Juan','22','juan@correo.cl','juan');
INSERT INTO Usuario (Nombre, edad, Correo, Contrasenia)
VALUES ('Hugo','22','hugo@correo.cl','hugo');
INSERT INTO Usuario (Nombre, edad, Correo, Contrasenia)
VALUES ('Michael','22','michael@correo.cl','michael');
--Empresa
INSERT INTO Empresa (Nombre, Correo, Contrasenia)
VALUES ('Empresa X','empresax@correo.cl','empresax');
INSERT INTO Empresa (Nombre, Correo, Contrasenia)
VALUES ('Empresa Y','empresay@correo.cl','empresay');
INSERT INTO Empresa (Nombre, Correo, Contrasenia)
VALUES ('Empresa Z','empresaz@correo.cl','empresaz');
INSERT INTO Empresa (Nombre, Correo, Contrasenia)
VALUES ('Empresa W','empresaw@correo.cl','empresaw');
INSERT INTO Empresa (Nombre, Correo, Contrasenia)
VALUES ('Empresa B','empresab@correo.cl','empresab');
--Patologia
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres X','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres Y','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres Z','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres W','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres B','blablabla','blablabla');
--Superusuario
INSERT INTO Superusuario (Nombre, Correo, Contrasenia)
VALUES ('Florencia','florencia@correo.cl','florencia');
INSERT INTO Superusuario (Nombre, Correo, Contrasenia)
VALUES ('Consuelo','consuelo@correo.cl','consuelo');
INSERT INTO Superusuario (Nombre, Correo, Contrasenia)
VALUES ('Magda','magda@correo.cl','magda');
INSERT INTO Superusuario (Nombre, Correo, Contrasenia)
VALUES ('Vari','vari@correo.cl','vari');
--Noticia
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Robot emocional','Robot que refleja y muestra emociones humanas.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Estado emocional','Nuevos estudios del estado emocional de las personas con insomnio.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Clima','El clima de hoy esta fresco como lechuga.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Psicologia','Estudio de unidad de universidad reconocida.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Pandemia','Los nuevos problemas psicologicos que pueden traer los problemas de la pandemia.');
--Chatbot
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Lucy','Afectividad en las personas y el trato de estas.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Mario','Responde de forma concreta y honesta.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Maria','Entrega información valiosa para el usuario.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Luciano','Se pone en el lugar de cada usuario.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Ariel','Un poco de todos los chatbots anteriores.');
--Consejo
INSERT INTO Consejo (Descripcion)
VALUES ('Si respiras en el agua, te ahogas.');
INSERT INTO Consejo (Descripcion)
VALUES ('Si aprietas el gatillo de una pistola, disparas.');
INSERT INTO Consejo (Descripcion)
VALUES ('Si te matan, te mueres.');
INSERT INTO Consejo (Descripcion)
VALUES ('Si caminas, avanzas.');
INSERT INTO Consejo (Descripcion)
VALUES ('Mas vale pajaro en mano que mil picoteandote la cabeza.');
--Sintoma
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Estres','No es dos.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Cansancio','Mucho ejercicio. Ya vaya a descanzar.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Sabrosura','Es un viejo sabroso.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Somnolencia','Duerma bien.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Tick nervioso','No sea nervioso.');
--RespChat
INSERT INTO RespChat( Descripcion)
VALUES ('Sus necesidades no son problema mio.');
INSERT INTO RespChat( Descripcion)
VALUES ('Suavamente besame que quiero sentir tus labios besandome otra vez....SUAVE');
INSERT INTO RespChat( Descripcion)
VALUES ('Albion Online es un mmorpg no lineal en el que puedes escribir tu propia historia');
INSERT INTO RespChat( Descripcion)
VALUES ('¿Esto en que afecta huachipato?');
INSERT INTO RespChat( Descripcion)
VALUES ('Estuve bajo la lluvia 2 horas, 1000 horas, como un perro');
--RespUs
INSERT INTO RespUs(Descripcion)
VALUES ('Eso tilin, baila tilin');
INSERT INTO RespUs(Descripcion)
VALUES ('MIMAMAMEMIMA');
INSERT INTO RespUs(Descripcion)
VALUES ('Entonces dave inteligentemente armo un megafono con una ardilla, una cuerda y un megafono');
INSERT INTO RespUs(Descripcion)
VALUES ('Dime, ¿cuanto es 5 + 6?');
INSERT INTO RespUs(Descripcion)
VALUES ('Flores azules espinas rojas flores azules espinas rojas, seria mas facil si no fuera daltonico');
--Estadistica
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Corrupción latina','Acenso indiscriminado');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Peso venezolano','Descadencia absoluta');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Actividades de la usach','Esta en paro, no se puede');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Habia una vez','truz');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Calidad estudiantil gringa','tiroteo');

/* TABLA CON LLAVES FORANEAS*/


--Usuario_Empresa
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('1','1');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('2','1');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('3','2');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('4','2');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('5','3');
--Empresa_Estadistica
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','1');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','2');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','3');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('2','4');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('2','5');
--Patologia_Sintoma
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('1','2');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('3','4');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('5','2');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('4','3');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('1','5');
--Usuario_Sintoma
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('1','2');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('3','4');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('5','2');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('4','3');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('1','5');
--Usuario_Patologia
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('1','2');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('3','4');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('5','2');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('4','3');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('1','5');
--Usuario_Noticia
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('1','2');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('3','4');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('5','2');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('4','3');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('1','5');
--Superusuario_Estadistica
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('1','2');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('3','4');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('3','2');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('4','3');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('1','4');
--Usuario_Consejo
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('1','2');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('3','4');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('5','2');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('4','3');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('1','5');