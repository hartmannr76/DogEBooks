CREATE DATABASE  IF NOT EXISTS `pkasperek` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pkasperek`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: pkasperek
-- ------------------------------------------------------
-- Server version	5.5.21

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
-- Table structure for table `yumexercisehistory`
--

DROP TABLE IF EXISTS `yumexercisehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumexercisehistory` (
  `idyumexercisehistory` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `exercise_id` int(11) DEFAULT NULL,
  `dateExercised` date DEFAULT NULL,
  `caloriesBurned` int(11) DEFAULT NULL,
  PRIMARY KEY (`idyumexercisehistory`),
  KEY `yumexercisehistoryuser_id` (`user_id`),
  KEY `yumexercisehistoryexercise_id` (`exercise_id`),
  CONSTRAINT `yumexercisehistoryexercise_id` FOREIGN KEY (`exercise_id`) REFERENCES `yumexercise` (`idyumexercise`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `yumexercisehistoryuser_id` FOREIGN KEY (`user_id`) REFERENCES `yumuseraccount` (`idyumUserAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumexercisehistory`
--

LOCK TABLES `yumexercisehistory` WRITE;
/*!40000 ALTER TABLE `yumexercisehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `yumexercisehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemwithauthor`
--

DROP TABLE IF EXISTS `itemwithauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemwithauthor` (
  `iditemwithAuthor` int(11) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditemwithAuthor`),
  KEY `itemauthor_id` (`author_id`),
  KEY `itemitem_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemwithauthor`
--

LOCK TABLES `itemwithauthor` WRITE;
/*!40000 ALTER TABLE `itemwithauthor` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemwithauthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ebook`
--

DROP TABLE IF EXISTS `ebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebook` (
  `digitalRightsInformation` text,
  `edition` int(11) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `item_id` int(11) NOT NULL,
  `availableCopies` int(11) DEFAULT NULL,
  `libraryCopies` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `EBookItemId` (`item_id`),
  CONSTRAINT `EBookItemId` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebook`
--

LOCK TABLES `ebook` WRITE;
/*!40000 ALTER TABLE `ebook` DISABLE KEYS */;
INSERT INTO `ebook` VALUES (NULL,1234,'1234',1,10,10),(NULL,1235,'1235',2,10,10),(NULL,1244,'1244',3,10,10),(NULL,1434,'1434',4,10,10),(NULL,2234,'2234',5,10,10),(NULL,1239,'1239',6,10,10),(NULL,1230,'1230',7,10,10),(NULL,1634,'1634',8,10,10),(NULL,1454,'1454',9,10,10),(NULL,9234,'9234',10,10,10),(NULL,1,'6414',11,10,10),(NULL,1,'2051',12,10,10),(NULL,1,'7641',13,10,10),(NULL,1,'5762',14,10,10),(NULL,1,'6329',15,10,10),(NULL,1,'9543',16,10,10),(NULL,1,'5406',17,10,10),(NULL,1,'2331',18,10,10),(NULL,1,'6265',19,10,10),(NULL,1,'7642',20,10,10),(NULL,1,'2000',21,10,10),(NULL,1,'2001',22,10,10),(NULL,1,'2002',23,10,10),(NULL,1,'2003',24,10,10),(NULL,1,'2004',25,10,10),(NULL,1,'2005',26,10,10),(NULL,1,'2006',27,10,10),(NULL,1,'2007',28,10,10),(NULL,1,'2008',29,10,10),(NULL,1,'2009',30,10,10),(NULL,1,'2010',31,10,10),(NULL,1,'2011',32,10,10),(NULL,1,'2012',33,10,10),(NULL,1,'2013',34,10,10),(NULL,1,'2014',35,10,10),(NULL,1,'2015',36,10,10),(NULL,1,'2016',37,10,10),(NULL,1,'2017',38,10,10),(NULL,1,'2018',39,10,10),(NULL,1,'2019',40,10,10),(NULL,1,'2020',41,10,10),(NULL,1,'2021',42,10,10),(NULL,1,'2022',101,10,10);
/*!40000 ALTER TABLE `ebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyitnow`
--

DROP TABLE IF EXISTS `buyitnow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyitnow` (
  `idBuyItNow` int(11) NOT NULL,
  `nameOfPlaceOfPurchase` varchar(45) DEFAULT NULL,
  `urlOfBookPurchase` varchar(45) DEFAULT NULL,
  `buyItNowInformation` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBuyItNow`),
  KEY `BuyItNowItemId` (`item_id`),
  CONSTRAINT `BuyItNowItemId` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyitnow`
--

LOCK TABLES `buyitnow` WRITE;
/*!40000 ALTER TABLE `buyitnow` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyitnow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffmessagehistory`
--

DROP TABLE IF EXISTS `staffmessagehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staffmessagehistory` (
  `idstaffmessagehistory` int(11) NOT NULL,
  `message_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idstaffmessagehistory`),
  KEY `staffmessagehistorymessage_id` (`message_id`),
  KEY `staffmessagehistoryuser_id` (`idstaffmessagehistory`),
  KEY `staffmessagehistoryuseraccount_id` (`user_id`),
  CONSTRAINT `staffmessagehistorymessage_id` FOREIGN KEY (`message_id`) REFERENCES `staffmessage` (`idStaffMessage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staffmessagehistoryuseraccount_id` FOREIGN KEY (`user_id`) REFERENCES `staffaccount` (`idStaffAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffmessagehistory`
--

LOCK TABLES `staffmessagehistory` WRITE;
/*!40000 ALTER TABLE `staffmessagehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `staffmessagehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_accounts`
--

DROP TABLE IF EXISTS `publisher_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher_accounts` (
  `username` text,
  `password` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_accounts`
--

LOCK TABLES `publisher_accounts` WRITE;
/*!40000 ALTER TABLE `publisher_accounts` DISABLE KEYS */;
INSERT INTO `publisher_accounts` VALUES ('jon','snarfcats',1),('ricky','midgets',2),('piotr','friggafross',3),('charles','charles',4),('kevin','kevin',5);
/*!40000 ALTER TABLE `publisher_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yumuseraccount`
--

DROP TABLE IF EXISTS `yumuseraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumuseraccount` (
  `idyumUserAccount` int(11) NOT NULL AUTO_INCREMENT,
  `startingWeight` int(11) DEFAULT NULL,
  `currentWeight` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `mobileNumber` varchar(45) DEFAULT NULL,
  `profileImage` varchar(45) DEFAULT NULL,
  `dailyCalorieGoal` int(11) DEFAULT NULL,
  `goalWeight` int(11) DEFAULT NULL,
  `dateRegistered` date DEFAULT NULL,
  `privilege` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idyumUserAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumuseraccount`
--

LOCK TABLES `yumuseraccount` WRITE;
/*!40000 ALTER TABLE `yumuseraccount` DISABLE KEYS */;
INSERT INTO `yumuseraccount` VALUES (1,200,190,'test','test@test.com','test','test','catscats','16319876543','default.png',1800,160,NULL,NULL),(8,140,140,'msnarf','mikal@mikal.com','Mikal','Snarf','mikal','','default.png',2000,150,NULL,NULL),(9,130,130,'cpetry','chuckles450@gmail.com','Charles','Petry','1936','6318823639','default.png',3000,145,NULL,NULL),(10,NULL,NULL,'admin',NULL,'admin','admin','adminpassword',NULL,NULL,NULL,NULL,NULL,'ADMIN'),(11,190,190,'dyummies','ralphie@yahoo.com','djdiddles','yummies','6245','3252452523','default.png',190,190,NULL,NULL),(12,205,205,'jdeagro','jondeagro@yahoo.com','Jon','DeAgro','1337','6316667777','techtrends.jpg',1900,190,NULL,NULL),(13,180,180,'akonstant','silvernblack2418@aol.com','Alex','Konstant','1234567890','631-897','default.png',4000,190,NULL,NULL),(14,170,170,'tscarlatos','tony@cs.sunysb.edu','tony','scarlatos','9370','','TS.jpg',1500,160,NULL,NULL);
/*!40000 ALTER TABLE `yumuseraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffmessage`
--

DROP TABLE IF EXISTS `staffmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staffmessage` (
  `idStaffMessage` int(11) NOT NULL,
  `textOfMessage` varchar(45) DEFAULT NULL,
  `dateOfMessage` datetime DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStaffMessage`),
  KEY `AuthorId` (`author_id`),
  CONSTRAINT `AuthorId` FOREIGN KEY (`author_id`) REFERENCES `staffaccount` (`idStaffAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffmessage`
--

LOCK TABLES `staffmessage` WRITE;
/*!40000 ALTER TABLE `staffmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `staffmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `award`
--

DROP TABLE IF EXISTS `award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `award` (
  `idAward` int(11) NOT NULL,
  `awardName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAward`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `award`
--

LOCK TABLES `award` WRITE;
/*!40000 ALTER TABLE `award` DISABLE KEYS */;
/*!40000 ALTER TABLE `award` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yumfoodhistory`
--

DROP TABLE IF EXISTS `yumfoodhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumfoodhistory` (
  `idyumfoodhistory` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  `dateEaten` date DEFAULT NULL,
  `calories` int(11) DEFAULT '0',
  PRIMARY KEY (`idyumfoodhistory`),
  KEY `foodhistoryuser_id` (`user_id`),
  KEY `foodhistoryfood_id` (`food_id`),
  KEY `yumfoodhistoryuser_id` (`user_id`),
  KEY `yumfoodhistoryfood_id` (`food_id`),
  CONSTRAINT `yumfoodhistoryfood_id` FOREIGN KEY (`food_id`) REFERENCES `yumfood` (`idyumFood`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `yumfoodhistoryuser_id` FOREIGN KEY (`user_id`) REFERENCES `yumuseraccount` (`idyumUserAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumfoodhistory`
--

LOCK TABLES `yumfoodhistory` WRITE;
/*!40000 ALTER TABLE `yumfoodhistory` DISABLE KEYS */;
INSERT INTO `yumfoodhistory` VALUES (16,1,28,'2012-05-02',515),(22,1,2,'2012-05-03',220),(23,1,25,'2012-05-03',474),(24,1,16,'2012-05-03',540),(26,1,25,'2012-05-03',474),(27,1,26,'2012-05-03',511),(28,1,15,'2012-05-03',77),(29,1,1,'2012-05-03',310),(30,1,22,'2012-05-03',77),(32,1,23,'2012-05-03',306),(33,1,24,'2012-05-03',181),(34,1,24,'2012-05-03',181),(35,1,27,'2012-05-03',511),(36,1,1,'2012-05-03',310),(37,1,1,'2012-05-03',310),(38,1,2,'2012-05-03',220),(39,1,2,'2012-05-03',220),(40,1,8,'2012-05-03',80),(44,1,25,'2012-05-03',474),(45,13,10,'2012-05-03',114),(46,13,1,'2012-05-03',310),(47,13,25,'2012-05-03',474),(50,1,21,'2012-05-03',210),(51,1,4,'2012-05-04',156),(53,1,1,'2012-05-04',310),(54,1,146,'2012-05-04',555),(55,1,143,'2012-05-04',186),(56,1,6,'2012-05-04',280),(57,1,15,'2012-05-04',77),(58,1,16,'2012-05-04',540),(59,12,30,'2012-05-04',412),(60,12,28,'2012-05-04',515),(61,12,1,'2012-05-04',310),(62,12,10,'2012-05-04',114),(63,12,15,'2012-05-04',77),(64,12,18,'2012-05-04',280),(65,12,32,'2012-05-09',505),(66,12,32,'2012-05-09',505),(67,12,4,'2012-05-09',156),(68,12,74,'2012-05-09',80),(69,12,74,'2012-05-09',80),(70,12,18,'2012-05-09',280),(71,12,15,'2012-05-09',77),(72,14,1,'2012-05-10',310),(73,9,2,'2012-05-11',220),(74,9,25,'2012-05-11',474),(75,12,1,'2012-05-13',310),(76,12,1,'2012-05-13',310),(77,12,6,'2012-05-13',280),(78,12,2,'2012-05-13',220),(126,12,12,'2012-05-14',13),(127,12,4,'2012-05-14',156),(128,12,6,'2012-05-14',280),(129,12,7,'2012-05-14',170),(130,12,10,'2012-05-14',114),(131,12,12,'2012-05-14',13),(132,12,28,'2012-05-14',515),(133,12,74,'2012-05-14',80),(134,12,74,'2012-05-14',80),(135,12,75,'2012-05-14',80),(136,12,75,'2012-05-14',80),(137,12,67,'2012-05-14',100),(138,12,73,'2012-05-14',130),(139,12,62,'2012-05-14',240),(140,12,65,'2012-05-14',80),(141,12,1,'2012-05-14',310),(142,12,4,'2012-05-14',156),(143,12,6,'2012-05-14',280),(144,12,7,'2012-05-14',170),(145,12,9,'2012-05-14',100),(146,12,10,'2012-05-14',114),(147,12,12,'2012-05-14',13),(148,12,14,'2012-05-14',25),(149,12,35,'2012-05-14',84),(150,12,35,'2012-05-14',84),(151,12,36,'2012-05-14',139),(152,12,37,'2012-05-14',77),(153,12,77,'2012-05-14',380),(154,12,2,'2012-05-14',220),(155,12,146,'2012-05-14',555),(156,12,134,'2012-05-14',19),(157,12,144,'2012-05-14',186),(158,12,146,'2012-05-14',555),(159,12,1,'2012-05-14',310),(160,12,7,'2012-05-14',170),(161,12,1,'2012-05-14',310),(162,1,17,'2012-07-05',360);
/*!40000 ALTER TABLE `yumfoodhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `idUserLibraryCode` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userMobileNumber` varchar(45) DEFAULT NULL,
  `userProfileImage` varchar(45) DEFAULT NULL,
  `userFirstName` varchar(45) DEFAULT NULL,
  `userLastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUserLibraryCode`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` VALUES (1,'rhartmann','hartmannr76@gmail.com','test','1112223333',NULL,'Ricky','Hartmann'),(2,'jTest','test@gmail.com','12345','','','Test','Tester'),(3,'newTest','newTest@gmail.com','12345','','','New','Tester'),(5,'kevchu','bob@goole.com','test','324666','','bob','bob'),(8,'newMember','testIt@gmai.com','test','1111111111','','New','Member'),(9,'testacct','ikevinci@gmail.com','test','55555','','test','acct'),(10,'newTester','test@gmail.com','12345','123456789','','New','Guy');
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_checkedout`
--

DROP TABLE IF EXISTS `publisher_checkedout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher_checkedout` (
  `userID` text,
  `title` text,
  `author` text,
  `url` text,
  `ISBN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_checkedout`
--

LOCK TABLES `publisher_checkedout` WRITE;
/*!40000 ALTER TABLE `publisher_checkedout` DISABLE KEYS */;
INSERT INTO `publisher_checkedout` VALUES ('jon','Knit Two','Author 2','/items/1244.pdf',1244),('jon','Simmer Down','Author 8','/items/9234.pdf',9234),('jon','Under the Banner of Heaven','Author 1','../Amazoink/items/1234.pdf',1234),('jon','Under the Banner of Heaven','Author 1','../Amazoink/items/1234.pdf',1234),('jon','Under the Banner of Heaven','Author 1','../Amazoink/items/1234.pdf',1234),('jon','Simmer Down','Author 8','../Amazoink/items/9234.pdf',9234),('jon','Free Culture','Author 5','../Amazoink/items/1434.pdf',1434),('jon','Free Culture','Author 5','../Amazoink/items/1434.pdf',1434),('jon','American Sniper','Author 7','../Amazoink/items/1634.pdf',1634),('ricky','Knit Two','Author 2','../Amazoink/items/1244.pdf',1244),('kevin','A Polish Boy and His President','Piotr Kasperek','../Amazoink/items/2022.pdf',2022),('ricky','Under the Banner of Heaven','Author 1','../Amazoink/items/1234.pdf',1234);
/*!40000 ALTER TABLE `publisher_checkedout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_items`
--

DROP TABLE IF EXISTS `publisher_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher_items` (
  `isbn` int(11) NOT NULL,
  `title` text,
  `author` text,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_items`
--

LOCK TABLES `publisher_items` WRITE;
/*!40000 ALTER TABLE `publisher_items` DISABLE KEYS */;
INSERT INTO `publisher_items` VALUES (1230,'Last Writes','Author 4'),(1234,'Under the Banner of Heaven','Author 1'),(1235,'The Beauty and the Sorrow','Author 3'),(1239,'Seven Keys to Unlock Autism','Author 4'),(1244,'Knit Two','Author 2'),(1434,'Free Culture','Author 5'),(1454,'Shop til You Drop','Author 9'),(1634,'American Sniper','Author 7'),(2000,'Super Cleanse','Adina Niemerow'),(2001,'A Week to Be Wicked','Tessa Dare'),(2002,'Citizens of London','Lynne Olson'),(2003,'Made in Marseille','Daniel Young'),(2004,'Chocolate-Covered Eyes','Lori R. Lopez'),(2005,'Do Bananas Chew Gum?','Jamie Gilson'),(2006,'Practicing Science Fiction','Karen Hellekson'),(2007,'Bruno, Chief of Police','Martin Walker'),(2008,'Ten Poems to Say Goodbye','Roge Housden'),(2009,'The Big Bing','Stanley Bing'),(2010,'Religion for Atheists','Alain de Botton'),(2011,'All Else Confusion','Betty Neels'),(2012,'Partials','Dan Wells'),(2013,'Being with Dieing','Joan Halifax'),(2014,'The Emerald Diamond','Charley Rosen'),(2015,'Algebra','Denise Szecsei'),(2016,'Simon Says Die','Lena Diaz'),(2017,'Londoners','Craig Taylor'),(2018,'Dylan','C. H. Admirand'),(2019,'Data-Driven Marketing','Mark Jeffery'),(2020,'Do More Faster','Brad Feld'),(2021,'Why Nations Fail','James Robinson'),(2022,'A Polish Boy and His President','Piotr Kasperek'),(2234,'Rome','Author 6'),(9234,'Simmer Down','Author 8');
/*!40000 ALTER TABLE `publisher_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercheckouthistory`
--

DROP TABLE IF EXISTS `usercheckouthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercheckouthistory` (
  `idUserCheckoutHistory` int(11) NOT NULL AUTO_INCREMENT,
  `timeOfCheckout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `useraccount_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `itemDueDate` datetime DEFAULT NULL,
  `formatOfItem` int(11) DEFAULT NULL,
  `itemReturnDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idUserCheckoutHistory`),
  KEY `usercheckouthistoryitem_id` (`item_id`),
  KEY `usercheckouthistoryuser_id` (`useraccount_id`),
  CONSTRAINT `usercheckouthistoryitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `usercheckouthistoryuser_id` FOREIGN KEY (`useraccount_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercheckouthistory`
--

LOCK TABLES `usercheckouthistory` WRITE;
/*!40000 ALTER TABLE `usercheckouthistory` DISABLE KEYS */;
INSERT INTO `usercheckouthistory` VALUES (3,'2012-04-30 20:50:34',1,10,'2012-05-14 12:58:14',NULL,'2012-04-30 16:50:45'),(4,'2012-05-07 04:49:33',1,5,'2012-05-14 12:58:14',NULL,'2012-05-07 00:49:03'),(5,'2012-05-07 04:49:37',1,1,'2012-05-14 14:55:03',NULL,'2012-05-07 00:49:08'),(6,'2012-05-07 04:49:36',1,6,'2012-05-14 14:58:12',NULL,'2012-05-07 00:49:07'),(7,'2012-04-30 19:43:52',2,1,'2012-05-14 15:43:55',NULL,NULL),(8,'2012-04-30 19:59:07',2,8,'2012-05-14 15:59:10',NULL,NULL),(9,'2012-04-30 21:27:48',5,1,'2012-05-14 17:26:58',NULL,'2012-04-30 17:27:59'),(10,'2012-05-07 04:50:47',1,8,'2012-05-21 00:50:15',NULL,'2012-05-07 00:50:17'),(11,'2012-05-09 07:13:00',1,27,'2012-05-23 03:12:22',NULL,'2012-05-09 03:12:24'),(13,'2012-05-11 09:02:53',1,96,'2012-05-25 05:02:57',NULL,NULL),(14,'2012-05-11 09:03:16',1,42,'2012-05-25 05:03:20',NULL,NULL),(15,'2012-05-11 19:55:31',9,101,'2012-05-25 15:53:31',NULL,'2012-05-11 15:56:00'),(16,'2012-09-24 23:47:27',1,1,'2012-10-08 19:47:27',NULL,NULL),(17,'2012-09-24 23:47:27',1,44,'2012-10-08 19:47:27',NULL,NULL),(18,'2012-12-13 19:25:32',1,1,'2012-12-14 10:29:11',NULL,'2012-12-13 14:25:34'),(19,'2012-11-30 15:29:35',1,101,'2012-12-14 10:29:37',NULL,NULL),(20,'2012-11-30 15:29:56',1,11,'2012-12-14 10:29:57',NULL,NULL);
/*!40000 ALTER TABLE `usercheckouthistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yumexercise`
--

DROP TABLE IF EXISTS `yumexercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumexercise` (
  `idyumexercise` int(11) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(45) DEFAULT NULL,
  `caloriesBurnedPerPoundPerHour` int(11) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idyumexercise`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumexercise`
--

LOCK TABLES `yumexercise` WRITE;
/*!40000 ALTER TABLE `yumexercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `yumexercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcartitem`
--

DROP TABLE IF EXISTS `shoppingcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcartitem` (
  `idShoppingCartItem` int(11) NOT NULL,
  `dateAddedToShoppingCart` datetime DEFAULT NULL,
  `lendingPeriodOfItem` int(11) DEFAULT NULL,
  `formatOfItem` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idShoppingCartItem`),
  KEY `shoppingcartitemuser_id` (`user_id`),
  KEY `shoppingcartitemitem_id` (`item_id`),
  CONSTRAINT `shoppingcartitemitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shoppingcartitemuser_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcartitem`
--

LOCK TABLES `shoppingcartitem` WRITE;
/*!40000 ALTER TABLE `shoppingcartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userreviewhistory`
--

DROP TABLE IF EXISTS `userreviewhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userreviewhistory` (
  `idUserReviewHistory` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `review` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `useraccount_id` int(11) DEFAULT NULL,
  `likeValue` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUserReviewHistory`),
  KEY `userreviewhistoryitem_id` (`item_id`),
  KEY `userreviewhistoryuser_id` (`useraccount_id`),
  CONSTRAINT `userreviewhistoryitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userreviewhistoryuser_id` FOREIGN KEY (`useraccount_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userreviewhistory`
--

LOCK TABLES `userreviewhistory` WRITE;
/*!40000 ALTER TABLE `userreviewhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userreviewhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `idAuthor` int(11) NOT NULL,
  `authorName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAuthor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificationhistory`
--

DROP TABLE IF EXISTS `notificationhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificationhistory` (
  `idnotificationhistory` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `hasItBeenSeen` varchar(45) DEFAULT NULL,
  `notificationDate` date DEFAULT NULL,
  `notificationText` text,
  PRIMARY KEY (`idnotificationhistory`),
  KEY `notificationhistoryuser_id` (`user_id`),
  CONSTRAINT `notificationhistoryuser_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificationhistory`
--

LOCK TABLES `notificationhistory` WRITE;
/*!40000 ALTER TABLE `notificationhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificationhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemswithawards`
--

DROP TABLE IF EXISTS `itemswithawards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemswithawards` (
  `iditemswithawards` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `award_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditemswithawards`),
  KEY `itemwithawarditem_id` (`item_id`),
  KEY `itemwithawardaward_id` (`award_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemswithawards`
--

LOCK TABLES `itemswithawards` WRITE;
/*!40000 ALTER TABLE `itemswithawards` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemswithawards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffaccount`
--

DROP TABLE IF EXISTS `staffaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staffaccount` (
  `idStaffAccount` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userMobileNumber` varchar(45) DEFAULT NULL,
  `permissionsLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStaffAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffaccount`
--

LOCK TABLES `staffaccount` WRITE;
/*!40000 ALTER TABLE `staffaccount` DISABLE KEYS */;
INSERT INTO `staffaccount` VALUES (1,'admin','admin@admin.com','admin','1111111111',1),(2,'libraryUser1','lib@gmail.com','test','2222222222',2);
/*!40000 ALTER TABLE `staffaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audiobook`
--

DROP TABLE IF EXISTS `audiobook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audiobook` (
  `idAudioBook` int(11) NOT NULL AUTO_INCREMENT,
  `durationOfBook` int(11) DEFAULT NULL,
  `edition` int(11) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `numberOfParts` int(11) DEFAULT NULL,
  `sampleOfItemDownloadURL` varchar(45) DEFAULT NULL,
  `exerptOfItemDownloadURL` varchar(45) DEFAULT NULL,
  `burnToCD` varchar(45) DEFAULT NULL,
  `transferToDevice` varchar(45) DEFAULT NULL,
  `transferToAppleDevice` varchar(45) DEFAULT NULL,
  `publicPerformance` varchar(45) DEFAULT NULL,
  `fileSharing` varchar(45) DEFAULT NULL,
  `peerToPeerUsage` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAudioBook`),
  KEY `AudioBookItemId` (`idAudioBook`),
  KEY `audiobookitem_id` (`item_id`),
  CONSTRAINT `audiobookitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audiobook`
--

LOCK TABLES `audiobook` WRITE;
/*!40000 ALTER TABLE `audiobook` DISABLE KEYS */;
INSERT INTO `audiobook` VALUES (1,253,1,'3000',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,43),(2,574,1,'3001',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,44),(3,364,1,'3002',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,45),(4,456,1,'3003',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,46),(5,424,1,'3004',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,47),(6,435,1,'3005',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,48),(7,765,1,'3006',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,49),(8,745,1,'3007',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,50),(9,464,1,'3008',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,51),(10,845,1,'3009',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,52),(11,355,1,'3010',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,53),(12,465,1,'3011',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,54),(13,356,1,'3012',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,55),(14,744,1,'3013',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,56),(15,364,1,'3014',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,57),(16,746,1,'3015',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,58),(17,365,1,'3016',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,59),(18,354,1,'3017',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,60),(19,567,1,'3018',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,61),(20,565,1,'3019',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,62),(21,283,1,'3020',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,63),(22,928,1,'3021',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,64),(23,472,1,'3022',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,65),(24,474,1,'3023',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,66),(25,547,1,'3024',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,67),(26,372,1,'3025',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,68),(27,973,1,'3026',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,69),(28,154,1,'3027',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,70),(29,180,1,'3028',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,71),(30,157,1,'3029',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,72),(31,905,1,'3030',NULL,'http://localhost:8080/cse308/exerpt/1.mp3','http://localhost:8080/cse308/exerpt/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,73),(32,222,1,'3031',NULL,'http://localhost:8080/cse308/exerpt/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,74),(33,964,1,'3032',NULL,'http://localhost:8080/cse308/exerpt/3.mp3','http://localhost:8080/cse308/exerpt/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,75),(34,375,1,'3033',NULL,'http://localhost:8080/cse308/exerpt/4.mp3','http://localhost:8080/cse308/exerpt/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,76),(35,285,1,'3034',NULL,'http://localhost:8080/cse308/exerpt/5.mp3','http://localhost:8080/cse308/exerpt/5.mp3',NULL,NULL,NULL,NULL,NULL,NULL,77);
/*!40000 ALTER TABLE `audiobook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yumachievementearned`
--

DROP TABLE IF EXISTS `yumachievementearned`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumachievementearned` (
  `idyumachievementEarned` int(11) NOT NULL AUTO_INCREMENT,
  `achievement_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dateAchieved` date DEFAULT NULL,
  `pointValue` int(11) DEFAULT NULL,
  PRIMARY KEY (`idyumachievementEarned`),
  KEY `achievement_id` (`achievement_id`),
  KEY `yumachievementuser_id` (`user_id`),
  KEY `yumachievement_id` (`achievement_id`),
  CONSTRAINT `yumachievementuser_id` FOREIGN KEY (`user_id`) REFERENCES `yumuseraccount` (`idyumUserAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `yumachievement_id` FOREIGN KEY (`achievement_id`) REFERENCES `yumachievement` (`idachievement`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumachievementearned`
--

LOCK TABLES `yumachievementearned` WRITE;
/*!40000 ALTER TABLE `yumachievementearned` DISABLE KEYS */;
INSERT INTO `yumachievementearned` VALUES (10,2,1,'2012-05-03',5),(11,1,1,'2012-05-03',10),(13,1,9,'2012-05-03',10),(14,1,13,'2012-05-03',10),(15,2,13,'2012-05-03',5),(16,2,12,'2012-05-03',5),(17,2,14,'2012-05-10',5),(18,2,9,'2012-05-11',5),(19,1,12,'2012-05-14',10);
/*!40000 ALTER TABLE `yumachievementearned` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `availableCopies` int(11) DEFAULT NULL,
  `libraryCopies` int(11) DEFAULT NULL,
  `languagesOffered` text,
  `publisher` varchar(45) DEFAULT NULL,
  `bookSubject` int(11) DEFAULT NULL,
  `numberOfLikes` int(11) DEFAULT NULL,
  `numberOfDislikes` int(11) DEFAULT NULL,
  `description` text,
  `aboutTheAuthor` text,
  `releaseDate` date DEFAULT NULL,
  `fileSize` int(11) DEFAULT NULL,
  `itemSeries` varchar(45) DEFAULT NULL,
  `itemImage` text,
  `type` int(11) DEFAULT NULL,
  `digitalRights` text,
  `dateAdded` date DEFAULT NULL,
  PRIMARY KEY (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Under the Banner of Heaven','Author 1',10,10,NULL,'amazoink',1,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book1.jpg',1,NULL,'2012-04-25'),(2,'The Beauty and the Sorrow','Author 3',10,10,NULL,'amazoink',2,10,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book2.jpg',1,NULL,'2012-04-24'),(3,'Knit Two','Author 2',10,10,NULL,'amazoink',1,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book3.jpg',1,NULL,'2012-04-24'),(4,'Free Culture','Author 5',10,10,NULL,'amazoink',5,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book4.jpg',1,NULL,'2012-04-24'),(5,'Rome','Author 6',10,10,NULL,'amazoink',1,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book5.jpg',1,NULL,'2012-04-24'),(6,'Seven Keys to Unlock Autism','Author 4',10,10,NULL,'amazoink',2,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book6.jpg',1,NULL,'2012-04-24'),(7,'Last Writes','Author 4',10,10,NULL,'amazoink',1,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book7.jpg',1,NULL,'2012-04-24'),(8,'American Sniper','Author 7',10,10,NULL,'amazoink',5,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book9.jpg',1,NULL,'2012-05-08'),(9,'Shop till You Drop','Author 9',10,10,NULL,'amazoink',1,5,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book11.jpg',1,NULL,'2012-04-24'),(10,'Simmer Down','Author 8',10,10,NULL,'amazoink',1,0,0,NULL,NULL,NULL,NULL,NULL,'http://localhost:8080/cse308/images/books/book12.jpg',1,NULL,'2012-04-24'),(11,'150 Best New Apartment Ideas','Francesc Zamora Mola',10,10,NULL,NULL,1,11,0,'This information-packed volume explores the manifold ways in which architects and designers meet the various challenges of designing and decorating apartments for their clients.','Francesc Zamora Mola studied interior architecture in Barcelona and later in San Francisco, where he honed his design skills working with innovative architecture firms. Mr. Zamora lives in Barcelona and applies his experience to writing and editing about design and architecture.','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/150-Best-New-Apartment-Ideas.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(12,'Eisenhower in War and Peace','Jean Edward Smith',10,10,NULL,NULL,2,0,0,'In his magisterial bestseller FDR, Jean Edward Smith gave us a fresh, modern look at one of the most indelible figures in American history. Now this peerless biographer returns with a new life of Dwight D. Eisenhower that is as full, rich, and revealing as anything ever written about America\'s thirty-fourth president. As America searches for new heroes to lead it out of its present-day predicaments, Jean Edward Smith\'s achievement lies in reintroducing us to a hero from the past whose virtues have become clouded in the mists of history.','Jean Edward Smith is the author of the highly acclaimed FDR, winner of the 2008 Francis Parkman Prize; Grant, a 2002 Pulitzer Prize finalist; John Marshall: Definer of a Nation; and Lucius D. Clay: An American Life. A member of the faculty at the University of Toronto for thirty-five years, and at Marshall University for twelve, he is currently a senior scholar in the history department at Columbia.','2012-02-21',NULL,NULL,'http://localhost:8080/cse308/images/books/Eisenhower-in-War-and-Peace.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(13,'American Icon','BRYCE G. HOFFMAN',10,10,NULL,NULL,3,0,0,'At the end of 2008, Ford Motor Company was just months away from running out of cash. With the auto industry careening toward ruin, Congress offered all three Detroit automakers a bailout. General Motors and Chrysler grabbed the taxpayer lifeline, but Ford decided to save itself. Under the leadership of charismatic CEO Alan Mulally, Ford had already put together a bold plan to unify its divided global operations, transform its lackluster product lineup, and overcome a dys­functional culture of infighting, backstabbing, and excuses. It was an extraordinary risk, but it was the only way the Ford family--America\'s last great industrial dynasty--could hold on to their company.','BRYCE G. HOFFMAN is an award-winning journalist who has covered the auto industry, both in the United States and around the world, since 1998. He began cov­ering Ford Motor Company for the Detroit News in 2005. That beat gave him a front-row seat for many of the events chronicled in American Icon. Hoffman has been honored by the Society of American Business Edi­tors and Writers, the Society of Professional Journalists, the Associated Press, and others for his coverage of Ford and is one of the world\'s foremost authorities on the automaker. He lives in Grand Blanc, Michigan.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/American-Icon.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(14,'The Power of Habit','Charles Duhigg',10,10,NULL,NULL,4,0,0,'A thirty-four-year-old woman walks into a research laboratory outside Bethesda, Maryland. Over the past two years, she has changed almost every aspect of her life. She has quit smoking, lost forty pounds, run a marathon, and been promoted at work. The patterns inside her brain, neurologists are shocked to discover, have fundamentally changed.','CHARLES DUHIGG is an investigative reporter for The New York Times. He is a winner of the George Polk and National Academies of Science awards, and was part of a team of finalists for the 2009 Pulitzer Prize. He is a frequent contributor to NPR, This American Life, and Frontline. A gradaute of Harvard Business School and Yale College, he lives in Brooklyn with his wife and their two children.','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Power-of-Habit.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(15,'Foreign Bodies','Cynthia Ozick',10,10,NULL,NULL,5,0,0,'Cynthia Ozick is one of America\'s literary treasures. For her sixth novel, she set herself a brilliant challenge: to retell the story of Henry James\'s The Ambassadors—the work he considered his best—but as a photographic negative, that is the plot is the same, the meaning is reversed. At the core of the story is Bea Nightingale, a fiftyish divorced schoolteacher whose life has been on hold during the many years since her brief marriage. When her estranged, difficult brother asks her to leave New York for Paris to retrieve a nephew she barely knows, she becomes entangled in the lives of her brother\'s family and even, after so long, her ex-husband. Every one of them is irrevocably changed by the events of just a few months in that fateful year.','N/A','2011-05-05',NULL,NULL,'http://localhost:8080/cse308/images/books/Foreign-Bodies.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(16,'The Penguin and the Leviathan','Yochai Benkler',10,10,NULL,NULL,6,0,0,'What do Wikipedia, Zip Car\'s business model, Barack Obama\'s presidential campaign, and a small group of lobster fishermen have in common? They all show the power and promise of human cooperation in transforming our businesses, our government, and our society at large. Because today, when the costs of collaborating are lower than ever before, there are no limits to what we can achieve by working together.','Yochai Benkler is the Berkman Professor of Entrepreneurial Legal Studies at Harvard University. Since the 1990s, he has been a leading scholar in the role of collaboration in information technology, business, society, and culture, and his work has been featured in The Economist, Wall Street Journal, New York Times, and Time Magazine. His previous book, The Wealth of Networks, was named best business book about the future by Strategy + Business Magazine.','2011-08-09',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Penguin-and-the-Leviathan.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(17,'Chef Paul Prudhomme\'s Seasoned America','Paul Prudhomme ',10,10,NULL,NULL,7,0,0,'When one of America\'s most talented and best loved chefs reinterprets the great American classics, the result is Chef Paul Prudhomme\'s Seasoned America, a beautifully illustrated collection of American favorites made even better.','Chef Paul Prudhomme is the owner of K-Paul\'s Louisiana Kitchen and Magic Seasoning Blends, both in New Orleans. Chef Paul is one of America\'s best-known chefs, having appeared on most major TV networks. He is currently the host of three cooking series on cable television and PBS. Chef Paul is the author of seven other cookbooks and has been featured in numerous publications. He lives in New Orleans.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/Chef-Paul-Prudhommes-Seasoned-America.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(18,'Drift','Rachel Maddow',10,10,NULL,NULL,8,0,0,'\"One of my favorite ideas is, never to keep an unnecessary soldier,\" Thomas Jefferson wrote in 1792. Neither Jefferson nor the other Found­ers could ever have envisioned the modern national security state, with its tens of thousands of \"privateers\"; its bloated Department of Homeland Security; its rust­ing nuclear weapons, ill-maintained and difficult to dismantle; and its strange fascination with an unproven counterinsurgency doctrine.','Rachel Maddow has hosted the Emmy Award--winning Rachel Maddow Show on MSNBC since 2008. Before that, she was at Air America Radio for the duration of that underappreciated enterprise. She has a doctorate in politics from Oxford and a bachelor\'s degree in public policy from Stanford. She lives in rural western Massachusetts and New York City with her partner, artist Susan Mikula, and an enormous dog.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Drift.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(19,'You Will Call Me Drog','Sue Cowing',10,10,NULL,NULL,9,0,0,'Parker is a normal sixth grader—or he was normal before the puppet. It\'s just an old hand puppet, sticking out of a garbage can, and even though Parker\'s best friend says leave it, Parker brings the puppet home and tries it on. Or maybe it tries him on. \"You will call me Drog!\" the puppet commands once they\'re alone. And now, no matter how hard Parker tries, he can\'t get Drog off his hand.','N/A','2011-08-11',NULL,NULL,'http://localhost:8080/cse308/images/books/You-Will-Call-Me-Drog.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(20,'French Essentials For Dummies','Laura K. Lawless',10,10,NULL,NULL,10,0,0,'Just the core concepts you need to write and speak French correctly','N/A','2011-05-09',NULL,NULL,'http://localhost:8080/cse308/images/books/French-Essentials-For-Dummies.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(21,'Super Cleanse','Adina Niemerow',10,10,NULL,'amazoink',11,0,0,'Newly Revised and Updated—Unleash your life force with the power of cleansing!.','Adina Niemerow began her journey as a holistic chef studying healing with whole foods and Asian traditions in modern nutrition at the Heartwood Institute. She continued her culinary education at the Natural Gourmet Institute in New York City and has worked at top wellness spas and restaurants, including the French Laundry. She\'s been a personal chef to Fortune 500 CEOs, fashion models, musicians, and movie stars, and she continues traveling the globe searching for secrets to thriving on a clean diet. She lives in San Francisco.','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/Super-Cleanse.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(22,'A Week to Be Wicked','Tessa Dare',10,10,NULL,'amazoink',12,0,0,'Unexpected lovers find themselves together in Spindle Cove with A Week to be Wicked—the second book in Tessa Dare\'s utterly delectable historical romance series. This Regency Era delight finds a restless British lord desperate to escape the quaint and too quiet small seaside resort he\'s trapped in...and he gets much more than he expected when he eagerly agrees to escort a beautiful, brilliant, socially awkward lady scientist to Scotland. Concerning Tessa Dare and her irresistible romances, bestselling author Julia Quinn is spot on when she says, “Prepare to fall in love!” And anyone who loves the novels of Lisa Kleypas, Christina Dodd, and Liz Carlyle is going to adore having A Week to be Wicked.','Tessa Dare is a sometime librarian, full-time mom, and swing-shift writer. Recently, Booklist magazine named her one of the “new stars of historical romance.” She makes her home in Southern California, where she shares a cozy, cluttered bungalow with her husband, their two children, and a big brown dog.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/A-Week-to-Be-Wicked.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(23,'Citizens of London','Lynne Olson',10,10,NULL,'amazoink',13,0,0,'The acclaimed author of Troublesome Young Men reveals the behind-the-scenes story of how the United States forged its wartime alliance with Britain, told from the perspective of three key American players in London: Edward R. Murrow, the handsome, chain-smoking head of CBS News in Europe; Averell Harriman, the hard-driving millionaire who ran FDR\'s Lend-Lease program in London; and John Gilbert Winant, the shy, idealistic U.S. ambassador to Britain. Each man formed close ties with Winston Churchill--so much so that all became romantically involved with members of the prime minister\'s family. Drawing from a variety of primary sources, Lynne Olson skillfully depicts the dramatic personal journeys of these men who, determined to save Britain from Hitler, helped convince a cautious Franklin Roosevelt and reluctant American public to back the British at a critical time. Deeply human, brilliantly researched, and beautifully written, Citizens of London is a new triumph from an author swiftly becoming one of the finest in her field.','Lynne Olson, a former Moscow correspondent for the Associated Press and White House correspondent for the Baltimore Sun, is the author of Troublesome Young Men and Freedom\'s Daughters and co-author, with her husband, Stanley Cloud, of A Question of Honor and The Murrow Boys. She lives in Washington, D.C.','2010-02-02',NULL,NULL,'http://localhost:8080/cse308/images/books/Citizens-of-London.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(24,'Made in Marseille','Daniel Young',10,10,NULL,'amazoink',14,0,0,'Marseille, once notorious for its assorted mischief, has recently experienced a cultural renaissance, establishing it as a Mediterranean capital of film, fashion, music, literature, and, most assuredly, cuisine. From the city\'s beloved, world-famous bouillabaisse to enticing ÉmigrÉ flavors to venerable street treats to classic and contemporary Provencal bistro fare, this culinary crossroads, the Paris of Provence, offers an exciting array of tempting foods that, while global in scope, have a folksy, made-in-Marseille personality. Join Daniel Young, author of The Paris CafÉ Cookbook, as he explores the authentic flavors of France\'s oldest city, its great southern gateway, extending from the Marseille of antiquity, found intact in the limestone cliffs of the rocky coastline, to the Marseille of romantic intrigue, still apparent in the labyrinthine passageways of the historic Panier quarter, to its storied center, the Vieux Port. Of course there\'s bouillabaisse: an entire chapter on this legendary fish stew-soup, including rustic, home-style Marseille recipes adapted so they can successfully be made with North American fish — not entirely authentic but wholeheartedly delicious. There are many other definitive fish recipes from this seafood lovers\' paradise as well, including the legendary pan-fried calamari with parsley and garlic from Chez Etienne and the foolproof formula for grilling fish from the Restaurant L\'Escale. In addition, there are aromatic appetizers, traditional and newfangled desserts, savory pastries, meat and chicken dishes, and hearty vegetable stews, all prepared with the building blocks of the healthful, French-Mediterranean diet: olive oil, garlic, tomatoes, zucchini, fennel, eggplant, artichokes, olives, basil, thyme, rosemary, bay leaves, almonds, figs, and honey.','Daniel Young is a food critic by trade and a collector of kitchen, dining room, and cafÉ secrets in practice. He is the author of Made in Marseille, The Rough Guide to New York City Restaurants, and The Paris CafÉ Cookbook and has written about French food and culture for many publications, including Gourmet, Bon AppÉtit, CondÉ Nast Traveler, the New York Times, and others. Formerly the restaurant critic for the New York Daily News, he now lives in Paris, London, and his hometown, New York.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Made-in-Marseille.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(25,'Chocolate-Covered Eyes','Lori R. Lopez',10,10,NULL,'amazoink',15,0,0,'Can the living and the undead co-exist in peace? A zombie defender must question his principles when a hunter becomes infected by the zombie plague and threatens the boy\'s mother in \"Heartbeat\".','Lori R. Lopez has always loved books since being read to when small, then reading and writing them herself. She is the author of works spanning multiple categories from Nonfiction to Fiction; novel to story to verse collection; children\'s fiction, storybooks and more, usually with a blend of genres such as Humor, Fantasy, Horror, Supernatural, Thriller, Epic-Adventure and so on. Her titles include OUT-OF-MIND EXPERIENCES, CHOCOLATE-COVERED EYES, DANCE OF THE CHUPACABRAS, and her award-winning novel AN ILL WIND BLOWS.','2011-10-29',NULL,NULL,'http://localhost:8080/cse308/images/books/Chocolate-Covered-Eyes.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(26,'Do Bananas Chew Gum?','Jamie Gilson',10,10,NULL,'amazoink',16,0,0,'Sam has made it most of the way through sixth grade, barely able to read and write, but now Sam\'s family have moved again and he is faced with the prospect of attending a new school. How long will he be able to keep his problem secret?','Jamie Gilson has written sixteen books, all of them about children, most of them about children in school. And the elementary school where she gets many of her ideas is Central, which all three Gilson children attended. While Tom and Anne are now lawyers and Matthew a photographer, their mother still goes to Central School classes, notebook in hand, looking for stories.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/Do-Bananas-Chew-Gum.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(27,'Practicing Science Fiction','Karen Hellekson',10,10,NULL,'amazoink',17,0,0,'Drawn from the Science Fiction Research Association conference held in Lawrence, Kansas, in 2008, the essays in this volume address intersections among the reading, writing, and teaching of science fiction. Part 1 studies the teaching of SF, placing analytical and pedagogical research next to each other to reveal how SF can be both an object of study as well as a teaching tool for other disciplines. Part 2 examines SF as a genre of mediation between the sciences and the humanities, using close readings and analyses of the literary-scientific nexus. Part 3 examines SF in the media, using specific television programs, graphic novels, and films as examples of how SF successfully transcends the medium of transmission.','N/A','2010-05-05',NULL,NULL,'http://localhost:8080/cse308/images/books/Practicing-Science-Fiction.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(28,'Bruno, Chief of Police','Martin Walker',10,10,NULL,'amazoink',18,0,0,'Meet Benoît Courrèges, aka Bruno, a policeman in a small village in the South of France. He\'s a former soldier who has embraced the pleasures and slow rhythms of country life. He has a gun but never wears it; he has the power to arrest but never uses it. But then the murder of an elderly North African who fought in the French army changes all that. Now Bruno must balance his beloved routines--living in his restored shepherd\'s cottage, shopping at the local market, drinking wine, strolling the countryside--with a politically delicate investigation. He\'s paired with a young policewoman from Paris and the two suspect anti-immigrant militants. As they learn more about the dead man\'s past, Bruno\'s suspicions turn toward a more complex motive.','Martin Walker is the senior director of the Global Business Policy Council and editor emeritus and international affairs columnist at United Press International. Formerly Moscow and U.S. bureau chief for Britain\'s The Guardian, he is also a senior scholar at the Woodrow Wilson International Center for Scholars in Washington, D.C. His books include The Cold War: A History, a New York Times Notable Book and short-listed for the Whitbread Book of the Year Prize, and The Caves of Périgord, a novel. He has written for The New York Times, The New Yorker, and The Times Literary Supplement. He lives in Washington, D.C., and the southwest of France.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Bruno-Chief-of-Police.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(29,'Ten Poems to Say Goodbye','Roge Housden',10,10,NULL,'amazoink',19,0,0,'In Ten Poems to Say Goodbye, the newest addition to the celebrated Ten Poems series, Roger Housden continues to highlight the magic of poetry, this time as it relates to personal loss. But while the selected poems in this volume may focus upon loss and grief, they also reflect solace, respite, and joy. ','ROGER HOUSDEN is the author of Ten Poems to Change Your Life; Ten Poems to Open Your Heart; Ten Poems to Set You Free; Ten Poems to Last a Lifetime; How Rembrandt Reveals Your Beautiful, Imperfect Self; Seven Sins for a Life Worth Living; Saved by Beauty; and the novella Chasing Rumi, and is also the editor of Risking Everything: 110 Poems of Love and Revelation and Dancing with Joy. Housden was born in England and now lives in the United States.','2011-02-19',NULL,NULL,'http://localhost:8080/cse308/images/books/Ten-Poems-to-Say-Goodbye.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(30,'The Big Bing','Stanley Bing',10,10,NULL,'amazoink',20,0,0,'After two decades in the belly of the corporate beast, clawing his way to the top of one of the great multinational companies in the cosmos, Stanley Bing has seen it all. The Big Bing provides a mole\'s-eye view of the society in which we all live and work, in Bing\'s trademark funny, wise, and pleasantly mean-spirited style.','N/A','2003-10-15',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Big-Bing.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(31,'Religion for Atheists','Alain de Botton',10,10,NULL,'amazoink',21,0,0,'What if religions are neither all true nor all nonsense? The long-running and often boring debate between fundamentalist believers and non-believers is finally moved forward by Alain de Botton\'s inspiring new book, which boldly argues that the supernatural claims of religion are entirely false--but that it still has some very important things to teach the secular world.','Alain de Botton is the author of essays on themes ranging from love and travel to architecture and philosophy. His best-selling books include How Proust Can Change Your Life, The Art of Travel and The Architecture of Happiness. He lives in London, where he is the founder and chairman of The School of Life (www.theschooloflife.com) and the creative director of Living Architecture (www.living-architecture.co.uk).','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/Religion-for-Atheists.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(32,'All Else Confusion','Betty Neels',10,10,NULL,'amazoink',22,0,0,'Annis\'s life as daughter of the Rectory was a busy and happy one, certainly not lacking in love—but she loved Jake Royle even more than she loved her family. So when he proposed to her she didn\'t hesitate, even though she knew he didn\'t love her. Jake had said from the start that he didn\'t think love was necessary to make a marriage work. But even if she could accept his lack of feeling for her, would Jake ever admit Annis into his life? ','Romance author Betty Neels died peacefully in hospital on June 7, 2001, aged 91. Her career with Harlequin spanned 30 years, and she continued to write into her 90th year.','2011-04-05',NULL,NULL,'http://localhost:8080/cse308/images/books/All-Else-Confusion.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(33,'Partials','Dan Wells',10,10,NULL,'amazoink',23,0,0,'The human race is all but extinct after a war with Partials—engineered organic beings identical to humans—has decimated the population. Reduced to only tens of thousands by RM, a weaponized virus to which only a fraction of humanity is immune, the survivors in North America have huddled together on Long Island while the Partials have mysteriously retreated. The threat of the Partials is still imminent, but, worse, no baby has been born immune to RM in more than a decade. Our time is running out.','N/A','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/Partials.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(34,'Being with Dieing','Joan Halifax',10,10,NULL,'amazoink',24,0,0,'The Buddhist approach to death can be of greatbenefit to people of all backgrounds—as has been demonstrated time and again inJoan Halifax\'s decades of work with the dying and their caregivers. Inspired bytraditional Buddhist teachings, her work is a source of wisdom for all thosewho are charged with a dying person\'s care, facing their own death, or wishingto explore and contemplate the transformative power of the dying process. Herteachings affirm that we can open and contact our inner strength, and that wecan help others who are suffering to do the same. ','Joan Halifax, PhD, is a Zen priest and anthropologist who has served on the faculty of Columbia University and the University of Miami School of Medicine. For the past thirty years she has worked with dying people and has lectured on the subject of death and dying at Harvard Divinity School, Harvard Medical School, Georgetown Medical School, and many other academic institutions. In 1990, she founded Upaya Zen Center, a Buddhist study and social action center in Santa Fe, New Mexico. In 1994, she founded the Project on Being with Dying, which has trained hundreds of healthcare professionals in the contemplative care of dying people.','2011-04-15',NULL,NULL,'http://localhost:8080/cse308/images/books/Being-with-Dieing.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(35,'The Emerald Diamond','Charley Rosen',10,10,NULL,'amazoink',25,0,0,'From \"Casey at the Bat\" to Connie Mack to the Irish Sports Hall of Fame, here is the first-ever full history of the Irish people\'s impact on America\'s favorite past time, from its earliest years to its most significant milestones today. New York Times bestselling sportswriter Charlie Rosen, author of The Bullpen Diaries and More than Just a Game, delivers a one-of-a-kind instant classic perfect “for anyone who is Irish and loves baseball.” In the words of Jay P. Dolan, author of The Irish Americans, “The Emerald Diamond is a must read. It is a remarkable story about the achievements of the Irish throughout the history of baseball in America.”','Charley Rosen is an analyst for FoxSports.com and the coauthor with Phil Jackson of the bestseller More Than a Game. He is also the author of fifteen other sports books and has written more than a hundred pieces for publications such as the New York Times Book Review, Sport, Inside Sports, Penthouse, M, and Cigar Aficionado—the latest being a piece for Men\'s Journal about Phil Jackson\'s trip to Australia and New Zealand.','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Emerald-Diamond.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(36,'Algebra','Denise Szecsei',10,10,NULL,'amazoink',26,0,0,'Homework Helpers: Algebra is a straightforward and easy-to-read review of arithmetic skills emphasizes the role that arithmetic plays in the development of algebra coversing all of the topics in a typical Algebra I class, including: Solving linear equalities and inequalities; Solving systems of linear equations; Factoring polynomials; Graphing functions; Working with rational functions; Solving quadratic equations; Understanding word problems; Homework Helpers: Algebra will help build a solid mathematical foundation and enable students to gain the confidence they need to study Algebra II. This book also contains a summary of important formulas for easy reference.','N/A','2011-12-07',NULL,NULL,'http://localhost:8080/cse308/images/books/Algebra.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(37,'Simon Says Die','Lena Diaz',10,10,NULL,'amazoink',27,0,0,'Simon says: I\'m watching. Simon says: I\'m coming. Simon says: Die.','Lena Diaz grew up a Navy Brat, but while two of her three siblings followed in her father\'s footsteps and joined the Navy, Lena loosely followed in her musically talented mother\'s footsteps by choosing a more creative path: writing. Her first novel-length manuscripts were paranormals ranging from contemporary vampire stories to medieval druid tales. Since dead bodies kept creeping into everything she wrote, she eventually turned to romantic suspense. Today Lena can be found in North Florida with her husband of twenty-plus years, her belly-dancing daughter, her mud-bogging son, a tri-colored Sheltie named Sparky, and a pair of Beta fish named Rocky Bal-Beta and Mr. T','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Simon-Says-Die.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(38,'Londoners','Craig Taylor',10,10,NULL,'amazoink',28,0,0,'“Craig Taylor is the real deal: a peerless journalist and a beautiful craftsman.”','N/A','2012-02-21',NULL,NULL,'http://localhost:8080/cse308/images/books/Londoners.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(39,'Dylan','C. H. Admirand',10,10,NULL,'amazoink',29,0,0,'PRAISE FOR TYLER: \"Guaranteed to sizzle in your hands.\"','N/A','2012-01-01',NULL,NULL,'http://localhost:8080/cse308/images/books/Dylan.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(40,'Data-Driven Marketing','Mark Jeffery ',10,10,NULL,'amazoink',20,0,0,'In the new era of tight marketing budgets, no organization can continue to spend on marketing without knowing what\'s working and what\'s wasted. Data-driven marketing improves efficiency and effectiveness of marketing expenditures across the spectrum of marketing activities from branding and awareness, trail and loyalty, to new product launch and Internet marketing. Based on new research from the Kellogg School of Management, this book is a clear and convincing guide to using a more rigorous, data-driven strategic approach to deliver significant performance gains from your marketing.','N/A','2010-01-29',NULL,NULL,'http://localhost:8080/cse308/images/books/Data-Driven-Marketing.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(41,'Do More Faster','Brad Feld',10,10,NULL,'amazoink',20,0,0,'TechStars is a mentorship-driven startup accelerator with operations in three U.S. cities. Once a year in each city, it funds about ten Internet startups with a small amount of capital and surrounds them with around fifty top Internet entrepreneurs and investors. Historically, about seventy-five percent of the companies that go through TechStars raise a meaningful amount of angel or venture capital. Do More Faster: TechStars Lessons to Accelerate Your Startup is a collection of advice that comes from individuals who have passed through, or are part of, this proven program. Each vignette is an exploration of information often heard during the TechStars program and provides practical insights into early stage entrepreneurship.','David Cohen is the founder and CEO of TechStars. He previously founded and successfully exited several companies and is now an angel investor in over 100 Internet startups.','2010-10-01',NULL,NULL,'http://localhost:8080/cse308/images/books/Do-More-Faster.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-07'),(42,'Why Nations Fail','James Robinson',10,10,NULL,'amazoink',20,0,0,'Daron Acemoglu and James Robinson conclusively show that it is man-made political and economic institutions that underlie economic success (or lack of it). Korea, to take just one of their fascinating examples, is a remarkably homogeneous nation, yet the people of North Korea are among the poorest on earth while their brothers and sisters in South Korea are among the richest. The south forged a society that created incentives, rewarded innovation, and allowed everyone to participate in economic opportunities. The economic success thus spurred was sustained because the government became accountable and responsive to citizens and the great mass of people. Sadly, the people of the north have endured decades of famine, political repression, and very different economic institutions--with no end in sight. The differences between the Koreas is due to the politics that created these completely different institutional trajectories. ','JAMES A. ROBINSON, a political scientist and an economist, is the David Florence Professor of Government at Harvard University. A world-renowned expert on Latin America and Africa, he has worked in Botswana, Mauritius, Sierra Leone, and South Africa.','2012-03-20',NULL,NULL,'http://localhost:8080/cse308/images/books/Why-Nations-Fail.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(43,'150 Best New Apartment Ideas','Francesc Zamora Mola',10,10,NULL,NULL,30,11,0,'This information-packed volume explores the manifold ways in which architects and designers meet the various challenges of designing and decorating apartments for their clients.','Francesc Zamora Mola studied interior architecture in Barcelona and later in San Francisco, where he honed his design skills working with innovative architecture firms. Mr. Zamora lives in Barcelona and applies his experience to writing and editing about design and architecture.','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/150-Best-New-Apartment-Ideas.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(44,'Eisenhower in War and Peace','Jean Edward Smith',10,10,NULL,NULL,31,0,0,'In his magisterial bestseller FDR, Jean Edward Smith gave us a fresh, modern look at one of the most indelible figures in American history. Now this peerless biographer returns with a new life of Dwight D. Eisenhower that is as full, rich, and revealing as anything ever written about America\'s thirty-fourth president. As America searches for new heroes to lead it out of its present-day predicaments, Jean Edward Smith\'s achievement lies in reintroducing us to a hero from the past whose virtues have become clouded in the mists of history.','Jean Edward Smith is the author of the highly acclaimed FDR, winner of the 2008 Francis Parkman Prize; Grant, a 2002 Pulitzer Prize finalist; John Marshall: Definer of a Nation; and Lucius D. Clay: An American Life. A member of the faculty at the University of Toronto for thirty-five years, and at Marshall University for twelve, he is currently a senior scholar in the history department at Columbia.','2012-02-21',NULL,NULL,'http://localhost:8080/cse308/images/books/Eisenhower-in-War-and-Peace.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(45,'American Icon','BRYCE G. HOFFMAN',10,10,NULL,NULL,32,0,0,'At the end of 2008, Ford Motor Company was just months away from running out of cash. With the auto industry careening toward ruin, Congress offered all three Detroit automakers a bailout. General Motors and Chrysler grabbed the taxpayer lifeline, but Ford decided to save itself. Under the leadership of charismatic CEO Alan Mulally, Ford had already put together a bold plan to unify its divided global operations, transform its lackluster product lineup, and overcome a dys­functional culture of infighting, backstabbing, and excuses. It was an extraordinary risk, but it was the only way the Ford family--America\'s last great industrial dynasty--could hold on to their company.','BRYCE G. HOFFMAN is an award-winning journalist who has covered the auto industry, both in the United States and around the world, since 1998. He began cov­ering Ford Motor Company for the Detroit News in 2005. That beat gave him a front-row seat for many of the events chronicled in American Icon. Hoffman has been honored by the Society of American Business Edi­tors and Writers, the Society of Professional Journalists, the Associated Press, and others for his coverage of Ford and is one of the world\'s foremost authorities on the automaker. He lives in Grand Blanc, Michigan.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/American-Icon.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(46,'The Power of Habit','Charles Duhigg',10,10,NULL,NULL,33,0,0,'A thirty-four-year-old woman walks into a research laboratory outside Bethesda, Maryland. Over the past two years, she has changed almost every aspect of her life. She has quit smoking, lost forty pounds, run a marathon, and been promoted at work. The patterns inside her brain, neurologists are shocked to discover, have fundamentally changed.','CHARLES DUHIGG is an investigative reporter for The New York Times. He is a winner of the George Polk and National Academies of Science awards, and was part of a team of finalists for the 2009 Pulitzer Prize. He is a frequent contributor to NPR, This American Life, and Frontline. A gradaute of Harvard Business School and Yale College, he lives in Brooklyn with his wife and their two children.','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Power-of-Habit.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(47,'Foreign Bodies','Cynthia Ozick',10,10,NULL,NULL,34,0,0,'Cynthia Ozick is one of America\'s literary treasures. For her sixth novel, she set herself a brilliant challenge: to retell the story of Henry James\'s The Ambassadors—the work he considered his best—but as a photographic negative, that is the plot is the same, the meaning is reversed. At the core of the story is Bea Nightingale, a fiftyish divorced schoolteacher whose life has been on hold during the many years since her brief marriage. When her estranged, difficult brother asks her to leave New York for Paris to retrieve a nephew she barely knows, she becomes entangled in the lives of her brother\'s family and even, after so long, her ex-husband. Every one of them is irrevocably changed by the events of just a few months in that fateful year.','N/A','2011-05-05',NULL,NULL,'http://localhost:8080/cse308/images/books/Foreign-Bodies.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(48,'The Penguin and the Leviathan','Yochai Benkler',10,10,NULL,NULL,35,0,0,'What do Wikipedia, Zip Car\'s business model, Barack Obama\'s presidential campaign, and a small group of lobster fishermen have in common? They all show the power and promise of human cooperation in transforming our businesses, our government, and our society at large. Because today, when the costs of collaborating are lower than ever before, there are no limits to what we can achieve by working together.','Yochai Benkler is the Berkman Professor of Entrepreneurial Legal Studies at Harvard University. Since the 1990s, he has been a leading scholar in the role of collaboration in information technology, business, society, and culture, and his work has been featured in The Economist, Wall Street Journal, New York Times, and Time Magazine. His previous book, The Wealth of Networks, was named best business book about the future by Strategy + Business Magazine.','2011-08-09',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Penguin-and-the-Leviathan.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(49,'Chef Paul Prudhomme\'s Seasoned America','Paul Prudhomme ',10,10,NULL,NULL,36,0,0,'When one of America\'s most talented and best loved chefs reinterprets the great American classics, the result is Chef Paul Prudhomme\'s Seasoned America, a beautifully illustrated collection of American favorites made even better.','Chef Paul Prudhomme is the owner of K-Paul\'s Louisiana Kitchen and Magic Seasoning Blends, both in New Orleans. Chef Paul is one of America\'s best-known chefs, having appeared on most major TV networks. He is currently the host of three cooking series on cable television and PBS. Chef Paul is the author of seven other cookbooks and has been featured in numerous publications. He lives in New Orleans.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/Chef-Paul-Prudhommes-Seasoned-America.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(50,'Drift','Rachel Maddow',10,10,NULL,NULL,37,0,0,'\"One of my favorite ideas is, never to keep an unnecessary soldier,\" Thomas Jefferson wrote in 1792. Neither Jefferson nor the other Found­ers could ever have envisioned the modern national security state, with its tens of thousands of \"privateers\"; its bloated Department of Homeland Security; its rust­ing nuclear weapons, ill-maintained and difficult to dismantle; and its strange fascination with an unproven counterinsurgency doctrine.','Rachel Maddow has hosted the Emmy Award--winning Rachel Maddow Show on MSNBC since 2008. Before that, she was at Air America Radio for the duration of that underappreciated enterprise. She has a doctorate in politics from Oxford and a bachelor\'s degree in public policy from Stanford. She lives in rural western Massachusetts and New York City with her partner, artist Susan Mikula, and an enormous dog.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Drift.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(51,'You Will Call Me Drog','Sue Cowing',10,10,NULL,NULL,38,0,0,'Parker is a normal sixth grader—or he was normal before the puppet. It\'s just an old hand puppet, sticking out of a garbage can, and even though Parker\'s best friend says leave it, Parker brings the puppet home and tries it on. Or maybe it tries him on. \"You will call me Drog!\" the puppet commands once they\'re alone. And now, no matter how hard Parker tries, he can\'t get Drog off his hand.','N/A','2011-08-11',NULL,NULL,'http://localhost:8080/cse308/images/books/You-Will-Call-Me-Drog.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(52,'French Essentials For Dummies','Laura K. Lawless',10,10,NULL,NULL,39,0,0,'Just the core concepts you need to write and speak French correctly','N/A','2011-05-09',NULL,NULL,'http://localhost:8080/cse308/images/books/French-Essentials-For-Dummies.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(53,'Super Cleanse','Adina Niemerow',10,10,NULL,NULL,40,0,0,'Newly Revised and Updated—Unleash your life force with the power of cleansing!.','Adina Niemerow began her journey as a holistic chef studying healing with whole foods and Asian traditions in modern nutrition at the Heartwood Institute. She continued her culinary education at the Natural Gourmet Institute in New York City and has worked at top wellness spas and restaurants, including the French Laundry. She\'s been a personal chef to Fortune 500 CEOs, fashion models, musicians, and movie stars, and she continues traveling the globe searching for secrets to thriving on a clean diet. She lives in San Francisco.','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/Super-Cleanse.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(54,'A Week to Be Wicked','Tessa Dare',10,10,NULL,NULL,41,0,0,'Unexpected lovers find themselves together in Spindle Cove with A Week to be Wicked—the second book in Tessa Dare\'s utterly delectable historical romance series. This Regency Era delight finds a restless British lord desperate to escape the quaint and too quiet small seaside resort he\'s trapped in...and he gets much more than he expected when he eagerly agrees to escort a beautiful, brilliant, socially awkward lady scientist to Scotland. Concerning Tessa Dare and her irresistible romances, bestselling author Julia Quinn is spot on when she says, “Prepare to fall in love!” And anyone who loves the novels of Lisa Kleypas, Christina Dodd, and Liz Carlyle is going to adore having A Week to be Wicked.','Tessa Dare is a sometime librarian, full-time mom, and swing-shift writer. Recently, Booklist magazine named her one of the “new stars of historical romance.” She makes her home in Southern California, where she shares a cozy, cluttered bungalow with her husband, their two children, and a big brown dog.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/A-Week-to-Be-Wicked.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(55,'Citizens of London','Lynne Olson',10,10,NULL,NULL,42,0,0,'The acclaimed author of Troublesome Young Men reveals the behind-the-scenes story of how the United States forged its wartime alliance with Britain, told from the perspective of three key American players in London: Edward R. Murrow, the handsome, chain-smoking head of CBS News in Europe; Averell Harriman, the hard-driving millionaire who ran FDR\'s Lend-Lease program in London; and John Gilbert Winant, the shy, idealistic U.S. ambassador to Britain. Each man formed close ties with Winston Churchill--so much so that all became romantically involved with members of the prime minister\'s family. Drawing from a variety of primary sources, Lynne Olson skillfully depicts the dramatic personal journeys of these men who, determined to save Britain from Hitler, helped convince a cautious Franklin Roosevelt and reluctant American public to back the British at a critical time. Deeply human, brilliantly researched, and beautifully written, Citizens of London is a new triumph from an author swiftly becoming one of the finest in her field.','Lynne Olson, a former Moscow correspondent for the Associated Press and White House correspondent for the Baltimore Sun, is the author of Troublesome Young Men and Freedom\'s Daughters and co-author, with her husband, Stanley Cloud, of A Question of Honor and The Murrow Boys. She lives in Washington, D.C.','2010-02-02',NULL,NULL,'http://localhost:8080/cse308/images/books/Citizens-of-London.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(56,'Made in Marseille','Daniel Young',10,10,NULL,NULL,43,0,0,'Marseille, once notorious for its assorted mischief, has recently experienced a cultural renaissance, establishing it as a Mediterranean capital of film, fashion, music, literature, and, most assuredly, cuisine. From the city\'s beloved, world-famous bouillabaisse to enticing ÉmigrÉ flavors to venerable street treats to classic and contemporary Provencal bistro fare, this culinary crossroads, the Paris of Provence, offers an exciting array of tempting foods that, while global in scope, have a folksy, made-in-Marseille personality. Join Daniel Young, author of The Paris CafÉ Cookbook, as he explores the authentic flavors of France\'s oldest city, its great southern gateway, extending from the Marseille of antiquity, found intact in the limestone cliffs of the rocky coastline, to the Marseille of romantic intrigue, still apparent in the labyrinthine passageways of the historic Panier quarter, to its storied center, the Vieux Port. Of course there\'s bouillabaisse: an entire chapter on this legendary fish stew-soup, including rustic, home-style Marseille recipes adapted so they can successfully be made with North American fish — not entirely authentic but wholeheartedly delicious. There are many other definitive fish recipes from this seafood lovers\' paradise as well, including the legendary pan-fried calamari with parsley and garlic from Chez Etienne and the foolproof formula for grilling fish from the Restaurant L\'Escale. In addition, there are aromatic appetizers, traditional and newfangled desserts, savory pastries, meat and chicken dishes, and hearty vegetable stews, all prepared with the building blocks of the healthful, French-Mediterranean diet: olive oil, garlic, tomatoes, zucchini, fennel, eggplant, artichokes, olives, basil, thyme, rosemary, bay leaves, almonds, figs, and honey.','Daniel Young is a food critic by trade and a collector of kitchen, dining room, and cafÉ secrets in practice. He is the author of Made in Marseille, The Rough Guide to New York City Restaurants, and The Paris CafÉ Cookbook and has written about French food and culture for many publications, including Gourmet, Bon AppÉtit, CondÉ Nast Traveler, the New York Times, and others. Formerly the restaurant critic for the New York Daily News, he now lives in Paris, London, and his hometown, New York.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Made-in-Marseille.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(57,'Chocolate-Covered Eyes','Lori R. Lopez',10,10,NULL,NULL,44,0,0,'Can the living and the undead co-exist in peace? A zombie defender must question his principles when a hunter becomes infected by the zombie plague and threatens the boy\'s mother in \"Heartbeat\".','Lori R. Lopez has always loved books since being read to when small, then reading and writing them herself. She is the author of works spanning multiple categories from Nonfiction to Fiction; novel to story to verse collection; children\'s fiction, storybooks and more, usually with a blend of genres such as Humor, Fantasy, Horror, Supernatural, Thriller, Epic-Adventure and so on. Her titles include OUT-OF-MIND EXPERIENCES, CHOCOLATE-COVERED EYES, DANCE OF THE CHUPACABRAS, and her award-winning novel AN ILL WIND BLOWS.','2011-10-29',NULL,NULL,'http://localhost:8080/cse308/images/books/Chocolate-Covered-Eyes.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(58,'Do Bananas Chew Gum?','Jamie Gilson',10,10,NULL,NULL,45,0,0,'Sam has made it most of the way through sixth grade, barely able to read and write, but now Sam\'s family have moved again and he is faced with the prospect of attending a new school. How long will he be able to keep his problem secret?','Jamie Gilson has written sixteen books, all of them about children, most of them about children in school. And the elementary school where she gets many of her ideas is Central, which all three Gilson children attended. While Tom and Anne are now lawyers and Matthew a photographer, their mother still goes to Central School classes, notebook in hand, looking for stories.','2012-03-13',NULL,NULL,'http://localhost:8080/cse308/images/books/Do-Bananas-Chew-Gum.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(59,'Practicing Science Fiction','Karen Hellekson',10,10,NULL,NULL,46,0,0,'Drawn from the Science Fiction Research Association conference held in Lawrence, Kansas, in 2008, the essays in this volume address intersections among the reading, writing, and teaching of science fiction. Part 1 studies the teaching of SF, placing analytical and pedagogical research next to each other to reveal how SF can be both an object of study as well as a teaching tool for other disciplines. Part 2 examines SF as a genre of mediation between the sciences and the humanities, using close readings and analyses of the literary-scientific nexus. Part 3 examines SF in the media, using specific television programs, graphic novels, and films as examples of how SF successfully transcends the medium of transmission.','N/A','2010-05-05',NULL,NULL,'http://localhost:8080/cse308/images/books/Practicing-Science-Fiction.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(60,'Bruno, Chief of Police','Martin Walker',10,10,NULL,NULL,47,0,0,'Meet Benoît Courrèges, aka Bruno, a policeman in a small village in the South of France. He\'s a former soldier who has embraced the pleasures and slow rhythms of country life. He has a gun but never wears it; he has the power to arrest but never uses it. But then the murder of an elderly North African who fought in the French army changes all that. Now Bruno must balance his beloved routines--living in his restored shepherd\'s cottage, shopping at the local market, drinking wine, strolling the countryside--with a politically delicate investigation. He\'s paired with a young policewoman from Paris and the two suspect anti-immigrant militants. As they learn more about the dead man\'s past, Bruno\'s suspicions turn toward a more complex motive.','Martin Walker is the senior director of the Global Business Policy Council and editor emeritus and international affairs columnist at United Press International. Formerly Moscow and U.S. bureau chief for Britain\'s The Guardian, he is also a senior scholar at the Woodrow Wilson International Center for Scholars in Washington, D.C. His books include The Cold War: A History, a New York Times Notable Book and short-listed for the Whitbread Book of the Year Prize, and The Caves of Périgord, a novel. He has written for The New York Times, The New Yorker, and The Times Literary Supplement. He lives in Washington, D.C., and the southwest of France.','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Bruno-Chief-of-Police.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(61,'Ten Poems to Say Goodbye','Roge Housden',10,10,NULL,NULL,48,0,0,'In Ten Poems to Say Goodbye, the newest addition to the celebrated Ten Poems series, Roger Housden continues to highlight the magic of poetry, this time as it relates to personal loss. But while the selected poems in this volume may focus upon loss and grief, they also reflect solace, respite, and joy. ','ROGER HOUSDEN is the author of Ten Poems to Change Your Life; Ten Poems to Open Your Heart; Ten Poems to Set You Free; Ten Poems to Last a Lifetime; How Rembrandt Reveals Your Beautiful, Imperfect Self; Seven Sins for a Life Worth Living; Saved by Beauty; and the novella Chasing Rumi, and is also the editor of Risking Everything: 110 Poems of Love and Revelation and Dancing with Joy. Housden was born in England and now lives in the United States.','2011-02-19',NULL,NULL,'http://localhost:8080/cse308/images/books/Ten-Poems-to-Say-Goodbye.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(62,'The Big Bing','Stanley Bing',10,10,NULL,NULL,49,0,0,'After two decades in the belly of the corporate beast, clawing his way to the top of one of the great multinational companies in the cosmos, Stanley Bing has seen it all. The Big Bing provides a mole\'s-eye view of the society in which we all live and work, in Bing\'s trademark funny, wise, and pleasantly mean-spirited style.','N/A','2003-10-15',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Big-Bing.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(63,'Religion for Atheists','Alain de Botton',10,10,NULL,NULL,50,0,0,'What if religions are neither all true nor all nonsense? The long-running and often boring debate between fundamentalist believers and non-believers is finally moved forward by Alain de Botton\'s inspiring new book, which boldly argues that the supernatural claims of religion are entirely false--but that it still has some very important things to teach the secular world.','Alain de Botton is the author of essays on themes ranging from love and travel to architecture and philosophy. His best-selling books include How Proust Can Change Your Life, The Art of Travel and The Architecture of Happiness. He lives in London, where he is the founder and chairman of The School of Life (www.theschooloflife.com) and the creative director of Living Architecture (www.living-architecture.co.uk).','2012-03-06',NULL,NULL,'http://localhost:8080/cse308/images/books/Religion-for-Atheists.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(64,'All Else Confusion','Betty Neels',10,10,NULL,NULL,51,0,0,'Annis\'s life as daughter of the Rectory was a busy and happy one, certainly not lacking in love—but she loved Jake Royle even more than she loved her family. So when he proposed to her she didn\'t hesitate, even though she knew he didn\'t love her. Jake had said from the start that he didn\'t think love was necessary to make a marriage work. But even if she could accept his lack of feeling for her, would Jake ever admit Annis into his life? ','Romance author Betty Neels died peacefully in hospital on June 7, 2001, aged 91. Her career with Harlequin spanned 30 years, and she continued to write into her 90th year.','2011-04-05',NULL,NULL,'http://localhost:8080/cse308/images/books/All-Else-Confusion.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(65,'Partials','Dan Wells',10,10,NULL,NULL,52,0,0,'The human race is all but extinct after a war with Partials—engineered organic beings identical to humans—has decimated the population. Reduced to only tens of thousands by RM, a weaponized virus to which only a fraction of humanity is immune, the survivors in North America have huddled together on Long Island while the Partials have mysteriously retreated. The threat of the Partials is still imminent, but, worse, no baby has been born immune to RM in more than a decade. Our time is running out.','N/A','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/Partials.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(66,'Being with Dieing','Joan Halifax',10,10,NULL,NULL,53,0,0,'The Buddhist approach to death can be of greatbenefit to people of all backgrounds—as has been demonstrated time and again inJoan Halifax\'s decades of work with the dying and their caregivers. Inspired bytraditional Buddhist teachings, her work is a source of wisdom for all thosewho are charged with a dying person\'s care, facing their own death, or wishingto explore and contemplate the transformative power of the dying process. Herteachings affirm that we can open and contact our inner strength, and that wecan help others who are suffering to do the same. ','Joan Halifax, PhD, is a Zen priest and anthropologist who has served on the faculty of Columbia University and the University of Miami School of Medicine. For the past thirty years she has worked with dying people and has lectured on the subject of death and dying at Harvard Divinity School, Harvard Medical School, Georgetown Medical School, and many other academic institutions. In 1990, she founded Upaya Zen Center, a Buddhist study and social action center in Santa Fe, New Mexico. In 1994, she founded the Project on Being with Dying, which has trained hundreds of healthcare professionals in the contemplative care of dying people.','2011-04-15',NULL,NULL,'http://localhost:8080/cse308/images/books/Being-with-Dieing.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(67,'The Emerald Diamond','Charley Rosen',10,10,NULL,NULL,54,0,0,'From \"Casey at the Bat\" to Connie Mack to the Irish Sports Hall of Fame, here is the first-ever full history of the Irish people\'s impact on America\'s favorite past time, from its earliest years to its most significant milestones today. New York Times bestselling sportswriter Charlie Rosen, author of The Bullpen Diaries and More than Just a Game, delivers a one-of-a-kind instant classic perfect “for anyone who is Irish and loves baseball.” In the words of Jay P. Dolan, author of The Irish Americans, “The Emerald Diamond is a must read. It is a remarkable story about the achievements of the Irish throughout the history of baseball in America.”','Charley Rosen is an analyst for FoxSports.com and the coauthor with Phil Jackson of the bestseller More Than a Game. He is also the author of fifteen other sports books and has written more than a hundred pieces for publications such as the New York Times Book Review, Sport, Inside Sports, Penthouse, M, and Cigar Aficionado—the latest being a piece for Men\'s Journal about Phil Jackson\'s trip to Australia and New Zealand.','2012-02-28',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Emerald-Diamond.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(68,'Algebra','Denise Szecsei',10,10,NULL,NULL,55,0,0,'Homework Helpers: Algebra is a straightforward and easy-to-read review of arithmetic skills emphasizes the role that arithmetic plays in the development of algebra coversing all of the topics in a typical Algebra I class, including: Solving linear equalities and inequalities; Solving systems of linear equations; Factoring polynomials; Graphing functions; Working with rational functions; Solving quadratic equations; Understanding word problems; Homework Helpers: Algebra will help build a solid mathematical foundation and enable students to gain the confidence they need to study Algebra II. This book also contains a summary of important formulas for easy reference.','N/A','2011-12-07',NULL,NULL,'http://localhost:8080/cse308/images/books/Algebra.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(69,'Simon Says Die','Lena Diaz',10,10,NULL,NULL,56,0,0,'Simon says: I\'m watching. Simon says: I\'m coming. Simon says: Die.','Lena Diaz grew up a Navy Brat, but while two of her three siblings followed in her father\'s footsteps and joined the Navy, Lena loosely followed in her musically talented mother\'s footsteps by choosing a more creative path: writing. Her first novel-length manuscripts were paranormals ranging from contemporary vampire stories to medieval druid tales. Since dead bodies kept creeping into everything she wrote, she eventually turned to romantic suspense. Today Lena can be found in North Florida with her husband of twenty-plus years, her belly-dancing daughter, her mud-bogging son, a tri-colored Sheltie named Sparky, and a pair of Beta fish named Rocky Bal-Beta and Mr. T','2012-03-27',NULL,NULL,'http://localhost:8080/cse308/images/books/Simon-Says-Die.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(70,'Londoners','Craig Taylor',10,10,NULL,NULL,57,0,0,'“Craig Taylor is the real deal: a peerless journalist and a beautiful craftsman.”','N/A','2012-02-21',NULL,NULL,'http://localhost:8080/cse308/images/books/Londoners.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(71,'Dylan','C. H. Admirand',10,10,NULL,NULL,58,0,0,'PRAISE FOR TYLER: \"Guaranteed to sizzle in your hands.\"','N/A','2012-01-01',NULL,NULL,'http://localhost:8080/cse308/images/books/Dylan.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(72,'Data-Driven Marketing','Mark Jeffery ',10,10,NULL,NULL,49,0,0,'In the new era of tight marketing budgets, no organization can continue to spend on marketing without knowing what\'s working and what\'s wasted. Data-driven marketing improves efficiency and effectiveness of marketing expenditures across the spectrum of marketing activities from branding and awareness, trail and loyalty, to new product launch and Internet marketing. Based on new research from the Kellogg School of Management, this book is a clear and convincing guide to using a more rigorous, data-driven strategic approach to deliver significant performance gains from your marketing.','N/A','2010-01-29',NULL,NULL,'http://localhost:8080/cse308/images/books/Data-Driven-Marketing.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(73,'Do More Faster','Brad Feld',10,10,NULL,NULL,49,0,0,'TechStars is a mentorship-driven startup accelerator with operations in three U.S. cities. Once a year in each city, it funds about ten Internet startups with a small amount of capital and surrounds them with around fifty top Internet entrepreneurs and investors. Historically, about seventy-five percent of the companies that go through TechStars raise a meaningful amount of angel or venture capital. Do More Faster: TechStars Lessons to Accelerate Your Startup is a collection of advice that comes from individuals who have passed through, or are part of, this proven program. Each vignette is an exploration of information often heard during the TechStars program and provides practical insights into early stage entrepreneurship.','David Cohen is the founder and CEO of TechStars. He previously founded and successfully exited several companies and is now an angel investor in over 100 Internet startups.','2010-10-01',NULL,NULL,'http://localhost:8080/cse308/images/books/Do-More-Faster.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(74,'Why Nations Fail','James Robinson',10,10,NULL,NULL,49,0,0,'Daron Acemoglu and James Robinson conclusively show that it is man-made political and economic institutions that underlie economic success (or lack of it). Korea, to take just one of their fascinating examples, is a remarkably homogeneous nation, yet the people of North Korea are among the poorest on earth while their brothers and sisters in South Korea are among the richest. The south forged a society that created incentives, rewarded innovation, and allowed everyone to participate in economic opportunities. The economic success thus spurred was sustained because the government became accountable and responsive to citizens and the great mass of people. Sadly, the people of the north have endured decades of famine, political repression, and very different economic institutions--with no end in sight. The differences between the Koreas is due to the politics that created these completely different institutional trajectories. ','JAMES A. ROBINSON, a political scientist and an economist, is the David Florence Professor of Government at Harvard University. A world-renowned expert on Latin America and Africa, he has worked in Botswana, Mauritius, Sierra Leone, and South Africa.','2012-03-20',NULL,NULL,'http://localhost:8080/cse308/images/books/Why-Nations-Fail.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(75,'At Home','Bill Bryson',10,10,NULL,NULL,30,0,0,'Bill Bryson and his family live in a Victorian parsonage in a part of England where nothing of any great significance has','N/A','2010-10-05',NULL,NULL,'http://localhost:8080/cse308/images/books/At-Home.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(76,'Vanished Smile','R.A. Scotti',10,10,NULL,NULL,30,0,0,'No story captured the imagination of the world quite like this one. Thousands flocked to the Louvre to see the empty space where the painting had hung. They mourned as if Mona Lisa were a lost loved one, left flowers and notes, and set new attendance records. For more than two years, Mona Lisa’s absence haunted the art world, provoking the question: Was she lost forever? A century later, questions still linger. ','N/A','2009-04-07',NULL,NULL,'http://localhost:8080/cse308/images/books/Vanished-Smile.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(77,'The Lost Painting','Jonathan Harr',10,10,NULL,NULL,30,0,0,'An Italian village on a hilltop near the Adriatic coast, a decaying palazzo facing the sea, and in the basement, cobwebbed and dusty, lit by a single bulb, an archive unknown to scholars. Here, a young graduate student from Rome, Francesca Cappelletti, makes a discovery that inspires a search for a work of art of incalculable value, a painting lost for almost two centuries.','N/A','2006-06-27',NULL,NULL,'http://localhost:8080/cse308/images/books/The-Lost-Painting.jpg',2,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(78,'Fables of the Reconstruction','R.E.M.',10,10,NULL,NULL,59,0,0,'(P) 2010 Capitol Records, LLC. All rights reserved. Unauthorized reproduction is a violation of applicable laws. Manufactured by Capitol Catalog, 1750 North Vine Street, Hollywood, CA 90028','N/A','2010-07-13',NULL,NULL,'http://localhost:8080/cse308/images/music/Fables-of-the-Reconstruction.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(79,'DELIBES: Best of French Ballet','Leo Delibes',10,10,NULL,NULL,60,0,0,'01 Slav Theme and Variations / Coppelia, Ballet Suite','N/A','2005-07-26',NULL,NULL,'http://localhost:8080/cse308/images/music/DELIBES-Best-of-French-Ballet.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(80,'Blues Master','Buddy Guy',10,10,NULL,NULL,61,0,0,'1. A Man And The Blues (Buddy Guy)','N/A','1997-09-30',NULL,NULL,'http://localhost:8080/cse308/images/music/Blues-Master.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(81,'A Bach Halloween, Volume 3','John William Hunt',10,10,NULL,NULL,62,0,0,'1. Prelude and Fugue in C minor, BWV.549 ','N/A','2008-01-22',NULL,NULL,'http://localhost:8080/cse308/images/music/A-Bach-Halloween-Volume-3.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(82,'ENGLISH CHORAL MUSIC','Lenox Berkeley',10,10,NULL,NULL,63,0,0,'01 Magnificat in G, Op. 81','N/A','2006-05-18',NULL,NULL,'http://localhost:8080/cse308/images/music/ENGLISH-CHORAL-MUSIC.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(83,'100 Best Karajan','Herbert Von Karajan',10,10,NULL,NULL,64,0,0,'1. Serenade No. 13 in G, K.525 \'Eine kleine Nachtmusik\' (1988 - Remaster): I. Allegro (Berliner Philharmoniker/Herbert von Karajan)','N/A','2008-10-28',NULL,NULL,'http://localhost:8080/cse308/images/music/100-Best-Karajan.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(84,'MOZART: Piano Concertos','Wolgang Amadeus Mozart',10,10,NULL,NULL,65,0,0,'01 Piano Concerto No. 23, A major, K. 488, K. 488, A major: Allegro','N/A','2006-05-18',NULL,NULL,'http://localhost:8080/cse308/images/music/MOZART-Piano-Concertos.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(85,'100 Best Film Classics','Various Artists',10,10,NULL,NULL,66,0,0,'1. Also sprach Zarathustra, Op. 30 (opening) (London Philharmonic Orchestra/David Bell/Klaus Tennstedt)','N/A','2007-06-19',NULL,NULL,'http://localhost:8080/cse308/images/music/100-Best-Film-Classics.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(86,'Any Day Now','Joan Baez',10,10,NULL,NULL,67,0,0,'1. Love Minus Zero / No Limit (Joan Baez)','N/A','2011-06-20',NULL,NULL,'http://localhost:8080/cse308/images/music/Any-Day-Now.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(87,'Music of the Italian Renaissance','Jacques Arcadelt',10,10,NULL,NULL,68,0,0,'01 La pastorella mia','N/A','2006-05-18',NULL,NULL,'http://localhost:8080/cse308/images/music/Music-of-the-Italian-Renaissance.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(88,'The Best of Louis Armstrong','Louis Armstrong',10,10,NULL,NULL,69,0,0,'1. When It\'s Sleepy Time Down South (Louis Armstrong)','N/A','1998-09-15',NULL,NULL,'http://localhost:8080/cse308/images/music/The-Best-of-Louis-Armstrong.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(89,'3','Nouvelle Vague',10,10,NULL,NULL,70,0,0,'1. Master And Servant (Nouvelle Vague Featuring Martin Gore)','N/A','2009-10-20',NULL,NULL,'http://localhost:8080/cse308/images/music/3.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(90,'Aida','Herbert Von Karajan',10,10,NULL,NULL,71,0,0,'1. Aida (1986 Digital Remaster): Preludio (Wiener Philharmoniker/Herbert von Karajan)','N/A','2007-07-03',NULL,NULL,'http://localhost:8080/cse308/images/music/Aida.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(91,'Great Classical Symphonies','Ludwig Van Beethoven',10,10,NULL,NULL,72,0,0,'01 Symphony No. 5 in C minor, Op. 67: Allegro con brio','N/A','2006-05-18',NULL,NULL,'http://localhost:8080/cse308/images/music/Great-Classical-Symphonies.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(92,'20 Rock \'n\' Roll Hits','Wanda Jackson',10,10,NULL,NULL,73,0,0,'1. Long Tall Sally (2002 - Remaster) (Wanda Jackson)','N/A','2011-04-19',NULL,NULL,'http://localhost:8080/cse308/images/music/20-Rock-n-Roll-Hits.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(93,'Baez Sings Dylan','Joan Baez',10,10,NULL,NULL,74,0,0,'1. Love Minus Zero/No Limit (Joan Baez)','N/A','2006-01-03',NULL,NULL,'http://localhost:8080/cse308/images/music/Baez-Sings-Dylan.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(94,'32 Great Songs of Ireland','CMR Records',10,10,NULL,NULL,75,0,0,'1. The Isle of Innisfree (Louise Morrissey)','N/A','2006-02-20',NULL,NULL,'http://localhost:8080/cse308/images/music/32-Great-Songs-of-Ireland.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(95,'Hazards of Love','Capitol Records',10,10,NULL,NULL,59,0,0,'1. Prelude (The Decemberists)','N/A','2009-03-24',NULL,NULL,'http://localhost:8080/cse308/images/music/Hazards-of-Love.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(96,'The King Is Dead','The Decemberists',10,10,NULL,NULL,59,0,0,'1. Don\'t Carry It All (The Decemberists)','N/A','2011-01-18',NULL,NULL,'http://localhost:8080/cse308/images/music/The-King-Is-Dead.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(97,'LCD Soundsystem','LCD Soundsystem',10,10,NULL,NULL,59,0,0,'1. Daft Punk Is Playing At My House (LCD Soundsystem)','N/A','2005-02-15',NULL,NULL,'http://localhost:8080/cse308/images/music/LCD-Soundsystem.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(98,'Mezzanine--The Remixes','Massive Attack',10,10,NULL,NULL,59,0,0,'1. Risingson (Underdog Mix) (Massive Attack)','N/A','2006-08-29',NULL,NULL,'http://localhost:8080/cse308/images/music/Mezzanine-The-Remixes.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(99,'Supernature (US Version)','Goldfrapp',10,10,NULL,NULL,59,0,0,'1. Ooh La La (Goldfrapp)','N/A','2006-03-07',NULL,NULL,'http://localhost:8080/cse308/images/music/Supernature.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(100,'We Are Glitter','Goldfrapp',10,10,NULL,NULL,59,0,0,'1. Satin Chic (Bombay Mix by The Shortwave Set) (Goldfrapp)','N/A','2006-10-17',NULL,NULL,'http://localhost:8080/cse308/images/music/We-Are-Glitter.jpg',3,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-09'),(101,'A Polish Boy and His President','Piotr Kasperek',10,10,NULL,'amazoink',18,0,0,'Some stories are filled with joy, and others are filled with sadness. Each and every one of them have a meaning so read carefuly. Enjoy ','Piotr Kasperek is a hard working boy who came from southern Poland who came to Greenpoint and got a bank card from the Polish & Slavic Credit Union. One day he learned a lesson about President Eisenhower and now he has a whole series on the US Presidents.','2011-01-01',NULL,NULL,'http://localhost:8080/cse308/images/music/piotr.jpg',1,'Copyright Protection (DRM) required by the Publisher may be applied to this title to limit or prohibit printing or copying. File sharing or redistribution is prohibited. Your rights to access this material expire at the end of the lending period. Please see Important Notice about Copyrighted Materials for terms applicable to this content.','2012-05-11');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`pkasperek`@`%`*/ /*!50003 TRIGGER triggerName
  BEFORE INSERT ON item
  FOR EACH ROW
    SET NEW.dateAdded = curdate() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `yumfood`
--

DROP TABLE IF EXISTS `yumfood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumfood` (
  `idyumFood` int(11) NOT NULL AUTO_INCREMENT,
  `portionSize` varchar(45) DEFAULT NULL,
  `calories` varchar(45) DEFAULT NULL,
  `totalFat` varchar(45) DEFAULT NULL,
  `cholesterol` varchar(45) DEFAULT NULL,
  `sodium` varchar(45) DEFAULT NULL,
  `carbohydrates` varchar(45) DEFAULT NULL,
  `fiber` varchar(45) DEFAULT NULL,
  `protein` varchar(45) DEFAULT NULL,
  `locationServed` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `foodImage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idyumFood`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumfood`
--

LOCK TABLES `yumfood` WRITE;
/*!40000 ALTER TABLE `yumfood` DISABLE KEYS */;
INSERT INTO `yumfood` VALUES (1,'4 oz','310','20','105','85','0','0','29','Charcoals','Hamburger','Hamburger.png'),(2,'4 oz','220','17','85','85','0','0','22','Charcoals','Turkey Burger','default.png'),(3,'3 oz','110','3.5','0','350','9','3','10','Charcoals','Garden Vegetable Burger','default.png'),(4,'4 oz','156','5.6','62','70','0','0','25','Charcoals','Grilled Chicken Breast','default.png'),(5,'6 oz','450','29','150','90','0','0','45','Charcoals','NY Steak','default.png'),(6,'4 oz','280','21','75','75','0','0','22','Charcoals','Philly Steak','default.png'),(7,'2 oz','170','15','20','530','1','0','7','Charcoals','Hot Dog','default.png'),(8,'1 oz','80','9','20','360','1','0','6','Charcoals','American Cheese','default.png'),(9,'1 oz','100','8','25','60','1','0','8','Charcoals','Swiss Cheese','default.png'),(10,'1 oz','114','7.5','30','176','0','0','7','Charcoals','Cheddar Cheese','default.png'),(11,'2 oz','10','1.5','0','4.5','1.8','1.1','7','Charcoals','Romane Lettuce','default.png'),(12,'2 oz','13','1.7','0','1.9','2.6','3','3','Charcoails','Fresh Tomato','default.png'),(13,'1 oz','25','2','0','0','2','0','0','Charcoals','Sauteed Peppers','default.png'),(14,'1 oz','25','2','0','0','2','1','1','Charcoals','Sauteed Onions','default.png'),(15,'.5 oz','77','6','15','310','0','0','5','Charcoals','Bacon','default.png'),(16,'6 Pieces','540','27','60','4500','54','1','4','Charcoals','Mozzarella Sticks','default.png'),(17,'6 oz','360','14','0','700','52','4','4','Charcoals','Onion Rings','default.png'),(18,'6 oz','280','10','0','200','22','2','2','Charcoals','Fries','default.png'),(19,'6 oz','240','8','0','380','42','4','4','Charcoals','Waffle Fries','default.png'),(20,'4 oz','308','19.2','51','720','16.7','0','18','Charcoals','Chicken Tenders','default.png'),(21,'8 oz','210','1','0','4','42','1','7','Mulberry Street','Spaghetti','default.png'),(22,'2 oz','77','1','0','528','16','4','3','Mulberry Street','Marinara Sauce','default.png'),(23,'2 oz','306','31','106','275','2','0','5','Mulberry Street','Alfredo Sauce','default.png'),(24,'2 oz','181','14','51','235','1','0','12','Mulberry Street','Mozzarella Cheese','default.png'),(25,'1 slice','474','9','0','1972','70','2.5','11','Mulberry Street','Cheese Pizza','default.png'),(26,'1 slice','511','12','0','1975','79','3','20','Mulberry Street','Pepperoni Pizza','default.png'),(27,'1 slice','511','13','0','2011','79','3','20','Mulberry Street','Sausage Pizza','default.png'),(28,'1 slice','515','14','0','2065','75','2.5','14','Mulberry Street','Bacon Pizza','default.png'),(29,'1 slice','477','7','0','1972','75','4.5','11','Mulberry Street','Broccoli Pizza','default.png'),(30,'1 slice','412','9','0','1868','75','4','11','Mulberry Street','Mushroom Pizza','default.png'),(31,'1 slice','495','11','0','1875','75','4','19','Mulberry Street','Pepper & Onion Pizza','default.png'),(32,'1 slice','505','11','0','2065','75','2','17','Mulberry Street','Meatball Pizza','default.png'),(33,'1 slice','465','9','0','1972','65','2','11','Mulberry Street','Whole Wheat Pizza','default.png'),(34,'1 knot','90','2','0','140','14','1','3','Mulberry Street','Garlic Knots','default.png'),(35,'1 each','84','0.6','0','0','21.9','1.9','0.3','Other','Apple','default.png'),(36,'1 each','139','0.7','0','2','35.4','2.4','1.6','Other','Banana','default.png'),(37,'4 oz','77','0.3','0','3','19.8','0.8','2.1','Other','Grapes','default.png'),(38,'1 each','53','0.1','0','0','13.3','2.7','1.1','Other','Orange','default.png'),(39,'1 each','72','0.1','0','0','15.9','2.3','1','Other','Peach, Fresh','default.png'),(40,'1 each','120','0.8','0','0','30.8','5.3','0.8','Other','Pear, Fresh','default.png'),(61,'5.5 oz','310','7','15','560','52','1','21','Charcoals','Cauliflower Burger','default.png'),(62,'5.5 oz','240','10','20','410','30','10','13','Charcoals','Sweet Potato Burger','default.png'),(63,'5.5 oz','210','12','5','310','23','5','9','Charcoals','Eggplant Burger','default.png'),(64,'5.5 oz','200','3.5','25','620','35','4','4','Charcoals','Black Bean Burger','default.png'),(65,'1 oz','80','6','20','200','1','0','6','Charcoals','Mozzarella Cheese','default.png'),(66,'1 oz','100','8','30','170','1','0','7','Charcoals','Monterey Jack Cheese','default.png'),(67,'1 oz','100','8','20','190','1','0','8','Charcoals','Provolone Cheese','default.png'),(68,'1 oz','25','2','0','0','1','0','1','Charcoals','Sauteed Mushrooms','default.png'),(69,'1 bun','160','3','0','125','30','1','5','Charcoals','House Hamburger Roll','default.png'),(70,'1 bun','300','7','0','540','48','7','11','Charcoals','4\" Rolls 50% Whole Wheat','default.png'),(71,'1 bun','220','2','0','430','46','4','9','Charcoals','6\" Whole Wheat Club','default.png'),(72,'1 bun','228','2','0','460','42','2','8','Charcoals','Kaiser Roll','default.png'),(73,'1 bun','130','2','0','250','24','> `','4','Charcoals','Hot Dog Bun','default.png'),(74,'1 slice','80','1','0','170','15','1','3','Charcoals','Wheat Bread','default.png'),(75,'1 slice','80','1','0','160','16','1','2','Charcoals','White Bread','default.png'),(76,'1 slice','70','5','0','200','14','1','3','Charcoals','Rye Bread','default.png'),(77,'1 - 5.5. oz','380','3','0','820','1','3','13','Charcoals','Italian Footer','default.png'),(78,'6 pieces','330','16','15','990','37','3','9','Charcoals','Mac & Cheese Bites','default.png'),(79,'6 pieces','360','12','30','1380','48','6','12','Charcoals','Broccoli Cheddar Bites','default.png'),(80,'6 oz','300','8','0','230','52','6','2','Charcoals','Sweet Potato Fries','default.png'),(81,'6 pieces','330','10.5','30','710','48','3','12','Charcoals','Jalapeno Poppers','default.png'),(82,'10 pieces','250','13','25','780','18','2','16','Charcoals','Popcorn Chicken','default.png'),(83,'10 pieces','270','15','20','790','18','1','16','Charcoals','Buffalo Popcorn Chicken','default.png'),(124,'N/A','631','7','22','1296','123','12','25','Mulberry Street','Pasta Marinara w/ Shrimp, Z, YS, M','default.png'),(125,'N/A','635','7','7','1282','123','12','25','Mulberry Street','Pasta Marinara w/ Chicken, Z, YS, M','default.png'),(126,'4 oz','173','7.6','0','4.2','37','6.3','7.5','Mulberry Street','Whole Wheat Pasta (cooked)','default.png'),(127,'2 oz','28','1','0','1614','3','2','2','Mulberry Street','Sauteed Broccoli','default.png'),(128,'2 oz','25','2','0','219','3','1','1','Mulberry Street','Grilled Vegetables','default.png'),(129,'2 oz','22','1','0','1620','3','1','1','Mulberry Street','Sauteed Artichokes','default.png'),(130,'2 oz','31','1','0','1601','5','1','1','Mulberry Street','Sauteed Onions','default.png'),(131,'2 oz','25','1','0','1601','3','1','1','Mulberry Street','Sauteed Mushrooms','default.png'),(132,'2 oz','24','1','0','1600','3','1','N/A','Mulberry Street','Sauteed Peppers','default.png'),(133,'2 oz','19','1','0','1601','2','1','1','Mulberry Street','Sauteed Summer Squash','default.png'),(134,'2 oz','19','1','0','1601','2','1','1','Mulberry Street','Sauteed Zucchini','default.png'),(135,'2 oz','214','2','0','60','45','11','8','Mulberry Street','Vegetarian Tuscan Style Sauce','default.png'),(136,'2 oz','132','11','37','29','N/A','0','6','Mulberry Street','Bolognese Sauce','default.png'),(137,'2 oz','529','53','26','435','3','1','13','Mulberry Street','Pesto Sauce','default.png'),(138,'2 oz','43','3','0','4','1','1','5','Mulberry Street','Tofu','default.png'),(139,'2 oz','60','1','86','84','N/A','0','11','Mulberry Street','Shrimp','default.png'),(140,'2 oz','213','16','75','247','5','N/A','11','Mulberry Street','Mini Meatballs','default.png'),(141,'2 oz','196','18','43','415','N/A','0','8','Mulberry Street','Italian Sausage','default.png'),(142,'6 oz','94','1','49','55','0','0','20','Mulberry Street','Grilled Chicken Breast','default.png'),(143,'1 slice','186','4','0','439','35','4','7','Mulberry Street','Whole Wheat Veg. Supreme Pizza w/out Cheese','default.png'),(144,'1 slice','186','4','0','439','35','4','7','Mulberry Street','Veg. Supreme Pizza w/o Cheese','default.png'),(145,'1 slice','429','19','51','820','48','5','21','Mulberry Street','Veg. Supreme Pizza w/ Cheese','default.png'),(146,'1 slice','555','14','0','2144','78','2','19','Mulberry Street','Sausage & Pepperoni Pizza','default.png'),(147,'1 serving','150','0','0','5','0','0','0','Custom','Wendy\'s Large Lemonaid','default.png'),(148,'1 serving','','','','','','','','Custom','','default.png');
/*!40000 ALTER TABLE `yumfood` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `music` (
  `idMusic` int(11) NOT NULL AUTO_INCREMENT,
  `durationOfItem` int(11) DEFAULT NULL,
  `numberOfParts` int(11) DEFAULT NULL,
  `sampleOfItemDownloadURL` varchar(45) DEFAULT NULL,
  `excerptOfItemDownloadURL` varchar(45) DEFAULT NULL,
  `burnToCd` varchar(45) DEFAULT NULL,
  `transferToDevice` varchar(45) DEFAULT NULL,
  `transferToAppleDevice` varchar(45) DEFAULT NULL,
  `publicPerformance` varchar(45) DEFAULT NULL,
  `fileSharing` varchar(45) DEFAULT NULL,
  `peerToPeerUsage` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMusic`),
  KEY `MusicItemId` (`idMusic`),
  KEY `musicitem_id` (`item_id`),
  CONSTRAINT `musicitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,30,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,78),(2,20,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/music/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,79),(3,33,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,80),(4,45,NULL,'http://localhost:8080/cse308/music/4.mp3','http://localhost:8080/cse308/music/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,81),(5,38,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,82),(6,37,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/music/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,83),(7,82,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,84),(8,46,NULL,'http://localhost:8080/cse308/music/4.mp3','http://localhost:8080/cse308/music/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,85),(9,94,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,86),(10,73,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/exerpt/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,87),(11,26,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,88),(12,85,NULL,'http://localhost:8080/cse308/music/4.mp3','http://localhost:8080/cse308/music/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,89),(13,28,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,90),(14,74,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/music/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,91),(15,27,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,92),(16,55,NULL,'http://localhost:8080/cse308/music/4.mp3','http://localhost:8080/cse308/music/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,93),(17,37,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,94),(18,28,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/music/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,95),(19,75,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,96),(20,37,NULL,'http://localhost:8080/cse308/music/4.mp3','http://localhost:8080/cse308/music/4.mp3',NULL,NULL,NULL,NULL,NULL,NULL,97),(21,27,NULL,'http://localhost:8080/cse308/music/1.mp3','http://localhost:8080/cse308/music/1.mp3',NULL,NULL,NULL,NULL,NULL,NULL,98),(22,85,NULL,'http://localhost:8080/cse308/music/2.mp3','http://localhost:8080/cse308/music/2.mp3',NULL,NULL,NULL,NULL,NULL,NULL,99),(23,27,NULL,'http://localhost:8080/cse308/music/3.mp3','http://localhost:8080/cse308/music/3.mp3',NULL,NULL,NULL,NULL,NULL,NULL,100);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userviewhistory`
--

DROP TABLE IF EXISTS `userviewhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userviewhistory` (
  `idUserViewHistory` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `review` text,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUserViewHistory`),
  KEY `userviewhistoryitem_id` (`item_id`),
  KEY `userviewhistoryuser_id` (`user_id`),
  CONSTRAINT `userviewhistoryitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userviewhistoryuser_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userviewhistory`
--

LOCK TABLES `userviewhistory` WRITE;
/*!40000 ALTER TABLE `userviewhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userviewhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yumachievement`
--

DROP TABLE IF EXISTS `yumachievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yumachievement` (
  `idachievement` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `image` varchar(45) DEFAULT NULL,
  `achievementPage` text,
  `description` text,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`idachievement`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yumachievement`
--

LOCK TABLES `yumachievement` WRITE;
/*!40000 ALTER TABLE `yumachievement` DISABLE KEYS */;
INSERT INTO `yumachievement` VALUES (1,'Learn a lesson from Jon','trophy10.png',NULL,'You have successfully learned your lesson.',10),(2,'Add first meal','trophy5.png',NULL,'Add your first meal.',5),(3,'Reach your goal','trophy50.png',NULL,'You\'ve reached your goal weight! Congratulations, you\'ve won.',50),(4,'Complete First Day','trophy10.png',NULL,'You\'ve successfully completed your first day.',10),(5,'Complete First Week','trophy25.png',NULL,'You\'ve successfully completed your first week.',25);
/*!40000 ALTER TABLE `yumachievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlistitem`
--

DROP TABLE IF EXISTS `wishlistitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wishlistitem` (
  `idWishlistItem` int(11) NOT NULL AUTO_INCREMENT,
  `dateAddedToWishlist` datetime DEFAULT NULL,
  `lendingPeriodOfItem` int(11) DEFAULT NULL,
  `formatOfItem` varchar(45) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `wishlistName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idWishlistItem`),
  KEY `wishlistitem_id` (`item_id`),
  KEY `wishlistitemuser_id` (`user_id`),
  CONSTRAINT `wishlistitemuser_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wishlistitem_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlistitem`
--

LOCK TABLES `wishlistitem` WRITE;
/*!40000 ALTER TABLE `wishlistitem` DISABLE KEYS */;
INSERT INTO `wishlistitem` VALUES (1,'2012-05-07 16:04:30',NULL,'1',3,1,NULL),(5,'2012-05-07 16:15:56',NULL,'1',6,1,NULL),(8,'2012-05-11 05:03:15',NULL,'1',42,1,NULL);
/*!40000 ALTER TABLE `wishlistitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemrequest`
--

DROP TABLE IF EXISTS `itemrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemrequest` (
  `idItemRequest` int(11) NOT NULL,
  `itemBeingRequested` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idItemRequest`),
  KEY `itemrequestitem_id` (`ISBN`),
  KEY `itemrequestionuser_id` (`user_id`),
  CONSTRAINT `itemrequestionuser_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`idUserLibraryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemrequest`
--

LOCK TABLES `itemrequest` WRITE;
/*!40000 ALTER TABLE `itemrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemrequest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-22 17:23:40
