package com.qcq.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qcq.po.Signal;
import com.qcq.service.SignalService;
import com.qcq.util.MathUtil;


@Controller
public class SearchController {
	@Resource
	SignalService service;
	@RequestMapping("/search")
	public ModelAndView toMain(ModelAndView mv,@RequestParam(value="mac")String mac) {
		List<Signal> signals=service.selectByMac(mac);
		List<Map<String,Double>> coordinates=MathUtil.getCoordinates(signals);
		
		mv.addObject("coordinates", coordinates);
		mv.getModel().put("signals", signals);
		mv.setViewName("search");
		return mv;
	}
}
