package com.company.eventHandlers;

import com.company.graphics.Display;
import com.company.screeStates.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    public static boolean isRebel;
    public MouseInput(Display display) {
        display.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(StateManager.getCurrentState() instanceof MainMenuState) {
            //Play Button
            if(MainMenuState.playButton.getColiderBox().contains(mouseX, mouseY)){
                StateManager.setCurrentState(new ChooseSideState());
            }

            //High Scores Button
            if (MainMenuState.highScoreButton.getColiderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new HighScoresState());
            }

            //Quit Button
            if (MainMenuState.quitButton.getColiderBox().contains(mouseX, mouseY)) {
                System.exit(0);
            }
        }
        else if(StateManager.getCurrentState() instanceof ChooseSideState) {

            //Sith Button
            if (mouseX >= 50 && mouseX <= 350) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.empire.play();
                    isRebel = false;
                    StateManager.setCurrentState(new GameState());
                }
            }

            //Rebels Button
            if (mouseX >= 450 && mouseX <= 750) {
                if (mouseY >= 300 && mouseY <= 400) {
                    PlayMusic.rebels.loop();
                    isRebel = true;
                    StateManager.setCurrentState(new GameState());
                }
            }

            if(ChooseSideState.backButton.getColiderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        }

        // HighScores
        if(StateManager.getCurrentState() instanceof HighScoresState) {
            // Back Button
            if(HighScoresState.backButton.getColiderBox().contains(mouseX, mouseY)) {
                StateManager.setCurrentState(new MainMenuState());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}