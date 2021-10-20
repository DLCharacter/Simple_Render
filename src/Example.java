//Class with example of execution program
import Graphics_2D.SGraphics_2D;
import Util.Vertex_2D;
import Graphics_2D.Kernel.SGL;
import java.awt.*;
public class Example
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();//Starting program time
        SGL.addWindow(600,600,"Example");
        SGraphics_2D.drawTriangle(new Vertex_2D(100,400),new Vertex_2D(200,100),new Vertex_2D(300,200),
                new Color(255,0,0),new Color(40,40,255));
        SGraphics_2D.drawTriangle(new Vertex_2D(250,100),new Vertex_2D(300,200),new Vertex_2D(400,150),
                new Color(255,0,0),new Color(40,40,255));
        SGraphics_2D.drawTriangle(100,400,400,150, 550, 500, new Color(255,0,0),new Color(40,40,255));
        SGL.repaint();
        long endTime = System.currentTimeMillis();//Ending program time
        System.out.println(endTime-startTime+" ms");//Execution time in ms
    }
}