/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : db_onlinetestsystem

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-08-01 21:29:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_paper
-- ----------------------------
DROP TABLE IF EXISTS `tb_paper`;
CREATE TABLE `tb_paper` (
  `paperId` int(11) NOT NULL AUTO_INCREMENT,
  `paperName` varchar(60) NOT NULL,
  `paperDescription` varchar(1024) DEFAULT NULL,
  `paperScore` tinyint(6) NOT NULL,
  `paperSubjectNumber` tinyint(4) NOT NULL,
  `paperAuthor` varchar(60) NOT NULL,
  `paperCreateDate` date DEFAULT NULL,
  `paperUpdateDate` date DEFAULT NULL,
  PRIMARY KEY (`paperId`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_paper
-- ----------------------------
INSERT INTO `tb_paper` VALUES ('89', '计算机卷1', '一套含有10道选择题的计算机卷', '100', '10', 'Mr.K', '2016-08-01', '2016-08-01');
INSERT INTO `tb_paper` VALUES ('90', '计算机卷2', '一套含有10道选择题的计算机卷', '100', '10', 'Mr.K', '2016-08-01', '2016-08-01');

-- ----------------------------
-- Table structure for tb_result
-- ----------------------------
DROP TABLE IF EXISTS `tb_result`;
CREATE TABLE `tb_result` (
  `resultID` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` varchar(20) NOT NULL DEFAULT '',
  `paperName` varchar(60) NOT NULL,
  `score` smallint(6) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`resultID`),
  KEY `fk_studentID` (`studentID`),
  CONSTRAINT `fk_studentID` FOREIGN KEY (`studentID`) REFERENCES `tb_student` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_result
-- ----------------------------
INSERT INTO `tb_result` VALUES ('2', '05099301*21', '综合卷', '100', '2016-06-12');
INSERT INTO `tb_result` VALUES ('20', '0509302*21', '综合卷3', '40', '2016-07-31');
INSERT INTO `tb_result` VALUES ('21', '0509302*21', '', '150', '2016-07-31');
INSERT INTO `tb_result` VALUES ('22', '0509302*21', '综合卷2', '30', '2016-08-01');
INSERT INTO `tb_result` VALUES ('23', '0509302*21', '综合卷2', '10', '2016-08-01');
INSERT INTO `tb_result` VALUES ('24', '0509302*21', '综合卷3', '20', '2016-08-01');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `studentID` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `password` varchar(60) DEFAULT NULL,
  `studentName` varchar(20) DEFAULT NULL,
  `studentAge` tinyint(4) DEFAULT NULL,
  `studentSex` tinyint(4) DEFAULT NULL,
  `studentEmail` varchar(50) DEFAULT NULL,
  `studentRegisterDate` date DEFAULT NULL,
  `result` int(11) DEFAULT NULL,
  `sclass` varchar(20) NOT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='学生信息表';

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('0509302*21', '*1308E0FCD43112F8D948AB093F54892CB7B220AA', '李明华', '9', '1', '1001230@456.com', '2011-11-11', '50', '0509301');
INSERT INTO `tb_student` VALUES ('05099301*21', '*23AE809DDACAF96AF0FD78ED04B6A265E05AA257', '洪林', '16', '0', '1547892@zbd.com', '2012-12-12', '100', '0509301');

-- ----------------------------
-- Table structure for tb_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject` (
  `subjectID` int(11) NOT NULL AUTO_INCREMENT,
  `subjectType` varchar(50) NOT NULL,
  `subjectTitle` varchar(255) DEFAULT NULL,
  `subjectOptionA` varchar(50) DEFAULT NULL,
  `subjectOptionB` varchar(50) DEFAULT NULL,
  `subjectOptionC` varchar(50) DEFAULT NULL,
  `subjectOptionD` varchar(50) DEFAULT NULL,
  `subjectAnswer` varchar(1) DEFAULT NULL,
  `subjectScore` smallint(6) DEFAULT '10',
  `subjectParse` text,
  PRIMARY KEY (`subjectID`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=gb2312 COMMENT='试题信息表';

-- ----------------------------
-- Records of tb_subject
-- ----------------------------
INSERT INTO `tb_subject` VALUES ('2', '计算机', '下列各进制数中最大的数是( )\r\r\n。', '227O', '1FFH', '1010001B', '789D', 'D', '10', null);
INSERT INTO `tb_subject` VALUES ('3', '计算机', '( )不是微型计算机必须的工作\r\r\n环境。', '恒温', '良好的接地线路', '远离强磁场', '稳定的电源电压', 'A', '10', null);
INSERT INTO `tb_subject` VALUES ('4', '计算机', '( )不是文件。', '设备', '文\r\r\n档', '应用程序', '窗口', 'D', '10', '窗口不是文件');
INSERT INTO `tb_subject` VALUES ('5', '计算机', '( )不属于Word2003的文档打开\r\r\n方式。', '读写方式', '只读方式', '备份方式', '系统方式', 'D', '10', '系统方式\r\r\n不是Word2003的文档打开方式。');
INSERT INTO `tb_subject` VALUES ('6', '计算机', '( )菜单中含有设置字体的命令\r\r\n。', '格式', '编辑', '视图', '工具', 'A', '10', null);
INSERT INTO `tb_subject` VALUES ('8', '计算机', '( )的功能是将计算机外部的信\r\r\n息送入计算机。', '输入设备', '输出设备', '软盘', '电源线', 'A', '10', '');
INSERT INTO `tb_subject` VALUES ('9', '计算机', '( )的主要功能是使用户的计算\r\r\n机与远程主机相连，从而成为远程主机的终端。', 'E-mail', 'FTP', 'Telnet', 'BBS', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('10', '计算机', '( )视图方式可对文档不进行分\r\r\n页处理。', '普通', '联机版式', '页面视图', '大纲', 'B', '10', '');
INSERT INTO `tb_subject` VALUES ('12', '计算机', '( )是微型计算机的外存。 ', 'RAM', 'ROM', '磁盘', '虚拟盘', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('13', '计算机', '( )是用来存储程序及数据的装\r\r\n置。', '输入设备', '存储器', '控制器', '输出设备', 'B', '10', '');
INSERT INTO `tb_subject` VALUES ('14', '计算机', 'NOVELLNETWARE是( )', '网络\r\r\n操作系统', '通用操作系统', '实时操作系统', '分时操作系统', 'A', '10', '');
INSERT INTO `tb_subject` VALUES ('15', '计算机', '预防计算机病毒的手段，错误\r\r\n的是( )。', '要经常地对硬盘上的文件进行备份', '凡不需要再写入数据的磁盘都应\r\r\n有写保护', '将所有的.COM和.EXE文件赋以“只读”属性', '对磁盘进行清洗', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('16', '计算机', '“32位微型计算机”中的32指\r\r\n的是( )', '微机型号', '内存容量', '存储单位', '机器字长', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('17', '计算机', '“奔腾”微型计算机采用的微\r\r\n处理器的型号是( )', '80286', '80386', '80486', '80586', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('18', '计算机', '“画图”程序是WINDOWS98的一\r\r\n个附件程序，能进行简单的图形处理，产生的文件为位图文件，扩展名为( )。', 'BMP', 'CRH', 'EXE', 'GPH', 'A', '10', '');
INSERT INTO `tb_subject` VALUES ('19', '计算机', '“开始”菜单中，注销命令将( \r\r\n)。', '关闭系统', '关闭当前窗口上的程序', '关闭所有打开的程序', '以上都不\r\r\n对', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('20', '计算机', '“文件”下拉菜单底部所显示\r\r\n的文件名是( )。', '扩展名为DOC的全部文件', '正要打印的文件名', '正在使用的文\r\r\n件名', '最近被Word处理过的文档', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('21', '计算机', '“溢出”一般是指计算机在运\r\r\n算过程中产生的( )。', '数据量超过了内存量', '文件个数超过了磁盘目录区规定的\r\r\n范围', '数超过了机器的位所表示的范围', '数超过了变量的表示范围', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('22', '计算机', '《计算机软件条例》中所称的\r\r\n计算机软件(简称软件)是指( )。', '计算机程序', '源程序和目标程序', '源程序', '计算机程序及其有关文档', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('23', '计算机', '10BaseF的含义是( )。', '10Mbps的宽带光纤网络', '10Mbps的基带同轴电缆网络', '10Mbps的基带光纤网络', '10Mbps的宽带同轴电缆网络', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('24', '计算机', '在微机中，主机由微处理器与( \r\r\n)组成。', '运算器', '磁盘存储器', '软盘存储器', '内存储器', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('25', '计算机', '1MB的存储容量相当于( )。', '一百万个字节', '2的10次方个字节', '2的20次方个字节', '1000KB', 'C', '10', '');
INSERT INTO `tb_subject` VALUES ('26', '计算机', '1nternet的分层结构是由( )这\r\r\n个四层组成。', ' 应用层、传输层、通信子网层和物理层', '应用层、表示层、传输\r\r\n层和网络层', '物理层、数据链路层、网络层和传输层', '网络接口层、网络层、传输\r\r\n层和应用层', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('27', '计算机', 'WindowsXP中改变窗口的大小时\r\r\n，应操作( )。', '窗口的四角或四边', '窗口右上角的按钮', '窗口的标题栏', '窗\r\r\n口左上角的控制栏', 'A', '10', '');
INSERT INTO `tb_subject` VALUES ('28', '计算机', '在WindowsXP操作系统中，对话\r\r\n框的大小是( )。', '可变的', '可任意设置的', '固定的', '与不同的操作有关的', 'D', '10', '');
INSERT INTO `tb_subject` VALUES ('29', '计算机', '测试路考', '向右转', '向左\r\r\n转', '向前', '向后', 'D', '10', '应该向后！！！！');

-- ----------------------------
-- Table structure for tb_subpap
-- ----------------------------
DROP TABLE IF EXISTS `tb_subpap`;
CREATE TABLE `tb_subpap` (
  `subId` int(11) DEFAULT NULL,
  `papId` int(11) DEFAULT NULL,
  KEY `fk_papId` (`papId`),
  KEY `fk_subId` (`subId`),
  CONSTRAINT `fk_papId` FOREIGN KEY (`papId`) REFERENCES `tb_paper` (`paperId`),
  CONSTRAINT `fk_subId` FOREIGN KEY (`subId`) REFERENCES `tb_subject` (`subjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_subpap
-- ----------------------------
INSERT INTO `tb_subpap` VALUES ('12', '89');
INSERT INTO `tb_subpap` VALUES ('6', '89');
INSERT INTO `tb_subpap` VALUES ('10', '89');
INSERT INTO `tb_subpap` VALUES ('8', '89');
INSERT INTO `tb_subpap` VALUES ('3', '89');
INSERT INTO `tb_subpap` VALUES ('9', '89');
INSERT INTO `tb_subpap` VALUES ('5', '89');
INSERT INTO `tb_subpap` VALUES ('2', '89');
INSERT INTO `tb_subpap` VALUES ('4', '89');
INSERT INTO `tb_subpap` VALUES ('13', '89');
INSERT INTO `tb_subpap` VALUES ('3', '90');
INSERT INTO `tb_subpap` VALUES ('9', '90');
INSERT INTO `tb_subpap` VALUES ('5', '90');
INSERT INTO `tb_subpap` VALUES ('2', '90');
INSERT INTO `tb_subpap` VALUES ('13', '90');
INSERT INTO `tb_subpap` VALUES ('10', '90');
INSERT INTO `tb_subpap` VALUES ('4', '90');
INSERT INTO `tb_subpap` VALUES ('12', '90');
INSERT INTO `tb_subpap` VALUES ('6', '90');
INSERT INTO `tb_subpap` VALUES ('8', '90');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `teacherID` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='老师信息表';

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('123', '*23AE809DDACAF96AF0FD78ED04B6A265E05AA257');
INSERT INTO `tb_teacher` VALUES ('teacher', '*977F15BF49C046DA76BC81A80146AAB943F679F1');

-- ----------------------------
-- View structure for result
-- ----------------------------
DROP VIEW IF EXISTS `result`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `result` AS select studentID,score,time from tb_result ;
DROP TRIGGER IF EXISTS `insrStuPass`;
DELIMITER ;;
CREATE TRIGGER `insrStuPass` BEFORE INSERT ON `tb_student` FOR EACH ROW set new.password = password(new.password)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `insrTeacherrPass`;
DELIMITER ;;
CREATE TRIGGER `insrTeacherrPass` BEFORE INSERT ON `tb_teacher` FOR EACH ROW set new.password = password(new.password)
;;
DELIMITER ;
