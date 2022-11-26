import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame mFrame = new JFrame("ChatBot");
        mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mFrame.setSize(500, 500);
        mFrame.setLayout(new BorderLayout());

        JMenuBar mbar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenu helpMenu = new JMenu("Ayuda");
        mbar.add(fileMenu);
        mbar.add(helpMenu);
        JMenuItem openMenuItem = new JMenuItem("Abrir");
        JMenuItem saveMenuItem = new JMenuItem("Guardar");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        
        JPanel panel = new JPanel();
        JLabel messageLabel = new JLabel("Mensaje:");
        JTextField chatTextField = new JTextField(10);
        JButton sendBtn = new JButton("Enviar");
        JButton resetBtn = new JButton("Restablecer");
        panel.setLayout(new FlowLayout());
        panel.add(messageLabel);
        panel.add(chatTextField);
        panel.add(sendBtn);
        panel.add(resetBtn);

        JTextArea chatHistory = new JTextArea();
        mFrame.getContentPane().add(BorderLayout.SOUTH, panel);
        mFrame.getContentPane().add(BorderLayout.NORTH, mbar);
        mFrame.getContentPane().add(BorderLayout.CENTER, chatHistory);

        sendBtn.addActionListener(e->addMessage(chatTextField.getText(),chatHistory,chatTextField));
        resetBtn.addActionListener(e->resetTextField(chatTextField));

        mFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        mFrame.setVisible(true);
    }

    public static void resetTextField(JTextField targetTextBox){
        targetTextBox.setText("");
    }

    public static void addMessage(String message,JTextArea targetTextArea, JTextField targetTextBox){
        targetTextArea.append("\nPablo Dice: " + message);
        resetTextField(targetTextBox);
    }
}
