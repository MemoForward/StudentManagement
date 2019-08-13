# StudentManagement
学生管理系统（JSP + Servlet + MySql）

**具体请移步我的博客：**

#实现功能
- 学生列表的增删改查
- 分页
- 过滤器实现UTF-8编码
- 一个Servlet实现多种请求

#使用
- 将项目克隆到本地
- 使用Intellj IDEA import Project // 配置好自己的JDK，其他的一路next
- 在Add configure中部署自己的tomcat
- 在project structure -- Modules选项中添加tomcat库，并将所有库勾选+Apply // 参考 https://blog.csdn.net/qq_41283865/article/details/81865806
- 在project structure -- facets 中create Artifacts //右下有警告，或者参考 https://blog.csdn.net/tj867182298/article/details/83308483 手动创建
- 在project structure -- Artifacts 中将右侧的lib添加到左侧中（点右下的fix一般就可）
- 在Edit congigure中将Artifacts通过tomcat发布// edit configure和Add confiure的位置是一样的，这一步不配置你会看到tomcat上有个红叉
- 创建自己的学生数据库 //我的博客中有sql语句，复制即可
- 修改c3p0-config.xml中配置
- 启动tomcat

# 项目预览
## 主界面
![主界面](https://github.com/MemoForward/StudentManagement/blob/master/StudentManagement/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9Fimg/%E4%B8%BB%E7%95%8C%E9%9D%A2.png)

## 添加学生界面
![添加学生](https://github.com/MemoForward/StudentManagement/blob/master/StudentManagement/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9Fimg/%E6%9F%A5%E8%AF%A2%E5%AD%A6%E7%94%9F.png)

## 编辑学生界面
![编辑学生](https://github.com/MemoForward/StudentManagement/blob/master/StudentManagement/%E5%AD%A6%E7%94%9F%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9Fimg/%E7%BC%96%E8%BE%91%E5%AD%A6%E7%94%9F.png)
