package tksoft.boundaries.icons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class IconUtil {

    private static Logger logger = LoggerFactory.getLogger(IconUtil.class);

    private static Map<ApplicationIcon, ImageIcon> loadedIcons = new HashMap<>();

    /**
     * Returns a javax.swing.ImageIcon that is created by loading the image
     * specified by path.
     **/
    public static ImageIcon createImageIcon(String path) {
        return createImageIcon(path, "");
    }

    /**
     * Creates a javax.swing.ImageIcon and adds a description.
     **/
    public static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = IconUtil.class.getResource(path);

        if (imgURL != null) {
            logger.debug("Successfully loaded icon image: \"{}\"", path);
            return new ImageIcon(imgURL, description);
        } else {
            logger.error("Couldn't image find file: {}", path);
            return null;
        }
    }

    /**
     * Retrieve a pre-loaded icon from one of the ApplicationIcons. Loads the icon
     * if not done so already.
     */
    public static ImageIcon getIcon(ApplicationIcon icon) {
        ImageIcon cachedIcon = loadedIcons.get(icon);

        if (cachedIcon != null) {
            return cachedIcon;
        } else {
            ImageIcon loadedIcon = createImageIcon(icon.getPath());
            loadedIcons.put(icon, loadedIcon);
            return loadedIcon;
        }
    }
}
