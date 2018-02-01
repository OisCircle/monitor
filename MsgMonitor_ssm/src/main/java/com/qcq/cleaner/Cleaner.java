package com.qcq.cleaner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qcq.mapper.SignalMapper;
import com.qcq.po.Signal;

//定期清理数据库里面的数据
public class Cleaner implements Runnable{
	int cycle;
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SignalMapper signalMapper=ctx.getBean(SignalMapper.class);
	public Cleaner(){
		
	}
	public Cleaner(int cycle){
		this.cycle=cycle;
	}
	public void cleanSignals(){
		Date date=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH,-cycle);
		date=calendar.getTime();
		
		//删除
		signalMapper.deleteOutDateSignals(date);
	}
	public void cleanMacs(){
		signalMapper.deleteUselessMacs();
	}
	public static void main(String[] args) {
		Thread t=new Thread(new Cleaner(1));
		t.start();
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(172800000);
				this.cleanSignals();
				this.cleanMacs();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
