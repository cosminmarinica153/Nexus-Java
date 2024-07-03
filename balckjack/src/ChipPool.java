import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class ChipPool {
    private ArrayList<Chip> chipPool;

    public ChipPool() {
        String[] colors = {"white", "red", "blue", "green", "orange", "black"};
        int[] values = {1, 5, 10, 25, 50, 100};

        chipPool = new ArrayList<>();

        for (int x = 0; x < 50; x++) {
            for (int i = 0; i < colors.length; i++) {
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

    public Chip[] startChips() {
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

    // I fixed it by adding a chip color verification in the if statements
    public Chip[] buyChips(int amount) {
        ArrayList<Chip> chipsCopy = chipPool;
        ArrayList<Chip> chips = new ArrayList<>();

        Collections.sort(chipsCopy, (chip1, chip2) -> Integer.compare(chip2.getValue(), chip1.getValue()));

        Iterator<Chip> iterator = chipsCopy.iterator();
        while (iterator.hasNext() & amount > 0) {

            Chip chip = iterator.next();
            if (amount >= 100 && chip.getColor().equals("black")) {
                chips.add(chip);
                iterator.remove();
                chip = iterator.next();
                amount -= 100;
            }
            if (amount >= 50 && chip.getColor().equals("orange")) {
                chips.add(chip);
                iterator.remove();
                chip = iterator.next();
                amount -= 50;
            }
            if (amount >= 25 && chip.getColor().equals("green")) {
                chips.add(chip);
                iterator.remove();
                chip = iterator.next();
                amount -= 25;
            }
            if (amount >= 10 && chip.getColor().equals("blue")) {
                chips.add(chip);
                iterator.remove();
                chip = iterator.next();
                amount -= 10;
            }
            if (amount >= 5 && chip.getColor().equals("red")) {
                chips.add(chip);
                iterator.remove();
                chip = iterator.next();
                amount -= 5;
            }
            if (amount >= 1 && chip.getColor().equals("white")) {
                chips.add(chip);
                iterator.remove();
                amount -= 1;
            }

            if(amount == 0) break;
        }

        return chips.toArray(new Chip[0]);
    }

    public int cashIn(Chip[] chips) {
        int value = 0;

        for (Chip chip : chips) {
            value += chip.getValue();
            chipPool.add(chip);
        }

        return value;
    }
}
