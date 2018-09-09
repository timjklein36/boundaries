package tksoft.boundaries.components;

import tksoft.boundaries.icons.ApplicationIcon;
import tksoft.boundaries.icons.IconUtil;

import javax.swing.*;

public class DrawToolBar extends JToolBar {
    public DrawToolBar() {
        JButton boundaryButton = new JButton(IconUtil.getIcon(ApplicationIcon.ACCESSORIES));
        add(boundaryButton);
    }
}
