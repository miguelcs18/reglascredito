-- Reglas enganche

INSERT INTO REGLAS_MULTIPLICAR VALUES('1','19','','<=','','','1','1');
INSERT INTO REGLAS_MULTIPLICAR VALUES('2','20','35','>=','&&','<=','2','1');
INSERT INTO REGLAS_MULTIPLICAR VALUES('3','36','50','>=','&&','<=','3','1');
INSERT INTO REGLAS_MULTIPLICAR VALUES('4','51','','>','','','4','1');

-- Reglas Plazo

INSERT INTO REGLAS_MULTIPLICAR VALUES('5','72','','==','','','1','2');
INSERT INTO REGLAS_MULTIPLICAR VALUES('6','60','','==','','','2','2');
INSERT INTO REGLAS_MULTIPLICAR VALUES('7','48','','==','','','3','2');
INSERT INTO REGLAS_MULTIPLICAR VALUES('8','36','','<=','','','4','2');

-- Reglas Mensualidad/ingresos

INSERT INTO REGLAS_MULTIPLICAR VALUES('9','2','','<','','','1','3');
INSERT INTO REGLAS_MULTIPLICAR VALUES('10','2','','==','','','2','3');
INSERT INTO REGLAS_MULTIPLICAR VALUES('11','3','','==','','','3','3');
INSERT INTO REGLAS_MULTIPLICAR VALUES('12','3','','>','','','4','3');

--Deudas totales/ ingreso

INSERT INTO REGLAS_MULTIPLICAR VALUES('13','50','','>=','','','1','4');
INSERT INTO REGLAS_MULTIPLICAR VALUES('14','31','49','>=','&&','<=','2','4');
INSERT INTO REGLAS_MULTIPLICAR VALUES('15','21','30','>=','&&','<=','3','4');
INSERT INTO REGLAS_MULTIPLICAR VALUES('16','20','','<=','','','4','4');

-- Edad

INSERT INTO REGLAS_MULTIPLICAR VALUES('17','22','','<=','','','1','5');
INSERT INTO REGLAS_MULTIPLICAR VALUES('18','23','27','>=','&&','<=','2','5');
INSERT INTO REGLAS_MULTIPLICAR VALUES('19','28','39','>=','&&','<=','3','5');
INSERT INTO REGLAS_MULTIPLICAR VALUES('20','40','','>=','','','4','5');

-- Dependientes económicos

INSERT INTO REGLAS_MULTIPLICAR VALUES('21','3','','>','','','1','6');
INSERT INTO REGLAS_MULTIPLICAR VALUES('22','2','3','>=','&&','<=','2','6');
INSERT INTO REGLAS_MULTIPLICAR VALUES('23','1','','==','','','3','6');
INSERT INTO REGLAS_MULTIPLICAR VALUES('24','0','','==','','','4','6');

-- Tiempo en el trabajo

INSERT INTO REGLAS_MULTIPLICAR VALUES('25','1','','<=','','','1','7');
INSERT INTO REGLAS_MULTIPLICAR VALUES('26','1','3','>','&&','<=','2','7');
INSERT INTO REGLAS_MULTIPLICAR VALUES('27','3','4','>','&&','<=','3','7');
INSERT INTO REGLAS_MULTIPLICAR VALUES('28','4','','>','','','4','7');

-- Tiempo en el domicilio

INSERT INTO REGLAS_MULTIPLICAR VALUES('29','1','','<=','','','1','8');
INSERT INTO REGLAS_MULTIPLICAR VALUES('30','1','3','>','&&','<=','2','8');
INSERT INTO REGLAS_MULTIPLICAR VALUES('31','3','4','>','&&','<=','3','8');
INSERT INTO REGLAS_MULTIPLICAR VALUES('32','4','','>','','','4','8');

-- Experiencia en buró

INSERT INTO REGLAS_MULTIPLICAR VALUES('33','639','','<=','','','1','9');
INSERT INTO REGLAS_MULTIPLICAR VALUES('34','640','701','>=','&&','<=','2','9');
INSERT INTO REGLAS_MULTIPLICAR VALUES('35','702','742','>=','&&','<=','3','9');
INSERT INTO REGLAS_MULTIPLICAR VALUES('36','743','','>=','','','4','9');

-- Comprobación ingresos

INSERT INTO REGLAS_MULTIPLICAR VALUES('37','1','','==','','','1','10');
INSERT INTO REGLAS_MULTIPLICAR VALUES('38','2','','==','','','2','10');
INSERT INTO REGLAS_MULTIPLICAR VALUES('39','3','','==','','','3','10');
INSERT INTO REGLAS_MULTIPLICAR VALUES('40','4','','==','','','4','10');


-- Perfil

INSERT INTO PERFIL VALUES ('1','30','0','PerfilCte','<=','','','1','A MEJORAR');
INSERT INTO PERFIL VALUES ('2','31','75','PerfilCte','>=','Y','<=','1','REGULAR');
INSERT INTO PERFIL VALUES ('3','75','100','PerfilCte','>','','','1','BUEN PERFIL');


-- Reglas aritmeticas

INSERT INTO REGLAS_ARITMETICAS VALUES(1,0,'suma','+');
INSERT INTO REGLAS_ARITMETICAS VALUES(2,0,'resta','-');
INSERT INTO REGLAS_ARITMETICAS VALUES(3,0.0208,'mutiplicacion','*');
INSERT INTO REGLAS_ARITMETICAS VALUES(4,1,'division','/');
INSERT INTO REGLAS_ARITMETICAS VALUES(5,100,'multiplicacion','*');
