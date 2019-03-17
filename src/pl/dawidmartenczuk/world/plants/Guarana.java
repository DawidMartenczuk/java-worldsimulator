package pl.dawidmartenczuk.world.plants;

import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.Plant;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Guarana extends Plant {

    public Guarana(Position position, World world) {
        super(position, world);
        this.name = "Guarana";
        this.shortcut = "Gu";
    }

    @Override
    public boolean checkCollision(Organism other)
    {
        other.setStrength(other.getStrength()+3);
        return true;
    }
}
