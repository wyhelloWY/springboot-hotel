/*
SQLyog Professional v12.08 (64 bit)
MySQL - 8.0.17 : Database - checkdatabase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`checkdatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `checkdatabase`;

/*Table structure for table `collection_list` */

DROP TABLE IF EXISTS `collection_list`;

CREATE TABLE `collection_list` (
  `collection_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '收藏唯一标识',
  `collection_explan` int(8) DEFAULT NULL COMMENT '收藏题解标识',
  `collection_people` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收藏人id',
  `collection_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `collection_list` */

insert  into `collection_list`(`collection_id`,`collection_explan`,`collection_people`,`collection_time`) values (1,1,'20181994','2020-12-10 16:54:25');

/*Table structure for table `comment_list` */

DROP TABLE IF EXISTS `comment_list`;

CREATE TABLE `comment_list` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '评论唯一标识',
  `comment_id` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论id',
  `comment_user_id` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论人id',
  `comment_content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论内容',
  `comment_content_id` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论内容id',
  `comment_date` datetime NOT NULL COMMENT '评论时间',
  `parent_comment_id` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父级评论id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `comment_list` */

insert  into `comment_list`(`id`,`comment_id`,`comment_user_id`,`comment_content`,`comment_content_id`,`comment_date`,`parent_comment_id`) values (1,'1','20181994','HELLO','1','2020-12-10 11:39:39','-1'),(2,'1607757257942','20181994','啊实打实的','1','2020-12-12 03:14:17','-1'),(3,'1607758085662','20181994','防辐射','1','2020-12-12 03:28:05','1607757257942'),(4,'1607758102571','20181994','水电费水电费','1','2020-12-12 03:28:22','-1'),(5,'1607758309006','20181994','哒哒哒','1','2020-12-12 03:31:49','-1'),(6,'1607761560200','20181994','SDADAS','1','2020-12-12 04:26:00','1607758309006'),(7,'1607761569936','20181994','SADSD','1','2020-12-12 04:26:09','1'),(8,'1607790095301','20181996','太强了','5','2020-12-13 00:21:35','-1'),(9,'1607790100709','20181996','真好','5','2020-12-13 00:21:40','1607790095301'),(10,'1607790105153','20181996','嘿嘿','5','2020-12-13 00:21:45','1607790100709');

/*Table structure for table `explanation_list` */

DROP TABLE IF EXISTS `explanation_list`;

CREATE TABLE `explanation_list` (
  `explanation_id` int(8) NOT NULL AUTO_INCREMENT COMMENT ' 题解唯一标识',
  `explanation_subject` int(8) NOT NULL COMMENT '题解对应题目标识',
  `explanation_publisher` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '题解发布者',
  `explanation_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '题解内容',
  `explanation_time` datetime NOT NULL COMMENT '题解发布时间',
  `explanation_like` int(5) DEFAULT '0' COMMENT '题解点赞量',
  `explanation_comment` int(5) DEFAULT '0' COMMENT '题解评论量',
  `explanation_collection` int(5) DEFAULT '0' COMMENT '题解收藏量',
  `explanation_type` int(11) NOT NULL DEFAULT '0' COMMENT '题解审核状态',
  `explanation_score` int(11) DEFAULT '0' COMMENT '题解评分',
  PRIMARY KEY (`explanation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `explanation_list` */

insert  into `explanation_list`(`explanation_id`,`explanation_subject`,`explanation_publisher`,`explanation_content`,`explanation_time`,`explanation_like`,`explanation_comment`,`explanation_collection`,`explanation_type`,`explanation_score`) values (1,1,'20181994','	int array[][] = new int[numRows][numRows];\r\n        for (int i = 0; i < numRows; i++) {\r\n            for (int j = 0; j <= i ; j++) {\r\n                if (j == 0 || j == i) {\r\n                    array[i][j] = 1;\r\n                } else {\r\n                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];\r\n                }\r\n            }\r\n        }\r\n        List<List<Integer>>  lists = new ArrayList<>();\r\n\r\n        for(int i = 0; i < numRows; i++) {\r\n            List<Integer> num = new ArrayList<>();\r\n            for (int j = 0; j <= i; j++) {\r\n                num.add(array[i][j]);\r\n            }\r\n            lists.add(num);\r\n        }\r\n        return lists;','2020-12-09 21:46:06',14,12,36,1,100),(2,1,'20181994','	<pre style=\"background-color:#2b2b2b;color:#a9b7c6;font-family:\'宋体\';font-size:15.0pt;\"><span style=\"color:#cc7832;\">public int </span><span style=\"color:#ffc66d;\">hammingDistance</span>(<span style=\"color:#cc7832;\">int </span>x<span style=\"color:#cc7832;\">, int </span>y) {<br>    <span style=\"color:#808080;\">//Integer.toBinaryString(x)此方法返回int变量的二进制表示的字符串<br></span><span style=\"color:#808080;\">    </span>String xx = Integer.<span style=\"font-style:italic;\">toBinaryString</span>(x)<span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\">    </span>String yy = Integer.<span style=\"font-style:italic;\">toBinaryString</span>(y)<span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\">    if </span>(xx.length()&gt;yy.length()){<br>        <span style=\"color:#cc7832;\">int </span>in =xx.length() - yy.length()<span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\">        for </span>(<span style=\"color:#cc7832;\">int </span>i = <span style=\"color:#6897bb;\">0</span><span style=\"color:#cc7832;\">; </span>i &lt;in<span style=\"color:#cc7832;\">; </span>i++) {<br>            yy=<span style=\"color:#6a8759;\">\"0\"</span>+yy<span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\">        </span>}<br>    }<span style=\"color:#cc7832;\">else if</span>(xx.length()&lt;yy.length()){<br>        <span style=\"color:#cc7832;\">int </span>in =yy.length() - xx.length()<span style=\"color:#cc7832;\">;<br></span><span style=\"color:#cc7832;\">        for </span>(<span style=\"color:#cc7832;\">int </span>i = <span style=\"color:#6897bb;\">0</span><span style=\"color:#cc7832;\">; </span>i &lt;in<span style=\"color:#cc7832;\">; </span>i++) {<br>            xx=<span ...','2020-12-09 21:47:06',17,19,25,1,80),(3,2,'20181994','fdsdafsdfdsf','2020-12-10 05:44:04',0,0,0,0,0),(4,2,'20181996','欢System.out.println(letterContent);UserList userList = (UserList) httpSession.getAttribute(\"user\");String quest_id = (String) httpSession.getAttribute(\"subjectId\");int id = Integer.valueOf(quest_id);LetterList letterList = new LetterList();letterList.setLetterContent(letterContent);letterList.setLetterPublisher(userList.getUserId());letterList.setLetterSubject(id);letterList.setLetterTime(GetDateUtil.getDateTime());int flag = letterService.insertLetter(letterList);ResultMap resultMap = new ResultMap();','2020-12-12 02:47:41',0,0,0,0,0),(5,4,'20181994','欢迎使用 wangEditor 富文&lt;title&gt;动态详情&lt;/title&gt;    &lt;meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"&gt;    &lt;meta name=\"description\" content=\"\" /&gt;    &lt;meta name=\"keywords\" content=\"\" /&gt;    &lt;link rel=\"stylesheet\" href=\"https://www.jq22.com/jquery/bootstrap-4.2.1.css\" th:href=\"@{https://www.jq22.com/jquery/bootstrap-4.2.1.css}\"&gt;    &lt;link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.mCustomScrollbar.min.css\" th:href=\"@{/layuistate/css/jquery.mCustomScrollbar.min.css}\"&gt;&lt;!--    &lt;link rel=\"stylesheet\" type=\"text/css\" href=\"css/index-style.css\" th:href=\"@{/layuistate/css/index-style.css}\"&gt;--&gt;    &lt;link rel=\"stylesheet\" type=\"text/css\" href=\"css/responsive.css\" th:href=\"@{/layuistate/css/responsive.css}\"&gt;    &lt;link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css\"          th:href=\"@{/layuistate/css/semantic.min.css}\"&gt;','2020-12-12 04:27:19',0,0,0,1,0),(6,4,'20181996','LetterList letterList = new LetterList();        letterList.setLetterContent(letterContent);        letterList.setLetterPublisher(userList.getUserId());        letterList.setLetterSubject(id);        letterList.setLetterTime(GetDateUtil.getDateTime());','2020-12-13 00:10:03',0,0,0,0,0),(7,4,'20181996','public ResultMap addLetter(@RequestParam(\"letterContent\") String letterContent, HttpSession httpSession){        System.out.println(letterContent);        UserList userList = (UserList) httpSession.getAttribute(\"user\");        String quest_id = (String) httpSession.getAttribute(\"subjectId\");        int id = Integer.valueOf(quest_id);        LetterList letterList = new LetterList();        letterList.setLetterContent(letterContent);        letterList.setLetterPublisher(userList.getUserId());        letterList.setLetterSubject(id);        letterList.setLetterTime(GetDateUtil.getDateTime());        int flag = letterService.insertLetter(letterList);        ResultMap resultMap = new ResultMap();        if(flag &gt; 0){            resultMap.setMsg(\"添加成功\");            resultMap.setCode(200);        }else{            resultMap.setMsg(\"添加失败\");            resultMap.setCode(201);        }        return resultMap;    }','2020-12-13 00:11:25',0,0,0,1,0),(8,4,'20181996','@PostMapping(\"/getAllComment\")    public String getAllComment(CommentList commentList, HttpSession session) {        UserList userlist = (UserList) session.getAttribute(\"user\");        String user_id = userlist.getUserId();        String comment_id =  GetLongDate.getStringDateId();        commentList.setCommentId(comment_id);        commentList.setCommentUserId(user_id);//        commentList.setImage_file(userListService.selectImage(user_id));//        commentList.setUsername(userListService.selectUsername(user_id));//        System.out.println(commentList);        if (commentList.getParentComment().getCommentId() != null) {            commentList.setParentCommentId(commentList.getParentComment().getCommentId());        }        commentListService.saveComment(commentList);        return \"answerDetail\";    }','2020-12-13 00:20:47',0,0,0,1,0);

/*Table structure for table `letter_list` */

DROP TABLE IF EXISTS `letter_list`;

CREATE TABLE `letter_list` (
  `letter_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '私信唯一标识',
  `letter_publisher` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '私信发布者id',
  `letter_subject` int(8) DEFAULT NULL COMMENT '私信题目id',
  `letter_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '私信内容',
  `letter_time` datetime DEFAULT NULL COMMENT '私信时间',
  `feedback_id` int(8) DEFAULT NULL COMMENT '反馈者id',
  `feedback_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '反馈内容',
  `feedback_time` datetime DEFAULT NULL COMMENT '反馈时间',
  PRIMARY KEY (`letter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `letter_list` */

insert  into `letter_list`(`letter_id`,`letter_publisher`,`letter_subject`,`letter_content`,`letter_time`,`feedback_id`,`feedback_content`,`feedback_time`) values (1,'20181994',2,'阿发','2020-12-12 02:31:50',NULL,NULL,NULL),(2,'20181997',5,'dasdasdasd','2020-12-13 00:23:00',NULL,NULL,NULL);

/*Table structure for table `like_list` */

DROP TABLE IF EXISTS `like_list`;

CREATE TABLE `like_list` (
  `like_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '点赞唯一标识',
  `liker_id` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '点赞id',
  `liked_id` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被点赞id',
  `like_content_id` int(8) DEFAULT NULL COMMENT '被点赞内容id',
  `like_statue` int(2) DEFAULT NULL COMMENT '点赞状态',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `like_list` */

/*Table structure for table `subject_list` */

DROP TABLE IF EXISTS `subject_list`;

CREATE TABLE `subject_list` (
  `subject_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '题目唯一标识',
  `subject_publisher_id` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '题目发布人',
  `subject_title` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '题目标题',
  `subject_content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '题目内容',
  `subject_time` datetime NOT NULL COMMENT '题目发布时间',
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `subject_list` */

insert  into `subject_list`(`subject_id`,`subject_publisher_id`,`subject_title`,`subject_content`,`subject_time`) values (1,'20181994','反转字符串','编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。\n\n不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。\n\n你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。。','2020-12-09 21:03:23'),(2,'20181994','验证回文串','给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。','2020-12-09 21:04:21'),(4,'20181997','求最大数组','给定几个数组 要求求出其中数值最高的数组','2020-12-12 02:48:54'),(5,'20181997','寻找一个链表中重复出现次数最多的一个数','<p>寻找一个链表中重复出现次数最多的一个数</p><p>示例：........................................</p>','2020-12-13 00:22:44');

/*Table structure for table `user_list` */

DROP TABLE IF EXISTS `user_list`;

CREATE TABLE `user_list` (
  `user_id` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id/学号',
  `user_name` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
  `user_pass` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户密码',
  `user_sex` int(2) NOT NULL COMMENT '用户性别',
  `user_type` int(2) NOT NULL DEFAULT '0' COMMENT '用户类型',
  `user_regist` datetime DEFAULT NULL COMMENT '用户注册时间',
  `user_login` datetime DEFAULT NULL COMMENT '用户登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user_list` */

insert  into `user_list`(`user_id`,`user_name`,`user_pass`,`user_sex`,`user_type`,`user_regist`,`user_login`) values ('20181994','hello','123456',1,1,'2020-12-10 12:37:42','2020-12-10 12:37:44'),('20181996','吴国','123456',1,1,'2020-12-12 14:45:07','2020-12-12 14:45:08'),('20181997','JAVA','123456',1,2,'2020-12-12 13:20:17','2020-12-12 13:20:18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
