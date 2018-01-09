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
    private String Ip ="10.51.3.214";
    //    public Server(int num){
    public Client(TetrisPane tp1,Player1 p1, int num){
        tp=tp1;
        player1 = p1;
        socketNum=num;
        System.out.println(socketNum);

        try{
            ipadrs = InetAddress.getLocalHost();
            socket = new Socket(Ip,socketNum);
//            servSocket = new ServerSocket(socketNum);
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error6"+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"Error7"+ioe.toString());
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
                //rec改成傳入變數,然後從這邊叫rec
                //rec(str)/rec("@init-7");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error9"+e.toString());
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
            javax.swing.JOptionPane.showMessageDialog(null,"Error0"+e.toString());
        }
    }

}
