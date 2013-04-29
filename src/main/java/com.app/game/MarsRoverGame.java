package com.app.game;

import com.app.initialization.InitCommand;
import com.app.initialization.InstructionInitialization;
import com.app.initialization.PlaceInitialization;
import com.app.initialization.PlateauInitialization;
import com.app.exception.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class MarsRoverGame {
    private RoverBust bust = new RoverBust();
    private BufferedReader bf;
    private InitCommand initCommand;

    public MarsRoverGame() {
        InputStreamReader input = new InputStreamReader(System.in);
        bf = new BufferedReader(input);
    }

    public MarsRoverGame(String string) {
        bf = new BufferedReader(new StringReader(string));
    }

    public void init() {
        while (true) {
            String strInit = readLine();
            try {
                setPlateau(strInit);
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startGame() {
        Rover rover = new Rover();
        while (true) {
            String placeCommand = readLine();
            try {
                setRoverPlace(placeCommand, rover);
                bust.addRover(rover);
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            String strCommand = readLine();
            try {
                setRoverInstruction(strCommand, rover);
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("rover begin to move");
        bust.runRover(rover);
        System.out.println("the final place of rover is:"+  rover.toString());
    }


    private String readLine() {
        String str = null;
        try {
            str = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void setPlateau(String area) throws GameException {
        InitCommand initCommand = new PlateauInitialization(area);
        setInstruction(initCommand);
    }

    public void setRoverPlace(String placeStr, Rover rover) throws GameException {
        InitCommand initCommand = new PlaceInitialization(placeStr, rover);
        setInstruction(initCommand);
    }

    public void setRoverInstruction(String instruction, Rover rover) throws GameException {
        InitCommand initCommand = new InstructionInitialization(instruction, rover);
        setInstruction(initCommand);
    }

    private void setInstruction(InitCommand initCommand) throws GameException {
        this.initCommand = initCommand;
        initCommand.configure();
    }


}
