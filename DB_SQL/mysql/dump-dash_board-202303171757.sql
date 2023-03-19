-- MySQL dump 10.13  Distrib 8.0.32, for macos13.0 (x86_64)
--
-- Host: 192.168.10.55    Database: dash_board
-- ------------------------------------------------------
-- Server version	5.5.5-10.9.2-MariaDB-1:10.9.2+maria~ubu2204

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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CODE_TYPE` varchar(50) NOT NULL DEFAULT 'makina' COMMENT 'CODE TYPE',
  `CODE_EU` varchar(30) DEFAULT NULL COMMENT 'CODE 용도',
  `CODE_GM` varchar(30) DEFAULT NULL COMMENT 'CODE Group',
  `CODE_WM` varchar(30) DEFAULT NULL COMMENT 'CODE 업무명',
  `CODE_NM` varchar(50) NOT NULL DEFAULT 'CODE 이름' COMMENT 'CODE 이름',
  `CODE_VM` varchar(50) DEFAULT NULL COMMENT 'CODE 값',
  `CODE_NOTE` varchar(200) DEFAULT NULL COMMENT 'DashBoard 비고',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='code 관리';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DSB_TYPE` varchar(50) NOT NULL DEFAULT 'makina' COMMENT 'DashBoard TYPE',
  `DSB_NM` varchar(50) NOT NULL DEFAULT 'DashBoard 이름' COMMENT 'DashBoard 이름',
  `DSB_EU` varchar(30) DEFAULT NULL COMMENT 'DashBoard 용도',
  `DSB_GM` varchar(30) DEFAULT NULL COMMENT 'DashBoard Group',
  `DSB_WM` varchar(30) DEFAULT NULL COMMENT 'DashBoard 업무명',
  `DSB_URL` varchar(30) DEFAULT NULL COMMENT 'SuperSet 연결 URL',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `DSB_NOTE` varchar(30) DEFAULT NULL COMMENT 'META Host 비고',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='DashBoard 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dashboardmng`
--

