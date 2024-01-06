
视频教程：
https://www.bilibili.com/video/BV15a411A7kP?p=24&vd_source=2cb0ef00b48f8857a3fd15d8778faebc

|-micro_parent                          父工程pom文件，用于定义版本依赖
  |-common

    |-service_base                      编写使用工具类，如MD5加密等
      |-com.example.utils
        |-exceptionhandler
          |-GlobalExceptionHandler.java 全局异常处理类
          |-GuliException.java          自定义异常
        |-handler
          |-MyMetaObjectHandler.java    mybatis plus全局操作类
        |-utils
          |-MD5.java                    字符串加密
          |-R.java                      定义所有controller返回统一对象
          |-ResponseUtils.java          数据返回
        |-RedisConfig.java              Redis工具类
        |-SwaggerConfig.java            Swagger工具类

    |-spring_security                   SpringSecurity相关配置
      |-com.example.security
        |-config
          |-TokenWebSecurityConfig.java 核心配置类
        |-entity
          |-SecurityUser.java           用户认证实体类
          |-User.java                   用户实体类
        |-filter
          |-TokenLoginFilter            认证（登录）过滤器
          |-TokenAuthFilter             授权过滤器
        |-security
          |-DefaultPasswordEncoder.java 密码处理工具类
          |-TokenManager.java           token操作工具类（使用JWT生成）
          |-TokenLogoutHandler.java     退出登录处理类
          |-UnauthEntryPoint.java       未授权统一处理类

  |-infrastructure
    |-api_gateway                       配置gateway网关
      |-com.example.gateway
        |-CorsConfig.java               跨域配置类

  |-service
    |-service_account                   实现权限管理功能代码
      |-com.example.accountservice
        |-controller
          |-IndexController.cs          登录用户信息控制器
          |-PermissionController.cs     权限，菜单控制器
          |-RoleController.cs           角色控制器
          |-UserController.cs           用户控制器
        |-entity
        |-helper
        |-mapper
        |-servie
        |-ServiceAclApplication.java      service_account 启动入口类


环境部署：
Redis
  启动命令：
  redis-server.exe

  port: 6379
  pid:  15388
  host: 127.0.0.1

Nacos
  https://blog.csdn.net/xiaojin21cen/article/details/125993132
  启动：
  \nacos-server-1.1.4\nacos\bin\startup.cmd
  访问地址：
  http://localhost:8848/nacos

  user: nacos
  psd:  nacos

  Port: 8848

Vue
  环境：需要安装nodejs
  启动命令:npm run dev
  访问地址：
  http://localhost:9528/

  error:03000086 解决
  https://blog.csdn.net/ddttxx/article/details/130827146
  Windows 64-bit with Unsupported runtime解决方法
  https://www.cnblogs.com/molice/p/16240363.html


  启动顺序：
  Redis->Nacos->api_gateway->service_account->Web

