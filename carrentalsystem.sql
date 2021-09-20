-- MySQL dump 10.10
--
-- Host: localhost    Database: carrentalsystem
-- ------------------------------------------------------
-- Server version	5.0.17-nt

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
CREATE TABLE `admin` (
  `USER_NAME` varchar(60) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `ID` varchar(30) NOT NULL,
  `ADMIN_ID` varchar(30) NOT NULL,
  PRIMARY KEY  (`USER_NAME`),
  CONSTRAINT `fk_1` FOREIGN KEY (`USER_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--


/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES ('anfanzhen','谢冬青','152822200607164363','1'),('baishuiqin','萧念萱','542331201304272603','2'),('baizhonglin','苏采灵','440000199307302728','3'),('bianyuchen','余雅晗','152200201501122273','4'),('changweiyang','花淑华','230601201710266130','5'),('douanbai','鲁淳美','440105198504111851','6'),('fengleshuang','郝汝鑫','140425199211063214','7'),('fumenghan','褚晨涛','440801199411165073','8'),('gexiafu','凤乐霜','360202199707271688','9'),('haoruxin','葛夏芙','35062319720726082X','10');
UNLOCK TABLES;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

--
-- Table structure for table `hirer_of_vehicle`
--

DROP TABLE IF EXISTS `hirer_of_vehicle`;
CREATE TABLE `hirer_of_vehicle` (
  `USER_NAME` varchar(60) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `SEX` int(11) NOT NULL,
  `ID` varchar(30) NOT NULL,
  `CREDIT` int(11) NOT NULL,
  `FREQUENCY` int(11) NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `TEL` varchar(30) NOT NULL,
  PRIMARY KEY  (`USER_NAME`),
  CONSTRAINT `fk_2` FOREIGN KEY (`USER_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hirer_of_vehicle`
--


/*!40000 ALTER TABLE `hirer_of_vehicle` DISABLE KEYS */;
LOCK TABLES `hirer_of_vehicle` WRITE;
INSERT INTO `hirer_of_vehicle` VALUES ('penghanhan','鲁淳美',1,'230200198611225496',100,0,'qishuhui_nvt@aol.com','13771965501'),('shimilv','李含香',1,'500241201111117058',100,0,'youchunqi_guqo@163.net','13821199734'),('sucailing','李夫子',1,'513424197304072749',100,0,'xueyinger_fh@0355.net','13899783364'),('sucailing2','吴曼云',1,'130902200810263783',100,0,'miaozhiqiao_lxtxw@aol.com','18783399582'),('sunguodong','谢文轩',1,'510108197305123609',100,0,'haowantao_kkr@yahoo.com','17003073670'),('weizehui','章若雁',1,'320829197001128392',100,0,'lerongshan_ffuk@qq.com','17733081088'),('wumanyun','施觅绿',1,'533324199303254556',100,0,'mujiahao_de@163.com','17183096043'),('wushujun','蒋易轩',1,'411303198802055468',100,0,'shiqiaohe_ezji@yeah.com','18982532202'),('wushujun2','苗润丽',1,'610404197310098334',100,0,'yinchenxi_zuj@263.net','17146037857'),('xiewenxuan','柏水琴',1,'142232199601193158',100,0,'langyuchen_smew@aol.com','17783014776'),('yangjingyang','孔熙涵',0,'421127200907086545',100,0,'mengchusong_tssrt@qq.com','13792733925'),('yinchiliu','穆静露',0,'130981200008118138',100,0,'lifuzi_ykc@163.com','13548886333'),('yunxiaonan','杨靖阳',0,'430381201710034754',100,0,'fangjingying_iennb@yahoo.com','13225521299'),('yuyahan','褚紫岚',0,'370100197509277610',100,0,'tangzixuan_rnkxd@163.net','13897180021'),('zhangruoyan','孙国栋',0,'445101200503052609',100,0,'renbisong_zij@yahoo.com','18729366965'),('zhangxiaodie','潘亦菲',0,'362321201601057970',100,0,'kangtianhao_o@ask.com','18762957799'),('zhechentao','邬淑君',0,'130921200102136379',100,0,'wuyuze_yjnpm@aol.com','13808439179'),('zhengmiaocui','尹痴柳',0,'632122198105189620',100,0,'shiqiaohe_qnww@aol.com','13200416765'),('zhezilan','彭涵涵',0,'52011319910326865X',100,0,'buqingyan_wkpp@qq.com','17002398610'),('zhushishan','卞语晨',0,'230421198704102551',59,0,'haoruxin_pyjoj@163.com','17713203139');
UNLOCK TABLES;
/*!40000 ALTER TABLE `hirer_of_vehicle` ENABLE KEYS */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `USER_NAME` varchar(60) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL default '',
  `LAST_TIME` datetime default NULL,
  `TIMES` int(11) NOT NULL,
  `STATE` int(11) NOT NULL,
  `REGISTER_TIME` datetime NOT NULL,
  `USER_TYPE` int(11) NOT NULL,
  PRIMARY KEY  (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--


/*!40000 ALTER TABLE `login` DISABLE KEYS */;
LOCK TABLES `login` WRITE;
INSERT INTO `login` VALUES ('anfanzhen','f3d866e70213583e290d607cd2cb67c0','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('baishuiqin','0ff2b59c0e20952fa483b6bc4fefb309','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('baizhonglin','7f45ecd81bda9719457c706819f82546','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('bianyuchen','2e935275ef5b98d690c22729adc59c64','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('changweiyang','c764f79980cfa0dc62bd640a4fc3b8fc','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('douanbai','12889c2db0b7f018270671c9935b4952','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('fengleshuang','b29ae399c23ae186f9a4a16bf098c149','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('fumenghan','331c0226ce71a97026d8ab0f20f92a8b','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('gexiafu','9fc458d5a8edcdbd48d365a792af51f0','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('haoruxin','17f030eb9b277e14c2230652f6a1e0a8','2021-09-13 22:25:41',1,0,'2021-09-12 22:25:56',0),('hejingdie','299c8f8e6e1820e138962f6314c8f069','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('huashuhua','7764aca363de76d30794b35edd681e44','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('huaxinxin','a3096bcf04af06c43bf1988cb956ccd7','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('huayuanchun','3f20d7bb184c33967afc1f9fded3771d','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('jiangyixuan','d19cf6d833d339054c1235bbf49f8e9e','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('kongxihan','e0f119d6b7a55e21da58cc648438191d','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('kongxihan2','04676ac1e20ee2a4b5de5fd582ecd006','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('leiyanxue','79241e2ce49e3e70adb380fafe8a79ab','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('lifuzi','ce27b804107c397e5b0a112d1be079c5','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('lihanxiang','2aff188c988355c41215451a23db056b','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('liujiayi','56665307e0c2609f0236dc2faf821710','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('luchunmei','c2e181e1e5501375e01716958e99334c','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('luchunmei2','e482810b1c0a52e45b87c37c582c5274','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('luxiangman','f52c1d191ab88d153d7fc817deae50f2','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('mengjiale','0e225dc00b5731fe65922c2651ff6b03','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('miaorunli','184003850086273d881dc221905d898b','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('miaorunli2','bb3602e1b24b562456fe0ed7937fb93a','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('mujinglu','d6ac6ffab33d7b2a836ad6c397d683d7','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('panqiuyan','b00e64a9bdf7f28833b8ea42c1732d01','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('panyifei','299c8f8e6e1820e138962f6314c8f069','2021-09-13 22:29:34',1,0,'2021-09-12 22:30:09',2),('penghanhan','43d40a5b5805e5c5530fe8b51132ff54','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('shimilv','e0f119d6b7a55e21da58cc648438191d','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('sucailing','5039aee930689a7ffc8fb72e32b41391','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('sucailing2','f52c1d191ab88d153d7fc817deae50f2','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('sunguodong','205d05f4356d60e63e3a9939a19777ca','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('weizehui','760129e97607ccd31746b433853ce8bc','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('wumanyun','4cd84e281e409879656c1b444373e40e','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('wushujun','6c8bd96777d752ab05a63e4c75f217d4','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('wushujun2','fd72dc221162c40acc94088000317ac1','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('xiewenxuan','b45c52ccd2cdaf36e0cd1f2d6b848073','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('yangjingyang','306141cb3e8bd58a135823b6cdb330a9','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('yinchiliu','8c2017f24e73b23ddc5e7aff0e386b97','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('yunxiaonan','caa8bd5dbdf621b9a57a3b2a3ecfbea6','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('yuyahan','59a4204f7b8b560d87e7a0fc9bf8a023','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhangruoyan','c5f928d7e0ddf9dce1937813290d0588','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhangxiaodie','79241e2ce49e3e70adb380fafe8a79ab','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhechentao','41f7be8f8b61864d0277d91c2419dd29','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhengmiaocui','108e26d68b3a8896e9a8754b68a945c0','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhezilan','e016b19cfe1b883ca780f0c064f786f0','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1),('zhushishan','5b2ea4edb4012d54ed39abd0bd623020','2021-09-13 22:27:28',1,0,'2021-09-12 22:28:08',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MESSAGE_ID` int(11) NOT NULL auto_increment,
  `SEND_NAME` varchar(60) NOT NULL,
  `RECEIVE_NAME` varchar(60) NOT NULL,
  `DETAIL` varchar(255) NOT NULL,
  `SEND_TIME` datetime NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY  (`MESSAGE_ID`),
  KEY `fk_5` (`SEND_NAME`),
  KEY `fk_5_2` (`RECEIVE_NAME`),
  CONSTRAINT `fk_5` FOREIGN KEY (`SEND_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_5_2` FOREIGN KEY (`RECEIVE_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--


/*!40000 ALTER TABLE `message` DISABLE KEYS */;
LOCK TABLES `message` WRITE;
INSERT INTO `message` VALUES (1,'anfanzhen','baishuiqin','开发UABUIHODIHVLIAHSLIF发耐萨里奥回复你哦急哦麻烦ven浪费那钱·1法海配合哦IQ·节操i解放后打篮球时哦好的我i啊hi哦啊皇帝瓯海区哦i后害怕foi啊红披风和气魄嗨皮哦后viahi哦粉红色起哦','2021-09-19 20:33:39',1),(2,'baishuiqin','anfanzhen','反倒是咖啡馆WIUGFOEH情感；·和次哦暗黑风哦IQhoi；和我到碗里的行情布林布林·','2021-09-19 20:34:03',1),(3,'anfanzhen','baizhonglin','而父亲的分红i为HOIDH·1FSOIDHFOIQLEWIODHOIA你视力恢复','2021-09-19 20:34:36',1),(4,'baizhonglin','anfanzhen','案发时覅去ghi哦','2021-09-19 20:34:57',1),(5,'anfanzhen','baishuiqin','11111','2021-09-19 20:34:36',0),(6,'anfanzhen','baishuiqin','风情地方·1','2021-09-19 22:17:32',0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL auto_increment,
  `OWNER_NAME` varchar(30) NOT NULL,
  `HIRER_NAME` varchar(30) NOT NULL,
  `START_TIME` datetime default NULL,
  `END_TIME` datetime default NULL,
  `VEHICLE_TYPE` varchar(60) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `AMOUNT` double default NULL,
  `VEHICLE_ID` varchar(30) NOT NULL,
  `VEHICLE_BRAND` varchar(255) NOT NULL,
  PRIMARY KEY  (`ORDER_ID`),
  KEY `fk_4_1` (`OWNER_NAME`),
  KEY `fk_4_2` (`HIRER_NAME`),
  CONSTRAINT `fk_4_1` FOREIGN KEY (`OWNER_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_4_2` FOREIGN KEY (`HIRER_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--


/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
LOCK TABLES `orders` WRITE;
INSERT INTO `orders` VALUES (1,'hejingdie','penghanhan','2021-09-19 16:00:45',NULL,'捷达',1,NULL,'京A·0085B','京A·0085B'),(2,'huashuhua','shimilv',NULL,NULL,'GLK级',0,NULL,'京A·012E2','京A·012E2');
UNLOCK TABLES;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

--
-- Table structure for table `owner_of_vehicle`
--

DROP TABLE IF EXISTS `owner_of_vehicle`;
CREATE TABLE `owner_of_vehicle` (
  `USER_NAME` varchar(60) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `SEX` int(11) NOT NULL,
  `ID` varchar(30) NOT NULL,
  `CREDIT` int(11) NOT NULL,
  `FREQUENCY` int(11) NOT NULL,
  `TEL` varchar(30) NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `INCOME` double NOT NULL,
  PRIMARY KEY  (`USER_NAME`),
  CONSTRAINT `fk_3` FOREIGN KEY (`USER_NAME`) REFERENCES `login` (`USER_NAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `owner_of_vehicle`
--


/*!40000 ALTER TABLE `owner_of_vehicle` DISABLE KEYS */;
LOCK TABLES `owner_of_vehicle` WRITE;
INSERT INTO `owner_of_vehicle` VALUES ('hejingdie','华欣欣',1,'370829197711109670',100,0,'13771701654','binianer_bgi@live.com',0),('huashuhua','窦安白',1,'654000197005203381',100,0,'13392232896','yuzuiping_cywfv@0355.net',0),('huaxinxin','贺静蝶',1,'350300200001167041',100,0,'13532845493','douanbai_cwzen@msn.com',0),('huayuanchun','花元春',1,'370687200009274569',100,0,'18954603561','yangyiran_wg@163.net',0),('jiangyixuan','柏忠林',1,'340201198608214552',100,0,'17197352519','liujiayi_mb@163.com',0),('kongxihan','韦泽惠',1,'320483200010209099',100,0,'18943645822','zhushishan_l@3721.net',0),('kongxihan2','郑妙翠',1,'532701197011099109',100,0,'13399657330','gexiafu_yjp@aol.com',0),('leiyanxue','安凡真',1,'452231200108282028',100,0,'13370306616','lexixia_zdf@yeah.com',0),('lifuzi','柳嘉怡',1,'450325201206072332',100,0,'17151905438','yunxiaonan_svnbo@aol.com',0),('lihanxiang','雷雁雪',1,'513434197706130924',100,0,'13392644899','shenyichen_h@263.net',0),('liujiayi','苗润丽',0,'230712197312294772',100,0,'17718351296','weihanqin_zwin@163.net',0),('luchunmei','苏采灵',0,'654224200605307981',100,0,'13854318049','youchunqi_jr@msn.com',0),('luchunmei2','鲁香曼',0,'513825200007192907',100,0,'13203772464','tengxiaoyu_gikb@qq.com',0),('luxiangman','孟嘉乐',0,'520328201202232818',100,0,'13110203568','langyuchen_jbbdb@aol.com',0),('mengjiale','张晓蝶',0,'22020020110602678X',100,0,'13851654604','cendandong_xcwe@263.net',0),('miaorunli','傅梦菡',0,'220623197202270907',55,0,'13186026932','huangleqiao_lhpiq@ask.com',0),('miaorunli2','孔熙涵',0,'522428197801072930',100,0,'17020917929','shijiayu_rn@qq.com',0),('mujinglu','昌伟洋',0,'131100198405100053',100,0,'17047683248','pingchihai_fjd@263.net',0),('panqiuyan','云小南',0,'532823198208245307',100,0,'13377489360','zouwenjie_sdyr@yeah.com',0),('panyifei','潘秋雁',0,'362523201612295249',41,0,'18703650381','wumanyun_oq@msn.com',0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `owner_of_vehicle` ENABLE KEYS */;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `VEHICLE_ID` varchar(30) NOT NULL default '',
  `VEHICLE_TYPE` varchar(60) NOT NULL,
  `OWNER_ID` varchar(60) NOT NULL,
  `DURATION` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `RENTAL_PRICE` double NOT NULL,
  `DEADLINE` datetime default NULL,
  `LOCATION` varchar(255) NOT NULL,
  `PIC_PATH` varchar(255) default NULL,
  `VEHICLE_BRAND` varchar(255) NOT NULL,
  PRIMARY KEY  (`VEHICLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle`
--


/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
LOCK TABLES `vehicle` WRITE;
INSERT INTO `vehicle` VALUES ('京A·0085B','捷达','hejingdie',3,2,10,'2021-11-30 23:22:58','云南省西双版纳傣族自治州勐腊县','carImage/dazhongjiedanew.jpg','大众'),('京A·012E2','GLK级','huashuhua',3,0,77,'2021-11-30 23:22:58','四川省攀枝花市东区','carImage/31.jpg','奔驰'),('京A·01660','捷达','huaxinxin',3,0,15,'2021-11-30 23:22:58','福建省漳州市东山县','carImage/dazhongjiedanew.jpg','大众'),('京A·0431B','卡罗拉','huayuanchun',3,0,40,'2021-11-30 23:22:58','山东省济南市平阴县','carImage/151.jpg','丰田'),('京A·06426','GL8','jiangyixuan',3,0,32,'2021-11-30 23:22:58','河北省保定市雄县','carImage/bkakw.jpg','别克'),('京A·07B75','福克斯','kongxihan',2,0,40,'2021-11-30 23:22:58','湖南省益阳市资阳区','carImage/171.jpg','福特'),('京A·08CB6','C系','kongxihan2',2,0,60,'2021-11-30 23:22:58','山西省临汾地区蒲县','carImage/29.jpg','奔驰'),('京A·08EC2','凯美瑞','leiyanxue',2,0,26,'2021-11-30 23:22:58','甘肃省甘南藏族自治州碌曲县','carImage/152.jpg','丰田'),('京A·0A428','G级','lifuzi',2,1,508,'2021-11-30 23:22:58','河北省邯郸市永年县','carImage/benz-G.jpg','奔驰'),('京A·0B9D2','赛欧','lihanxiang',2,0,75,'2021-11-30 23:22:58','河北省沧州市','carImage/saiou.jpg','雪佛兰'),('京A·0BCB8','普拉多','liujiayi',6,1,51,'2021-11-30 23:22:58','重庆市潼南县','carImage/147.jpg','丰田'),('京A·0C433','Q3','luchunmei',6,0,45,'2021-11-30 23:22:58','辽宁省丹东市振兴区','carImage/AUDIQ3.jpg','奥迪'),('京A·0D2DB','野马','luchunmei2',6,0,88,'2021-11-30 23:22:58','吉林省四平市市辖区','carImage/sailinyema.jpg','福特'),('京A·0D578','C系','luxiangman',6,0,56,'2021-11-30 23:22:58','贵州省贵阳市白云区','carImage/29.jpg','奔驰'),('京A·0D8B3','汉兰达','mengjiale',6,0,39,'2021-11-30 23:22:58','江西省萍乡市上栗县','carImage/147.jpg','丰田'),('京A·0DDBF','昂科拉','miaorunli',6,0,30,'2021-11-30 23:22:58','广东省湛江市麻章区','carImage/78.jpg','别克'),('京A·0EC49','C系','miaorunli2',24,0,61,'2021-11-30 23:22:58','广东省阳江市阳东县','carImage/29.jpg','奔驰'),('京A·0EEE3','GLK级','mujinglu',24,0,78,'2021-11-30 23:22:58','湖北省黄石市','carImage/31.jpg','奔驰'),('京A·0F700','CC','panqiuyan',24,2,16,'2021-11-30 23:22:58','四川省成都市锦江区','carImage/106.jpg','大众'),('京A·11C0C','迈锐宝','panyifei',24,0,17,'2021-11-30 23:22:58','新疆维吾尔族自治区巴音郭楞蒙古自治州','carImage/309.jpg','雪佛兰');
UNLOCK TABLES;
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

