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
            String firstCord = cordShip[0];
            String secondCord = cordShip[1];

            Cord left_up_corner = new Cord(firstCord);
            System.out.println("Pierwszy róg " + firstCord + ": " + left_up_corner.toString());

            Cord right_down_corner = new Cord(secondCord);
            System.out.println("Drugi róg " + secondCord + ": " + right_down_corner.toString());


            Map fields = new Map(mapSize);
            fields.markShip(left_up_corner, right_down_corner);
            //System.out.println('\n' + "Mapa statku: ");
            //fields.mapToString();
            fields.markShots(shots);
           // System.out.println('\n' + "Mapa po walce: ");
            //fields.mapToString();

            if (fields.isShipDestroyed()) {
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

    static void printMap(Map array) {
        for (int i = 0; i < array.fields.length; i++) {
            for (int k = 0; k < array.fields.length; k++) {
                System.out.print(array.fields[i][k] + " ");
            }
            System.out.println();
        }
    }


}

