//package edu.etime.woo.controller.wechatcontroller;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import com.alibaba.fastjson.JSONObject;
//import edu.etime.woo.pojo.Customer;
//import edu.etime.woo.service.interfaces.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
///**
// * 微信客户管理，包含客户的注册和openid获取
// *
// */
//
//@Controller
//@RequestMapping("wx/customer")
//public class WxCustomerController {
//
//    @Autowired
//    CustomerService customerService;
//
//    /**
//     * 获取客户openid的方法
//     * 说明：@ResponseBody 注解：
//     *     表示这个方法返回的内容就是需要响应到客户端的内容，而不需要进行视图解析
//     * @param code
//     * @return
//     */
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(String code) {
//        /**
//         * appid=wxc449411fab1b45b8(微信小程序的id)
//         * secret=645cc9ba8cf29fc5fa683047e3ed859（每个人的密钥，需要到微信小程序平台中去获取）
//         * js_code:小程序传递过来的code属性
//         */
//        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wxaad0703b177762b4&secret=24559ad2f297296c025f538e23acd050&js_code="
//                + code + "&grant_type=authorization_code";
//        String returnvalue = GET(WX_URL);
//        JSONObject json = JSONObject.parseObject(returnvalue);
//        String openid = json.get("openid").toString();
//        return openid;
//    }
//
//    // 发起get请求的方法。
//    public static String GET(String url) {
//        String result = "";
//        BufferedReader in = null;
//        InputStream is = null;
//        InputStreamReader isr = null;
//        try {
//            URL realUrl = new URL(url);
//            URLConnection conn = realUrl.openConnection();
//            conn.connect();
//            Map<String, List<String>> map = conn.getHeaderFields();
//            is = conn.getInputStream();
//            isr = new InputStreamReader(is);
//            in = new BufferedReader(isr);
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            // 异常记录
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//                if (is != null) {
//                    is.close();
//                }
//                if (isr != null) {
//                    isr.close();
//                }
//            } catch (Exception e2) {
//                // 异常记录
//            }
//        }
//        return result;
//    }
//
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(Customer cus){
//        List<Customer> list = customerService.selectCustomerByOpenid(cus.getOpenid());
//        Integer rtn = 1;
//        if(list.size()>0){
//            //用户已在数据库中存在。这里不需要做其他的处理
//        }else{
//            //用户不存在，那么需要将用户保存到数据库中
//            cus.setCusid(UUID.randomUUID().toString());
//            rtn = customerService.insertCustomer(cus);
//        }
//        return rtn.toString();
//    }
//}
