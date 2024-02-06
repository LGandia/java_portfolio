# 1 Getting Started
## Writing A Simple Java Program


You commit all work to repos on your GitHub account. You should use the standard assignment template in the Assessment directory. You will be able to use this when you attempt the online tests (for marks).


You should include an associated README.md file which contains the output of the code when run.


This week you are going to undertake some simple development work which should allow you to become familiar with your IDE. There are many different IDEs and people can prefer different ones for different reasons. You may have used PyCharm for Python and so find IntelliJ more to your liking (both are made by JetBrains and are very similar). Your module leader prefers Eclipse, as it is more industry standard and highly configurable. The video material uses Eclipse. The choice is yours.


Start the IDE.


## Programming Projects:


**1. Create a new project called “HelloWorld” and write a simple Java program that displays the message “Hello World” to the console.**


**2. “Test”. Create a project, enter, compile and run the following application.**


```
public class Test
{
   //----------------------------------------------------
   //  Prints a statement.
   //----------------------------------------------------
   public static void main (String[] args)
   {
      System.out.println ("An Emergency Broadcast");
   }
}
```


Introduce the following errors, one at a time. Note any messages that the compiler produces. Fix the previous error each time. If no error messages are produced, be prepared to explain why.


a. Change Test to test.\
java: class test is public, should be declared in a file named test.java

b. Change Emergency to emergency.\
No error. You are changing the output message, not the formatting/method of the program itself.

c. Remove the first quotation mark in the string\
java: ')' or ',' expected

d. Change main to man.\
Program can not be run.\
Method 'man(java.lang.String[])' is never used\
Parameter 'args' is never used

e. Change println to bogus.\
java: cannot find symbol\
symbol:   method bogus(java.lang.String)\
location: variable out of type java.io.PrintStream

f. Remove the semicolon at the end of the println statement.\
java: ';' expected

g. Remove the last brace in the program.\
java: reached end of file while parsing


**3. Create a second project called “PersonalDetails” and write a program that outputs some personal details to the screen, e.g. Name, Address, Age, Phone number etc.**


**4. Write and application that prints the following diamond shape. Don’t print any unneeded characters**

```
       *
      ***
     *****
    *******
     *****
      ***
       *

```


If you complete the exercises above, answer the following questions.
 
a. What is the latest version of the Java SDK that is available?\
JDK21

b. What is the difference between Java SE and Java ME?\
JSE = Java Standard Edition: core Java programming platform\
JME = Java Micro edition: platform used for developing applications for
mobile devices and embedded systems

c. Which operating system is Java available for?\
Windows, Mac OS X, Linux, Solaris

d. What is the most popular IDE available for Java apart from Eclipse?\
IntelliJ IDEA

e. What is the main() function for in a Java program?\
Where the program starts its execution.