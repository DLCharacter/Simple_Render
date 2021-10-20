//Simple line class
//Draws line without smoothing on canvas by algorithm Bresenham
package Graphics_2D;
import Graphics_2D.Kernel.SGL;
import java.awt.*;
public class SLine
{
    protected static void drawSLine(int x1, int y1, int x2, int y2, Color color)
    {
        double angleOfInclination = (double)(y2-y1)/(x2-x1);
        double reversAngleOfInclination = (double)(x2-x1)/(y2-y1);
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
        }
        if(Math.abs(x2-x1)>Math.abs(y2-y1))
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
                Color c = new Color(color.getRed(),color.getGreen(),color.getBlue());
                SGL.setPixel(x,y,c);
                currentError += angleOfInclination;
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
                Color c = new Color(color.getRed(),color.getGreen(),color.getBlue());
                SGL.setPixel(x,y,c);
                currentError += reversAngleOfInclination;
                if((currentError>errorMax) && (errorMax>0)||(currentError<errorMax) && (errorMax<0))
                {
                    x += (int)Math.ceil(errorMax*2);
                    currentError -= Math.ceil(errorMax*2);
                }
            }
        }
    }
}