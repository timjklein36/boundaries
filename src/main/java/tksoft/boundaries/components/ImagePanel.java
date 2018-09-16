package tksoft.boundaries.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tksoft.boundaries.bounds.Boundary;
import tksoft.boundaries.bounds.RectangleBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagePanel extends JPanel {

    private Logger logger = LoggerFactory.getLogger(ImagePanel.class);

    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);

    private JLabel backgroundLabel = new JLabel();
    private ImageIcon backgroundImage;

    private List<Boundary> boundaries = new ArrayList<>();

    ImagePanel() {
        setLayout(flowLayout);

        boundaries.add(new RectangleBoundary(10, 10, 20, 40, Color.CYAN));

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
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Boundary b : boundaries) {
            b.paint(graphics);
            logger.debug("Painted boundary: {}", b);
        }
    }
}
