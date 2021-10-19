package Graphics_2D;
import Graphics_2D.Kernel.SGL;
import java.awt.*;
public class Example
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        SGL.addWindow(600,600,"Example");
        Triangle.drawTriangle(new Vertex_2D(100,400),new Vertex_2D(200,100),new Vertex_2D(300,200),
                new Color(255,0,0),new Color(40,40,255));
        Triangle.drawTriangle(new Vertex_2D(250,100),new Vertex_2D(300,200),new Vertex_2D(400,150),
                new Color(255,0,0),new Color(40,40,255));
        Triangle.drawTriangle(new Vertex_2D(100,400),new Vertex_2D(400,150),new Vertex_2D(550,500),
                new Color(255,0,0),new Color(40,40,255));
        SGL.repaint();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
