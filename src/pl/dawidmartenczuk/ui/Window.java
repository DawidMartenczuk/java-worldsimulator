package pl.dawidmartenczuk.ui;


import pl.dawidmartenczuk.Simulator;
import pl.dawidmartenczuk.ui.listeners.WindowKey;
import pl.dawidmartenczuk.world.animals.Human;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Window extends JFrame {

    private Simulator simulator;
    private Human player;

    public Simulator getApplication()
    {
        return simulator;
    }

    public Human getPlayer()
    {
        return player;
    }

    private final WorldSpace floor;

    public Window(int x, int y, Simulator simulator)
    {
        super("165408 Dawid Martenczuk - Symulator wirtualnego swiata");
        this.simulator=simulator;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000, 1000);
        setLayout(new FlowLayout());
        WindowKey escExit = new WindowKey();
        addKeyListener(escExit);
        floor = new WorldSpace(x, y, simulator);
        add(floor);
        floor.setBackground(new Color(0, 102, 0));
        floor.setLocation(0, 0);
        floor.setPreferredSize(new Dimension(1000 - x,1000 - (y * 2)));
        setVisible(true);
    }

    public void close() {
        setVisible(false);
        dispose();
    }

    public void fill(String text, Color color, int x, int y)
    {
        floor.fill(text, color, x, y);
    }

    public void clear()
    {
        floor.clear();
    }
}
