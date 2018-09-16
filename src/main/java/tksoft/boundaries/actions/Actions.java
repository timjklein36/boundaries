package tksoft.boundaries.actions;

import tksoft.boundaries.icons.ApplicationIcon;
import tksoft.boundaries.icons.IconUtil;

import javax.swing.*;
import java.awt.*;

public class Actions {
    public ExitAction EXIT;
    public OpenFileAction OPEN_FILE;

    public Actions(Component windowComponent, JFileChooser fileChooser) {
        EXIT = new ExitAction("Exit", windowComponent);
        OPEN_FILE = new OpenFileAction(
                "Open",
                IconUtil.getIcon(ApplicationIcon.FOLDER),
                windowComponent,
                fileChooser
        );
    }
}
