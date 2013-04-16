package Game;

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

    public static void main(String[] args) {
        MarsRoverGame marsRoverGame = new MarsRoverGame();
        marsRoverGame.init();
        while(true){
            marsRoverGame.startGame();
        }
    }

    public void init() {
        client = new Client();
        String strInit = readLine();
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
}
