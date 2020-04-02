-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: jpql_and_native_sql
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employeeTable`
--

DROP TABLE IF EXISTS `employeeTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeeTable` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `empFirstName` varchar(20) DEFAULT NULL,
  `empLastName` varchar(20) DEFAULT NULL,
  `empSalary` decimal(10,0) DEFAULT NULL,
  `empAge` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeTable`
--

LOCK TABLES `employeeTable` WRITE;
/*!40000 ALTER TABLE `employeeTable` DISABLE KEYS */;
INSERT INTO `employeeTable` (`empId`, `empFirstName`, `empLastName`, `empSalary`, `empAge`) VALUES (1,'Chirag','Bohet',15000,24),(2,'Ajay','Kumar',13000,24),(3,'Rohan','Gidwani',40000,29),(4,'Arshad','Ansari',60000,25),(5,'Harshit','Halwan',45000,22),(6,'Jayant','Dhawan',5000,23),(7,'Nikhil','Bisht',10000,23),(8,'Chirag','Bohet',15000,24),(9,'Rohit','Nayak',28000,25),(10,'Ravinder','Singh',30000,50);
/*!40000 ALTER TABLE `employeeTable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-02  9:23:41
