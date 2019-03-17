package pl.dawidmartenczuk.world.plants;

import pl.dawidmartenczuk.world.Plant;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class SowThistle extends Plant {

    public SowThistle(Position position, World world) {
        super(position, world);
        this.name = "SowThistle";
        this.shortcut = "So";
    }

    @Override
    public void action()
    {
        multiply();
        multiply();
        multiply();
    }


}