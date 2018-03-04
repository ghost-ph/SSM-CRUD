# SSM-CRUD
## 开发环境：
* Intellij idea 2017
* jdk8
* MySQL5.7
## 使用及功能：
* 数据库在工程resource中的ssm-crud.sql中，直接导入到本地数据库即可
* 使用Maven构建spring+springMVC+mybatis项目，实现srud功能。
* 持久层直接采用mybatis Generator产生，也可以根据自己需要来进行修改。
* 使用mybatis的pagehelper来实现分页
* 为了显示方便，数据库中的数据采用mybatis批量插入，数据格式采用UUID随机生成
* 前端使用bootstrap来快速搭建美观的界面，可实现用户基本的增删改查
