import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NameMaker {
    public static Pair groupByVolume(String... names) {

        List<String> saidName = new ArrayList<>();
        List<String> shoutedName = new ArrayList<>();
        for (String name : names) {
            if (StringUtils.isAllUpperCase(name)) {
                shoutedName.add(name);
            } else {
                saidName.add(name);
            }
        }
        return new Pair(saidName.toArray(new String[saidName.size()]), shoutedName.toArray(new String[shoutedName.size()]));
    }
}
