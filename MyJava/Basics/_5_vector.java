import java.util.Vector;
public class _5_vector {
    public static void main(String[] args){
        Vector<Integer> vector = new Vector<>();

        vector.add(19); vector.add(29); vector.add(39); vector.add(49); vector.add(59);

        System.out.println(vector);

        vector.remove(2);

        System.out.println(vector);

        System.out.println(vector.get(2));

        System.out.println(vector.size());

        System.out.println(vector.capacity());
        
        System.out.println(vector.isEmpty());

        vector.clear();

        System.out.println(vector);
        
        System.out.println(vector.isEmpty());

        System.out.println(vector.size());

        System.out.println(vector.capacity());
        
    }
}
