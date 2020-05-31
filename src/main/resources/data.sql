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