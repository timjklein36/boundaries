package tksoft.boundaries.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagePanel extends JPanel {

    private Logger logger = LoggerFactory.getLogger(ImagePanel.class);

    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);

    private JLabel backgroundLabel = new JLabel();
    private ImageIcon backgroundImage;

    ImagePanel() {
        setLayout(flowLayout);

        add(backgroundLabel);
    }

    public void setBackgroundImage(File imageFile) {
        setBackgroundImage(new ImageIcon(imageFile.getPath()));
    }

    public void setBackgroundImage(ImageIcon image) {
        backgroundImage = image;

        backgroundLabel.setIcon(backgroundImage);

        logger.debug("Image panel background image set: {}", backgroundImage);
    }

    @Override
    public Dimension getPreferredSize() {
        if (backgroundImage != null) {
            return super.getPreferredSize();
        } else {
            return new Dimension(20, 20);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
