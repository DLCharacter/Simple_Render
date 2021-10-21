package Graphics_3D;
public class ZBuffer
{
    private int[][] currentBuffer;
    public ZBuffer(int width, int height)
    {
        currentBuffer = new int[width][height];
        for(int i=0;i<width;i++)
            for(int j=0;j<width;j++)
                currentBuffer[i][j] = -1;
    }
    protected int[][] getCurrentBuffer()
    {
        return currentBuffer;
    }
    protected void changeBuffer(int x, int y, int z)
    {
        currentBuffer[x][y] = z;
    }
}
