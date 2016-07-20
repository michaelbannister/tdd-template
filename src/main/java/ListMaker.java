import com.google.common.base.Joiner;

public class ListMaker {

    public static String withOxfordComma(String... names) {
        if (names.length < 3) {
            return Joiner.on(" and ").join(names);
        } else {
            int indexOfLastName = names.length - 1;

            String joined = "";

            for (int i = 0; i < indexOfLastName; i++) {
                joined += names[i] + ", ";
            }
            joined += "and " + names[indexOfLastName];
            return joined;
        }
    }
}
