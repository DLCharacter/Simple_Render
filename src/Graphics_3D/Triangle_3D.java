package Graphics_3D;

import Graphics_2D.SLine;
import Util.Vertex_3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Triangle_3D
{
    public static void drawTriangle(Vertex_3D firstVertex, Vertex_3D secondVertex, Vertex_3D thirdVertex, Color borderColor, Color fillColor, ZBuffer buffer)
    {
        ArrayList<Vertex_3D> vertexes = new ArrayList<>();//List with vertexes of triangle
        vertexes.add(firstVertex);
        vertexes.add(secondVertex);
        vertexes.add(thirdVertex);
        vertexes.sort(vertex_3DComparator);//Sorting vertexes in ascending order of Y
        //Coefficients formula: (x2-x1)/(y2-y1)
        float coefficient01 = (float)(vertexes.get(1).getX()-vertexes.get(0).getX())/(vertexes.get(1).getY()-vertexes.get(0).getY());
        float coefficient02 = (float)(vertexes.get(2).getX()-vertexes.get(0).getX())/(vertexes.get(2).getY()-vertexes.get(0).getY());
        float coefficient12 = (float)(vertexes.get(2).getX()-vertexes.get(1).getX())/(vertexes.get(2).getY()-vertexes.get(1).getY());
        float currentZ01 = vertexes.get(0).getZ();
        float currentZ02 = vertexes.get(0).getZ();
        float currentZ12 = vertexes.get(2).getZ();
        float currentZ20 = vertexes.get(2).getZ();
        float angleOfInclinationZ01 = (float)(vertexes.get(1).getZ()-vertexes.get(0).getZ())/(vertexes.get(1).getY()-vertexes.get(0).getY());
        float angleOfInclinationZ02 = (float)(vertexes.get(2).getZ()-vertexes.get(0).getZ())/(vertexes.get(2).getY()-vertexes.get(0).getY());
        float angleOfInclinationZ12 = (float)(vertexes.get(2).getZ()-vertexes.get(1).getZ())/(vertexes.get(2).getY()-vertexes.get(1).getY());
        //This cycles draw horizontal lines for every Y of triangle
        //We need compute X1 and X2 for each Y
        //In line with two points: x = (x2-x1)(y-y2)/(y2-y1)+x2
        //Coefficients formula: (x2-x1)/(y2-y1) so x = (y-y2)*coefficient+x2
        //y=i, we have two lines with two points for each Y, so we can compute X1 and X2
        for(int i=vertexes.get(0).getY();i<=vertexes.get(1).getY();i++)
        {
            int currentX01 = Math.round((i-vertexes.get(1).getY())*coefficient01)+vertexes.get(1).getX();
            int currentX02 = Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine_3D.drawSLine_3D(new Vertex_3D(currentX01,i,Math.round(currentZ01)), new Vertex_3D(currentX02,i,Math.round(currentZ02)),fillColor,buffer);
            currentZ01 += angleOfInclinationZ01;
            currentZ02 += angleOfInclinationZ02;
        }
        for(int i=vertexes.get(2).getY();i>vertexes.get(1).getY();i--)
        {
            int currentX12 = Math.round((i-vertexes.get(2).getY())*coefficient12)+vertexes.get(2).getX();
            int currentX20 = Math.round((i-vertexes.get(2).getY())*coefficient02)+vertexes.get(2).getX();
            SLine_3D.drawSLine_3D(new Vertex_3D(currentX12,i,Math.round(currentZ12)),new Vertex_3D(currentX20,i,Math.round(currentZ20)),fillColor,buffer);
            currentZ12 -= angleOfInclinationZ12;
            currentZ20 -= angleOfInclinationZ02;
        }
        //Drawing borders
        SLine_3D.drawSLine_3D(vertexes.get(2),vertexes.get(0),borderColor,buffer);
        SLine_3D.drawSLine_3D(vertexes.get(0),vertexes.get(1),borderColor,buffer);
        SLine_3D.drawSLine_3D(vertexes.get(1),vertexes.get(2),borderColor,buffer);
    }
    static private Comparator<Vertex_3D> vertex_3DComparator = new Comparator<>()//Sorting vertexes in ascending order of Y
    {
        @Override
        public int compare(Vertex_3D o1, Vertex_3D o2)
        {
            return new Integer(o1.getY()).compareTo(o2.getY());
        }
    };
}
