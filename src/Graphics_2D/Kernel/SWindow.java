//Window class
//Draws windows and frames
package Graphics_2D.Kernel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SWindow
{
    private int width;
    private int height;
    private String name;
    private String id;
    private Frame frame;
    private SCanvas sCanvas;
    protected SWindow(int width, int height, String name)
    {
        this.width=width;
        this.height=height;
        this.name=name;
        paint();
    }
    protected void setId(String id)
    {
        this.id = id;
    }
    protected String getId()
    {
        return id;
    }
    protected SCanvas getSCanvas()
    {
        return sCanvas;
    }
    protected Frame getFrame()
    {
        return frame;
    }
    protected void paint()
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