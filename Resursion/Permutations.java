import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Permutations
 */
public class Permutations {

    public static void main(String[] args) {
        // arr = [10,20,30]
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);

        List<List<Integer>> result = new ArrayList<>();
        permute(0, arr, result);

        for (List<Integer> p : result) {
            for (Integer i : p) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
    static void permute(int i, List<Integer> arr, List<List<Integer>> result){
        if( i == arr.size() - 1){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i; j < arr.size(); j++){
            Collections.swap(arr, i, j);
            permute(i + 1, arr, result);
            Collections.swap(arr, i, j);
        }
    }
}