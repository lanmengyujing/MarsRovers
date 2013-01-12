package MarsRover;

import parser.PlateauParser;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoversGame {
    RoverManager manager = new RoverManager();
    RoverBust bust = new RoverBust();
    BufferedReader bf;

    public MarsRoversGame(){
        InputStreamReader input = new InputStreamReader(System.in);
        bf = new BufferedReader(input);
    }

    public MarsRoversGame(String string){
        bf = new BufferedReader(new StringReader(string));
    }

    public static void main(String[] args) {
        MarsRoversGame marsRoversGame = new MarsRoversGame();
        marsRoversGame.startGame();
    }

    public void init() {
        manager = new RoverManager();
        bust = new RoverBust();
        String plateauArea = null;
        try{
            plateauArea = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initPlateau(plateauArea);
    }

    public void initPlateau(String area) {
        PlateauParser parser = new PlateauParser();
        if (parser.parse(area)) {
            Plateau.getInstance().setUpperX(parser.getUpperX());
            Plateau.getInstance().setUpperY(parser.getUpperY());
        }
    }

    public void startGame() {
        init();

        int id = 0;
        try {
            String strPos = bf.readLine();
            while (strPos != null) {
                id++;
                Rover rover = new Rover(Integer.toString(id));
                placeRover(rover, strPos);

                String strCommand = bf.readLine();
                initRoverCommand(rover, strCommand );

                bust.runRover(rover);
                System.out.println(rover.toString());

                strPos = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void placeRover(Rover rover, String string) {
        manager.initPositionAndOrientation(rover, string);
        if (bust.getRovers() != null){
            bust.checkCrash(rover);
        }
        bust.addRover(rover);
    }

    public void initRoverCommand(Rover rover, String string) {
        manager.initCommand(rover, string);
    }
}

