package software.ulpgc.ImageViewer;

public class PreviousImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public PreviousImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {imageDisplay.show(imageDisplay.image().previousImage());}
}
