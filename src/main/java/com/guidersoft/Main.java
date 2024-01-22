package com.guidersoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TestConfig config=TestConfigReader.instance().getConfig();
        System.out.println("config.getApplication().getName() = " + config.getApplication().getName());
        System.out.println("config.getTests().getBrowser() = " + config.getTests().getBrowser());
        config.getUser("user").getPassword(); // hangi user yazarsak onu getirir


    }

    public static void main1(String[] args) throws IOException {
        File file=new File("testconfig.yml");

        // mapper ile objeleri eslestirecek yani map edecek.YAML ile pojp yu karsilastitacak. reader objesi olustu
        // Eger Yaml kullanilacaksa  ObjectMapper(new YAMLFactory()); buray new YAMLFactory yazdik ama json kullanilacksa birsey yazmayiz
        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());


        //Yani mapper ile file  dosyasini kullanarak  TestInnerClass ta bir obje olustur
        TestConfig config1=mapper.readValue(file, TestConfig.class);
        System.out.println("config1.getApplication().getName() = " + config1.getApplication().getName());




        /* Strem ile ypatik
       String pass= config1.getUsers().stream().filter(U -> U.getName()
               .equalsIgnoreCase("admin")).findFirst().get().getPassword();
        System.out.println("pass = " + pass);

*/
        String pass="";
        for (TestConfig.User user : config1.getUsers()) {
           if (user.getName().equalsIgnoreCase("admin")){
               pass=user.getName();
               break;
           }
            
        }
        System.out.println("pass = " + pass);
        System.out.println("config1.getVariables().get(\"var2\") = " + config1.getVariables().get("var2"));


    }
}

