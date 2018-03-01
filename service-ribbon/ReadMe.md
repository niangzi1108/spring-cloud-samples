# 服务消费者 （rest + ribbon）负载均衡

 > Hystrix断路器 异常处理

 > Feign是自带断路器的，在D版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码：

 >     feign.hystrix.enabled=true

