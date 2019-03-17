package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Sheep extends Animal {

    public Sheep(Position position, World world) {
        super(position, world);
        this.name = "Sheep";
        this.shortcut = "S";
        this.initiative = 4;
        this.strength = 4;
    }

}
