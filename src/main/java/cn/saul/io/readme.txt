io流涉及：
1.File类
	File类：表示文件和目录路径名的抽象表示形式。
	File类可以实现文件的创建、删除、重命名、得到路径、创建时间等等，是唯一与文件本身有关的操作类。
	主要方法：
			public boolean createNewFile()：创建新文件
			public boolean delete()：       删除文件
			public boolean isDirectory()：  判断给定的路径是否是文件夹
			public boolean isFile()     ：  判断给定的路径是否是文件
			public boolean mkdir()：		    创建新的文件夹
			public File[] listFiles()：     列出文件夹中的所有文件
			String getPath() ： 			    路径名字符串。
				
2.字节流
	abstract OutputStream：此抽象类是表示输出字节流的所有类的超类
	abstract InputStream：此抽象类是表示字节输入流的所有类的超类。
	FileOutputStream，FileInputStream
	
3.字符流
	Writer：写入字符流的抽象类。子类必须实现的方法仅有 write(char[], int, int)、flush() 和 close()。
			但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。 
			与OutputStream一样，对文件的操作使用：FileWriter类完成。
	Reader：用于读取字符流的抽象类。子类必须实现的方法只有 read(char[], int, int) 和 close()。
			但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。
			使用FileReader类进行实例化操作。
			
4.字节字符转换流
	OutputStreamWriter：可以将输出的字符流转换为字节流的输出形式
 	InputStreamReader：将输入的字节流转换为字符流输入形式
	
5.缓冲流
	BufferedInputStream： 为另一个输入流添加一些功能，在创建 BufferedInputStream 时，会创建一个内部缓冲区数组，用于缓冲数据。
	BufferedOutputStream：通过设置这种输出流，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。
	BufferedReader：从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
	BufferedWriter：将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。 
	
6.打印流
	字节打印流：PrintStream
 	字符打印流：PrintWriter
	
7.对象流
	ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream
	ObjectInputStream 对以前使用 ObjectOutputStream 写入的基本数据和对象进行反序列化
	序列化一组对象
	
8.字节数组流
9.数据流
10.字符串流，管道流，合并流
11.RandomAccessFile
12、Properties文件操作
13、文件压缩与解压缩
14、装饰者模式
15、常见字符编码
16、New IO
