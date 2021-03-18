package com.steam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.steam.util.Constant;
import com.steam.util.JsonChange;

public class TestController extends HttpServlet {
	JsonChange print = new JsonChange();
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			/**/
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			//String method = request.getParameter("method");
			String out_trade_no = request.getParameter("out_trade_no");//订单号(必填)
			String total_amount =request.getParameter("total_amount");//金额(必填)
			String subject = request.getParameter("subject"); //订单名称(必填)
			String body = request.getParameter("body");  //商品描述，(选填)
			String token ="321425"; // request.getParameter("token");
			token = token==null?"":token;
			System.out.println(out_trade_no);
			System.out.println(total_amount);
			System.out.println(subject);
			System.out.println(body);
			String html = null;
			
			
			//获得初始化的AlipayClient
			AlipayClient alipayClient = new DefaultAlipayClient(Constant.gatewayUrl, Constant.app_id, Constant.merchant_private_key, "json", Constant.charset, Constant.alipay_public_key, Constant.sign_type);
			//设置请求参数
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(Constant.return_url);
			alipayRequest.setNotifyUrl(Constant.notify_url);

			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ total_amount +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"body\":\""+ body +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			//请求
			try {
				html = alipayClient.pageExecute(alipayRequest).getBody();
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			System.out.println(html);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(html);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
