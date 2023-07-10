# EmployeeManagementSystem
This repository was built for the USTB summer internship

该仓库是为了北京科技大学暑期认识实习小组项目所创建



> 本仓库使用Apache2.0 license，欢迎借鉴学习



## 命名规则

数据库及table命名全部小写

列名及成员名采用首字母小写的驼峰命名法

所有表关系

- UserLogin

  - id——自行添加，作为主键，不出现在网页上

  - password

  - employeeId——工号

  - name

  - photo

  - department

  - position——职务

  - isAdministrator——是否为管理员

- Customer

  - id——自行添加，作为主键，不出现在网页上

  - interest——意向

  - addTime

  - website

  - companyName

  - contactPerson

  - contactNumber

  - contactResult——通话结果

  - companyAddress

  - employee——客户对应的员工

- VipCustomer

  - systemId——系统编号

  - productType

  - companyName

  - website

  - id——ID号

  - regTime——注册日期

  - password

  - contractAmount——合同金额

  - recharge——充值

  - contactPerson

  - employee

- CustomerProtection——客户保护

  - id——自行添加，作为主键，不出现在网页上

  - companyName

  - website

  - contactPerson

  - contactNumber

  - addTime

  - endTime

  - 续保——不清楚什么意思，可以删掉

  - additionalInformation——备注

  - leaderOpinion

  - employee

- FollowUp——回访

  - id——自行添加，作为主键，不出现在网页上

  - visitTime

  - companyName

  - costumerTitle——客户称呼

  - costomerAddress

  - costomerNumber

  - visitTime——拜访用时

  - visitResult——拜访结果

  - postProcess——后期处理

  - additionalInformation

  - administrativeFollowUp——行政回访

  - leaderOpinion

  - employee

- Employee

  - id——自行添加，作为主键，不出现在网页上

  - department

  - name

  - position

  - employeeId

  - sex

  - ranking——排序

  - level——级别

  - authority——权限

  - resume——简历图片

- Department

  - id——自行添加，作为主键，不出现在网页上

  - name

  - introduction

  - ranking

- DepartmentPosition

  - id——自行添加，作为主键，不出现在网页上

  - departmentName

  - departmentPosition

  - positionIntroduction

  - ranking

- ServiceTicket——工单

  - owner——所属人

  - companyName

  - website

  - id

  - productType

  - regTime——注册日期

  - productionTeam——制作人员

  - yesterdayProgress——昨日进度

  - leaderOpinion

  - employee
