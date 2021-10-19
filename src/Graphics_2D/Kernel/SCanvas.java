package Graphics_2D.Kernel;
import java.awt.*;
import java.awt.image.BufferedImage;
public class SCanvas extends Panel
{
    BufferedImage sCanvasImage;
    SCanvas(int width, int height)
    {
        sCanvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = sCanvasImage.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, width, height);
    }
    public void addPoint(Point point)
    {
        point.paint(sCanvasImage);
    }
    public void paint(Graphics g)
    {
        g.drawImage(sCanvasImage, 0, 0, this);
    }
}