#基本设计思路说明 
##接口请求规范：  
###头部必须包含信息: 
*sessionToken:单次会话的id,用来做链路追踪  
*RequestId:单次请求的id，用来做请求跟踪  
*lang:语言标识   
*region:地区  
*timeZone:请求端时间时区  
*requestTimesstamp:请求服务器时刻的时间戳(注意时间戳是不依赖于时区)  
*source:来源标识  
*userid：用户id号，guest登录用guest(方便后续扩容的时候做分流)  

  
###返回值：
返回包括两种：  
页面(freemarker)  
json数据:json数据封装在responseEntity中  


###包目录说明
annotation 注解包
aop  切面处理包，目前只针对缓存注解
constants  常量包
context   请求上下文存放
controller 控制层
exception 自定义异常，全部都需要继承自baseexception
interceptor 拦截器 针对请求做处理，目前封装了登录权限校验、请求上下面封装两个类
job 定时任务类
manager 所有业务逻辑应该写在这里，包括外部接口调用
model 实体类，对应数据表
response  请求返回相关
service 服务层，提供原子性的服务，这里设计不再提供dao层实现，因为有基类



##总共分成四层架构
interceptor：针对权限、入参进行拦截  
controller:参数入口，基本的参数校验可以放在interceptor，这里主要做核心业务的参数校验  
manager;业务主要覆盖，service服务的组合、外部接口的调用、业务逻辑的编写都在这层  
service:主要数据服务提供层，尽量确保所有服务方法都是原子(不可分解的)  
dao:这一层尽量只使用基类模板basedao，除非有特殊复杂的sql，否则不考虑编写代码。保证简洁  
context；threadlocal<map>构造，存放一些线程共享的变量，特别是requestheader头部的变量，会经过interceptor提取，提取后保存到这里  




##基础框架说明  
本框架基于几个大模块，springmvc , mainutil, dexcoder的orm框架(基于springjdbc的封装)  
###mainutil包  
<https://github.com/Stevenhuangqian/mainutil/>  
###dexcoder  
<https://gitee.com/selfly/dexcoder-assistants/>  
###缓存注解的介绍  
缓存注解基于两个部分@Cacheable和@CacheEvict两个，一个是增加缓存一个是清除缓存  
鉴于目前框架设计，限定这两个缓存只能在service层使用。  