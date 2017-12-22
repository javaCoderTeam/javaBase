### javac.exe、 java.exe、 java虚拟机三者之间的区别与联系:

JDK中

javac：Java编译器，将Java源代码换成字节代；

java：Java解释器，直接从类文件执行Java应用程序代码；

先编译  *.java文件――――>*.class文件

运行   *.class ――加载――> JVM

jvm加载二进制文件

javac编译后得到的class文件是二进制指令，但不是机器指令，而是java虚拟机可识别的指令。这样class文件就有了可移植行。你可以把class文件拿到windows、linux或者solaris等不同的系统上去，在jvm上执行。

java是启动jvm，jvm负责对class文件的内容进行处理，将字节码文件解释或者编译为机器指令，执行。

### java虚拟机的体系结构

下图表示了Java虚拟机的结构框图，主要描述了JVM子系统和内存区。

