package pl.dawidmartenczuk.world.animals;

import pl.dawidmartenczuk.world.Animal;
import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.World;
import pl.dawidmartenczuk.world.Position;

public class Human extends Animal {

    private int specialAbility;

    public Human(Position pos, World world) {
        super(pos, world);
        name = "Human";
        shortcut = "H";
        this.specialAbility = 5;
        this.initiative = 4;
        this.strength = 5;
    }

    public void action(Position delta)
    {
        specialAbility++;
        if(delta.isEqual(new Position(0, 0))) {
            if(specialAbility >= 5) {
                specialAbility = -5;
                shortcut = "[H]";
            }
        }
        if(specialAbility == 0) {
            shortcut = "H";
        }
        move(new Position(location.x+delta.x,location.y+delta.y));
    }

    @Override
    public boolean checkCollision(Organism other)
    {
        if(specialAbility < 0)
        {
            other.movePermission=false;
            this.movePermission=false;
            return false;
        }
        return true;
    }
}
