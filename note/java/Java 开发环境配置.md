# Java 开发环境配置
在本章节中我们将为大家介绍如何搭建Java开发环境。

window系统安装java

## 下载JDK
首先我们需要下载java开发工具包JDK，下载地址：http://www.oracle.com/technetwork/java/javase/downloads/index.html

在下载页面中你需要选择接受许可，并根据自己的系统选择对应的版本，本文以 Window 64位系统为例：

下载后JDK的安装根据提示进行，还有安装JDK的时候也会安装JRE，一并安装就可以了。

安装JDK，安装过程中可以自定义安装目录等信息，例如我们选择安装目录为 C:\Program Files (x86)\Java\jdk1.8.0_91。

## 配置环境变量
1.安装完成后，右击"我的电脑"，点击"属性"，选择"高级系统设置"；

![](https://i.imgur.com/RdZ1yZc.png)

2.选择"高级"选项卡，点击"环境变量"；

![](https://i.imgur.com/eE77V6a.png)

然后就会出现如下图所示的画面：

![](https://i.imgur.com/S0NEx55.png)

在"系统变量"中设置3项属性，JAVA_HOME,PATH,CLASSPATH(大小写无所谓),若已存在则点击"编辑"，不存在则点击"新建"。

变量设置参数如下：

	变量名：JAVA_HOME
	变量值：C:\Program Files (x86)\Java\jdk1.8.0_91        // 要根据自己的实际路径配置
	变量名：CLASSPATH
	变量值：.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;         //记得前面有个"."
	变量名：Path
	变量值：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
JAVA_HOME 设置

![](https://i.imgur.com/p4id1x9.png)

![](https://i.imgur.com/r1jSJQr.png)

PATH设置

![](https://i.imgur.com/xpyf3FD.png)

![](https://i.imgur.com/l2XsJWq.png)

CLASSPATH 设置

![](https://i.imgur.com/b63Frau.png)

这是 Java 的环境配置，配置完成后，你可以启动 Eclipse 来编写代码，它会自动完成java环境的配置。
注意：如果使用1.5以上版本的JDK，不用设置CLASSPATH环境变量，也可以正常编译和运行Java程序。
测试JDK是否安装成功

1、"开始"->"运行"，键入"cmd"；

2、键入命令: java -version、java、javac 几个命令，出现以下信息，说明环境变量配置成功；

![](https://i.imgur.com/BPaXMHF.png)

## Linux，UNIX，Solaris，FreeBSD环境变量设置

环境变量PATH应该设定为指向Java二进制文件安装的位置。如果设置遇到困难，请参考shell文档。
例如，假设你使用bash作为shell，你可以把下面的内容添加到你的 .bashrc文件结尾: export PATH=/path/to/java:$PATH

## 流行JAVA开发工具

正所谓工欲善其事必先利其器，我们在开发java语言过程中同样需要依款不错的开发工具，目前市场上的IDE很多，本文为大家推荐以下下几款java开发工具：


Eclipse（推荐）:另一个免费开源的java IDE，下载地址： http://www.eclipse.org/
选择 Eclipse IDE for Java Developers：

Notepad++ : Notepad++ 是在微软视窗环境之下的一个免费的代码编辑器，下载地址： http://notepad-plus-plus.org/

Netbeans:开源免费的java IDE，下载地址： http://www.netbeans.org/index.html