## IO流之File

### 一、IO
大多数的应用程序都要与外部设备进行数据交换，最常见的外部设备包含磁盘和网络。
IO就是指应用程序对这些设备的数据输入与输出，Java语言定义了许多类专门负责各种方式的输
入、输出，这些类都被放在java.io包中。

### 二、File类
**<font color='red'>File类是IO包中唯一代表磁盘文件本身的对象</font>**，File类定义了一些与平台无关的方法来操作
文件。通过调用File类提供的各种方法，能够完成创建、删除文件、重命名文件、判断文件的
读写权限权限是否存在、设置和查询文件的最近修改时间等操作。

File类没有无参构造方法，最常用的是使用下面的构造方法来生成File对象
（注意分隔符可以使用"/"和"\"，但是使用"\"必须写"\\"，因为涉及转义的问题）：

`File(String pathName)`

pathName指的是文件的路径名


### 三、File类中的方法
File定义了很多获取File对象标准属性的方法，写一段代码来看一下：

```
public static void main(String[] args)
{
    String fileName = "D:" + File.separator + "Files";
    File file = new File(fileName);
    
    if (file.exists() && file.isDirectory()) // 判断路径指向的文件/文件夹是否存在、是否目录
    {
        System.out.println("file是一个文件夹\n");
            
        File[] files = file.listFiles(); // 获取目录下的所有文件/文件夹（仅该层路径下）
        System.out.print("路径下有文件：");
        for (File f : files)
        {
            System.out.print(f + "\t");
        }
        System.out.println();
            
        System.out.println("files[0]的文件名：" + files[0].getName()); // 获取文件名、文件夹名
        System.out.println("files[0]的文件路径：" + files[0].getPath()); // 获取文件、文件夹路径
        System.out.println("files[0]的绝对路径：" + files[0].getAbsolutePath()); // 获取文件、文件夹绝对路径
        System.out.println("files[0]的父文件夹名：" + files[0].getParent()); // 获取文件父目录路径
        System.out.println(files[0].exists() ? "files[0]的存在" : "files[0]的不存在"); // 判断文件、文件夹是否存在
        System.out.println(files[0].canWrite() ? "files[0]的可写" : "files[0]的不可写"); // 判断文件是否可写
        System.out.println(files[0].canRead() ? "files[0]的可读" : "files[0]的不可读"); // 判断文件是否可读
        System.out.println(files[0].canExecute() ? "file[0]可执行" : "file[0]不可执行"); // 判断文件是否可执行
        System.out.println(files[0].isDirectory() ? "files[0]的是目录" : "files[0]的不是目录"); // 判断文件、文件夹是不是目录
        System.out.println(files[0].isFile() ? "files[0]的是文件" : "files[0]的不是文件"); // 判断拿文件、文件夹是不是标准文件
        System.out.println(files[0].isAbsolute() ? "files[0]的路径名是绝对路径" : "files[0]的路径名不是绝对路径"); // 判断路径名是不是绝对路径
        System.out.println("files[0]的最后修改时间：" + files[0].lastModified()); // 获取文件、文件夹上一次修改时间
        System.out.println("files[0]的大小：" + files[0].length() + " Bytes"); // 获取文件的字节数，如果是一个文件夹则这个值为0
        System.out.println("files[0]的路径转换为URI：" + files[0].toURI()); // 获取文件路径URI后的路径名
            
        if (files[0].exists())
            files[0].delete(); // 删除指定的文件、文件夹
        if (files[1].exists())
            files[1].deleteOnExit(); // 当虚拟机终止时删除指定的文件、文件夹
    }
}

```

注意：

1、程序代码的第三行，写"D:/Files"和"D:\\Files"都是可以的，但像示例代码这么写应该
是一种更好的做法，因为这么写使得代码的跨平台型、健壮性更好。"File.separator"会
根据不同的操作系统取不同操作系统下的分隔符。其实File还有另一个分隔符pathSeparator，
表示":"，不过因为Java主要用在Windows和Linux下，Linux下没有盘符的问题，
所以一般直接打":"就好了

2、程序代码的第34、第36行，注意一下，**<font color='red'>删除的如果是一个文件夹的话，文件夹下还有文件/文件夹，是无法删除成功的</font>**