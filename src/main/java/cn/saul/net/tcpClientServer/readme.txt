TCP 实现ECHO程序（最基本的c/s程序）
MultiServer 用来处理多客户端的请求

服务器端实现：
1.创建 ServerSocke，设置端口号（1024 - 65535）
2.服务器进行监听，并接受到此套接字的连接: accept()
3.创建输入流和输出流来接收和发送消息:getOutputStream(), getInputStream()

客户端实现：
1.创建Socket，指定服务器地址和端口号
2.创建输出输入流来发送和接收消息:getOutputStream(), getInputStream()

数据发送过程：
产生Socket --> 调用bind将Socket的信息通知给驱动程序 --> 应用程序将要发送的数据传给Socket
--> 驱动程序从Socket取出数据并通过网卡发送出去

数据接收过程：
产生Socket --> 调用bind将Socket的信息通知给驱动程序 
--> 驱动程序根据从网卡传送来的数据报中的指定目标端口号，将处理后的数据传送到相应的Socket中
--> 应用程序从Socket中取数据