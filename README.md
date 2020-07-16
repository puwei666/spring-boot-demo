# java spring demo

* 测试环境打包方式：

    ```bash
    mvn clean package -Dmaven.test.skip=true -Ptest
    ```
    
* 该 demo 项目使用 spring boot 框架
* 目前项目使用 idea 开发， demo-web 为 web项目入口 module
* module 中：
    * `src/main/java` 为 Java 源码
    * `src/main/resources` 为配置
    * `src/main/profiles` 为个环境配置，配置项会替换 resources 中单项目配置
* 项目使用 slf4j + log4j2 作为日志记录工具
* 测试路径：
   
    ```
    /hello
    /get?id=1
    /list 
    ```
    
 