# StudentGradeManageSystem（Swing+JDBC+MySQL）
学生成绩管理系统
### 一、 题目具体要求：
①设计内容:
* (1)对“学生成绩管理系统”进行需求调研，完成概念模型和逻辑结构设计；
* (2)建立“学生成绩管理系统”数据库；
* (3)编程实现“学生成绩管理系统”，主要包括用户登录（该系统中涉及到的用户包括学生、任课教师、教务处，输入自己的账号和密码登录系统后，进入不同的操作界面）、学生基本信息管理（学生的基本信息进行管理，可以方便灵活的进行添加、删除、修改和查询的功能）、学生选课管理（对现有的课程信息进行查询，保存学生选课信息）、 成绩管理（成绩录入和成绩查询两部分。首先教师可以通过成绩录入对成绩进行添加和维护。然后学生便可以通过各种查询方式显示出自己各科的成绩） 

②设计要求：
* (1) 采用图形化界面；
* (2) 操作方便、界面友好；
* (3) 撰写课程设计说明书。

### 二、系统功能截图展示：
* 登陆界面
>![学生成绩管理主界面](https://github.com/5454135620/ICON/blob/master/学生成绩管理系统主界面.png)
* 学生子系统
>![学生子系统主界面](https://github.com/5454135620/ICON/blob/master/%E5%AD%A6%E7%94%9F%E5%AD%90%E7%B3%BB%E7%BB%9F%E4%B8%BB%E7%95%8C%E9%9D%A2.png)
* 教师子系统
>![教师子系统界面](https://github.com/5454135620/ICON/blob/master/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E5%AD%90%E7%B3%BB%E7%BB%9F%E4%B8%BB%E7%95%8C%E9%9D%A2.png)
* 教务处子系统
>![教务处子界面](https://github.com/5454135620/ICON/blob/master/%E6%95%99%E5%8A%A1%E5%A4%84%E4%B8%BB%E7%95%8C%E9%9D%A2.png )
* 基本功能实现界面展示：
* ①教务处学生管理界面：
>![教务处学生管理](https://github.com/5454135620/ICON/blob/master/%E6%95%99%E5%8A%A1%E5%A4%84%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86.png)
* ②学生选课界面管理：
>![学生选课界面管理](https://github.com/5454135620/ICON/blob/master/%E5%AD%A6%E7%94%9F%E9%80%89%E8%AF%BE%E7%AE%A1%E7%90%86.png )


### 三、基础知识：
* ① 系统E-R（实体关系图）创建：
* ② 数据库创建明细：
* ③ mvc
* ④ JDBC基础

### 四、具体创建：
*   ① 学生基本信息：
学生基本信息包括:学号、姓名、性别、年龄、专业、班级、电话号码、登录密码。  
*   ② 教师基本信息：
教师基本信息包括：教师号、姓名、性别、系别、学历、职称、电话号码、登录密码。
*   ③ 课程基本信息：
课程基本信息包括：课程号、课程名、学分。
*   ④ 选课基本情况：
选课基本情况包括：学号、TC_id、成绩。
*   ⑤ 授课基本情况：
授课基本情况包括：教师号、课程号、TC_id
*   ⑥ 用户基本信息：
用户基本信息包括：用户名、用户类别、密码。

* 具体编写的完整性和用户约束略

* 系统功能图：
>![系统功能图](https://github.com/5454135620/ICON/blob/master/%E5%AD%A6%E7%94%9F%E6%88%90%E7%BB%A9%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%9B%BE.png)
* 实体关系图：
>![实体关系图](https://github.com/5454135620/ICON/blob/master/%E5%AE%9E%E4%BD%93%E5%85%B3%E7%B3%BB%E5%9B%BE.png )