package Graphics_2D;
import Graphics_2D.Kernel.SGL;
import java.awt.*;
public class Line
{
    public static void drawLine(int x1, int y1, int x2, int y2)
    {
        double angleOfInclination = (double)(y2-y1)/(x2-x1);
        double reversAngleOfInclination = (double)(x2-x1)/(y2-y1);
        boolean isXAxisMain = Math.abs(x2-x1)>Math.abs(y2-y1);
        boolean isYAxisMain = Math.abs(x2-x1)<=Math.abs(y2-y1);
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
                int intensity = (int)Math.abs(currentError*255);
                Color c = new Color(intensity,intensity,intensity);
                int intensity2 = (int)((1-Math.abs(currentError))*255);
                Color c2 = new Color(intensity2,intensity2,intensity2);
                SGL.setPixel(x,y,c);
                double currentY = angleOfInclination*(x-x1)+y1;
                double upperPixelDistance = y+1-currentY;
                double loverPixelDistance = Math.abs(y-1-currentY);
                if(upperPixelDistance<loverPixelDistance)
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x,y+1,c2);
                }
                else
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x,y-1,c2);
                }
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
                int intensity = (int)Math.abs(currentError*255);
                Color c = new Color(intensity,intensity,intensity);
                int intensity2 = (int)((1-Math.abs(currentError))*255);
                Color c2 = new Color(intensity2,intensity2,intensity2);
                SGL.setPixel(x,y,c);
                double currentX = reversAngleOfInclination*(y-y1)+x1;
                double upperPixelDistance = x+1-currentX;
                double loverPixelDistance = Math.abs(x-1-currentX);
                if(upperPixelDistance<loverPixelDistance)
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x+1,y,c2);
                }
                else
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x-1,y,c2);
                }
                currentError += reversAngleOfInclination;
                if((currentError>errorMax) && (errorMax>0)||(currentError<errorMax) && (errorMax<0))
                {
                    x += (int)Math.ceil(errorMax*2);
                    currentError -= Math.ceil(errorMax*2);
                }
            }
        }
    }
    public static void drawLine(int x1, int y1, int x2, int y2, Color color)
    {
        double angleOfInclination = (double)(y2-y1)/(x2-x1);
        double reversAngleOfInclination = (double)(x2-x1)/(y2-y1);
        boolean isXAxisMain = Math.abs(x2-x1)>Math.abs(y2-y1);
        boolean isYAxisMain = Math.abs(x2-x1)<=Math.abs(y2-y1);
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
                int intensityR = (int)Math.abs(currentError*(255-color.getRed()));
                int intensityG = (int)Math.abs(currentError*(255-color.getGreen()));
                int intensityB = (int)Math.abs(currentError*(255-color.getBlue()));
                Color c = new Color(intensityR+color.getRed(),intensityG+color.getGreen(),intensityB+color.getBlue());
                int intensityR2 = (int)((1-Math.abs(currentError))*(255-color.getRed()));
                int intensityG2 = (int)((1-Math.abs(currentError))*(255-color.getGreen()));
                int intensityB2 = (int)((1-Math.abs(currentError))*(255-color.getBlue()));
                Color c2 = new Color(intensityR2+color.getRed(),intensityG2+color.getGreen(),intensityB2+color.getBlue());
                SGL.setPixel(x,y,c);
                double currentY = angleOfInclination*(x-x1)+y1;
                double upperPixelDistance = y+1-currentY;
                double loverPixelDistance = Math.abs(y-1-currentY);
                if(upperPixelDistance<loverPixelDistance)
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x,y+1,c2);
                }
                else
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x,y-1,c2);
                }
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
                int intensityR = (int)Math.abs(currentError*(255-color.getRed()));
                int intensityG = (int)Math.abs(currentError*(255-color.getGreen()));
                int intensityB = (int)Math.abs(currentError*(255-color.getBlue()));
                Color c = new Color(intensityR+color.getRed(),intensityG+color.getGreen(),intensityB+color.getBlue());
                int intensityR2 = (int)((1-Math.abs(currentError))*(255-color.getRed()));
                int intensityG2 = (int)((1-Math.abs(currentError))*(255-color.getGreen()));
                int intensityB2 = (int)((1-Math.abs(currentError))*(255-color.getBlue()));
                Color c2 = new Color(intensityR2+color.getRed(),intensityG2+color.getGreen(),intensityB2+color.getBlue());
                SGL.setPixel(x,y,c);
                double currentX = reversAngleOfInclination*(y-y1)+x1;
                double upperPixelDistance = x+1-currentX;
                double loverPixelDistance = Math.abs(x-1-currentX);
                if(upperPixelDistance<loverPixelDistance)
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x+1,y,c2);
                }
                else
                {
                    if(c2.getBlue()+c2.getGreen()+c2.getRed()<755)
                        SGL.setPixel(x-1,y,c2);
                }
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