package pl.dawidmartenczuk;

import java.awt.EventQueue;

public class main {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Simulator(15,15);
            }
        });
    }
}
