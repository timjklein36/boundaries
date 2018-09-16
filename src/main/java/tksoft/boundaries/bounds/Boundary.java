package tksoft.boundaries.bounds;

import java.awt.*;

public interface Boundary {
    public void paint(Graphics g);

    public void setColor(Color color);

    public Color getColor();
}
