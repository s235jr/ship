public class Cord {
    public int x;
    public int y;

    public String toString() {
        String cord = "[" + this.x + "," + this.y + "]";
        return cord;
    }

    Cord(String inputCord) {
        this.x = inputCord.charAt(0) - '1';
        this.y = inputCord.charAt(1) - 'A';
        //System.out.println("this.x: " + this.x);
        //System.out.println("this.y: " + this.y);
    }
}
