CREATE DATABASE  IF NOT EXISTS `musica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `musica`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: musica
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `name` varchar(40) NOT NULL,
  `date` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES ('1',2000),('21',2011),('Abbey Road',1969),('Appetite for Destruction',1987),('Back In Black',1980),('Bad',1987),('Bat Out Of Hell',1977),('Born In tThe USA',1984),('Brothers In Arms',1985),('Come On Over',1997),('Dangerous',1991),('Daydream',1995),('Falling Into You',1996),('Gold: Greatest Hits',1992),('Greatest Hits',1981),('Hotel California',1976),('Hybrid Theory',2000),('Jagged Little Pill',1995),('La Vida Es Bella',2016),('Led Zeppelin ',1971),('Legend: The Best Of Bob Marley & The Wai',1984),('Let`s Talk About Love',1997),('Metallica',1991),('Music Box',1993),('Nevermind',1991),('No Jacket Required',1985),('Rumours',1977),('Saturday Night Fever',1977),('Sgt. Pepper\'s Lonely Hearts Club Band',1967),('Slippery When Wet',1986),('Spice',1996),('Supernatural',1999),('The BodyGuard',1992),('The Dark Side Of The Moon',1973),('The Immaculate Collection',1990),('The Wall',1979),('Their Greatest Hits',1976),('Thriller',1982);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `singer` varchar(40) NOT NULL,
  `genre` varchar(20) NOT NULL,
  PRIMARY KEY (`singer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES ('ABBA','Pop'),('AC/DC','Hard Rock'),('Adele','Pop'),('Alanis Morissette','Rock'),('Bee Gees','Disco'),('Bob Marley','Reggae'),('Bon Jovi','Hard Rock'),('Britney Spears','Pop'),('Bruce Springsteen','Rock'),('Carlos Santana','Rock'),('Celine Dion','Ballad'),('Dire Straits','Rock'),('Eagles','Soft Rock'),('Fleetwood Mac','Romours'),('Gabry Ponte','Italo Dance'),('Gigi D\'Agostino','Italo Dance'),('Guns \'N\' Roses','Hard Rock'),('Led Zeppelin','Hard Rock'),('Linkin Park','Nu Metal'),('Madonna','Pop'),('Mariah Carey','Pop'),('Meat Loaf','Hard Rock'),('Metallica','Hard Rock'),('Michael Bublé','Vocal Jazz'),('Michael Jackson','Pop'),('Nirvana','Rock'),('Phil Collins','Pop'),('Pink Floyd','Progressive Rock'),('Queen','Rock'),('Sandrinhos Brown','Folk'),('Shania Twain','Pop'),('Spice Girls','Pop'),('The Beatles','Rock'),('Tom Jones','Pop'),('U2','Rock'),('Witney Houston','R&B');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `invoicenum` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(8) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`invoicenum`),
  KEY `fk1_idx` (`username`),
  CONSTRAINT `fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'1','2016-06-23'),(2,'11111111','2016-06-23');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoicelines`
--

DROP TABLE IF EXISTS `invoicelines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoicelines` (
  `invoicenum` int(11) NOT NULL,
  `trackname` varchar(20) NOT NULL,
  PRIMARY KEY (`invoicenum`,`trackname`),
  KEY `fk5_idx` (`trackname`),
  CONSTRAINT `fk5` FOREIGN KEY (`trackname`) REFERENCES `track` (`trackname`) ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`invoicenum`) REFERENCES `invoice` (`invoicenum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoicelines`
--

LOCK TABLES `invoicelines` WRITE;
/*!40000 ALTER TABLE `invoicelines` DISABLE KEYS */;
INSERT INTO `invoicelines` VALUES (1,'Billie Jean'),(1,'Brain Damage '),(2,'Breathe'),(2,'Given The Dog A Bone'),(1,'Let Me Put My Love I'),(2,'Let Me Put My Love I'),(1,'Shake A Leg'),(1,'Speak to Me'),(1,'The Girl Is Mine'),(1,'The Great Gig in the'),(2,'The Great Gig in the'),(1,'The Lady In My Life'),(1,'Thriller'),(1,'Time'),(1,'Us and Them  ');
/*!40000 ALTER TABLE `invoicelines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `trackname` varchar(20) NOT NULL,
  `artist` varchar(40) NOT NULL,
  `duration` decimal(3,1) NOT NULL,
  `album` varchar(40) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  PRIMARY KEY (`trackname`),
  KEY `fk2_idx` (`artist`),
  KEY `fk3_idx` (`album`),
  CONSTRAINT `fk2` FOREIGN KEY (`artist`) REFERENCES `artist` (`singer`) ON UPDATE CASCADE,
  CONSTRAINT `fk3` FOREIGN KEY (`album`) REFERENCES `album` (`name`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES ('Any Colour You Like ','Pink Floyd',3.2,'The Dark Side Of The Moon',0.99),('Back In Black','AC/DC',4.1,'Back In Black',0.99),('Be Mine','Michael Jackson',4.0,'Thriller',0.99),('Beat It','Michael Jackson',4.2,'Thriller',0.99),('Billie Jean','Michael Jackson',4.5,'Thriller',0.99),('Brain Damage ','Pink Floyd',3.5,'The Dark Side Of The Moon',0.99),('Breathe','Pink Floyd',2.4,'The Dark Side Of The Moon',0.99),('Eclipse ','Pink Floyd',2.0,'The Dark Side Of The Moon',0.99),('Given The Dog A Bone','AC/DC',3.3,'Back In Black',0.99),('Have A Drink On Me','AC/DC',3.6,'Back In Black',0.99),('Hells Bells','AC/DC',5.1,'Back In Black',0.99),('Human Nature','Michael Jackson',4.1,'Thriller',0.99),('Let Me Put My Love I','AC/DC',4.2,'Back In Black',0.99),('Money','Pink Floyd',6.3,'The Dark Side Of The Moon',0.99),('On the Run','Pink Floyd',3.3,'The Dark Side Of The Moon',0.99),('Rock and Roll Ain\'t ','AC/DC',4.2,'Back In Black',0.99),('Shake A Leg','AC/DC',4.1,'Back In Black',0.99),('Shoot To Thrill','AC/DC',5.2,'Back In Black',0.99),('Speak to Me','Pink Floyd',1.3,'The Dark Side Of The Moon',0.99),('The Girl Is Mine','Michael Jackson',3.4,'Thriller',0.99),('The Great Gig in the','Pink Floyd',4.2,'The Dark Side Of The Moon',0.99),('The Lady In My Life','Michael Jackson',5.0,'Thriller',0.99),('Thriller','Michael Jackson',5.6,'Thriller',0.99),('Time','Pink Floyd',6.5,'The Dark Side Of The Moon',0.99),('Us and Them  ','Pink Floyd',7.5,'The Dark Side Of The Moon',0.99),('Vamos A Ligar ','Sandrinhos Brown',8.8,'La Vida Es Bella',0.99),('Wanna be Startin\' So','Michael Jackson',6.0,'Thriller',0.99),('What Do You Do For M','AC/DC',3.3,'Back In Black',0.99),('You Shook Me All Nig','AC/DC',3.3,'Back In Black',0.99);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(40) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','1','1','1'),('11111111','1','1','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-23 13:45:39
