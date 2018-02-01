package com.qcq.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qcq.po.Device;
import com.qcq.po.Seeker;
import com.qcq.po.Seeker_device;
import com.qcq.po.Signal;
@Repository
public interface SignalMapper {
	public void insertSeeker(Seeker seeker);
	public void insertDevices(List<Device> devices);
	public void insertSignals(List<Signal> signals);
	public void insertSeeker_device(List<Seeker_device> seeker_devices);
	public List<Signal> selectAllSignals();
	public List<Signal> selectLatestSignals();
	public List<Signal> selectByMac(String mac);
	public void deleteOutDateSignals(Date date);
	public void deleteUselessMacs();
}
