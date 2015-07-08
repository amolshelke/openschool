CREATE DATABASE  IF NOT EXISTS `commhub` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `commhub`;
-- MySQL dump 10.13  Distrib 5.5.32, for Linux (i686)
--
-- Host: 192.168.0.120    Database: commhub
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `raw_messages`
--

DROP TABLE IF EXISTS `raw_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raw_messages` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `MSG` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sms_config`
--

DROP TABLE IF EXISTS `sms_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORG_ID` varchar(15) NOT NULL,
  `URL` varchar(200) NOT NULL,
  `UID` varchar(100) NOT NULL,
  `PIN` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sms_inbox`
--

DROP TABLE IF EXISTS `sms_inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_inbox` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORG_CODE` varchar(45) DEFAULT NULL,
  `ROUTE` int(11) DEFAULT NULL,
  `MOBILE` varchar(45) DEFAULT NULL,
  `RAW_MSG_ID` int(11) DEFAULT NULL,
  `MSG_ID` varchar(45) DEFAULT NULL,
  `MSG_PUSH_ID` varchar(45) DEFAULT NULL,
  `MSG_STATUS` enum('SENT','DELIVERED','DND','FAILED','PROCESSING') DEFAULT NULL,
  `SENT_ON` datetime DEFAULT NULL,
  `DELEVERED_ON` datetime DEFAULT NULL,
  `DEL_FLG` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RAW_MSG_ID_FK_idx` (`RAW_MSG_ID`),
  CONSTRAINT `RAW_MSG_ID_FK` FOREIGN KEY (`RAW_MSG_ID`) REFERENCES `raw_messages` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-08 16:29:59