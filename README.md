### 后台权限管理系统
[![OSCS Status](https://www.oscs1024.com/platform/badge/pj153/gradle.git.svg?size=small)](https://www.murphysec.com/dr/vmHwnkMaZe86ipS2r3)

基于SpringBoot，Spring Security，JWT的前后端分离的权限管理系统后端
通过修改数据库可方便的进行登录用户的权限控制 内置mybatis-plus逆向工程

**前台对android进行适配，正在搭建过程...** 

#### 版本管理
+ 数据库：mysql:8.0.28
+ 后端项目构建工具：gradle:7.5
+ 权限管理：spring-security:5.3.2RELEASE
+ 数据库连接：mybatis-plus:3.3.1.tmp
+ 缓存：redis
+ 接口文档：swagger3 ui使用：knife4j

#### 后台简介
+ 后端采用Spring Boot、Spring Security、Redis & Jwt。
+ 权限认证使用Jwt，支持多终端认证系统。
+ 支持加载动态权限菜单，多方式轻松权限控制。


#### 模块简介
+ gradle-generator mybatis-plus逆向工程
+ gradle-system 后端基础内容 包含用户管理 权限管理...
+ gradle-server 扩展业务逻辑 其将被引入gradle-system中 对其进行权限控制

#### gradle-system登录授权过程
+ 用户通过登录接口进行登录 然后查询用户角色权限表中角色，查询到用户所拥有的角色，然后进行查询该角色下拥有的菜单
+ 授权管理 通过用户id查询到所拥有的角色 对用户访问的url进行拦截，查询访问url所需要的角色，若角色符合，则授权访问，否则拦截

