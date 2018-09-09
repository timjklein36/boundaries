package tksoft.boundaries.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ExitAction extends AbstractAction {
    private Component parent;

    private Logger logger = LoggerFactory.getLogger(ExitAction.class);

    public ExitAction(String name, Component parent) {
        super(name);
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.debug("ActionEvent from ExitAction: {}", actionEvent);

        if (confirmExit() == JOptionPane.YES_OPTION) {
            logger.info("Application exited by user");
            System.exit(0);
        }
    }

    private int confirmExit() {
        return JOptionPane.showConfirmDialog(
                parent,
                "Are you sure you want to exit?",
                "Exit?",
                JOptionPane.YES_NO_OPTION
        );
    }
}
