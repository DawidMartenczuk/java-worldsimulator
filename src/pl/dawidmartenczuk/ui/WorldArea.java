package pl.dawidmartenczuk.ui;

import pl.dawidmartenczuk.Simulator;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class WorldArea extends JPanel {

    private JLabel text;

    public WorldArea(int x, int y, Simulator simulator)
    {
        ContextMenu contextMenu = new ContextMenu(x,y,simulator);
        addMouseListener(contextMenu);
        setBackground(Color.white);
        text=new JLabel();
        add(text);
    }

    public void clearField()
    {
        text.setText("");
        setBackground(Color.white);
    }

    public void setText(String newText)
    {
        text.setText(newText);
    }

    public void setColor(Color color)
    {
        setBackground(color);
    }

}
