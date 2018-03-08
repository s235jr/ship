public class Map {
    int[][] fields;

    Map(int mapSize) {
        this.fields = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int k = 0; k < mapSize; k++) {
                this.fields[i][k] = 0;
            }
        }
    }

    public void markShip(Cord first, Cord second) {
        for (int i = Math.min(first.x, second.x); i <= Math.max(first.x, second.x); i++) {
            for (int k = Math.min(first.y, second.y); k <= Math.max(first.y, second.y); k++) {
                this.fields[i][k] = 1;
            }
        }
    }

    public void markShots(String shots) {
        String[] arrayshots = shots.split(" ");
        for (int i = 0; i < arrayshots.length; i++) {
            String stringshot = arrayshots[i];
            Cord shot = new Cord(stringshot);
            if (this.fields[shot.x][shot.y] == 1) {
                this.fields[shot.x][shot.y]--;
            }
        }
//        System.out.println('\n' + "Mapa statku po walce: " + '\n');
//        System.out.println(mapToString());
    }

    boolean isShipDestroyed() {
        for (int i = 0; i < this.fields.length; i++) {
            for (int k = 0; k < this.fields.length; k++) {
                if (this.fields[i][k] == 1)
                    return false;
            }
        }
        return true;
    }

    public String mapToString() {
        String mapInString = "";
        for (int i = 0; i < this.fields.length; i++) {
            for (int k = 0; k < this.fields.length; k++) {
                mapInString += Integer.toString(this.fields[i][k]);
            }
            mapInString = mapInString + '\n';
        }
        return mapInString;
    }
}