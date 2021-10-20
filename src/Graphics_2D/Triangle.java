//Triangle class
//Draws triangles without creating instance of class
package Graphics_2D;
import Util.Vertex_2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
public class Triangle
{
    protected static void drawTriangle(Vertex_2D firstVertex, Vertex_2D secondVertex, Vertex_2D thirdVertex, Color borderColor, Color fillColor)
    {
        ArrayList<Vertex_2D> vertexes = new ArrayList<>();//List with vertexes of triangle
        vertexes.add(firstVertex);
        vertexes.add(secondVertex);
        vertexes.add(thirdVertex);
        vertexes.sort(vertex_2DComparator);//Sorting vertexes in ascending order of Y
        //Coefficients formula: (x2-x1)/(y2-y1)
        float coefficient01 = (float)(vertexes.get(1).getX()-vertexes.get(0).getX())/(vertexes.get(1).getY()-vertexes.get(0).getY());
        float coefficient02 = (float)(vertexes.get(2).getX()-vertexes.get(0).getX())/(vertexes.get(2).getY()-vertexes.get(0).getY());
        float coefficient12 = (float)(vertexes.get(2).getX()-vertexes.get(1).getX())/(vertexes.get(2).getY()-vertexes.get(1).getY());
        //This cycles draw horizontal lines for every Y of triangle
        //We need compute X1 and X2 for each Y
        //In line with two points: x = (x2-x1)(y-y2)/(y2-y1)+x2
        //Coefficients formula: (x2-x1)/(y2-y1) so x = (y-y2)*coefficient+x2
        //y=i, we have two lines with two points for each Y, so we can compute X1 and X2
        for(int i=vertexes.get(0).getY();i<=vertexes.get(1).getY();i++)
        {
            int currentX01 = Math.round((i-vertexes.get(1).getY())*coefficient01)+vertexes.get(1).getX();
            int currentX02 = Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine.drawSLine(currentX01,i,currentX02,i,fillColor);
        }
        for(int i=vertexes.get(2).getY();i>vertexes.get(1).getY();i--)
        {
            int currentX12 = Math.round((i-vertexes.get(2).getY())*coefficient12)+vertexes.get(2).getX();
            int currentX20 = (int)Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine.drawSLine(currentX12,i,currentX20,i,fillColor);
        }
        //Drawing borders
        SLine.drawSLine(vertexes.get(2).getX(),vertexes.get(2).getY(),vertexes.get(0).getX(),vertexes.get(0).getY(),borderColor);
        SLine.drawSLine(vertexes.get(0).getX(),vertexes.get(0).getY(),vertexes.get(1).getX(),vertexes.get(1).getY(),borderColor);
        SLine.drawSLine(vertexes.get(1).getX(),vertexes.get(1).getY(),vertexes.get(2).getX(),vertexes.get(2).getY(),borderColor);
    }
    static private Comparator<Vertex_2D> vertex_2DComparator = new Comparator<>()//Sorting vertexes in ascending order of Y
    {
        @Override
        public int compare(Vertex_2D o1, Vertex_2D o2)
        {
            return o1.getY().compareTo(o2.getY());
        }
    };
}