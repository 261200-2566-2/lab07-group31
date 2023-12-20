import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//-----interface which is going to use in lab08-----
interface WeekSetInterface extends Iterable<String> {
    boolean add(String day);
    boolean remove(String day);
    int size();
}
class WeekSet implements WeekSetInterface {
    private final Map<String, Object> daysMap;

    // Initialize the set with the 7 days of the week
    private void initializeDays() {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : daysOfWeek) {
            add(day);
        }
    }
    //-----implement Set using a HashMap-----
    public WeekSet() {
        this.daysMap = new HashMap<>();
        initializeDays();
    }
    //-----methods-----
    @Override
    public boolean add(String day) {
        return daysMap.put(day, new Object()) == null;
    }
    @Override
    public boolean remove(String day) {
        return daysMap.remove(day) != null;
    }
    @Override
    public int size() {
        return daysMap.size();
    }
    @Override
    public Iterator<String> iterator() {
        return daysMap.keySet().iterator();
    }
}

public class Main {
    public static void main(String[] args) {
        var weekSet = new WeekSet();
        System.out.println("Number of days in a week: " + weekSet.size());
        System.out.println("**************************************");
        System.out.println("Remove weekday : Monday? ");
        weekSet.remove("Monday");
        System.out.println("**************************************");
        System.out.println("Number of days after removal: " + weekSet.size());
        // Using Iterator
        System.out.println("Using Iterator to show the day left:");
        Iterator<String> iterator = weekSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("-"+ iterator.next());
        }
    }
}


/*-----Reference-----//please give us 2 points
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#add(E)
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#iterator()
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
*/