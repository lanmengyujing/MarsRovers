package parser;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-9
 * Time: 上午9:25
 * To change this template use File | Settings | File Templates.
 */
public class PlaceParser implements parser {
    String regEx = "^\\s*\\d*+\\s+\\d*+\\s+[N|S|W|E]\\s*$";
    int posX;
    int posY;
    char orientation;

    @Override
    public void parse(String posAndOrientation) {
        posAndOrientation = posAndOrientation.toUpperCase();
        try {
            Match.matchCondition(regEx, posAndOrientation);
            String[] posAndOri = posAndOrientation.split(" ");
            posX = Integer.valueOf(posAndOri[0]);
            posY = Integer.valueOf(posAndOri[1]);
            orientation = posAndOri[2].charAt(0);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The input position or orientation for rover is not valid!");
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public char getOrientation() {
        return orientation;
    }
}
