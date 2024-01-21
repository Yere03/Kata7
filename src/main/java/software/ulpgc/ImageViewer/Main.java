package software.ulpgc.ImageViewer;

import java.io.File;

public class Main {
    public static final String root = "D:\\Yeremay\\FSI\\Practica 2 FSI\\Practica 2 FSI\\test_images";
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        Image image = new FileImageLoader(new File(root)).load();
        frame.ImageDisplay().show(image);
        frame.add("<",new PreviousImageCommand(frame.ImageDisplay()));
        frame.add(">",new NextImageCommand(frame.ImageDisplay()));
        frame.setVisible(true);
    }
}
