package com.qcq.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qcq.mapper.SignalMapper;
import com.qcq.po.Signal;
import com.qcq.service.SignalService;
import com.qcq.util.MathUtil;


@Controller
public class ToMainController {
	@Resource
	SignalService service;
	@RequestMapping("/main")
	public ModelAndView toMain(ModelAndView mv) {
		List<Signal> signals=service.selectLatestSignals();
		List<Map<String,Double>> coordinates=MathUtil.getCoordinates(signals);
		
		mv.addObject("coordinates", coordinates);
		mv.addObject("signals", signals);
		mv.setViewName("main");
		return mv;
	}
}
