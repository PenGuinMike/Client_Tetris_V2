import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintStream;
        import java.net.InetAddress;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.net.UnknownHostException;

public class Client_Rec extends Thread {
    private InetAddress ipadrs;
    private ServerSocket servSocket;
    private Socket socket;
    private PrintStream outStream;
    private BufferedReader inputStream;
    private Player1 p1;
    private int socketNum;
    private String Ip ="127.0.0.1";
    //    public Server(int num){
    public Client_Rec(Player1 pO, int num){
        p1=pO;
        socketNum=num;
        try{
            ipadrs = InetAddress.getLocalHost();
            servSocket = new ServerSocket(socketNum);
        }catch (UnknownHostException e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }catch (IOException ioe){
            javax.swing.JOptionPane.showMessageDialog(null,"Error"+ioe.toString());
        }catch (Exception yee){
            javax.swing.JOptionPane.showMessageDialog(null,"Error"+yee.toString());
        }
    }
    public void run(){
        try {
            socket = new Socket(Ip,socketNum);
            outStream = new PrintStream(socket.getOutputStream());// tep 1
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));// step 1
            sendToclient("");// step 1
            String str="";
            while (!(str=inputStream.readLine()).equals("")){// step 1
                //rec改成傳入變數,然後從這邊叫rec
                //rec(str)/rec("@init-7");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    public void  sendToclient(String command){
        try {
            if(outStream != null){
                outStream.println(command);
            }else{
                System.out.println("87");
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }

}
