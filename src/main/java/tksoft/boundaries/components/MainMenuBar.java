package tksoft.boundaries.components;

import tksoft.boundaries.actions.Actions;
import tksoft.boundaries.icons.ApplicationIcon;
import tksoft.boundaries.icons.IconUtil;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(Actions actions) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem fileOpenMenuItem = new JMenuItem();
        fileOpenMenuItem.setAction(actions.OPEN_FILE);
        fileOpenMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fileOpenMenuItem.setMnemonic(KeyEvent.VK_O);
        fileMenu.add(fileOpenMenuItem);

        JMenuItem fileSaveMenuItem = new JMenuItem("Save", IconUtil.getIcon(ApplicationIcon.FLOPPY));
        fileSaveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        fileSaveMenuItem.setMnemonic(KeyEvent.VK_S);
        fileMenu.add(fileSaveMenuItem);

        JMenuItem fileSaveAsMenuItem = new JMenuItem("Save as...");
        fileMenu.add(fileSaveAsMenuItem);

        JMenuItem exitMenuItem = new JMenuItem();
        exitMenuItem.setAction(actions.EXIT);
        fileMenu.add(exitMenuItem);

        add(fileMenu);
    }
}
