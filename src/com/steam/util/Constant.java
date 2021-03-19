package com.steam.util;

import java.io.FileWriter;
import java.io.IOException;

public class Constant {
	public static String RequestCharacterEncoding = "utf-8"; //请求编码格式
	public static String ResponseCharacterEncoding = "text/json;charset=utf-8"; //响应编码格式
	public static String RedisIp = "106.52.112.29";
	public static int RedisHost = 6379;
	/**
	 * 数据库连接参数
	 */
	public static String DataBase ="shopmall";        //数据库名称
	public static String UserTable = "userinfo";      //用户数据表
	public static String AddressTable = "address";	  //收货地址表
	public static String ShopcartTable = "shopcart";  //购物车表

	public static String OrderTable = "orders";        //订单表
	public static String HistoryTable = "history";    //浏览记录表
	public static String CommentTable = "comment";  //评价表
	public static String GoodsTable = "goods";        //商品表
	public static String ParameterTable = "parameter";//商品参数
	public static String InfoTable = "info";          //资讯表
	public static String TypesTable = "types";          //商品类目表

	public static String JDBC_Driver = "com.mysql.jdbc.Driver";  //驱动
	public static String DBURL = "jdbc:mysql://localhost:3306/" + DataBase +"?useSSL=false&characterEncoding=UTF-8";//url
	public static String DBUSER = "root"; //帐号
	public static String DBPWD = ""; //密码
	public static String lifeCycle = "1800";
	
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117611608";
	
	// 商户私钥 PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCIi0qK+XpfpcqsyvFmChSKy4HMmQbSxHa2ksZv7jkpQQeRhyKddo0YT8AffILB/XB7jJehYAL/YLKq6mnxSlUDEEaaQO/wjWTc0AAOYSuLV9wtnC9VDJO46ngfL0x8xRewx2xM2wnIKrnpteRFj25Jfstj0pVobpp9W+3S9Cj/g741rVfU0+NV5Th8At0flm7097ZHvPx7B76gKHKkEqV/0HWTZ0fcwpArDWs9zAk6Xhc+zt8K1cOnIu45P1rZXDWCu34X2YtIQ+pVxo5swWJqorjpXVgnlagb/MZgaDJYdlNW1WEalzczNCofjWREjXrBmVxChT2641GRIiwv6C5/AgMBAAECggEAAyIvM8FF7awAWrbNk2nnzsec0vUwEuYvU0FLDIaLCUdUxSI0yShPVJ9/6TkSRyFp02wGjs2FRBcUApgelkr+aHOXKzMSTpLwHaEoXywbs7bwdpt++pSvTy8SUqTjPHnJcWUiNyFPuChC2/owougHv+gJAuFyTFM9eGMDsjOoPTTf7hj9LKkMh30IshcCgCEHjEbspOAQ1UtiqjFS6d8aOcq1WpKg1N7RlUCjfXD+PG6tLXFIiVleqfYleehEMtkl17fzU5HmZuRzEBIZqu2vXfzjy/mt5f8SEM9GlSaE5Nizyi7fiAbjFE4sEyhUcrDYvG50ubTn9fTS6FuBc4JwAQKBgQDwXCCHaYvN796SjpOSzaJDBTACxzV3WJIM5OWGYQgrvmVR5FNtkuQuTXa6s2Z+oDlf6T0SMxLdVmFI7/w1MGYixh7khQ6BPb5TqwrlcbrHVHC+s75GSyctVdH7gKfDxc12CrDILyVCexaI0uajeOTdpotLWPFFdzOFrouxAyCZwQKBgQCRbdG0OTN0oFAmE5zOjUSRKTtKARbjipe+ZigucP7idFLGMHE7DgNpV8N/2Jy+yPeBhtpQetdSr0G9yaWDFllcHwen8/IxZUVBeNU8jNaONMovKyhIYmTv5p6j/jPUIK+QjQ0oFe1XlH+boFPBpKE4zZNQ4n3mEzZ1N0iOaAhYPwKBgQCviij7nFrNKSz9DgG7ClFB7yz0Knbi1Z28qwLyFDV6dQ/cMgu4D7p0EoDus4zcV7nvUREYFJLncWmVcidY1SMSrGztajuAqg4xXs6TaW8GmqXIsM762XIgSvgTXQ+pC/IVDpOzb7MfjXOUs6pbozRKqJI8khWLLRZEwIgm2+jYQQKBgHDYOyFSRVgY0ThKfaFUwsC0srnA0KbtMsPd9w3aRh0nz9bTXflJ7WG/ZQZ96VqtDEiogBx0xUH2ldeTcWefXuV5enJbezHS+ANOpH+gdRfRZJVnMpHAL7xrQevUYxkV58UNfgj9wrXzl3UF2hfnC+bMtaPMq45smBQqOpWtqdP3AoGBAOA9dTF8E0H/5NfRc+ZXFSvcKonm4xY2u0dufDqKo2Mypl1iVGu49HmyrOY5ze/5fP2iZJhdedsoZFUOYHUV2HCzAf79e/XMVlsvMGKm9IsFi6sNxyan8C+CcNhu6P6f/glOlfmHHFCocA2AVDcoiqj6UERGQ0gncDMEJe4hJEfe";
	
	// 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhZbQSiR9rJQ/ETRsIw7YuA0W2QmRqRmLQAY6kFih5tjGrJPU4W9b4TKD3k9TDAy2MQ8d4GgyIjyjoFAhkmEEruCN13r0wn95VPj6PkEJ0gZluWkHQE2KQ4meyVh5NL9uEngVo3zSYD6eVVW6oAeO0rFkJY7ly7omUmb/ka3xmZXg14Mb+l4qimuSQ1zI2C/sZDgUMmwqaFt1vMhXjMFS19kylKgHLeI27WYcL/w/Ot2pvm1oK4tjdsYfsiKvEb4OO0LgcLQ3ypfwxxELQBjDt6ZDiENDoZT828nknOu2XCZrnJ3ZCvXOAwTl4MQnZ+eAxf0bXp9TcV1vMjT+w9+ULQIDAQAB/ETRsIw7YuA0W2QmRqRmLQAY6kFih5tjGrJPU4W9b4TKD3k9TDAy2MQ8d4GgyIjyjoFAhkmEEruCN13r0wn95VPj6PkEJ0gZluWkHQE2KQ4meyVh5NL9uEngVo3zSYD6eVVW6oAeO0rFkJY7ly7omUmb/ka3xmZXg14Mb+l4qimuSQ1zI2C/sZDgUMmwqaFt1vMhXjMFS19kylKgHLeI27WYcL/w/Ot2pvm1oK4tjdsYfsiKvEb4OO0LgcLQ3ypfwxxELQBjDt6ZDiENDoZT828nknOu2XCZrnJ3ZCvXOAwTl4MQnZ+eAxf0bXp9TcV1vMjT+w9+ULQIDAQAB";

	// 服务器异步通知页面路径
	public static String notify_url = "http://shoppingmall.free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	//支付成功跳转页面
	public static String return_url = "http:/localhost:8080/ShoppingMall/html/pay.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "https://openapi.alipaydev.com/gateway.do";

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
