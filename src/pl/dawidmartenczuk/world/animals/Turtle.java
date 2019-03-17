package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

import java.util.Random;

public class Turtle extends Animal {

    public Turtle(Position position, World world) {
        super(position, world);
        this.name = "Turtle";
        this.shortcut = "T";
        this.initiative = 1;
        this.strength = 2;
    }

    @Override public void action()
    {
        Random rand = new Random();
        if(rand.nextInt(100) >= 75) {
            return;
        }
        move(world.nearbyArea(location, 1));
    }

    @Override
    public boolean checkCollision(Organism other)
    {
        if(other.getStrength()<5)
        {
            other.movePermission=false;
            this.movePermission=false;
            return false;
        }

        return true;

    }
}
