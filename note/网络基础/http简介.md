# HTTP简介
> HTTP(HyperText Transport Protocol)协议是互联网上应用最为广发的一种网络协议标准，所有的www文件都必须遵守这个标准。
> 
HTTP是一个适用于分布式超媒体信息系统的应用层协议。它于1990年提出，并得到不断地完善和扩展。

## HTTP协议的主要特点：

- 支持C/S（客户/服务器）模式。
- 简单快速.客户向服务器请求服务时，只需传送请求方法和路径。请求方法常用的有GET、POST、HEAD，每种方法规定了客户与服务器联系的类型不同。因为HTTP协议简单，使得HTTP服务器的程序规模小，因而通信速度很快。
- 灵活：HTTP允许传输任意类型的数据对象。正在传输的类型由Content-Type加以标记。
- 无连接：无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。采用这种方式可以节省传输时间。
- 无状态：HTTP协议是无状态协议，无状态是指协议对于事务处理没有记忆能力。缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快。

![](https://i.imgur.com/G2m302R.png)

**HTTP URL 的格式如下**

	http://host[":"port][abs_path]

- http表示要通过HTTP协议来定位网络资源；
- host表示合法的Internet主机域名或者IP地址；
- port指定一个端口号，为空则使用默认端口80；abs_path指定请求资源的URI（Uniform Resource Identifier,纸Web上任意的可用资源）。

## HTTP有两类报文：请求报文和响应报文。

HTTP请求报文
一个HTTP请求报文由请求行、消息报头、空行和请求数据4个部分组成。请求报文的一般格式如下所示：

![](https://i.imgur.com/SgDBmWi.png)

**HTTP请求报文**

HTTP请求报文
（1）请求行

请求行由请求方法字段、URI字段和HTTP协议的版本字段组成，它们之间用空格分开，格式如下：

	Method Request-URI HTTP-Version CRLF
	例如：GET /from.html HTTP/1.1 (CRLF)

其中 Method表示请求方法；Request-URI是一个统一资源标识符；HTTP-Version表示请求的HTTP协议版本；CRLF表示回车和换行（除了作为结尾的CRLF外，不允许出现单独的CR或LF字符）。

请求方法	含义

	GET	请求获取Request-URI所标识的资源
	POST	在Request-URI所标识的资源后附加新的数据
	HEAD	请求获取由Request-URI所标识的资源的响应消息报头
	PUT	请求服务器存储一个资源，并用Request-URI作为其标识
	DELETE	请求服务器删除Request-URI所标识的资源
	TRACE	请求服务器回送收到的请求信息，主要用于测试或诊断
	CONNECT	HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器。
	OPTIONS	请求查询服务器的性能，或者查询与资源相关的选项和需求
	HTTP请求方法有8种，分别是GET、POST、DELETE、PUT、HEAD、TRACE、CONNECT 、OPTIONS。其中PUT、
    DELETE、POST、GET分别对应着增删改查，对于移动开发最常用的就是POST和GET了。


（2）消息报头

	这部分稍后再详细说。

（3）空行

	最后一个请求头之后是一个空行，发送回车符和换行符，通知服务器以下不再有请求头。

（4）请求数据

	请求数据不在GET方法中使用，而是在POST方法中使用。POST方法适用于需要客户填写表单的场合。与请求数     
    据相关的、最常使用的请求头是Content-Type和Content-Length。
	
	在接收数据和解释请求消息后，服务器会返回一个HTTP响应消息。

HTTP响应报文

HTTP响应报文也是由4个部分组成的，分别是：状态行、消息报头、空行、响应正文。如下图所示：

![](https://i.imgur.com/DZXWjCF.png)

**HTTP响应报文**

HTTP响应报文
（1）状态行

状态行的格式如下：

	HTTP-Version Status-Code Reason-Phrase CRLF
	例如：HTTP/1.1 200 OK (CRLF)
	其中，HTTP-Version表示服务器HTTP协议的版本；Status-Code表示服务器发回的响应状态代码；Reason-Phrase表示状态代码的文本描述。

状态代码有三位数字组成，第一个数字定义了响应的类别，且有五种可能取值：

	100~199：指示信息，表示请求已接收，继续处理
	200~299：请求成功，表示请求已被成功接收、理解、接受
	300~399：重定向，要完成请求必须进行更进一步的操作
	400~499：客户端错误，请求有语法错误或请求无法实现
	500~599：服务器端错误，服务器未能实现合法的请求

状态代码具体种类很多，这里列出常见的状态吗。

状态代码	状态描述

	200 OK	客户端请求成功
	400 Bad Request	客户端请求有语法错误，不能被服务器所理解
	401 Unauthorized	请求未经授权
	403 Forbidden	服务器收到请求，但是拒绝提供服务
	404 Not Found	请求资源不存在，比如输入了错误的URL
	500 Internal Server Error	服务器发生不可预期的错误
	503 Server Unavailable	服务器当前不能处理客户端的请求，一段时间后可能恢复正常

（2）消息报头

	在下面介绍。

（3）空行

	这行是空行。

（4）响应正文

	响应正文就是服务器返回的资源的内容。

HTTP消息报头

- HTTP消息由客户端到服务器的请求和服务器到客户端的响应组成。请求消息和响应消息都是由开始行（对于请求消息，状态就是请求行；对于响应消息，开始行就是状态行）、消息报头（可选）、空行（只有CTRF的行）、消息正文（可选）4部分组成。
	
- 消息报头分为普通报头、请求报头、响应报头、实体报头等。消息头由键值对（头部字段名/值）组成，每行一对，关键字和值用英文冒号“:”分隔。形式如下：
	
- 头部字段名 +":"+空格 + 值
- 消息报头头部字段名是大小写无关的。

（1）普通报头：

即可以用于请求，也可用于响应，不用于被传输的实体，只用于传输消息，是作为一个整体而不是特定资源与事务相关联。例如：

	Date：表示消息产生的日期和时间
	Connection：允许发送指定连接的选项，例如指定连接是连续的，或者指定“close”选项，通知服务器，在响应完成后，关闭连接

（2）请求报头：

允许客户端传递关于自身的信息和希望的响应形式。请求报头通知服务器有关客户端请求的信息，典型的请求报头如下几种。

	Host：请求的主机名，允许多个域名同处一个IP地址，即虚拟主机。
	User-Agent ：包含产生请求的操作系统、浏览器类型等信息。
	Accept：客户端可识别的内容类型列表，用于指定客户端接受哪些类型的信息。
	Accept-Encoding：客户端可识别的数据编码
	Accept-Language：表示浏览器所支持的语言类型
	Accept-Charset：浏览器采用的是哪种编码 如：Accept-Charset: ISO-8859-1
	Connection：允许客户端和服务器指定与请求/响应连接有关的选项，例如这是为Keep-Alive则表示保持连接。
	Transfer-Encoding：告知接收端为了保证报文的可靠传输，对报文采用了什么编码方式。

（3）响应报头：

用于服务器传递自身信息的响应，常见的响应报头：

	Location：用于重定向接受者到一个新的位置，常用在更换域名的时候
	Server：包含可服务器用来处理请求的系统信息，与User-Agent请求报头是相对应的.

（4）实体报头：

定于被传送资源的信息。既可以用于请求，也可用于响应。请求和响应消息都可以传送一个实体，常见的实体报头为：

	Content-Type：发送给接收者的实体正文的媒体类型
	Content-Lenght：实体正文的长度
	Content-Language：描述资源所用的自然语言，没有设置则该选项则认为实体内容将提供给所有的语言阅读
	Content-Encoding：实体报头被用作媒体类型的修饰符，它的值指示了已经被应用到实体正文的附加内容的
                     编码，因而要获得Content-Type报头域中所引用的媒体类型，必须采用相应的解码机制。
	Last-Modified：实体报头用于指示资源的最后修改日期和时间
	Expires：实体报头给出响应过期的日期和时间

HTTP报文示例
get请求

访问我的博客 http://blog.csdn.net/hj2drf
请求报文

	GET http://blog.csdn.net/vnanyesheshou HTTP/1.1   //请求行
	Host: blog.csdn.net                 //请求报头
	Connection: keep-alive
	Cache-Control: max-age=0
	Upgrade-Insecure-Requests: 1
	User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 
		(KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36
	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
	Accept-Encoding: gzip, deflate
	Accept-Language: zh-CN,zh;q=0.8
	Cookie: uuid_tt_dd=-1205275839430178051_20170417; bdshare_firstime=1492437984444; 
	UM_distinctid=15d02126ec433b-05cbdcfaa61095-333f5902-100200-15d02126ec5805; 
	UN=VNanyesheshou; UE=""; BT=1498978406572; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; uuid=776d64a5-fe9f-4005-912c-aa9cc5d4283a; TY_SESSION_ID=a7afad62-bcc6-4390-8e04-7bfefe0addfd; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1498978348,1501397302; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1501398302; CNZZDATA1262013314=1683604614-1498975340-%7C1501396556; dc_tos=otw6ce; dc_session_id=1501398302320
	        //空行
	
get请求没有请求数据，所以这里也是空行。

响应报文

	HTTP/1.1 200 OK             //状态行
	Server: openresty           //响应报头
	Date: Sun, 30 Jul 2017 07:09:01 GMT
	Content-Type: text/html; charset=utf-8
	Transfer-Encoding: chunked
	Connection: keep-alive
	Keep-Alive: timeout=20
	Vary: Accept-Encoding
	Cache-Control: private
	X-Powered-By: PHP 5.4.28
	Content-Length: 51577
	                        //空格
	<!DOCTYPE html PUBLIC 太长省略了。    //响应正文

post请求

请求报文

	POST http://120.25.226.186:32812/login HTTP/1.1
	Host: 120.25.226.186:32812
	User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 
		(KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36
	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
	Accept-Encoding: gzip, deflate
	Accept-Language: zh-CN,zh;q=0.8
	Connection: Keep-Alive
	Content-Type: application/x-www-form-urlencoded; charset=UTF-8
	Content-Length: 24
	
	username=520it&pwd=520it
响应报文

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json;charset=UTF-8
	Transfer-Encoding: chunked
	Date: Sun, 30 Jul 2017 08:17:09 GMT
	
	1a
	{"success":"登录成功"}
	0

![](https://i.imgur.com/pFRzuY4.png)![](https://i.imgur.com/Zxfm4qe.png)