LOCK TABLES `dashboardmng` WRITE;
/*!40000 ALTER TABLE `dashboardmng` DISABLE KEYS */;
INSERT INTO `dashboardmng` VALUES (5,'EGM','SNS 자원사용량','SYSTEM 기반의 자원 모니터링 ','SYSTEM','연관 시스템의 자원 사용량 ','/sns/dashboard?idx=1','Y','업무 시스템 기반의 자원 사용량 모니터링 ','admin','2023-02-13 00:04:03',NULL),(6,'EGM','SNS DB  모니터링 ','DB 시스템의 자원 사용량 ','DB','DB 자원 사용량 ','/sns/dashboard?idx=2','Y','','admin','2023-02-23 07:29:00',NULL),(7,'EGM','NetWork Dashboard','Network 다이어그램을 통한 데이타 확인','NETWORK','Network 기반의 데이터 사용량','/sns/dashboard?idx=3','Y','','admin','2023-03-03 01:32:58',NULL);
/*!40000 ALTER TABLE `dashboardmng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egmmeta`
--

DROP TABLE IF EXISTS `egmmeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egmmeta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `META_TYPE` varchar(50) NOT NULL DEFAULT 'egmanager' COMMENT 'META TYPE 정보',
  `META_NM` varchar(50) NOT NULL DEFAULT 'HOST 이름' COMMENT 'META 이름',
  `META_EU` varchar(30) DEFAULT NULL COMMENT 'META 용도',
  `META_MM` varchar(30) DEFAULT NULL COMMENT 'META 모델명',
  `META_GM` varchar(30) DEFAULT NULL COMMENT 'META Group',
  `META_WM` varchar(30) DEFAULT NULL COMMENT 'META Host 업무명',
  `META_HM` varchar(30) DEFAULT NULL COMMENT 'META Host 이름',
  `META_OS` varchar(30) DEFAULT NULL COMMENT 'META Host OS',
  `META_IP` varchar(30) DEFAULT NULL COMMENT 'META Host IP',
  `META_CORE` varchar(10) DEFAULT NULL COMMENT 'CPU Core 수',
  `META_MEM` varchar(10) DEFAULT NULL COMMENT '설치된 메모리 GB',
  `META_CPUCHECK` varchar(10) DEFAULT NULL COMMENT 'CPU 알람',
  `META_MEMCHECK` varchar(10) DEFAULT NULL COMMENT '메모 알람',
  `META_DISKCHECK` varchar(10) DEFAULT NULL COMMENT '용량 알람',
  `META_TM` varchar(30) DEFAULT NULL COMMENT 'META Host 구분',
  `META_NOTE` varchar(30) DEFAULT NULL COMMENT 'META Host 비고',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COMMENT='EGManger 대상 장비 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egmmeta`
--

LOCK TABLES `egmmeta` WRITE;
/*!40000 ALTER TABLE `egmmeta` DISABLE KEYS */;
INSERT INTO `egmmeta` VALUES (1,'DB','MES DB #1','MES Tibero DBMS','Dell','MES','MES DBMS','MES_Tibero_1_t','Windows 2019 Std','192.168.10.210','16','32GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(2,'DB','MES DB #2','MES Tibero DBMS','Dell','MES','MES DBMS','MES_Tibero_2_t','Windows 2019 Std','192.168.10.211','16','32GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(3,'WAS','MES APP Server #1','MES 웹 서버','Dell','MES','MES WAS','MES_App_1_t','Windows 2019 Std','192.168.10.213','8','16GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(4,'APP','MES APP Server #2','MES App Aserver #1','Dell','MES','MES C/S inf','MES_App_2_t','Windows 2019 Std','192.168.10.214','8','16GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(5,'APP','MES APP Server #3','MES App Aserver #2','Dell','MES','MES C/S inf','MES_App_3_t','Windows 2019 Std','192.168.10.215','8','16GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(6,'APP','MES APP Server #4','','Dell','MES','','MES_App_4_t','Windows 2019 Std','192.168.10.216','8','16GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(7,'SYSTEM','EAP Server','문서 중앙화','Dell','SMM','문서 보안','','Centos 7.9','192.168.10.237',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(8,'SYSTEM','Docker Server','다기능 서버','','APP','SMS , Remote , Maria DB','','Centos 8 Stream','192.168.10.55',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(9,'SYSTEM','Esxi Server','가상화 서버','Supermicro','SMM','FMC,MSSQL,DEV','','esxi 67u3','192.168.10.50',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(10,'SYSTEM','FMC Server','IPS Mgmt','Firewall Management Center','SMM','IPS 보안 관리','','7.2.0.1','192.168.10.51',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(11,'SYSTEM','IPS F/W','IPS','Firepower 2110 with FTD','SMM','IPS 방화벽','','7.2.0.1','192.168.10.53',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(12,'DB','MS SQL Server','MSSQL DBMS','Vmware','ERP','ERP , ESD DBMS','MSSQL_Server_t','Windows 2022 Std','192.168.10.236','4','16GB','90','85','80','OS','','admin','2023-02-09 02:14:53',NULL),(13,'SYSTEM','MDS Server','Malware Defence','MDS4000','SMM','IDS 보안관리','','2.1.19.15(build 1200)','192.168.10.40',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(14,'SYSTEM','EPP Server','Ahnlab 통합 플랫폼','Dell','SMM','Ahnlab 통합 보안','','','192.168.10.41',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(15,'SYSTEM','DLP Server','문서 유출 방지','Dell','SMM','문서 유출 방지','','Centos 7.9.2009','192.168.10.64',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL),(16,'SYSTEM','EDR Server','위험탐지','Dell','SMM','위험 탐지','','','192.168.10.65',NULL,NULL,NULL,NULL,NULL,'OS','','admin','2023-02-09 02:14:53',NULL);
/*!40000 ALTER TABLE `egmmeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egmmetadata`
--

DROP TABLE IF EXISTS `egmmetadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egmmetadata` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `META_ID` int(11) NOT NULL COMMENT 'FOREIGN Key ',
  `REST_NAME` varchar(50) DEFAULT NULL COMMENT 'REST API 이름',
  `COMPONENT_NAME` varchar(50) DEFAULT NULL COMMENT 'componentName',
  `TEST` varchar(50) DEFAULT NULL COMMENT 'test',
  `INFO` varchar(50) DEFAULT NULL COMMENT 'info',
  `COMPONENT_TYPE` varchar(50) DEFAULT NULL COMMENT 'componentType',
  `TIMELINE` varchar(50) DEFAULT NULL COMMENT 'timeline',
  `MEASURE` varchar(50) DEFAULT NULL COMMENT 'measure',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`ID`),
  KEY `META_ID` (`META_ID`),
  CONSTRAINT `egmmetadata_ibfk_1` FOREIGN KEY (`META_ID`) REFERENCES `egmmeta` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COMMENT='EGManger 대상 장비의 상세 정보 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egmmetadata`
--

LOCK TABLES `egmmetadata` WRITE;
/*!40000 ALTER TABLE `egmmetadata` DISABLE KEYS */;
INSERT INTO `egmmetadata` VALUES (5,1,'EGM','MES_Tibero_1_t','System Details','Summary','getTestData','10분','Y','Y','admin','2023-03-15 07:28:37',NULL),(6,1,'EGM','MES_Tibero_1_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 07:29:11',NULL),(7,1,'EGM','MES_Tibero_1_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:04:23',NULL),(8,2,'EGM','MES_Tibero_2_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:06:18',NULL),(9,2,'EGM','MES_Tibero_2_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:06:42',NULL),(10,2,'EGM','MES_Tibero_2_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:06:55',NULL),(11,2,'EGM','MES_Tibero_2_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:07:07',NULL),(12,3,'EGM','MES_App_1_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:07:26',NULL),(13,3,'EGM','MES_App_1_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:07:38',NULL),(14,3,'EGM','MES_App_1_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:07:52',NULL),(15,3,'EGM','MES_App_1_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:08:03',NULL),(17,4,'EGM','MES_App_2_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:10:45',NULL),(18,4,'EGM','MES_App_2_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:14:13',NULL),(19,4,'EGM','MES_App_2_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:14:36',NULL),(20,4,'EGM','MES_App_2_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:14:50',NULL),(21,5,'EGM','MES_App_3_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:15:23',NULL),(22,5,'EGM','MES_App_3_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:15:40',NULL),(23,5,'EGM','MES_App_3_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:15:52',NULL),(24,5,'EGM','MES_App_3_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:16:05',NULL),(25,6,'EGM','MES_App_4_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:16:33',NULL),(26,6,'EGM','MES_App_4_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:16:46',NULL),(27,6,'EGM','MES_App_4_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:17:00',NULL),(28,6,'EGM','MES_App_4_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:17:13',NULL),(29,12,'EGM','MSSQL_Server_t','System Details','Summary','getTestData','2분','Y','Y','admin','2023-03-15 08:17:52',NULL),(30,12,'EGM','MSSQL_Server_t','Uptime','','getTestData','2분','Y','Y','admin','2023-03-15 08:18:02',NULL),(31,12,'EGM','MSSQL_Server_t','Disk Space','','getTestData','2분','Y','Y','admin','2023-03-15 08:18:18',NULL),(32,12,'EGM','MSSQL_Server_t','Memory Usage','','getTestData','2분','Y','Y','admin','2023-03-15 08:18:32',NULL);
/*!40000 ALTER TABLE `egmmetadata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hyperrestapi`
--

DROP TABLE IF EXISTS `hyperrestapi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hyperrestapi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `REST_TYPE` varchar(50) NOT NULL DEFAULT 'egmanager' COMMENT 'REST API TYPE 정보',
  `REST_CONTENT` varchar(50) NOT NULL DEFAULT 'HOST 자원조회' COMMENT 'REST API 조회 정보 확인',
  `USR_EN` varchar(30) NOT NULL DEFAULT 'admin' COMMENT '연결 ID',
  `USR_PW` varchar(30) NOT NULL DEFAULT 'bHlpanVuIUAwOQ==' COMMENT '연결 암호_base64',
  `MANAGERURL` varchar(30) NOT NULL DEFAULT 'http://192.168.10.62:7077' COMMENT 'EG Mnager URL',
  `EGMMNGID` int(11) DEFAULT NULL COMMENT 'EG MNG DATA ID',
  `REST_SERVER` varchar(50) NOT NULL DEFAULT 'http://172.30.1.109:7077/api/eg/analytics/' COMMENT 'REST API 서버 정보',
  `REST_FUNCTION` varchar(50) NOT NULL DEFAULT 'getTestData' COMMENT 'REST API 연결 정보',
  `REST_HTTP` varchar(50) NOT NULL DEFAULT 'POST' COMMENT 'REST API HTTP 방법',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `REST_SYNC` varchar(50) NOT NULL DEFAULT 'OFFLINE' COMMENT 'REST API Sync',
  `SYNC_TIME` varchar(50) NOT NULL DEFAULT '1m' COMMENT 'REST API Sync 시기',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='REST API 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hyperrestapi`
--

LOCK TABLES `hyperrestapi` WRITE;
/*!40000 ALTER TABLE `hyperrestapi` DISABLE KEYS */;
INSERT INTO `hyperrestapi` VALUES (9,'egmanager','EG Manager 의 Alarm 의 Count 수 를 가져 온다. ','admin','c25zMTIzNCE=','http://192.168.10.62:7077',1,'http://192.168.10.62:7077/api/eg/analytics/','getAlarmCount','POST','Y','online','5m','admin','2023-03-10 03:37:53',NULL),(10,'egmanager','Host 자원 정보를 조회 하는 Rest API','admin','c25zMTIzNCE=','http://192.168.10.62:7077',2,'http://192.168.10.62:7077/api/eg/analytics/','getTestData','POST','Y','online','5m','admin','2023-03-10 03:42:01',NULL);
/*!40000 ALTER TABLE `hyperrestapi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hyperrestapidata`
--

DROP TABLE IF EXISTS `hyperrestapidata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hyperrestapidata` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `REST_ID` int(11) NOT NULL,
  `REST_CONTENT` varchar(50) NOT NULL DEFAULT 'getTestData' COMMENT 'REST API BODY KEY',
  `REST_DATA` varchar(50) NOT NULL DEFAULT 'POST' COMMENT 'REST API BODY 값',
  `SE_TF` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정 ID',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`),
  KEY `REST_ID` (`REST_ID`),
  CONSTRAINT `hyperrestapidata_ibfk_1` FOREIGN KEY (`REST_ID`) REFERENCES `hyperrestapi` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='REST Input Data 관리';
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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT current_timestamp(),
  `modified_date` datetime DEFAULT NULL,
  `content` text NOT NULL,
  `title` varchar(100) NOT NULL,
  `writer` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkboard`
--

LOCK TABLES `mslkboard` WRITE;
/*!40000 ALTER TABLE `mslkboard` DISABLE KEYS */;
INSERT INTO `mslkboard` VALUES (36,'2023-02-27 15:20:36',NULL,'<p>                  공지 내용을 작성 해 주세요.</p><p><br></p><p><br></p><p><br></p><p>\r\n                </p>','공지사항 게시판입니다. ','admin');
/*!40000 ALTER TABLE `mslkboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslkmember`
--

DROP TABLE IF EXISTS `mslkmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslkmember` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '이름',
  `password` varchar(100) NOT NULL,
  `created_date` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='사용자관리';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서명',
  `EM_NM` char(50) DEFAULT NULL COMMENT '이메일',
  `NR_IP_AR` varchar(50) DEFAULT NULL COMMENT '관리공간_IP',
  `EAR_EHF` char(1) DEFAULT NULL COMMENT '공용계정 USE_YN',
  `AD_TF` char(1) DEFAULT NULL COMMENT '관리자여부',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='사용자관리';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자 ID',
  `US_TF` char(1) DEFAULT NULL COMMENT '사용구분',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '소유자 사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `RULE_ID` int(11) DEFAULT NULL COMMENT 'DATA_권한',
  `SE_TF` char(1) DEFAULT NULL COMMENT '사용유무',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '등록일시',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='공용계정 관리 테이블';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `GSN_ID` int(11) NOT NULL COMMENT '앱코드',
  `APP_NM` varchar(50) DEFAULT NULL COMMENT '앱명',
  `CL_NM` varchar(100) DEFAULT NULL COMMENT '클러스터명',
  `PGE_URL_AR` varchar(200) DEFAULT NULL COMMENT '링크 URL',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '역할ID',
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='사용자권한관리';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '시간',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `EM_NM` char(20) DEFAULT NULL COMMENT '이메일',
  `UG_NM` char(20) DEFAULT NULL COMMENT '활동',
  `REF_URL_AR` varchar(200) DEFAULT NULL COMMENT 'ReferURL',
  `USR_IP` char(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='인증감사';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='계정감사';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `CREATED_DATE` timestamp NULL DEFAULT NULL COMMENT '시간',
  `WR_TY` char(20) DEFAULT NULL COMMENT '타입',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `UG_ID` int(11) DEFAULT NULL COMMENT '사용권한 부여 이력',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='권한감사';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DCD` varchar(30) DEFAULT NULL COMMENT '부서코드',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사번',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '성명',
  `REQ_NM` varchar(200) DEFAULT NULL COMMENT '연동 정보',
  `MNU_ID` char(1) DEFAULT NULL COMMENT '결과',
  `CREATED_DATE` timestamp(6) NULL DEFAULT NULL COMMENT '등록일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='연동로그';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mslkte0001`
--

LOCK TABLES `mslkte0001` WRITE;
/*!40000 ALTER TABLE `mslkte0001` DISABLE KEYS */;
/*!40000 ALTER TABLE `mslkte0001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mslktf0001`
--

DROP TABLE IF EXISTS `mslktf0001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mslktf0001` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `ROLE_ID` varchar(50) DEFAULT NULL COMMENT '역할ID',
  `ROLE_NM` varchar(50) DEFAULT NULL COMMENT '역할명',
  `DESC_TT` varchar(4000) DEFAULT NULL COMMENT '설명',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='ROLE관리';
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
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '등록순번',
  `DCD` varchar(50) DEFAULT NULL COMMENT '부서코드',
  `USR_NM` varchar(30) DEFAULT NULL COMMENT '사용자명',
  `USR_EN` varchar(30) DEFAULT NULL COMMENT '사용자ID',
  `NR_IP_AR` varchar(50) DEFAULT NULL COMMENT 'IP주소',
  `DESC_TT` varchar(4000) DEFAULT NULL COMMENT '설명',
  `SE_TF` char(1) DEFAULT NULL COMMENT '사용유무',
  `RG_EN` varchar(30) DEFAULT NULL COMMENT '등록사번',
  `CREATED_DATE` timestamp NULL DEFAULT current_timestamp() COMMENT '등록일시',
  `ALT_EN` varchar(30) DEFAULT NULL COMMENT '수정사번',
  `MODIFIED_DATE` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='접속허용IP관리';
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) DEFAULT NULL COMMENT ' 부서 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '부서명',
  `upper_id` varchar(50) DEFAULT NULL COMMENT '상위부서 ID',
  `lft_id` int(11) DEFAULT NULL COMMENT 'Neseted Set Model 좌측 ID',
  `rgt_id` int(11) DEFAULT NULL COMMENT 'Nelgusmsseted Set Model 우측 ID',
  `depth` varchar(50) DEFAULT NULL COMMENT 'Depth',
  `seq` int(11) DEFAULT NULL COMMENT '순서',
  `sync_use` int(11) DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `tree_id` varchar(50) DEFAULT NULL COMMENT 'Full Tree ID',
  `root` int(11) DEFAULT NULL COMMENT '최상위 유무(0/1 , FALSE/TRUE)',
  `del` int(11) DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text DEFAULT NULL COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT=' 부서 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
INSERT INTO `tb_department` VALUES (1,'SNS_CO','(주)에스앤에스','SNS_CO',1,94,'0',0,1,'',1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(2,'SNS0001','회장','SNS_CO',4,5,'1',1,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(3,'SNS0002','사장','SNS_CO',6,7,'1',2,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(4,'SNS0003','부사장','SNS_CO',8,9,'1',3,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(5,'SNS1100','경영지원담당','SNS_CO',10,15,'1',4,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(6,'SNS1101','관리팀','SNS1100',11,12,'2',5,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(7,'SNS1102','재경팀','SNS1100',13,14,'2',6,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(8,'SNS1200','사업담당','SNS_CO',16,23,'1',7,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(9,'SNS1201','사업팀','SNS1200',17,18,'2',8,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(10,'SNS1202','구매팀','SNS1200',19,20,'2',9,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(11,'SNS1420','자재팀','SNS1200',21,22,'2',10,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(12,'SNS1300','디지털전략담당','SNS_CO',24,27,'1',11,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(13,'SNS1301','디지털전략팀','SNS1300',25,26,'2',12,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(14,'SNS1400','생산본부','SNS_CO',28,43,'1',13,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(15,'SNS1430','생산관리팀','SNS1400',29,30,'2',14,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(16,'SNS1441','SMT팀','SNS1400',31,32,'2',15,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(17,'SNS1442','생산지원팀','SNS1400',33,34,'2',16,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(18,'SNS1450','조립1팀','SNS1400',35,36,'2',17,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(19,'SNS1460','조립2팀','SNS1400',37,38,'2',18,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(20,'SNS1470','물류팀','SNS1400',39,42,'2',19,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(21,'SNS1431','물류파트','SNS1470',40,41,'3',20,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(22,'SNS1500','종합기술연구소','SNS_CO',44,61,'1',21,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(23,'SNS1550','연구담당','SNS1500',45,48,'2',22,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(24,'SNS1552','연구팀','SNS1550',46,47,'3',23,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(25,'SNS1530','연구개발담당','SNS1500',49,54,'2',24,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(26,'SNS1510','개발팀','SNS1530',50,51,'3',25,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(27,'SNS1520','SMT기술팀','SNS1530',52,53,'3',26,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(28,'SNS1540','생산기술담당','SNS1500',55,60,'2',27,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(29,'SNS1531','선행기술팀','SNS1540',56,57,'3',28,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(30,'SNS1541','공정기술팀','SNS1540',58,59,'3',29,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(31,'SNS1600','품질관리담당','SNS_CO',62,69,'1',30,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(32,'SNS1601','품질관리 1팀','SNS1600',63,64,'2',31,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(33,'SNS1602','품질관리 2팀','SNS1600',65,66,'2',32,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(34,'SNS1603','품질관리 3팀','SNS1600',67,68,'2',33,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(35,'SNS2100','고전력CU','SNS_CO',70,77,'1',34,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(36,'SNS2110','개발','SNS2100',71,72,'2',35,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(37,'SNS2120','기술','SNS2100',73,74,'2',36,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(38,'SNS2130','생산','SNS2100',75,76,'2',37,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(39,'SNS9100','생산현장','SNS_CO',78,93,'1',38,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(40,'SNS9105','현장관리팀','SNS9100',79,80,'2',39,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(41,'SNS9110','현장 자재팀','SNS9100',81,82,'2',40,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(42,'SNS9120','현장 물류팀','SNS9100',83,84,'2',41,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(43,'SNS9130','현장 SMT팀','SNS9100',85,86,'2',42,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(44,'SNS9150','현장 조립1팀','SNS9100',87,88,'2',43,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(45,'SNS9160','현장 조립2팀','SNS9100',89,90,'2',44,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(46,'SNS9170','현장 품질관리팀','SNS9100',91,92,'2',45,1,'',0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(47,NULL,'생산현장',NULL,2,3,NULL,NULL,NULL,NULL,NULL,NULL,'2023-03-13 14:56:58',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_position`
--

DROP TABLE IF EXISTS `tb_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) DEFAULT NULL COMMENT ' 직책 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '직책명',
  `seq` int(11) DEFAULT NULL COMMENT '순서',
  `sync_use` int(11) DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int(11) DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text DEFAULT NULL COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='직책 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_position`
--

LOCK TABLES `tb_position` WRITE;
/*!40000 ALTER TABLE `tb_position` DISABLE KEYS */;
INSERT INTO `tb_position` VALUES (5,'T110','회장',1,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(6,'T111','사장',2,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(7,'T101','대표이사',3,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(8,'T121','원장',4,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(9,'T122','사업부장',5,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(10,'T123','국장',6,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(11,'T102','본부장',7,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(12,'T124','센터장',8,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(13,'T125','지서장',9,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(14,'T103','담당임원',10,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(15,'T126','그룹장',11,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(16,'T127','처장',12,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(17,'T128','지점장',13,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(18,'T129','실장',14,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(19,'T104','팀장',15,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(20,'T130','파트장',16,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(21,'T105','팀원',17,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(22,'T131','총무',18,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업'),(23,'T120','고문',19,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW 기준 초기셋업');
/*!40000 ALTER TABLE `tb_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rank`
--

DROP TABLE IF EXISTS `tb_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) DEFAULT NULL COMMENT ' 직급 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '직급명',
  `seq` int(11) DEFAULT NULL COMMENT '순서',
  `sync_use` int(11) DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int(11) DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text DEFAULT NULL COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COMMENT='직급 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rank`
--

LOCK TABLES `tb_rank` WRITE;
/*!40000 ALTER TABLE `tb_rank` DISABLE KEYS */;
INSERT INTO `tb_rank` VALUES (1,'P101','회장',1,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(2,'P124','임원',2,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(3,'P102','사장',3,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(4,'P103','부사장',4,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(5,'P121','전무',5,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(6,'P104','상무',6,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(7,'P122','연구소장',7,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(8,'P120','연구위원',8,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(9,'P105','이사',9,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(10,'P125','사외이사',10,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(11,'P123','고문',11,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(12,'P126','감사',12,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(13,'P127','수석연구원',13,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(14,'P113','책임매니저',14,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(15,'P106','부장',15,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(16,'P107','차장',16,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(17,'P128','책임연구원',17,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(18,'P108','과장',18,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(19,'P129','선임연구원',19,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(20,'P130','계장',20,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(21,'P109','대리',21,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(22,'P131','계장',22,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(23,'P132','주임연구원',23,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(24,'P110','주임',24,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(25,'P133','연구원',25,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(26,'P114','매니저',26,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(27,'P111','사원',27,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업'),(28,'P112','인턴/수습',28,1,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준 초기셋업');
/*!40000 ALTER TABLE `tb_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_staff`
--

DROP TABLE IF EXISTS `tb_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) DEFAULT NULL COMMENT ' login ID',
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
  `head` int(11) DEFAULT NULL COMMENT '부서장 유무 (0/1 , FALSE/TRUE)',
  `utype` varchar(50) NOT NULL DEFAULT 'USER' COMMENT '사용자 유형(Admin,User,OP) default : User',
  `auth` varchar(50) DEFAULT NULL COMMENT '사용자 권한 (S,R,L,C)',
  `concurrent_position` varchar(50) DEFAULT NULL COMMENT '겸직',
  `user_id` varchar(50) DEFAULT NULL COMMENT '겸직 사용자 아이디',
  `e_mail` varchar(50) DEFAULT NULL COMMENT 'E-mail',
  `hp` varchar(50) DEFAULT NULL COMMENT '연락처',
  `seq` int(11) DEFAULT NULL COMMENT '순서',
  `sync_use` int(11) DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `sync_system` varchar(500) DEFAULT NULL COMMENT '동기화시스템 (,)',
  `finger_print` varchar(500) DEFAULT NULL COMMENT '지문정보',
  `card_no` varchar(500) DEFAULT NULL COMMENT '카드정보',
  `del` int(11) DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `memo` text DEFAULT NULL COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8mb4 COMMENT='사용자 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_staff`
--

LOCK TABLES `tb_staff` WRITE;
/*!40000 ALTER TABLE `tb_staff` DISABLE KEYS */;
INSERT INTO `tb_staff` VALUES (1,'sunghoonelim','회장','성훈','홍','홍성훈','S10001','60d183156911271ee90c069ec3367babd534741a3e918fbc122423c792692bc0','남','P101','T110','SNS0001',1,'user','','','','sunghoonelim@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(2,'thnoh','사장','태호','노','노태호','S10002','912f0bd8fa8adf5c8b83f254d119f6c0d15bdc20363188ec4b5ca99ad773e629','남','P102','T111','SNS0002',1,'user','','','','thnoh@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(3,'uikjhh','관리팀','재현','고','고재현','S10006','7ca79e2f097f9af15f83a2bcd33373522e29302803405182e0093a1356389684','남','P113','T104','SNS1101',1,'user','','','','uikjhh@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(4,'ta2rj','관리팀','상혁','이','이상혁','S10007','a8a775aada0dccec370a3e10e1b00911f5b057b92dddd27c010b9282f375da57','남','P113','T105','SNS1101',0,'user','','','','ta2rj@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(5,'jildong333','관리팀','상미','이','이상미','S10008','c60c57cb6d6fd5394a9ec7fd94b9356faeb94c88709510bdbbc3eb6535cbc69c','여','P113','T105','SNS1101',0,'user','','','','jildong333@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(6,'oyh','재경팀','영학','오','오영학','S10049','c3943e2b64a78e59eb3568f6ddff8be68b45affa2240d2e7b7516ec5a9725874','남','P113','T104','SNS1102',1,'user','','','','oyh@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(7,'sejin1510','재경팀','세진','박','박세진','S10005','4c4658cdbe61571925bebd166e58c73cc6690ad315a5f755c89320b8ee48057e','남','P113','T105','SNS1102',0,'user','','','','sejin1510@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(8,'skcjfja111','재경팀','유진','최','최유진','S20003','9d58d9a40a895cad17af0e73fffee7f6846669f3b5a0f1fb1dd34c5476810452','여','P114','T105','SNS1102',0,'user','','','','skcjfja111@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(9,'kimhs411','사업담당','현승','김','김현승','S10010',NULL,'남','P121','T103','SNS1200',0,'user','','','','kimhs411@sns-at.co.kr','',1,0,'','','',1,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(10,'S10099','사업담당','재광','이','이재광','S10099','bcfce4dcbe0d00fed3e9d133a25b8fe7ed25d51cd7862cee44bac480b6f9d340','남','P105','T103','SNS1200',1,'user','','','','S10099@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(11,'jimipark88','사업팀','종민','박','박종민','S20004','3267abc8da36a52ba82475eeaf901c92154bfd534ab57b91b5249003cad22c1b','남','P113','T104','SNS1201',1,'user','','','','jimipark88@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(12,'kwon1667','사업팀','순열','권','권순열','S20006','abe6723a9ddf0218d64ed3bfbc53e5c7878bab896dea3f947fa7c67ce039e9b6','남','P113','T105','SNS1201',0,'user','','','','kwon1667@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(13,'kim1224jt','자재팀','진태','김','김진태','S10011','7d0bc22956b3a60343e5f09dd7d5f222fcf30467d0c535a48ddfb4aaff21d381','남','P113','T104','SNS1420',1,'user','','','','kim1224jt@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(14,'kolee1219','자재팀','래형','고','고래형','S10012','97d86e1aeb988b56cf3d271c70a501f99f4a864f6c4eff8b9f1606ba99f07097','남','P113','T105','SNS1420',0,'user','','','','kolee1219@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(15,'toasmap','자재팀','순희','박','박순희','S10013','3634396613eb5bbabbb0766973f5003e03b3e3f77d22438f9fc6feebf54877e3','여','P113','T105','SNS1420',0,'user','','','','toasmap@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(16,'S10095','자재팀','상수','이','이상수','S10095','fce26b14b7b31cd79c9e9b30e945fee50333aa649c56871a9c91c394ab188d27','남','P113','T105','SNS1420',0,'user','','','','S10095@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(17,'a01027836865','자재팀','혜연','문','문혜연','S11038','03fa32013681797e166f0e9b670a10d25bdfd3eae64560e6777b051e0bbd0e4e','여','P114','T105','SNS1420',0,'user','','','','a01027836865@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(18,'ysdudrl','자재팀','영기','김','김영기','S11152','1da3c047f7e10dd64b4d6b9f1ac9058d1d782f45d7ffcf0bb61a7bba3e4c5366','남','P114','T105','SNS1420',0,'user','','','','ysdudrl@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(19,'snsdso','디지털전략담당','창주','이','이창주','S20005','f9a75ff281a752e9802ba5837357ca2bc66cf70545defdd8853eb7b83fd5c6a8','남','P105','T103','SNS1300',1,'admin','','','','snsdso@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(20,'S10061','디지털전략팀','성훈','윤','윤성훈','S10061','4f33eae20df14f2b08b1db12a36ae3087b76fab907c6fb11782b0ecee4bdd0c5','남','P113','T104','SNS1301',1,'Admin','','','','S10061@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(21,'sns','디지털전략팀','sns','sns','sns','2021072901',NULL,'남','P113','T105','SNS1301',0,'user','','','','sns@sns-at.co.kr','',2,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(22,'s10078','디지털전략팀','진태','김','김진태','s10078','acc503e4eec545021cb51e879ca98c0c4469d41d595f561fd1b6e5bb2a56716f','남','P113','T105','SNS1301',0,'admin','','','','s10078@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(23,'superadmin','디지털전략팀','관리자','슈퍼','슈퍼관리자','1',NULL,'남','P109','T105','SNS1301',0,'user','','','','superadmin@sns-at.co.kr','',4,0,'','','',1,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(24,'mes','디지털전략팀','test','mes','mes test','mes',NULL,'남','P114','T105','SNS1301',0,'user','','','','mes@sns-at.co.kr','',5,0,'','','',1,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(25,'S10098','디지털전략팀','두렬','김','김두렬','S10098','9a0aa2b643a079c3eb07394fe49d362062f87d21bc67a65e05ec34b8333d2fed','남','P114','T105','SNS1301',0,'admin','','','','S10098@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(26,'admin','디지털전략팀','admin','admin','admin','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','남','P114','T105','SNS1301',0,'admin','','','','admin@sns-at.co.kr','',7,1,'','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(27,'ktj6002','생산본부','택진','강','강택진','S10004','adff66971d231e586425ed56b5de4ad52acaad9838d06b7a732cea996966a9c0','남','P104','T102','SNS1400',1,'user','','','','ktj6002@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(28,'ojgyun','생산관리팀','정균','오','오정균','S10017','388b6bacfe051bf53aa61821e197ae8eef1bafc2e699e306898ff00c630186f4','남','P105','T104','SNS1430',1,'user','','','','ojgyun@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(29,'dhpark17','생산관리팀','대형','박','박대형','S20049',NULL,'남','P113','T104','SNS1430',0,'user','','','','dhpark17@sns-at.co.kr','',2,0,'','','',1,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(30,'eumchs','생산관리팀','철승','엄','엄철승','S10015','1fc072f956a02a8053e79d14e4f4767002be5df05b3620348633519739b4d801','남','P113','T105','SNS1430',0,'user','','','','eumchs@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(31,'S10081','생산관리팀','성호','문','문성호','S10081','9c7b0aca83bc1e917c6bc1007f8abfa211049db22fc8f3aa9fa2571a49ea993f','남','P113','T105','SNS1430',0,'user','','','','S10081@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(32,'beverly.soon','생산관리팀','성호','조','조성호','S20007','8977a213c5d4a7f762fe12d70a035396f6b529fb26ead914e9762dc0f5d01fa1','남','P113','T105','SNS1430',0,'user','','','','beverly.soon@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(33,'s10068','생산관리팀','덕영','김','김덕영','S10068','b592519f7d9a7d6ee39c8a1a3be60f7891ac9b62b44fceb367b611b0a6a1945b','남','P114','T105','SNS1430',0,'user','','','','s10068@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(34,'s10074','SMT팀','경훈','정','정경훈','S10074','1b30d37a4842cb8d8edb7b706cca6f84c6f7d2f8ddb8a23e96dd2c390049cb8f','남','P105','T104','SNS1441',1,'user','','','','kyeonghun.jeong@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(35,'kunhak1','SMT팀','건학','이','이건학','S10018','834e4a6ba4c4e729cad26cebc0e38e5b194e4246e8694f387dccf0b9ba971aa1','남','P113','T105','SNS1441',0,'user','','','','kunhak1@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(36,'aznuri1980','SMT팀','세환','김','김세환','S10019','cc5679db4d22fc96455617aad85e266f0955b761fe04ba947beeef864ea28f89','남','P113','T105','SNS1441',0,'user','','','','aznuri1980@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(37,'S10073','SMT팀','정우','박','박정우','S10073','656b16d8662d7bc653d974e0bc70159ce40f4e417d3f5679d68d3d12f50604b8','남','P113','T105','SNS1441',0,'user','','','','S10073@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(38,'dnjsrldus1','SMT팀','기연','원','원기연','S20009','ac6c2ee20dc967e085aae273aac720cfa6b34a3f114d3777c218a5a9ee419d7b','남','P113','T105','SNS1441',0,'user','','','','dnjsrldus1@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(39,'etnow','SMT팀','천선','유','유천선','S10041',NULL,'남','P110','T105','SNS1441',0,'user','','','','etnow@sns-at.co.kr','',6,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(40,'s10051','SMT팀','경수','임','임경수','s10051',NULL,'남','P111','T105','SNS1441',0,'user','','','','s10051@sns-at.co.kr','',7,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(41,'jjecom','생산지원팀','태용','정','정태용','S10021','2d43b2fbf7cf4d4c868d301cecae79b23a12d52c225e59d02755e0a2293714b7','남','P113','T104','SNS1442',1,'user','','','','jjecom@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(42,'S10062','조립1팀','경남','조','조경남','S10062','d35243e415d34855ed21314f12d6e292966431aa9693a06b18f9eb9592319073','남','P113','T104','SNS1450',1,'user','','','','S10062@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(43,'haigang_zheng','조립1팀','해강','정','정해강','S11043','32b70590fca9d2c319a47b8ec7daa188a266f64e9910a4ac29c2dd0572b1eae0','남','P109','T105','SNS1450',0,'user','','','','haigang_zheng@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(44,'S11045','조립1팀','송림','김','김송림','S11045','c0856123ff170868528af6c67de305c343fed44d55483c80521c0c9859b0ad78','여','P109','T105','SNS1450',0,'user','','','','S11045@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(45,'s10094','조립1팀','건모','구','구건모','s10094','5ac19c3223873f013fe0d0a1a794d406d7563a98536e4a2d01058f228eedb5a6','남','P114','T105','SNS1450',0,'user','','','','s10094@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(46,'ojhldp','조립1팀','정현','오','오정현','S11041','90c40bc172b24e8f6bcfb39925c437696febfcbc32fcf8ab6e08908d7e0fd18f','남','P111','T105','SNS1450',0,'user','','','','ojhldp@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(47,'ksmun_99','조립1팀','금실','문','문금실','S20032','fabe95f965d97274fbb46c4bc5c7030f0f9b54f50cf5574b040d0c854a391b26','여','P111','T105','SNS1450',0,'user','','','','ksmun_99@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(48,'cheolhwan','조립2팀','철환','이','이철환','S20011','5fdebd68d75134084e68e8154526aa356397623296744ba9bd6c038ef0a88b96','남','P113','T104','SNS1460',1,'user','','','','cheolhwan@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(49,'koste3','조립2팀','재휘','김','김재휘','S20012','03de64d55d3a0b853cefcbbfdd447eeba4e3cc7f4a2136aa9fd87baf02fbc945','남','P113','T105','SNS1460',0,'user','','','','koste3@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(50,'cjh1167','조립2팀','종화','최','최종화','S20048','b2c0305eea9430b05da62794039c1a4085c5f799137e200beb336edbebdf537b','남','P113','T105','SNS1460',0,'user','','','','cjh1167@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(51,'S20034','조립2팀','희진','장','장희진','S20034','2e455a44899b5378ade64ad5be0809c846c5c10e9ecda4b50cb4971144389b93','여','P110','T105','SNS1460',0,'user','','','','S20034@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(52,'S21001','조립2팀','정연','한','한정연','S21001','2a9e5ebc855e0e92454a0da7391f3ca4c0a548826bf66230383f00ba3b295920','남','P110','T105','SNS1460',0,'user','','','','S21001@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(53,'S10028','조립2팀','경현','김','김경현','S10028','ffbdb57a4f41744bd3ffee4a30ce16a8b372f3ea85055cbe52e5dc97935354aa','남','P114','T105','SNS1460',0,'user','','','','S10028@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(54,'hoon3003','조립2팀','지훈','김','김지훈','S20060','e16426b3b29a51759d9ff968e5a51c97bed7cc214471e9747c18ec9798568544','남','P111','T105','SNS1460',0,'user','','','','hoon3003@sns-at.co.kr','',7,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(55,'s10085','물류팀','승철','양','양승철','s10085','29a5e0cb190c97f703fb48441a722430fda6153b50a5e528844f75d47d6dd3ce','남','P113','T104','SNS1470',1,'user','','','','s10085@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(56,'yongman5210','물류파트','용만','장','장용만','S11035',NULL,'남','P110','T105','SNS1431',0,'op','','','','yongman5210@sns-at.co.kr','',1,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(57,'S11034','물류파트','경식','박','박경식','S11034',NULL,'남','P111','T105','SNS1431',0,'op','','','','S11034@sns-at.co.kr','',2,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(58,'S11036','물류파트','성산','조','조성산','S11036',NULL,'남','P111','T105','SNS1431',0,'op','','','','S11036@sns-at.co.kr','',3,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(59,'S11037','물류파트','기태','김','김기태','S11037',NULL,'남','P111','T105','SNS1431',0,'op','','','','S11037@sns-at.co.kr','',4,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(60,'ryu871210','물류파트','호림','류','류호림','S11048',NULL,'남','P111','T105','SNS1431',0,'op','','','','ryu871210@sns-at.co.kr','',5,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(61,'S12017','물류파트','경하','박','박경하','S12017',NULL,'남','P111','T105','SNS1431',0,'op','','','','S12017@sns-at.co.kr','',6,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(62,'dylee','종합기술연구소','덕영','이','이덕영','S20040','108186427845104f4c0d6cda0977b84e3810066b516b46a8cb625df503567546','남','P120','T103','SNS1500',1,'user','','1','dylee','dylee@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(63,'dylee','연구담당','덕영','이','이덕영','S20040','108186427845104f4c0d6cda0977b84e3810066b516b46a8cb625df503567546','남','P120','T103','SNS1550',1,'user','','','','dylee@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(64,'dylee','연구팀','덕영','이','이덕영','S20040','108186427845104f4c0d6cda0977b84e3810066b516b46a8cb625df503567546','남','P105','T104','SNS1552',1,'user','','1','dylee','dylee@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(65,'s10066','연구팀','정현','김','김정현','S10066','bb8bd16078fa88ac7ffd8ad726495673abf81c9617194aa229b545c32582d85d','남','P113','T105','SNS1552',0,'user','','','','s10066@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(66,'s10084','연구팀','상호','김','김상호','s10084','2c3ae592d9120ef59d7d549d3cc852005b4be9aa9239cf5c6b07fdaf52727d54','남','P113','T105','SNS1552',0,'user','','','','s10084@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(67,'s10086','연구팀','상범','서','서상범','s10086','972fd9355c53d5f62141153bf9bd7ffa6b3385d30e5a6d9313a9d8c8dae6737f','남','P113','T105','SNS1552',0,'user','','','','s10086@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(68,'s10087','연구팀','태준','편','편태준','s10087','f7e2da151e276ce6f225f2a98a94706fa23acdf335a48fbbee20c9916312a38c','남','P113','T105','SNS1552',0,'user','','','','s10087@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(69,'hjk9535','연구팀','준기','홍','홍준기','S10056','4d4bf2aafe95a0b9195696e6d4bd3b4894e5aeb852ac08d84088888a98d2444c','남','P111','T105','SNS1552',0,'user','','','','hjk9535@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(70,'ffooo','연구개발담당','현수','김','김현수','S20017','db61b07192270c7355bf7696b3734d5ca42a20706176c39391adae4f1a9b3159','남','P105','T103','SNS1530',1,'user','','','','ffooo@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(71,'scombr6','개발팀','영배','육','육영배','S10034','e28b4c02c739ed967e9e374d8a48b7bfbc526f6701370098aa7d0e369774c1de','남','P105','T104','SNS1510',1,'user','','','','scombr6@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(72,'igchoi2002','개발팀','인규','최','최인규','S11001','76ea230d624567cd99e32c69fba5b30c90a7edba789374c43aa3cf1dcd9aa01c','남','P113','T105','SNS1510',0,'user','','','','igchoi2002@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(73,'sb41213','개발팀','재성','장','장재성','S10058','c6a05cb0eeb4e6e5be3006d575e9e0771feb5c7999a4c728a18229ed1f72ca6f','남','P114','T105','SNS1510',0,'user','','','','sb41213@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(74,'s10070','개발팀','미경','연','연미경','s10070','b1b02a4add953cfac3a1142b70635671b8190dba6e2221eda6a840418d319501','여','P114','T105','SNS1510',0,'user','','','','s10070@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(75,'kanghyeon3932','개발팀','강현','이','이강현','S20023','34f41a9e35b14d026d25a99696bf6bdb44566fbf02ce507772446ae9e5148d0b','남','P114','T105','SNS1510',0,'user','','','','kanghyeon3932@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(76,'keiths9972','SMT기술팀','성인','강','강성인','S10023','afe3e9ef3cee230da53b44cff3706f4e2e6c128a603d640034ff36ed050a2664','남','P113','T104','SNS1520',0,'user','','','','keiths9972@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(77,'s10092','SMT기술팀','진호','문','문진호','s10092','aad5e3426481cb3f4a7bfbd9766f2c9b140c52a0dc63ad0d502441b76d8c0bca','남','P113','T105','SNS1520',0,'user','','','','s10092@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(78,'vx5000baram','SMT기술팀','영현','안','안영현','S10024','deb439d884fe8862891d6e0ac36447cfd53c3d753ba62851565822ec4919a46f','남','P113','T105','SNS1520',0,'user','','','','vx5000baram@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(79,'sbch0706','SMT기술팀','병찬','송','송병찬','S10059','bae5dc8612c28f436f4ce5ad1fc837b9ee2691526baea4d2513a69e58316fd33','남','P114','T105','SNS1520',0,'user','','','','sbch0706@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(80,'hg0627','SMT기술팀','균','허','허균','S14001','90f17a97cb1e0a49599c9246d220c97f1d5ccbe2a43975df8816b0c4940d36d5','남','P114','T105','SNS1520',0,'user','','','','hg0627@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(81,'jungseok.min','생산기술담당','정석','민','민정석','S20014','a788003455f083e2de9b46bf13899150df472f120d70ad4acc5a589ec2a12805','남','P105','T103','SNS1540',1,'user','','','','jungseok.min@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(82,'jungseok.min','선행기술팀','정석','민','민정석','S20014','a788003455f083e2de9b46bf13899150df472f120d70ad4acc5a589ec2a12805','남','P105','T104','SNS1531',1,'user','','1','jungseok.min','jungseok.min@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(83,'dongyeom.kim','선행기술팀','돈겸','김','김돈겸','S10026','3a21ce1d355abdd90968d3df21ada1494f40a4a2f654a8c51a2f67b710bbcf26','남','P113','T105','SNS1531',0,'user','','','','dongyeom.kim@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(84,'snakeeys','선행기술팀','정호','김','김정호','S10030','59f69c3fba123dfbee86d8e689454ae0d56b5b4e62d0f490e25624c21488f013','남','P113','T105','SNS1531',0,'user','','','','snakeeys@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(85,'ysgeum','선행기술팀','윤섭','금','금윤섭','S10060','27749ae5b7b43455047307bf2b7f31f09a9c9baddbaf6271456ad22bae07a19f','남','P113','T105','SNS1531',0,'user','','','','ysgeum@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(86,'sdwa353','선행기술팀','동준','김','김동준','S10064','aa2331346b01ac27517f97a309ea6f583c2fe148a8e791b93af15e0d7ba5a3c7','남','P114','T105','SNS1531',0,'user','','','','sdwa353@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(87,'mannerku','공정기술팀','병구','구','구병구','S10029','14f699bdfcd4c1b8121ed84ff5122b118ac3c7bfc182eca2bee13cd1483992ed','남','P113','T104','SNS1541',1,'user','','','','mannerku@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(88,'jeunseop','공정기술팀','은섭','전','전은섭','S10031','a22af217249f0ba55153efa9911944929b27df8482d2b610159f67f21e68083f','남','P113','T105','SNS1541',0,'user','','','','jeunseop@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(89,'97hanhyj','공정기술팀','홍열','한','한홍열','S20015','1164cd42a8f494cbdf06c6bc58c059f1fa5edf787d487adf4ee53135ee7adb81','남','P113','T105','SNS1541',0,'user','','','','97hanhyj@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(90,'khjeong0523','공정기술팀','현정','김','김현정','S10033','d4d3af48f607ee53c1ef89a3c140508f96b0f8ec4194569e6e4bf5e2c8c9d70c','여','P114','T105','SNS1541',0,'user','','','','khjeong0523@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(91,'lee78958','공정기술팀','원정','이','이원정','S11002','dd03b636905e616bcbf9d1e665c293c4f22099055ee2a776e8afcca6a9e193af','남','P114','T105','SNS1541',0,'user','','','','lee78958@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(92,'soonboam','공정기술팀','순범','권','권순범','S20050','f359613be05c31658962d7ed311763a8641a492a959c532ee20f2bae9161eb8a','남','P114','T105','SNS1541',0,'user','','','','soonboam@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(93,'s10072','공정기술팀','현정','류','류현정','s10072','1f862287c9633e6a0e96e95f0d626e767f2618c3341ea4c50ff5f372b3316d47','여','P111','T105','SNS1541',0,'user','','','','s10072@sns-at.co.kr','',7,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(94,'hyongcho','품질관리담당','형','조','조형','S10054','a3c63dc738e6c177a4bcf0a9f21b0525591d822a0876234e8789e79adc4c0dd1','남','P105','T103','SNS1600',1,'user','','','','hyongcho@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(95,'weaponding','품질관리 1팀','동인','길','길동인','S10035','660357f4acb7bcc643b4a479b8c63a868308cf66a85905559685befceb3db92a','남','P113','T104','SNS1601',1,'user','','','','weaponding@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(96,'seungmin7679','품질관리 1팀','승민','임','임승민','S10037','bb8183eb7c89bfe84cad67fe65df3f69f13b708c6411429f1224a09f990f3163','남','P113','T105','SNS1601',0,'user','','','','seungmin7679@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(97,'ysdudwn','품질관리 1팀','영주','김','김영주','S11153','ca76847f14cbdea411477f3eef72f1350f7f6eccc13f9d2cc324c2235dce6b9d','남','P114','T105','SNS1601',0,'user','','','','ysdudwn@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(98,'limhn93','품질관리 1팀','하나','임','임하나','S20051','2c82059bf115b1f1ffe77b9390d12f2877d4e911f00862ab883991aea017ead3','여','P114','T105','SNS1601',0,'user','','','','limhn93@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(99,'S16030','품질관리 1팀','미성','김','김미성','S16030','c6afc012c837b04c1db783d21bfc9fade505daffa35c842145fe578713c0bd59','남','P111','T105','SNS1601',0,'user','','','','S16030@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(100,'s10082','품질관리 2팀','종민','강','강종민','s10082','0fb1fc053b9c495d06c298594086247178cf060e44cb03d3f10861639c35783e','남','P113','T105','SNS1602',0,'user','','','','s10082@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(101,'choi11','품질관리 2팀','병근','최','최병근','S20045','7c5af718a7fd46238434bb00f3f0ad565d83ba07e87d58e5272d8cad7b258e21','남','P113','T105','SNS1602',0,'user','','','','choi11@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(102,'s16009','품질관리 2팀','현주','황','황현주','S16009','8522c5900d662b490aa17f4192347cebb07b7ff7c844c4736e4a47ab812c2f83','여','P110','T105','SNS1602',0,'user','','','','s16009@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(103,'emt25','품질관리 2팀','희철','김','김희철','S10038','3865585c0f23c5785d42406af0fecaa8b423b7e1918295779e51a1d660ed47d2','남','P114','T105','SNS1602',0,'user','','','','emt25@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(104,'S10097','품질관리 3팀','강수','심','심강수','S10097','7ed5302fd66d14c527e6c411563ed24cccc900dadaa255c28c0b1198e3f4dce9','남','P105','T104','SNS1603',1,'user','','','','S10097@sns-at.co.kr','',5,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(105,'drk5078','품질관리 3팀','동린','김','김동린','S10071','ce38aae76321fa93f8b9f896a840241be6934f6b0bf49108d7f82c4714cae2ee','남','P113','T105','SNS1603',0,'user','','','','drk5078@sns-at.co.kr','',6,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(106,'S10096','품질관리 3팀','대홍','김','김대홍','S10096','2b82be8ae94909972d4d85ac54c54d765cd768a3a59e4659af6da1d394647161','남','P113','T105','SNS1603',0,'user','','','','S10096@sns-at.co.kr','',7,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(107,'leehh','품질관리 3팀','현희','이','이현희','S20054','f930d7866c77d1f8c8715d938e01c8fdde2ed50ea203c96137d8717c26de158b','여','P113','T105','SNS1603',0,'user','','','','leehh@sns-at.co.kr','',8,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(108,'wsxc2080','품질관리 3팀','선미','최','최선미','S12047',NULL,'여','P110','T105','SNS1603',0,'user','','','','wsxc2080@sns-at.co.kr','',9,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(109,'yhk5009','품질관리 3팀','해경','이','이해경','S11003','0605f2b25aa0bc361d4b55c0e541f42af0a6ff96c519253a2c03c6d31e8810ed','여','P114','T105','SNS1603',0,'user','','','','yhk5009@sns-at.co.kr','',10,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(110,'dia0212','품질관리 3팀','은영','천','천은영','S11170','13172cf5f1eae1b3dcbda1b24d2e4f66e895b062ef4db9c2db651036e5c17b77','여','P114','T105','SNS1603',0,'user','','','','dia0212@sns-at.co.kr','',11,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(111,'dlarkdh','품질관리 3팀','동근','유','유동근','S20038','cdfa637c7f8e22b156de7399cdf0e6735cc41434125bd3687bc4c8dab36b4b80','남','P114','T105','SNS1603',0,'user','','','','dlarkdh@sns-at.co.kr','',12,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(112,'ycs11','고전력CU','창수','유','유창수','S10003','609d84bcbd29dcff15a2a492fbcc5c001ce5dcbaa083070fb36398a7a2f0748f','남','P121','T102','SNS2100',1,'user','','','','ycs11@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(113,'scombr6','개발','영배','육','육영배','S10034','e28b4c02c739ed967e9e374d8a48b7bfbc526f6701370098aa7d0e369774c1de','남','P113','T105','SNS2110',0,'user','','1','scombr6','scombr6@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(114,'igchoi2002','개발','인규','최','최인규','S11001','76ea230d624567cd99e32c69fba5b30c90a7edba789374c43aa3cf1dcd9aa01c','남','P113','T105','SNS2110',0,'user','','1','igchoi2002','igchoi2002@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(115,'s10070','개발','미경','연','연미경','s10070','b1b02a4add953cfac3a1142b70635671b8190dba6e2221eda6a840418d319501','여','P114','T105','SNS2110',0,'user','','1','s10070','s10070@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(116,'kanghyeon3932','개발','강현','이','이강현','S20023','34f41a9e35b14d026d25a99696bf6bdb44566fbf02ce507772446ae9e5148d0b','남','P114','T105','SNS2110',0,'user','','1','kanghyeon3932','kanghyeon3932@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(117,'dongyeom.kim','기술','돈겸','김','김돈겸','S10026','3a21ce1d355abdd90968d3df21ada1494f40a4a2f654a8c51a2f67b710bbcf26','남','P113','T105','SNS2120',0,'user','','1','dongyeom.kim','dongyeom.kim@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(118,'xodms001','기술','기성','이','이기성','S10027','b17be8589f74e8e228fbc464a1a9eedc72099f06d13ac9b48c65f56a8a249aed','남','P113','T105','SNS2120',0,'user','','','','xodms001@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(119,'sb41213','기술','재성','장','장재성','S10058','c6a05cb0eeb4e6e5be3006d575e9e0771feb5c7999a4c728a18229ed1f72ca6f','남','P114','T105','SNS2120',0,'user','','1','sb41213','sb41213@sns-at.co.kr','',3,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(120,'lee78958','기술','원정','이','이원정','S11002','dd03b636905e616bcbf9d1e665c293c4f22099055ee2a776e8afcca6a9e193af','남','P114','T105','SNS2120',0,'user','','1','lee78958','lee78958@sns-at.co.kr','',4,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(121,'cjh1167','생산','종화','최','최종화','S20048','b2c0305eea9430b05da62794039c1a4085c5f799137e200beb336edbebdf537b','남','P113','T105','SNS2130',0,'user','','1','cjh1167','cjh1167@sns-at.co.kr','',1,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(122,'S21001','생산','정연','한','한정연','S21001','2a9e5ebc855e0e92454a0da7391f3ca4c0a548826bf66230383f00ba3b295920','남','P110','T105','SNS2130',0,'user','','1','S21001','S21001@sns-at.co.kr','',2,1,'SV001,SV002,SV003,SV004,SV005,SV006,SV007,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(123,'ju616','현장 관리팀','주현','이','이주현','S10009',NULL,'남','P114','T105','SNS9105',0,'op','','','','ju616@sns-at.co.kr','',1,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(124,'S11033','현장 관리팀','숙자','황','황숙자','S11033',NULL,'여','P111','T105','SNS9105',0,'op','','','','S11033@sns-at.co.kr','',2,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(125,'S11040','현장 자재팀','령','김','김령','S11040',NULL,'남','P111','T105','SNS9110',0,'op','','','','S11040@sns-at.co.kr','',1,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(126,'S12063','현장 자재팀','보현','심','심보현','S12063',NULL,'남','P111','T105','SNS9110',0,'op','','','','S12063@sns-at.co.kr','',2,0,'SV001,SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(127,'S13009','현장 SMT팀','금석','이','이금석','S13009',NULL,'남','P109','T105','SNS9130',0,'op','','','','S13009@sns-at.co.kr','',1,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(128,'hotjcy','현장 SMT팀','창용','정','정창용','S12026',NULL,'남','P109','T105','SNS9130',0,'op','','','','hotjcy@sns-at.co.kr','',2,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(129,'S20025','현장 SMT팀','영완','김','김영완','S20025',NULL,'남','P109','T105','SNS9130',0,'op','','','','S20025@sns-at.co.kr','',3,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(130,'S20029','현장 SMT팀','명숙','변','변명숙','S20029',NULL,'여','P109','T105','SNS9130',0,'op','','','','S20029@sns-at.co.kr','',4,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(131,'S11020','현장 SMT팀','성훈','임','임성훈','S11020',NULL,'남','P110','T105','SNS9130',0,'op','','','','S11020@sns-at.co.kr','',5,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(132,'S11025','현장 SMT팀','종선','정','정종선','S11025',NULL,'남','P110','T105','SNS9130',0,'op','','','','S11025@sns-at.co.kr','',6,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(133,'S13001','현장 SMT팀','훈','이','이훈','S13001',NULL,'남','P110','T105','SNS9130',0,'op','','','','S13001@sns-at.co.kr','',7,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(134,'S13003','현장 SMT팀','규찬','채','채규찬','S13003',NULL,'남','P110','T105','SNS9130',0,'op','','','','S13003@sns-at.co.kr','',8,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(135,'S14002','현장 SMT팀','범석','김','김범석','S14002',NULL,'남','P110','T105','SNS9130',0,'op','','','','S14002@sns-at.co.kr','',9,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(136,'S10055','현장 SMT팀','준범','박','박준범','S10055',NULL,'남','P111','T105','SNS9130',0,'op','','','','S10055@sns-at.co.kr','',10,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(137,'S11004','현장 SMT팀','춘봉','김','김춘봉','S11004',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11004@sns-at.co.kr','',11,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(138,'S11005','현장 SMT팀','성림','남','남성림','S11005',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11005@sns-at.co.kr','',12,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(139,'S11006','현장 SMT팀','향화','한','한향화','S11006',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11006@sns-at.co.kr','',13,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(140,'S11007','현장 SMT팀','호천','조','조호천','S11007',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11007@sns-at.co.kr','',14,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(141,'S11008','현장 SMT팀','철민','전','전철민','S11008',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11008@sns-at.co.kr','',15,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(142,'S11010','현장 SMT팀','용','김','김용','S11010',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11010@sns-at.co.kr','',16,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(143,'S11011','현장 SMT팀','윤화','김','김윤화','S11011',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11011@sns-at.co.kr','',17,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(144,'S11012','현장 SMT팀','혜진','안','안혜진','S11012',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11012@sns-at.co.kr','',18,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(145,'S11013','현장 SMT팀','명섭','송','송명섭','S11013',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11013@sns-at.co.kr','',19,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(146,'S11014','현장 SMT팀','문빈','장','장문빈','S11014',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11014@sns-at.co.kr','',20,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(147,'S11016','현장 SMT팀','국정','장','장국정','S11016',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11016@sns-at.co.kr','',21,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(148,'S11018','현장 SMT팀','준우','이','이준우','S11018',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11018@sns-at.co.kr','',22,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(149,'S11019','현장 SMT팀','대홍','김','김대홍','S11019',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11019@sns-at.co.kr','',23,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(150,'S11021','현장 SMT팀','재용','이','이재용','S11021',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11021@sns-at.co.kr','',24,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(151,'S11022','현장 SMT팀','승우','류','류승우','S11022',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11022@sns-at.co.kr','',25,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(152,'S11023','현장 SMT팀','미리','최','최미리','S11023',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11023@sns-at.co.kr','',26,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(153,'S11026','현장 SMT팀','용길','장','장용길','S11026',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11026@sns-at.co.kr','',27,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(154,'S11030','현장 SMT팀','진노','윤','윤진노','S11030',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11030@sns-at.co.kr','',28,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(155,'S11032','현장 SMT팀','칠욱','권','권칠욱','S11032',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11032@sns-at.co.kr','',29,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(156,'S11257','현장 SMT팀','은지','조','조은지','S11257',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11257@sns-at.co.kr','',30,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(157,'S13004','현장 SMT팀','봉남','오','오봉남','S13004',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13004@sns-at.co.kr','',31,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(158,'S13005','현장 SMT팀','민아','박','박민아','S13005',NULL,'여','P111','T105','SNS9130',0,'op','','','','S13005@sns-at.co.kr','',32,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(159,'S13006','현장 SMT팀','선홍','김','김선홍','S13006',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13006@sns-at.co.kr','',33,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(160,'S13007','현장 SMT팀','에담','레','레에담','S13007',NULL,'여','P111','T105','SNS9130',0,'op','','','','S13007@sns-at.co.kr','',34,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(161,'S13008','현장 SMT팀','평화','이','이평화','S13008',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13008@sns-at.co.kr','',35,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(162,'S13010','현장 SMT팀','순용','신','신순용','S13010',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13010@sns-at.co.kr','',36,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(163,'S13011','현장 SMT팀','금난','백','백금난','S13011',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13011@sns-at.co.kr','',37,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(164,'S13012','현장 SMT팀','승호','백','백승호','S13012',NULL,'남','P111','T105','SNS9130',0,'op','','','','S13012@sns-at.co.kr','',38,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(165,'S13049','현장 SMT팀','경실','백','백경실','S13049',NULL,'여','P111','T105','SNS9130',0,'op','','','','S13049@sns-at.co.kr','',39,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(166,'S15001','현장 SMT팀','용식','김','김용식','S15001',NULL,'남','P111','T105','SNS9130',0,'op','','','','S15001@sns-at.co.kr','',40,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(167,'S15002','현장 SMT팀','운봉','설','설운봉','S15002',NULL,'남','P111','T105','SNS9130',0,'op','','','','S15002@sns-at.co.kr','',41,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(168,'S20026','현장 SMT팀','수현','류','류수현','S20026',NULL,'남','P111','T105','SNS9130',0,'op','','','','S20026@sns-at.co.kr','',42,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(169,'S21003','현장 SMT팀','창민','김','김창민','S21003',NULL,'남','P111','T105','SNS9130',0,'op','','','','S21003@sns-at.co.kr','',43,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(170,'S20024','현장 SMT팀','찬우','이','이찬우','S20024',NULL,'남','P111','T105','SNS9130',0,'op','','','','S20024@sns-at.co.kr','',44,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(171,'S20027','현장 SMT팀','경자','김','김경자','S20027',NULL,'여','P111','T105','SNS9130',0,'op','','','','S20027@sns-at.co.kr','',45,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(172,'S20028','현장 SMT팀','한솔','이','이한솔','S20028',NULL,'남','P111','T105','SNS9130',0,'op','','','','S20028@sns-at.co.kr','',46,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(173,'S10039','현장 SMT팀','빛','주','주빛','S10039',NULL,'여','P111','T105','SNS9130',0,'op','','','','S10039@sns-at.co.kr','',47,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(174,'s10040','현장 SMT팀','민식','신','신민식','s10040',NULL,'남','P111','T105','SNS9130',0,'op','','','','s10040@sns-at.co.kr','',48,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(175,'S10043','현장 SMT팀','태수','한','한태수','S10043',NULL,'남','P111','T105','SNS9130',0,'op','','','','S10043@sns-at.co.kr','',49,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(176,'s11108','현장 SMT팀','명권','서','서명권','s11108',NULL,'남','P111','T105','SNS9130',0,'op','','','','s11108@sns-at.co.kr','',50,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(177,'S11122','현장 SMT팀','종군','조','조종군','S11122',NULL,'남','P111','T105','SNS9130',0,'op','','','','S11122@sns-at.co.kr','',51,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(178,'S12001','현장 SMT팀','미영','이','이미영','S12001',NULL,'여','P111','T105','SNS9130',0,'op','','','','S12001@sns-at.co.kr','',52,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(179,'S12003','현장 SMT팀','영희','채','채영희','S12003',NULL,'여','P111','T105','SNS9130',0,'op','','','','S12003@sns-at.co.kr','',53,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(180,'S12004','현장 SMT팀','광일','정','정광일','S12004',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12004@sns-at.co.kr','',54,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(181,'S12005','현장 SMT팀','용해','강','강용해','S12005',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12005@sns-at.co.kr','',55,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(182,'S12006','현장 SMT팀','영걸','천','천영걸','S12006',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12006@sns-at.co.kr','',56,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(183,'S12007','현장 SMT팀','홍건','곽','곽홍건','S12007',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12007@sns-at.co.kr','',57,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(184,'S12008','현장 SMT팀','승은','김','김승은','S12008',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12008@sns-at.co.kr','',58,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(185,'S12009','현장 SMT팀','상엽','김','김상엽','S12009',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12009@sns-at.co.kr','',59,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(186,'S12010','현장 SMT팀','정화','최','최정화','S12010',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12010@sns-at.co.kr','',60,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(187,'S12011','현장 SMT팀','동석','이','이동석','S12011',NULL,'남','P111','T105','SNS9130',0,'op','','','','S12011@sns-at.co.kr','',61,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(188,'s12054','현장 SMT팀','춘연','서','서춘연','s12054',NULL,'남','P111','T105','SNS9130',0,'op','','','','s12054@sns-at.co.kr','',62,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(189,'s12055','현장 SMT팀','경일','이','이경일','s12055',NULL,'남','P111','T105','SNS9130',0,'op','','','','s12055@sns-at.co.kr','',63,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(190,'S12060','현장 SMT팀','매화','이','이매화','S12060',NULL,'여','P111','T105','SNS9130',0,'op','','','','S12060@sns-at.co.kr','',64,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(191,'S11135','현장 SMT팀','나영','김','김나영','S11135',NULL,'여','P111','T105','SNS9130',0,'op','','','','S11135@sns-at.co.kr','',65,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(192,'S12066','현장 SMT팀','애림','유','유애림','S12066',NULL,'여','P111','T105','SNS9130',0,'op','','','','S12066@sns-at.co.kr','',66,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(193,'S11053','현장 조립1팀','화','안','안화','S11053',NULL,'여','P111','T105','SNS9150',0,'op','','','','S11053@sns-at.co.kr','',1,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(194,'S11055','현장 조립1팀','경천','조','조경천','S11055',NULL,'남','P111','T105','SNS9150',0,'op','','','','S11055@sns-at.co.kr','',2,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(195,'S11056','현장 조립1팀','미자','안','안미자','S11056',NULL,'여','P111','T105','SNS9150',0,'op','','','','S11056@sns-at.co.kr','',3,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(196,'S11058','현장 조립1팀','양이','정','정양이','S11058',NULL,'여','P111','T105','SNS9150',0,'op','','','','S11058@sns-at.co.kr','',4,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(197,'S11061','현장 조립1팀','혜지','최','최혜지','S11061',NULL,'여','P111','T105','SNS9150',0,'op','','','','S11061@sns-at.co.kr','',5,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(198,'S14005','현장 조립1팀','리셀','마','마리셀','S14005',NULL,'여','P111','T105','SNS9150',0,'op','','','','S14005@sns-at.co.kr','',6,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(199,'S14007','현장 조립1팀','유란','신','신유란','S14007',NULL,'여','P111','T105','SNS9150',0,'op','','','','S14007@sns-at.co.kr','',7,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(200,'S20033','현장 조립1팀','경미','정','정경미','S20033',NULL,'여','P111','T105','SNS9150',0,'op','','','','S20033@sns-at.co.kr','',8,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(201,'S12018','현장 조립1팀','영아','김','김영아','S12018',NULL,'여','P111','T105','SNS9150',0,'op','','','','S12018@sns-at.co.kr','',9,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(202,'S20037','현장 조립2팀','종남','이','이종남','S20037',NULL,'남','P110','T105','SNS9160',0,'op','','','','S20037@sns-at.co.kr','',1,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(203,'S11062','현장 조립2팀','녕매','권','권녕매','S11062',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11062@sns-at.co.kr','',2,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(204,'S11063','현장 조립2팀','영식','이','이영식','S11063',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11063@sns-at.co.kr','',3,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(205,'S11064','현장 조립2팀','문','김','김문','S11064',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11064@sns-at.co.kr','',4,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(206,'S11065','현장 조립2팀','미영','장','장미영B','S11065',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11065@sns-at.co.kr','',5,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(207,'S11066','현장 조립2팀','미미','정','정미미','S11066',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11066@sns-at.co.kr','',6,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(208,'S11067','현장 조립2팀','혜숙','현','현혜숙','S11067',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11067@sns-at.co.kr','',7,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(209,'S11068','현장 조립2팀','문광','박','박문광','S11068',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11068@sns-at.co.kr','',8,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(210,'S11069','현장 조립2팀','화','홍','홍화','S11069',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11069@sns-at.co.kr','',9,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(211,'S11072','현장 조립2팀','정군','최','최정군','S11072',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11072@sns-at.co.kr','',10,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(212,'S11073','현장 조립2팀','기명','임','임기명','S11073',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11073@sns-at.co.kr','',11,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(213,'S11074','현장 조립2팀','해숙','이','이해숙','S11074',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11074@sns-at.co.kr','',12,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(214,'S11075','현장 조립2팀','홍매','김','김홍매','S11075',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11075@sns-at.co.kr','',13,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(215,'S11087','현장 조립2팀','순영','송','송순영','S11087',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11087@sns-at.co.kr','',14,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(216,'S11088','현장 조립2팀','원춘','현','현원춘','S11088',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11088@sns-at.co.kr','',15,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(217,'S11090','현장 조립2팀','운승','백','백운승','S11090',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11090@sns-at.co.kr','',16,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(218,'S12029','현장 조립2팀','선옥','정','정선옥','S12029',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12029@sns-at.co.kr','',17,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(219,'S12031','현장 조립2팀','금선','황','황금선','S12031',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12031@sns-at.co.kr','',18,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(220,'S12033','현장 조립2팀','희연','김','김희연','S12033',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12033@sns-at.co.kr','',19,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(221,'S12034','현장 조립2팀','서연','김','김서연','S12034',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12034@sns-at.co.kr','',20,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(222,'S12035','현장 조립2팀','이엔','후','후이엔','S12035',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12035@sns-at.co.kr','',21,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(223,'S12036','현장 조립2팀','서연','남','남서연','S12036',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12036@sns-at.co.kr','',22,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(224,'S12037','현장 조립2팀','봉화','정','정봉화','S12037',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12037@sns-at.co.kr','',23,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(225,'S12038','현장 조립2팀','광빈','전','전광빈','S12038',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12038@sns-at.co.kr','',24,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(226,'S12039','현장 조립2팀','춘호','안','안춘호','S12039',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12039@sns-at.co.kr','',25,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(227,'S12040','현장 조립2팀','향','김','김향','S12040',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12040@sns-at.co.kr','',26,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(228,'S12041','현장 조립2팀','연','이','이연B','S12041',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12041@sns-at.co.kr','',27,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(229,'S12042','현장 조립2팀','호아','티','티호아B','S12042',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12042@sns-at.co.kr','',28,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(230,'S12043','현장 조립2팀','광봉','이','이광봉','S12043',NULL,'남','P111','T105','SNS9160',0,'op','','','','S12043@sns-at.co.kr','',29,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(231,'S13017','현장 조립2팀','미자','최','최미자B','S13017',NULL,'여','P111','T105','SNS9160',0,'op','','','','S13017@sns-at.co.kr','',30,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(232,'S13018','현장 조립2팀','광선','정','정광선','S13018',NULL,'남','P111','T105','SNS9160',0,'op','','','','S13018@sns-at.co.kr','',31,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(233,'S13019','현장 조립2팀','재환','김','김재환','S13019',NULL,'남','P111','T105','SNS9160',0,'op','','','','S13019@sns-at.co.kr','',32,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(234,'S13021','현장 조립2팀','효수','김','김효수','S13021',NULL,'남','P111','T105','SNS9160',0,'op','','','','S13021@sns-at.co.kr','',33,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(235,'S14011','현장 조립2팀','미영','장','장미영','S14011',NULL,'여','P111','T105','SNS9160',0,'op','','','','S14011@sns-at.co.kr','',34,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(236,'S20035','현장 조립2팀','미애','정','정미애','S20035',NULL,'여','P111','T105','SNS9160',0,'op','','','','S20035@sns-at.co.kr','',35,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(237,'S20036','현장 조립2팀','애진','권','권애진','S20036',NULL,'여','P111','T105','SNS9160',0,'op','','','','S20036@sns-at.co.kr','',36,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(238,'S26002','현장 조립2팀','옥순','김','김옥순','S26002',NULL,'여','P111','T105','SNS9160',0,'op','','','','S26002@sns-at.co.kr','',37,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(239,'s11099','현장 조립2팀','흥매','서','서흥매','s11099',NULL,'여','P111','T105','SNS9160',0,'op','','','','s11099@sns-at.co.kr','',38,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(240,'s11102','현장 조립2팀','은희','김','김은희','s11102',NULL,'여','P111','T105','SNS9160',0,'op','','','','s11102@sns-at.co.kr','',39,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(241,'s11103','현장 조립2팀','순자','채','채순자','s11103',NULL,'여','P111','T105','SNS9160',0,'op','','','','s11103@sns-at.co.kr','',40,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(242,'S11123','현장 조립2팀','성룡','최','최성룡','S11123',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11123@sns-at.co.kr','',41,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(243,'S11124','현장 조립2팀','화룡','최','최화룡','S11124',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11124@sns-at.co.kr','',42,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(244,'S11125','현장 조립2팀','춘매','정','정춘매','S11125',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11125@sns-at.co.kr','',43,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(245,'s12052','현장 조립2팀','성','이','이성','s12052',NULL,'남','P111','T105','SNS9160',0,'op','','','','s12052@sns-at.co.kr','',44,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(246,'S12061','현장 조립2팀','민주','노','노민주','S12061',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12061@sns-at.co.kr','',45,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(247,'S12062','현장 조립2팀','은정','이','이은정','S12062',NULL,'여','P111','T105','SNS9160',0,'op','','','','S12062@sns-at.co.kr','',46,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(248,'s13024','현장 조립2팀','혜련','방','방혜련','s13024',NULL,'여','P111','T105','SNS9160',0,'op','','','','s13024@sns-at.co.kr','',47,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(249,'S13025','현장 조립2팀','순복','정','정순복','S13025',NULL,'여','P111','T105','SNS9160',0,'op','','','','S13025@sns-at.co.kr','',48,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(250,'S11136','현장 조립2팀','국철','임','임국철','S11136',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11136@sns-at.co.kr','',49,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(251,'S11137','현장 조립2팀','화B','홍','홍화B','S11137',NULL,'여','P111','T105','SNS9160',0,'op','','','','S11137@sns-at.co.kr','',50,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(252,'S11140','현장 조립2팀','진우','권','권진우','S11140',NULL,'남','P111','T105','SNS9160',0,'op','','','','S11140@sns-at.co.kr','',51,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(253,'S11080','현장 품질관리팀','미영','권','권미영','S11080',NULL,'남','P111','T105','SNS9170',0,'op','','','','S11080@sns-at.co.kr','',1,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(254,'S11083','현장 품질관리팀','경아','이','이경아','S11083',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11083@sns-at.co.kr','',2,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(255,'S11084','현장 품질관리팀','경숙','김','김경숙','S11084',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11084@sns-at.co.kr','',3,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(256,'S11085','현장 품질관리팀','순향','김','김순향','S11085',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11085@sns-at.co.kr','',4,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(257,'S11086','현장 품질관리팀','경희','박','박경희','S11086',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11086@sns-at.co.kr','',5,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(258,'S11185','현장 품질관리팀','혜영','박','박혜영','S11185',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11185@sns-at.co.kr','',6,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(259,'S12083','현장 품질관리팀','수진','도','도수진','S12083',NULL,'여','P111','T105','SNS9170',0,'op','','','','S12083@sns-at.co.kr','',7,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(260,'S13022','현장 품질관리팀','영선','권','권영선','S13022',NULL,'여','P111','T105','SNS9170',0,'op','','','','S13022@sns-at.co.kr','',8,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(261,'S14012','현장 품질관리팀','경례','이','이경례','S14012',NULL,'여','P111','T105','SNS9170',0,'op','','','','S14012@sns-at.co.kr','',9,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(262,'S14013','현장 품질관리팀','경희','공','공경희','s14013',NULL,'여','P111','T105','SNS9170',0,'op','','','','S14013@sns-at.co.kr','',10,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(263,'S14015','현장 품질관리팀','미자','최','최미자','S14015',NULL,'여','P111','T105','SNS9170',0,'op','','','','S14015@sns-at.co.kr','',11,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(264,'S14016','현장 품질관리팀','현숙','이','이현숙','S14016',NULL,'여','P111','T105','SNS9170',0,'op','','','','S14016@sns-at.co.kr','',12,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(265,'s11109','현장 품질관리팀','성희','허','허성희','s11109',NULL,'여','P111','T105','SNS9170',0,'op','','','','s11109@sns-at.co.kr','',13,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(266,'s11111','현장 품질관리팀','보람','김','김보람','s11111',NULL,'여','P111','T105','SNS9170',0,'op','','','','s11111@sns-at.co.kr','',14,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(267,'S11126','현장 품질관리팀','창환','권','권창환','S11126',NULL,'남','P111','T105','SNS9170',0,'op','','','','S11126@sns-at.co.kr','',15,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(268,'S11143','현장 품질관리팀','지민','이','이지민','S11143',NULL,'여','P111','T105','SNS9170',0,'op','','','','S11143@sns-at.co.kr','',16,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업'),(269,'S12070','현장 품질관리팀','용B','김','김용B','S12070',NULL,'남','P111','T105','SNS9170',0,'op','','','','S12070@sns-at.co.kr','',17,0,'SV008','','',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00','GW기준초기셋업');
/*!40000 ALTER TABLE `tb_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sync_svr`
--

DROP TABLE IF EXISTS `tb_sync_svr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sync_svr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 인덱스',
  `uid` varchar(50) DEFAULT NULL COMMENT ' 서버 ID',
  `name` varchar(50) DEFAULT NULL COMMENT '서버명',
  `ip` varchar(50) DEFAULT NULL COMMENT '서버 IP',
  `seq` int(11) DEFAULT NULL COMMENT '순서',
  `sync_use` int(11) DEFAULT NULL COMMENT '동기화 유무 (0/1 , FALSE/TRUE)',
  `del` int(11) DEFAULT NULL COMMENT '삭제 유무(0/1 , FALSE/TRUE)',
  `created_date` timestamp NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modified_date` timestamp NULL DEFAULT NULL COMMENT '변경일',
  `delete_date` timestamp NULL DEFAULT NULL COMMENT '삭제일',
  `modi_id` varchar(50) DEFAULT NULL COMMENT '마지막 데이터 생성 , 수정 ,삭제자',
  `memo` text DEFAULT NULL COMMENT '메모',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='Sync 서버 관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sync_svr`
--

LOCK TABLES `tb_sync_svr` WRITE;
/*!40000 ALTER TABLE `tb_sync_svr` DISABLE KEYS */;
INSERT INTO `tb_sync_svr` VALUES (1,'SV001','NAC(Sensor)','192.168.30.2',1,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(2,'SV002','EPP','192.168.10.41',2,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(3,'SV003','MDS','192.168.10.40',3,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(4,'SV004','EDR','192.168.10.65',4,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(5,'SV005','MES(DB)','192.168.10.212',5,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(6,'SV006','ECM','192.168.10.237',6,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(7,'SV007','DLP','192.168.10.64',7,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업'),(8,'SV008','ESD','192.168.10.58',8,0,0,'2023-03-08 20:21:00','0000-00-00 00:00:00','0000-00-00 00:00:00','admin','GW기준초기셋업');
/*!40000 ALTER TABLE `tb_sync_svr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dash_board'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-17 17:57:18
