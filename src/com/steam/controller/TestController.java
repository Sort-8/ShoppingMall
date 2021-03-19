package com.steam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.steam.service.serviceimp.OrdersServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;

public class TestController extends HttpServlet {
	JsonChange print = new JsonChange();
	
	/**
	 * 庞海
	 * 根据请求的参数跳转支付页面
	 * @param request
	 * @param response
	 */
	public static void AliPay(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String out_trade_no = request.getParameter("out_trade_no");//订单号(必填)
			String total_amount =request.getParameter("total_amount");//金额(必填)
			String subject = request.getParameter("subject"); //订单名称(必填)
			String body = request.getParameter("body");  //商品描述，(选填)
			String method = request.getParameter("method");  //支付方法，(必填)
			method = method==null?"":method; 
			String html = null;
			System.out.println(method);
			AlipayClient alipayClient = new DefaultAlipayClient(Constant.gatewayUrl,
					Constant.app_id, Constant.merchant_private_key, "json", Constant.charset,
					Constant.alipay_public_key, Constant.sign_type);
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(Constant.return_url);
			alipayRequest.setNotifyUrl(Constant.notify_url);
			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			html = alipayClient.pageExecute(alipayRequest).getBody();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(html);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 庞海
	 * 搜索订单是否已支付
	 * @param request
	 * @param response
	 * @param out_trade_no
	 */
	public static void searchOrder(HttpServletResponse response, String out_trade_no) {
		AlipayClient alipayClient = new DefaultAlipayClient(Constant.gatewayUrl, 
				Constant.app_id, Constant.merchant_private_key, "json", 
				Constant.charset, Constant.alipay_public_key, Constant.sign_type);
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		String trade_no = "" ; //支付宝交易号
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");
		try {
			String result = alipayClient.execute(alipayRequest).getBody();
			response.getWriter().write(result);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
			String method = request.getParameter("method");
			String out_trade_no = request.getParameter("out_trade_no");
			out_trade_no = out_trade_no==null?"":out_trade_no;
			method = method==null?"":method;
			if("Alipay".equals(method)) {
				AliPay(request, response);
			}else {
				//已支付,将订单状态设为待发货,减少对应商品数量
				
				OrdersServiceImp ordersServiceImp = new OrdersServiceImp();
				ordersServiceImp.editOrders(out_trade_no, "待发货");
				searchOrder(response, out_trade_no);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
