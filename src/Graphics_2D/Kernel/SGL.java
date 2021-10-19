package Graphics_2D.Kernel;
import java.awt.*;
import java.util.ArrayList;
public class SGL
{
    static int selectedWindow;
    static ArrayList<SWindow> windows = new ArrayList();
    public static void addWindow(int x, int y, String nameAndId)
    {
        windows.add(new SWindow(x,y,nameAndId));
        windows.get(windows.size()-1).setId(nameAndId);
        selectedWindow = windows.size()-1;
    }
    public static void addWindow(int x, int y, String name, String id)
    {
        windows.add(new SWindow(x,y,name));
        windows.get(windows.size()-1).setId(id);
        selectedWindow = windows.size()-1;
    }
    public static void selectWindow(String id)
    {
        for(SWindow w : windows)
            if(w.getId().equals(id))
            {
                selectedWindow = windows.indexOf(w);
                return;
            }
        System.out.println("Cant find window with this id");
        return;
    }
    public static void deleteWidow()
    {
        windows.remove(selectedWindow);
    }
    public static void deleteWindow(String id)
    {
        for(SWindow w : windows)
            if(w.getId().equals(id))
            {
                windows.remove(w);
                return;
            }
        System.out.println("Cant find window with this id");
        return;
    }
    public static void setPixel(int x, int y)
    {
        windows.get(selectedWindow).getSCanvas().addPoint(new Point(x,y));
    }
    public static void setPixel(int x, int y, Color color)
    {
        windows.get(selectedWindow).getSCanvas().addPoint(new Point(x,y,color));
    }
    public static void repaint()
    {
        windows.get(selectedWindow).getSCanvas().repaint();
        windows.get(selectedWindow).getFrame().setVisible(true);
    }
}