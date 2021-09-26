import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CTCIPermutationsWithDups {
    public static void main(String[] args) {
        try {
            CTCIPermutationsWithDups obj = new CTCIPermutationsWithDups();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) {
        ArrayList<String> allPermutations = new ArrayList<>();
        allPermutations = findAllPermutations(new ArrayList<String>(),"lol",new ArrayList<String>(),"",-1);
        System.out.println(allPermutations);
    }

    public ArrayList<String> findAllPermutations(ArrayList<String> holdCombos, String startingWord, ArrayList<String> holdCharacters, String word, int index) {
        if (index != -1) {
            holdCharacters = new ArrayList<>(holdCharacters);
            word += holdCharacters.remove(index);
        }
        if (holdCharacters.isEmpty()) {
            if (!word.equals("")) {
                holdCombos.add(word);
                return holdCombos;
            }
            String[] tempArray = startingWord.split("");
            holdCharacters = new ArrayList<>(Arrays.asList(tempArray));
            if(index != -1){
                holdCharacters.remove(index);
            }
        }
        HashSet<String> usedStrings = new HashSet<>();
        for (int x = 0; x < holdCharacters.size(); x++) {
            if(!usedStrings.contains(holdCharacters.get(x))){
                findAllPermutations(holdCombos, startingWord, holdCharacters, word, x);
                usedStrings.add(holdCharacters.get(x));
            }
            /*findAllPermutations(holdCombos, startingWord, holdCharacters, word, x);
            usedStrings.add(holdCharacters.get(x));*/
        }
        return holdCombos;
    }
}
