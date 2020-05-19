import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon May 18 14:34:22 CST 2020
 */



/**
 * @author Dafu Chou
 */
public class ServerFrame extends JFrame {

    public ServerFrame() {
        initComponents();
    }


    private void thisWindowClosing(WindowEvent e) {
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
    }

    public JTextArea getTextArea2() {
        return textArea2;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextField getTextArea3() {
        return textArea3;
    }

    public JButton getButton1() {
        return button1;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dafu Chou
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        vSpacer1 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        textArea3 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setTitle("\u670d\u52a1\u7aef");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setFocusable(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 55, 220, 240);

        //---- label1 ----
        label1.setText("\u804a\u5929\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 15, 80, 30);

        //---- label2 ----
        label2.setText("\u5728\u7ebf\u7528\u6237\uff1a");
        contentPane.add(label2);
        label2.setBounds(245, 20, 85, 25);
        contentPane.add(vSpacer1);
        vSpacer1.setBounds(160, 425, 20, 20);
        contentPane.add(hSpacer1);
        hSpacer1.setBounds(350, 290, 15, 15);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setEditable(false);
            textArea2.setFocusable(false);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(240, 55, 110, 240);
        contentPane.add(textArea3);
        textArea3.setBounds(15, 330, 220, 90);

        //---- label3 ----
        label3.setText("\u53d1\u9001\u6d88\u606f\uff1a");
        contentPane.add(label3);
        label3.setBounds(15, 300, 65, 25);

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        contentPane.add(button1);
        button1.setBounds(255, 350, button1.getPreferredSize().width, 65);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dafu Chou
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private JLabel label2;
    private JPanel vSpacer1;
    private JPanel hSpacer1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JTextField textArea3;
    private JLabel label3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
