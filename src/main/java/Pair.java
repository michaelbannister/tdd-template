public class Pair {
    private final String[] saidNames;
    private final String[] shoutedNames;

    public String[] getSaidNames() {
        return saidNames;
    }

    public String[] getShoutedNames() {
        return shoutedNames;
    }

    public Pair(String[] saidNames, String[] shoutedNames) {

        this.saidNames = saidNames;
        this.shoutedNames = shoutedNames;
    }



}
