# Kotlin 简介

> <font size=3>Kotlin 是一种在 Java 虚拟机上运行的静态类型编程语言，被称之为 Android 世界的Swift，由 JetBrains 设计开发并开源。

Kotlin 可以编译成Java字节码，也可以编译成 JavaScript，方便在没有 JVM 的设备上运行。
在Google I/O 2017中，Google 宣布 Kotlin 成为 Android 官方开发语言。

Kotlin 程序文件以 .kt 结尾，如：hello.kt 、app.kt。

最简版

	package hello                      //  可选的包头
	 
	fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
	   println("Hello World!")         // 分号可以省略
	}

运行实例 »
面向对象
class Greeter(val name: String) {
   fun greet() { 
      println("Hello, $name")
   }
}
 
fun main(args: Array<String>) {
   Greeter(args[0]).greet()          // 创建一个对象不用 new 关键字
}

运行实例 »
为什么选择 Kotlin？

	简洁: 大大减少样板代码的数量。
	安全: 避免空指针异常等整个类的错误。
	互操作性: 充分利用 JVM、Android 和浏览器的现有库。
	工具友好: 可用任何 Java IDE 或者使用命令行构建。

参考链接

- [官方网站](http://kotlinlang.org/)
- [官方示例](http://try.kotlinlang.org/)
- [官方网站 - 中文翻译](https://www.kotlincn.net/)
- [Kotlin 在线工具](https://c.runoob.com/compile/2960)