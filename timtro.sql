-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: timtro
-- ------------------------------------------------------
-- Server version	8.0.39
DROP DATABASE timtro;
CREATE DATABASE timtro;
USE timtro;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chat_message`
--

DROP TABLE IF EXISTS `chat_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recipient_id` int DEFAULT NULL,
  `sender_id` int DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_message`
--

LOCK TABLES `chat_message` WRITE;
/*!40000 ALTER TABLE `chat_message` DISABLE KEYS */;
INSERT INTO `chat_message` VALUES (1,2,1,'2024-11-30 10:54:14.988824','1_2','hello'),(2,1,2,'2024-11-30 10:54:49.855095','1_2','bạn muốn thuê nhà trọ nào ạ'),(3,2,3,'2024-11-30 11:07:17.390364','3_2','hello ptit'),(4,1,3,'2024-11-30 11:11:19.880039','1_3','hello'),(5,3,1,'2024-11-30 11:12:55.828380','1_3','hi'),(6,1,3,'2024-11-30 11:13:31.448160','1_3','abc'),(7,1,3,'2024-11-30 11:13:52.802132','1_3','fdfdf'),(8,3,1,'2024-11-30 11:13:55.098652','1_3','fdfd'),(9,3,2,'2024-11-30 11:14:28.816163','3_2','bạn cần thuê nhà trọ đúng không?'),(10,2,3,'2024-11-30 11:14:41.395704','3_2','đúng rồi ạ'),(11,1,3,'2024-11-30 11:15:30.382107','1_3','bạn là admin phải không'),(12,3,1,'2024-11-30 11:15:34.759395','1_3','đúng rồi');
/*!40000 ALTER TABLE `chat_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_room`
--

DROP TABLE IF EXISTS `chat_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recipient_id` int DEFAULT NULL,
  `sender_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_room`
--

LOCK TABLES `chat_room` WRITE;
/*!40000 ALTER TABLE `chat_room` DISABLE KEYS */;
INSERT INTO `chat_room` VALUES (1,1,2,'2024-11-30 10:54:07.394398','2024-11-30 10:54:07.394398','1_2'),(2,2,1,'2024-11-30 10:54:07.402812','2024-11-30 10:54:07.402812','1_2'),(3,3,2,'2024-11-30 11:07:08.094341','2024-11-30 11:07:08.094341','3_2'),(4,2,3,'2024-11-30 11:07:08.113368','2024-11-30 11:07:08.113368','3_2'),(5,1,3,'2024-11-30 11:08:01.134091','2024-11-30 11:08:01.134091','1_3'),(6,3,1,'2024-11-30 11:08:01.138117','2024-11-30 11:08:01.138117','1_3');
/*!40000 ALTER TABLE `chat_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `motelid` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlpjsjn9ag2tstjsa1m6qildxi` (`motelid`),
  CONSTRAINT `FKlpjsjn9ag2tstjsa1m6qildxi` FOREIGN KEY (`motelid`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel`
--

DROP TABLE IF EXISTS `motel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel` (
  `area` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `maxpeople` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4p1qlqh5v1lo22tccqqx9ydt9` (`userid`),
  CONSTRAINT `FK4p1qlqh5v1lo22tccqqx9ydt9` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel`
--

LOCK TABLES `motel` WRITE;
/*!40000 ALTER TABLE `motel` DISABLE KEYS */;
/*!40000 ALTER TABLE `motel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,'ADMIN'),(2,NULL,NULL,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleid` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `tokenexpirydate` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fileurl` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `resettoken` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ovmsl4hvm5vu1w8i308r5j6w` (`roleid`),
  CONSTRAINT `FK2ovmsl4hvm5vu1w8i308r5j6w` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'2024-11-30 10:51:13.324424',NULL,'2024-11-30 10:51:13.324424','daongocson12022004@gmail.com',NULL,'Đào Ngọc Sơn','$2a$10$f35BNGjAuNv6J2XYy5Gbse7PICJCX/vSppKfv3jEn1VzDbe.K8BVi','0904155772',NULL,'admin'),(2,2,'2024-11-30 10:53:00.122760',NULL,'2024-11-30 10:53:00.122760','daongocson2k4@gmail.com',NULL,'Trần Anh Tú','$2a$10$xAVli5VZIdk0E/xkVptrLOVvvJojKyt6o1olN/jNpezZg8hx4Tx3W','0987654321',NULL,'user1'),(3,2,'2024-11-30 11:06:50.197857',NULL,'2024-11-30 11:06:50.197857','atus25012004@gmail.com',NULL,'Ngô Hông Phúc','$2a$10$klbG68lBzGXn2Wg0Qw5pFO81rjTz3B87kPjrMLeUdNn.hSkIO0qeS','0973320282',NULL,'user2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userfavorites`
--

DROP TABLE IF EXISTS `userfavorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userfavorites` (
  `motelid` int NOT NULL,
  `userid` int NOT NULL,
  KEY `FKqks4ps8kjrxhl4h0xgpyayd2e` (`motelid`),
  KEY `FK7p1a9t4ornryqhnp8n85cac9f` (`userid`),
  CONSTRAINT `FK7p1a9t4ornryqhnp8n85cac9f` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqks4ps8kjrxhl4h0xgpyayd2e` FOREIGN KEY (`motelid`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userfavorites`
--

LOCK TABLES `userfavorites` WRITE;
/*!40000 ALTER TABLE `userfavorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `userfavorites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-30 11:18:57
