-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_rat
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `tblcargo`
--

DROP TABLE IF EXISTS `tblcargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblcargo` (
  `id_cargo` int(4) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `salario` varchar(15) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  PRIMARY KEY (`id_cargo`),
  UNIQUE KEY `id_cargo` (`id_cargo`),
  KEY `nombre` (`cargo`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcargo`
--

LOCK TABLES `tblcargo` WRITE;
/*!40000 ALTER TABLE `tblcargo` DISABLE KEYS */;
INSERT INTO `tblcargo` VALUES (1000,'Lider de proyecto','20000000','Activo',1000),(1001,'Analista de requisitos','10000000','Activo',1000),(1002,'Programador','6000000','Activo',1000),(1003,'Analista de calidad','6000000','Activo',1000);
/*!40000 ALTER TABLE `tblcargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblempleado`
--

DROP TABLE IF EXISTS `tblempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblempleado` (
  `id_empleado` int(20) NOT NULL,
  `contrasena` varchar(60) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `id_horario` int(4) NOT NULL,
  `fecha_n` date DEFAULT NULL,
  `telefono` int(13) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `estado` varchar(8) NOT NULL,
  `id_cargo` int(2) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `id_empleado` (`id_empleado`),
  KEY `id_cargo` (`id_cargo`),
  KEY `id_empresa` (`id_empresa`),
  KEY `id_horario` (`id_horario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblempleado`
--

LOCK TABLES `tblempleado` WRITE;
/*!40000 ALTER TABLE `tblempleado` DISABLE KEYS */;
INSERT INTO `tblempleado` VALUES (1000,'1234','Mateo','Leal',1000,'1999-12-15',2937152,'Cra 16b 32-50','mateolegi@gmail.com','Activo',1000,1000),(1001,'1234','Daniel','Arboleda',1000,'1999-02-20',2342341,'cra 23','arboleda.daniel@gmail.com','Activo',1001,1000),(1002,'','JuliÃ¡n','CastaÃ±o',1000,'2000-04-12',2347345,'cra 65','castano.julian@gmail.com','Activo',1002,1000),(1003,'','Mateo','Ortiz',1000,'1998-12-20',5525443,'cra 75','mateito.ortiz69@gmail.com','Activo',1002,1000);
/*!40000 ALTER TABLE `tblempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblempresa`
--

DROP TABLE IF EXISTS `tblempresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblempresa` (
  `id_empresa` int(4) NOT NULL,
  `nombre` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `logo` blob,
  `estado` varchar(8) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblempresa`
--

LOCK TABLES `tblempresa` WRITE;
/*!40000 ALTER TABLE `tblempresa` DISABLE KEYS */;
INSERT INTO `tblempresa` VALUES (1000,'RAT','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0 \0\0\0\È\0\0\0…\Z\0\0@üIDATx\Ú\í˜[Õ™÷g\Ä#i¦„–„N ¡$`ñ\èJ0›nlSB\Ç` `À\Ø3*·\Ìõ\Ø3*cl\ã>#iØ„´u6„$›lH\ãÛ„°„M%•@„,il¨K1`}\ç½W\åJºUõ\ÊúÿžGO‚gF÷œsOyÿ\ç¼\ç}»º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 -\éöôñ·{‚\ÂÏ¼œð¶7 fóûÌ¼*™]Ù’Œ¥³‘D¦%Ÿp\"ýF$žù[8žþ]89ù\ÕPrr,2šZÝ´o§¾´\È\èV4‘ù\ÏH<ýZy{]=¸9{\Ô«³{Î’²\Ú÷iü^fÿûmo0|R«\êsWl\ëI¬\ìÿgþQ^Ÿ\Å\Ñ-\Ùc/\Í\î}†\Ýú\ìš\'¼\è\áø\ïx8ñ4L[\0\0\0\0h[¼i\Ø\È\à9cñš–‰[Ÿxz\'&?\n\ÅS·v’‰ŽŒŸ\Ì\êþŽ^›XôqU\Z¹œð\ÆT.òÁf\×g0±\í”p\"ó¶^}®o\ÎúBG÷ô¶gVd&f/\0\0\0\0´ûù§y9ñM=#g¯~);0’v·\0)#™7CÉ‰„,¯›¾«¿·P|òKF\íp\Â\ÂXmÆ­Ÿ¿·ùõ\É|Ç¨>¼h5‡þ\çÛ˜Á\0\0\0\0\Ðvxýƒ§8‡7\Ü>\â£\Ô]\ë…ÁDú¶%\ã\ã{\ìº$ó´Qý<keM†mO@øU³\ë\Ã\Êý’Q}H»Á\à\ïYrvÿ3\å\êO—\ê\îŽ%¾„\0\0\0\0m\Ç\Ôþ¡£Œœƒ\æ\Èm)@ŠB$óÄŠ±ñ]\ÒW>’H=nT\ï÷\Ï[Y£q+<\Úbø[i\ä~Þª?]z\×Æ£©ByB±töªM\Ù—Å©­ZZ>\Ì`\0\0\0\0h?-Úv¼œ%\Â\Ö6!\é7Â±\ÉKw92:¹Ê¨Î³®[S£a\ËG!@„—=Á\è%T¶P|œ‹$&Ÿ\Õ+\ÛÕƒ›²œ5\0\0\0\0\àŠ¨\ã	ˆ\×\Ý>Uöö\áñ¶!Ê®urR\ê\Êf»w•w6˜HL‹$3\é\Õuù\ê‰\ì\á\ç\rWi\ÔJ?\èš!{;]€ø‚\á9\Úò…‡6Ž§_\Ö+\ß\ÍÒ¶\ì^§C€\0\0\0\0\08\Â7;z€“®óôIk\Øÿ®\×\Z9û\Î\ÊÎ¸<ž=k\É\Ú\ì\Ü%\ë,ýK\î\Üø³j>n\ßð\Ûo½\ç¹ónYÿ\"{\Î;ô,\ås\Ó\Ú\ìü¥\ë·—›Å­U_Œ\'\Ó÷É²<eWyg¬.ï‰ŒN\ê\Õup4•=\ëÆ»Š»ú\å\Ý[Q—Z\ÈqF\æôs\äù«¿Cý<ÿaß³‘þ\í„E£¿œu\í\Ø†c“7,Ý°aªR¸yK§²Ÿ\ßpð\\ùß™?ò\ËÀ5\É\ïÜµzb#ûõù\ÏŸ\\5\å O\ßUÉ¬\Ñ\0\0\0\0ƒ™\Ñce\è×¥\03d¯7 \\\ä	Ÿ¦\Ü\Ú\ç\ï9K\Ì¿p4{\ám÷d—­šp&DF\'V\îJï©ž®X”¦eõ¨A€\Ôú\ì\è\Èú\"ñôS:\Ï~ò\Ôk\âÇ±g<¥\ã¦ödo\ß\Ðþ\í^w\0\0\0\0\0=\æ¬ð±\ç®dŸ\×\Ë\ËB‰öN¿~Mv`Ä¾Y1–™¿+¼£EÛ·\ï‰gž\Óu9‹§²ûŸ9\ä4\É\Ý\ã\ìk[\â¦f\ä\ÞDŸ=ûÅfw5j\0\é/=û\èW=k\è¦\Å	Ÿo÷º\0\0\0\0@€˜\à\é—\ßÏžÿE\Ý©\Ì\Ø^p\Ç=v“¾\Z\Þt\\»¿£\è\È\Ä<£:^~\×\Æ\êB»øµ¢.\ì<hT—\Ã\Î[õ‚a\È`Žÿf\í\Ï\Îü\Í\è\Ù{Ÿ!½k\ÜV\Â\ßÚ½\î\0\0\0\0\0 \Öt{¼¤oŠ\Ùþ\ë\íen\ÇÓ¿k÷<!HF\Ø\ä\Ç[R&Ã‰Ì«:¡”_\í»:~¡—^\Õ\Éþj¯_¬YH¶\Úª•u\0\0\0\0€\0±‰/(]ÁŒ°·õ\Ê÷\ÑKc\ÙÁ˜õEõP<uK»¾ŸC[÷g\ê\Ûzõºc\åx\ÖWe~\n&\â^\é\ê—{[#¨\î9$2š\ÚN¤¡ýú7ú™‡\âõK¼\á\å\Ãþ?ý[=ž\ë†;­ª;\0\0\0\0\0ˆ“2…[\Êøñ+“v\\±þ²bl\Ì×Ž\ï\'2š^aT¯9K\î®--\']\×I}—À\0\0\0\0 @\ì\ÒMQ²ŒÜ±(J–UY)¾\í^N6\ÛNf~k\àZ–=x®y&ô_™07¬9\é‡  \0\0\0\0\0 z\Ì\\\æñ\Ä\'ô\Ê9m–˜½I\Üfu\ä\åP<¾W;½~õDŸQ}®	m25˜)§\ËÀh\Ê2{wo@þ0\0\0\0\0\0ˆž`ô£²~dQ\Ì\Æ]‰\Ë\Ú\éÝ„\â™I£ºÌ¸\ÜüòyðZõ’>….6u\Ã\nˆwC€@€\0\0\0\0\0@€\è\"Oñ…Ÿ\äJ\È.Žl±*ó\ç\Ú\å½&\Ó(Œ°^=–¯žPò¢˜½»[Ä­\Ê\ï\Þ:4n•\ä]\Ç\É\ï\0\0\0\0\0\0€\0\ÑÁ\Z•÷D\ëS—\Ú%$odt\âF£zœÿ\Éõ¦\Æò\ÑŽ”üþ±ZD\ÄB€@€\0\0\0\0\0@€\èA\Ù\Ò9ñM½òÒ©ÀÀH\Ú\";úÄ™\íð^\Âñô£Fu8üüU¦\Æòü¥¥—òÞ±Á<\'H‡$ºƒ\0\0\0\0\0€\0©Šž ø\r£2_¶|£i™£‰t\Ü\í\ï$:²õx£ò/¶š\Z\Ê\ÓÏ”\Ë\ç%À\Ø\ï3\Ûô2úÎž>þP\0\0\0\0\0<ñ6³Ð³¦$™~À\í\ï$O­3*\ßUISC™~®÷wþk\ÆÌ\ì $C€@€\0\0\0\0\0@€\è\à›%eT\æc\æ¯6 ñ\Ìo\Üü>–n\Ø05œH¿ Wv:\Ù\Øûtó°º7òúño¶89ñrâŸº-\Ú\r\0\0\0\0\0¤Œ\Þ~ùx£2¿\ÞJ‹¬è™¿¹ù}„\â—•ý\â;\î±0”…GÃ±ô÷þþ¨VY„\ä•Î†\0\0\0\0\0\0€\0)c\Ú\ìÈ¾Fe¦s’z\Ý\ÕFr<ý QÙ™?b\åFµ8š\Ì\\mô÷Ý¶\Þ\Ê\Ðþ\"\0\0\0\0\0H93—yŒ\ÊLY\Ñ-N@v¸õ]ðk6\Ê\ÈN½r\ß:´\ÍÊ…\êµýüƒ\ÓdYöR\Öw\Ý`#©\ì^§›\Z\Ú;zû†ö‡\0\0\0\0\0\0€\0\Ñ\Ð7*ósd\Ó2‡™\ç\Ýú.¢±”lT\î~‹Œ\æ=~>U0´“©-F\ßsÚ•\æ—\Ø}Á\èr\0\0\0\0\0\rž@\ÄoT\æ#/XeQ\î\Ô\ãn|‹¶o\ß-’˜|V¯Ì¡x*{ÀYC\Éù„\Ì\Èø\ÉFõ§lñ\æ™\Ñ\Åß²¯\è†\0\0\0\0\0\0€\0\ÉNZd˜\rý’Q\Ó2‡\â\é\ï¹ñ=„\âg•ù\Ë7Z$~Y.\Z\Ø\ßý\Ô\èû9g\ØB\ÌDü  \0\0\0\0\0 9|Añ£2Ï½i­¹V2}Ÿ\ßC41¹Ý¨\Ì¹$f.úø\ÛË¿o01ñI£\ï;\ç\æu7?	\0\0\0\0\0¢\Ò\íõó\Ôß¹•\Ë\Ú\æ\' ©[\Üö–¯Y³]Ž\×+\ï\Ã\ÙÞ \é\åó7÷œ)\ïSþ²¼n:Eü\ÒûÎ»VOd§Í’\Ì\Âùþ\ß>§\É{B€@€\0\0\0\0\0t¼\0ñ\ÅŒs€[–9:²õx·½ƒhlr™Qy\ç,¹\Û\âÎ†ðY£\ï\r\ÇRŸ2úÞ“/[E\ÕZ\0\0\0\0\0\×•÷l÷«HbòŸ²,Oq\Õ\Èf»Y¹~¥\ë.Og\ß7o¥©a\Ü;K:\Ý\è«’©€Q[\\5¸\É*©\ác  \0\0\0\0\0-@<\\\èf¿¥W\Öý\Ï\Z\Ê\ÄReNÁm\í¿blü4£ò^\Þle?\Õ\Õe\"¨˜¸	\'2O‰›ƒ\ç\Ê™Ñ‡N„\0\0\0\0\0\0\èX\âõó÷\Z•õ‚[\×[–7¼jk¿\Û\Ú?šH¥Œ\Ê{\Ê\'\â9;ø°\å÷\Ç2†\î]7š»wyý\Ò\0\0\0\0€Ž \äj\ä\r\ï\ê•óƒ®¦ðº\æw?\â™\ßÐ‰€›\Ú^–\å\Þp\"óª^y—S\ÖòY¦w4\Þñ¢Y\n‘õ°g¼­÷ŒÛ‡Ç³¾€`ŽWügW¿\Ü\0\0\0\0\ÐQ„2Ÿ3cø£\Ì\çw¬\Z·,\ë`\"}›\Û\Ú>šL_oT^:\Ñ1?°ûœP|òKF\Ï9a¡Eˆ_Nº\0\0\0\0 c\È~þÁiNø…^ùöê—²7D·Z»^\Å2Ï¬ó¹­\íÃ‰\Ì\Ê|\äù«-Œ\âè¹¶…\Î\È\Ä<£\ç\\~—y’C_ü.\0\0\0\0@Gºt\î	?7ºt~Ct‹e\éÃ¯NŸ\ï¶v¿3±ùCF\å½I\Øjn\Å?wõË»\Û}Ö¢\í\Ûw\'\Ò2È‹’\ÝÿLó\Ë\èSûŽ„\0\0\0\0\0\0­ ñôÎ†Š?ÿq\'þU¯\\Gœ?œ½}xÂ–øˆ&\Ó¸±\Ý™5Feö_=f•£c•\Ó\çEc)\Ù\èyý×¯±2ÀG @\0\0\0\0\0@£Èƒ&\â\ãÁc[\Z¢µ7y/E_òr\Â\Û\åe\ÚçŒ¡\ìÜ›\Öfci{\â#žùG(~\Ï!nksY–\ßN¤ÿ®{We4•\Ýgö©1Lwbœ>“_³\éPzÏ¤\ìñ\æ÷@\Äçœ¸@€\0\0\0\0\0\0G„œ1ö£n]c-™‰5\"šTO¨7\Èž€øJyy˜#gg]7–]¾\ÚÞ©‡*’2oò«\'ú\Ü\Ø\æÉ‰F\å^x\Ç‹\Óþ[U\àñ\Ì7ž{\ìü‹\ç\n\çA€\0\0\0\0\0€úN\ÚF\âC\×`KNn«Y|,Z´›¯\à@o@>™ŒZo€—<~\á§ù\ç\ï;{({\è¹\Ã\Ù/U\\ƒÛ¼\çQyñ|òR·¶y8‘þ†Q¹?t±¹ð£—Tm€¦\ZŸ{\êu\0\0\0\0\0\Ø Nxqz¿<]\Ï`[¶j<;ýt©\Ä(ûè¥±\ìu‘Í¶]¢šò‰§w&R·»µ½ùÕ›?Nd\Þ\Õ+ûm2¹B™\æ\åx¡k\ÞÒ©\Õ>›\\¿\È-\Í\Èõk\ï²÷[M\Þ\0\0\0\0\0`[€ø8i½‘Á6wÉºƒ\ì¤\Ëb\îEññZ(žº\Ð\Í\í\ÍÄ‘hTþ3›_÷Ä»k~õ—\ß\íd^‡\0\0\0\0\0\0¶ˆ7À_hd°·`´\Ä »E\Ú\æ2ñ‘y.:2ñQ7·µ,\ËS\"‰ôõ]\Æ\Ò\Ù\Î2‡\Û?\\kj\nÿ\àŸ\ìÊ¹\çA€\0\0\0\0\0€šˆ¯O.ð{Î”÷\Ñ\Zh‡œ3\\ø½½Ï\\\årI¦¶\Èò\Ú}\Ü\Þ\Ö+\Æ&\Î4ª\Ç+6Z\\—~X¯r„™‡\r ^°\Ê\\qB?\0\0\0\0\0¨‹\0ñ\Ã\'\åÿ}\Ú\ìÈ¾†\äô!Wˆp|ò¿¢#\ã\'·œþ¼Q]>zI\Ì\Êý\ê\Úz•#šœ¸Ö¨Þ¶\Þ\"3ºp\0\0\0\0\0¨‹\0ñ£Ÿ02\Ø\èÂ¹+\\°\â\éw¢ñ\Ôý\áØ¶¹\ä\Ò\Ô.\íL\'4\ZX¯N\ËVMd§E³\Ë\ç¯t\ÍY\á«WYVŒù\Âñô\ËzeY>2‘\Ý\ët\Óp¼o\ìÅ…÷†\0\0\0\0\0\05¯Ÿ¿\×\È`»\à\Öõ-½„Š§~Jf¢Ñ‘um‰‰\"sÕ’+Z¸_m«wy¢‰\ÔV£òœvEÂ¼<A\áV\0\0\0\0\0P»\0\á\Ä7)G‡žÁ60’VrtT„\á\r7\'/Ej\ÛF\Îf»Ã±\Ì/ô\Ý\È\Ò\Ù\Ì[i!@\Äõ.Rxx\Ë£¶¾>²\Å\"‰ð³®6¼Œ\0\0\0\0\à6\Â>=ñ\ë]]ªkS…±œH½·§no@x\ÄÀ\Å({Mh³ù}Dú\ra\Õ\Æ\ÃÛ±\Ã\Ã§\ZÕ‹ò¨˜\Zû\á\ç\r1ö™(Š$\Ò?7E\ç7]A€\0\0\0\0\0t \0QDˆŸOu\ÍX²‡ž¡M¤RK\Æ\Ç÷¨\êY³\ÄS¼\Ã\Î]e}\é<9ù\Õvlc\Ê ¯6x3ô=nÁ\è“:í±ƒ‰µG}œðy¯?:¯Q\å\n\ÅS·\Zµõ9·¬µ\nÉ»\0\0\0\0\0\ÔE€\ä\îü\È$\çÆ(¤lU\Ïóó÷\Z=“\î™X‰~uúüvjßŠß”,19)EG\Ö@Ë™\ÐxYsªð\Z3\ì%\ß\ì\è\Í([8Û›N–ª¹O\å\îš!{!@\0\0\0\0\0@}ûX‰\êž=H5´+Ÿ·\ß\ì¡\ìŠ\Õ\ÏMÿQ–\Û\Çð$Æ¯)^¤\Ï<½lxü„ü\Ï|A\é\Zøx\ÚOhvù\Â\Éô}Fm}Ò¥¡¹\è\Õ \0\0\0\0\0À\ÕD5¼ù°\Ñ3×ŒY_J\\\Õ.\íŽ¥¿¯\ÞaÉ¼\Z–·Q\Òœðý\\h\ÛW{8ùˆ–\å\É\ÉYF\í|\ÕÀ&\"|\0\0\0\0\0¸^€tõ\Ë=\Þ\0ÿ½g’\Û\Ï\'¥­V\Ò\ßVm;\Ú\ím+¬\ÚrŒ&Œð-ÚŸ]°týmù:ŸsËº’ú-ºsCöˆóWY¸@¹\ã3\Í/\0\0\0\0\0\Ü-@”\ç\n=÷ø…£6f¾I‘œ\ÜÜ¶¡\äD\"w\ï\ã­\ÛXd4µ»vL©\ëžýRv\ÅHªP¯…w\Ü\ãz\ÑQš]JB€\0\0\0\0\0\0\×F·\Ç/~\×(,\ï•-Ÿ?œX\à\Öv¥Ha\áD\æ¯jYSÿªý\Ù@,ýû}\ÏPsª|dQiBÇƒ\ç\Ê\í%@\Â\ß(b\Z\0\0\0\0\0p»\0\é¢K\×Þ€ð®Þ³\ß?o8Š§­NAž“e¹×•\Æ\î\èøE÷«\äD\"ÿï²¼aOr±\Ê×“NBò¿·|õD[‰‚\áøù \0\0\0\0\0ÀõDy~\ßlôüsn^gY­q\ï&Â±\Ì×Šeœ”´\ä\ÃFu<\ãú5m/@\Ô\ä• \0\0\0\0\0 \rÈ´þ\åûy8\áE½\ç\ï}†¤\ä£0¿žy;2º\í\Ãnj\Óek·¾•\ë\Ýb\Åô}ùŸyf.{Ÿ7 \êH¡n\Û\Ù+—\ä]Oÿ\0\0\0\0\0\0p½\0QŒò>þv£2Ì¼*i}\nO\ÏM\ÒC\ÉL´\ÔU,ý”,\ËS\Ôö\æ£\Úútö\Êl8Vt5[pÇ†¶<ñú£\"\0\0\0\0\0hB—˜½œø\Ý\\A1{¿Õ²,\áX\êr7´\'	\r•¹K\Æ/b?\Â\êôTy\éNHe\Þ\Õm†·(@ø?Rý @\0\0\0\0\0€û\Ã\Î6*Ç±óG¬H\"ó<Ý¯hu{FG2§\ë—1õø>gsô/qw\Í[:µ\Õe_¶v­\'O¿¨W~\n<½_²JLx&\0\0\0\0\0h¢”%(~Õ¨,—ÜµÑ†+Vj]Ë\ÜX\ê3F\åû\àE«Ÿ6Î§!\Ü\ç†p¶‘\Ñ\Ô£òÏ¼2i.@\Â @\0\0\0\0\0@\Û©A\áhö\Üze9ø\ì•\ÙÁQ«°¼\éwVŒm9±UmŽ\Åö\'\Òoè•.Ó›»T	oÑ…üV÷‡e\Ã\ã\'µ\ïü«\Ëè®¨\0\0\0\0\0ˆm<qÌ¨<g-Yk\Ç\ë\áü…\ïfŠ§n5*\×9·¬m›Óƒp<ý¨Q=?•EbBþN\0\0\0\0\0\Ð6d\ï3C{Qvm½ò\Ð„;VŽ[–+šœ¸¶E\îO\Êt\È9\Ãms\"›¼Á¨\çr½EN\áW\ì+º\Ý\Ø\×!@\0\0\0\0\0 @ô\Ë”•\é”\Ë6NA\Ò\'w¨f¶ctdüd£ò,Žli«R”]>œÈ¼ªW—\å#©\ì^³,2£ûùC€\0\0\0\0\0€¶ ]‹\í\æñ?5*\×\â\è\ëSXfsS{žQY>~e\Â\ÜÀ\rò‚\ÛúE(‘ž0ªÏ©W\Ä\ÍOAü|\n\0\0\0\0\0´\0aôÌŠŒ\Êu\Ô«-\Ë‰§w†‡·\ÌhFRøZöÌ—Œ\Â\×\îe\Z¾Vx—²£»­_„‡\'N5j\Û\ë\"›\Í\rvNxµ«_\î…\0\0\0\0\0\0m#@º˜mT¶·\ßcC„d~ÔŒ\éÑ‘Ô•Fe˜¿t½Å¥mñk®\ì\Ùlw8–ù…®‹[<ýÀ¼•§:\Òb\0\0\0\0\0\ÐV\ÄÃ…ñr\Âze\Ûÿ¬¡\ìŠÑ”\éK\Zn\Ø&\'2zþ\ÑX·ü…n\íƒ‰ômFõšwó:+ò_ \0\0\0\0\0 ­H®|+\Êwúõkìœ‚ü\ïò5k\Z–›\"<´ù(£g\ß,m3?ý\à„¿¸!ù a\Ýj\Êk\"f{û\å\ã!@\0\0\0\0\0@[	®9+|^NxN¯|{Î’²·\r\ÙË›H5\ìRt469jô\Ü\àµk,ˆs{ÿ\Ç2Ÿ6ª\ßI—\Å-r›ˆ\ë\ÜT\0\0\0\0\0[x8\ér£2~ôÒ˜õ)ûð«·\Ô=4¬,Ë»‡™\çõžŠ¥³ûÎ–MÚ©ýCG¹½,o\Zµ\éUƒ›¬î·¼\Ð5o\éT\0\0\0\0\0\ÐV„\Ñ\í\å¤\Z¹Ù«C›ìˆŸ.Ú¾}·zŠ_>\ß\èy—.\ÛhqúÁ¯-:]F§gtý\à¹\æ—\Ñ=Á\è% \0\0\0\0\0 \ÝH—\×?xŠQ9;o\Ø\Ö)]ª®g™¢\ÉôF\Ï:~Á¨¹{R0ú‰v\é#‘\Ñô\n£z\ÎYr·EH^þ[ \0\0\0\0\0 \íˆZV~Ò¨¬ÜºÞŽy):²þ€z”e ¹ùÀH<ýŽ\Þsn_9žõq¦®Iÿ\ì\ê—{Ú¥¬Úº$žÙ¡W\×;X]{\Í/£\ï\ì\é—ƒ\0\0\0\0\0\èLº}œp&3\ä%\'­§Ö•\éƒóG²ý×¯\É\Î]²NùX‡¸\\OŸPrB¯JA\î:,¼¯\à@Jr§g \î;{({×ˆ°¼‰\Ì\Ãùr\Ó\'šœ¸c\Ùðø	vžO\Éù¢±\Ì\0ý3È¿YžœoÎwgû®JfozW|Š\Õc\ÈÎ¦w\â\Ú\Þ\Â\Þg(>qv(9)1±õ—r÷«O,ß˜=ƒõj{S7,¿ø]\êkž€°\Ì:±i‚ct«0‘Ž\äßµ¶üWnÎžy\Ã\Z\å}\Ñ\ÇJ€\Ç;no\0\0\0\0\0\î@ž\â\á„\Ï\Zd\ã\ÎÎ·“\Ø\Ïúó¹F\'þóøA##‘»f¬ªr3Qònd4s§©øHd†Œþž\Â[°\Æ.Jâ—º-\Ú\Ím½e\Éøø\á\ä\äWu]\Ùb©\ìqFª­\ï;Þ pk£\ËÏ„\ÓZ£÷\å¿z¬ú÷•ÿø\Å\ÜB\0\0\0\0 \åx\ÑËŒŒ©\\«‡ø\È}Æ¯ihE\æ-ªœ \è\åŠÙ›Å­Õ•›Ü©FÇ\Õ{dtdüd£¿[\ÙR»1Ë‰×»­¿&R·\Õy\îMkk¬³ðVOP8¼Qe¯\Ú\Úo¹k`S\íï«l±ñB\n\0\0\0\0 ˆð#Cjþ\Òõu \Ñx\êþF×…²‡\Õ\å¸£Õ—t\â.½ç‘‹™\Ñ\ßÌ¾aMYñ~·õ—P<ó£:ð¢\Õõ]\r\ËP?˜È¬i\è\é‡/\Ø\0\0\0\0¸O€p\â¿R—Þµ¡~\' \ÉÉ‡šPn\Ç\Ç(,\ï+6U)@&WµÂ ee~\Èmý…½\Ç\Õù\Ðó†k®³‹†\Z\'žRi£²Ÿry¼Ž\' \Òcf\0\0\0\00€L#F†\Ô\ì\Åw\×M€\ï}3\êC.<NxQ¯>Î‘³\ËVMT!@R\ëôUFs\Ñm÷\ÔnŒ»,cx3Œø\ÜE\î†MN,5*û¼›\×\ÖM€ôø	\Ì,\0\0\0\0\0P)\'¾dAjuªvO¿²l\í\Ö÷5MT#\ç°ò\ïÐ«Ó‡.\ÍŽ¦§\ÔOŒÊ²üžp\"ó„\î…\ì\ÑTö\à¹r-®H¯y‚ü\Ü\Ö_\ÂC›\n\'\Òo\è\Õùfi[vZ°¦; RP„F•½¯\Þp<õg½²/Ie\ß{–\\òz\'™\0\0\0\0À„i~á˜ž ø\r\ÊCQnPQF\ëË–o¬\ê\ä€ª/°\Ï×…U[Živ¼ÁðI¬ü\ßf†ü›\åu:\äœ\á\ì+6’\Ùi\\þ\Égi·_–\×M7{Ž’#‘ù\\y8\Ú|.Œ^\Z³G[š	]ƒöú\Å\ã\Ü\Ú_VŒm9‘\Õ÷ÁP<ýbyoˆn\Í3$;½_r\"¶þ\ä\åøô\Þg†öjt\Ù\å\r\ï\Å\'¿\Äú\å\ß\Ë\Ë~›<ž=aa,»ƒ÷U|oÊ©Ûƒ¾ xf\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ho<³\"3=œø’7 fsŸ\ì3‚–»þxÀø\0\0\ÐRzƒ\Â\Þ\0ÿ\'ü\Åˆž‹\é¼A^\Ð\Ê\Ç‡–Á¸\ï\Äòu\ÚxÀø°\'\0p:ir\Â\Û\å§\Ég§‡ÿ\ê\r²¿š\ZŽF+–µi@|ª\Ð^œðZ¤3\è	\n‡÷Ä¯³±ñp§ Þ€´…\Õû]M¿\Ûã—’÷[¾N<þw\éqÍ‰«\Ø\çM6’ƒ›3ý\Ò\Ø #ñ„\×4€8ñ¦Î·võË½h\Íü„Á?©iŸ?¹¤XÝ¾\Ù\Ñðvšf\ìu’\Ò\Í\ÆWuvÿ\Þnõ¨eŒ¸tÜ»¢|\'\È!@vw)¼e\×b\ïûk>4\â\á„Ï–lÈ˜‹·\Úy^ z.ö„ÿ§Q\Øo¨;8Ÿ ô_9E¾S;ˆz8á—ž ÿ´h\îÈ”ŸVOŠ\Üqd\êóKÿ©¾+i\Þú\×Wº±|aõ£Ÿh§:\Ô:F\Ü8\î\ÝR>\Ð\î\ï\Ò\Ê6\"\á\Ñ\Õ/÷ôÎ’N\ß\ç4yOO z™©-¥|Ÿú\Ý\í<¯\0\Ðô	³·oh&FV«\' ¹¿\å„_\à$\"\è¼öö¥K+vö‚‘sð\Î\0hówùºò.ý\ÂO-\çÁ€ø5eó% >aù»\ìûrý\äu´2ÀQÅ„\é\r†Ob÷La×““Ö£5± ¢½;\Î\àzP\Ç=óKxg\0´3ŽŸ\ï\rð“ž@\ÄoC€ü\ÎÎ©†ú½!Ž¾\×.B+,UN˜=³\"K\Ö¸baAD{wN{³…ôüø§SPöy<NJñ\Î\0\è±\â@€\0°\ËŠ§?‰gžˆ&2¿‰$\Ò?‹$2D’“E\ã™û\ÙÿŸŒ$Ó‰hrrY4>ye8™ž\Ë\'\Ò‹Œ\Þ{¬f\Â|¢+›\ív>\áò‹\ßÁß‰7\í\Ý\í\íõGEM}oóôñ·\Ý2ù»ð\Î\0€\0`\× cLh|…}>Ã„Ç¶p\"“d1š\Ì,\r\'\'/\'3søD\æ”p,}Ttdü yÝ½\ÓeyÜ«0mß¾›S\ÂD\Ç\Ç\n®~ñ¼	,ˆh\ïNhoy\n]Ì¹\\½¹\Þ{\Ú\ìÈ¾š\È1¿f¿Ôw†ñ\0 @\0Ø…L¤>M¦¯\Ç&—\Ð)OŸO§¡ø\Äq\áØ½‡EF\'\ß;˜\ÈL[ºa\ÃTY–wgŸ)$6J&L\È~þÁi\Å\ï~Œ7\á¾‘yüü\Ç\Ñ\Z0@ê…š$«0\î?“ÿw_@ø\\ñD<\rc¤T´\í}fh¯\éýòôü‡¢\æ`< ¾\0€¶‡Gd\Í\ä‡CññCš1a\Ò\"Z¼ˆ.|\ß\É\ßöpò¾\0?˜ƒù\ížR\È9fü\Ä\Ó\'­\É05\î¢\ÊSz\â,öŒµÞ ô\ß\ì;ŸW\î«(\ÙE…G)¢—/0tbe»H£¥!‡ù\'Œ_ÿÀì»ž\Õ\Æ÷ö\Å{œ/^Ñƒ(‰{\å\Ê÷\æ˜}\çH>O\å^a\ßÿ²rËº_\Ò/÷\Ð\îsÙ¥\à%\ê…:5ª‡\æÿ\Ó\ÌHT\\l\n\É*)¶¹4\\2\é\Î\\ö>JJ©¼??ÿGöœ×¼A~³-6y/ûý\ë\éÔŒ\Ê\Ë\Êñ\Õ\×Ç‰¿\ï	Š\ß`?û$}\ëF’<…R\ÖF	55½_\á-oPü³z‘“\Ö÷ú\Å\ã\Za€4g\\Ôº\à\nŸ)„\âf\ãKO˜ôø‰z¾_@šM\ãXi‡€ð7u³ñ\ÌI?¤~\ØüP\á\×g.óx‚|m4jŒ8\Z÷¬<¥¿[òùŠ\í1C\ãL\'©µK£\æ¥‡nºLý¾bþ¦ÿf\å¡SøŠº„/h\Þí›¬|Waü\×q©†\ã\ä÷°\ïü¹\Þ`¶Ã¿:ú®²·b«\ïú5ž\Û\Î¤¾\ã¶\îý©»$}ƒú\î>Ÿÿ!m°\Ð\Ú\ÍÖ„ÿ ä‰¹9ZyõB¿<\ÅxckðC4—«sºø\'\å\ï\âž ð3_@\\Gsº\Óú\Ó\Z }?ª]\'V<»_>^M>)ý(7.\ÞR\Ë ý€B-O\í8²nxM²š>Ö™ðØ‹N:dùÞžf\ÜEt\Õ\àðó)[\ß7´?\'\å9Eô>”avjÿ\ÐQ\Õ\î\ÒjB\ÞY}¾\Ò\Ó/¦7¡\ÛH?\Z0\ç\éö\'\Ó%{(&>¸N¢£²~¦fwù·º“WŸüÑŠÉ	,5\ê†\Îw3‘abdþ¸¬¿Ë——&m(f»I\èöœ)\ï£ö’<\í ;F\ÍN¤¨F)³\Óo”‰–\ròzŒ§f‹ZQ6\n}•²tñ’§°ûC®\r^éš³\ÂWóû\n.¸[e&¬\Z\'¹\è\\ü\Z5FœŒ{½gjþ\æÿ\ÌeÍ†À<“ú?S÷y©\Å\ã\æ[e“\ÈVb\\þ[Sƒ\Â\Ñ\å\Ï\Õ3’:vü\×q©Ê°Š\'˜\Íõ$PlV³\ÄSû‚´©H½\Æm#ú“b8W„]>¥lôñ·+†¬Õ¸a‚¾d³ˆ1­ù~\Ú\Ós‹¤9\éû´‘ ó¿\Ó\Z\é¬on·µ¾°¾E\î\ÆÕ¾Û¦\Ù?­\Z\ëtƒÜ««f&:Š	\Èø\Ö•ÿ©•‹<ÿG\Ú\ÑR’V¶\Â\Ë=ÁP\Ð~#,\ÚMiüŠ‰Ixƒ\ZY\ÝÁ¯¾\à\Ò\ÝZ\ä\Ë\'\Ç‡u¼m]ýò\îº\ÏcF-pN’iw\Ø\ï~±´¬ü“j»J\Ã\ì;ÿ%·\Õ\î\Î\Z¿/:ñ¡I\'ŸøˆýnPŠ+\íNõ\Ð$D¢I‡vGûFP¸ ‡ã¿©\ÍöJƒ¯˜¸­h@±2þ†Œ>O0z‰a_a\ï’ÿ\ÐJBKŠ¤¤3\Ñ\r”¦œzpbL/c­\Ú”ö|¦|B§\Ýø|ÿ¬v<5e\\\Ô	¯_¼¹h\ØEC•s\n-\Î	\Ò5\Õ>‡v\Ó\Ô\Ì\Â»œ\ï(÷O\ÔvyFg2ÿ²6‹p\ÃÆˆ£q\ÏúV@øŒ²¬ùÝž€ð+6o†m5{m”°\çý¶ï©›,\Â-už—Z9Øœ\ÈKzÏ¥<ô\\e/_\\i÷{–tV™\0yÞ¡=wÀ]zü\×y©r~\rŸVÇ€ø¦¦,¿¦]oG_\Å\Öb\Å`-–YYG”ó€|r;\Ú\Çmcû“:Freó‹ÿ–\Ûðù²Î¸ùš›\Ô\ÝýŠ9ü\Í|¾¨i~\á˜Ü‰vùß¿L\'º?\ã„Wm\Û\Ì¤$³\ê\Ü^Ú¯•S\Î\n›„\Ù3\Ê\é\Zw\ÚL«\Èlÿ\ÌT.òAÇ¶ró\ìŸŽu‡w8jÚ¡R”e\î\åp\Â\Û\Ú]õ\Ì	ý¥.\ìEû£b¹\Â#•HªšT“t–xªI®\äø]}\Îc´‹J¥\ÜÀa\ÒdhU\'\ë«Pœþe.]`£WÒ€©8º\æø»Œ¼­÷\Ë¬\êñ\Ô]rASwü\n\å}V)o¿\Üc]OéŠ¢;—º;®¸¿\ÅÊŽ»ÉµŽB•\ßÑº™p\Òu\r\\Cº\Ùdy_I\Ó5\'-ªH²I†`P¸I³\ÅúhwøœŒ§æŒ‹:\nü\î0{Ÿ\ä.P1\È5/7/8u\Ë,\å\'pl‚¦þV±ÅŒ\ÊBL§›\n6\Æa=Æˆ“qO®µ´Ü±}…û[\r¤V‡\îÜ®­\ÖÀÿ9%¼¬p§S\\é„‹ò\"2?v\ÈM£š\ç\î\Ê\ã¿\Ñ\ëŒ\ã\Ó:A/\Z£\×Wý=Š¡^0².\ìjºR\Í÷6k=¡²©¡Ø™A[z\Z™\î\r\È.[j\Èö•%/\'¼\èõž¢\Ý,¢5…Nz‚\Â\áZ»@¹k”—¸ ’Qí‡ª\ì]Ú”\Ð\Ú´V\Ñ\éS×¼¥SKú[\ãhs]+¤H\Ü9q\Éj¦ýã¶±\Þ\â†\ç”(l\Ö\éL;k¿ü~\í\ï\Ó\Î:ý›\Ù\ßÐ±kÀGŠDü½U\Æu\ÅPó\Ò\Ô\ÐÀ§A\ì\å\ÐNnqgK\Ùñz¥)Dsš`å§¬\ÝU)@j\è\\ô÷\äÞ m[2\nôŒO]\åÏŒ¤2\Ãð\Ëôn­þNyÿ\Zc‹vlò;œõ_ùÁ’~\î°\ì7l{ý\ÒÍ„øœ\ÓönÖ¸¨ŠŸl\á(]¼\ßøôLüjþ÷´®1vw¬”\Å@³)À&\Õ\åvÜ”\È\ÕIk: 5Œ\'\ãž\Ü4ùS~\âh­_>,/\îhw°Ë¦\ï¶\ãy©U\ãAÊ™\ÚH9a+_<u6\Ègº°¦\Ü\Ópö\Ü]}ü7zq¾,^\èÇœðxWwZh\ç¼0ŽŒ…]Y€4s=¡²Ñ¦d\Þ\Í]\á\él«ò©§T\Z·¦‚¬øÄ´þÈ±–c.\Èg4ÿ°“÷^rr\\8PNV¯µú\å>EÉ¦˜ð˜·Áf\Û?n\ë–/„”¨M\ÃNUgA\áS\åG\ßf®<¹—ð%f\æ2-ƒ\'y¯öØŠ.™%Š.(]\êl°õ|\å\Z:a\Ð.@\îHÒªMr\Ù\ç›.@¨Œ\ê\Îk~÷Žj•\nKh·º\äý\ÄuvÉ’­ xf\âø_Ú¹©«øPv.‹¡rZ\æH¼D\Ì|L[=.\ê\ÚVÌ¡ @\Ô#tý¾*\\ ñ-9\ëoše\×\È\Ù\ÎfO¨\Ö\Å\Ãm$÷û_+¶Oˆ³ý¿”¬\æô\Ä\Ñ	M‹\Æ¹5hw	™ø¸\ÚY¿‘Uó\ÜNÿ^gª²=8ñKš\Ýg\Ç.¶¥vH\ëN?\Ü$@š¹ž(§a©b¤QKñC¹¨^ƒ^¥y\ÛV£ôË»“\à,ˆ,n\Èz÷,\èô\Ü\îß«\'ó\Åw¢nŒ¹\Ëþq\ãX7!A\áVeg)SµSU~\Ôc2\áe_¼·\É\Ø0š‹\ê\ä?\çÔ€d\Ë\å\Zc\æ¯F.?Jô€bcŽU\×•¾Çœ0ò>žt¼gç¤¦x(ý Y$¿‹­F¢ÿ\ì\åøóm·‡Fa«\Ñ~œ¾’zÿ{ÑU\ÚÐ¨…ŽE«øŠ\îòch;\íÝ¬qQ7”c\Û\Üd\Ê	Ï™\îL\Ó\"¡D\ÝP\Êö¼\áý©Ê¿\ë¥\Å\È\îo2	6??¹Q€Ð†\æ\Ý\Ñ\ÖCf\È^\Å\Ï=·ƒW\î*P¯òµj<h]g«ú£uo³û\ÜNÿ^gª3d x	\Ú\Ñ&\'‘¿\Ã\Ð\ê\Ó·f¯\'JÙ˜‘«F\Ò\n\âhœ’KR\é\ÅtÙ¡è¿²Ô¨¯R€0\Û\×ù;)\æ¾Ë­m=n²Z?\Ö\äó\ÈMö\'°m™\ÍhQZÙ¿P¤)\Ïø¢6\Üe5¼ö\èK\ï´F=\Ò-^\Ú\Ñ\r¿i¶¨\ç£ø4C€h\ïŸ\Øñ\çVNyú¢|™e\Ãùß“û“¿Ë…\ä\Ë\ïD¿nul>9†\Ñ\\\È\ÛA\ß]—	^õM-ô\çò{BvQ’ðig[†O\ÆE}C~f\\¬´®Ÿ\Ê:¿Qqž½…E¼V{9\Õ\Úý\Æ`G\Â9ú\ÅÓ½œ\í’3|Sð{ò°Q\Îª]°í–¯U\ã\Ü´—2)\ÒZ5\ÏU\Ã\Â7Ê¬ž\Û)\ã¿\Ñ\ëL•tk£\Ù\ÝAW\ê£	~\Ó\ê\Ó·f¯\'%‘BlJ\æ7S´—\àõBZ›>›Í—\Úx\Õ\Åõ¯\Êõ¥\ä›­‹n²Z;\Ös\â\ÃI,r=òq¡\äw×¬…\Åb—†mJ\ìoõ>…2ÁW¹K[v21R©4‹¾\Ã«¶A/,m\Ú	{ñ\Úv¥÷P\Ï	¬^¤º{B\Å]Žž ?^k]J\"®9Ž\ëoP7MD\'ºøUS¿	Jq\ÛmÕ¤qQOh—2\ï›op‚\È\Ýu(ø½Ú›h5Q¯Ø»i†ñ\Ð2¢\é{6.Àw\Ó&@Ág\Ù\æý+§\åk\Õx`\ëÉšÍ»kyn©Ë‚\Ås;dü7z©Þ°*\îº+‘&\ío\Z\íp\Ë\é‡+HÖ“W¤*B\Åj#˜\Ùu+\n˜%{\ï¹¿¬F€Ð†NõýV\Ée\Úo[eÿ´t¬S\Þ%\ã\ã{,[»\Ýc÷…(\ÉO´w8\ÊOO\è˜F\ãsgjµ\âûsñº=~ñ»µ4…\Ö\Ó\\~ýj\å\Îiñø\Þnd[\êºÁ¤\"9\'¾CÍŽ\çv¢uK°ºœfË°\à\Âs5\á\ï­Gû”d\î®1¶š?À¦\áÓ¤qQ·…P\ÙÊ‰»›¨¿Wˆ˜ec‘¢c`\å’Ç—\×\ÛL€P4¥¼¿.Úš-\Â%\îj\Üý†”¯U\ãA\ÊÎ©º\Ýy\Â\ê¹3þ¼\ÎT\r’Å ¯\ÓI’e\Õhw®9ýpƒ\0i\ÅzRR¶*Njm³j\æ\í’\Ü@5\äS#ˆ£3º\Êþi\åX§„\áØ–½’÷\èð…ü\Ú\ì÷´ŽI¹\ÚM0¦„Id¹D©™0õ\ï˜X}\Ôø\ï\ÅD6•/§5§‰ëº•œ \Í ´S\Ü7p$E\ÃÑ´\ï\ÓJ\æd¿´A1P”ˆB\Â-Ú„W\í @\n\Æ\'ým²zj…!\Åô®“\0)du¥‹x5}¹\ï\åý’-w|›3.\ê]J¤±tiÍ‰«6$ <AtªJFEWi\Ö\Îf\Ëˆúwc\Å9XºÑ¸µ‰²œ\ç9p @Z2´s…\ÓÓŠ\ï¢H;öHÇŒÿF®3µVJÊ¼ ˆš¶›\è\à¼[E_\êrÁ\é‡+HúS­un¥\0Q\ïG\ÔünŠ÷ñ\\fÿ´l¬\Ë\ë\î.$ÿ\åH>‘9¥\Þ/Q\ë÷f÷²\Ån¦Å“\n§wLL2þ°b‡PM/¯vfU\'ºb¼\é¦*\n/§$p\ãÿ@—\é•2h|Šó®#\ßIü\é\Ö\nböj\'f\r\é—w/½«‹OÍ”ô›:”Ñ¶Ò¤qQ\'\Èý\çq\Å\Ï=(\É\æ\Öî‚¦½O•Ë´j\êß˜ûý›e<´R€¨Á?r}F\rGªoP\ç~‡B,6²|­\Z%sE­ó·r\Ï\Þ;\í¸ñß u¦(RP.ù›z©\×\äý—\ä±~\ÓQ¤ý©\Ùwu\ëO\ç\ïd¸\Òþi\ÅX§“\È\Ø\äiÑ‘ñƒ\êý•‹…‹C\Â[\ä\ãmc|>©“}1«võƒB\Ùý¸A§3?T¯´\Ü÷½\ÒT¢1öòY6)PI’ž’L\Ñs]/@ü\âw\ë¹ N´\ÂMJ¨A§—\Þwö‹1³k¹$\æ\ÔðiÖ¸¨‹H#÷Nú‘’Q¶<û´\ÓÀ³\"3\ÍûŒ\ZS^?U^n\'¢öiñ~3÷#\Ú\ì\Ñ\ì|\ÍodùZ5´\'Ø½}Cû\×òX:É°ý\Ü\Îÿu]gj7\æ¤MEw•è•º\ï•õ‹|\";7~¸A€´¢?µµ\0a}»\Öþcy\âû§yc„!G/Y2¾G$‘YŽ¥—…c©\ËÃ±‰S™ƒeys/\ÝQ.©g³ÝŽóJh&\n\n\rfm„R¶t%RÀU… ³kHj|yk½¢\î\È4\éˆ\ïdWR¦‰\ÎEq³møôµôˆ&N;ù/\ÖþŽ‡N$7z¿Nb[>šLºµ\r@Ê‹a\ß\ç½9\ã¢>ºð/J.˜Kö(¹$^\Õ\Âf‘°Ts\ÊJ‰\Æ:A€\ä2\ç/\Þ?Pn\Ô‹Ñ®]õQ[\ì	\í>\'yQô\ëª	“i-|0þ\ë°\ÎÔŠ’\è¶49g·NN¸ñô\Ã¤ý©½H	r5Øº\âbû§ac}ùšñý\"£›ö\åW§\r\Ç\Ók#\Éô–H<3IL^Š§ƒ\áØ½‡‘›\Ý!!\âô%ª»Kš| V\á5\Éï¬°k!~·F\Ò-\"\ÊX\Î¸I€\ä¡“Ú“;Ñ¾Z\Z‹‹^m\×ð´Õ¶š$l\Õ\Ä\ï\ÖÔ”A9/\\ù‰\Z\r\ÙòGœ–mÕ¤qQ+\ê‘~\Þ=‚¿«ºo‘§P\\úü$g–e·\äN{7 @\Ô\ÌB„«wµI>µc¨úöw\à\ÊÑ¢ñPy°º\\š\ç’Û\Í\Ë\àÿuYg\ê2¿týMDm˜c·~¸A€´¢?µ»\0ñ…;ª®»&\n–Ñ¼\ÑöO\Ý\Çú`\"3Dˆ,oO4™¹6š\È\È\Ê\'™Y\Z\Ë\Ì\ÇR3ò\"d\é†\rS«y‰¾\0?¨¹4ö«o”€¥–”ö:„&ž{@ü»\ÝKòº\"«_>^»#\×\ÈA¥\ì\ê¨Q@lŸS¬fM=²1\àv¶J€¨1ùUŸErÝ©E]“!LY@\ë½;^\ZOœÜ‹ª¼”¥\Æ5Ÿ‘3\Ø¶™ \á\ã¢\Æy!÷…º®\á{VjB^gø{¹h.¹£\íŸW»\ã\ï°l;[-@È‡[\'m7û÷ÿÎ‰±×ªÍ\áh\'µE\ãA¹£\Í\Ç\á4,§\å\"nPº†.šZ\nŸÿ^g\ê\ÙI …Hv\ë\é‡+HÖ“v ´®(yGj˜c´b™\ÒX¸\Éþi\éX\'\á!¯M\ï#\Ë\ã¦þ\Óª—\ÄJU\Æ%…MeB\àsÁ\"­ñ5{´—Ä­:%A«NÈˆ§)«c>ž|#U\áR‘\ÝögÂª\Ä@³®\ÏóùP\Ë\Í \Ê\ßú¥\r\ÅX\Ø\â7ª5()ŽviFÑºö›û‹Æ±ð¯Žw\×({7\ë\×ùx\ß4¹\Ù\ËüÜœqQ›q.<’£[‹o>]r\Ó\Ôõa“_\Õä»¨m—\Ên,üzŒ‘š\rVV\n\Å[ˆ\ÐB!zsn¹žM3dZ4J²ý\ÚHt©\×w\ÈP%£\nò‹·!:`ü7z©Ýšpÿ;ócµ\É%Ü³ @š¿ž´«\0Q7;¤a:m¦L\åNûm4\Ý\Í3Æ·\Âþi\éX§»ùP¼Ö¿{oO\ÕŒƒÒ¥šy½§?\ÔlbÑ†;T\îŽT™(\Çt\0RFG\í›A†J“<»˜¹’R<\í&Â¥/;—nKv‰l\ä} Pzù E¡\Ù„|%µ\Ê]I\È\ãpRøVm;1axB]wÞ˜Á\ÏqaGP—0o\éT\í¥?\ê\çj~%\â“\å‚ÛŒqQu»PÐ‰:\æ\Ñ^46\ÛÁ!ÿVms\Ç;ždRt\Ê=\âFš1F\êa€”fŽ?©M(UkN\'\åk\Õx q_Ø•ÿuhB	­]Hm>·\Æ£×™º­\áZ·f¼©F\\T¬:\ãv	f¯\'\í(@\ïõo‹\è¬\Ùýû\\”±_k&¸\Íþi\íX/fB\ß\Ý\Î\ï\Ö`\\vn\å\Èôß¬v@\Ë2­›Ž¿mÊª)¶óŽpÂf\à]\Õm\ÄòRV·\"¨4¹?hç••¯¯iD=µ6û]òƒÕ†4\ËP,ði«£\ÂF\nœ\áy&ƒ\ÅÌ¥ü7\íD*Sb¾ûù{KÚ¨AÙ±i\")yN\ßl\Õ\çHt³>ö˜f\Âÿ+Št‚f·­š5.ªZ 4>§NÅ¼¡¿Ø®¯©\Ï/­-!”À†8(\'v&\ÔzŒ‘z j¸]uœ(¡ŽsÿMó›m,´j<hE„òÞ•ñn13@¹J\æ}\Ö_\é\í\ç\î\â\ã¿\Ñ\ëLÝ  œð­\Û!“Ÿqóé‡‹HS×“¶½¢œ`ð#º2›\ÄÏ§¬\ê>­ù~Z›—õ\Ë\Û9ej¶ýãŽ±^žÍ¼\Æe\Þ@/¨ÁY\ÒY\æ“<0”„ñ\ÜAi\ì\évÅ‹$(ö}¬A¶(\'¼ªø\í\ÙDtŒ^r\Â&.O zY.¹Y¦i¡¢¤.\Ú\ßWTªzqö+\Í j‡¡dl\å‰Tª\Ö5…B©Ù™,(H€\æ¿À\Ôþ¼ò6°2\ì\êqI—-\ÊWi<]lV/+¾ªÝ¥;\à\Â\áªÏ¯zù¹Ð¿l\ìf\×@w\Å`ÿCa\ëJ|7-Úv\ï\ÉO_S›&}\ê\Ç=œ|„\êJ\Ãþ–²Ÿ\ÎX²‡µñÓŒq\á%\â•ø\×\Üøy±q\Ìs»G¯üüMû<E\'\â\ÖStù®bA\í—{©­i\ÑNô\ÊÎ“ð”fŒ‘z Ú¹‹\êD\âˆúG¤V‡n6·M–=÷1š¿+\æÅ™\Ë<d\ì÷„_•\ÌñZ\åR.\'ý\ÈÁœµKÿF¯3õ„N Š\ÉK)lhô\\7Ÿ~¸I€4s=i\ßK\èù)z‡“.×œ¸*\ÉúhÃº|\\\äò\Ô\Ü\Â\Ú\ç\Z›òv\ÒP´\Âþi‹±®\ëH?\Ð^À£˜è”¹\Ø\Ù÷3ôª\á\"…‡Í¢PQˆÄ¼\ÏuY\Üi\Ú\å|’Ž\Î)®²~O‹ˆ[šE‚|ûtþþm%Á r±S	?¶£ò9\äkM\â£I\ÅÎ®\r…*¥º—|ö\ßl15[„´nl7\0N|üi\Ò #¬|¥\ÎO\îfvV\í±l®ž#%Ÿ\ïi”\Ü,\çCýP=‘\ëðÿ¨\È\rÁ\\ª#\í(\ÐÂ­£úe\ZÀ\ì½kr.”õ\Ï\×\Ôc[\á-ò?žw)\Ò\Ï:q\çhÊ¸°½0\Ë\ÔwQ\Ì\ZK§!µ\n<%‰X‰\ÑÆžn2Ç¹\Ë\ë;õúŒ²`¨÷&v\ê´\És„Yuc¤†qo\Üö¿\Ög8—›¢º]ßš\Ë×²ñ@\"D\ÒÂ³¹¾ùL‰Û”:?½B\'Ùª–\"\Â\êML´Y\Ö\É\ã¿	\ëL\ÝPvšsý•N?\È%Óµw?‚\Â\Å\Ê\ÜQ2¾¤P žZNjW\ZÙŸ\è~•’?§¼\ÎL,\Ú<m¼²Æ¿¨\Öv-q•\ìRCgW¶J\"jf\Ër\âo+\ìDNüÓ´þÈ±nµ\Ü?\Ö)£b\á®C…þ¤“¯¢\ÝI\Ù$ñ\nM0ª‹E\å\ß\é&/£\Æ!õ\ç\Ôw. \Í.IGoúñ·\Ú\Ð´\Ð\å_¢Žeú\ÝÌ¨0\é,;.Á\è%•™*K?4pœ(o¥|\È{MÛuN}Rú7µ\n|Y”wo\Øÿ\ÊcPø”ý#\äú ºn\rp“ò½¡ø)kü,Kw9hO\Ü\îd\ámÆ¸°\ïùS\n\'cÚŠ\\œ\Ý:X”¢dÁ1k\â?}\\4\ät\'§š1RË¸·€?\Îµœ<Õ«|­\Z”´R{oÈ´.~ñ»´\íR¾Nÿ\ÍXg\êj\Øsü|%Œ\è`õdÓ­w?ú	[»ª½Q¯qÛ¨þ¤\Z\çú\ãÁŽ›lIî‰²¬Ü–.Mj²\Ï\ÕÚ®z¶WQòÈ•]\ÏNòŽ!·%7\Û?m1Ö•Kš•\à]e§Ó¦û–fÒ½¾´’\Â#v’\á\Ð1í€’Ÿ¶/ >¡FºPŽ~MjMõëž[K¸4*erVND”“Ea\îP\ÜKè¿ƒüf5ñUIy»êœ’Y \Ñq\â\ÓFƒ¢\Âõ«ä¸™u0¦À\éDJ}/C³²\ÅT¿<:¦c?S²õJ[hbªzhÆ’=X—(»Š\âW&¥_+þµ\å.\'…>5ƒ’:õH½úŸ’Õ–\îø\ÅÔ£Xö\î•A)<K™>•]ø&Š~i\×^q\áSü’©\Í\Ø\ä\Éñß¢MšL*~B;!\Ó™ó£\åfŒ3\á^A]U¥–Wla\Ò1ðw*¾·6O)h›Ž­U—Je×Š\Æñó\ê÷J[#¥–#d‡c¤–qo:6fI§+\'/ln¨\å=Ö·|-\ÝJhf:™ ÿk:™b\Ï\Í=ÿJŒ«w)\Ó\ã\î\Ó\Z6\ÎOPw­ñß´u¦N\ËH.·×—_{—\ÞýP\îœ\ê®\å	E[6n\ëßŸr÷­*N\íŠm\Õ;¥ôô\Ò\Î=\âb_.F­«°]« …rÑ»€¸R\É`®ž€¼¥„³\å¤\Òx¯5H³\ìŸv\ëEŠ\Ø]™¹Ñ´\":\0\0\0\0Ê²ž\×\Ù\Åt.õô\æ\0\r ”r„tt\'Õ„¿d*2ŒŽ\0\0\04aý¥\è?ù`.>ý\0  \ÎP\"\ÃcŸöujý\é\è7ŸŒ>”½\0\0\0h†‘\Èo\Å\é€\0\é@\èD–7÷vf\å\í¦Í¦N¾ð\è\0\0\0@\ã¡<…\\88ý\0 ‚´mS’·ˆP(`\'ù”„,ñ\ë\ÚÐ£4¢7\0\0\0\0§$÷N?\0H»ˆyŠ\Ó\èU†\Ô\ë{Z€š¸¨$:\Â#M\ÃÇ…>R?›\Â\ÏO¥jdˆbD_0<½\n\0\0\0h\Â\Ú:±B§\0¤} ‹\ãô!ª|4«v\ÕBw6òœuCµQvdJ`¦&\éÙ¡“G\à«Œ\î\0\0\0\0¨ƒðJWPˆÐ’L\Ól¦”¾þ\ÑB &Ž“ß£†s.f^\'\ÛOM\Æ\'Ýˆuez¿<\Ý\Ãñw\Ç\Ò6Jú\ÂgZ›{\0\0\0\è¼\á1\ãµ\"¨\r\Êeœ„O|-\Z]*÷G\çQò25£.ÿ‡\Ü	\È;tÇƒ’úÐ¥söoK=\\\è4\0\0\0\Ð<(\Ô}þ\ây©7‚ð·z&Êœ¾²Ó‚GL=“+\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ª\âÿw‰\ÒG\Ó!\0\0\0\0IEND®B`‚','Activo'),(1001,'Pinvalidda','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0f\0\0\0\å\Ç|\0\09IDATx\Ú\í]	œõõ_ð\ÖzŠr\Ã9ñ¢\Õú·µXO\Ô\"‡‘\Ý$“ ­¨µ´R)\Þ\Z…\ÝMf² T\Ô-Â²G23¿9²ˆ¢\âZ«VÅ£ÕŠRŠŠx¡\"\×úo’…v“ü&“M~\ïó™Ï²KŽ\ßü\æý\Þ÷Ý¯¤„#F=œB½«\Ýn.\Ú\âD×ºƒ\Ñ\Íp­wë–»|\Ñ\ß\Ä\Ëö¨\Ãn…BûÊ²zž¬\ê\ÏÉŠ¶^Vô-ðs£¤\è\ïÁ\ÏH\\U\'„\ì\Óþú¡þX—_¸\ÓVÁµ\É\Øß€ð­+ý»3 ø{kd»Êˆ£žH½†ùgØœ\èÁ\è;_\Â‡Ÿ¿kð„\Ú\ál«’\Ô\ÒBœ2\ÑT‰h›<~\Ü\å\Ú\"ò(¼f¾\Ö\å	\ío÷E‚®€ð€sÛ®û@²\Î®0\îÆ¾lg1bÔ£hˆ¿ú8\0\ÇA¸m\Ú<RB.(l\Ø\nÂ°\ÏÞ¾_±X\ìH‰¨­I«c7ð0.\0–oÀB™€¯w\\\Z>ö\î“\ÎÀc\ÇþF¿rp‘kK\\¡ýG2bÄ¨Ç3P\'@l\ëJ¸m¿\Ñ-®@ô¡½}¿d%q]:ðÀK$Ê“MMMƒÁü\ØÀ\ãót\à\Ñ~!\È\Ø*o\ï\Ï8’#F=‚¿ð\ê#A¸m\É;4\åÍ‡žµw»Z$¢¼™<\à\Ú—\Ô:|\í0\Ï\ÌS²ö«¢*2–q\å^F„2IRÆ‹D\ãZD2Q’´ŸÏ™³\ä\0¶3ŒŠ\ìU57d+\Ü\Ú/›/\Âwù£&h÷Õž\ë\ä/X6~w€¿h\Ð¦UKDÛ˜@´õ’¢MÁ\×:ü|3\Í\Þ:8þÆ•{	\Õ\×\×\ï\'õj\0Žç‰¢Ì³˜\ë;¸Þ–ˆ\Îk\Ú\ÃC\Ø.1*frr\áZZ\0±süS}VY ö$G@Xhd\Z…\rðs#\\k\\œð¨\ÃW;®ddý~{ÂžÁ9ß–	@¥õ÷øZ°>§\Ù[\Ç\ßÁ¸r/ ¦¦¦CDE0€i\Úva\"ü}“Lô\æÍ›×\í£b%‡?¦‡_xf7ð¨ª9\Íˆ¼\ÚY,]8®@ô§ŸŸ¶\'‰‰šh\Ë@Ff=I \áNÆ•{8Bö—\åúÌ¦,fc¨Á\ëf»\ÆhO² _\nšó\Ë\ã\'a“\Íñ1\0a\0²·\È)2\Ñ>\Î\ÛAD\Ò\Z–-[¶/\Û9F{\"€8¹(\É:ˆnx\Þ\Ô\n\Ì\0„QN$\Ë\ê\ÝÙ‚‡q}Y²„Y!Œö8\0±UUŸ®~dO3\0a”€(‰§©\0D\Ñ?ni\Ñ²c´§ˆ3½Žþý‘§€0\0\Ùk)U…š5€HŠþacc#kSÀh\no¸’¦\Î_k«.e\0²\ç\È+¯¼²Ÿ\Ñ\êEKL\'Z\âØ¯@d¾­(úQTO%„\ì\Ý}\Õ$¢M\ÎT‰\Ú1#K\":õb\âŠÑž %£B(¬\Ì^@F?\îw\î´C€\ì™\0òÀ¤Qõ›e¢­\Åùø¹\ä\å2\Ñ_‡½ù&U\êðh,&ŸÑ±\Ù\ä^EMMM\Ç%++¤M&Ê“\r\r\rG0Q\Åhtcù…K\Ý\á›,ªØ¿«ð	\ãzúž1\0\éœ‰\Ä²’ˆ\Ãýo6\Êˆöü~\'ü~€\Ê_\âŠv#Q4û·E\"\êë²¬¹\×*\Öñx\Ü.\É\Ú3Ô€\ì\0UN\\´ˆõ¶a”„¦C\Zõ¾¹BK\ê@\\¡ý\íþ\È\0 ¾Nó¾o\Þ(¯\î\Í\0d\ÏP(\Ô;	úFQ\Ö>E\åy£~7\Ú\Ü¼ô\rðóUøÿ\Ø\Å8.£%\Û{\Û\Ø\ßsOc_@\Ñy°¥6k+öÁk\rü­[œ01\Ç\ÈR\áE\È\áqY½4.“§\çR\Âì«¸¤óñ¸\êÂƒ\Ü\í\0bg»Oðºü®@ô{l¼\×V\ì\â\ë\æ„\åNŸ\à\ßcžÝ½2’\ä\íE‘h\ëb1r¢hXú¢¢\Í\0yº(ªW€L|\'••úü»\É\0/\ïõ‡ºYTFú\Þ;˜\çö¸œ¸4\"¬-3#KIÓ´\áp\è\î\ëJ€Á~9“\Ï+€$iø\Ù\×\î\ä\"×¡ tqü¸¦—V\Î´G8\Ý=2²Z÷¾g´*\Ú„h‰Iøÿõõõ\Ã\ïrr+c’r1*\ÚD\Ñ5v²1\Ê3a\Z8!‰¦.u¸+\n	 {…\È\0d\'\Â\"i°2nDLs³tòN\0¢\è‹-Q|\Ë\ã´:\àÿÆ´´´8\á\ç?a¯V³\ÓÍˆQ~\ÝVû‹²vS\ÊMÚ–)q#.\Ë€0\0\éfþ¼•B\î ©Æ“\è\Úoƒ\×üG’$7¾G\ÅA’¢?±v\Â1Ê§õ!’K\à }Ÿ}\í‘ú·½@0E\ãE¢¸¨?ü&Iz!‹lqUµ\Ã\Ï2Ð€\ëøú¡£B–yjŽvÂƒž\Ú2›?b«¨Š\Úñ§\ÃË—\ã\ß\á÷£JFO9@\"ú\ç)¡\È\0$µ\×1YŸ<º­YQF\íd¨‰?56\êÈ“FZ¯’x^¨ª\'©½ªöA!\ÖÜ«¤ˆÒ¿Tu\Ññ8DR´kEY½<F#±\Õ;}Œr\åe|8ˆ\ß\Ò®\ÆbJe¡\0¤ÿoBG\Ù}üE\Î@tŠ“þhð‚·\è\Þ{cG’8E–U¿D\Ô\Û`/\æ\ËD{ƒ» ¬þ\r\Â\ìY¸þJ\à¬\Þu\ï|›\Ó?«\ÌÁñ\àZ\Ýá­¸\Â3..ò*üü\\+ÜºÿÀ\ß_Ç¿»¹(qþw¡y\ËBw7¿^\ß(½\Û9°÷X\01-WEB\ÆÀ^|!)‰%\Å@š%ýøÛ«2ðln$¥2U2/o~µQ*Š\ÊYð…€/š_.\á\Â\à\ç\ãð·\Çd¢,‚¿·€iTÿ­¬i§\Ç\ãñnkŸ¾`Á‚£\ãD\å\ã˜U \èk\Ñ\Å\0\Ú	ö\Ä[²¬Uc½\È\Þ*\ÚÜ°ª\ê\ã+&†OÀóbŒ«\ék«Œµö7-\Ï,\Ô{Pe¤\é¥\Õg:¼á«~w\êb.Ž_\×RN;¹\È\Ãðw\Ù\à\ïrú¢—$5;ýI\Õ?¤\ìzð\îœ9s\è~\0Á,,þ\\W€\Â>q£?W@ø\Ôˆ>a«ªýu5`§D\n4\Úw\04¾FA\Õa>ù× \ß\×²d\Æ\Ü&\Ç	>aœ‹\Z\ÝAa9¬ñc¸6\Òí°\á\ÄË¢Ÿýâª»>›0\íž\×\"÷µ| }\Ý\×VqÈ 1·÷·W\Õü\Ê\Îñ“\áû\Â.\Î\à\Å]þðcÈ‹ð¼J°G³\á™NqTEÎ©˜P;¼\Ä\ã\é21H[Eö\àI\Ó&wD\ß\ä$o\ÈH•¨\Ã>|e\é\Í\Åb\Ú\Ð ¦\Ê$ñN*%vkÊÖ–\æÚ–b˜­\ÆEôW@só\Õ\×\Çó¦ù42X6€L\Û\Öi\r¬C’U\Í\è\î†˜\ÆÙ¢ic„œ“¤ñp°þ—\ÈLQT…˜¨T‹Š>\r´…q-’ô3ôCz<k«AGO9„\Ò<p ¶â…©œ_¤i g\æ€bŽ~\ãn?\Æ\é\Ôcº\éöµ¢[“„…C\ÆW—+ˆ\ÓqvøJW0úh²›“{Ý†\í<ºº\\~\á›2O³§\\*ú³™‡ulÚ©}l\Ì\á¦ ‹\0¤·=\rb1agmMRó@¾¬\à„J+=\r\r±ò¸¬&\Ú}\ì»Æ‡\Ðeg0‡\Ë\è`l»\âL‚[ò³oÁ\ÒU[–\Ôýn=\ës¾¼kžÀ…k(>\09fLu?›7ò[G€ÿW\êLn\ËÄ‹©=Ú–z\íføý}›O¸¹\Ô_\Ûiy\È\í`r>’¶ö\á1xKAþý¢ýÿ²PúS2³M”\Õû/^|p\îÂ¸‰E\íøð¥\é}‹\Ô\×÷’¬\Ý/)Ê¹Vö_y\àú\0‚’Lß\Z‰H%Dò–\Ò\Ûk¾(ö\ÉÚ™ðð.‡§`±•\Æ\n&8€Œ†®7\Ô\Ì\ïS¨·\ÍWsúˆ€ðy×‡£\îG0zF1XH¾ÚŸÀ{¥óŠ\éº6ú¯µp\Þ\ÍcÊª\Ë\ãôó\Í)¥ÿMý|°le\Ã_;µ\ËQô÷\ÌhsV\0ˆ\Í?\ë|Ø¯õY´1ù®\âÒšr}vqU=^Qôj8_k»\Ø,\\{4\ÞóOõ\Í9Ì‘´8ž\Î,²¹œœ°\å²\Û\ê\êc\ëZ\âZÁ¤\ÌXÁñÀóZ\è\æ\èx1CGm`¡¼\à\à\"œ\Í±µ+Q\Õ99do$\'\æ¢ùt6>QÖ¯J\Õ\Èa¥úÃ’®;rºÁfM;NR×¦LŸ6c\×üø$Emm\Å\ßÐ°\ìÀ\\(5þ.,.²b”\éVJ¿ü±—$I\'‹²r<¬‡S–Z\ÎûDp}RnT\Õ\ÖSi´E[@8À\ãÕŒ\Äý \äô\é‡=\\žY}\à\0<‘þÔµ\á!\É\Ö_:N8\Æ\î_B\äq“‡òœ\Øù\ëüþ;òå³¾¾‘\åD•™½°fˆðo\n!»º¤l\Êf\ÖjL•\Õ?\Ê\íi_\èF¾\r„\Ù`{•pš“‹\Î¬Ûšoð\èxýôwu?Œ¹îž…(À G\ný\ÄÁ	¿uq\ÑG\áÚ”\Ï{usür»¿¡|b¤z’¸\ZŒG\ä\ÎS\ÎWƒ¢{Ks3±\å$\0‘~\rö$Z	ù.¥m\"Ñ¿!ùúLsEW(µü°OŒ\Â\ë\à3\ã2\ÑW¤\Z:Z½wmF­R8¬kl$\ÝNe£§\à¡”+(£\ÙL\ÝTH\0qs\Â\ÍF¥t\æ²Þ½\ïÿ\â„ÿpø¿¥\éL»óA\à \Î\Z!I\ê_¨\ÜV†ŸY›l6i#\çy •‘1´\Ýx+ª\"c\é\ã‹l\ï¾\\\ß\ÏK²úN‹¨óLu\Í\Ë{@\ë~+ž´\\¨\Z\îa½\Ë/<V×›\Ý	 vøÿ0®†­c’\ë¨k\ë†û\Ý÷ùŠ\Óñ¥\æ\Þˆ²\Üz^LR|’¤\ß õjø÷xQUJ\Û-a÷€‹¢ÝŽÀ‘g\ÐH\çZ\Â \Î\ï\Ìúc\áýÿ ¢iKrš’£‹©rt9\\ß´Ä•kÓ­m\è\Ø\ÐÀø­A\ÈOlž[†\ÌI\ãf\ë\Ä\í²*;\Å¬›i\Í!¯ð\Ì\Z\0¼õ\rØƒ:-—½\È@FLŠ\Þ@ÿþ\è2š5\Ö/\\X*«ú\Ò\íQ¯‰¢zR\êžþû¹±»ÃŠ\Ë4€Œ\n\í‹,\Ü÷ºB­\ã‡\Î`Z’§\Ù^\Í\Í\Í\Ô(\Ü?ù¼¾•e­¦¡\Þ\ç/*‰\ç\é,ý“\Ö\ÖV\Ó\íb±\ÄH‘¨Z2º\0{eX$º#ddg-˜A\íZ\ÏGY3h…`±\Ü_\â	u{»\ÃR¢\ì›:\ãå²‰3JA\Ãl¤\Æ×µ‹_Z\á™9@\Ñ[Wdù\\¶€…Ÿ=»\á‡ü\"{U\Íi%”I…\0\à•—²L\ÙWÖ´30¾“ÁEý¢$i?\Ã:¢wÁ3\Û\ÒÁ\Ã,€ó\Î\âô÷/®/ôú11”®bŒAÍ²Ì xœœFýI’ý¼_I¬‰X=YŒ\0‚RqY\ÇÌ†7óàª¢½¶\Â},‰6q÷˜,0þ\nJF{\ËéœÒ\à©´˜\ßO	 \ëwsYU…]pH–X©\ïy\Î\áQ.kú¼,ž\Å6xO7“E6Lù…½ü*™\é$¼f÷\Õ]´\'\0**p>/px7ƒ{ø…Iœ8\Ô:\Ö\É	w\Ã|\ßSÁ\Ã€`ú9\Ü÷ƒð\Þ\Í\År©¬»7\í\Þ\èxK@¤Y’N€ýo‹3¬,Œ8³CÓ´!\Å X­	\à†\í¾*¢½\Â\Å5²’¨Á8VûZ‡{Â‡;¹(¡b40w]\\d&V\0w€8¸\ÈÍ˜RL•Y¡\ãgö\Ô8a\íobj£µ‡Nøýö±X¬œ$kŠÒµ\Êx¬\Ò+ªÂ¿\0aü\Þ.‡w•½ª¶ª§ˆ#%†\Ûj[\Z\Ëx9v~-ñL=\È\á\ãg û\Ælª\'HYe\ÝI¨\ícVT±\ÝGò9Ÿ\Øýµr:´÷\Ý\×8\0L\í/‹8v\ÕdÎ¶ð/\ß\0b\ÝHú\ÍE¼_›e-1‹=\Û]:6¯ð[7¥‡å“²ñ‘n™?t\ìl\Ê8MÒ§;ð\â;Glÿ°´@Hý/o\Â#(<8\Ð\ê\Ó“Ï”±ª7•/\ß\áBlu<®\Ú\r;Y\ÒE\Ý\Å\×eþÈ˜ž\n ---q’]†DÏšEr¡¡…ûø\Ë{2h˜¬Å€}|¶\'\ÜS\Ù%µ\çš:´RbI)Q¯;x´_\"\Ñ\Z ¤O!ý¾qY¹®\è÷‹h	Qo[²d‰‘’‰þ{S\ç\Î„º\î¨ûp¢¡\È\ÈAÁ\Ö\ÇSö@M\ßöœzð\ä[\Ãuúùú\á^¾¬ö“%Y[\0Zø#\"QŸ€ŸÁ\ïÑ––%‡Ùªª‡½n\Î`Ñ¼>|b\í\Ïò u\×[	 ³f\Í:HR\Ôg3({S©ºû”û\ÃZ¦›*¢Û„\ê\Éjú\î³j²t\Å:ý¥§€\"ð\â\Z¬|§\n®c\\¯r\Å<²óó«u…ŒI$ñ§´g\ß\Æm\Êv!\ÍE¯¢\Íqø/]ž\Zg>\Ñc°·öHg2fA‘n*¬CÐ‡Ò»\Ì7\ç0Xg|D7gS±Œ\çŒ6“øc1†Bu\ä\äúý\Ê*kO\á}½“–gº\ãs‚ü\Ò¾ô^1Y FÜƒ™™\â}\00\Zó¢ÿ\ß\Íe?=]R‡+}ûøI\Â\ß\ÎþÓœÆ±\Ó\î%\ã§\ß\×4\æ\Ïsÿ:ò²ºi8\Ó®\Û@\Ù\àu\Ï[í¾¤Q“tp|cOrÕ¥\0ù\ÇDÁÕ\Å^<²¢\Ý(¥\ÉÙ¦¼6‰ŠöOQV…¸¤])\Ëz¬…IX\Ù›%Š\Úó™\ç$d+\ìÕ-¢zy!\0\'\Ía¥f\\\Ô×ªªjø9:\ïG´\Ì\åD\ä@**ù_\Ò\Ö¸‚Ñ—0Xn\ä\ÖW…oƒû²$H\éâ„·0öƒ9óÐž\álG öl›¿ö|[ z‰‹ü„úC °>aò†›\ã—\ÂÏ‡\Üþ(6ó[\é\Â	Á\ìrû\Ñ7\Âþ±ž ©†¤k3ñ\ÜÂ…K\Ñ2„½lrs\æAÝÙ€~^\Ç\ÎW\Îh¸`aŒ$â’Š\r\ß\Ç8“À\'úr\ì½—µû\ï_(žu<\'3z~q|ƒ;h}\ÖS&\0¾¹ÝŠ,³d‹’h’}‚`/œƒühóó\ç»üü¹\Ö\è\×´ Š\Ö\ì\äx2\Üs}\æ\ÖN\ÍÍ¤,\Çz…6£¢½ˆ“®\âñ\Ì=­x€ô!Z«WRô7p/\\\Û\ÌEý#8×\0\"I:&\Z¼jAÁ$X/\Ø!TûL&êƒ’Dn‹\Çå ¢\è\ã%IñÉ²2@¸ööCIV7¤€7Wÿ@$•ƒ/\\H«#¯¶UF~š7÷ý7\åz6 žiøš=µe¹T,\êÁ°°\Ü[}bI–ET\ØÕ¶œ‹ E·jºSr\Ð8\0¯,v\0‰\Ç%\ï˜!Ñ•²²M$Ä›\\wt,fŸ™}&`Q¾ió×ŒÁ&\íkhll\ìgµNV:;F\'Y™,—eù¼I“B–ú\Ãÿ\0¿B¬²\ÒHyU\ä°€¾0Ï‹\Â6\à§\r?Gk¶¤$»©\ÃÎ›\Ú\Ç\Î	W¤27\ç\à\Ê\ÚRQY;1í—¡O6û•„7>¼¥²¬NÀ\ÖfR_%E¹ƒ\âÀß˜Ž[\Ðÿ\Ü\Ð\ÐpDw\0H²Eƒ~O®+*®‡\ëe\0†\æÎ£¯<“•ˆ…W°¶¿ˆ²ö´HŒD³ »•DlÁr4öŽ\ÂtRJ\æ\Ú\ìD\ï\ÊG]H…/:\ÚDUø*t -÷õª‘\×À^\ÄJ½Ñ‘f‹«úŒþO¸§¦Ó†\Ñ5vo\í\Èbt\Ý*Šve†\âb\àqýõyñx¿Á¢Kè«¬<¾sruó+¼µÃ»\â+Ê¹¢¢=Ÿ\Z\à\ÕiúŒ¨M8¶a\ä\ä\ëwú\"5h1Z\"]&p€\"”H5ý4\ãBú>»©\"‹¸X—g	\Î¶\è‡\ÏzÃ¬;³\ïlž\ÃÒ´ùH\Üh²P°\rþ*0!ÿl¦¸ow+H;„òT\ìPjN(j«Á¤¾°;\0$.Ë¿¡ù°\Ó\ç«ú»°\Þ\ë\æ77\ÛÌ´	Àø8#!N´§r\0±oÀ\Ê	\à÷Wøª\Ï¡õ=•\ß?(¼\Ìyª•\à\Ñ\Ç:\ru=\Ç\ÏB \Ä\Ê^l\ÝmR\Ãý—\Í¹Ìš4e\ØSø\Ã÷M\Ýz<\Ð\ßQc\"‡#€ \â!*ú\ß3\Õl\\™Œüe÷ó\\ü\ÕAþ\Z\çµ÷;wZZ\Å4\ÙkN?\ÎÄƒiÎƒ\Ñõ;Š.™¹\n÷s‘\Î\ä\Ç^v´\nÖ¿\Öd¿ª÷œÀ‹´\â\\µ\'~\á~¸\ßu´ n4*\å\"Z\É\È\Éûu;\Z}‡&5\èw@`›<y²eƒ˜°ý¶5OM£õ\ío#Š®74\ì\Þ\Ã\Êj\01æ‡˜uY‘\Ä\ã’$UÀÁ\ÊI{Çƒ	&ü\0)Ù³ßŒ\Õ\Öûõ†®\ë\Çu!~A\É\ÖWßž2òš\Û\ËÛ¹ðoPh\Ð\à\è\æ¡„Ž­ð\ÎkzÆŒ@€\ÏXQ\æ\çO\îô\ä@\Ø\ÒÁ	3Í¬	Þ³\Òÿ¢³°b’\âÉ¤¸ {‡q\0ø¤\\\èº\á\ê®ueo\åö\ÂD bÌ­H\ë2^#)Ê•¨(€•7	,Ö¯­û¸š¾ \\=kŽ…\á<Ž°¬*|§\Ú/¾\0dƒ	 ÿ\Ýq»mxJø\Ð³U}•¬¶ž—¯ \êB)Q\nà´†V0¢;­±Qª\È\'€HIÓpYZ­\Þ/0\á\ÏJÅ°h¤-WFypPxI\ÉX\ëÜ—\Õ\r²\âz¦Ÿ\'Óšú_;\'÷rù\Ð\çK¯]ÁA_‡õˆ’<’\Í\î6Ø„Ç®´,\Ð\âŸ\É\0[eE½_{\Èü±´…sØŽ\Æ\å‹F\Ì\ìudþüC3\ÉL$Er	Z.ÿ¬¿\ä’p\Ñ€\Ùf”.#x=XÁÂªþ•3\å“§¢pn6›H&K:Z\çØµLº¥&\ê	V‹„\\’\ïB\0¬l•$\í=J¡\Ø&µ5_\02þ¢C3µj\èjÎ‰¨h\á]\ç:[EF·dYý\rºM€È·‡ª¨\n\åL\npª\Ú‡Ÿ¿\Ú!ëœ\é\nF? ±\È\ÐI³1›\ì!zÿnô\Ý\á¾ðˆ|ó2Grp\ÑYô…›Ñ·±\íL1ˆªª\åI€H \ßI’~™!°\Ñ\'L|\ßRt3™–ñ¸=uÒ­q9!	#\Îd÷ó÷›­\ï@@Ø¾d\"\æ±\Ò\æ­>³{:<ð÷ HS\Þ\ç\ë\É@~\Êý!\Ë\êXœ‰K\é&úN–õË»\ã&\ZI¹,91‹ªs\ïº]\ÝCV\Üû´\ëI\Åg\Äl2\Ór\Û/²¿$£„\×Ñ»#H¤	À,k)ƒlsõ\ÕöŸ\\0Ë¹´&¿3ÀC\'…\æ¡\ÍðÁªz¸\ß*«]]§sÖ–9qN7MmKP\Øf÷U{‹	@@º3~\ë>\à\å½]þ]Jaº\ZG\ç\ê\neí¦®‚\êb¸:N -½x\æ ¬{°@Žö„Ž\0ù\Òúø\Î\é.£†fú¼U\É&R>—\ÍN\ä†\Ë\Z…™¬$B\Ô.\"Y›7LÄ’n¢†††¥d`Œ\Î-#kÓ­\ÔZb´{€öZ¾Á£\ê\ë\ë–d]4‘I·\ïý\ÂX‡@ô«k\Ée\Ý\Ã\Æ\ÏJ\é>‹®Á\\øT*ò­#¨|\ìø\Ú:‡ý\'%\ÝH8g„ñ”\0ýH1H†CûœD\Òu¹„6\ìòñ7X±\×Xš \í\ï\\Y›b’^‰©Á\Îd\nö\Æ\\b\Ñ*B \Ì\è™uP7²b/‡W8\î÷¿t.\ÕhƒqfDEeL ¢³>þ+Š\Ê/Kº™@°kLp£r³\éoulh€4bK¥\n\Ò|Î·¢ªžÚûõüó\Ï$«\Ú´nI4û:\no\äL\Ú\Üq¬)\çf›w	Œ\ÙB]ý\Í	M©a8%´S\á\Ð:¬ªúø’3}œ& ÷¹®X\0$Ó†c\rQfžJ\Ô\à\ë\ÝAþ>\Z\×fY0\Û~‡\â(k\Õ¬”k\ï \Ç\Â\Æ\Íõij\á¿€xö\ßß¡tS~?pÂŒòng\ÄÓ¦dŒÎ¥(Ø…µ~€£ Jp¨\r˜™\ßÐµ\Ñ\Z\æ\Î%?)Ä¡“$ºL#Q\Ò>\ìh)Y ¢H¼ h¿§\É\n\Ã!ôfjcr>8X!\ÚM\ç\0¸ª·ûpý]ßž€°\Þ3\ÝI´k5\æt„o)k-V\ã¶Zw€\ßH>þ©Ži\ÝIv_x„‹R\Ó-\íPRH\0Q”E‰d–8\ë£\Ä\ÚÀ/F\Õ\á€\ã\ï\Ãx‘uqTr\Z6q\Ì\ÜS¯uf\à\á4K\Ú\àwG\0I\rjû.](Ø´O»¿vœ/hý\Ø%¢\Ä±J§¡~-I\ÊE…ºQI’4-C€i>—e\í«\0»\Ø\àN§Ü³$)qn!ö»ƒöeZ¶T_¿\Ø8¼\Þ\È)´\é´Xõj¦.„S£‰\à÷K\íþ\â¡gþœ¶\æcxþªè³»\ç\0]±£\ËYX\0\"I\êŸR\íŽ\Ò*›\Øk7\Ü#pŽ(^«]5’¬¾\ÑÍ¬$4ƒ\ï}\á\Ñ&bi\Û¤b\"¼Ÿ\Ëþý8ªÀN+¢ÛŒvÞŽ#\È_SBõ_”\ÂpUc£Þ·P7\Z‹ÅŽ\Ä\Ù\è\Ù\ÇpðT\"d€\Ô/^|°¤j¥\Û3ei6ó\Éó”€°ojV7\Í3~˜,Yrt{Ö+™K\Û\à\Î\éW\Ó\âa\ï*`\ài\ÝW\Ã+gþ´cZ\"eL\áË’“\ÝH9¦¦cVR\0ð‰©‡jü\íq-°@–\Ñdœ•[\\˜j€ž’˜›…\ÂùÊ˜!\ão:n¶¢1	 v_¤†&»\É\Í	\Ëq*c!y\Ñ\æ\r\ßB\ÅK~^	m¡lð3…¼\É\ä|q\íV¢&Ú²¯»\ÐX \Ø\"E\"j+E\à|‹¢$fvÏ´1ðÜ¾¦x\Æÿˆ\Å\Ôò‚*|!€\Ï\é‚\é\Âûö\ÊÚ¡\Ùj‡è² é”šŒ}ð/wüw n>\0Õ­,4€8Œ¬±º\Í\0²¼H\0\ä¾L=\ë$Y{.@¯9øgeöu\Ñ†ù#6\Ë\ÏAb\Ñ\ÕYœ÷\Ï	\ÑqXó‡fÀcbm\é¬\Û@w¶š§¤O–Ð¦¢\Æ%\å\ÊŸ¹^²ª)‹\ã\Ø?\Ê\n\0\ÅEýñoi»\ßH’\â)\ä†\ÅTµö\ì9\n\0ùBRô\ín\Ê~\ç\n‡¸üØŠƒBÀ£Û°\Ú5»`rØ…ùò4Ž¶Êš1;»À‘\æ\0\Ø|üôBHr&}\äSŠ,\ï€¨Ë¦u{»;\È\ä?£P>\î7\îöc¬\Þ\ë&Q=5›d\à}ŸÁ—\áß¦\0c>8B€n¶N\ßWH^\Ä\Þm”üK’³Å³¨-„8}\èd¹õQ\Ö>§ˆ¤Ý§Ÿ+€42­\nŠ\ïþL\×uw!÷[”\È$ñ0\Å}oTôE•;k\Ê\á3Ü”\ÝD\á@­)›È—¦]œÇ³6¤-\Þ-õ™öQÛ(À?‘=ÀÕµ•zf•š—K¹Ûqù\åñ÷\ámû€\ÌÏ˜Ì¢&dca\Ôo)¬,be\0½A8$\Þ_GHbrR!©{\Ö€<\r;)D%*~öñSº«ö£k?ò”\èx!úU	mûB\n\ã\Ë\ß@´\ÓiªÀAˆ«\í™X¹H<®º(k+>ij\"\Ã\n¹_³9\ã4n78üþ]¢)½]Áº\'hcNúy!†N9jŽ\Éb«{\íb¼D \è>*4/WTE‚õ<O‘4ðA{Ÿ®‚N\\\Ì@€o&\Ð+C\á‹\ílò\";HFY±^U]e¸¡‚\Ñe”{sG{\Ü\Þ+Óœ»/|E‰É®\ÏRo\Êö:©¤YÓŽ+ô¡Ã”<XËŠ¬A@ÑµE‹Y ’®Ÿ@Yyþ1º½\n¹_\É\Ì1½™b\Ý\Û`\Ï»}Ð¨Ð˜!C™%õIûp§N\ÝW”3±\Û\'¤ULŠ\Úw\Ï\â^\Þ\Ó\îý\ÃvWG!›)\Ì\Ë D\ÑIò#co¾\É>\ÓLPŽõ{\Ë\Ë\ê\ë\ëÊ¦Ã†–xð·\É¹\ìŸK²ð1z[\0!{:€`E:5€Zš±@d´@ör\0Q\Ô\r€´)\n-_d6\æ€SÕ……Ùu\êÅ™\Î@ô\Ê\ÔÛN¸¹³µ€<M\çÂª\í.,+$\çÈ¶ô5\ê\â\ä:£\ç`»ŠxÀ\ãÆ‡ZŒ©\çe¡l®•\å\Ä\Ã\âö+(G	\\c¸°L4\í‰.,“\0\"-ô¡‹\ÉÀDÿ”@”ö\"¾\\$FÈ‰{:€nª\ìì³†{Âƒi\ÒmS\ÃÛŽIu?\ß=©Ö„,¬ª˜\Ðù@!g BUôh«Šü¥(‚\èÂµX\0D’µ¹\Æ\\ô#¦_3\ä\Ò\Ä\ê“q\Ä/E,\á\åRN°<n¨\è­\×g3Kã¼˜U–\Í¾¸]\Ó\Ñ#¡ön\n=%ˆn\n@b©…‚º°dµŠ&øþ\ì\ï\Ä\0„ªM°Ë ·—ŸJ\Õ.=\Ý\êòó;Y4Ãªªû\Ñö\ßI\Ò[ººOL\Ü\ã\Óx‹@DY›¼¶Ã(«\ß\âk¿ð†#A ¶\Ò\ÌÁÀŽÌ–{.”D<Y±k§\Ø\Ýu h\Ñv˜\ØË•l\r’õqúù–£\ÆL\ïQi¼¦\0¤=0V(ª¯¯\ß¸\àF\ZwLLÒš)€X\0 %\Øö \îÿpðU\Úm0ú]‡º^hî»ƒ\Ñõ”ûÝ 1‘.÷»øRvðý¢ð1\Ú\ßQ\Õ‹¢(—\"—±\0;ñ\Z1\n—f\ä9|†;\È2—*\Ø/s™‚ZgX†\\\íU4\ìS†“;¬\á:f\Ö|\×+….$´{ù›ò J\âý\î\ìÂ»+\á\rB‘Q„\Ó\ÒE\Ú\ß\Ï\0$w\0Á¶\ç ˆx8\ètsü\Âõ†õ\á9´\Ì\'©[¶û„št÷9\Ü[sm+“²‰üÉ…|6® \Ýúb%‘\r|òU\æ^X\ÊE%£F\í\à\ÞD¥pp‚z¤\'|¸UûŒs‹²(¦\Ý\"ª­§b[\'\Ç\ÇhRËœð\"&DlwMúÃ—ºƒ\Ù\'`÷_‡/òóBñ!\Æm\à½™w\0Á\"³Y;½P7ªi\Ú@\0±ÿ\ÑtÁÀñ2\0±@J\Ú[Di[|;¨òöþv_\Ø\ë¦lš\èk¡¢ªÆž>8ú\0¯K×´Ox²PÁK\Ð8.Š\æÅ”…õ\0!}²\r\Ê\ÛÝ†F\ÎEki4rf_X5\à½°–{2Þ…ûÁ™ û`ÿ7e_(\0œùGM\Îùˆ2\ÞP0ë£ŠÿM3\Å,}€\È_\Û]B\ÝM’¢MÁ\î¶ü\r‰³\Ñ€X )7\ÔAð±\à\Öúpc\æ\Õ\ä\ÌAFgn¶s/X]BOW·´Ü¶žhg‘¨K2g5iÿ0¬N\Ïe²@›\Ó\Ï/²\Äú•³RJgš´cm=œí‘¸·n$D33•5u§LC°\ÒW\Ò=[a\Ã\à.DòJ§M=\È\é7Z¯l\í\0A\áòR“\Ôý\Õ\Õs\æ\Ì9˜v%\0(ú»7a\0b9€”yvøp\n«\é\ë8„-”Y\\k@ð]˜Í½\âdB:¡h$tû@)ge\Í/iû‹€\Ä%å²Œ\íL\àü€V_f–9\á-Z£\ÍÏŸŸc\Ìô`QQgeH9\Þ\ë¼cÉ’%8’cŸP*!Ÿ\Ø}ünÝ¶\\T¢v\Óú#KhšZ@½lÞº3iz•\å Æ†«Æ†w\ç\Æe¥†z\"¡¢7î¤0\0\É.][V/\ÏR`_N\Ó#‹šIAˆ¸¸hC¶s±S]}7P\ÏS\çÂ•%\Ò-sA°½Ö¬\Ð\n—bùó\Åþ™¼iß‹²~}r½ü]&,\ÏŽ\âTqE¹2\Ã\ÜömpÆ—I’^aŒw¥h‡\ÓqŠ`gÃ¯\Ê\'F´ó\ÆÑµ\ëHf,v‹[uÀ¸š¾`\é%L\Í\0\'ý}\Ú,Š£ºK\ÒzI6av‰\×lnjj\Z\Æ\0\Ä€\èYU\ÆS\Ý‡2\å@@»û\å9Yûr5}\Ý]Š\Ô÷¼“®b\Þ*ÂŒ$l;‡o“\ÉC[4\0‚$\'\ëA\Òñÿ6à¥…¡PÃF\\ÀO\îF\n¸Oh-­¬D»×±˜v&|ÿ,\íDQ=©\Ä\å\Ù\ßA™z›Rp~pr˜\Ü\ÑùP2P~V\ÐZ\èðž•8\à©;dƒ\Ã¾\ï¡û$9\ïø£¹s\ç\æ\Ýô—tÝ¾T\ê¹\íŠþ\ánþP 4]—³h­\ê\rVÈ”¼Y ~þ…º½\áP\\Mo\éÔµ9\Â\ê’\Óó›‹_\áþ\0÷ƒ\éý(2\0Y\Ð\Ò\â\Ì\Ô\\oD¢.H\0\êG\Í*X÷\\LE÷ø%|o¦d›¯!G\'ƒütó;v\\\Â\'\é\â\åž\êsh…\Âm\ÃVò|‘y@]\Ø\Ü=[ \í³#\âñx¿|\Ý$\n_\Ð`šiÁ\ï+\ÖIu \ÙÞ·zu(”]vR0º\Ó?‹ksEe\í8\Úûµù#68Ï›³x¢+\àÐŸˆAP+ŸÁ`o\í‘vŽ¿ÃŒÛª˜»\\Kªvo†ó¹\Î\Ñ\r“\'OÞ¯l,_\ê\æ\è&\\vhq²À˜Ã!\ã*&«Àw¾\ÕÅš\Ú`-\à\çRQ\rwc_»¿\ÍM9Zx‡µ h\é3\í\æ\rg\ã53\Ï\Ý\ÅÕ½W>q†\Ãj\×j\Ù\è\Ða°î™´®Þ¼\0ˆ‘\Z§j.Œ«®‹›a\ç[°\"ˆ	ð@`[Ž\ã\\€˜Ž\\“-€$ûE®ˆ~omüÃ°>\è	gZ„ö\Í2s	o8¼| lôb|¡\Þ8û…Ÿ™õk\Zo\ÇØ¤(’qRižZ\ÓLHÎ–qú…ûGP¤[\ï2ƒbº4±Vcwy\ïgdi*ú‡]ÉŒ8\Ñ\ße\åÖºâ Šªð/ŒzN0·–\0ÿÅ±™Šÿ@ø;üü\Õ4E‰»X#+\Þ‡3\Ö-_öo.¬\ç;”K\0\Ä\ÐöA`¿“\å¬xL^\Þ/˜³Šô\r)¸/³.,mJö\0‚¾ý\èQnŽ\Ï2ð\à¢?8¼µg›?(‘À\à\ï›<mp/Ÿ¹ƒBc¹wö‰¦7þ\Üi‡8‚u×¸¸È«fc\Ån$ƒ\é‹•eµ9Co¬6I\ÖDt1\â\ìo\Ú:‹>úƒ\ãg\rŸXSÑži%IúÅ˜V\ÜÙœö\ä\è]õ5YI\Ü\Ò\Ü,|\æ\ÕwÙ°÷\èsžŽ]\Úót—«¬\n¯œÖ•\ÕÁ\Êù\Üˆ\Î\æ¯;Á´|a\í‘N.z\ìû«4Y\Ý )\ÓP\Û(©:m“\Í\Þ(\ÆT0¥N”ª\Ñ63ë‰þŒ$%:d\Ä\0$ËžgDý“‡Ð™\Î•\á+¬80O¸<³ú\är\ß\Ã+#?\Í5\ÉZG \îoÉ¢¶\ì\0u \'\Ô\Ç\Æ	¿\Åf|\èc\ÎU\Ó+v\0I&¹\Í\à\Ø\Ö\"I\ç\â>:Â­8\×\Å,À£ƒZ´\Ë\ÏÏ»¦zþ51¢QÑž\Ë\ê[°Ž\è\09ð€Jm“¨þ4r\åxNp\Ûü‘;\Ôs¢fŸösr\Â\Ã\è–\Ìúløø‰ðÞµ9<û­h\Å\Ø}|C)g\Ô-eÅ‹\Ø \Ñ\Î\ÕMrø™\r–w€\ì\àŠ¶4\Øk	Iœˆ\êI\ZA„VBCC\âˆFQ=	\Ì\Ï\ßp¬\Ê)&£\èk¥.Z‘3\0¡raM%„\Þ÷\nZ\Ý,`\Ìõv?_eÅ½;uó\Ý&\Ý%»i‚È«N¿p»#ÀO\Äú\Ð¶+Ç©{6øj‡\×]”3Sö\012²Tý*L\Û\ÍÀWŸ\Æbj¹\ÑÊŸ·\n\\A¨¯†{+8~*¬q’›‹p\ØÀ{®98\áø®÷\ÍX\0óðn…Ÿÿ%5/úùû­HyOZaü¿\àùßŠ\ç\Ä\é…\å\×6®ö×Žª\È9Ÿ0\ÝfÀ¯Š\Ëb·rw\0H‡y\0ú—`¶¶`\ÍQõˆšø0\Ù LFú#üý0+Cð\Ú\ÆTŠn[\ÎV¬\Ý\ß\Þy—H.,Y¹\Î€Ø½‘ñpH6\ät@9\ái8–LqD\Ó‘–\ÏZ•î¼Š@Œó…]zI\×]zÑgtf?\r÷ò\å Ø—÷¤ýðø\Î\î®\ì*m7}\ÍÅ}Ÿ°\Ò\"-0/\æ@º¨øÜ¼\Ð/™3`\ì*\ìkO\Ëc\0’s\È43\íj†Nš}¶+1Í˜ 1™~ƒ™Ú¥+\Ë;£þs@ò ˜•%+\ê=\é\â!\è%\å&,D®¨¬ù%mOµB^v.R“K×‚²±3J\Ñòb\0RdQµš››3N˜c\0’­¢M…–™Jeµ{kÆ»\æR5\ÝØ›*“\Ë|‘ŸÐ·Ù³Ä’,¬\Î\â!\Ç\Êj\â\á4\nb›D\Ô\ïeUkð‹Ÿ¯¢m®Yˆ\Ëˆ\Î\él²&-\ró\Î<c@Š\ãÂ ù*Q$c~üñ\Ç^@,ª‘\Ôð}¦Š\å<3¸üb3>g\'\Ì\Î[_e\ä,\Ì\àa\0’?¤¤D¢T$\Ú\Ó\é{Pi\ëd91vÎœ%€\Õ9@dMqî¹°ûŒžr˜U¼Xî«¹\Î\È\Û=Ùµ§\0È§\"iõf+\ì€d½\î;6¡¤®rõF8ú–\íÂ·C\Æ\Ï>.Ÿ{Qêœ	\ßó¢U ™Š€C‰šˆeˆ‰|&«ú\å8r\Ú\æú°\îÁ¬+\"¡*lpúy¡³^W¹’-`ð\âó=˜{:€h«e\ílE¥¦¤$ž¥±€Hº~-€477\×\Ó\0D”µ›r#=\×\îò\Ó\Å\Þ\è\Ôü\ïF¨w¹—?\Ñ\ÅE° ;ËŠ¬\Ê&\Û\Ä\îW›°ð–µ\ï/j\Óiv»I×kv&\Î\å\éÚƒ ­†ÿÿ3\ÆDl¾šÓ\á\ï |\\¨º¹\èz‡/ò{št]\êøœ/<«Ù­ª\Ê\é\ê¦v\îm\Å\0Ø¦½¥¥…ºW¼7Nù]/Z´Ã‚ „Œ Z§ª\ïùI!\Ä¨C m¢¬_CSHØ¹R{6\Í,›ÇšÌ«¬j5N›u\0¹\Ð\Ö\Îñµ®`\Ýs\Ù[i\Ñ°\ÒÞ°¦.œI\ë\ß\âj~Eÿ~a¡	þ\ë-)­¿O\"Š¾-.)³=„\ì_6>4\Ð\Íñ¤P\0\ß\Þ\Ðpø¸d¡b¾\éÈ³¯?\Ü\éþZHIÖ˜„§ÐŒpø\r&&&®–‰þz>²¨²¼0\Ï\\‰\'[§PÒ±r\'Õª]2¶ª½\0p\Ð³\\\ìû(\ë\à¾\ÒJJŠ€° *õÌ²Y÷—Š®_d\Å÷‚–ûPóA63°=ž}º{_l¾\È%ðý/c‘Uwø£“uü·.Ž\n4\Û\áØ’\Ã\á\Ï\ÊÖ\ï}c§ý\rF\ß\Êv\Ý ~\è3:4p\ç\çÍºOV0ó³{\ÝÛ·J\Â\íTvˆJ\âŸ8ñôò\ÈüC\í~þ&\àŸ×\"ºnpkµw prü½\Þ\î\ì”tûò/ t/¢\â\æò\Ù|ü\é\ín\Ñ\ìù)ú\"5€ˆ \Ò:,€y ¾\ïVðPÿ…Ÿ\Ó2¥\êf\Èù	\æ¡g9\Õp£$);\rŠihXv ,\ëB¶-^\àûœ\Å\0 ¸°ž\ÕÙ€&Q\ÔÅ¹\ìñN‡\ÂÏŸ\ìN3tÊ¨ö\æ¢\Ë*ª¢öB\í\Ó_[†©Ã®Z[P\ÚgÀ\ê˜\\:N\ØÞ§\Í.\Ä®Y¥‘‚–¸\Óþúfsg1:59¾—\îð\\ô¼lZ¾\às¿§$\Ç~w¨Œ\Åe=\n\ÍbL\ë\ï<CûPV´°$I¥(\È…ÚŠ|\nU¸¿µ°?õNP(¬L!§\ÎÐªª\îýV83o\ä;6‚\rPÁ¢¼¿s»U\ê©qfÓ¡Ÿ…\Ý\ËO¦fM3üù8&¶ERFU{±[¬91GÒ´“K,h\Ø‹iCˆ¢?’Ö‚\"\ê—R\'\Ý|S‡\àD°\Â^\É\ìfS~_bqƒI³\ä\í\ä\ï2\ÏyÑ¾e\í«\Ö]6z\Ê\é|õ¨a–ù¢E\0²¡\ÞÎª°ûa¿ «]U\0‹\è%\Øi·´\çq5}]º\ÖL­¹\ÝkM®\ß´\ÇË±­xº\ïwúøûŽ\è¬!ß¨Ð¾Î€\à¡ñQ:\Ë\Ã\É	÷1\ê\Ú#¬\Ú\í\æf\í88£S\ÊÜ–N\\Z |i¯\ÊJ\ë¬\Ðì†¡\ï<!õlÞµTˆ£\ß\áK\0õ_5&rhIq\Ö}p\0š”š7,Ž­ð,ŸupB\åpOhð®_5.N_¸!//K\ØMÀ4€\ì(ª\ß/&)`‚RZ}›5\íPŒk«Hô¥]õµÊ…Œl²Ò’J3lÿ>\ì\çµM$\Úó---#Ò½¿¥…ŒeuU‡÷v˜p¦m”U}j.A\è|XqUR2+¦\ãºSÿNlhŒÇ·üKË¦P\îü„\è7†Å­‚\Ñl¾_r|ö3ºF\Ö\ï7lbø»/r7º}\Ú×œ\nx·uv¸°?\Òöÿo¿\Ç\0¿]Éº–ôZmù¸ø®U»~~\ÊÍ°\ÕÁEHSÀÖ«\ì’\ÚsA¸~\ÞqÉµ°<²JûýU‘s\à™¬\éôýº\Ûqnv¾¶»>¾ø¨Q½B”´·Sˆ\Û:žGty\ÅRoŒ9y¿Š‰µ?Ã´Z\'v”\í\ä\Ù\ìØ¿º¶\Ý\ï\Çè¶¼\Ñ\é.)\ÇAec¦ZR\Ü\Ô{¨‡?Àó^W\'÷;¢\×^÷ü¥\Ý­mo@™Ž†L^DÿsI\Ú÷Ò½c/·€Õªõwû1\íA\åœ\0¤î¹§±/he¢,‚‡þ¦(kŸ­Þ³o¿¾¨úZb+fˆD½#W\Ï÷\ÓiŠ“_‹Šú7œ\0\Â5\à1±¡¡!+M\ëHIIL‘I\âal\ä ñjT1Y>#d²†¢\ê½c12RVÔ»ÁÚ€}\Ö^H\ÎFPnE­0Ÿß\Z0\Î\Ú(óó\'3\æ¦~\Åb¥%\0¸!þ\ê“\Þp\05Ug N‡\Ãõ¤ÀÁ|ú¬\á°\ÕÁ\ßðÿ\ê\ÂNn–×˜nH9\Ç§;P\Ü\ì\æø¥†/<(<ÿn±UÕž?Ð“Y€ô\Ì\0\Ú\ånNx/²w\Zó$²$LUupüt´–\àZ\âðEg`û\ï\î\Ü\îyóZ\Æd\íLQU¯¾œ<ª%±þý$QZù0C\ÅS.	#C÷„G½Ÿ8þxó]~~Qª\Ç\ÖS`y=‰V<§œ\nA°¼R8[Š”ôD:w\Ú!e•µ\'\Ù|‚\ß\éx#{+˜\ä\Å\áE¼pò\'¶LÁ\×Tx#\\(CýG¦W v%¬\å²…¤±‹ð \\ü>7Ÿ5ºÄ“\Ì´@:¸wö‘t\Ý-)º„\ÒM œ\ç ,…÷¾?ÿ#«\Ú;À\ï\àÀlÿ~\\2za\éw€ðž$k\Ú\é jU€\Çc:\ã-F]\ï[_O\ïIü8þüCrt\Ç$F\Ùdxö?\ì¼PœQ\×@ø7ZY–}þ\è)`{ü#=a³ü\Ô+Gp\ÎõýyqÁ¦z³õ\Ênýhñ…z\ï\r¼ˆýÞ1®† wss\æøùý«¯?¼Ó½·\Z@v}--Kkl$JRi3!6I\ÒªªÚl1MŽm ±¯™\Æ}Œ1bÄ¨€”g\0aÄˆ#F@€0bÄˆ# Œ1bÄˆ#FŒ1b\0Âˆ#FŒ€0bÄˆ# @1bÄˆFŒ1b\Ä\0„#FŒ1\0aÄˆ#F@1bÄˆ Œ1bÄˆ#FŒ1*,€BŽe»Æˆ#FŒ@6\Ò\0H<¾ø(¶kŒ1bÄ¨DVµ(\0dS1ŽieÄˆ#F…±@\îN\Í!\Î8r6.iSØŽ1bÄˆ#ƒDQ=I\"ú299¼¾+\0\Ù*ý\éxaF\Í2bÄˆ£b$c†¹¦,\å\0Š-€\Ç‘\è4Kú	%E6\'™#FŒžz566öU”\Ö\Ë$E@\ã¸¾‚\ëiQV¯¨¯G\Ë\ãGŒ1b\Äh;ý?\ÌoD\Ó!76\0\0\0\0IEND®B`‚','Activo');
/*!40000 ALTER TABLE `tblempresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblentrada_salida`
--

DROP TABLE IF EXISTS `tblentrada_salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblentrada_salida` (
  `id_empleado` int(4) NOT NULL,
  `cons` int(4) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salida` time NOT NULL,
  `fecha` date NOT NULL,
  `id_empresa` int(4) NOT NULL,
  PRIMARY KEY (`cons`),
  UNIQUE KEY `cons` (`cons`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblentrada_salida`
--

LOCK TABLES `tblentrada_salida` WRITE;
/*!40000 ALTER TABLE `tblentrada_salida` DISABLE KEYS */;
INSERT INTO `tblentrada_salida` VALUES (1000,1000,'07:00:00','17:00:00','2005-06-13',1000),(1001,1001,'09:00:00','22:00:00','2005-06-14',1000),(1002,1002,'11:00:00','15:00:00','2005-02-12',1000),(1003,1003,'07:00:00','19:00:00','2005-06-13',1000),(1000,1004,'06:00:00','20:00:00','2016-08-01',1000),(1000,1005,'09:30:00','18:00:00','2016-08-02',1000),(1000,1006,'05:30:00','16:00:00','2016-08-03',1000),(1001,1007,'05:30:00','12:45:00','2016-07-13',1000);
/*!40000 ALTER TABLE `tblentrada_salida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblhorario`
--

DROP TABLE IF EXISTS `tblhorario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblhorario` (
  `id_horario` int(4) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  `tipo` varchar(8) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `inicio_lunes` time DEFAULT NULL,
  `inicio_martes` time DEFAULT NULL,
  `inicio_miercoles` time DEFAULT NULL,
  `inicio_jueves` time DEFAULT NULL,
  `inicio_viernes` time DEFAULT NULL,
  `inicio_sabado` time DEFAULT NULL,
  `inicio_domingo` time DEFAULT NULL,
  `fin_lunes` time DEFAULT NULL,
  `fin_martes` time DEFAULT NULL,
  `fin_miercoles` time DEFAULT NULL,
  `fin_jueves` time DEFAULT NULL,
  `fin_viernes` time DEFAULT NULL,
  `fin_sabado` time DEFAULT NULL,
  `fin_domingo` time DEFAULT NULL,
  `numero_lunes` int(2) DEFAULT NULL,
  `numero_martes` int(2) DEFAULT NULL,
  `numero_miercoles` int(2) DEFAULT NULL,
  `numero_jueves` int(2) DEFAULT NULL,
  `numero_viernes` int(2) DEFAULT NULL,
  `numero_sabado` int(2) DEFAULT NULL,
  `numero_domingo` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhorario`
--

LOCK TABLES `tblhorario` WRITE;
/*!40000 ALTER TABLE `tblhorario` DISABLE KEYS */;
INSERT INTO `tblhorario` VALUES (1000,1000,'Variable','Lun-Vie 6 horas',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,6,6,6,6,6,NULL,NULL);
/*!40000 ALTER TABLE `tblhorario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblregistro_actividades`
--

DROP TABLE IF EXISTS `tblregistro_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblregistro_actividades` (
  `id_empleado` int(4) NOT NULL,
  `cons` int(4) NOT NULL,
  `id_actividad` int(4) NOT NULL,
  `usuario_creador` varchar(15) NOT NULL,
  `fecha_actividad` date NOT NULL,
  `estado` varchar(8) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  UNIQUE KEY `cons` (`cons`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_actividad` (`id_actividad`),
  KEY `usuario_creador` (`usuario_creador`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblregistro_actividades`
--

LOCK TABLES `tblregistro_actividades` WRITE;
/*!40000 ALTER TABLE `tblregistro_actividades` DISABLE KEYS */;
INSERT INTO `tblregistro_actividades` VALUES (1000,1000,1015,'Wolcres20','2016-03-10','Activo',1000),(1001,1001,1256,'Mateolegi','2016-05-15','Activo',1000),(1002,1002,1256,'Ortiz','2016-04-20','Activo',1000),(1003,1003,1256,'Estropajo','2016-04-23','Activo',1000);
/*!40000 ALTER TABLE `tblregistro_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltipo_actividad`
--

DROP TABLE IF EXISTS `tbltipo_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbltipo_actividad` (
  `id_actividad` int(4) NOT NULL,
  `actividad` varchar(30) NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `estado` varchar(8) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  PRIMARY KEY (`id_actividad`),
  UNIQUE KEY `id_actividad` (`id_actividad`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltipo_actividad`
--

LOCK TABLES `tbltipo_actividad` WRITE;
/*!40000 ALTER TABLE `tbltipo_actividad` DISABLE KEYS */;
INSERT INTO `tbltipo_actividad` VALUES (1015,'Actividades administrativas','Actividades administrativas','Activo',1000),(1100,'PÃ¡gina web','PÃ¡gina web','Inactivo',1000),(1256,'Registro de actividades','Registro de actividades','Activo',1000);
/*!40000 ALTER TABLE `tbltipo_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblusuario`
--

DROP TABLE IF EXISTS `tblusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblusuario` (
  `usuario` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `clave` varchar(128) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `perfil` varchar(20) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `id_empresa` int(4) NOT NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `correo` (`correo`),
  KEY `perfil` (`perfil`),
  KEY `id_empresa` (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblusuario`
--

LOCK TABLES `tblusuario` WRITE;
/*!40000 ALTER TABLE `tblusuario` DISABLE KEYS */;
INSERT INTO `tblusuario` VALUES ('Admin','Pinvalidda','81dc9bdb52d04dc20036dbd8313ed055','Activo','Administrador','mateolegi@pinvalidda.com',1001),('Mateolegi','RAT','81dc9bdb52d04dc20036dbd8313ed055','Activo','Administrador','mateolegi@gmail.com',1000);
/*!40000 ALTER TABLE `tblusuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-20 11:20:04
