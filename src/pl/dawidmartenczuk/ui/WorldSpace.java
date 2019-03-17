package pl.dawidmartenczuk.ui;

import  pl.dawidmartenczuk.Simulator;

import javax.swing.JPanel;
import java.awt.*;

public class WorldSpace extends JPanel {

    private WorldArea[][] areas;
    private final int size_x, size_y;

    public WorldSpace(int x, int y, Simulator simulator)
    {
        this.size_x = x;
        this.size_y = y;
        setLayout(new GridLayout(x,y,1,1));
        this.areas = new WorldArea[x][y];
        for(int b=0;b<y;b++)
        {
            for(int a=0;a<x;a++)
            {
                areas[a][b]=new WorldArea(a,b,simulator);
                add(areas[a][b]);
            }
        }
    }

    public void fill(String text, Color color, int x, int y)
    {
        areas[x][y].setText(text);
        areas[x][y].setColor(color);
    }

    public void clear()
    {
        for(int b = 0; b< size_y; b++)
        {
            for(int a = 0; a< size_x; a++)
            {
                areas[a][b].clearField();
            }
        }
    }

}
