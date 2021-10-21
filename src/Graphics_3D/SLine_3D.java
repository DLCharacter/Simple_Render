//Simple 3D line class
//Draws line without smoothing on canvas by algorithm Bresenham
package Graphics_3D;
import Graphics_2D.Kernel.SGL;
import Util.Vertex_3D;

import java.awt.*;
public class SLine_3D
{
    public static void drawSLine_3D(Vertex_3D firstVertex, Vertex_3D secondVertex, Color color, ZBuffer zBuffer)
    {
        int x1,x2,y1,y2;
        x1 = firstVertex.getX();
        x2 = secondVertex.getX();
        y1 = firstVertex.getY();
        y2 = secondVertex.getY();
        int z1 = firstVertex.getZ();
        int z2 = secondVertex.getZ();
        float currentZ;
        int[][] buffer = zBuffer.getCurrentBuffer();
        double angleOfInclination = (double)(y2-y1)/(x2-x1);
        double reversAngleOfInclination = (double)(x2-x1)/(y2-y1);
        double angleOfInclinationZ = (double)(z2-z1)/(x2-x1);
        double reversAngleOfInclinationZ = (double)(z2-z1)/(y2-y1);
        boolean isXAxisMain = Math.abs(x2-x1)>Math.abs(y2-y1);
        boolean isYAxisMain = Math.abs(x2-x1)<Math.abs(y2-y1);
        if((x2<x1) && isXAxisMain || (y2<y1) && isYAxisMain)
        {
            x2 += x1;
            x1 = x2-x1;
            x2 -= x1;
            y2 += y1;
            y1 = y2-y1;
            y2 -= y1;
            z2 += z1;
            z1 = z2-z1;
            z2 -= z1;
        }
        currentZ = z1;
        if(isXAxisMain)
        {
            double errorMax;
            double currentError = 0;
            int y = y1;
            if(angleOfInclination<0)
                errorMax = -0.5;
            else
                errorMax = 0.5;
            for(int x=x1;x<x2;x++)
            {
                if((currentZ < buffer[x][y]) || (buffer[x][y] < 0))
                {
                    zBuffer.changeBuffer(x, y, Math.round(currentZ));
                    Color c = new Color(color.getRed(), color.getGreen(), color.getBlue());
                    SGL.setPixel(x, y, c);
                }
                currentError += angleOfInclination;
                currentZ += angleOfInclinationZ;
                if((currentError>errorMax) && (errorMax>0)||(currentError<errorMax) && (errorMax<0))
                {
                    y += (int)Math.ceil(errorMax*2);
                    currentError -= Math.ceil(errorMax*2);
                }
            }
        }
        else
        {
            double errorMax;
            double currentError = 0;
            int x = x1;
            if(reversAngleOfInclination<0)
                errorMax = -0.5;
            else
                errorMax = 0.5;
            for(int y=y1;y<y2;y++)
            {
                if((currentZ < buffer[x][y]) || (buffer[x][y] < 0))
                {
                    zBuffer.changeBuffer(x, y, Math.round(currentZ));
                    Color c = new Color(color.getRed(), color.getGreen(), color.getBlue());
                    SGL.setPixel(x, y, c);
                }
                currentError += reversAngleOfInclination;
                currentZ += reversAngleOfInclinationZ;
                if((currentError>errorMax) && (errorMax>0)||(currentError<errorMax) && (errorMax<0))
                {
                    x += (int)Math.ceil(errorMax*2);
                    currentError -= Math.ceil(errorMax*2);
                }
            }
        }
    }
}