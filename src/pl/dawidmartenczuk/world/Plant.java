package pl.dawidmartenczuk.world;

import java.util.Random;

public class Plant extends Organism {

    public Plant(Position position, World world)
    {
        super(position,world);
        this.strength=0;
        this.initiative=0;
    }

    @Override
    public void multiply()
    {
        Random random = new Random();
        Position position2 = world.freeNearbyArea(location, 1);
        if(position2.isEqual(location))return;
        if(random.nextInt(10)==0)
        {
            world.addOrganism(position2, this.getName());
        }
    }

    public void action()
    {
        multiply();
    }
}
