package tksoft.boundaries.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class OpenFileAction extends AbstractAction {
    private static Logger logger = LoggerFactory.getLogger(OpenFileAction.class);

    public OpenFileAction(String name, Icon icon) {
        super(name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.info("OpenFileAction performed");
    }
}
