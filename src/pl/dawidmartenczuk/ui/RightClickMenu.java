package pl.dawidmartenczuk.ui;

import pl.dawidmartenczuk.ui.listeners.CreateOrganism;
import pl.dawidmartenczuk.Simulator;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClickMenu extends JPopupMenu{

    public int menuLength;

    JMenuItem[] menuItems;

    public RightClickMenu(int x, int y, Simulator simulator)
    {
        this.menuLength = 9;

        menuItems = new JMenuItem[menuLength];
        menuItems[0] = new JMenuItem("[A] Antelope");
        menuItems[1] = new JMenuItem("[A] Fox");
        menuItems[2] = new JMenuItem("[A] Sheep");
        menuItems[3] = new JMenuItem("[A] Turtle");
        menuItems[4] = new JMenuItem("[A] Wolf");
        menuItems[5] = new JMenuItem("[P] Belladonna");
        menuItems[6] = new JMenuItem("[P] Grass");
        menuItems[7] = new JMenuItem("[P] Guarana");
        menuItems[8] = new JMenuItem("[P] Sow Thistle");
        for(int i=0;i<menuLength;i++)
        {
            add(menuItems[i]);
            menuItems[i].addActionListener(new CreateOrganism(x,y,simulator,menuItems[i].getText()));
        }
    }
}