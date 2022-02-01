package maze;

import java.util.*;

public class Solver {
    private Deque<Node> stack;
    private Deque<Node> lane = new ArrayDeque<>();
    private Labyrinth lab;
    private Node node;
    private Node node_out;
    private Node nextNode;
    private Random random = new Random();
    private int x;

    private List<Generator.Directions> dir = Arrays.asList(Generator.Directions.values());

    public Solver(Deque stack){
        this.stack = stack;
    }
    public Solver(Labyrinth lab){
        this.lab = lab;
        this.node = lab.getBaseNode();
        this.node_out = lab.getOutNote();
    }

    public void solve(){
        nextNode = node.getRightNext();
        int i = 0;
        while(true){
            if(i == 20000) break;
            if(nextNode == node_out) break;
            if(!node.isDownWall()){
                nextNode = node.getDownNext();
                nextNode.setPath(true);
                lane.add(nextNode);
                node = nextNode;
            }
            else if(!node.isRightWall()){
                nextNode = node.getRightNext();
                nextNode.setPath(true);
                lane.add(nextNode);
                node = nextNode;
            }
            else if(!node.isUpWall()){
                nextNode = node.getUpNext();
                nextNode.setPath(true);
                lane.add(nextNode);
                node = nextNode;
            }
            else{
             nextNode =  node.getLeftNext();
             node.setPath(false);
             lane.pop();
             node = nextNode;
            }
            i++;
        }
    }

    public Labyrinth getLab() {
        return lab;
    }

    public String toString_2(){
        for(Node[] nodes: lab.nodesToString){
            for(Node node: nodes){
                if(node.isPath()){
                    System.out.print("X");
                }
                else System.out.print("#");
            }
            System.out.println();
        }
        return "";
    }
    public String toString() {
        Node[][] nodesToString = lab.nodesToString;
        for(int h=0;h<5;h++){
            for(int w=0;w<5;w++){
                if(nodesToString[w][h].isUpWall()){
                    System.out.print("*---*");
                }else System.out.print("*   *");
            }
            System.out.print("\n");
            for(int w=0;w<5;w++){
                if(nodesToString[w][h].isRightWall() && nodesToString[w][h].isLeftWall()){
                    if(nodesToString[w][h]==lab.baseNode || nodesToString[w][h]==lab.outNote){
                        System.out.print("| X |");
                    }else {
                        if(nodesToString[w][h].isPath()) System.out.print("| o |");
                        else System.out.print("|   |");
                    }

                }
                else if(nodesToString[w][h].isRightWall()){
                    if(nodesToString[w][h]==lab.baseNode || nodesToString[w][h]==lab.outNote){
                        System.out.print("  X |");
                    }else {
                        if(nodesToString[w][h].isPath()) System.out.print("  o |");
                        else System.out.print("    |");
                    }

                }
                else if(nodesToString[w][h].isLeftWall()){
                    if(nodesToString[w][h]==lab.baseNode || nodesToString[w][h]==lab.outNote){
                        System.out.print("| X  ");
                    }else {
                        if(nodesToString[w][h].isPath()) System.out.print("| o  ");
                        else System.out.print("|    ");
                    }

                }
                else {
                    if(nodesToString[w][h]==lab.baseNode || nodesToString[w][h]==lab.outNote){
                        System.out.print("  X  ");
                    }else {
                        if(nodesToString[w][h].isPath()) System.out.print("  o  ");
                        else System.out.print("     ");
                    }
                }
            }
            System.out.print("\n");
            for(int w=0;w<5;w++){
                if(nodesToString[w][h].isDownWall()){
                    System.out.print("*---*");
                }
                else System.out.print("*   *");
            }
            System.out.print("\n");
        }
        return "";
    }
    public String toString_3(){
        while(true){
            if(lane.getFirst() == null) break;
            node = lane.pop();
            if(!node.isDownWall()) System.out.println("v");
            else if(!node.isRightWall()) System.out.println("->");
            else if(!node.isUpWall()) System.out.println("^");
            else System.out.println("<-");
        }
        return "";
    }
}
