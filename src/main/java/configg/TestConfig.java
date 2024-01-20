package configg;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class TestConfig {
    // config file nin pojo sudur.Okunmasi kolay olsun diye file den buraya atariz
    private Application application;
    private List<User> users = new ArrayList<User>();
    private Tests tests;
    private Browser chrome;
    private Browser edge;
    private Browser firefox;
    private Map<String ,String> variables;


}

