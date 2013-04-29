package Game;

import Initialization.InitCommand;
import Initialization.InstructionInitialization;
import Initialization.PlaceInitialization;
import Initialization.PlateauInitialization;
import exception.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class MarsRoverGame {
    private Client client;
    private RoverBust bust = new RoverBust();
    private BufferedReader bf;

    public MarsRoverGame(){
        InputStreamReader input = new InputStreamReader(System.in);
        bf = new BufferedReader(input);
    }

    public MarsRoverGame(String string){
        bf = new BufferedReader(new StringReader(string));
    }

    public void init() {
        client = new Client();
        String strInit = readLine();
        setPlateau(strInit);
        client.setPlateau(strInit);
    }

    public void startGame(){
        Rover rover = new Rover();

        String placeCommand = readLine();
        client.setRoverPlace(placeCommand, rover);
        bust.addRover(rover);

        String strCommand = readLine();
        client.setRoverInstruction(strCommand, rover);

        bust.runRover(rover);
        System.out.println(rover.toString());
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

        private InitCommand initCommand;

        public void setInitCommand(InitCommand initCommand) {
            this.initCommand = initCommand;
        }

        public void setPlateau(String area) {
            InitCommand initCommand = new PlateauInitialization(area);
            setInstruction(initCommand);
        }

        public void setRoverPlace(String placeStr, Rover rover) {
            InitCommand initCommand = new PlaceInitialization(placeStr, rover);
            setInstruction(initCommand);
        }

        public void setRoverInstruction(String instruction, Rover rover) {
            InitCommand initCommand = new InstructionInitialization(instruction, rover);
            setInstruction(initCommand);
        }

        private void setInstruction(InitCommand initCommand) {
            setInitCommand(initCommand);
            initialize();
        }

        private void initialize() {
            try {
                initCommand.configure();
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }


    public static void main(String[] args) {
        MarsRoverGame marsRoverGame = new MarsRoverGame();
        marsRoverGame.init();
        while(true){
            marsRoverGame.startGame();
        }
    }

    public static class Client {
        private InitCommand initCommand;

        public void setInitCommand(InitCommand initCommand) {
            this.initCommand = initCommand;
        }

        public void setPlateau(String area) {
            InitCommand initCommand = new PlateauInitialization(area);
            setInstruction(initCommand);
        }

        public void setRoverPlace(String placeStr, Rover rover) {
            InitCommand initCommand = new PlaceInitialization(placeStr, rover);
            setInstruction(initCommand);
        }

        public void setRoverInstruction(String instruction, Rover rover) {
            InitCommand initCommand = new InstructionInitialization(instruction, rover);
            setInstruction(initCommand);
        }

        private void setInstruction(InitCommand initCommand) {
            setInitCommand(initCommand);
            initialize();
        }

        private void initialize() {
            try {
                initCommand.configure();
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
