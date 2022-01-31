package maze;


import javax.lang.model.element.UnknownAnnotationValueException;
import java.sql.SQLOutput;
import java.util.*;

public class Labyrinth {
    private int height = 0;
    private int width = 0;
    private Difficulty difficulty;
    private Node baseNode = null;
    private Node outNote = null;
    private Node[][] nodesToString;
    public enum Difficulty {
        HARD,
        MEDIUM,
        EASY
    }
    public enum Algorithm {
        RANDOMIZED_DEPTH__FIRST,
        OTHER_ALG;
        private Deque<Node> stack = new ArrayDeque<>();
        private void generate(Labyrinth labyrinth){
            Node node = labyrinth.baseNode;

        }

    }

    /**
     * Constructor to make the Labyrint with given height and width. Difficulty is being set according to size.
     * @param width
     * @param height
     */
    public Labyrinth(int width, int height){
        if(width<10 || height<10){
            throw new WrongSizeException("Too small size of the Labyrint",width,height);
        }
        this.height = height;
        this.width = width;
        int size = width*height;
        if(size>100){
            difficulty = Difficulty.HARD;
        }
        else if(size>50){
            difficulty = Difficulty.MEDIUM;
        }
        else{
            difficulty = Difficulty.EASY;
        }
        generateGrid();
    }


    /**
     * Constructor to make the Labyrint with given difficulty. Size is being set according to difficulty.
     * @param difficulty
     */
    public Labyrinth(Difficulty difficulty){
        switch (difficulty){
            case HARD ->{
                height=100;
                width=100;
            }
            case MEDIUM -> {
                height = 50;
                width = 50;
            }
            case EASY -> {
                height = 30;
                width = 30;
            }
        }
        generateGrid();
    }
    private Node[][]  generateGrid(){
        if(height<10 || width<10){
            throw new WrongSizeException("Too small size of the Labyrint",width,height);
        }
        baseNode = new Node();
        Node node = baseNode;
        Node[][] Nodes = new Node[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(i == 0 && j == 0) Nodes[i][j] = node;
                else Nodes[i][j] = new Node();
            }
        }
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(i == 0){
                    if(j == 0){
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                    }
                    else{
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                }
                else if(i == (width - 1)){
                    if(j == 0){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                    }
                    else{
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                    }
                }
                else{
                    if(j == 0){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                    else if(j == (height - 1)){
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                    else{
                        Nodes[i][j].setLeftNext(Nodes[i-1][j]);
                        Nodes[i][j].setUpNext(Nodes[i][j-1]);
                        Nodes[i][j].setDownNext(Nodes[i][j+1]);
                        Nodes[i][j].setRightNext(Nodes[i+1][j]);
                    }
                }
            }
        }
        //Nodes[7][8].setDownWall(false);
        return nodesToString = Nodes;
    }

    @Override
    public String toString() {
        for(int i = 0; i < width + 2; i++){
            System.out.print("# ");
        }
        System.out.print("\n");
        for(Node rows[]:nodesToString){
            System.out.print("# ");
            for(Node wall: rows){
                int x;
                if(!wall.isDownWall() || !wall.isLeftWall() || !wall.isUpWall() || !wall.isRightWall()) x = 1;
                else x = 0;
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.print("#");
            System.out.print("\n");
        }
        for(int i = 0; i < width + 2; i++){
            System.out.print("# ");
        }
        return "";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Node getBaseNode() {
        return baseNode;
    }
    public Node getOutNote() {
        return outNote;
    }
    public void generate(Algorithm algorithm){
        switch (algorithm){
            case RANDOMIZED_DEPTH__FIRST -> rdf_alg();
            case OTHER_ALG -> rdf_alg();
        }
    }
    // Raczej idziemy w strone klasy zagniezdzonej generator z wlasnym stackiem i wywolaniem rekurencyjnym algorytmu
    private void rdf_alg() {
    }


    public static void main(String[] args) {
        Labyrinth L1 = new Labyrinth(10, 10);
        Labyrinth L2 = new Labyrinth(Difficulty.EASY);
        System.out.println(L2.getHeight());
        System.out.println(L1);
    }
}
