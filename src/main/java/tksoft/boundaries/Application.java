package tksoft.boundaries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tksoft.boundaries.actions.Actions;
import tksoft.boundaries.components.MainMenuBar;
import tksoft.boundaries.icons.ApplicationIcon;
import tksoft.boundaries.icons.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main Boundaries application class. The application is started by running
 * <code>Application.main()</code>.
 */
public class Application extends JFrame implements WindowListener {

    private static Application window = new Application("Boundaries");

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private Actions actions = new Actions(this);

    private void init() {
        addWindowListener(this); // Adds the window listener that is implemented in this very class

        // Initialize main window components
        setJMenuBar(new MainMenuBar(actions));

        JToolBar drawToolbar = new JToolBar("Draw");

        JButton boundaryButton = new JButton(IconUtil.getIcon(ApplicationIcon.ACCESSORIES));
        drawToolbar.add(boundaryButton);

        add(drawToolbar, BorderLayout.PAGE_START);

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

    @Override
    public void windowOpened(WindowEvent windowEvent) {}

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

    @Override
    public void windowClosed(WindowEvent windowEvent) {}

    @Override
    public void windowIconified(WindowEvent windowEvent) {}

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {}

    @Override
    public void windowActivated(WindowEvent windowEvent) {}

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {}

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
}
