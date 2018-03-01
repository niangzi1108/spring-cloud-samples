#### 分布式配置中心

**application.properties文件配置**
- spring.cloud.config.server.git.uri：配置git仓库地址
- spring.cloud.config.server.git.searchPaths：配置仓库路径
- spring.cloud.config.label：配置仓库的分支
- spring.cloud.config.server.git.username：访问git仓库的用户名
- spring.cloud.config.server.git.password：访问git仓库的用户密码

> 如果Git仓库为公开仓库，可以不填写用户名和密码，如果是私有仓库需要填写


- {application}映射到Config客户端的spring.application.name属性
- {profile}映射到Config客户端的spring.profiles.active属性，可以用来区分环境，比如dev，test，produce等等
- {label}映射到Git服务器的commit id,分支名称或者tag，默认值为master

**http请求地址和资源文件映射如下**
> 仓库中的配置文件会被转换成web接口，访问可以参照以下的规则

+ /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties

*举个栗子*

 >     cloud-config-rd.properties
 >     cloud-config-dev.properties
 >     cloud-config-test.properties
 >     cloud-config-test.properties
 > 以cloud-config-rd.properties为例子，它的application是cloud-config，profile是rd.client会根据填写的参数来选择读取对应的配置。


