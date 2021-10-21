//User interface class
//Connects all classes in this package
//Used to import
package Graphics_2D;
import Util.Vertex_2D;
import java.awt.*;
public class SGraphics_2D
{
    //Line with smoothing methods
    public static void drawLineWithSmoothing(int x1, int y1, int x2, int y2, Color color)
    {
        Line.drawLine(x1, y1, x2, y2, color);
    }
    public static void drawLineWithSmoothing(int x1, int y1, int x2, int y2)
    {
        Line.drawLine(x1, y1, x2, y2, new Color(0,0,0));
    }
    public static void drawLineWithSmoothing(Vertex_2D firstVertex, Vertex_2D secondVertex, Color color)
    {
        Line.drawLine(firstVertex.getX(), firstVertex.getY(), secondVertex.getX(), secondVertex.getY(), color);
    }
    public static void drawLineWithSmoothing(Vertex_2D firstVertex, Vertex_2D secondVertex)
    {
        Line.drawLine(firstVertex.getX(), firstVertex.getY(), secondVertex.getX(), secondVertex.getY(), new Color(0,0,0));
    }
    //Line without smoothing methods
    public static void drawLineWithoutSmoothing(int x1, int y1, int x2, int y2, Color color)
    {
        SLine.drawSLine(x1, y1, x2, y2, color);
    }
    public static void drawLineWithoutSmoothing(int x1, int y1, int x2, int y2)
    {
        SLine.drawSLine(x1, y1, x2, y2,new Color(0,0,0));
    }
    public static void drawLineWithoutSmoothing(Vertex_2D firstVertex, Vertex_2D secondVertex, Color color)
    {
        SLine.drawSLine(firstVertex.getX(), firstVertex.getY(), secondVertex.getX(), secondVertex.getY(), color);
    }
    public static void drawLineWithoutSmoothing(Vertex_2D firstVertex, Vertex_2D secondVertex)
    {
        SLine.drawSLine(firstVertex.getX(), firstVertex.getY(), secondVertex.getX(), secondVertex.getY(), new Color(0,0,0));
    }
    //Triangle methods
    public static void drawTriangle(Vertex_2D firstVertex, Vertex_2D secondVertex, Vertex_2D thirdVertex, Color borderColor, Color fillColor)
    {
        Triangle.drawTriangle(firstVertex, secondVertex, thirdVertex, borderColor, fillColor);
    }
    public static void drawTriangle(Vertex_2D firstVertex, Vertex_2D secondVertex, Vertex_2D thirdVertex, Color color)
    {
        Triangle.drawTriangle(firstVertex, secondVertex, thirdVertex, color, color);
    }
    public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color borderColor, Color fillColor)
    {
        Triangle.drawTriangle(new Vertex_2D(x1,y1), new Vertex_2D(x2,y2), new Vertex_2D(x3,y3), borderColor, fillColor);
    }
    public static void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color)
    {
        Triangle.drawTriangle(new Vertex_2D(x1,y1), new Vertex_2D(x2,y2), new Vertex_2D(x3,y3), color, color);
    }
}
