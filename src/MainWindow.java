import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainWindow extends JFrame {
    public static void main(String[] args) throws IOException {
        //System.setProperty("sun.java2d.opengl", "true");
        //new MainWindow();

        HashSet<Integer> palette = new HashSet<>();

        HashMap<Integer, Integer> north = new HashMap<>();
        HashMap<Integer, Integer> east = new HashMap<>();
        HashMap<Integer, Integer> south = new HashMap<>();
        HashMap<Integer, Integer> west = new HashMap<>();

        HashMap[] directions = new HashMap[] {north, east, south, west};


        String imagePath = "src/in.png";
        BufferedImage image = ImageIO.read(new File(imagePath));


        System.out.println(image);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x,y);
                palette.add(color);
                if (y-1>-1) north.put(color,image.getRGB(x,y-1));
                if (y+1<image.getHeight()) south.put(color,image.getRGB(x,y+1));
                if (x+1<image.getWidth()) east.put(color,image.getRGB(x+1,y));
                if (x-1>-1) west.put(color,image.getRGB(x-1,y));
            }
        }

        System.out.println(palette);
        System.out.println(north);
        System.out.println(east);
        System.out.println(south);
        System.out.println(west);

        // reWrite image
        File output_file = new File("out2.png");
        BufferedImage output_image = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        ArrayList<Integer> paletteArray = new ArrayList<>(palette);

        for (int y = 0; y < output_image.getHeight(); y++) {
            for (int x = 0; x < output_image.getWidth(); x++) {
                output_image.setRGB(x,y, paletteArray.get((int) (Math.random()*palette.size())));
            }
        }
        ImageIO.write(output_image, "png", output_file);
    }

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setAlwaysOnTop(true);
        setSize(800, 800);
        setTitle("collapse");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Renderer renderer= new Renderer(getWidth(),getHeight(), 1);
        add(renderer,BorderLayout.CENTER);

        setVisible(true);
    }
}