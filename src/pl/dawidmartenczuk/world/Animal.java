package pl.dawidmartenczuk.world;

public class Animal extends Organism{

    public Animal(Position pos, World world) {
        super(pos, world);
    }

    @Override
    public void action()
    {
        this.movePermission=true;
        move(world.nearbyArea(location,1));
    }

    @Override
    protected void multiply()
    {
        Position newLocation = world.freeNearbyArea(this.location, 1);
        if(location.isEqual(this.location)) {
            return;
        }
        else {
            world.addOrganism(newLocation, this.getName());
        }
    }

    public void move(Position pos2)
    {
        if(pos2.isEqual(location)) {
            return;
        }
        if(!world.isInWorld(pos2)) {
            return;
        }
        if(world.isEmpty(pos2))
        {
            location=pos2;
            return;
        }
        Organism enemy = world.findOrganism(pos2);

        if(!enemy.isKilled()) {
            collision(this, enemy);
        }

        if(!this.killed && this.movePermission) {
            location=pos2;
        }
    }
}

