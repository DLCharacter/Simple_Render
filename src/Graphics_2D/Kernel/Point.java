package Graphics_2D.Kernel;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Point
{
    int x;
    int y;
    Color color;
    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
        color=new Color(0,0,0);
    }
    public Point(int x, int y, Color color)
    {
        this.x=x;
        this.y=y;
        this.color=color;
    }
    public void paint(BufferedImage image)
    {
        image.setRGB(x,y,color.getRGB());
    }
}