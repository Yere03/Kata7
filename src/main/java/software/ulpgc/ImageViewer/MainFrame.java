package software.ulpgc.ImageViewer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    private final Map<String,Command> Commands;

    public MainFrame() throws HeadlessException {
        this.Commands = new HashMap<>();
        setTitle("ImageViewer");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createImageDisplay());
        createToolBar();

    }
    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay = display;
        return display;
    }

    private void createToolBar() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridBagLayout());
        panel1.add(createButton("<"));
        panel2.add(createButton(">"));
        add(panel1,BorderLayout.WEST);
        add(panel2,BorderLayout.EAST);
    }


    public ImageDisplay ImageDisplay() {
        return imageDisplay;
    }


    private Component createButton(String CommandLabel) {
        JButton button = new JButton(CommandLabel);
        button.addActionListener(a -> Commands.get(CommandLabel).execute());
        return button;
    }
    public void add(String CommandLabel,Command command){
        Commands.put(CommandLabel, command);
    }
}
