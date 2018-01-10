import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_GetIP extends JFrame {
    private JTextField jtf;
    private JButton jbtnStart;
    int FrameW=400,FrameH=330;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Client_GetIP (){
        init();
    }

    private void init(){
        this.setTitle("Enter Server's IP");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        jbtnStart = new JButton("Start");
        jtf = new JTextField(null);
        jtf.setBounds(65,80,260,35);
        jbtnStart.setBounds(150,150,85,45);
        this.add(jtf);
        this.add(jbtnStart);

        jbtnStart.setEnabled(false);
        if (jtf.getText() !=null){
            jbtnStart.setEnabled(true);
        }


        jbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getIp = jtf.getText();
                Tetris_Frame tf = new Tetris_Frame(Client_GetIP.this,getIp);
                tf.setVisible(true);
                Client_GetIP.this.setVisible(false);
            }
        });
    }
}
