package pl.dawidmartenczuk;

import pl.dawidmartenczuk.ui.Window;

import pl.dawidmartenczuk.world.Plant;
import pl.dawidmartenczuk.world.World;
import pl.dawidmartenczuk.world.Position;

import pl.dawidmartenczuk.world.Organism;
import pl.dawidmartenczuk.world.animals.Human;

import pl.dawidmartenczuk.exceptions.InvalidSizeException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator extends World {

    private Human player;

    public Simulator(int x, int y)
    {
        super(x,y);
        initWindow(x, y);
        generateWorld();
    }

    public void initWindow(int x, int y) {
        if(window != null) {
            window.close();
        }
        window = new Window(x, y, this);
        render();
    }

    private void generateWorld()
    {
        player = (Human)this.addOrganism(new Position(0,0), "Human");
    }

    public void save() throws FileNotFoundException
    {
        PrintWriter fio = new PrintWriter("level.txt");
        fio.println(size.x + " " + size.y);
        for(ArrayList <Organism> initiative : organisms)
        {
            fio.print(initiative.size()+String.format("%n"));
            for(Organism actual : initiative)
            {
                fio.print(actual.getName()+" "+actual.getLocation().x+" "+actual.getLocation().y+" "+actual.getAge()+" "+actual.getStrength()+String.format("%n"));
            }
        }
        fio.close();
    }

    public void load() throws InvalidSizeException
    {
        for(ArrayList list : organisms)
        {
            list.clear();
        }
        File fio = new File("level.txt");
        Scanner scanner;
        try
        {
            scanner = new Scanner(fio);
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Cannot load file");
            return;
        }

        size = new Position(scanner.nextInt(), scanner.nextInt());
        initWindow(size.x, size.y);

        for(int i=0;i<10;i++)
        {
            int count = scanner.nextInt();
            for(int j=0;j<count;j++)
            {
                String name=scanner.next();
                Position pos = new Position(scanner.nextInt(), scanner.nextInt());
                Organism newOrg = this.addOrganism(pos, name);
                newOrg.setAge(scanner.nextInt());
                if(newOrg.getName()!="Human") {
                } else {
                    this.player =(Human) newOrg;
                }
                newOrg.setStrength(scanner.nextInt());
                if(pos.x>=size.x || pos.y>=size.y)
                {
                    throw new InvalidSizeException();
                }
            }
        }
        this.render();
    }

    public void executeTurn(Position humanMove)//0,0 means special ability
    {
        for(int i=organisms.size()-1;i>=0;i--)
        {
            for(int j=0;j<organisms.get(i).size();j++)
            {
                Organism actual = organisms.get(i).get(j);
                if(actual.isKilled())continue;
                if("Human".equals(actual.getName()))
                {
                    player.action(humanMove);
                    player.setAge(player.getAge()+1);
                    continue;
                }
                actual.action();
                actual.setAge(actual.getAge()+1);
            }
        }
        killAll();
        render();
    }

    public void render()
    {
        window.clear();
        organisms.stream().forEach((organism) -> {
            organism.stream().forEach((actual) -> {
                if(isInWorld(actual.getLocation())) {
                    window.fill(actual.getShortcut(), (actual instanceof Plant ? Color.green : (actual instanceof Human ? Color.orange : Color.lightGray)), actual.getLocation().x, actual.getLocation().y);
                }
            });
        });
    }

    private void killAll()
    {
        for(int i=0;i<organisms.size();i++)
        {
            for(int j=0;j<organisms.get(i).size();j++)
            {
                Organism actual = organisms.get(i).get(j);
                if(actual.isKilled())
                {
                    organisms.get(i).remove(j);
                }
            }
        }
    }

}
