import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println(pot(2, 3));

        /*List<Integer> list = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de elementos: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.print("Elemento: ");
            list.add(sc.nextInt());
        }

        int res = 0;
        for (int i=0; i<n; i++){
            res += list.get(i);
        }

        System.out.println("Suma: " + res);*/

        ArrayList<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(1);  // RES: 7

        System.out.print("RES: " + suma(arr, 0));

    }

    public static int suma(ArrayList<Integer> arr, int pos){
        int parcial = arr.get(pos++);
        // pos++; //0, 1 -> x = pos++, x=0, pos=1
                //       x = ++pos, x=1, pos=1
        if(pos == arr.size()){
            return parcial;
        }
        return parcial + suma(arr, pos);
    }

    public static int pot(int x, int y){
        if(y == 0)
            return 1;
        else
            return x * pot(x, y-1);
    }
}
