package software.ulpgc.ImageViewer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public class FileImageLoader implements ImageLoader{
    private final File[] files;
    private final List<String> listExtensions = List.of(".jpg",".png",".jpeg",".webp");
    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imagesAtFolder());
    }
    private FilenameFilter imagesAtFolder() {return ((dir, name) -> listExtensions.stream().anyMatch(name::endsWith));}

    @Override
    public Image load() {
        return imageAtIndex(0);
    }

    private Image imageAtIndex(int i) {
        return new Image() {
            @Override
            public String name() {
                return files[i].getAbsolutePath();
            }

            @Override
            public Image nextImage() {
                return i == files.length-1 ? imageAtIndex(0) : imageAtIndex(i+1);
            }

            @Override
            public Image previousImage() {
                return  i == 0 ? imageAtIndex(files.length - 1) : imageAtIndex(i - 1);
            }
        };
    }
}
