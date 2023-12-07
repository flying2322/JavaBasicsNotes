# 1 Intro to the Java tutorial at XuetangX
## 1.0. 本章主要内容
- Java与面向对象程序设计简介
- 基本数据类型与表达式
- 数组
- 算法的流程控制

## 1.1 JDK的安装与配置01-download
oracle official website install
JDK: java development kit
JRE: java run environment

## 1.2 JDK的安装与配置02-install


## 1.3 JDK的安装与配置03-env config
environment variable

## 1.4 The first program 
```java
public class Helloworld
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
```
Compile and run
```shell
javac Helloworld.java
java Helloworld
```
### Some file explaination
- Helloworld.java (source file)
- Helloworld.class (字节码)一种可以被解释器理解 并在不同的系统上运行