package tksoft.boundaries.config;

public final class Config {
    private static Config CONFIG = new Config();

    private String ICON_DIR = "breathe/16x16/";

    private Config() {}

    public static Config getConfig() {
        return CONFIG;
    }

    public String getIconDir() {
        return ICON_DIR;
    }

    public void setIconDir(String iconDir) {
        ICON_DIR = iconDir;
    }
}
