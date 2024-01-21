package software.ulpgc.ImageViewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private software.ulpgc.ImageViewer.Image image;
    private BufferedImage bitmap;
    @Override
    public void show(software.ulpgc.ImageViewer.Image image) {
        this.image = image;
        bitmap = load(image.name());
        this.repaint();


    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Resizer resizer = new Resizer(new Dimension(this.getWidth(), this.getHeight()));
        Dimension resized = resizer.resize(new Dimension(bitmap.getWidth(), bitmap.getHeight()));
        int x = (this.getWidth() - bitmap.getWidth()) / 2;
        int y = (this.getHeight() - bitmap.getHeight()) / 2;
        g.drawImage(bitmap, x, y, null);
    }

    public static class Resizer {
        private final Dimension dimension;

        public Resizer(Dimension dimension) {
            this.dimension = dimension;
        }

        public Dimension resize(Dimension dimension) {
            return null;
        }
    }

    @Override
    public Image image() {return image;}

    private BufferedImage load(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
