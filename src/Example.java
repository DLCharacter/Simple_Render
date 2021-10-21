//Class with example of execution program
import Graphics_2D.SGraphics_2D;
import Graphics_3D.SLine_3D;
import Graphics_3D.Triangle_3D;
import Graphics_3D.ZBuffer;
import Util.Vertex_2D;
import Graphics_2D.Kernel.SGL;
import Util.Vertex_3D;
import java.awt.*;
public class Example
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();//Starting program time
        SGL.addWindow(600,600,"Example_2D");
        SGraphics_2D.drawTriangle(new Vertex_2D(50,400),new Vertex_2D(50,100),new Vertex_2D(300,200),
                new Color(255,0,0),new Color(40,200,55));
        SGraphics_2D.drawTriangle(new Vertex_2D(250,100),new Vertex_2D(300,200),new Vertex_2D(400,150),
                new Color(255,0,0),new Color(40,40,255));
        SGraphics_2D.drawTriangle(550,400,550,100, 350, 250, new Color(255,0,0),new Color(40,40,255));
        SGL.repaint();
        SGL.addWindow(700,700,"Example_3D");
        ZBuffer buffer = new ZBuffer(700, 700);
        //SLine_3D.drawSLine_3D(new Vertex_3D(200,250, 100), new Vertex_3D(500,250,10), new Color(255,0,0), buffer);
        Triangle_3D.drawTriangle(new Vertex_3D(200,150,100), new Vertex_3D(200,350,100), new Vertex_3D(550,250,30),
                new Color(40,200,55), new Color(40,200,55), buffer);
        Triangle_3D.drawTriangle(new Vertex_3D(650,100,300), new Vertex_3D(650,400,300), new Vertex_3D(250,250,0),
                new Color(0,0,200), new Color(0,0,200), buffer);
        SGL.repaint();
        long endTime = System.currentTimeMillis();//Ending program time
        System.out.println(endTime-startTime+" ms");//Execution time in ms
    }
}