package tksoft.boundaries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tksoft.boundaries.actions.Actions;
import tksoft.boundaries.components.DrawPanel;
import tksoft.boundaries.components.DrawToolBar;
import tksoft.boundaries.components.MainMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main Boundaries application class. The application is started by running
 * <code>Application.main()</code>.
 */
public class Application extends JFrame {

    private static Application window = new Application("Boundaries");

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private WindowListener windowListener = new ApplicationWindowListener();

    private JFileChooser fileChooser = new JFileChooser();

    private Actions actions = new Actions(this, this.fileChooser);

    private void init() {
        addWindowListener(windowListener); // Adds the window listener that is implemented in this very class

        // Initialize main window components
        setJMenuBar(new MainMenuBar(actions));

        add(new DrawToolBar(), BorderLayout.PAGE_START);

        add(new DrawPanel(fileChooser));

        // Log some system information
        String hostName = "UNKNOWN_HOST";
        String userName = System.getProperty("user.name");

        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.debug("Could not get hostname: {}", e);
        }

        logger.info("Application Initialized: {}@{}", userName, hostName);
    }

    private Application(String windowName) {
        super(windowName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::run);
    }

    private static void run() {
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.init();
        window.pack();
        window.setVisible(true);
    }

    private class ApplicationWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent windowEvent) {
            actions.EXIT.actionPerformed(new ActionEvent(
                    windowEvent.getSource(),
                    ActionEvent.ACTION_PERFORMED,
                    windowEvent.toString(),
                    System.currentTimeMillis(),
                    InputEvent.BUTTON1_MASK
            ));
        }
    }
}
