/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_online_ssm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-10-19 16:01:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `c3p0testtable`
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for `classinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(50) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `teacherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `teacherId` (`teacherId`),
  KEY `FK_Reference_1` (`gradeId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`),
  CONSTRAINT `classinfo_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `teacherinfo` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `courseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  `division` int(11) DEFAULT '0',
  `gradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `gradeId` (`gradeId`),
  CONSTRAINT `courseinfo_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `examchooseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `examchooseinfo`;
CREATE TABLE `examchooseinfo` (
  `chooseId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `chooseResult` varchar(500) NOT NULL,
  PRIMARY KEY (`chooseId`),
  KEY `FK_Reference_11` (`studentId`),
  KEY `FK_Reference_12` (`examPaperId`),
  KEY `FK_Reference_13` (`subjectId`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`studentId`) REFERENCES `studentinfo` (`studentId`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`subjectId`) REFERENCES `subjectinfo` (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examchooseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `examhistoryinfo`
-- ----------------------------
DROP TABLE IF EXISTS `examhistoryinfo`;
CREATE TABLE `examhistoryinfo` (
  `historyId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `examScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`historyId`),
  KEY `FK_Reference_10` (`studentId`),
  KEY `FK_Reference_9` (`examPaperId`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`studentId`) REFERENCES `studentinfo` (`studentId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examhistoryinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `exampaperinfo`
-- ----------------------------
DROP TABLE IF EXISTS `exampaperinfo`;
CREATE TABLE `exampaperinfo` (
  `examPaperId` int(11) NOT NULL AUTO_INCREMENT,
  `examPaperName` varchar(50) NOT NULL,
  `subjectNum` int(11) NOT NULL,
  `examPaperTime` int(11) NOT NULL,
  `examPaperScore` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `division` int(11) DEFAULT '0',
  `examPaperEasy` int(11) DEFAULT '1',
  PRIMARY KEY (`examPaperId`),
  KEY `FK_Reference_4` (`gradeId`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exampaperinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `examplaninfo`
-- ----------------------------
DROP TABLE IF EXISTS `examplaninfo`;
CREATE TABLE `examplaninfo` (
  `examPlanId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `examPaperId` int(11) NOT NULL,
  `beginTime` datetime NOT NULL,
  PRIMARY KEY (`examPlanId`),
  KEY `courseId` (`courseId`),
  KEY `classId` (`classId`),
  KEY `examPaperId` (`examPaperId`),
  CONSTRAINT `examplaninfo_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `courseinfo` (`courseId`),
  CONSTRAINT `examplaninfo_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `classinfo` (`classId`),
  CONSTRAINT `examplaninfo_ibfk_3` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examplaninfo
-- ----------------------------

-- ----------------------------
-- Table structure for `examsubjectmiddleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `examsubjectmiddleinfo`;
CREATE TABLE `examsubjectmiddleinfo` (
  `esmId` int(11) NOT NULL AUTO_INCREMENT,
  `examPaperId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  PRIMARY KEY (`esmId`),
  KEY `FK_Reference_7` (`examPaperId`),
  KEY `FK_Reference_8` (`subjectId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`examPaperId`) REFERENCES `exampaperinfo` (`examPaperId`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`subjectId`) REFERENCES `subjectinfo` (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examsubjectmiddleinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `gradeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `gradeinfo`;
CREATE TABLE `gradeinfo` (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(50) NOT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gradeinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `studentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(32) NOT NULL,
  `studentAccount` varchar(64) NOT NULL,
  `studentPwd` varchar(32) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`),
  KEY `FK_Reference_3` (`classId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`classId`) REFERENCES `classinfo` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `subjectinfo`
-- ----------------------------
DROP TABLE IF EXISTS `subjectinfo`;
CREATE TABLE `subjectinfo` (
  `subjectId` int(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(500) NOT NULL,
  `optionA` varchar(500) NOT NULL,
  `optionB` varchar(500) NOT NULL,
  `optionC` varchar(500) NOT NULL,
  `optionD` varchar(500) NOT NULL,
  `rightResult` varchar(500) NOT NULL,
  `subjectScore` int(11) NOT NULL,
  `subjectType` int(11) DEFAULT '0',
  `courseId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `subjectEasy` int(11) DEFAULT '1',
  `division` int(11) DEFAULT '0',
  PRIMARY KEY (`subjectId`),
  KEY `FK_Reference_5` (`courseId`),
  KEY `FK_Reference_6` (`gradeId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`courseId`) REFERENCES `courseinfo` (`courseId`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`gradeId`) REFERENCES `gradeinfo` (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6547 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjectinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `teacherinfo`
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(10) DEFAULT NULL,
  `teacherAccount` varchar(10) DEFAULT NULL,
  `teacherPwd` varchar(10) DEFAULT NULL,
  `adminPower` int(11) DEFAULT '0',
  `isWork` int(11) DEFAULT '0',
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('23', '猿来入此', 'admin', 'admin', '1', '0');
