package tksoft.boundaries.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private static Logger logger = LoggerFactory.getLogger(DrawPanel.class);

    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

    private JPanel imagePanel = new JPanel();

    public DrawPanel() {
        this.setBackground(new Color(45, 45, 55));
        this.setLayout(flowLayout);

        add(imagePanel);
    }
}
