drop database test;

create database test;

use test;

 CREATE TABLE `PHARMACY`(
       `encounterID` int(9) unsigned zerofill NOT NULL,
       `cardID` varchar(10) , 
       `firstName` varchar(55),
       `lastName` varchar(55),
	   `givenHappyMeal` bit,
   	   `happyMeal` varchar(255),
       `medDispensed1` varchar(55),
       `medDispensed2` varchar(55),
       `medDispensed3` varchar(55),
       `medDispensed4` varchar(55),
       `medDispensed5` varchar(55),
       `equalPrescribed1` bit,
       `equalPrescribed2` bit,
       `equalPrescribed3` bit,
       `equalPrescribed4` bit,
       `equalPrescribed5` bit,
       `creatingUser` varchar(55),
       `createdDate` datetime,
       PRIMARY KEY(`encounterID`),
       UNIQUE KEY `encounterID_UNIQUE` (`encounterID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 CREATE TABLE `ENCOUNTERS` (
       `encounterID` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
       `patientID` int(9) unsigned zerofill NOT NULL,
   	   `cardID` varchar(10) , 
       `chiefComplaint` varchar(255),
       `onsetNumber` int(10),
       `onsetUnit` varchar(55),
       `severity` int(10),
       `radiation` varchar(55),
       `quality` varchar(55),
       `provokes` varchar(55),
       `timeofday` varchar(55),
       `other` varchar(55),
       `medicationPrescribed1` varchar(55),
       `medicationPrescribed2` varchar(55),
       `medicationPrescribed3` varchar(55),
       `medicationPrescribed4` varchar(55),
       `medicationPrescribed5` varchar(55),
       `condition1` varchar(55),
       `condition2` varchar(55),
       `condition3` varchar(55),
       `condition4` varchar(55),
       `condition5` varchar(55),
       `overallImpression` varchar(255),
       `assessment` varchar(255),
       `keywords` varchar(55),
       `medicalProcedures` varchar(255),
       `creatingUser` varchar(55),
       `createdDate` datetime,
       `modifyingUser` varchar(55),
       `lastModifiedDate` datetime,
       PRIMARY KEY (`encounterID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `PATIENTS` (
       `patientID` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
   	   `cardID` varchar(10) , 
       `firstName` varchar(55) NOT NULL,
       `lastName` varchar(55),  
       `birthDate` varchar(55),
   	   `age` varchar(5),
       `gender` varchar(15),
       `isPregers`  bit(1) DEFAULT 0,
       `pregweeks` int(2) unsigned DEFAULT NULL,
       `keywords` varchar(55),
       `residence` varchar(55),
       `socialHistory` varchar(255),
       `creatingUser` varchar(55) DEFAULT NULL,  
       `createdDate` datetime DEFAULT NULL,
       `modifyingUser` varchar(55) DEFAULT NULL,
       `lastModifiedDate` datetime DEFAULT NULL,
       PRIMARY KEY (`patientID`),
       UNIQUE KEY `patientID_UNIQUE` (`patientID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
CREATE TABLE `USERS` (
	  `userID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
	  `firstName` varchar(55) NOT NULL,
	  `lastName` varchar(55) NOT NULL,
	  `userName` varchar(55) NOT NULL,
	  `password` varchar(55) NOT NULL,
	  `roles` varchar(55) NOT NULL,
	  `creatingUser` varchar(55) DEFAULT NULL,
	  `createdDate` datetime DEFAULT NULL,
	  `modifyingUser` varchar(55) DEFAULT NULL,
	  `lastModifiedDate` datetime DEFAULT NULL,
	  PRIMARY KEY (`userID`),
	  UNIQUE KEY `userID_UNIQUE` (`userID`),
	  UNIQUE KEY `username_UNIQUE` (`userName`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
 CREATE TABLE `VITALS` (
       `vitalsID` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
       `encounterID` int(9) unsigned zerofill NOT NULL,
       `systolicBP` int(10) unsigned DEFAULT NULL,
       `diastolicBP` int(10) unsigned DEFAULT NULL,
       `heartRate` int(10) unsigned DEFAULT NULL,
       `respRate` int(10) unsigned DEFAULT NULL,
       `temperatureF` float(6,3) unsigned DEFAULT NULL,
       `bloodSampleID` int(10) unsigned zerofill DEFAULT NULL,
       `bloodSaturation` float(3,1) unsigned DEFAULT NULL,
       `height` int(10) unsigned DEFAULT NULL,
       `weight` int(10) unsigned DEFAULT NULL,
       `calculatedBMI` int(10) unsigned DEFAULT NULL,
       `creatingUser` varchar(55),  
       `createdDate` datetime ,
       `modifyingUser` varchar(55),
       `lastModifiedDate` datetime,
       PRIMARY KEY (`vitalsID`),
       UNIQUE KEY `vitalsID_UNIQUE` (`vitalsID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     
     insert into test.USERS (firstName, lastName, userName, password, roles) values ('Bob', 'Bobson', 'admin', 'cef5729281f29438d09d2aedcacfd607d1cddcc9','System Administrator');
    insert into test.USERS (firstName, lastName, userName, password, roles) values ('SuperUser', '', 'superuser', 'rootadminuser123','System Administrator');
     insert into test.USERS (firstName, lastName, userName, password, roles) values ('Jim', 'Jimerson', 'student', '2eb4ed42db03e48321ae25bab6b68370051921a0','Medical Student');
	 insert into test.USERS (firstName, lastName, userName, password, roles) values ('Frank', 'Frankfurter', 'pharm', '6ccab84e7539afccc64d90e19d9d4abd72968c13','Pharmacist');
	 insert into test.USERS (firstName, lastName, userName, password, roles) values ('Sample', 'McTest', 'research', '43532e0c9726857cc44f5852c1f561335db3dd69','Researcher');