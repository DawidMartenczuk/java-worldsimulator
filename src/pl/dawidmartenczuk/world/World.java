package pl.dawidmartenczuk.world;

import pl.dawidmartenczuk.ui.Window;
import pl.dawidmartenczuk.world.animals.*;
import pl.dawidmartenczuk.world.plants.*;

import java.util.ArrayList;
import java.util.Random;

public class World {

    public Position size;
    protected ArrayList <ArrayList <Organism>> organisms;
    protected Window window;

    public World(Position size) {
        this.size = size;
        organisms = new ArrayList <>();
        for(int i=0;i<10;i++)
        {
            organisms.add(new ArrayList <>());
        }
    }

    public World(int x, int y)
    {
        this(new Position(x,y));
    }

    public Organism addOrganism(Position pos, String name)
    {
        if(!isEmpty(pos)) {
            return null;
        }
        Organism newOrganism;
        switch (name)
        {
            case "Antelope":
                newOrganism = new Antelope(pos,this);
                break;
            case "Belladonna":
                newOrganism = new Belladonna(pos,this);
                break;
            case "Fox":
                newOrganism = new Fox(pos,this);
                break;
            case "Grass":
                newOrganism = new Grass(pos,this);
                break;
            case "Guarana":
                newOrganism = new Guarana(pos,this);
                break;
            case "Human":
                newOrganism = new Human(pos,this);
                break;
            case "Sheep":
                newOrganism = new Sheep(pos, this);
                break;
            case "Sow Thistle":
                newOrganism = new SowThistle(pos,this);
                break;
            case "SowThistle":
                newOrganism = new SowThistle(pos,this);
                break;
            case "Turtle":
                newOrganism = new Turtle(pos, this);
                break;
            case "Wolf":
                newOrganism = new Wolf(pos, this);
                break;

            default:
                return null;
        }

        organisms.get(newOrganism.getInitiative()).add(newOrganism);

        return newOrganism;
    }

    public boolean isInWorld(Position pos)
    {
        if(pos.x >= 0 && pos.x <size.x && pos.y >=0 && pos.y<size.y) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEmpty(Position pos)
    {
        if(!isInWorld(pos)) {
            return true;
        }
        for(ArrayList <Organism> organism : organisms)
        {
            for(Organism actual : organism)
            {
                if(actual.location.isEqual(pos)) {
                    return false;
                }
            };
        }
        return true;
    }

    public Position nearbyArea(Position pos, int range)
    {
        Random random = new Random();
        Position pos2 = new Position(pos.x+(random.nextInt(3)-1)*range,pos.y+(random.nextInt(3)-1)*range);
        while(!isInWorld(pos2) || pos2.equals(pos))
        {
            pos2 = new Position(pos.x+(random.nextInt(3)-1)*range,pos.y+(random.nextInt(3)-1)*range);
        }
        return pos2;
    }

    public Position freeNearbyArea(Position center, int range)
    {
        int attempts=50;
        Random rand = new Random();
        Position pos2 = new Position(center.x+(rand.nextInt(3)-1)*range,center.y+(rand.nextInt(3)-1)*range);
        while(!isInWorld(pos2) || pos2.equals(center) || !isEmpty(pos2))
        {
            if(attempts==0)return center;
            pos2 = new Position(center.x+(rand.nextInt(3)-1)*range,center.y+(rand.nextInt(3)-1)*range);
            attempts--;
        }
        return pos2;
    }

    public Organism findOrganism(Position pos)
    {
        for(ArrayList <Organism> organism : organisms)
        {
            for(Organism actual : organism)
            {
                if(actual.location.isEqual(pos))return actual;
            };
        }
        return null;
    }

}
