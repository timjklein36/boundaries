package tksoft.boundaries.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DrawPanel extends JPanel implements ActionListener {

    private static Logger logger = LoggerFactory.getLogger(DrawPanel.class);

    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

    private ImagePanel imagePanel = new ImagePanel();

    private JFileChooser fileChooser;

    private File imageFile;

    public DrawPanel(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;

        this.setBackground(new Color(45, 45, 55));
        this.setLayout(flowLayout);

        fileChooser.addActionListener(this);

        add(imagePanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            imageFile = fileChooser.getSelectedFile();

            imagePanel.setBackgroundImage(imageFile);
        }
    }
}
