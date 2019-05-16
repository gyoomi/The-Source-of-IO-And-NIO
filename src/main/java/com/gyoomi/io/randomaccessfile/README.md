## IO流之RandomAccessFile
### 一、RandomAccessFile
RandomAccessFile类可以说是Java语言中功能最为丰富的文件访问类，它提供了众多的文件
访问方法。RandomAccessFile类支持"随机访问"方式，可以跳转到文件的任意位置处读写数据。
要访问一个文件的时候，不想把文件从头读到尾，而是希望像访问一个数据库一样地访问一个
文本文件，使用RandomAccessFile类是最佳选择。

RandomAccessFile对象类中有个位置指示器，指向当前读写处的位置，当读写n个字节后，
文件指示器将指向这n个字节后的下一个字节处。刚打开文件时，文件指示器指向文件的开头处，
可以移动文件指示器到新的位置，随后的读写将从新的位置开始。

RandomAccessFile类在文件随机（相对于顺序）读取时有很大的优势，但**该类仅限于操作文件，
不能访问其他得IO设备，如网络、内存映像等**。

### 二、RandomAccessFile构造方法
RandomAccessFile类为用户提供了两种构造方法：

1、RandomAccessFile(File file, String mode)

2、RandomAccessFile(String name, String mode)

其实第二种构造方法也是new一个File出来再调用第一种构造方法，建议使用第一种构造方法，因为第一篇文章就说了File是IO的基础，有一个File不仅仅可以通过RandomAccessFile对文件进行操作，也可以通过File对象对文件进行操作。至于mode，Java给开发者提供了四种mode：

name | 111 | 222 | 333 | 444
- | :-: | :-: | :-: | -:
aaa | bbb | ccc | ddd | eee| 
fff | ggg| hhh | iii | 000|

注意第二点"rw"模式，对rw模式的解释意味着Java并不强求指定的路径下一定存在某个文件，假如文件不存在，会自动创建.


### 三、RandomAccessFile中的方法



### 四、示例

可能有人奇怪，"zhangsan"加上一个int跳过12个字节可以理解，但是"lisi"、
"wangwu"为什么加上int要跳过12个字节呢？明明"lisi"只有4个字节，"wangwu"
只有6个字节啊。这个就涉及到一个"字节对齐"的问题了，有兴趣的可以了解一下。
另外，再说一下，RandomAccessFile使用完一定要及时close()。