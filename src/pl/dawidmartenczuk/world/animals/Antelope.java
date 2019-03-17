package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

import java.util.Random;

public class Antelope extends Animal {

    public Antelope(Position position, World world) {
        super(position, world);
        name = "Antelope";
        shortcut = "A";
        this.initiative = 4;
        this.strength = 4;
    }

    @Override
    public void action()
    {
        move(world.nearbyArea(location,2));
    }

    @Override
    public boolean checkCollision(Organism other)
    {
        Random random = new Random();
        if(random.nextBoolean())
        {
            Position position2 = world.freeNearbyArea(location, 1);
            if(position2==this.location) {
                return true;
            }
            else {
                this.move(position2);
                return false;
            }
        }
        return true;
    }

}
