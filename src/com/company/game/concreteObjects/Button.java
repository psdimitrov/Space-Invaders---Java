package com.company.game.concreteObjects;

import com.company.game.AbstractObjects.GameObject;
import com.company.gameObjectsInterfaces.Displayable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button extends GameObject implements Displayable {
    public String name;

    public Button(int x, int y, BufferedImage gameObjectIcon, String name) {
        super(x, y, gameObjectIcon,1);
        this.name = name;
    }


    public void update() {
        this.getColiderBox().setBounds(this.getX(), this.getY(),
                this.getObjectIcon().getWidth(), this.getObjectIcon().getHeight());

    }
    @Override
    public void display(Graphics g) {
        g.drawImage(this.getObjectIcon(), this.getX(), this.getY(), null);
        g.drawString(name,this.getX()+ (int) this.getColiderBox().getWidth()/2 - g.getFontMetrics().stringWidth(name)/2 - 4,this.getY()+40);
    }
}
