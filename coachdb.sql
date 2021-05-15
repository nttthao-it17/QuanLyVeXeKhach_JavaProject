-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: coachdb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `booking_ticket`
--

DROP TABLE IF EXISTS `booking_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_ticket` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `amount` int NOT NULL,
  `date_created` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_bt_idx` (`user_id`),
  CONSTRAINT `user_id_bt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_ticket`
--

LOCK TABLES `booking_ticket` WRITE;
/*!40000 ALTER TABLE `booking_ticket` DISABLE KEYS */;
INSERT INTO `booking_ticket` VALUES (1,2,2,'2021-05-18'),(2,1,3,'2021-03-04'),(3,3,1,'2021-05-01');
/*!40000 ALTER TABLE `booking_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_fb_idx` (`user_id`),
  CONSTRAINT `user_id_fb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,3,'Dịch vụ tốt, phục vụ chu đáo','2021-05-25'),(2,1,'Khá ổn, giá cả hợp lý','2021-06-01'),(3,2,'Đón khách trễ','2021-03-04');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `station_from` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `station_to` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'BX Nguyễn Văn Lượng - Gò Vấp','BX Đà Lạt'),(2,'BX Hàng Xanh - Bình Thạnh','BX Đồng Nai'),(3,'BX Bạch Đằng - Tân Bình','BX Đà Lạt');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_detail`
--

DROP TABLE IF EXISTS `ticket_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_detail` (
  `id` int NOT NULL,
  `trip_id` int NOT NULL,
  `booking_id` int NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `trip_id_td_idx` (`trip_id`),
  KEY `booking_id_td_idx` (`booking_id`),
  CONSTRAINT `booking_id_td` FOREIGN KEY (`booking_id`) REFERENCES `booking_ticket` (`id`),
  CONSTRAINT `trip_id_td` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_detail`
--

LOCK TABLES `ticket_detail` WRITE;
/*!40000 ALTER TABLE `ticket_detail` DISABLE KEYS */;
INSERT INTO `ticket_detail` VALUES (1,2,2,1560000,1),(2,3,1,180000,1),(3,2,3,520000,1);
/*!40000 ALTER TABLE `ticket_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `route_id` int NOT NULL,
  `trip_description` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `coach_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_started` date NOT NULL,
  `time_started` time NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `route_id_trip_idx` (`route_id`),
  CONSTRAINT `route_id_trip` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,1,'Sài Gòn - Đà Lạt','Huyndai 24 chỗ','2021-04-19','07:00:00',300000),(2,3,'Sài Gòn - Đà Lạt','Limousin 16 chỗ','2021-05-01','18:00:00',520000),(3,2,'Sài Gòn - Đồng Nai','Thaco 54 chỗ','2021-03-20','09:00:00',90000);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userRole` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Thao Nguyen','thao123','$2a$10$mbTPNvMI0VmVZed/P/6NH.HkqjYSy8FAr3uoFfjPChw3BXhk9SwvS','thuthao@gmail.com','090912345','ROLE_ADMIN'),(2,'Bao Nguyen','habao1','1','bao@gmail.com','0912387421','ROLE_USER'),(3,'Thu Thao','thuthao2','1','thao@gmail.com','0812345678','ROLE_USER'),(4,'Nguyá»n Thá» Thu Tháº£o','admin','$2a$10$mbTPNvMI0VmVZed/P/6NH.HkqjYSy8FAr3uoFfjPChw3BXhk9SwvS','1751012096thao@ou.edu.vn','0336712433','ROLE_USER'),(5,'Tiki','admin','$2a$10$0ix1Ytj92kIyyBRuEWQxIuVAM.MFx9yI2rdwdYqi9miuGCLV.XxQ6','tiki@gmail.com','0138734532','ROLE_USER'),(6,'shopee','admin','$2a$10$zU1umaGRNFnTSnEygp9C4edAa9Oc2.uIZsEaIYfZgTbtRTjKNH.V6','shopee@gmail.com','0472861742','ROLE_USER'),(7,'Shopee','thuthao','$2a$10$latC2rg5U0m3VzdC/dC9y.FYoiUB3rhf5VcbjXrvSHXwizHlTaeqW','shopee1@gmail.com','0729585824','ROLE_USER');
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

-- Dump completed on 2021-05-13 23:53:30
