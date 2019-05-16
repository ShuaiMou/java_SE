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
	ByteArrayInputStream 
		包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。
		关闭 ByteArrayInputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。 
	ByteArrayOutputStream
		此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。
		可使用 toByteArray() 和 toString() 获取数据。 关闭 ByteArrayOutputStream 无效。
		此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。
		
9.数据流
	DataInputStream：
		数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。应用程序可以使用
		数据输出流写入稍后由数据输入流读取的数据。 DataInputStream 对于多线程访问不一定是安全的。
		线程安全是可选的，它由此类方法的使用者负责。
	DataOutputStream：
		数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。然后，应用程序可以使用数据
		输入流将数据读入。 
	
10.字符串流，管道流，合并流
	合并流：
		SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，
		直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。
	字符串流
		1、StringReader
			其源为一个字符串的字符流。 
		2、 StringWriter
			一个字符流，可以用其回收在字符串缓冲区中的输出来构造字符串。 关闭 StringWriter 无效。
			此类中的方法在关闭该流后仍可被调用，而不会产生任何 IOException。
	管道流
		管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。通常，数据由某个
		线程从 PipedInputStream 对象读取，并由其他线程将其写入到相应的 PipedOutputStream。不建议
		对这两个对象尝试使用单个线程，因为这样可能死锁线程。管道输入流包含一个缓冲区，可在缓冲区限定的范
		围内将读操作和写操作分离开。如果向连接管道输出流提供数据字节的线程不再存在，则认为该管道已损坏。
	
11.RandomAccessFile
	RandomAccessFile是IO包的类，从Object直接继承而来。 只可以对文件进行操作，可以对文件进行读取和写入。
	当模式为r是，当文件不存在时会报异常，当模式为rw时，当文件不存在时，会自己动创建文件，当文件已经存在时 
	不会对原有文件进行覆盖。
	RandomAccessFile有强大的文件读写功能，其内部是大型 byte[]，可以通过seek(),getFilePointer()等
	方法操作的指针，方便对数据进行写入与读取。还可以对基本数据类型进行直接的读和写操作
	RandomAccessFile的绝大多数功能，已经被JDK 1.4的nio的“内存映射文件(memory-mapped files)”给取代了，
	你该考虑一下是不是用“内存映射文件”来代替RandomAccessFile了
	
12、Properties文件操作
		Properties（Java.util.Properties），主要用于读取Java的配置文件，各种语言都有自己所支持的配置文件，
		配置文件中很多变量是经常改变的，这样做也是为了方便用户，让用户能够脱离程序本身去修改相关的变量设置。
		它提供了几个主要的方法：
	1、getProperty ( String key)，用指定的键在此属性列表中搜索属性。也就是通过参数 key ，得到 key 所对应的 value。
	2、load ( InputStream inStream)，从输入流中读取属性列表（键和元素对）。通过对指定的文件（比如说上面的 test.properties 
		文件）进行装载来获取该文件中的所有键 - 值对。以供 getProperty ( String key) 来搜索。
	3、setProperty ( String key, String value) ，调用 Hashtable 的方法 put 。他通过调用基类的
		put方法来设置 键 - 值对。
	4、store ( OutputStream out, String comments)，以适合使用 load 方法加载到 Properties 表中的格式，
		将此 Properties 表中的属性列表（键和元素对）写入输出流。与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。
	5、 clear ()，清除所有装载的 键 - 值对。该方法在基类中提供。
		
13、文件压缩与解压缩
	java中实现zip的压缩与解压缩

	ZipOutputStream
		  实现文件的压缩
	ZipOutputStream(OutputStream out) 
          创建新的 ZIP 输出流。
 	void putNextEntry(ZipEntry e) 
          开始写入新的 ZIP 文件条目并将流定位到条目数据的开始处。 
	ZipEntry(String name)   //test/mm.jpg   /test/a.txt
          使用指定名称创建新的 ZIP 条目。
	ZipInputStream
		  实现文件的解压
	ZipInputStream(InputStream in) 
          创建新的 ZIP 输入流。
	ZipEntry getNextEntry() 
          读取下一个 ZIP 文件条目并将流定位到该条目数据的开始处。 
	
14、装饰者模式
15、常见字符编码
16、New IO
