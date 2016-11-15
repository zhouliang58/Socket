package ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhouliang on 2016/11/13.
 */
public class Test_01 extends JFrame implements ActionListener {
    Test_01() {
        JPanel panel = new JPanel();
        JButton button1 = new JButton("按钮一");
        JButton button2 = new JButton("按钮二");

        panel.add(button1);
        panel.add(button2);
        this.setSize(300,400);
        this.getContentPane().add(panel);
        this.setVisible(true);
        button1.addActionListener(this);
        button2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("按钮一")) {
            System.out.println("你按了按钮一");
        }
        if (source.equals("按钮二")) {
            System.out.println("你按了按钮二");
        }
    }

    public static void main(String args[]) {
        new Test_01();
    }


}
