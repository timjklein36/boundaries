package tksoft.boundaries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application extends JFrame implements WindowListener {

    private static Application window = new Application("Boundaries");

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    private void init() {
        addWindowListener(this); // Adds the window listener that is implemented in this very class

        // Initialize main window components
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem fileOpenMenuItem = new JMenuItem("Open", UIManager.getIcon("FileView.directoryIcon"));

        fileMenu.add(fileOpenMenuItem);

        menuBar.add(fileMenu);

        add(menuBar);

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

    private int confirmExit() {
        return JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Exit?",
                JOptionPane.YES_NO_OPTION
        );
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {}

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if (confirmExit() == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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
