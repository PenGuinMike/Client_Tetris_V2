import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
    private InetAddress ipadrs;
    private ServerSocket servSocket;
    private Socket socket;
    private PrintStream outStream;
    private BufferedReader inputStream;
    private TetrisPane tp;
    private Player1 player1;
    private int socketNum;
//    private String Ip ="10.51.3.214";
//    private String Ip ="127.0.0.1";
    private String Ip;
    //    public Server(int num){
    public Client(TetrisPane tp1,Player1 p1, int num,String ip){
        tp=tp1;
        player1 = p1;
        socketNum=num;
        Ip=ip;
        System.out.println(socketNum);

        try{
            ipadrs = InetAddress.getLocalHost();
            socket = new Socket(Ip,socketNum);
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error6"+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"please enter the ip");
            socket.isClosed();
            String[] args = new String[0];
            Main.main(args);
        }catch (Exception yee){
            javax.swing.JOptionPane.showMessageDialog(null,"Error8"+yee.toString());
        }
    }
    public void run(){
        try {
//            socket = new Socket(Ip,socketNum);
            outStream = new PrintStream(socket.getOutputStream());// step 1
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));// step 1
//            sendToclient("test");// step 1
            String str="";
            while (true){
                str=inputStream.readLine();
                player1.rec(str);
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"the opponent has left,game is over");
            System.exit(0);
        }
    }
    public void  sendToclient(String command){
        try {
            outStream = new PrintStream(socket.getOutputStream());
            if(outStream != null){
                outStream.println(command);
            }else{
                System.out.println("Error"+"  command:"+command);
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error8"+e.toString());

        }
    }

    public void closeSocket(){
        try {
            inputStream.close();
            socket.close();
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error00"+e.toString());
        }
    }

}
