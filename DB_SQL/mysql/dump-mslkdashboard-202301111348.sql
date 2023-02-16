-- MySQL dump 10.13  Distrib 8.0.31, for macos13.0 (x86_64)
--
-- Host: www.uiscloud.com    Database: mslkdashboard
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mslkboard`
--

DROP TABLE IF EXISTS `mslkboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkboard` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  `content` text NOT NULL,
  `title` varchar(100) NOT NULL,
  `writer` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkboard`
--

LOCK TABLES `mslkboard` WRITE;
/*!40000 ALTER TABLE `mslkboard` DISABLE KEYS */;
INSERT INTO `mslkboard` VALUES (22,'2022-07-13 23:39:09',NULL,'                  공지 내용을 작성 해 주세요.ㅛ','ㅛ','admin'),(26,'2022-07-13 23:39:31',NULL,'                  공지 내용을 작성 해 주세요.ㅛ','TEST','admin'),(31,'2022-11-30 17:20:34',NULL,'<p>                  공지 내용을 작성 해 주세요.<br>T<br>E<br>ET<br><br>TE<br>T<br><br>E<br>T<br>E<br>T<br>E<br>T<br><br>E<br>T<br>E<br><br>T<br>ETTETETEET</p><p>\r\n                </p>','TESTTETETE','admin');
/*!40000 ALTER TABLE `mslkboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslkmember`
--

DROP TABLE IF EXISTS `mslkmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkmember` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '이름',
  `password` varchar(100) NOT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkmember`
--

LOCK TABLES `mslkmember` WRITE;
/*!40000 ALTER TABLE `mslkmember` DISABLE KEYS */;
INSERT INTO `mslkmember` VALUES (1,'admin','관리자','$2a$10$wku9tPEO8oTwpSlInntqJ.t8ded9VA2DKYBPI0J.DXQOHDtrG8ifa','2022-12-19 17:25:30',NULL,'ADMIN'),(2,'user','사용자','$2a$10$wku9tPEO8oTwpSlInntqJ.t8ded9VA2DKYBPI0J.DXQOHDtrG8ifa','2022-12-20 08:48:36',NULL,'USER');
/*!40000 ALTER TABLE `mslkmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslkta0001`
--

DROP TABLE IF EXISTS `mslkta0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkta0001` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서명',
  `EM_NM` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '이메일',
  `NR_IP_AR` varchar(50) DEFAULT NULL COMMENT '관리공간_IP',
  `EAR_EHF` char(1) DEFAULT NULL COMMENT '공용계정 USE_YN',
  `AD_TF` char(1) DEFAULT NULL COMMENT '관리자여부',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkta0001`
--

LOCK TABLES `mslkta0001` WRITE;
/*!40000 ALTER TABLE `mslkta0001` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslkta0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslkta0002`
--

DROP TABLE IF EXISTS `mslkta0002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkta0002` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자 ID',
  `US_TF` char(1) DEFAULT NULL COMMENT '사용구분',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '소유자 사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `RULE_ID` int DEFAULT NULL COMMENT 'DATA_권한',
  `SE_TF` char(1) DEFAULT NULL COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='공용계정 관리 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkta0002`
--

LOCK TABLES `mslkta0002` WRITE;
/*!40000 ALTER TABLE `mslkta0002` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslkta0002` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktc0001`
--

DROP TABLE IF EXISTS `mslktc0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktc0001` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `GSN_ID` int NOT NULL COMMENT '앱코드',
  `APP_NM` varchar(50) DEFAULT NULL COMMENT '앱명',
  `CL_NM` varchar(100) DEFAULT NULL COMMENT '클러스터명',
  `PGE_URL_AR` varchar(200) DEFAULT NULL COMMENT '링크 URL',
  `ROLE_ID` int DEFAULT NULL COMMENT '역할ID',
  `USR_DCD` varchar(50) DEFAULT NULL COMMENT '부서명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT 'P아이디',
  `EM_NM` char(50) DEFAULT NULL COMMENT '이메일',
  `USE_YN` char(1) DEFAULT NULL COMMENT '사용유부',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `START_DATE` char(10) DEFAULT NULL COMMENT '시작 일자 ',
  `END_DATE` char(10) DEFAULT NULL COMMENT '종료 일자',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '생성 일자',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '변경 일자',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자권한관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktc0001`
--

LOCK TABLES `mslktc0001` WRITE;
/*!40000 ALTER TABLE `mslktc0001` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslktc0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktd0001`
--

DROP TABLE IF EXISTS `mslktd0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktd0001` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '시간',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `EM_NM` char(20) DEFAULT NULL COMMENT '이메일',
  `UG_NM` char(20) DEFAULT NULL COMMENT '활동',
  `REF_URL_AR` varchar(200) DEFAULT NULL COMMENT 'ReferURL',
  `USR_IP` char(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='인증감사';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktd0001`
--

LOCK TABLES `mslktd0001` WRITE;
/*!40000 ALTER TABLE `mslktd0001` DISABLE KEYS */;
INSERT INTO `mslktd0001` VALUES (1,'2022-07-06 23:39:11','03','관리자','admin','lhlee@goodmit.co.kr','관리자 페이지 접속','https://hue.uiscloud.com','10.200.101.100');
/*!40000 ALTER TABLE `mslktd0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktd0002`
--

DROP TABLE IF EXISTS `mslktd0002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktd0002` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '시간',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `UG_ID` varchar(50) DEFAULT NULL COMMENT '사용자그룹ID',
  `USR_IP` char(20) DEFAULT NULL COMMENT '접근 IP',
  `EM_NM` char(20) DEFAULT NULL COMMENT '이메일',
  `UG_NM` char(20) DEFAULT NULL COMMENT '상태',
  `LF_DT` char(20) DEFAULT NULL COMMENT '마지막로그인실패시간',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='계정감사';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktd0002`
--

LOCK TABLES `mslktd0002` WRITE;
/*!40000 ALTER TABLE `mslktd0002` DISABLE KEYS */;
INSERT INTO `mslktd0002` VALUES (1,'2022-07-08 12:04:46','03','관리자','admin','관리자 그룹','10.200.101.100','lhlee@goodmit.co.kr','페이지 접속','2022-07-08 11:00:57');
/*!40000 ALTER TABLE `mslktd0002` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktd0003`
--

DROP TABLE IF EXISTS `mslktd0003`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktd0003` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '시간',
  `WR_TY` char(20) DEFAULT NULL COMMENT '타입',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `UG_ID` int DEFAULT NULL COMMENT '사용권한 부여 이력',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='권한감사';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktd0003`
--

LOCK TABLES `mslktd0003` WRITE;
/*!40000 ALTER TABLE `mslktd0003` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslktd0003` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslkte0001`
--

DROP TABLE IF EXISTS `mslkte0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkte0001` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DCD` varchar(30) DEFAULT NULL COMMENT '부서코드',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '성명',
  `REQ_NM` varchar(200) DEFAULT NULL COMMENT '연동 정보',
  `MNU_ID` char(1) DEFAULT NULL COMMENT '결과',
  `CREATED_DATE` timestamp(6) NULL DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='연동로그';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkte0001`
--

LOCK TABLES `mslkte0001` WRITE;
/*!40000 ALTER TABLE `mslkte0001` DISABLE KEYS */;
INSERT INTO `mslkte0001` VALUES (1,'03','관리자','admin','통합 계정관리 시스템 연동 ','Y','2022-07-08 15:23:41.000000'),(2,'03','관리자','admin','통합 계정관리 시스템 연동 ','Y','2022-07-09 01:26:46.000000');
/*!40000 ALTER TABLE `mslkte0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktf0001`
--

DROP TABLE IF EXISTS `mslktf0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktf0001` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `ROLE_ID` varchar(50) DEFAULT NULL COMMENT '역할ID',
  `ROLE_NM` varchar(50) DEFAULT NULL COMMENT '역할명',
  `DESC_TT` varchar(4000) DEFAULT NULL COMMENT '설명',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='ROLE관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktf0001`
--

LOCK TABLES `mslktf0001` WRITE;
/*!40000 ALTER TABLE `mslktf0001` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslktf0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktf0002`
--

DROP TABLE IF EXISTS `mslktf0002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktf0002` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `NR_IP_AR` varchar(50) DEFAULT NULL COMMENT 'IP주소',
  `DESC_TT` varchar(4000) DEFAULT NULL COMMENT '설명',
  `SE_TF` char(1) DEFAULT NULL COMMENT '사용유무',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='접속허용IP관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslktf0002`
--

LOCK TABLES `mslktf0002` WRITE;
/*!40000 ALTER TABLE `mslktf0002` DISABLE KEYS */;
INSERT INTO `mslktf0002` VALUES (1,'AD01','관리자','admin','0.0.0.0','관리자 사용 IP등록 사용','Y','admin','2022-07-09 01:39:06','admin','2022-07-09 01:39:06'),(4,'AD01','DDDD','DDDD','0.0.0.0','                  앱 설명을 넣어 주세요.\r\n\r\n                ','Y','admin','2022-07-13 13:27:46','admin',NULL),(6,'AD01','DDDD','DDDD','0.0.0.0','                  앱 설명을 넣어 주세요.\r\n\r\n                ','Y','admin','2022-07-13 14:52:38','admin',NULL);
/*!40000 ALTER TABLE `mslktf0002` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mslkdashboard'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11 13:48:26
