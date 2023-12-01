import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");

        //new MainWindow();

        BufferedImage image = null;

        // READ IMAGE
        try {
            File input_file = new File("C:/Users/hp/Desktop/Image Processing in Java/gfg-logo.png");

            image = new BufferedImage(
                    width, height, BufferedImage.TYPE_INT_ARGB);

            // Reading input file
            image = ImageIO.read(input_file);

            System.out.println("Reading complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // WRITE IMAGE
        try {
            // Output file path
            File output_file = new File(
                    "C:/Users/hp/Desktop/Image Processing in Java/gfg.png");

            // Writing to file taking type and path as
            ImageIO.write(image, "png", output_file);

            System.out.println("Writing complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
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