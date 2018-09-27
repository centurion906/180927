//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//
//public class MainFrame extends JFrame {
//    private Container cp;
//    private JPanel jpn = new JPanel(new GridLayout(4,3,3,3));
//    private JButton jbtn [] = new JButton[12];
//    private String jbtnlabel[] = new String[10];
//    private JPasswordField jlb = new JPasswordField("");
//    private Font fnt = new Font(null, Font.BOLD, 18);
//    private Login lg;
//    public MainFrame(Login lg1){
//        lg = lg1;
//        ex();
//    }
//    private void ex() {
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setBounds(100, 150, 450, 600);
//        cp = this.getContentPane();
//        cp.add(jlb, BorderLayout.NORTH);
//        cp.add(jpn, BorderLayout.CENTER);
////        jlb.setBackground(new Color(255, 193, 244));
////        jlb.setOpaque(true);
//        for (int i = 0; i<10; i++){
//            jbtn[i] = new JButton(jbtnlabel[i]);
//            jpn.add(jbtn[i]);
//            jbtn[i].setFont(fnt);
//            jpn.add(jbtn[i]);
//            genLabel(jbtnlabel);
//            jbtn[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JButton tmpbtn = (JButton)e.getSource();
//                    jlb.setText(jlb.getText()+tmpbtn.getText());
//
//                }
//            });
//        }
//        jbtn[10] = new JButton("重置");
//        jbtn[11] = new JButton("Sub");
//        jpn.add(jbtn[10]);
//        jpn.add(jbtn[11]);
//        jbtn[10].addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                genLabel(jbtnlabel);
//                for (int i = 0;i<10;i++){
//                    jbtn[i].setText(jbtnlabel[i]);
//                }
//            }
//        });
//        jbtn[11].addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                lg.setPassWord(new String(jlb.getPassword()));
//                MainFrame.this.setVisible(false);
//            }
//        });
//    }
//    private void genLabel(String str[]){
//        int i = 0;
//        Random rnd = new Random(System.currentTimeMillis());
//        while (i<10){
//            jbtnlabel[i] = Integer.toString(rnd.nextInt());
//            int j = 0;
//            boolean flag = false;
//            while (j<i){
//                if (jbtnlabel[i].equals(jbtnlabel[j])){
//                    flag = true;
//                    j = i;
//                }
//                j++;
//            }
//            if (!flag){
//                i++;
//            }
//        }
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpn=new JPanel(new GridLayout(4,3,3,3));
    private JButton jbtns[]=new JButton[12];
    private String jbtnlabel[]=new String[10];
    private JPasswordField jlb=new JPasswordField("");
    private Font fnt=new Font(null,Font.BOLD,18);
    private Login lg;
    public MainFrame(Login lg1){
        lg = lg1;
        ex();
    }

    private void ex() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 300, 400);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpn,BorderLayout.CENTER);
        cp.add(jlb,BorderLayout.NORTH);
        genLabel(jbtnlabel);
        for (int i=0;i<10;i++){
            jbtns[i]=new JButton(jbtnlabel[i]);
            jbtns[i].setFont(fnt);
            jpn.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton jButton=(JButton) actionEvent.getSource();
                    jlb.setText(jlb.getText()+jButton.getText());
                }
            });
        }

        jbtns[10]=new JButton("Sub");
        jbtns[11]=new JButton("reflash");


        jpn.add(jbtns[10]);
        jpn.add(jbtns[11]);
        jbtns[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lg.setPassWord(new String(jlb.getPassword()));
                MainFrame.this.setVisible(false);
            }
        });
        jbtns[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                genLabel(jbtnlabel);
                for (int i=0;i<10;i++){
                    jbtns[i].setText(jbtnlabel[i]);


                }
            }
        });
    }
    private void genLabel(String str[]){
        int i=0;
        Random rnd=new Random(System.currentTimeMillis());
        while (i<10){
            jbtnlabel[i]=Integer.toString(rnd.nextInt(10));
            int j=0;
            boolean flag=false;
            while (j<i){
                if (jbtnlabel[i].equals(jbtnlabel[j])){
                    flag=true;
                    j=i;
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
    }
}