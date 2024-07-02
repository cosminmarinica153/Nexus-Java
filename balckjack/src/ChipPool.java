import java.util.ArrayList;
import java.util.Iterator;

public class ChipPool {
    private ArrayList<Chip> chipPool;

    public ChipPool() {
        String[] colors = {"white", "red", "blue", "green", "orange", "black"};
        int[] values = {1, 5, 10, 25, 50, 100};

        chipPool = new ArrayList<>();

        for(int x = 0; x < 50; x++) {
            for(int i = 0; i < colors.length; i++) {
                if (x >= 25) {
                    if (colors[i].equals("white") || colors[i].equals("red") || colors[i].equals("blue")) {
                        chipPool.add(new Chip(colors[i], values[i]));
                    }
                } else {
                    chipPool.add(new Chip(colors[i], values[i]));
                }
            }
        }
    }

    public Chip[] startChips(){
        ArrayList<Chip> buyIn = new ArrayList<>();

        // 10 white, 6 red, 6 blue, 4 green, 2 orange, 1 black => 27 chips, value 400$
        int[] count = {10, 6, 6, 4, 2, 1};

        Iterator<Chip> iterator = chipPool.iterator();
        while (iterator.hasNext()) {
            Chip chip = iterator.next();

            if (chip.getColor().equals("white") && count[0] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[0]--;
            } else if (chip.getColor().equals("red") && count[1] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[1]--;
            } else if (chip.getColor().equals("blue") && count[2] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[2]--;
            } else if (chip.getColor().equals("green") && count[3] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[3]--;
            } else if (chip.getColor().equals("orange") && count[4] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[4]--;
            } else if (chip.getColor().equals("black") && count[5] > 0) {
                buyIn.add(chip);
                iterator.remove();
                count[5]--;
            }

            // Check if all counts are zero to exit early
            boolean exit = true;
            for (int c : count) {
                if (c > 0) {
                    exit = false;
                    break;
                }
            }

            if (exit) break;
        }

        return buyIn.toArray(new Chip[0]);
    }

    // something does not work here, it runs indefinitely
    public Chip[] buyChips(int amount){
        ArrayList<Chip> chips = new ArrayList<>();

        Chip chip;
        while (amount > 0){
            chip = new Chip("black", 100);
            if(amount > 100 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 100;
                continue;
            }
            chip = new Chip("orange", 50);
            if(amount > 50 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 50;
                continue;
            }
            chip = new Chip("green", 25);
            if(amount > 25 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 25;
                continue;
            }
            chip = new Chip("blue", 10);
            if(amount > 10 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 10;
                continue;
            }
            chip = new Chip("red", 5);
            if(amount > 5 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 5;
                continue;
            }
            chip = new Chip("white", 1);
            if(amount > 1 && chipPool.contains(chip)){
                chips.add(chip);
                chipPool.remove(chip);
                amount -= 1;
            }
        }

        return chips.toArray(new Chip[0]);
    }

    public int cashIn(Chip[] chips){
        int value = 0;

        for(Chip chip: chips){
            value += chip.getValue();
            chipPool.add(chip);
        }

        return value;
    }
}
