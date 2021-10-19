package Graphics_2D.Kernel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SWindow
{
    int width;
    int height;
    String name;
    String id;
    Frame frame;
    SCanvas sCanvas;
    public SWindow(int width, int height, String name)
    {
        this.width=width;
        this.height=height;
        this.name=name;
        paint();
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return id;
    }
    public SCanvas getSCanvas()
    {
        return sCanvas;
    }
    public Frame getFrame()
    {
        return frame;
    }
    public void paint()
    {
        frame = new Frame(name);
        frame.setSize(width,height);
        sCanvas = new SCanvas(width,height);
        frame.setResizable(false);
        frame.add(sCanvas);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                frame.dispose();
            }
        });
    }
}