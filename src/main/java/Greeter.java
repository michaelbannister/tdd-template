import static org.apache.commons.lang3.StringUtils.isAllUpperCase;

public class Greeter {
    public static String greet(String... names) {

        String joinedNames;
        if (names == null) {
            return "Hello, my friend.";
        }

        Pair pairedNames = NameMaker.groupByVolume(names);

        joinedNames = ListMaker.withOxfordComma(names);


        String greeting;
        if (isAllUpperCase(joinedNames)) {
            return "HELLO " + joinedNames + "!";
        } else {
            return "Hello, " + joinedNames + ".";
        }
    }

}
