package sthFunny;

import java.util.Map;
import java.util.TreeMap;

public class FunnyMain {
	
	/** Method */
	public static void main(String args[]) {

		 getMethodDetail();
	}
	
	
	public static void getMethodDetail() {
		
		Map<String, String> params = new TreeMap<String, String>();
		params.put("expend_code", "wulin3");
		params.put("expend_trace", "3587");
		params.put("extend", "aplipaysdk");
		params.put("notify_url", "http://paytest.renren.com");
		params.put("out_trade_no", "201502040001");
		params.put("quantity", "1");
		params.put("return_url", "http://paytest.renren.com");
		params.put("rrd", "10");
		params.put("sign_type", "MD5");
		params.put("subject", "Ôª±¦");
		params.put("uid", "833752054");
		
		SignUtils.buildMD5Sign("", params);
		System.out.print("\nGive: "+"c2d5bbfa4d84d6ec2374796c8a790cfb");
		//Give: c2d5bbfa4d84d6ec2374796c8a790cfb
		//My:   e2eb534d1490b37ad08b158e4f632347
	}
	
	
}
