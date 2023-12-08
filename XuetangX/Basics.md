# 1.0 Intro to the Java tutorial at XuetangX
## 1.0.0 本章主要内容
- Java与面向对象程序设计简介
- 基本数据类型与表达式
- 数组
- 算法的流程控制

## 1.0.1 JDK的安装与配置01-download
oracle official website install
JDK: java development kit
JRE: java run environment

## 1.0.2 JDK的安装与配置02-install


## 1.0.3 JDK的安装与配置03-env config
environment variable

## 1.0.4 The first program 
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

## 1.0.5 Eclipse IDE
New -> New project -> project name/JavaSE 1.8

- code template for easy use
- modify to suit your work flow





---
---


# 1.1 java与面向对象程序设计简介

- 抽象与封装
- 继承
- 多态

**半编译 半执行**

文字量
标识符：与内存中的某个位置（地址）相对应
变量
常量

关系运算符：
类型比较运算符 *instanceof*

隐含转换：
- 赋值转换（将表达式类型转换为指定变量的类型）
- 方法调用转换（适用于方法或构造方法调用的每一个参数）
- 字符串转换
    - 任何类型（包括null类型）都可以转换为字符串类型
    - 只当一个操作数是String类型时，适用于+运算符的操作数

# 1.3 数组
- 数组时对象（1. 动态初始化 2. 可以复制给Object类型的变量 3. 可以调用Object类的所有方法 4. 每个数组都有一个public final修饰的成员变量： length）
- 数组元素
- 数组的创建和初始化
- 数组引用的声明
- 数组元素的初始化