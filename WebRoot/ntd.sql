/*
Navicat MySQL Data Transfer

Source Server         : cs
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : ntd

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-11-25 22:43:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bean
-- ----------------------------
DROP TABLE IF EXISTS `bean`;
CREATE TABLE `bean` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bean
-- ----------------------------
INSERT INTO `bean` VALUES ('a');
INSERT INTO `bean` VALUES ('子鼠');

-- ----------------------------
-- Table structure for buyer_remark
-- ----------------------------
DROP TABLE IF EXISTS `buyer_remark`;
CREATE TABLE `buyer_remark` (
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `time` date DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT '0',
  PRIMARY KEY (`pid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buyer_remark
-- ----------------------------
INSERT INTO `buyer_remark` VALUES ('1', '1', '2017-11-23', '范德萨十分大', '8', '0');
INSERT INTO `buyer_remark` VALUES ('3', '1', '2017-11-25', '不持续创新', '8', '0');
INSERT INTO `buyer_remark` VALUES ('4', '1', '2017-11-25', '日月潭', '10', '0');
INSERT INTO `buyer_remark` VALUES ('5', '1', '2017-11-25', '大丰收发到', '6', '0');
INSERT INTO `buyer_remark` VALUES ('6', '1', '2017-11-23', '下次再接再厉', '8', '0');
INSERT INTO `buyer_remark` VALUES ('6', '13', '2017-11-23', '非常赞的一部手机', '8', '0');
INSERT INTO `buyer_remark` VALUES ('6', '14', '2017-11-23', '需要加把劲才能完美', '10', '0');
INSERT INTO `buyer_remark` VALUES ('7', '1', '2017-11-25', '换个活法', '6', '0');
INSERT INTO `buyer_remark` VALUES ('8', '1', '2017-11-25', '二恶烷', '6', '0');
INSERT INTO `buyer_remark` VALUES ('9', '1', '2017-11-25', '多干活', '8', '0');
INSERT INTO `buyer_remark` VALUES ('20', '1', '2017-11-25', '杜甫江阁店', '10', '0');
INSERT INTO `buyer_remark` VALUES ('25', '1', '2017-11-25', '吃不饱', '6', '0');
INSERT INTO `buyer_remark` VALUES ('40', '1', '2017-11-25', '发多少方式', '6', '0');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', 'vivo');
INSERT INTO `company` VALUES ('2', 'OPPO');
INSERT INTO `company` VALUES ('3', '三星');
INSERT INTO `company` VALUES ('4', '苹果');
INSERT INTO `company` VALUES ('5', '华为');
INSERT INTO `company` VALUES ('6', '荣耀');
INSERT INTO `company` VALUES ('7', '小米');
INSERT INTO `company` VALUES ('8', '一加');
INSERT INTO `company` VALUES ('9', '魅族');
INSERT INTO `company` VALUES ('10', '锤子科技');
INSERT INTO `company` VALUES ('11', '金立');

-- ----------------------------
-- Table structure for imgs
-- ----------------------------
DROP TABLE IF EXISTS `imgs`;
CREATE TABLE `imgs` (
  `pid` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`,`image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgs
-- ----------------------------
INSERT INTO `imgs` VALUES ('1', 'images/1/0.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/1.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/10.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/11.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/2.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/3.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/4.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/5.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/6.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/7.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/8.jpg');
INSERT INTO `imgs` VALUES ('1', 'images/1/9.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/0.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/1.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/10.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/11.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/2.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/3.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/4.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/5.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/6.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/7.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/8.jpg');
INSERT INTO `imgs` VALUES ('2', 'images/2/9.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/0.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/1.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/10.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/11.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/2.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/3.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/4.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/5.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/6.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/7.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/8.jpg');
INSERT INTO `imgs` VALUES ('3', 'images/3/9.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/0.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/1.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/10.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/11.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/2.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/3.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/4.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/5.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/6.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/7.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/8.jpg');
INSERT INTO `imgs` VALUES ('4', 'images/4/9.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/0.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/1.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/10.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/11.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/2.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/3.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/4.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/5.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/6.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/7.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/8.jpg');
INSERT INTO `imgs` VALUES ('5', 'images/5/9.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/0.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/1.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/10.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/11.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/2.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/3.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/4.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/5.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/6.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/7.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/8.jpg');
INSERT INTO `imgs` VALUES ('6', 'images/6/9.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/0.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/1.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/10.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/11.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/2.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/3.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/4.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/5.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/6.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/7.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/8.jpg');
INSERT INTO `imgs` VALUES ('7', 'images/7/9.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/0.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/1.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/10.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/11.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/2.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/3.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/4.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/5.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/6.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/7.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/8.jpg');
INSERT INTO `imgs` VALUES ('8', 'images/8/9.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/0.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/1.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/10.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/11.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/2.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/3.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/4.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/5.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/6.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/7.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/8.jpg');
INSERT INTO `imgs` VALUES ('9', 'images/9/9.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/0.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/1.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/10.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/11.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/2.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/3.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/4.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/5.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/6.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/7.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/8.jpg');
INSERT INTO `imgs` VALUES ('10', 'images/10/9.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/0.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/1.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/10.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/11.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/2.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/3.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/4.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/5.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/6.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/7.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/8.jpg');
INSERT INTO `imgs` VALUES ('11', 'images/11/9.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/0.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/1.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/10.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/11.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/2.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/3.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/4.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/5.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/6.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/7.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/8.jpg');
INSERT INTO `imgs` VALUES ('12', 'images/12/9.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/0.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/1.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/10.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/11.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/2.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/3.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/4.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/5.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/6.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/7.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/8.jpg');
INSERT INTO `imgs` VALUES ('13', 'images/13/9.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/0.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/1.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/10.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/11.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/2.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/3.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/4.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/5.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/6.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/7.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/8.jpg');
INSERT INTO `imgs` VALUES ('14', 'images/14/9.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/0.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/1.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/10.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/11.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/2.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/3.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/4.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/5.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/6.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/7.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/8.jpg');
INSERT INTO `imgs` VALUES ('15', 'images/15/9.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/0.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/1.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/10.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/11.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/2.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/3.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/4.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/5.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/6.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/7.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/8.jpg');
INSERT INTO `imgs` VALUES ('16', 'images/16/9.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/0.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/1.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/10.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/11.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/2.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/3.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/4.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/5.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/6.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/7.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/8.jpg');
INSERT INTO `imgs` VALUES ('17', 'images/17/9.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/0.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/1.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/10.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/11.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/2.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/3.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/4.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/5.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/6.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/7.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/8.jpg');
INSERT INTO `imgs` VALUES ('18', 'images/18/9.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/0.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/1.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/10.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/11.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/2.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/3.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/4.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/5.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/6.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/7.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/8.jpg');
INSERT INTO `imgs` VALUES ('19', 'images/19/9.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/0.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/1.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/10.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/11.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/2.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/3.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/4.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/5.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/6.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/7.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/8.jpg');
INSERT INTO `imgs` VALUES ('20', 'images/20/9.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/0.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/1.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/10.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/11.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/2.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/3.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/4.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/5.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/6.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/7.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/8.jpg');
INSERT INTO `imgs` VALUES ('21', 'images/21/9.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/0.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/1.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/10.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/11.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/2.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/3.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/4.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/5.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/6.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/7.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/8.jpg');
INSERT INTO `imgs` VALUES ('22', 'images/22/9.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/0.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/1.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/10.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/11.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/2.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/3.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/4.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/5.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/6.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/7.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/8.jpg');
INSERT INTO `imgs` VALUES ('23', 'images/23/9.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/0.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/1.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/10.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/11.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/2.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/3.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/4.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/5.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/6.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/7.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/8.jpg');
INSERT INTO `imgs` VALUES ('24', 'images/24/9.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/0.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/1.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/10.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/11.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/2.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/3.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/4.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/5.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/6.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/7.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/8.jpg');
INSERT INTO `imgs` VALUES ('25', 'images/25/9.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/0.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/1.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/10.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/11.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/2.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/3.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/4.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/5.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/6.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/7.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/8.jpg');
INSERT INTO `imgs` VALUES ('26', 'images/26/9.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/0.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/1.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/10.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/11.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/2.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/3.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/4.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/5.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/6.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/7.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/8.jpg');
INSERT INTO `imgs` VALUES ('27', 'images/27/9.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/0.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/1.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/10.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/11.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/2.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/3.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/4.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/5.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/6.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/7.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/8.jpg');
INSERT INTO `imgs` VALUES ('28', 'images/28/9.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/0.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/1.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/10.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/11.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/2.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/3.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/4.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/5.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/6.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/7.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/8.jpg');
INSERT INTO `imgs` VALUES ('29', 'images/29/9.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/0.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/1.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/10.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/11.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/2.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/3.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/4.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/5.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/6.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/7.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/8.jpg');
INSERT INTO `imgs` VALUES ('30', 'images/30/9.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/0.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/1.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/10.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/11.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/2.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/3.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/4.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/5.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/6.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/7.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/8.jpg');
INSERT INTO `imgs` VALUES ('31', 'images/31/9.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/0.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/1.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/10.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/11.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/2.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/3.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/4.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/5.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/6.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/7.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/8.jpg');
INSERT INTO `imgs` VALUES ('32', 'images/32/9.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/0.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/1.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/10.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/11.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/2.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/3.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/4.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/5.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/6.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/7.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/8.jpg');
INSERT INTO `imgs` VALUES ('33', 'images/33/9.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/0.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/1.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/10.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/11.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/2.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/3.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/4.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/5.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/6.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/7.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/8.jpg');
INSERT INTO `imgs` VALUES ('34', 'images/34/9.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/0.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/1.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/10.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/11.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/2.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/3.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/4.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/5.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/6.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/7.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/8.jpg');
INSERT INTO `imgs` VALUES ('35', 'images/35/9.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/0.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/1.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/10.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/11.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/2.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/3.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/4.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/5.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/6.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/7.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/8.jpg');
INSERT INTO `imgs` VALUES ('36', 'images/36/9.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/0.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/1.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/2.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/3.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/4.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/5.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/6.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/7.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/8.jpg');
INSERT INTO `imgs` VALUES ('37', 'images/37/9.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/0.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/1.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/10.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/11.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/2.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/3.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/4.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/5.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/6.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/7.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/8.jpg');
INSERT INTO `imgs` VALUES ('38', 'images/38/9.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/0.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/1.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/10.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/11.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/2.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/3.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/4.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/5.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/6.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/7.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/8.jpg');
INSERT INTO `imgs` VALUES ('39', 'images/39/9.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/0.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/1.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/10.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/11.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/2.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/3.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/4.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/5.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/6.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/7.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/8.jpg');
INSERT INTO `imgs` VALUES ('40', 'images/40/9.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/0.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/1.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/10.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/11.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/2.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/3.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/4.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/5.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/6.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/7.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/8.jpg');
INSERT INTO `imgs` VALUES ('41', 'images/41/9.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/0.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/1.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/10.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/11.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/2.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/3.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/4.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/5.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/6.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/7.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/8.jpg');
INSERT INTO `imgs` VALUES ('42', 'images/42/9.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/0.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/1.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/10.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/11.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/2.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/3.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/4.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/5.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/6.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/7.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/8.jpg');
INSERT INTO `imgs` VALUES ('43', 'images/43/9.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/0.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/1.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/10.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/11.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/2.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/3.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/4.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/5.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/6.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/7.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/8.jpg');
INSERT INTO `imgs` VALUES ('44', 'images/44/9.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/0.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/1.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/10.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/11.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/2.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/3.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/4.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/5.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/6.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/7.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/8.jpg');
INSERT INTO `imgs` VALUES ('45', 'images/45/9.jpg');

-- ----------------------------
-- Table structure for login_info
-- ----------------------------
DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `uid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_info
-- ----------------------------
INSERT INTO `login_info` VALUES ('1', '2017-11-24 23:51:58', '192.168.23.1:32452', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 11:56:04', '192.168.23.1:31788', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 11:59:24', '192.168.23.1:31829', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 12:01:40', '192.168.23.1:31848', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 12:01:46', '192.168.23.1:31848', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 12:52:06', '192.168.23.1:33291', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 12:52:30', '192.168.23.1:33295', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 13:31:08', '192.168.23.1:34114', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:29:48', '192.168.23.1:2496', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:32:15', '192.168.23.1:2536', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:38:57', '192.168.23.2:42543', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:47:44', '192.168.23.1:2685', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:48:00', '192.168.23.1:2686', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:59:23', '192.168.23.1:37441', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 18:59:43', '192.168.23.1:37445', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:01:28', '192.168.23.1:37477', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:01:46', '192.168.23.1:37482', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:02:34', '192.168.23.1:37494', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:03:34', '192.168.23.1:37510', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:07:56', '192.168.23.1:37560', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:11:32', '192.168.23.1:37618', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:30', '192.168.23.1:37976', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:35', '192.168.23.1:37973', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:40', '192.168.23.1:37979', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:45', '192.168.23.1:37973', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:50', '192.168.23.1:37979', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:21:54', '192.168.23.1:37982', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:03', '192.168.23.1:37983', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:08', '192.168.23.1:37983', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:12', '192.168.23.1:37973', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:17', '192.168.23.1:37976', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:22', '192.168.23.1:37973', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:26', '192.168.23.1:37988', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:31', '192.168.23.1:37983', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:36', '192.168.23.1:37983', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:40', '192.168.23.1:37988', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:45', '192.168.23.1:37988', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 19:22:49', '192.168.23.1:37983', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 20:12:57', '192.168.23.1:38810', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 22:09:26', '192.168.23.2:43337', null, 'NTD Phone');
INSERT INTO `login_info` VALUES ('1', '2017-11-25 22:38:45', 'fe80:0:0:0:2cdb:b043:5267:6e6%10:50559', null, 'NTD Phone');

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `price` decimal(8,0) DEFAULT NULL,
  `rank` double(4,2) DEFAULT NULL,
  `commentSize` int(8) DEFAULT NULL,
  `screenSize` varchar(255) DEFAULT NULL,
  `pixels` varchar(255) DEFAULT NULL,
  `forecamera` varchar(255) DEFAULT NULL,
  `backcamera` varchar(255) DEFAULT NULL,
  `battery` varchar(255) DEFAULT NULL,
  `batteryType` varchar(255) DEFAULT NULL,
  `core` varchar(255) DEFAULT NULL,
  `coreType` varchar(255) DEFAULT NULL,
  `coreRate` varchar(255) DEFAULT NULL,
  `ROM` varchar(255) DEFAULT NULL,
  `RAM` varchar(255) DEFAULT NULL,
  `density` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `cid` (`cid`),
  CONSTRAINT `phone_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `company` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES ('1', 'images/1/00.jpg', 'vivo X20', '全网通', '1', '2998', '9.20', '702', '6.01英寸', '2160x1080像素', '（2400万感光单元）2x1200万像素', '（2400万感光单元）2x1200万像素+500万像素', '3245mAh', '不可拆卸式电池', '八核', '高通 骁龙660', '2.2GHz（大四核）,1.8GHz（小四核）', '64GB', '4GB', '402ppi', '159g', '2017年09月30日');
INSERT INTO `phone` VALUES ('2', 'images/2/00.jpg', 'OPPO R11s', '全网通', '2', '2999', '9.20', '872', '6.01英寸', '2160x1080像素', '2000万像素', '2000万像素+1600万像素', '3205mAh', '不可拆卸式电池', '八核', '高通 骁龙660', '2.2GHz', '64GB', '4GB', '401ppi', '153g', '2017年');
INSERT INTO `phone` VALUES ('3', 'images/3/00.jpg', '三星GALAXY S8', 'G9500/双卡版/全网通', '3', '5497', '8.00', '418', '5.8英寸', '2960x1440像素', '800万像素', '1200万像素', '3000mAh', '不可拆卸式电池', '八核', '高通 骁龙835（MSM8998）', '2.35GHz（大四核）,1.9GHz（小四核）', '64GB', '4GB', '568ppi', '155g', '2017年05月25日');
INSERT INTO `phone` VALUES ('4', 'images/4/00.jpg', '苹果iPhone 8', '全网通', '4', '4898', '5.00', '209', '4.7英寸', '1334x750像素', '700万像素', '1200万像素', '暂无数据', '不可拆卸式电池', '六核', '苹果 A11+M11协处理器', '暂无数据', '64GB,256GB', '暂无数据', '326ppi', '148g', '2017年09月');
INSERT INTO `phone` VALUES ('5', 'images/5/00.jpg', '华为nova 2', 'PIC-AL00/全网通', '5', '2199', '8.20', '186', '5英寸', '1920x1080像素', '2000万像素', '1200万像素+800万像素', '2950mAh', '不可拆卸式电池', '八核', '海思 Kirin 659', '2.36GHz（大四核）,1.7GHz（小四核）', '64GB', '4GB', '441ppi', '143g', '2017年06月');
INSERT INTO `phone` VALUES ('6', 'images/6/00.jpg', '荣耀9', '4GB RAM/全网通', '6', '2059', '8.20', '288', '5.15英寸', '1920x1080像素', '800万像素', '1200万像素+2000万像素', '3200mAh', '不可拆卸式电池', '八核', '海思 Kirin 960', '2.4GHz（大四核）,1.8GHz（小四核）+微智核I6', '64GB', '4GB', '428ppi', '155g', '2017年06月16日');
INSERT INTO `phone` VALUES ('7', 'images/7/00.jpg', 'vivo X9s', '全网通', '1', '2498', '9.00', '526', '5.5英寸', '1920x1080像素', '2000万像素+500万像素', '1600万像素', '3320mAh', '不可拆卸式电池', '八核', '高通 骁龙652（MSM8976）', '1.8GHz', '64GB', '4GB', '401ppi', '155.3g', '2017年07月14日');
INSERT INTO `phone` VALUES ('8', 'images/8/00.jpg', 'OPPO R11', '标准版/全网通', '2', '2799', '9.10', '1308', '5.5英寸', '1920x1080像素', '2000万像素', '1600万像素+2000万像素', '3000mAh', '不可拆卸式电池', '八核', '高通 骁龙660', '2.2GHz', '64GB', '4GB', '401ppi', '150g', '2017年06月');
INSERT INTO `phone` VALUES ('9', 'images/9/00.jpg', '华为P10', 'VTR-AL00/全网通', '5', '3488', '7.20', '368', '5.1英寸', '1920x1080像素', '800万像素', '2000万像素+1200万像素', '3200mAh', '不可拆卸式电池', '八核', '海思 Kirin 960', '2.4GHz（大四核）,1.8GHz（小四核）+微智核I6', '64GB,128GB', '4GB', '432ppi', '145g', '2017年03月');
INSERT INTO `phone` VALUES ('10', 'images/10/00.jpg', '三星GALAXY Note 8', 'N9500/全网通', '3', '6988', '7.60', '124', '6.3英寸', '2960x1440像素', '800万像素', '双1200万像素', '3300mAh', '不可拆卸式电池', '八核', '高通 骁龙835（MSM8998）', '2.35GHz（大四核）,1.9GHz（小四核）', '64GB,128GB,256GB', '6GB', '522ppi', '195g', '2017年09月');
INSERT INTO `phone` VALUES ('11', 'images/11/00.jpg', 'vivo X9', '全网通', '1', '1998', '8.50', '1340', '5.5英寸', '1920x1080像素', '2000万像素+800万像素', '1600万像素', '3050mAh', '不可拆卸式电池', '八核', '高通 骁龙625（MSM8953）', '2.0GHz', '64GB,128GB', '4GB', '401ppi', '154g', '2016年11月24日');
INSERT INTO `phone` VALUES ('12', 'images/12/00.jpg', '苹果iPhone 7 Plus', '全网通', '4', '5088', '8.10', '305', '5.5英寸', '1920x1080像素', '700万像素', '双1200万像素', '2910mAh', '不可拆卸式电池', '四核', '苹果 A10+M10协处理器', '暂无数据', '32GB,128GB,256GB', '3GB', '401ppi', '188g', '2016年9月16日');
INSERT INTO `phone` VALUES ('13', 'images/13/00.jpg', 'OPPO R9s', '全网通', '2', '2599', '8.20', '1518', '5.5英寸', '1920x1080像素', '1600万像素', '1600万像素', '3010mAh', '不可拆卸式电池', '八核', '高通 骁龙625（MSM8953）', '2.0GHz', '64GB', '4GB', '401ppi', '145g', '2016年10月');
INSERT INTO `phone` VALUES ('14', 'images/14/00.jpg', '华为Mate 10', '4GB RAM/全网通', '5', '3899', '7.80', '44', '5.9英寸', '2560x1440像素', '800万像素', '1200万像素+2000万像素', '4000mAh', '不可拆卸式电池', '八核', '海思 Kirin 970', '2.36GHz（大四核）,1.8GHz（小四核）+微智核i7', '64GB', '4GB', '498ppi', '186g', '2017年10月20日');
INSERT INTO `phone` VALUES ('15', 'images/15/00.jpg', '荣耀V9', 'DUK-AL20/6GB RAM/全网通', '6', '2580', '7.60', '390', '5.7英寸', '2560x1440像素', '800万像素', '双1200万像素', '4000mAh', '不可拆卸式电池', '八核', '海思 Kirin 960', '2.4GHz（大四核）,1.8GHz（小四核）+微智核I6', '64GB,128GB', '6GB', '515ppi', '184g', '2017年02月28日');
INSERT INTO `phone` VALUES ('16', 'images/16/00.jpg', '华为Mate 9', 'MHA-AL00/4GB RAM/全网通', '5', '3099', '7.80', '417', '5.9英寸', '1920x1080像素', '800万像素', '2000万像素+1200万像素', '4000mAh', '不可拆卸式电池', '八核+微智核i6', '海思 kirin 960', '2.4GHz（大四核）,1.8GHz（小四核）', '32GB,64GB', '4GB', '373ppi', '190g', '2016年11月14日');
INSERT INTO `phone` VALUES ('17', 'images/17/00.jpg', '苹果iPhone 7', '全网通', '4', '4188', '8.10', '457', '4.7英寸', '1334x750像素', '700万像素', '1200万像素', '1960mAh', '不可拆卸式电池', '四核', '苹果 A10+M10协处理器', '暂无数据', '32GB,128GB,256GB', '2GB', '326ppi', '138g', '2016年9月16日');
INSERT INTO `phone` VALUES ('18', 'images/18/00.jpg', '荣耀8', 'FRD-AL00/3GB RAM/全网通', '6', '1516', '7.60', '456', '5.2英寸', '1920x1080像素', '800万像素', '双1200万像素', '3000mAh', '不可拆卸式电池', '八核', '海思 Kirin 950', '2.3GHz（大四核）,1.8GHz（小四核）', '32GB', '3GB', '424ppi', '153g', '2016年07月');
INSERT INTO `phone` VALUES ('19', 'images/19/00.jpg', '苹果iPhone X', '全网通', '4', '8388', '5.00', '121', '5.8英寸', '2436x1125像素', '700万像素', '双1200万像素', '暂无数据', '不可拆卸式电池', '六核', '苹果 A11+M11协处理器', '暂无数据', '64GB,256GB', '暂无数据', '463ppi', '174g', '2017年11月');
INSERT INTO `phone` VALUES ('20', 'images/20/00.jpg', '苹果iPhone 6', '全网通', '4', '2479', '8.00', '3062', '4.7英寸', '1334x750像素', '120万像素', '800万像素', '1810mAh', '不可拆卸式电池', '双核', '苹果 A8+M8协处理器', '1.4GHz', '16GB,64GB,128GB', '1GB', '326ppi', '129g', '2014年09月');
INSERT INTO `phone` VALUES ('21', 'images/21/00.jpg', 'OPPO R9', '全网通', '2', '2499', '7.80', '1707', '5.5英寸', '1920x1080像素', '1600万像素', '1300万像素', '2850mAh', '不可拆卸式电池', '真八核', '联发科 MT6755', '2.0GHz', '64GB', '4GB', '401ppi', '145g', '2016年03月');
INSERT INTO `phone` VALUES ('22', 'images/22/00.jpg', '小米6', '6GB RAM/全网通', '7', '2499', '7.60', '450', '5.15英寸', '1920x1080像素', '800万像素', '双1200万像素', '3350mAh', '不可拆卸式电池', '八核', '高通 骁龙835（MSM8998）', '2.45GHz', '64GB,128GB', '6GB', '428ppi', '168g', '2017年04月28日');
INSERT INTO `phone` VALUES ('23', 'images/23/00.jpg', '三星GALAXY S7 Edge', 'G9350/全网通', '3', '2699', '9.10', '1033', '5.5英寸', '2560x1440像素', '500万像素', '1200万像素', '3600mAh', '不可拆卸式电池', '四核', '高通 骁龙820（MSM8996）', '2.15GHz（大双核）,1.6GHz（小双核）', '32GB,64GB,128GB', '4GB', '534ppi', '157g', '2016年02月');
INSERT INTO `phone` VALUES ('24', 'images/24/00.jpg', '苹果iPhone 6S Plus', '全网通', '4', '3650', '8.00', '271', '5.5英寸', '1920x1080像素', '500万像素', '1200万像素', '2750mAh', '不可拆卸式电池', '双核', '苹果 A9+M9协处理器', '1.8GHz', '16GB,32GB,64GB,128GB', '2GB', '401ppi', '192g', '2015年09月');
INSERT INTO `phone` VALUES ('25', 'images/25/00.jpg', 'vivo Xplay6', '全网通', '1', '3998', '8.70', '670', '5.46英寸', '2560x1440像素', '1600万像素', '1200万像素+500万像素', '4080mAh', '不可拆卸式电池', '四核', '高通 骁龙820（MSM8996）', '2.15GHz', '64GB,128GB', '6GB', '538ppi', '178g', '2016年12月12日');
INSERT INTO `phone` VALUES ('26', 'images/26/00.jpg', 'vivo X9Plus', '全网通', '1', '2998', '8.30', '683', '5.88英寸', '1920x1080像素', '2000万像素+800万像素', '1600万像素', '4000mAh', '不可拆卸式电池', '八核', '高通 骁龙653（MSM8976 Pro）', '1.95GHz（大四核）,1.4GHz（小四核）', '64GB', '6GB', '375ppi', '199g', '2016年12月30日');
INSERT INTO `phone` VALUES ('27', 'images/27/00.jpg', '一加手机5', '6GB RAM/全网通', '8', '2999', '7.70', '527', '5.5英寸', '1920x1080像素', '1600万像素', '1600万像素+2000万像素', '3300mAh', '不可拆卸式电池', '八核', '高通 骁龙835（MSM8998）', '2.45GHz', '64GB', '6GB', '401ppi', '153g', '2017年06月22日');
INSERT INTO `phone` VALUES ('28', 'images/28/00.jpg', 'OPPO A57', '全网通', '2', '1399', '7.60', '547', '5.2英寸', '1280x720像素', '1600万像素', '1300万像素', '2900mAh', '不可拆卸式电池', '八核', '高通 骁龙435（MSM8940）', '1.4GHz', '32GB', '3GB', '282ppi', '147g', '2016年11月');
INSERT INTO `phone` VALUES ('29', 'images/29/00.jpg', '华为P9', 'EVA-AL00/标准版/全网通', '5', '2250', '7.80', '626', '5.2英寸', '1920x1080像素', '800万像素', '双1200万像素', '3000mAh', '不可拆卸式电池', '八核', '海思 Kirin 955', '2.5GHz（大四核）,1.8GHz（小四核）+微智核I5', '32GB', '3GB', '424ppi', '144g', '2016年04月');
INSERT INTO `phone` VALUES ('30', 'images/30/00.jpg', '小米红米Note 4X', '3GB RAM/全网通', '7', '930', '5.90', '244', '5.5英寸', '1920x1080像素', '500万像素', '1300万像素', '4100mAh', '暂无数据', '八核', '高通 骁龙625（MSM8953）', '2.0GHz', '16GB,32GB', '3GB', '401ppi', '165g', '2017年02月');
INSERT INTO `phone` VALUES ('31', 'images/31/00.jpg', '魅族魅蓝Note 5', '全网通', '9', '899', '7.70', '607', '5.5英寸', '1920x1080像素', '500万像素', '1300万像素', '4000mAh', '暂无数据', '八核', '联发科 Helio P10', '1.8GHz（大四核）,1.0GHz（小四核）', '16GB,32GB', '3GB', '401ppi', '175g', '2016年12月');
INSERT INTO `phone` VALUES ('32', 'images/32/00.jpg', 'OPPO R11 Plus', '全网通', '2', '3499', '9.20', '540', '6英寸', '1920x1080像素', '2000万像素', '1600万像素+2000万像素', '4000mAh', '不可拆卸式电池', '八核', '高通 骁龙660', '2.2GHz', '64GB', '6GB', '367ppi', '188g', '2017年06月30日');
INSERT INTO `phone` VALUES ('33', 'images/33/00.jpg', '锤子科技坚果Pro', '64GB ROM/全网通', '10', '1499', '7.30', '167', '5.5英寸', '1920x1080像素', '1600万像素', '双1300万像素', '3500mAh', '不可拆卸式电池', '八核', '高通 骁龙626（MSM8953 Pro）', '2.2GHz', '64GB', '4GB', '401ppi', '158g', '2017年05月09日');
INSERT INTO `phone` VALUES ('34', 'images/34/00.jpg', 'vivo Y67', '全网通', '1', '1798', '6.30', '236', '5.5英寸', '1280x720像素', '1600万像素', '1300万像素', '3000mAh', '暂无数据', '真八核', '联发科 MT6750', '1.5GHz', '32GB,64GB', '4GB', '267ppi', '154g', '2016年11月');
INSERT INTO `phone` VALUES ('35', 'images/35/00.jpg', '魅族魅蓝E2', '3GB RAM/全网通', '9', '999', '6.80', '410', '5.5英寸', '1920x1080像素', '800万像素', '1300万像素', '3400mAh', '不可拆卸式电池', '八核', '联发科 Helio P20', '2.3GHz（大四核）,1.6GHz（小四核）', '32GB', '3GB', '401ppi', '155g', '2017年04月29日');
INSERT INTO `phone` VALUES ('36', 'images/36/00.jpg', '金立S10', '全网通', '11', '2599', '7.40', '719', '5.5英寸', '1920x1080像素', '2000万像素+800万像素', '主：1600万像素', '3450mAh', '不可拆卸式电池', '八核', '联发科 Helio P25', '2.5GHz', '64GB', '6GB', '401ppi', '178g', '2017年06月09日');
INSERT INTO `phone` VALUES ('37', 'images/37/00.jpg', 'vivo Y66', '全网通', '1', '1298', '6.30', '141', '5.5英寸', '1280x720像素', '500万像素', '1300万像素', '3000mAh', '不可拆卸式电池', '真八核', '暂无数据', '1.4GHz', '32GB', '3GB', '267ppi', '157g', '2016年12月');
INSERT INTO `phone` VALUES ('38', 'images/38/00.jpg', 'OPPO A59s', '全网通', '2', '1799', '7.70', '527', '5.5英寸', '1280x720像素', '1600万像素', '1300万像素', '3075mAh', '不可拆卸式电池', '八核', '联发科 MT6750', '1.5GHz', '32GB', '4GB', '267ppi', '160g', '2016年10月');
INSERT INTO `phone` VALUES ('39', 'images/39/00.jpg', '小米5', '标准版/全网通', '7', '1516', '6.00', '1236', '5.15英寸', '1920x1080像素', '400万像素', '1600万像素', '3000mAh', '不可拆卸式电池', '四核', '高通 骁龙820（MSM8996）', '1.8GHz', '32GB', '3GB', '428ppi', '129g', '2016年02月');
INSERT INTO `phone` VALUES ('40', 'images/40/00.jpg', '华为Mate 10 Pro', '全网通', '5', '4899', '10.00', '23', '6英寸', '2160x1080像素', '800万像素', '1200万像素+2000万像素', '4000mAh', '暂无数据', '八核', '海思 Kirin 970', '2.36GHz（大四核）,1.8GHz（小四核）+微智核i7', '64GB,128GB', '6GB', '402ppi', '178g', '2017年11月15日');
INSERT INTO `phone` VALUES ('41', 'images/41/00.jpg', 'OPPO R9s Plus', '全网通', '2', '3299', '8.20', '677', '6英寸', '1920x1080像素', '1600万像素', '1600万像素', '4000mAh', '不可拆卸式电池', '八核', '高通 骁龙653（MSM8976 Pro）', '1.95GHz', '64GB', '6GB', '367ppi', '185g', '2016年12月');
INSERT INTO `phone` VALUES ('42', 'images/42/00.jpg', '荣耀8青春版', 'PRA-AL00X/4GB RAM/全网通', '6', '1409', '7.60', '229', '5.2英寸', '1920x1080像素', '800万像素', '1200万像素', '3000mAh', '不可拆卸式电池', '八核', '海思 Kirin 655', '2.1GHz（大四核）,1.7GHz（小四核） + 微智核I5', '32GB,64GB', '4GB', '424ppi', '147g', '2017年02月28日');
INSERT INTO `phone` VALUES ('43', 'images/43/00.jpg', '华为nova 2 Plus', 'BAC-AL00/全网通', '5', '2599', '6.80', '65', '5.5英寸', '1920x1080像素', '2000万像素', '1200万像素+800万像素', '3340mAh', '不可拆卸式电池', '八核', '海思 Kirin 659', '2.36GHz（大四核）,1.7GHz（小四核）', '128GB', '4GB', '401ppi', '169g', '2017年06月');
INSERT INTO `phone` VALUES ('44', 'images/44/00.jpg', '小米Max 2', '全网通', '7', '1359', '6.30', '100', '6.44英寸', '1920x1080像素', '500万像素', '1200万像素', '5300mAh', '不可拆卸式电池', '八核', '高通 骁龙625', '2.0GHz', '32GB,64GB,128GB', '4GB', '342ppi', '211g', '2017年05月');
INSERT INTO `phone` VALUES ('45', 'images/45/00.jpg', '荣耀畅玩6X', 'BLN-AL10/4GB RAM/全网通', '6', '989', '7.70', '261', '5.5英寸', '1920x1080像素', '800万像素', '1200万像素+200万像素', '3340mAh', '不可拆卸式电池', '八核', '海思 Kirin 655', '2.1GHz（大四核）,1.7GHz（小四核）', '32GB,64GB', '4GB', '401ppi', '162g', '2016年10月25日');

-- ----------------------------
-- Table structure for sensitive_operation
-- ----------------------------
DROP TABLE IF EXISTS `sensitive_operation`;
CREATE TABLE `sensitive_operation` (
  `uid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sensitive_operation
-- ----------------------------
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-20 21:30:51', '127.0.0.1:41811', null, '修改密码');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-20 21:31:09', '127.0.0.1:41811', null, '修改邮箱');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-20 21:34:09', '127.0.0.1:41837', null, '修改邮箱');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-20 23:13:03', '192.168.23.1:9385', null, '修改邮箱');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-20 23:13:17', '192.168.23.1:9385', null, '修改邮箱');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-25 11:58:53', '192.168.23.1:31829', null, '修改邮箱');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-25 11:59:13', '192.168.23.1:31829', null, '修改密码');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-25 11:59:39', '192.168.23.1:31829', null, '修改密码');
INSERT INTO `sensitive_operation` VALUES ('1', '2017-11-25 11:59:49', '192.168.23.1:31829', null, '修改邮箱');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李四', '123456', '12@qq.com', null);
INSERT INTO `user` VALUES ('13', '王五', '123456', '123@qq.com', null);
INSERT INTO `user` VALUES ('14', '马坤', '123456', '124@qq.com', null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `blood` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `height` double(6,2) DEFAULT NULL,
  `marriage` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `microblog` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '女', '2017-01-06', '你去玩一样', 'A型', '较瘦', '40.00', '单身', '博士', '爱因斯坦大学', '学生', '20000以上', '重庆', '渝中', '广州市天河区五山街道', '24489833', '2453245413@qq.com', '13819324561');
INSERT INTO `user_info` VALUES ('13', '女', '2015-03-03', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('14', '女', '2014-05-03', null, 'O型', '苗条', null, null, null, null, null, '20000以上', 'null', null, null, null, null, null);

-- ----------------------------
-- Table structure for wanter_remark
-- ----------------------------
DROP TABLE IF EXISTS `wanter_remark`;
CREATE TABLE `wanter_remark` (
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `time` date DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `agree` int(11) DEFAULT '0',
  PRIMARY KEY (`pid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wanter_remark
-- ----------------------------
INSERT INTO `wanter_remark` VALUES ('1', '1', '2017-11-23', '菲登斯堡宫', '2', '0');
INSERT INTO `wanter_remark` VALUES ('3', '1', '2017-11-25', '发多少的说法', '4', '0');
INSERT INTO `wanter_remark` VALUES ('4', '1', '2017-11-25', '发的发的是', '2', '0');
INSERT INTO `wanter_remark` VALUES ('5', '1', '2017-11-25', '的空间丰富', '6', '0');
INSERT INTO `wanter_remark` VALUES ('6', '1', '2017-11-23', '非常期待', '8', '0');
INSERT INTO `wanter_remark` VALUES ('6', '13', '2017-11-23', '七七好手机的一部，期待能够买得到', '6', '0');
INSERT INTO `wanter_remark` VALUES ('6', '14', '2017-11-23', '很好', '4', '0');
INSERT INTO `wanter_remark` VALUES ('7', '1', '2017-11-25', '天太热太热', '8', '0');
INSERT INTO `wanter_remark` VALUES ('8', '1', '2017-11-25', '凤高蛋糕房', '8', '0');
INSERT INTO `wanter_remark` VALUES ('9', '1', '2017-11-25', '小灰灰', '10', '0');
INSERT INTO `wanter_remark` VALUES ('25', '1', '2017-11-25', '放寒假', '8', '0');
INSERT INTO `wanter_remark` VALUES ('40', '1', '2017-11-25', '大丰收饭店', '10', '0');
