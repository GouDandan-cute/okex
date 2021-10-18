import com.zsm.Util.RequestUtil;

/**
 * [一句话功能简述]
 *
 * @author zsm
 * @version [版本号, 2021年10月18日]
 */
public class Test
{
    @org.junit.jupiter.api.Test
    public  void test(){
        String asd = RequestUtil.getRequest("/api/v5/market/ticker?instId=BTC-USD-SWAP");
        System.out.println(asd);

    }
}
