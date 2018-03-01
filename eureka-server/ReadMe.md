# 服务注册中心 （分布式）

+ 配置文件application-peer1.yml
```
server:
  port: 7090

spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1
  client:
    serviceUrl:
      defaultZone: http://peer2:7091/eureka/
```

+ 配置文件application-peer2.yml
```
server:
  port: 7091

spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: http://peer1:7090/eureka/
```