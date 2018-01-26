##使用说明
###基本设计思路说明
接口请求规范：
头部必须包含信息:
sessionToken:单次会话的id,用来做链路追踪
RequestId:单次请求的id，用来做请求跟踪
lang:语言标识
region:地区
timeZone:请求端时间时区
requestTimesstamp:请求服务器时刻的时间戳(注意时间戳是不依赖于时区)
source:来源标识
userid：用户id号，guest登录用guest(方便后续扩容的时候做分流)


返回值：
返回包括两种：页面(freemarker)
json数据
json数据封装在responseEntity中



总共分成四层架构
interceptor：针对权限、入参进行拦截
controller:参数入口
manager;
service:
dao:
context；threadlocal<map>构造，存放一些线程共享的变量，特别是requestheader头部的变量，会经过interceptor提取，提取后保存到这里







###基础框架说明
本框架基于几个大模块，springmvc , mainutil, dexcoder的orm框架(基于springjdbc的封装)
####mainutil包
https://github.com/Stevenhuangqian/mainutil
####dexcoder
https://gitee.com/selfly/dexcoder-assistants
###缓存注解的介绍
缓存注解基于两个部分@Cacheable和@CacheEvict两个，一个是增加缓存一个是清除缓存
鉴于目前框架设计，限定这两个缓存只能在service层使用。