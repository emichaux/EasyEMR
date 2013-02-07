drop database raptor;

create database raptor;  

use raptor;

 CREATE TABLE `PHARMACY`(
       `encounterID` int(9) unsigned zerofill NOT NULL,
       `firstName` varchar(55),
       `lastName` varchar(55),
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
       PRIMARY KEY (`encounterID`),
       UNIQUE KEY `encounterID_UNIQUE` (`encounterID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `PATIENTS` (
       `patientID` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
       `firstName` varchar(55) NOT NULL,
       `lastName` varchar(55),  
       `birthDate` varchar(55),
       `gender` varchar(15),
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
       `oximetry` int(10) unsigned DEFAULT NULL,
       `malaria` bit(1) DEFAULT NULL,
       `dengue` bit(1) DEFAULT NULL,
       `bloodSampleID` int(10) unsigned zerofill DEFAULT NULL,
       `height` int(10) unsigned DEFAULT NULL,
       `weight` int(10) unsigned DEFAULT NULL,
       `calculatedBMI` int(10) unsigned DEFAULT NULL,
       `creatingUser` varchar(55),  
       `createdDate` datetime ,
       `modifyingUser` varchar(55),
       `lastModifiedDate` datetime,
       PRIMARY KEY (`vitalsID`),
       UNIQUE KEY `encounterID_UNIQUE` (`encounterID`),
       UNIQUE KEY `vitalsID_UNIQUE` (`vitalsID`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     
     insert into raptor.USERS (firstName, lastName, userName, password, roles) values ('bob', 'bobson', 'admin', 'cef5729281f29438d09d2aedcacfd607d1cddcc9','System Administrator');
     insert into raptor.USERS (firstName, lastName, userName, password, roles) values ('jim', 'jimerson', 'student', '2eb4ed42db03e48321ae25bab6b68370051921a0','Medical Student');
	 insert into raptor.USERS (firstName, lastName, userName, password, roles) values ('frank', 'frankfurter', 'pharm', '6ccab84e7539afccc64d90e19d9d4abd72968c13','Pharmacist');
	 insert into raptor.USERS (firstName, lastName, userName, password, roles) values ('sample', 'mcTest', 'research', '43532e0c9726857cc44f5852c1f561335db3dd69','Researcher');