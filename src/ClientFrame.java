import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientFrame extends JFrame {

    private Client client = new Client(this);

    public ClientFrame() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        client.start();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // 发送消息
        client.send();
    }

    private void thisWindowClosed(WindowEvent e) {

    }

    private void thisWindowClosing(WindowEvent e) {
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextField getTextArea2() {
        return textArea2;
    }

    public JButton getButton2() {
        return button2;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dafu Chou
        button1 = new JButton();
        button2 = new JButton();
        textArea2 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();
        vSpacer1 = new JPanel(null);
        hSpacer1 = new JPanel(null);

        //======== this ========
        setTitle("\u5ba2\u6237\u7aef");
        setResizable(false);
        setVisible(true);
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

        //---- button1 ----
        button1.setText("\u8fde\u63a5");
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
		});
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 225), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d1\u9001\u6d88\u606f");
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
		});
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 305), button2.getPreferredSize()));
        contentPane.add(textArea2);
        textArea2.setBounds(15, 265, 205, 65);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setFocusable(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 25, 290, 195);

        //---- label1 ----
        label1.setText("\u804a\u5929\u5ba4\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 5, 65, 20);
        contentPane.add(vSpacer1);
        vSpacer1.setBounds(155, 330, 20, 15);
        contentPane.add(hSpacer1);
        hSpacer1.setBounds(305, 140, 15, 20);

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
    private JButton button1;
    private JButton button2;
    private JTextField textArea2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    private JPanel vSpacer1;
    private JPanel hSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
