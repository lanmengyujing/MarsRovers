package parser;

public class PlateauParser implements parser {
    private String regEx = "^(\\d*)\\s(\\d*)\\s*$";
    private int upperX;
    private int upperY;

    @Override
    public void parse(String area) {
        try {
            Match.matchCondition(regEx, area);
            String[] inputArea = area.split(" ");
            upperX = Integer.valueOf(inputArea[0]);
            upperY = Integer.valueOf(inputArea[1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The input area for Plateau is not valid");
        }
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }
}
