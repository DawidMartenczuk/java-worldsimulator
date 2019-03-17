package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Wolf extends Animal {

    public Wolf(Position position, World world) {
        super(position, world);
        this.name = "Wolf";
        this.shortcut = "W";
        this.initiative = 5;
        this.strength = 9;
    }
}