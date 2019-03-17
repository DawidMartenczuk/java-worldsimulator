package pl.dawidmartenczuk.world.plants;

import pl.dawidmartenczuk.world.Plant;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Grass extends Plant {

    public Grass(Position position, World world) {
        super(position, world);
        this.name = "Grass";
        this.shortcut = "Gr";
    }

}

