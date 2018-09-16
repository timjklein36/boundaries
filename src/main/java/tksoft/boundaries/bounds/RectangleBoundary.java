package tksoft.boundaries.bounds;

import java.awt.*;

public class RectangleBoundary extends Rectangle implements Boundary {

    private Color color = Color.WHITE;

    public RectangleBoundary(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public RectangleBoundary(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.drawRect(x, y, width, height);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "RectangleBoundary [x=" +
                x + ",y=" + y +
                ",width=" + width + ",height=" + height +
                ",color=" + color + "]";
    }
}
