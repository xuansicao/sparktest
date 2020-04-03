import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5Test {

    @Test
    public void testmd5(){
        String str = "f365af86245142a7851eccdcebbe90a9apikpi.delivery.resultappKeyB4C32F5BpageIndex1pageSize10toAppKeyB6CFE8F3ver1_0{\"activityDate\":\"2020-03-16\",\"warehouseCode\":\"403011\"}f365af86245142a7851eccdcebbe90a9";
        String str2 ="f365af86245142a7851eccdcebbe90a9apikpi.delivery.resultappKeyB4C32F5BpageIndex1pageSize10toAppKeyB6CFE8F3ver1_0{\"activityDate\":\"2020-03-16\",\"warehouseCode\":\"403011\"}f365af86245142a7851eccdcebbe90a9";

        String s = DigestUtils.md5Hex(str);
        String s2 = DigestUtils.md5Hex(str2);
        System.out.println(s);
        System.out.println(s2);

    }
}
