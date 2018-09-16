package tksoft.boundaries.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class OpenFileAction extends AbstractAction {
    private static Logger logger = LoggerFactory.getLogger(OpenFileAction.class);

    private JFileChooser fileChooser;

    private Component parent;

    private File file;

    OpenFileAction(String name, Icon icon, Component parent, JFileChooser fileChooser) {
        super(name, icon);
        this.parent = parent;
        this.fileChooser = fileChooser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.debug("Action performed: {}", actionEvent);

        int chosenOption = fileChooser.showOpenDialog(parent);

        if (chosenOption == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();

            logger.debug("User approved file open: {}", file);
        } else if (chosenOption == JFileChooser.CANCEL_OPTION) {
            logger.debug("User canceled file open");
        }
    }

    private File emitFileToParent() {
        logger.debug("Emitting file ('{}') to parent component", file);
        return file;
    }
}
