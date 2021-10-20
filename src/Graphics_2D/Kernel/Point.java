//Point class
//Draws one point on Canvas
package Graphics_2D.Kernel;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Point
{
    private int x;
    private int y;
    private Color color;
    protected Point(int x, int y)
    {
        this.x=x;
        this.y=y;
        color=new Color(0,0,0);
    }
    protected Point(int x, int y, Color color)
    {
        this.x=x;
        this.y=y;
        this.color=color;
    }
    protected void paint(BufferedImage image)//Scanvas image
    {
        image.setRGB(x,y,color.getRGB());
    }
}