package TestRunners;

import dataProvider.DataProviderdata;
import org.testng.annotations.Test;

import java.util.Map;

public class Sampltest {


    @Test(dataProvider = "data", dataProviderClass = DataProviderdata.class)
    public void findstoreswithLocation(Object[] data){
        Map<String, String> map = (Map<String, String>) data[0];

        System.out.println(map.toString());
    }


}
