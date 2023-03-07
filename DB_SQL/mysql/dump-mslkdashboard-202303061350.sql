-- MySQL dump 10.13  Distrib 8.0.32, for macos13.0 (x86_64)
--
-- Host: db.uiscloud.net    Database: mslkdashboard
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
-- Table structure for table `codemng`
--

DROP TABLE IF EXISTS `codemng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codemng` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CODE_TYPE` varchar(50) NOT NULL DEFAULT 'makina' COMMENT 'CODE TYPE',
  `CODE_EU` varchar(30) DEFAULT NULL COMMENT 'CODE 용도',
  `CODE_GM` varchar(30) DEFAULT NULL COMMENT 'CODE Group',
  `CODE_WM` varchar(30) DEFAULT NULL COMMENT 'CODE 업무명',
  `CODE_NM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'CODE 이름' COMMENT 'CODE 이름',
  `CODE_VM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'CODE 값',
  `CODE_NOTE` varchar(200) DEFAULT NULL COMMENT 'DashBoard 비고',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='code 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codemng`
--

LOCK TABLES `codemng` WRITE;
/*!40000 ALTER TABLE `codemng` DISABLE KEYS */;
INSERT INTO `codemng` VALUES (6,'EGM','Egmanager Body 구성','EGBODY','getHistoricalData','timeline','timeline','','Y','admin','2023-02-21 08:02:46',NULL),(7,'EGM','Egmanager Body 구성','EGBODY','getHistoricalData','componentName','componentName','','Y','admin','2023-02-21 08:04:41',NULL),(8,'EGM','Egmanager Body 구성','EGBODY','getHistoricalData','componentType','componentType','','Y','admin','2023-02-21 08:04:53',NULL),(9,'EGM','Egmanager Body 구성','EGBODY','getHistoricalData','test','test','','Y','admin','2023-02-21 08:05:16',NULL),(10,'EGM','Egmanager Body 구성','EGBODY','getHistoricalData','measure','measure','','Y','admin','2023-02-21 08:05:29',NULL),(11,'EGM','Egmanager Body 구성','EGBODY','getInfraHealth','filterBy','filterBy','','Y','admin','2023-02-21 08:06:02',NULL),(12,'EGM','Egmanager Body 구성','EGBODY','getInfraHealth','filterValues','filterValues','','Y','admin','2023-02-21 08:06:16',NULL),(13,'EGM','Egmanager Body 구성','EGBODY','getTestData','componentName','componentName','','Y','admin','2023-02-21 08:07:05',NULL),(14,'EGM','Egmanager Body 구성','EGBODY','getTestData','lastmeasure','lastmeasure','','Y','admin','2023-02-21 08:07:23',NULL),(15,'EGM','Egmanager Body 구성','EGBODY','getTestData','startDate','startDate','','Y','admin','2023-02-21 08:07:35',NULL),(16,'EGM','Egmanager Body 구성','EGBODY','getTestData','endDate','endDate','','Y','admin','2023-02-21 08:07:48',NULL),(17,'EGM','Egmanager Body 구성','EGBODY','getTestData','test','test','','Y','admin','2023-02-21 08:08:02',NULL),(18,'EGM','Egmanager Body 구성','EGBODY','getTestData','info','info','','Y','admin','2023-02-21 08:08:12',NULL);
/*!40000 ALTER TABLE `codemng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dashboardmng`
--

DROP TABLE IF EXISTS `dashboardmng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dashboardmng` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DSB_TYPE` varchar(50) NOT NULL DEFAULT 'makina' COMMENT 'DashBoard TYPE',
  `DSB_NM` varchar(50) NOT NULL DEFAULT 'DashBoard 이름' COMMENT 'DashBoard 이름',
  `DSB_EU` varchar(30) DEFAULT NULL COMMENT 'DashBoard 용도',
  `DSB_GM` varchar(30) DEFAULT NULL COMMENT 'DashBoard Group',
  `DSB_WM` varchar(30) DEFAULT NULL COMMENT 'DashBoard 업무명',
  `DSB_URL` varchar(30) DEFAULT NULL COMMENT 'SuperSet 연결 URL',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `DSB_NOTE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'META Host 비고',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='DashBoard 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboardmng`
--

LOCK TABLES `dashboardmng` WRITE;
/*!40000 ALTER TABLE `dashboardmng` DISABLE KEYS */;
INSERT INTO `dashboardmng` VALUES (5,'EGM','SNS 자원사용량','상황판 1','metaMm','DashBoard 업무명','/sns/dashboard?idx=1','N','DashBoard 비고','admin','2023-02-13 00:04:03',NULL),(6,'EGM','SNS CPU 2','CPU 자원 사용량 ','자원 그룹 ','CPU 자원 사용량 ','/sns/dashboard?idx=2','Y','','admin','2023-02-23 07:29:00',NULL),(7,'EGM','NetWork Dashboard','Network 다이어그램을 통한 데이타 확인','SNS ','IPwell Network 다이어그램 ','/sns/dashboard?idx=3','Y','','admin','2023-03-03 01:32:58',NULL);
/*!40000 ALTER TABLE `dashboardmng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egmmeta`
--

DROP TABLE IF EXISTS `egmmeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egmmeta` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `META_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'egmanager' COMMENT 'META TYPE 정보',
  `META_NM` varchar(50) NOT NULL DEFAULT 'HOST 이름' COMMENT 'META 이름',
  `META_EU` varchar(30) DEFAULT NULL COMMENT 'META 용도',
  `META_MM` varchar(30) DEFAULT NULL COMMENT 'META 모델명',
  `META_GM` varchar(30) DEFAULT NULL COMMENT 'META Group',
  `META_WM` varchar(30) DEFAULT NULL COMMENT 'META Host 업무명',
  `META_HM` varchar(30) DEFAULT NULL COMMENT 'META Host 이름',
  `META_OS` varchar(30) DEFAULT NULL COMMENT 'META Host OS',
  `META_IP` varchar(30) DEFAULT NULL COMMENT 'META Host IP',
  `META_TM` varchar(30) DEFAULT NULL COMMENT 'META Host 구분',
  `META_NOTE` varchar(30) DEFAULT NULL COMMENT 'META Host 비고',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='EGManger 대상 장비 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egmmeta`
--

LOCK TABLES `egmmeta` WRITE;
/*!40000 ALTER TABLE `egmmeta` DISABLE KEYS */;
INSERT INTO `egmmeta` VALUES (1,'EGM','MES DB #1','MES Tibero DBMS','Dell','MES','MES DBMS','','Windows 2019 Std','192.168.10.210','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(2,'EGM','MES DB #2','MES Tibero DBMS','Dell','MES','MES DBMS','','Windows 2019 Std','192.168.10.211','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(3,'EGM','MES APP Server #1','MES 웹 서버','Dell','MES','MES WAS','','Windows 2019 Std','192.168.10.213','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(4,'EGM','MES APP Server #2','MES App Aserver #1','Dell','MES','MES C/S inf','','Windows 2019 Std','192.168.10.214','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(5,'EGM','MES APP Server #3','MES App Aserver #2','Dell','MES','MES C/S inf','','Windows 2019 Std','192.168.10.215','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(6,'EGM','MES APP Server #4','','Dell','MES','','','Windows 2019 Std','192.168.10.216','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(7,'EGM','ECM Server','문서 중앙화','Dell','ECM','문서 보안','','Centos 7.9','192.168.10.237','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(8,'EGM','Docker Server','다기능 서버','','','SMS , Remote , Maria DB','','Centos 8 Stream','192.168.10.55','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(9,'EGM','Esxi Server','가상화 서버','Supermicro','','FMC,MSSQL,DEV','','esxi 67u3','192.168.10.50','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(10,'EGM','FMC Server','IPS Mgmt','Firewall Management Center','','IPS 보안 관리','','7.2.0.1','192.168.10.51','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(11,'EGM','IPS F/W','IPS','Firepower 2110 with FTD','','IPS 방화벽','','7.2.0.1','192.168.10.53','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(12,'EGM','MS SQL Server','MSSQL DBMS','Vmware','','ERP , ESD DBMS','','Windows 2022 Std','192.168.10.236','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(13,'EGM','MDS Server','Malware Defence','MDS4000','','IDS 보안관리','','2.1.19.15(build 1200)','192.168.10.40','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(14,'EGM','EPP Server','Ahnlab 통합 플랫폼','Dell','','Ahnlab 통합 보안','','','192.168.10.41','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(15,'EGM','DLP Server','문서 유출 방지','Dell','','문서 유출 방지','','Centos 7.9.2009','192.168.10.64','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(16,'EGM','EDR Server','위험탐지','Dell','','위험 탐지','','','192.168.10.65','OS','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(17,'EGM','BB 9300L','L3 Switch','C9300L-24T-4G-E','','Backborn','','16.12.04','192.168.200.254','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(18,'EGM','SR C1000 #1','Vlan 20,30','C1000-24T-4G-L','','가동 패치 스위치','','15.2(7)E2','192.168.200.253','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(19,'EGM','SR C1000 #2','Vlan 40,50','C1000-24T-4G-L','','나동 패치 스위치','','15.2(7)E5','192.168.200.252','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(20,'EGM','SW C1000 (A1-1)','Switch','C1000-24T-4G-L','','가동 스위치 #1','','15.2(7)E6','192.168.20.4','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(21,'EGM','SW C1000 (A1-2)','Switch','C1000-24T-4G-L','','가동 스위치 #2','','15.2(7)E6','192.168.20.5','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(22,'EGM','SW CBS350 (A1-POE1)','','CBS350-8P-2G','','가동 POE #1','','3.0.0.69','192.168.20.12','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(23,'EGM','SW CBS350 (A1-POE2)','','CBS350-8P-2G','','가동 POE #2','','3.0.0.69','192.168.20.13','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(24,'EGM','SW C1000 (A2-1)','Switch','C1000-24T-4G-L','','가동 2F 스위치 #1','','15.2(7)E6','192.168.30.4','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(25,'EGM','SW C1000 (A2-2)','Switch','C1000-24T-4G-L','','가동 2F 스위치 #2','','15.2(7)E6','192.168.30.5','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(26,'EGM','SW C1000 (B1-1)','Switch','C1000-24T-4G-L','','나동 1F 스위치 #1','','15.2(7)E6','192.168.40.4','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(27,'EGM','SW C1000 (B2-1)','Switch','C1000-24T-4G-L','','나동 2F 스위치 #1','','15.2(7)E6','192.168.50.4','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(28,'EGM','SW C1000 (AB1-1)','Switch','C1000-24T-4G-L','','출하창고 스위치','','15.2(7)E6','192.168.60.4','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(29,'EGM','SW CBS350 (AB1-PEO1)','','CBS350-8P-2G','','출하창고 POE','','3.0.0.69','192.168.60.12','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(30,'EGM','SW C1000 (C1-1)','Switch','C1000-24T-4G-L','','다동 1F 스위치 #1','','15.2(7)E2','192.168.110.253','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(31,'EGM','SW CBS350 (C1-POE1)','','CBS350-8P-2G','','다동 1F POE #1','','3.0.0.69','192.168.110.12','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(32,'EGM','SW C1000 (C2-1)','Switch','C1000-24T-4G-L','','다동 2F 스위치 #1','','15.2(7)E3','192.168.120.253','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(33,'EGM','SW CBS350 (C2-POE1)','','CBS350-8P-2G','','다동 2F POE #1','','3.0.0.69','192.168.120.12','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(34,'EGM','SW C1000 (C3-1)','Switch','C1000-24T-4G-L','','다동 3F 스위치 #1','','15.2(7)E3','192.168.130.253','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(35,'EGM','SW C1000 (C4-1)','Switch','C1000-24T-4G-L','','다동 4F 스위치 #1','','15.2(7)E3','192.168.140.253','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(36,'EGM','WLC C9800','Switch','C9800-L-C-K9','','무선 컨트롤러','','17.6.4','192.168.10.12','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(37,'EGM','AP (A1-1)','','C9115AXI-K','','가동 1F AP #1','','','192.168.20.14','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(38,'EGM','AP (A1-2)','','C9115AXI-K','','가동 1F AP #2','','','192.168.20.15','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(39,'EGM','AP (A1-3)','','C9115AXI-K','','가동 1F AP #3','','','192.168.20.16','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(40,'EGM','AP (A1-4)','','C9115AXI-K','','가동 1F AP #4','','','192.168.20.17','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(41,'EGM','AP (A1-5)','','C9115AXI-K','','가동 1F AP #5','','','192.168.20.18','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(42,'EGM','AP (AB1-1)','','C9115AXI-K','','출하창고 1F AP','','','192.168.60.13','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(43,'EGM','AP (C1-1)','','C9115AXI-K','','다동 1F AP #1','','','192.168.110.13','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(44,'EGM','AP (C2-1)','','C9115AXI-K','','다동 2F AP #1','','','192.168.120.13','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(45,'EGM','AP (C2-2)','','C9115AXI-K','','다동 2F AP #2','','','192.168.120.14','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(46,'EGM','AP (C2-3)','','C9115AXI-K','','다동 2F AP #3','','','192.168.120.15','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53'),(47,'EGM','GenNAC','NAC','Genian NAC Sensor SS64','','네트웍 통제','','5.0.49','192.168.30.2','NW','','admin','2023-02-09 02:14:53','2023-02-09 02:14:53');
/*!40000 ALTER TABLE `egmmeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egmmetadata`
--

DROP TABLE IF EXISTS `egmmetadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egmmetadata` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `META_ID` int NOT NULL COMMENT 'FOREIGN Key ',
  `REST_NAME` varchar(50) DEFAULT NULL COMMENT 'REST API 이름',
  `COMPONENT_NAME` varchar(50) DEFAULT NULL COMMENT 'componentName',
  `START_DATE` varchar(50) DEFAULT NULL COMMENT 'startDate',
  `END_DATE` varchar(50) DEFAULT NULL COMMENT 'endDate',
  `TEST` varchar(50) DEFAULT NULL COMMENT 'test',
  `INFO` varchar(50) DEFAULT NULL COMMENT 'info',
  `COMPONENT_TYPE` varchar(50) DEFAULT NULL COMMENT 'componentType',
  `TIMELINE` varchar(50) DEFAULT NULL COMMENT 'timeline',
  `MEASURE` varchar(50) DEFAULT NULL COMMENT 'measure',
  `SE_TF` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
  PRIMARY KEY (`ID`),
  KEY `META_ID` (`META_ID`),
  CONSTRAINT `egmmetadata_ibfk_1` FOREIGN KEY (`META_ID`) REFERENCES `egmmeta` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='EGManger 대상 장비의 상세 정보 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egmmetadata`
--

LOCK TABLES `egmmetadata` WRITE;
/*!40000 ALTER TABLE `egmmetadata` DISABLE KEYS */;
INSERT INTO `egmmetadata` VALUES (1,5,'EGM','componentName','startDate','endDate','test','info','componentType','timeline','measure','Y','admin','2023-02-24 09:02:30',NULL),(2,5,'EGM','componentName','startDate','endDate','test','info','componentType','timeline','measure','Y','admin','2023-02-24 09:04:24',NULL);
/*!40000 ALTER TABLE `egmmetadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hyperrestapi`
--

DROP TABLE IF EXISTS `hyperrestapi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hyperrestapi` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `REST_TYPE` varchar(50) NOT NULL DEFAULT 'egmanager' COMMENT 'REST API TYPE 정보',
  `REST_CONTENT` varchar(50) NOT NULL DEFAULT 'HOST 자원조회' COMMENT 'REST API 조회 정보 확인',
  `USR_EN` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'admin' COMMENT '연결 ID',
  `USR_PW` varchar(30) NOT NULL DEFAULT 'bHlpanVuIUAwOQ==' COMMENT '연결 암호_base64',
  `CONTENT_TYPE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'application/json' COMMENT 'REST_HEAFER 정보',
  `ACCEPT` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'application/json' COMMENT 'REST_HEAFER 정보',
  `REST_SERVER` varchar(50) NOT NULL DEFAULT 'http://172.30.1.109:7077/api/eg/analytics/' COMMENT 'REST API 서버 정보',
  `REST_FUNCTION` varchar(50) NOT NULL DEFAULT 'getTestData' COMMENT 'REST API 연결 정보',
  `REST_HTTP` varchar(50) NOT NULL DEFAULT 'POST' COMMENT 'REST API HTTP 방법',
  `SE_TF` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `REST_SYNC` varchar(50) NOT NULL DEFAULT 'OFFLINE' COMMENT 'REST API Sync',
  `SYNC_TIME` varchar(50) NOT NULL DEFAULT '1m' COMMENT 'REST API Sync 시기',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='REST API 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hyperrestapi`
--

LOCK TABLES `hyperrestapi` WRITE;
/*!40000 ALTER TABLE `hyperrestapi` DISABLE KEYS */;
INSERT INTO `hyperrestapi` VALUES (6,'egmanager','Alarm 정보 조회','admin','bHlpanVuIUAwOQ==','application/json','application/json','http://172.30.1.109:7077/api/eg/analytics/','getAlarmCount','POST','Y','online','1m','admin',NULL,NULL),(7,'egmanager','Host 자원 정보를 조회','admin','bHlpanVuIUAwOQ==','application/json','application/json','http://172.30.1.109:7077/api/eg/analytics/','getTestData','POST','Y','offline','5m','admin',NULL,NULL),(8,'egmanager','Host Memory 정보를 조회 ','admin','bHlpanVuIUAwOQ==','application/json','application/json','http://172.30.1.109:7077/api/eg/analytics/','getTestData','POST','Y','offline','5m','admin','2023-02-08 07:46:53',NULL);
/*!40000 ALTER TABLE `hyperrestapi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hyperrestapidata`
--

DROP TABLE IF EXISTS `hyperrestapidata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hyperrestapidata` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `REST_ID` int NOT NULL,
  `REST_CONTENT` varchar(50) NOT NULL DEFAULT 'getTestData' COMMENT 'REST API BODY KEY',
  `REST_DATA` varchar(50) NOT NULL DEFAULT 'POST' COMMENT 'REST API BODY 값',
  `SE_TF` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`),
  KEY `REST_ID` (`REST_ID`),
  CONSTRAINT `hyperrestapidata_ibfk_1` FOREIGN KEY (`REST_ID`) REFERENCES `hyperrestapi` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='REST Input Data 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hyperrestapidata`
--

LOCK TABLES `hyperrestapidata` WRITE;
/*!40000 ALTER TABLE `hyperrestapidata` DISABLE KEYS */;
/*!40000 ALTER TABLE `hyperrestapidata` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkboard`
--

LOCK TABLES `mslkboard` WRITE;
/*!40000 ALTER TABLE `mslkboard` DISABLE KEYS */;
INSERT INTO `mslkboard` VALUES (31,'2022-11-30 17:20:34',NULL,'<p>                  공지 내용을 작성 해 주세요.<br>T<br>E<br>ET<br><br>TE<br>T<br><br>E<br>T<br>E<br>T<br>E<br>T<br><br>E<br>T<br>E<br><br>T<br>ETTETETEET</p><p>\r\n                </p>','TESTTETETE','admin'),(32,'2023-02-23 11:14:18',NULL,'<p>                  공지 내용을 작성 해 주세</p><p><br></p><p>ㅇㄹㄴㅇㅁㄹㅇㅁㄴㄹㅇㄴㅁㄹ</p><p><br></p><p>요.\r\n                </p>','서비스 만들기','admin'),(33,'2023-02-27 15:19:50',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','test1','admin'),(35,'2023-02-27 15:20:23',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','yy','admin'),(36,'2023-02-27 15:20:36',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','y','admin'),(37,'2023-02-27 15:22:52',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','test3','admin'),(38,'2023-02-27 15:25:06',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','/admin/notice/search','admin'),(39,'2023-02-27 15:25:28',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','yyyy','admin'),(40,'2023-02-27 15:29:03',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','ttttttt','admin'),(41,'2023-02-27 15:49:18',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','1','admin'),(42,'2023-02-27 15:49:22',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','2','admin'),(43,'2023-02-27 15:49:26',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','3','admin'),(44,'2023-02-27 15:49:31',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','4','admin'),(45,'2023-02-28 09:21:11',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','6','admin'),(46,'2023-02-28 09:21:16',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','7','admin'),(47,'2023-02-28 09:21:21',NULL,'                  공지 내용을 작성 해 주세요.\r\n                ','8','admin');
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
/*!40000 ALTER TABLE `mslktf0002` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_department`
--

DROP TABLE IF EXISTS `tb_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT ' 부서 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '부서명',
  `upper_id` varchar(50) DEFAULT NULL COMMENT '상위부서 ID',
  `lft_id` varchar(50) DEFAULT NULL COMMENT 'Neseted Set Model 좌측 ID',
  `rgt_id` varchar(50) DEFAULT NULL COMMENT 'Nelgusmsseted Set Model 우측 ID',
  `depth` varchar(50) DEFAULT NULL COMMENT 'Depth',
  `seq` int DEFAULT NULL COMMENT '순서',
  `sync_use` int DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `tree_id` varchar(50) DEFAULT NULL COMMENT 'Full Tree ID',
  `root` int DEFAULT NULL COMMENT '최상위 유무(0/1 , FALSE/TRUE)',
  `del` int DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT=' 부서 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
INSERT INTO `tb_department` VALUES (2,'lhleeuid','name','upperId','lftId','treeIdtreeIdtreeIdtreeIdtreeIdtreeId','depth',1,0,'treeId',1,0,'2023-02-20 09:16:21',NULL,NULL,'treeIdtreeIdtreeIdtreeIdtreeIdtreeId'),(3,'lhlee','LEE LAE HOON','11','lftId','ffgfgdsfd','11',1,0,'treeId',1,0,'2023-02-28 07:00:23',NULL,NULL,''),(4,'1dfdfd','2fdfdfdfdfd','2','2','222','2',1,1,'2',0,0,'2023-02-28 07:18:56',NULL,NULL,'222');
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_position`
--

DROP TABLE IF EXISTS `tb_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_position` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT ' 직책 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '직책명',
  `seq` int DEFAULT NULL COMMENT '순서',
  `sync_use` int DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='직책 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_position`
--

LOCK TABLES `tb_position` WRITE;
/*!40000 ALTER TABLE `tb_position` DISABLE KEYS */;
INSERT INTO `tb_position` VALUES (2,'lhleeuid','이거되나 ',1,0,0,'2023-02-21 00:46:45',NULL,NULL,''),(3,'lhlee','LEE LAE HOON',1,1,0,'2023-02-28 08:27:11',NULL,NULL,'ㅍㄹㄹㄹㄹ'),(4,'ㅇㅇㅇㅇ','ㅇㅇㅇㅇㅇ',1,0,0,'2023-02-28 08:28:49',NULL,NULL,'');
/*!40000 ALTER TABLE `tb_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rank`
--

DROP TABLE IF EXISTS `tb_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rank` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT ' 직급 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '직급명',
  `seq` int DEFAULT NULL COMMENT '순서',
  `sync_use` int DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='직급 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rank`
--

LOCK TABLES `tb_rank` WRITE;
/*!40000 ALTER TABLE `tb_rank` DISABLE KEYS */;
INSERT INTO `tb_rank` VALUES (2,'lhlee@goodmit.co.kr','LEE LAE HOON',1,1,0,'2023-02-21 01:38:20',NULL,NULL,'111'),(3,'lhleeuid','LEE LAE HOON',1,1,0,'2023-02-21 01:46:19',NULL,NULL,'11'),(4,'부서장ghhgshs','이래훈',2,1,0,'2023-03-02 00:50:36',NULL,NULL,'부서장 입니다. ');
/*!40000 ALTER TABLE `tb_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_staff`
--

DROP TABLE IF EXISTS `tb_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_staff` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT ' login ID',
  `name` varchar(30) DEFAULT NULL COMMENT '부서명',
  `f_name` varchar(50) DEFAULT NULL COMMENT '사원 이름',
  `l_name` varchar(50) DEFAULT NULL COMMENT '사원 성',
  `full_name` varchar(50) DEFAULT NULL COMMENT '사원 전체 이름',
  `identity_no` varchar(50) DEFAULT NULL COMMENT '사원 번호',
  `pw` varchar(100) DEFAULT NULL COMMENT '비밀번호',
  `sex` varchar(50) DEFAULT NULL COMMENT '성별(남/여)',
  `rank_id` varchar(50) DEFAULT NULL COMMENT '직급 ID',
  `position_id` varchar(50) DEFAULT NULL COMMENT '직책 ID',
  `department_id` varchar(50) DEFAULT NULL COMMENT '부서 ID',
  `head` int DEFAULT NULL COMMENT '부서장 유무 (0/1 , FALSE/TRUE)',
  `utype` varchar(50) NOT NULL DEFAULT 'USER' COMMENT '사용자 유형(Admin,User,OP) default : User',
  `auth` varchar(50) DEFAULT NULL COMMENT '사용자 권한 (S,R,L,C)',
  `concurrent_position` varchar(50) DEFAULT NULL COMMENT '겸직',
  `user_id` varchar(50) DEFAULT NULL COMMENT '겸직 사용자 아이디',
  `e_mail` varchar(50) DEFAULT NULL COMMENT 'E-mail',
  `hp` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '연락처',
  `seq` int DEFAULT NULL COMMENT '순서',
  `sync_use` int DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `sync_system` varchar(500) DEFAULT NULL COMMENT '동기화시스템 (,)',
  `finger_print` varchar(500) DEFAULT NULL COMMENT '지문정보',
  `card_no` varchar(500) DEFAULT NULL COMMENT '카드정보',
  `del` int DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사용자 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_staff`
--

LOCK TABLES `tb_staff` WRITE;
/*!40000 ALTER TABLE `tb_staff` DISABLE KEYS */;
INSERT INTO `tb_staff` VALUES (3,'lhlee','111','래훈','이','이래훈','123-011111','1111','남','11','11','111',0,'USER','S','11','11','11','11',1,1,'11','11','11',0,'2023-02-20 06:07:50',NULL,NULL,'111'),(4,'lhlee','2222','1','1','1','2222','','남','1','1','1',1,'USER','S','1','1','1','1',1,1,'1','1','1',0,'2023-02-28 06:51:37',NULL,NULL,''),(5,'lhlee','ddd','ddd','ddd','d','ddd','dfdfdf','남','ddd','ddd','ddd',1,'USER','S','ddfsdgfsdg','','','',1,1,'11','11','11',0,'2023-03-06 04:28:51',NULL,NULL,'222');
/*!40000 ALTER TABLE `tb_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sync_svr`
--

DROP TABLE IF EXISTS `tb_sync_svr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sync_svr` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT ' 서버 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '서버명',
  `ip` varchar(50) DEFAULT NULL COMMENT '서버 IP',
  `seq` int DEFAULT NULL COMMENT '순서',
  `sync_use` int DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `modi_id` varchar(50) DEFAULT NULL COMMENT '마지막 데이터 생성 , 수정 ,삭제자',
  `memo` text COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Sync 서버 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sync_svr`
--

LOCK TABLES `tb_sync_svr` WRITE;
/*!40000 ALTER TABLE `tb_sync_svr` DISABLE KEYS */;
INSERT INTO `tb_sync_svr` VALUES (1,'lhlee sssss','Lsssssssss','192.168.0.111',1,1,0,'2023-02-21 04:43:20',NULL,NULL,'admin','3333'),(2,'WAS Server','test Server','123.123.123.123',1,0,0,'2023-03-02 01:54:07',NULL,NULL,'admin','treeIdtreeIdtreeIdtreeIdtreeIdtreeId'),(3,'DB 서버 ','DB 서버 입니다. dfggfgf','123.123.123.123',1,0,0,'2023-03-02 01:58:29',NULL,NULL,'admin','11');
/*!40000 ALTER TABLE `tb_sync_svr` ENABLE KEYS */;
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

-- Dump completed on 2023-03-06 13:51:00
