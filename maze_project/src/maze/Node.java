package maze;

class Node{
    private Node upNext;
    private Node downNext;
    private Node rightNext;
    private Node leftNext;

    private boolean upWall;
    private boolean downWall;
    private boolean rightWall;
    private boolean leftWall;

    private boolean path;

    public Node() {
        this.downNext = null;
        this.leftNext = null;
        this.upNext = null;
        this.rightNext = null;
        this.upWall = true;
        this.downWall = true;
        this.rightWall = true;
        this.leftWall = true;
        this.path = false;
    }

    public Node getUpNext() {
        return upNext;
    }

    public void setUpNext(Node upNext) {
        this.upNext = upNext;
    }

    public Node getDownNext() {
        return downNext;
    }

    public void setDownNext(Node downNext) {
        this.downNext = downNext;
    }

    public Node getRightNext() {
        return rightNext;
    }

    public void setRightNext(Node rightNext) {
        this.rightNext = rightNext;
    }

    public Node getLeftNext() {
        return leftNext;
    }

    public void setLeftNext(Node leftNext) {
        this.leftNext = leftNext;
    }

    public boolean isUpWall() {
        return upWall;
    }

    public void setUpWall(boolean upWall) {
        this.upWall = upWall;
    }

    public boolean isDownWall() {
        return downWall;
    }

    public void setDownWall(boolean downWall) {
        this.downWall = downWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public boolean isPath() {
        return path;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Node{" +
                "upWall=" + upWall +
                ", downWall=" + downWall +
                ", rightWall=" + rightWall +
                ", leftWall=" + leftWall +
                '}';
    }
}