package tksoft.boundaries.icons;

import tksoft.boundaries.config.Config;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationIcon {
    ACCESSORIES("categories/applications-accessories.png"),
    FLOPPY("places/media-floppy.png"),
    FOLDER("places/folder.png");

    private String path;

    private static Map<ApplicationIcon, String> iconToPath;
    static {
        iconToPath = new HashMap<>();
        for (ApplicationIcon icon : values()) {
            iconToPath.put(icon, icon.path);
        }
    }

    ApplicationIcon(String path) {
        this.path = Config.getConfig().getIconDir() + path;
    }

    public String getPath() {
        return this.toString();
    }

    @Override
    public String toString() {
        return iconToPath.get(this);
    }
}
