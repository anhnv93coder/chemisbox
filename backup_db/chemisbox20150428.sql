-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: chemisbox
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `edited_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','admin','Administrator','No address','0988123888','2015-04-26 00:00:00',NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chemical`
--

DROP TABLE IF EXISTS `chemical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chemical` (
  `chemical_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `difference_name` varchar(100) DEFAULT NULL COMMENT 'Tên khác',
  `formula` varchar(50) DEFAULT NULL COMMENT 'Công thức',
  `quantity` int(11) DEFAULT NULL COMMENT 'Khối lượng',
  `description` varchar(500) DEFAULT NULL COMMENT 'Mô tả',
  `density` varchar(200) DEFAULT NULL COMMENT 'Tỷ trọng',
  `melting_temperature` varchar(100) DEFAULT NULL COMMENT 'Độ nóng chảy',
  `boiling_temperature` varchar(100) DEFAULT NULL COMMENT 'Độ sôi',
  `solubility_in_water` varchar(100) DEFAULT NULL COMMENT 'Độ hòa tan trong nước',
  `ignition_point` varchar(100) DEFAULT NULL COMMENT 'Điểm bắt lửa',
  `flavour` varchar(100) DEFAULT NULL COMMENT 'Mùi',
  `img` varchar(200) DEFAULT NULL COMMENT 'ảnh',
  `created_date` datetime DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  `last_user_modify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`chemical_id`),
  UNIQUE KEY `FK_Formula` (`formula`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chemical`
--

LOCK TABLES `chemical` WRITE;
/*!40000 ALTER TABLE `chemical` DISABLE KEYS */;
INSERT INTO `chemical` VALUES (1,'Hidro','Di-Hidro','H2',2,'Khí không màu, sẽ phát sáng với ánh sáng tím khi chuyển sang thể plasma',NULL,NULL,NULL,NULL,'',NULL,'','2015-04-19 00:00:00',NULL,NULL),(2,'Axit Sunfuric','','H2SO4',98,'Dầu trong suốt, không màu,\nkhông mùi','1,84 g/cm3, lỏng','10 °C, 283 K','338 °C (dung dịch axit 98%)','','Không cháy','Không mùi','http://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Sulfuric-acid-2D-dimensions.svg/200px-Sulfuric-acid-2D-dimensions.svg.png','2015-04-19 00:00:00',NULL,NULL),(3,'Amoniac','Ammonia, Azane','NH3',17,'Chất khí không màu, mùi khai','0,6813 g/l, khí','-77,73 °C (195,42 K)','-33,34 °C (239,81 K)','89,9 g/100 ml ở 0 °C','11°C','Mùi khai','http://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Ammonia-3D-vdW.png/200px-Ammonia-3D-vdW.png','2015-04-19 00:00:00',NULL,NULL),(4,'Axít clohiđric','Axít muriatic, cloran','HCl',36,'Chất lỏng, trong suốt','1,18 g/cm3 (đa giá trị, đây là tỷ trọng của dung dịch 36-38%)','–27,32 °C (247 K)\r\nDung dịch 38%.','110 °C (383 K),\r\ndung dịch 20,2%;\r\n48 °C (321 K),\r\ndung dịch 38%.','Tan giới hạn','Không cháy','Không mùi','http://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Hydronium-3D-balls.png/125px-Hydronium-3D-balls.png','2015-04-19 00:00:00',NULL,NULL),(5,'Axit Hydrofluroic','fluoric acid; fluohydric acid','HF',20,'Dung dịch pha trộn không màu','1.15 g/mL (cho 48% trộn với H2O)',NULL,NULL,'[[>95%]]','Không cháy','Không mùi','','2015-04-19 00:00:00',NULL,NULL),(6,'Axit Cloro','','HClO2',68,'',NULL,NULL,NULL,NULL,'',NULL,'','2015-04-19 00:00:00',NULL,NULL),(7,'Axit Hipocloro','hyđrô hypôcloric, clorin hyđrôxit','HClO',52,'Chất lỏng không màu','Thay đổi',NULL,NULL,'Tan',NULL,NULL,'','2015-04-19 00:00:00',NULL,NULL),(8,'Liti','Liti','Li',7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(9,'Beri','Beri','Be',9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(10,'Natri','Natri','Na',23,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(11,'Magie','Magie','Mg',24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(12,'Kali','Kali','K',39,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(13,'Canxi','Canxi','Ca',40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(14,'Bari','Bari','Ba',137,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(15,'Crom','Crom','Cr',52,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(16,'Mangan','Mangan','Mn',55,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(17,'Sắt','Sắt','Fe',56,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(18,'Niken','Niken','Ni',57,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(19,'Đồng','Đồng','Cu',64,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(20,'Bạc','Bạc','Ag',108,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(21,'Vàng','Vàng','Au',197,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(22,'Kẽm','Kẽm','Zn',65,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(23,'Thủy Ngân','Thủy Ngân','Hg',200,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(24,'Bo','Bo','B',11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(25,'Cacbon','Cacbon','C',12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(26,'Nito','Nito','N2',28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(27,'Oxi','Oxy','O2',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(28,'Ozon','Ozon','O3',48,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(29,'Flo','Flo','F2',38,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(30,'Neon','Neon','Ne2',40,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(31,'Nhôm','Nhôm','Al',27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(32,'Silic','Silic','Si',28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(33,'Photpho','Photpho','P',31,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(34,'Lưu Huỳnh','Lưu Huỳnh','S',32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(35,'Clo','Clo','Cl2',70,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(36,'Brom','Brom','Br2',160,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(37,'Iot','Iot','I2',254,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(38,'Chì','Chì','Pb',207,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(39,'Natri clorua','Halua. muối thường, muối ăn','NaCl',58,'Chất rắn kết tinh màu trắng hoặc không màu','2,16 g/cm3, rắn','801°C (1074 K)','	1465°C (1738 K)','35,9 g/100 ml (25°C)','	Không cháy','Không mùi','http://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Selpologne.jpg/200px-Selpologne.jpg','2015-04-19 00:00:00',NULL,NULL),(40,'Natri iotua',NULL,'NaI',150,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(41,'Natri floua',NULL,'NaF',42,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(42,'Natri bromua',NULL,'NaBr',103,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(43,'',NULL,'Na2C2',70,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(44,NULL,NULL,'NaH',24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(48,NULL,'','Na2O2',78,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(49,NULL,NULL,'Na2S',78,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(50,NULL,NULL,'Na2(Sn)',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(51,NULL,NULL,'Na3P',100,'Xanh lá cây',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(53,NULL,NULL,'[Na(NH3)4]',91,'Xanh nước biển',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(66,NULL,NULL,'BeCl2',80,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),(67,'Bari sunfua','Bari sunfua','BaSO4',100,'','','','','','','','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `chemical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chemistry_equation`
--

DROP TABLE IF EXISTS `chemistry_equation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chemistry_equation` (
  `equation_id` int(11) NOT NULL,
  `number_of_atomic` varchar(10) DEFAULT '1',
  `chemical_id` int(11) NOT NULL,
  `chemical_typeof` int(11) NOT NULL,
  `condition` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`equation_id`,`chemical_id`),
  KEY `FK_CHemistryEquation_ChemicalTypOf` (`chemical_typeof`),
  KEY `FK_CHemistryEquation_State` (`condition`),
  KEY `FK_ChemistryEquation_Chemical` (`chemical_id`),
  CONSTRAINT `FK_ChemistryEquation_Chemical` FOREIGN KEY (`chemical_id`) REFERENCES `chemical` (`chemical_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ChemistryEquation_Equation` FOREIGN KEY (`equation_id`) REFERENCES `equation` (`equation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chemistry_equation`
--

LOCK TABLES `chemistry_equation` WRITE;
/*!40000 ALTER TABLE `chemistry_equation` DISABLE KEYS */;
INSERT INTO `chemistry_equation` VALUES (2,'1',1,1,''),(2,'1',3,1,' '),(2,'2',10,1,''),(2,'2',44,2,''),(3,'2',10,2,''),(3,'1',29,2,''),(3,'1',41,1,''),(4,'2',10,1,''),(4,'2',25,1,''),(4,'1',43,2,''),(5,'2',10,1,''),(5,'1',27,1,''),(5,'1',48,2,''),(6,'2',10,1,''),(6,'1',34,1,''),(6,'1',49,2,''),(7,'2',10,1,''),(7,'n',34,1,''),(7,'1',50,2,''),(8,'2',10,1,''),(8,'1',29,1,''),(8,'2',41,2,''),(9,'3',10,1,''),(9,'1',33,1,''),(9,'1',51,2,''),(10,'4',3,1,''),(10,'1',10,1,''),(10,'1',53,2,''),(12,'1',9,2,'(chat long)'),(12,'2',35,2,'↓(catot)'),(12,'2',66,1,'↑(anot)');
/*!40000 ALTER TABLE `chemistry_equation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element`
--

DROP TABLE IF EXISTS `element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `element` (
  `notation` varchar(10) NOT NULL COMMENT 'Kí hiệu',
  `name` varchar(50) DEFAULT NULL,
  `number_of_atomic` float DEFAULT NULL COMMENT 'Số nguyên tử',
  `atomic_volume` int(11) DEFAULT NULL COMMENT 'Khối lượng nguyên tử',
  `classify` varchar(50) DEFAULT NULL COMMENT 'Phân loại',
  `group` varchar(50) DEFAULT NULL COMMENT 'Nhóm, phân lớp',
  `cycle` varchar(50) DEFAULT NULL COMMENT 'Chu Kì',
  `electron_configuration` varchar(50) DEFAULT NULL COMMENT 'Cấu hình e',
  `layers` varchar(50) DEFAULT NULL COMMENT 'Các lớp',
  `description` varchar(500) DEFAULT NULL COMMENT 'Mô tả',
  `color` varchar(50) DEFAULT NULL COMMENT 'Mầu sắc',
  `condition` varchar(50) DEFAULT NULL COMMENT 'Trạng thái vật chất',
  `melting_temperature` varchar(50) DEFAULT NULL COMMENT 'Độ nóng chảy',
  `boiling_temperature` varchar(50) DEFAULT NULL COMMENT 'Độ sôi',
  `img` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  `last_user_modify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`notation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
INSERT INTO `element` VALUES ('Ac','Actini',89,227,'Nhóm Actini','IIIB, f','7','[Rn] 6d1 7s2','2, 8, 18, 32, 18, 9, 2','Bạc, phát sáng với ánh sáng xanh khá lạ','Bạc','Chất rắn','(circa) 1323 K ​(1050 °C, ​1922 °F)','3471 K ​(3198 °C, ​5788 °F)',NULL,'2015-04-19 00:00:00',NULL,NULL),('Ag','Bạc',47,108,'Kim loại chuyển tiếp','IB, d','5','[Kr] 4d10 5s1','2, 8, 18, 18, 1','Ánh kim trắng bóng','Ánh kim trắng bóng','Chất rắn','1234,93 K ​(961,78 °C, ​1763,2 °F)','2435 K ​(2162 °C, ​3924 °F)','https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Silver_crystal.jpg/220px-Silver_crystal.jpg','2015-04-19 00:00:00',NULL,NULL),('Au','Vàng',79,197,'Kim loại chuyển tiếp','IB, d','6','[Xe] 4f14 5d10 6s1','2, 8, 18, 32, 18, 1','Ánh kim vàng','Ánh kim vàng','Chất rắn','1337,33 K ​(1064,18 °C, ​1947,52 °F)','3129 K ​(2856 °C, ​5173 °F)','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Gold-crystals.jpg/220px-Gold-crystals.jpg','2015-04-19 00:00:00',NULL,NULL),('Ba','Bari',56,137,'Kim loại kiềm thổ','IIA, s','6','[Xe] 6s2','2, 8, 18, 18, 8, 2','Bạc xám','Bạc xám','Chất rắn','1000 K ​(727 °C, ​1341 °F)','2170 K ​(1897 °C, ​3447 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Barium_unter_Argon_Schutzgas_Atmosph%C3%A4re.jpg/220px-Barium_unter_Argon_Schutzgas_Atmosph%C3%A4re.jpg','2015-04-19 00:00:00',NULL,NULL),('Be','Beri',4,9,NULL,'IIA, s','2','1s2 2s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Bh','Bhori',107,264,NULL,NULL,NULL,'[Rn] 5f14 6d5 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Ca','Canxi',20,40,'Kim loại kiềm thổ','IIA, s','4','[Ar] 4s2','2, 8, 8, 2','Ánh kim xám bạc','Ánh kim xám bạc','Chất rắn','1115 K ​(842 °C, ​1548 °F)','1757 K ​(1484 °C, ​2703 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Calcium_unter_Argon_Schutzgasatmosph%C3%A4re.jpg/220px-Calcium_unter_Argon_Schutzgasatmosph%C3%A4re.jpg','2015-04-19 00:00:00',NULL,NULL),('Cd','Cadimi',48,112,'Kim loại chuyển tiếp','IIB, d','5','[Kr] 5s2 4d10','2, 8, 18, 18, 2 18, 2','Ánh kim bạc hơi xanh xám','Ánh kim bạc hơi xanh xám','Chất rắn','594,22 K ​(321,07 °C, ​609,93 °F)','1040 K ​(767 °C, ​1413 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Cadmium-crystal_bar-1.jpg/220px-Cadmium-crystal_bar-1.jpg','2015-04-19 00:00:00',NULL,NULL),('Co','Cobal',27,59,NULL,'VIIIB, d','4','[Ar] 3d7 4s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Cr','Crom',24,52,'Kim loại chuyển tiếp','VB, d','4','[Ar] 3d5 4s1','2, 8, 13, 1','Ánh bạc','Ánh bạc','Chất rắn','2180 K ​(1907 °C, ​3465 °F)','2944 K ​(2671 °C, ​4840 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Chromium_crystals_and_1cm3_cube.jpg/220px-Chromium_crystals_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Cs','Xesi',55,133,'Kim loại kiềm','IA, s','6','[Xe] 6s1','2, 8, 18, 18, 8, 1','Bạc ngà','Bạc ngà','Chất rắn','301,59 K ​(28,44 °C, ​83,19 °F)','944 K ​(671 °C, ​1240 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Cesium.jpg/220px-Cesium.jpg','2015-04-19 00:00:00',NULL,NULL),('Cu','Đồng',29,64,'Kim loại chuyển tiếp','IB, d','4','[Ar] 3d10 4s1','2, 8, 18, 1','Ánh kim đỏ cam','Ánh kim đỏ cam','Chất rắn','1357,77 K ​(1084,62 °C, ​1984,32 °F)','2835 K ​(2562 °C, ​4643 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg','2015-04-19 00:00:00',NULL,NULL),('Db','Dubni',105,262,NULL,'VB, d','7','[Rn] 5f14 6d3 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Fe','Sắt',26,55,'Kim loại chuyển tiếp','VIIIB, d','4','[Ar] 3d6 4s2','2, 8, 14, 2','Ánh kim xám nhẹ','Ánh kim xám nhẹ','Chất rắn','3459 K ​(3186 °C, ​5767 °F)','5869 K ​(5596 °C, ​10105 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Iron_electrolytic_and_1cm3_cube.jpg/220px-Iron_electrolytic_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Fr','Franxi',87,223,'Kim loại kiềm','IA, s','7','[Rn] 7s1','2, 8, 18, 32, 18, 8, 1','Ánh kim','Ánh kim','Chất rắn','? 300 K ​(? 27 °C, ​? 80 °F)','? 950 K ​(? 677 °C, ​? 1250 °F)',NULL,'2015-04-19 00:00:00',NULL,NULL),('H','Hidro',1,1,'Phi kim','IA, s','1','1s1','1','Khí không màu, sẽ phát sáng với ánh sáng tím khi chuyển sang thể plasma','Không màu','Chất khí','14,01 K ​(-259,14 °C, ​-434,45 °F)','0,28 K ​(-252,87 °C, ​-423,17 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Hydrogenglow.jpg/220px-Hydrogenglow.jpg','2015-04-19 00:00:00',NULL,NULL),('He','Heli',2,4,'Khí hiếm','VIIIA, s','1','1s2','2','Khí không màu, phát sáng với ánh sáng tím khi ở thể plasma','Không màu','Chất khí','(với 2,5 MPa) 0,95 K ​(−272,20 °C, ​−457,96 °F)','4,22 K ​(−268,93 °C, ​−452,07 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Helium-glow.jpg/220px-Helium-glow.jpg','2015-04-19 00:00:00',NULL,NULL),('Hf','Hafini',72,178,NULL,'IVB, d','6','[Xe] 4f14 5d 6s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Hg','Thủy Ngân',80,201,'Kim loại chuyển tiếp','IIB, d','6','[Xe] 4f14 5d10 6s2','2, 8, 18, 32, 18, 2','Ánh bạc','Ánh bạc','Chất lỏng','234,32 K ​(-38,83 °C, ​-37,89 °F)','629,88 K ​(356,73 °C, ​674,11 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Pouring_liquid_mercury_bionerd.jpg/250px-Pouring_liquid_mercury_bionerd.jpg','2015-04-19 00:00:00',NULL,NULL),('Hs','Hassi',108,264,NULL,'VIIIB, d','7','[Rn] 5f14 6d6 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Ir','Iridi',77,192,'Kim loại chuyển tiếp','VIIIB, d','6','[Xe] 4f14 5d7 6s2','2, 8, 18, 32, 15, 2','Bạc trắng','Bạc trắng','Chất rắn','2739 K ​(2466 °C, ​4471 °F)','4701 K ​(4428 °C, ​8002 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Iridium-2.jpg/220px-Iridium-2.jpg','2015-04-19 00:00:00',NULL,NULL),('Ka','Kali',19,39,'Kim loại kiềm','IA, s','4','[Ar] 4s1','2, 8, 8, 1','Ánh kim trắng bạc','Ánh kim trắng bạc','Chất rắn','336,53 K ​(63,38 °C, ​146,08 °F)','1032 K ​(759 °C, ​1398 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Potassium-2.jpg/220px-Potassium-2.jpg','2015-04-19 00:00:00',NULL,NULL),('La','Lantan',57,139,'Nhóm Lantan','IIIB, f','6','[Xe] 5d1 6s2','2, 8, 18, 18, 9, 2','Bạc trắng','Bạc trắng','Chất rắn','1193 K ​(920 °C, ​1688 °F)','3737 K ​(3464 °C, ​6267 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Lanthanum-2.jpg/220px-Lanthanum-2.jpg','2015-04-19 00:00:00',NULL,NULL),('Li','Liti',3,7,'Kim loại kiềm','IA, s','2','1s2 2s1 hay [He]2s1','2, 1','Trắng bạc','Trắng bạc','Chất rắn','453,69 K ​(180,54 °C, ​356,97 °F)','1615 K ​(1342 °C, ​2448 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Lithium_paraffin.jpg/220px-Lithium_paraffin.jpg','2015-04-19 00:00:00',NULL,NULL),('Mg','Magie',12,24,'Kim loại kiềm thổ','IIA, s','3','[Ne] 3s2','2, 8, 2','Ánh kim xám','Ánh kim xám','Chất rắn','923 K ​(650 °C, ​1202 °F)','1363 K ​(1091 °C, ​1994 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Magnesium_crystals.jpg/220px-Magnesium_crystals.jpg','2015-04-19 00:00:00',NULL,NULL),('Mn','Mangan',25,55,'Kim loại chuyển tiếp','VIIB, d','4','[Ar] 4s2 3d5','2, 8, 13, 2','Mangan điện phân màu bạc nguyên chất bao bọc bởi các ôxít màu','Ánh kim bạc','Chất rắn','1519 K ​(1246 °C, ​2275 °F)','2334 K ​(2061 °C, ​3742 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Manganese_electrolytic_and_1cm3_cube.jpg/220px-Manganese_electrolytic_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Mo','Molypden',42,96,'Kim loại chuyển tiếp','VIB, d','5','[Kr] 5s1 4d5','2, 8, 18, 13, 1','Ánh kim xám','Ánh kim xám','Chất rắn','2896 K ​(2623 °C, ​4753 °F)','4912 K ​(4639 °C, ​8382 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Molybdenum_crystaline_fragment_and_1cm3_cube.jpg/220px-Molybdenum_crystaline_fragment_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Mt','Meitneri',109,268,NULL,'VIIIB, d','7','[Rn] 5f14 6d7 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Na','Natri',11,23,'Kim loại kiềm','IA, s','3','[Ne] 3s1','2, 8, 1','Ánh kim trắng bạc','Ánh kim trắng bạc','Chất rắn','370,87 K ​(97,72 °C, ​207,9 °F)','1156 K ​(883 °C, ​1621 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Na_%28Sodium%29.jpg/220px-Na_%28Sodium%29.jpg','2015-04-19 00:00:00',NULL,NULL),('Nb','Niobi',41,93,'Kim loại chuyển tiếp','VB, d','5','[Kr] 4d4 5s1','2, 8, 18, 12, 1','Ánh kim xám','Ánh kim xám, chuyển thành màu xanh dương nhạt khi ','Chất rắn','2750 K ​(2477 °C, ​4491 °F)','5017 K ​(4744 °C, ​8571 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Niobium_crystals_and_1cm3_cube.jpg/220px-Niobium_crystals_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Ni','Niken',28,59,'Kim loại chuyển tiếp','VIIIB, d','4','[Ar] 4s2 3d8 hay [Ar] 4s1 3d9 ','2, 8, 16, 2 or 2, 8, 17, 1','Ánh kim bạc ánh vàng','Ánh kim bạc ánh vàng','Chất rắn','1728 K ​(1455 °C, ​2651 °F)','3186 K ​(2913 °C, ​5275 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Nickel_electrolytic_and_1cm3_cube.jpg/220px-Nickel_electrolytic_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Os','Osmi',76,190,'Kim loại chuyển tiếp','VIIIB, d','6','[Xe] 4f14 5d6 6s2','2, 8, 18, 32, 14, 2','Bạc ánh xanh','Bạc ánh xanh','Chất rắn','3306 K ​(3033 °C, ​5491 °F)','5285 K ​(5012 °C, ​9054 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Osmium_crystals.jpg/220px-Osmium_crystals.jpg','2015-04-19 00:00:00',NULL,NULL),('Pd','Paladi',46,106,'Kim loại chuyển tiếp','VIIIB, d','5','[Kr] 4d10','2, 8, 18, 18','Ánh kim bạc trắng','Ánh kim bạc trắng','Chất rắn','1828.05 K ​(1554.9 °C, ​2830.82 °F)','3236 K ​(2963 °C, ​5365 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Palladium.jpg/220px-Palladium.jpg','2015-04-19 00:00:00',NULL,NULL),('Pt','Platin',78,195,'Kim loại chuyển tiếp','VIIIB, d','6','[Xe] 4f14 5d9 6s1','2, 8, 18, 32, 17, 1','Xám trắng','Xám trắng','Chất rắn','2041,4 K ​(1768,3 °C, ​3214,9 °F)','4098 K ​(3825 °C, ​6917 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Platinum_crystals.jpg/220px-Platinum_crystals.jpg','2015-04-19 00:00:00',NULL,NULL),('Ra','Radi',88,226,'Kim loại kiềm thổ','IIA, s','7','[Rn] 7s2','2, 8, 18, 32, 18, 8, 2','Ánh kim bạc trắng','Ánh kim bạc trắng','Chất rắn','973 K ​(700 °C, ​1292 °F)','2010 K ​(1737 °C, ​3159 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Radium226.jpg/220px-Radium226.jpg','2015-04-19 00:00:00',NULL,NULL),('Rb','Rubidi',37,85,'Kim loại kiềm','IA, s','5','[Kr] 5s1','2, 8, 18, 8, 1','Xám trắng','Xám trắng','Chất rắn','312,46 K ​(39,31 °C, ​102,76 °F)','961 K ​(688 °C, ​1270 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Rb5.JPG/220px-Rb5.JPG','2015-04-19 00:00:00',NULL,NULL),('Re','Rheni',75,186,'Kim loại chuyển tiếp','VIIB, d','6','[Xe] 4f14 5d5 6s2','2, 8, 18, 32, 13, 2','Xám trắng','Xám trắng','Chất rắn','3459 K ​(3186 °C, ​5767 °F)','5869 K ​(5596 °C, ​10105 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Rhenium_single_crystal_bar_and_1cm3_cube.jpg/220px-Rhenium_single_crystal_bar_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Rf','Rutofodi',104,261,NULL,'IVB, d','7','[Rn] 5f14 6d2 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Rh','Rhodi',45,103,'Kim loại chuyển tiếp','VIIIB, d','5','[Kr] 5s1 4d8','	2, 8, 18, 16, 1','Ánh kim bạc trắng','Ánh kim bạc trắng','Chất rắn','2237 K ​(1964 °C, ​3567 °F)','3968 K ​(3695 °C, ​6683 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Rhodium_powder_pressed_melted.jpg/220px-Rhodium_powder_pressed_melted.jpg','2015-04-19 00:00:00',NULL,NULL),('Ru','Rhuteni',44,101,'Kim loại chuyển tiếp','VIIIB, d','5','[Kr] 4d7 5s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Sc','Scandi',21,45,'Kim loại chuyển tiếp','IIIB, d','4','[Ar] 3d1 4s2','2, 8, 9, 2','Ánh kim trắng bạc','Ánh kim trắng bạc','Chất rắn','1814 K ​(1541 °C, ​2806 °F)','3109 K ​(2836 °C, ​5136 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Scandium_sublimed_dendritic_and_1cm3_cube.jpg/220px-Scandium_sublimed_dendritic_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Sg','Seabogi',106,262,NULL,'IVB','7','[Rn] 5f14 6d4 7s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Sr','Stronti',38,88,'Kim loại kiềm thổ','IIA, s','5','[Kr] 5s2','2, 8, 18, 8, 2','Ánh kim bạc trắng','Ánh kim bạc trắng','Chất rắn','1050 K ​(777 °C, ​1431 °F)','1655 K ​(1382 °C, ​2520 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Strontium_destilled_crystals.jpg/220px-Strontium_destilled_crystals.jpg','2015-04-19 00:00:00',NULL,NULL),('Ta','Tantal',73,181,NULL,'VB, d','6','[Xe] 4f14 5d3 6s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Tc','Tecnexi',43,98,NULL,'VIIB, d','5','[Kr] 4d5 5s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Ti','Titan',22,48,'Kim loại chuyển tiếp','IVB, d','4','[Ar] 4s2 3d2','2, 8, 10, 2','Ánh kim bạc xám-trắng','Ánh kim bạc xám-trắng','Chất rắn','1941 K ​(1668 °C, ​3034 °F)','3560 K ​(3287 °C, ​5949 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Titan-crystal_bar.JPG/240px-Titan-crystal_bar.JPG','2015-04-19 00:00:00',NULL,NULL),('Uub','Ununbi',112,277,NULL,'IIB, d','7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Uun','Ununnili',110,271,NULL,'VIIIB, d','7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Uuu','Unununi',112,277,NULL,'IB, d','7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('V','Vanadi',23,51,'Kim loại chuyển tiếp','VB, d','4','[Ar] 3d3 4s2','2, 8, 11, 2','Ánh kim xanh bạc xám','Ánh kim xanh bạc xám','Chất rắn','2183 K ​(1910 °C, ​3470 °F)','3680 K ​(3407 °C, ​6165 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Vanadium_etched.jpg/220px-Vanadium_etched.jpg','2015-04-19 00:00:00',NULL,NULL),('W','Wolfram',74,184,'Kim loại chuyển tiếp','VIB, d','6','[Xe] 4f14 5d4 6s2','2, 8, 18, 32, 12, 2','Xám trắng bóng, ánh nhiều màu khi bị ôxy hóa','Xám trắng bóng','Chất rắn','3695 K ​(3422 °C, ​6192 °F)','5828 K ​(5555 °C, ​10031 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Wolfram_evaporated_crystals_and_1cm3_cube.jpg/220px-Wolfram_evaporated_crystals_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Y','Ytri',39,89,NULL,'IIIB, d','5','[Kr] 4d1 5s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL),('Zn','Kẽm',30,65,'Kim loại chuyển tiếp','IIB, d','4','[Ar] 3d10 4s2','2, 8, 18, 2','Ánh kim bạc xám','Ánh kim bạc xám','Chất rắn','692,68 K ​(419,53 °C, ​787,15 °F)','1180 K ​(907 °C, ​1665 °F)','http://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Zinc_fragment_sublimed_and_1cm3_cube.jpg/220px-Zinc_fragment_sublimed_and_1cm3_cube.jpg','2015-04-19 00:00:00',NULL,NULL),('Zr','Ziriconi',40,91,NULL,'IVB, d','5','[Kr] 4d2 5s2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2015-04-19 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equation`
--

DROP TABLE IF EXISTS `equation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equation` (
  `equation_id` int(11) NOT NULL AUTO_INCREMENT,
  `equation` varchar(200) NOT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `condition` varchar(100) DEFAULT NULL,
  `video_link` varchar(300) DEFAULT NULL,
  `ion_id` int(11) DEFAULT NULL,
  `oxi_id` int(11) DEFAULT NULL,
  `active` int(11) NOT NULL DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  `last_user_modify` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`equation_id`),
  UNIQUE KEY `equation_UNIQUE` (`equation`),
  KEY `FK_ion_equation` (`ion_id`),
  KEY `FK_oxi_reduce_equation` (`oxi_id`),
  CONSTRAINT `FK_ion_equation` FOREIGN KEY (`ion_id`) REFERENCES `ion_equation` (`ion_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_oxi_reduce_equation` FOREIGN KEY (`oxi_id`) REFERENCES `oxi_reduce` (`oxi_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equation`
--

LOCK TABLES `equation` WRITE;
/*!40000 ALTER TABLE `equation` DISABLE KEYS */;
INSERT INTO `equation` VALUES (2,'2Na + H2 = 2NaH','Phản ứng abc','250—400°C, áp suất','',7,1,0,'2015-04-20 19:17:42','2015-04-24 00:19:36','admin'),(3,'2NaF = 2Na + F2','Phản ứng điều chế Natri','Điện phân dung dịch','',NULL,2,0,'2015-04-20 19:17:42','2015-04-23 23:56:56','admin'),(4,'2Na + 2C = Na2C2','','150—200°C',NULL,NULL,3,0,'2015-04-20 19:17:42',NULL,'admin'),(5,'2Na + O2 = Na2O2','','cháy trong không khí, hỗn hợp Na2O','https://www.youtube.com/embed/lVtAFrURA1Q',NULL,4,0,'2015-04-20 19:17:42',NULL,'admin'),(6,'2Na + S = Na2S','','trên 130°C',NULL,NULL,5,0,'2015-04-20 19:17:42',NULL,'admin'),(7,'2Na + nS = Na2(S)n','','[—40 º C, trong NH3, n = 1, 2, 4 , 5] lỏng',NULL,NULL,6,0,'2015-04-20 19:17:42',NULL,'admin'),(8,'2Na + F2 = 2NaF','','nhiệt độ phòng',NULL,NULL,7,0,'2015-04-20 19:17:42',NULL,'admin'),(9,'3Na + P = Na3P','','200°C, trong môi trường Ar',NULL,NULL,8,0,'2015-04-20 19:17:42',NULL,'admin'),(10,'Na +4 NH3 =[ Na(NH3)4]','',' - 40°C',NULL,NULL,NULL,0,'2015-04-20 19:17:42',NULL,'admin'),(12,'BeCl2(chất lỏng) = Be↓(catôt) + Cl2↑(anốt)','Điều chế Cl2','Điều kiện','',NULL,10,0,'2015-04-20 19:17:42',NULL,'admin');
/*!40000 ALTER TABLE `equation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `received_date` datetime DEFAULT NULL,
  `equation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'pe.chom9x@yahoo.com.vn','',NULL,NULL);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ion_equation`
--

DROP TABLE IF EXISTS `ion_equation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ion_equation` (
  `ion_id` int(11) NOT NULL AUTO_INCREMENT,
  `ion_equation` varchar(100) NOT NULL,
  `shortcut_ion_equation` varchar(100) NOT NULL,
  PRIMARY KEY (`ion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ion_equation`
--

LOCK TABLES `ion_equation` WRITE;
/*!40000 ALTER TABLE `ion_equation` DISABLE KEYS */;
INSERT INTO `ion_equation` VALUES (7,'2H+ + SO4 2− + Ba2+ + 2Cl− = 2H+ + 2Cl− + BaSO4','SO42− + Ba2+ = BaSO4');
/*!40000 ALTER TABLE `ion_equation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oxi_reduce`
--

DROP TABLE IF EXISTS `oxi_reduce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oxi_reduce` (
  `oxi_id` int(11) NOT NULL AUTO_INCREMENT,
  `mol_reduce` int(11) NOT NULL,
  `reduce_equation` varchar(100) NOT NULL,
  `mol_oxi` int(11) NOT NULL,
  `oxi_equation` varchar(100) NOT NULL,
  `summary` varchar(100) NOT NULL,
  PRIMARY KEY (`oxi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oxi_reduce`
--

LOCK TABLES `oxi_reduce` WRITE;
/*!40000 ALTER TABLE `oxi_reduce` DISABLE KEYS */;
INSERT INTO `oxi_reduce` VALUES (1,1,'Na+ + 1e− = Na',1,'H− − 1e− = H','Na+ + H− = Na + H'),(2,1,'Na+ + 1e− = Na',1,'F− − 1e− = F','Na+ + F− = Na + F'),(3,1,'C + 1e− = C−',1,'Na − 1e− = Na+','C + Na = C− + Na+'),(4,1,'O + 1e− = O−',1,'Na − 1e− = Na+','O + Na = O− + Na+'),(5,1,'S + 2e− = S2−',2,'Na − 1e− = Na+','S + 2Na = S2− + 2Na+'),(6,1,'nS + 2e− = Sn2−',2,'Na − 1e− = Na+','nS + 2Na = Sn2− + 2Na+'),(7,1,'F + 1e− = F−',1,'Na − 1e− = Na+','F + Na = F− + Na+'),(8,1,'P + 3e− = P3−',3,'Na − 1e− = Na+','P + 3Na = P3− + 3Na+'),(10,1,'Be2+ + 2e− = Be',2,'Cl− − 1e− = Cl','Be2+ + 2Cl− = Be + 2Cl');
/*!40000 ALTER TABLE `oxi_reduce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'chemisbox'
--
/*!50003 DROP PROCEDURE IF EXISTS `getEquation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEquation`(IN formula varchar(50))
BEGIN
	SELECT tt.equation_id, CONCAT('{\"chemicals\":[', GROUP_CONCAT( tt.formula SEPARATOR ' ,'), ']}') AS equation
    , tt.`condition`, tt.`desc`, tt.video_link, tt.ion_id, tt.oxi_id, tt.active, tt.created_date, tt.edited_date, tt.last_user_modify
	FROM(
	    SELECT e.equation_id, 
        CONCAT(
        '{\"chemicalId\": \"', c.chemical_id
		,'\", \"numberOfAtomic\": \"', cr.number_of_atomic
        , '\", \"formula\": \"', c.formula
        , '\", \"condition\": \"', cr.`condition`
        , '\", \"typeOf\":', GROUP_CONCAT(cr.chemical_typeof), '}'
        ) AS formula,
	     e.`condition`, e.`desc`, e.video_link, e.ion_id, e.oxi_id, e.active, e.created_date, e.edited_date, e.last_user_modify
	    FROM equation e INNER JOIN chemistry_equation cr ON e.equation_id = cr.equation_id 
	    INNER JOIN chemical c ON cr.chemical_id = c.chemical_id
	    INNER JOIN `oxi_reduce` oxi ON e.`oxi_id` = oxi.`oxi_id`
	    GROUP BY e.equation_id, c.name
	    ) tt
	    WHERE tt.equation_id IN 
	    (
		SELECT ce.`equation_id` FROM chemistry_equation ce 
		INNER JOIN chemical ON ce.`chemical_id` = `chemical`.`chemical_id`
		WHERE `chemical`.`formula` LIKE formula
	    )
	GROUP BY tt.equation_id;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEquationBy2Chemical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEquationBy2Chemical`(in chemical1 varchar(50), IN chemical2 VARCHAR(50), IN typeOf int)
BEGIN
	SELECT tt.equation_id, CONCAT('{\"chemicals\":[', GROUP_CONCAT( tt.formula SEPARATOR ' ,'), ']}') AS equation, tt.`condition`
	, tt.`desc`, tt.video_link, tt.ion_id, tt.oxi_id, tt.active, tt.created_date, tt.edited_date, tt.last_user_modify
	FROM(
	    SELECT e.equation_id, 
        CONCAT('{\"numberOfAtomic\": \"', cr.number_of_atomic 
        , '\", \"formula\": \"', c.formula
        , '\", \"condition\": \"', cr.`condition`
        , '\", \"typeOf\":', GROUP_CONCAT(cr.chemical_typeof), '}') AS formula,
	     e.`condition`, e.`desc`, e.video_link, e.ion_id, e.oxi_id, e.active, e.created_date, e.edited_date, e.last_user_modify
	    FROM equation e INNER JOIN chemistry_equation cr ON e.equation_id = cr.equation_id 
	    INNER JOIN chemical c ON cr.chemical_id = c.chemical_id
	    INNER JOIN oxi_reduce oxi ON e.`oxi_id` = oxi.`oxi_id`
	    GROUP BY e.equation_id, c.name
	    ) tt
	    WHERE tt.equation_id IN 
	    (
		SELECT ce.equation_id FROM chemistry_equation ce
		INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
		WHERE (c.`formula` LIKE chemical1 AND ce.`chemical_typeof` = typeOf)
		AND equation_id IN (SELECT equation_id FROM chemistry_equation ce
		INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
		WHERE (c.`formula` LIKE chemical2 AND ce.`chemical_typeof` = typeOf))
	    )
	GROUP BY tt.equation_id;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEquationBy3Chemical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEquationBy3Chemical`(in chemical1 varchar(50), IN chemical2 VARCHAR(50), IN chemical3 VARCHAR(50), IN typeOf int)
BEGIN
	SELECT tt.equation_id, CONCAT('{\"chemicals\":[', GROUP_CONCAT( tt.formula SEPARATOR ' ,'), ']}') AS equation, tt.`condition`
	, tt.`desc`, tt.video_link, tt.ion_id, tt.oxi_id, tt.active, tt.created_date, tt.edited_date, tt.last_user_modify
	FROM(
	    SELECT e.equation_id, 
        CONCAT('{\"numberOfAtomic\": \"', cr.number_of_atomic 
        , '\", \"formula\": \"', c.formula
        , '\", \"condition\": \"', cr.`condition`
        , '\", \"typeOf\":', GROUP_CONCAT(cr.chemical_typeof), '}') AS formula,
	     e.`condition`, e.`desc`, e.video_link, e.ion_id, e.oxi_id, e.active, e.created_date, e.edited_date, e.last_user_modify
	    FROM equation e INNER JOIN chemistry_equation cr ON e.equation_id = cr.equation_id 
	    INNER JOIN chemical c ON cr.chemical_id = c.chemical_id
	    INNER JOIN oxi_reduce oxi ON e.`oxi_id` = oxi.`oxi_id`
	    GROUP BY e.equation_id, c.name ) tt
	    WHERE tt.equation_id IN (
			SELECT ce.equation_id FROM chemistry_equation ce
			INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
			WHERE (c.`formula` LIKE chemical1 AND ce.`chemical_typeof` = typeOf)
			AND equation_id IN (SELECT equation_id FROM chemistry_equation ce
			INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
			WHERE (c.`formula` LIKE chemical2 AND ce.`chemical_typeof` = typeOf))
            AND equation_id IN (SELECT equation_id FROM chemistry_equation ce
			INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
			WHERE (c.`formula` LIKE chemical3 AND ce.`chemical_typeof` = typeOf))
	)
	GROUP BY tt.equation_id;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEquationByChemical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEquationByChemical`(IN formula varchar(50), IN typeof int)
BEGIN
	SELECT tt.equation_id, CONCAT('{\"chemicals\":[', GROUP_CONCAT( tt.formula SEPARATOR ' ,'), ']}') AS equation
    , tt.`condition`, tt.`desc`, tt.video_link, tt.ion_id, tt.oxi_id, tt.active, tt.created_date, tt.edited_date, tt.last_user_modify
	FROM(
	    SELECT e.equation_id, 
        CONCAT(
        '{\"chemicalId\": \"', c.chemical_id
		,'\", \"numberOfAtomic\": \"', cr.number_of_atomic
        , '\", \"formula\": \"', c.formula
        , '\", \"condition\": \"', cr.`condition`
        , '\", \"typeOf\":', GROUP_CONCAT(cr.chemical_typeof), '}'
        ) AS formula,
	     e.`condition`, e.`desc`, e.video_link, e.ion_id, e.oxi_id, e.active, e.created_date, e.edited_date, e.last_user_modify
	    FROM equation e INNER JOIN chemistry_equation cr ON e.equation_id = cr.equation_id 
	    INNER JOIN chemical c ON cr.chemical_id = c.chemical_id
	    INNER JOIN `oxi_reduce` oxi ON e.`oxi_id` = oxi.`oxi_id`
	    GROUP BY e.equation_id, c.name
	    ) tt
	    WHERE tt.equation_id IN 
	    (
		SELECT ce.`equation_id` FROM chemistry_equation ce 
		INNER JOIN chemical ON ce.`chemical_id` = `chemical`.`chemical_id`
		WHERE `chemical`.`formula` LIKE formula AND ce.`chemical_typeof` = typeof
	    )
	GROUP BY tt.equation_id;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEquationByLeftAndRightChemical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEquationByLeftAndRightChemical`(in leftChemical varchar(50), IN rightChemical VARCHAR(50))
BEGIN
	SELECT tt.equation_id, CONCAT('{\"chemicals\":[', GROUP_CONCAT( tt.formula SEPARATOR ' ,'), ']}') AS equation, tt.`condition`
	, tt.`desc`, tt.video_link, tt.ion_id, tt.oxi_id, tt.active, tt.created_date, tt.edited_date, tt.last_user_modify
	FROM(
	    SELECT e.equation_id, CONCAT('{\"numberOfAtomic\": \"', cr.number_of_atomic 
        , '\", \"formula\": \"', c.formula
        , '\", \"condition\": \"', cr.`condition`
        , '\", \"typeOf\":', GROUP_CONCAT(cr.chemical_typeof), '}') AS formula,
	     e.`condition`, e.`desc`, e.video_link, e.ion_id, e.oxi_id, e.active, e.created_date, e.edited_date, e.last_user_modify
	    FROM equation e INNER JOIN chemistry_equation cr ON e.equation_id = cr.equation_id 
	    INNER JOIN chemical c ON cr.chemical_id = c.chemical_id
	    INNER JOIN oxi_reduce oxi ON e.`oxi_id` = oxi.`oxi_id`
	    GROUP BY e.equation_id, c.name
	    ) tt
	    WHERE tt.equation_id IN 
	    (
		SELECT ce.equation_id FROM chemistry_equation ce
		INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
		WHERE (c.`formula` LIKE leftChemical AND ce.`chemical_typeof` = 1)
		AND equation_id IN (SELECT equation_id FROM chemistry_equation ce
		INNER JOIN chemical c ON ce.`chemical_id` = c.`chemical_id`
		WHERE (c.`formula` LIKE rightChemical AND ce.`chemical_typeof` = 2))
	    )
	GROUP BY tt.equation_id;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-28 22:04:54
