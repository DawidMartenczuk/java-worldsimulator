package pl.dawidmartenczuk.ui.listeners;

import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.Simulator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrganism implements ActionListener
{
    private String name;

    private int x, y;

    Simulator simulator;

    public CreateOrganism(int x, int y, Simulator simulator, String name)
    {
        this.name = name.substring(4);
        this.x = x;
        this.y = y;
        this.simulator = simulator;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        simulator.addOrganism(new Position(x,y),name);
        simulator.render();
    }
}
