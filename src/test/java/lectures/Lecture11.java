package lectures;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String joining = "";
        for (String name : names) {
            joining += name + ",";
        }
        System.out.println(joining.substring(0, joining.length() - 1));
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String strReduce = names.stream()
                .reduce("", (s1, s2) -> s1 + "," + s2)
                .substring(1);

        String strJoining = names.stream()
                .collect(Collectors.joining(","));

        System.out.println(strReduce);
        System.out.println(strJoining);

    }
}
