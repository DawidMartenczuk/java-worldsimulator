package pl.dawidmartenczuk.world.plants;

import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.Plant;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Belladonna extends Plant {

    public Belladonna(Position position, World world) {
        super(position, world);
        this.name = "Belladonna";
        this.shortcut = "B";
        this.strength = 99;
    }

    @Override
    public boolean checkCollision(Organism other)
    {
        other.kill();
        this.kill();
        return false;
    }

}
