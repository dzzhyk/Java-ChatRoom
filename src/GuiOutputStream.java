import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 将标准输出重定向到gui
 */
public class GuiOutputStream extends PrintStream {

    private JTextComponent component;
    private StringBuffer buffer = new StringBuffer();

    public GuiOutputStream(OutputStream out, JTextComponent component) {
        super(out);
        this.component = component;
    }

    // 重写write方法
    @Override
    public void write(byte[] buf, int off, int len) {
        final String message = new String(buf, off, len);

        SwingUtilities.invokeLater(()->{
            buffer.append(message);
            component.setText(buffer.toString());
        });
    }
}
