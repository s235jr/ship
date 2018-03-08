public class Map {
    int mapSize;
    int[][] fields;
    String shots;


    Map(int inputMapSize) {
        this.mapSize = inputMapSize;
        int[][] fields = new int[this.mapSize][this.mapSize];
        for (int i = 0; i < this.mapSize; i++) {
            for (int k = 0; k < this.mapSize; k++) {
                this.fields[i][k] = 0;
            }
        }
    }

    public void shipCordOnMap(Cord first, Cord second) {
        for (int i = Math.min(first.x, second.x); i <= Math.max(first.x, second.x); i++) {
            for (int k = Math.min(first.y, second.y); k <= Math.max(first.y, second.y); k++) {
                this.fields[i][k] = 1;
            }
        }
    }

    public void generateMapAfterShots(String shots) {
        String[] arrayshots = shots.split(" ");
        for (int i = 0; i < arrayshots.length; i++) {
            String stringshot = arrayshots[i];
            Cord shot = new Cord(stringshot);
            this.fields[shot.x][shot.y]--;
        }

    }
}
