--Tao bang RECRUIT 
create table RECRUIT (
	companyNo NUMBER NOT NULL,
	departmentNo NUMBER NOT NULL,
  	positionNo NUMBER NOT NULL,
  	numberOfPersonnel NUMBER
);

--Khoa chinh
ALTER TABLE RECRUIT ADD CONSTRAINT PK_RECRUIT PRIMARY KEY (companyNo, departmentNo, positionNo);

--Khoa ngoai
ALTER TABLE RECRUIT ADD CONSTRAINT FK1_RECRUIT FOREIGN KEY (departmentNo) REFERENCES DEPARTMENT(departmentNo);
ALTER TABLE RECRUIT ADD CONSTRAINT FK2_RECRUIT FOREIGN KEY (positionNo) REFERENCES POSITION(positionNo);
ALTER TABLE RECRUIT ADD CONSTRAINT FK3_RECRUIT FOREIGN KEY (companyNo) REFERENCES COMPANY(companyNo);

--Du lieu
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (1,1,5,3);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (1,6,6,1);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (2,2,3,0);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (2,2,4,2);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (4,4,3,1);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (4,7,7,1);
Insert into RECRUIT (COMPANYNO,DEPARTMENTNO,POSITIONNO,NUMBEROFPERSONNEL) values (5,5,2,1);
