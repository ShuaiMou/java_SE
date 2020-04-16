package cn.saul.net.groupcommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * @Auther: Saul
 * @Date: 16/4/20 21:56
 * @Description:
 */
public class Groupcommunication {

    //多点广播地址的范围是224.0.0.0 ~ 239.255.255.255
    public final static String BROADCAST_IP = "230.0.1.1";//组播地址
    public final static int BROADCAST_PORT = 9000;
    private final static int PACKAGE_SIZE = 4096;
    public void init(){
        MulticastSocket socket = null;
        Scanner scanner = null;
        try {
            socket = new MulticastSocket(BROADCAST_PORT);
            InetAddress ipAddress = InetAddress.getByName(BROADCAST_IP);
            socket.joinGroup(ipAddress);//必须是false才能开启广播功能！
            MulticastSocket finalSocket = socket;
            new Thread(()->{

                DatagramPacket inPacket = new DatagramPacket(new byte[PACKAGE_SIZE], PACKAGE_SIZE);
                while (true){
                    try {
                        finalSocket.receive(inPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("广播消息： " + new String(inPacket.getData(),0, inPacket.getLength()) );
                }

            }).start();

            DatagramPacket outPacket = new DatagramPacket(new byte[0], 0, ipAddress, BROADCAST_PORT); // 目的端口和MulticastSocket端口一样！！
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                outPacket.setData(scanner.nextLine().getBytes());
                socket.send(outPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != socket) socket.close();
            if (null != scanner) scanner.close();
        }

    }
    public static void main(String[] args) {
        new Groupcommunication().init();
    }
}
