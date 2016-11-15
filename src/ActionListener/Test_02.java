package ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhouliang on 2016/11/13.
 */
public class Test_02 extends JFrame{
    Test_02(){
        JPanel panel = new JPanel();
        JButton button1 = new JButton("按钮一");
        JButton button2 = new JButton("按钮二");

        panel.add(button1);
        panel.add(button2);
        this.setSize(300,400);
        this.getContentPane().add(panel);
        this.setVisible(true);

        button1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("你按了按钮一");
                    }
                });
        button2.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("你按了按钮二");
                    }
                });
    }

    public static void main(String args[]){
        new Test_02();
    }
}
