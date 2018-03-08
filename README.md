***//TODO***

1. spring cloud feign : camden.sr7下继承特性中的服务降级  改动较大，demo未实现
2. eureka server : 集群服务通讯不及时导致的异常<业务不影响>

***//DONE***

 1. 高可用的集群注册中心
 2. feign对服务双方的糅合《客户端负载均衡，服务端服务熔断以及降级》
 3. API网关
 4. 分布式配置中心 spring cloud config
 5. 分布式服务追踪 sleuth + zipkin
 
 
 技术点：
 -------------------------------------------------------------------------------------------------------------------------

 #### spring cloud eureka : 服务治理 
 
	简述-- ：微服务架构中的服务治理功能，包含服务端和客户端组件，并且均采用java编写
				1）服务端：也就是服务注册中心，支持高可用配置。依托于强一致性提供良好的服务实例可用性，可以
						   应对多种不同的故障场景。
				2）客户端：主要处理服务的注册与发现。客户端服务通过注解和参数配置的方式，嵌入在客户端应用程序的
						   代码中，在应用程序运行时，eureka客户端向注册中心注册自身提供的服务并周期性的发送心跳来更新
						   它的租约。同时，他也能总服务端查询当前注册的服务信息并把它们缓存到本地并周期性的刷新服务状态。
	功能-- ：服务注册
			 服务发现
			 服务剔除
			 高可用（集群）
       
#### spring cloud feign : 声明式服务调用
	
	1）整合ribbon , hystrix
	2) 声明式的WEB服务客户端定义方式
	3）继承特性实现客户端与服务端的DTO共用<开发敏捷，维护繁琐>
	
	
#### spring cloud zuul : API 网关

	简述-- ：微服务系统架构的门面，所有的外部客户端访问都需要经过它来进行调度和过滤
	功能-- ：请求路由（面向服务<eureka的服务发现机制>，简单的配置完成路由映射实例的维护问题 && 迭代版本号的支持-249）
			 校验过滤（自定义过滤器<类型，顺序，范围，逻辑>）
			 负载均衡
			 线程隔离
			 断路器
			 动态加载：
			 		1）动态修改路由规则
			 		2）动态添加、删除过滤器

 
	总结：
		1）作为系统的统一入口，屏蔽了系统内部的各个微服务的细节。
		2）作为与服务治理框架结合，实现自动化的服务实例维护以及负载均衡的路由转发。
		3）可以实现接口权限校验与微服务业务逻辑的解耦。
		4）通过服务网关中的过滤器，在各生命周期中去校验请求的内容，将原本在对外服务层做的校验前移，
			保证了微服务的无状态性，同时降低了微服务的测试难度，让服务本身更集中关注业务逻辑的处理。

	注意：
		重定向问题需要使用Camden版本
		/routes 返回当前所有的路由规则
		
### spring cloud config ：分布式配置中心
		
		简述：spring cloud团队创建的一个全新的项目，用来为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持。

		读取远程配置时，会在本地进行文件暂存。

		缺点：没有UI管理界面
		
### spring cloud sleuth ：分布式服务跟踪

	zipkin：使用的时候，spring boot不能使用2.0版本，使用1.5版本没有异常信息
-------------------------------------------------------------------------------------------------------------------------

   

