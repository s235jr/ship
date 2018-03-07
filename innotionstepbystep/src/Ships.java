class Main {
    public static void main(String args[]) {
        String inputshipsCord = "1B 4B,1C 3C,3C 4C";
        String shots = "1B 2B 3B 4B 2C 2D 3D 4D 4A";
        int mapSize = 4;
        int sunk = 0;
        int unsunk = 0;


        String[] cordShips = inputshipsCord.split(",");
        for (int i = 0; i < cordShips.length; i++) {
            String[] cordShip = cordShips[i].split(" ");
            //BattleShip leftTop = cordShip[0];
            //BattleShip rightBottom = cordShip[1];
            String firstCord = cordShip[0];
            String secondCord = cordShip[1];

            Cord left_up_corner = new Cord(firstCord);
            System.out.println("Pierwszy róg " + firstCord + ": " + left_up_corner);

            Cord right_down_corner = new Cord(secondCord);
            System.out.println("Drugi róg " + secondCord+ ": " + right_down_corner);

            int[][] shipCord = shipCordonMap(mapSize, left_up_corner, right_down_corner);
            System.out.print('\n' + "Mapa statku: " + '\n' + '\n');
            printarray(shipCord);

            int[][] mapofShots = generatemapaftershot(mapSize, shots);
            System.out.print('\n' + "Mapa strzałów: " + '\n' + '\n');
            printarray(mapofShots);

            int[][] mapafterfight = generatemapafterfight(shipCord, mapofShots);
            System.out.print('\n' + "Mapa po walce: " + '\n' + '\n');
            printarray(mapafterfight);

            if (result(mapafterfight)) {
                System.out.println('\n' + "Statek zatopiony");
                System.out.println("- - - - - - - - - - - - - - ");
                sunk = sunk + 1;

            } else {
                System.out.println('\n' + "Statek niezatopiony");
                System.out.println("- - - - - - - - - - - - - - ");
                unsunk = unsunk + 1;
            }
        }
        System.out.println("Liczna zatopionych statków: " + sunk);
        System.out.println("Liczba niezatopionych statków: " + unsunk);
    }

    static int[][] shipCordonMap(int MapSize, Cord firstCorner, Cord secondCorner) {
        int[][] arrayofShiponMap = new int[MapSize][MapSize];
        for (int i = Math.min(firstCorner.x, secondCorner.x); i <= Math.max(firstCorner.x, secondCorner.x); i++) {
            for (int k = Math.min(secondCorner.y, firstCorner.y); k <= Math.max(secondCorner.y, firstCorner.y); k++) {
                arrayofShiponMap[i][k] = 1;
            }
        }
        return arrayofShiponMap;
    }

    static int[][] generateEmptyMap(int MapSize) {
        int[][] Map = new int[MapSize][MapSize];
        for (int i = 0; i < MapSize; i++) {
            for (int k = 0; k < MapSize; k++) {
                Map[i][k] = 0;
            }
        }
        return Map;
    }

    static int[][] generatemapaftershot(int MapSize, String shots) {
        int[][] mapofShots = generateEmptyMap(MapSize);
        String[] arrayshots = shots.split(" ");
        for (int i = 0; i < arrayshots.length; i++) {
            String stringshot = arrayshots[i];
            Cord shot = new Cord(stringshot);
            mapofShots[shot.x][shot.y] = 1;
        }
        return mapofShots;

    }

    static int[][] generatemapafterfight(int[][] shipCord, int[][] mapofShots) {
        int[][] MapAfterFigth = new int[mapofShots.length][mapofShots.length];
        for (int i = 0; i < mapofShots.length; i++) {
            for (int k = 0; k < mapofShots.length; k++) {
                if (shipCord[i][k] == 1) {
                    MapAfterFigth[i][k] = shipCord[i][k] - mapofShots[i][k];
                }
            }
        }
        return MapAfterFigth;
    }

    static boolean result(int[][] mapafterfigth) {
        for (int i = 0; i < mapafterfigth.length; i++) {
            for (int k = 0; k < mapafterfigth.length; k++) {
                if (mapafterfigth[i][k] == 1)
                    return false;
            }
        }
        return true;
    }

    static void printarray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[i][k] + " ");
            }
            System.out.println();
        }
    }
}