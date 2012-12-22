
public class Plateau {
    private int upperX;
    private int upperY;
    private static int lowerX = 0;
    private static int lowerY = 0;
    static Plateau plateau;

    private Plateau() {
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau();
        }
        return plateau;
    }

    public void setUpperX(int upperX){
        this.upperX = upperX;
    }

    public int getUpperX(){
        return upperX;
    }

    public void setUpperY(int upperY){
        this.upperY = upperY;
    }

    public int getUpperY(){
        return upperY;
    }

    public void setLowerX(int lowerX){
        this.lowerX = lowerX;
    }
    public int getLowerX(){
        return lowerX;
    }

    public void setLowerY(int lowerY){
        this.lowerY = lowerY;
    }
    public int getLowerY(){
        return lowerY;
    }

    public boolean isInRange(int x,int y){
        if (x < lowerX || x > upperX || y < lowerY || y > upperY){
            return false ;
        }else{
            return true;
        }
    }
}
