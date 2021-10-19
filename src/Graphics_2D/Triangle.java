package Graphics_2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
public class Triangle
{
    public static void drawTriangle(Vertex_2D firstPoint, Vertex_2D secondPoint, Vertex_2D thirdPoint, Color borderColor, Color fillColor)
    {
        ArrayList<Vertex_2D> vertexes = new ArrayList<>();
        vertexes.add(firstPoint);
        vertexes.add(secondPoint);
        vertexes.add(thirdPoint);
        vertexes.sort(vertex_2DComparator);
        float coefficient01 = (float)(vertexes.get(1).getX()-vertexes.get(0).getX())/(vertexes.get(1).getY()-vertexes.get(0).getY());
        float coefficient02 = (float)(vertexes.get(2).getX()-vertexes.get(0).getX())/(vertexes.get(2).getY()-vertexes.get(0).getY());
        float coefficient12 = (float)(vertexes.get(2).getX()-vertexes.get(1).getX())/(vertexes.get(2).getY()-vertexes.get(1).getY());
        for(int i=vertexes.get(0).getY();i<=vertexes.get(1).getY();i++)
        {
            int currentX01 = Math.round((i-vertexes.get(1).getY())*coefficient01)+vertexes.get(1).getX();
            int currentX02 = (int)Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine.drawSLine(currentX01,i,currentX02,i,fillColor);
        }
        for(int i=vertexes.get(2).getY();i>vertexes.get(1).getY();i--)
        {
            int currentX12 = Math.round((i-vertexes.get(2).getY())*coefficient12)+vertexes.get(2).getX();
            int currentX20 = (int)Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine.drawSLine(currentX12,i,currentX20,i,fillColor);
        }
        SLine.drawSLine(vertexes.get(2).getX(),vertexes.get(2).getY(),vertexes.get(0).getX(),vertexes.get(0).getY(),borderColor);
        SLine.drawSLine(vertexes.get(0).getX(),vertexes.get(0).getY(),vertexes.get(1).getX(),vertexes.get(1).getY(),borderColor);
        SLine.drawSLine(vertexes.get(1).getX(),vertexes.get(1).getY(),vertexes.get(2).getX(),vertexes.get(2).getY(),borderColor);
    }
    static Comparator<Vertex_2D> vertex_2DComparator = new Comparator<>()
    {
        @Override
        public int compare(Vertex_2D o1, Vertex_2D o2)
        {
            return o1.getY().compareTo(o2.getY());
        }
    };
}