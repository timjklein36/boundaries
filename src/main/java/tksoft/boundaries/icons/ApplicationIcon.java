package tksoft.boundaries.icons;

import java.util.HashMap;
import java.util.Map;

import static tksoft.boundaries.config.ConfigConstants.ICON_DIR;

public enum ApplicationIcon {
    ACCESSORIES(ICON_DIR + "categories/applications-accessories.png"),
    FLOPPY(ICON_DIR + "places/media-floppy.png"),
    FOLDER(ICON_DIR + "places/folder.png");

    private String path;

    private static Map<ApplicationIcon, String> iconToPath;
    static {
        iconToPath = new HashMap<>();
        for (ApplicationIcon icon : values()) {
            iconToPath.put(icon, icon.path);
        }
    }

    ApplicationIcon(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.toString();
    }

    @Override
    public String toString() {
        return iconToPath.get(this);
    }
}