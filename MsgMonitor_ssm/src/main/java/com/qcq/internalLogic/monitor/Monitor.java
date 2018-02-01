package com.qcq.internalLogic.monitor;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qcq.internalLogic.parser.Parser;
import com.qcq.internalLogic.parser.ParserImpl;
import com.qcq.mapper.SignalMapper;
import com.qcq.po.Device;
import com.qcq.po.Seeker;
import com.qcq.po.Seeker_device;
import com.qcq.po.Signal;

public class Monitor extends HttpServlet implements Runnable{
	@Override
	public void init() throws ServletException {
		super.init();
		
		this.main(null);
	}
	int port=8080;
	DatagramSocket ds;
	DatagramPacket dp;
	byte[] buf=null;
	String strReceive;
	//s e p e r a t o r
	Map<String,Object> parseResult=null;
	int items;
	Parser parser=new ParserImpl();
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SignalMapper signalMapper=ctx.getBean(SignalMapper.class);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			buf=new byte[1024];
			ds=new DatagramSocket(port);
			dp=new DatagramPacket(buf, buf.length);
			System.out.println("monitor is online, waiting for data...");
//			test to send something
			String strSend="hello world";
			InetAddress addr=InetAddress.getByName("39.108.162.211");
			DatagramPacket send=new DatagramPacket(strSend.getBytes(), strSend.length(), addr,8080);
			ds.send(send);
			while(true){
					
					ds.receive(dp);
//					System.out.println("from client:");
					strReceive=new String(dp.getData());
					strReceive=strReceive.trim();
					strReceive=strReceive.replaceAll(";;", ";");
					System.out.println("receive data: "+strReceive);
					if(strReceive!=null)
						this.receive(strReceive);
//					String strReceive=new String(dp.getData(),0,dp.getLength())+" from "+dp.getAddress().getHostAddress()+":"+dp.getPort();
//					System.out.println(strReceive);
					
//					String strSend="client respond";
//					DatagramPacket send=new DatagramPacket(strSend.getBytes(), strSend.length(), dp.getAddress(),8080);
//					ds.send(send);
					
					
					dp.setLength(1024);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ds.close();
		}
	}
	public static void main(String[] args) {
		Thread t=new Thread(new Monitor());
		t.start();
	}
	/**
	 * @param strReceive
	 */
	public void receive(String strReceive){
		//parse
		if(strReceive!=""||strReceive.indexOf("?")!=-1){
			this.parseResult=parser.parse(strReceive,";");
		}else{
			System.out.println("错误信息:"+strReceive);
		}
		
		//save
		if(parseResult!=null){
			try{
			Seeker seeker=(Seeker) parseResult.get("seeker");
			List<Device> devices=(List<Device>) parseResult.get("devices");
			List<Seeker_device> seeker_devices=(List<Seeker_device>) parseResult.get("seeker_devices");
			List<Signal> signals=(List<Signal>) parseResult.get("signals");
				
			signalMapper.insertSeeker(seeker);
			signalMapper.insertDevices(devices);
			signalMapper.insertSeeker_device(seeker_devices);
			signalMapper.insertSignals(signals);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("message wrong:"+strReceive);
		}
	}
}
