package software.ulpgc.ImageViewer;

public interface Image {
    String name();

    Image nextImage();

    Image previousImage();
}
