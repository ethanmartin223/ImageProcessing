import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    boolean[][] pixels;
    int pixelScale;

    public Renderer(int w, int h, int resolution) {
        pixelScale = resolution;
        pixels = new boolean[h / resolution][w / resolution];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.draw3DRect(60,60,60,60, true);
//        for (int y = 0; y < pixels.length; y++) {
//            for (int x = 0; x < pixels[0].length; x++) {
//                    g.setColor(Color.BLACK);
//                    g.fillRect((x * pixelScale), (y * pixelScale), pixelScale, pixelScale);
//            }
//        }
    }
}
