package com.qcq.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qcq.mapper.SignalMapper;
import com.qcq.po.Signal;

@Service
public class SignalService {
	@Resource
	SignalMapper signalMapper;
	public List<Signal> selectAllSignals(){
		List<Signal> signals=signalMapper.selectAllSignals();
		return signals;
	}
	public List<Signal> selectLatestSignals(){
		List<Signal> signals=signalMapper.selectLatestSignals();
		return signals;
	}
	public List<Signal> selectByMac(String mac){
		List<Signal> signals=signalMapper.selectByMac(mac);
		return signals;
	}
}
