package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.world.World;

public class Fox extends Animal {


    public Fox(Position position, World world) {
        super(position, world);
         name = "Fox";
        shortcut = "F";
        this.initiative = 7;
        this.strength = 3;
    }

    @Override
    public void action()
    {
        int attempts = 10;
        Position pos2;
        do{
            if(attempts==0) {
                return;
            }
            pos2 = world.nearbyArea(location, 1);
            attempts--;
        } while(!world.isEmpty(pos2) && world.findOrganism(pos2).getStrength()>this.strength);
        move(pos2);
    }

}
