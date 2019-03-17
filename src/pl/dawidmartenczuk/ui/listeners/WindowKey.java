package pl.dawidmartenczuk.ui.listeners;

import pl.dawidmartenczuk.world.Position;
import pl.dawidmartenczuk.ui.Window;

import pl.dawidmartenczuk.exceptions.InvalidSizeException;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowKey implements KeyListener{
    @Override
    public void keyPressed(KeyEvent event)
    {
        Window father=(Window)event.getSource();
        switch (event.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
                father.dispose();
                return;

            case KeyEvent.VK_UP:
                father.getApplication().executeTurn(new Position(0,-1));
                break;

            case KeyEvent.VK_DOWN:
                father.getApplication().executeTurn(new Position(0,1));
                break;

            case KeyEvent.VK_LEFT:
                father.getApplication().executeTurn(new Position(-1,0));
                break;

            case KeyEvent.VK_RIGHT:
                father.getApplication().executeTurn(new Position(1,0));
                break;

            case KeyEvent.VK_SPACE:
                father.getApplication().executeTurn(new Position(0,0));//special ability
                break;

            case KeyEvent.VK_S:
            {
                try {
                    father.getApplication().save();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(WindowKey.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case KeyEvent.VK_L:
            {
                try {
                    father.getApplication().load();
                } catch (InvalidSizeException ex) {
                    Logger.getLogger(WindowKey.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case KeyEvent.VK_PAGE_UP:
            {
                father.getApplication().size.x++;
                father.getApplication().size.y++;
                father.getApplication().initWindow(father.getApplication().size.x, father.getApplication().size.y);
            }
            break;

            case KeyEvent.VK_PAGE_DOWN:
            {
                father.getApplication().size.x--;
                father.getApplication().size.y--;
                father.getApplication().initWindow(father.getApplication().size.x, father.getApplication().size.y);
            }
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event)
    {

    }

    @Override
    public void keyTyped(KeyEvent event)
    {

    }
}

