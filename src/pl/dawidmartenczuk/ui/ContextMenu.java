package pl.dawidmartenczuk.ui;

import pl.dawidmartenczuk.Simulator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContextMenu extends MouseAdapter{

    private int x, y;

    private Simulator simulator;

    public ContextMenu(int x, int y, Simulator _simulator)
    {
        this.simulator =_simulator;
        this.x = x;
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent event)
    {
        if(MouseEvent.BUTTON3==event.getButton())
        {
            RightClickMenu menu=new RightClickMenu(x,y,simulator);
            menu.show(event.getComponent(),event.getX(),event.getY());
        }
    }

}

