package com.pro.kim.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JsoupTestController {

	
	@RequestMapping(value="/jsouphome") 
	public ModelAndView JsoupHome (ModelAndView mav, Model model, String aliurl) throws IOException {
	  
	  
	  	mav.setViewName("jsouphome");//view page name 
	  	
	  	return mav; 
	}
	 

	@RequestMapping(value = "/jsoup", method = RequestMethod.POST)
	public ModelAndView JsoupTest(ModelAndView mav, Model model, HttpServletRequest httpServletRequest) throws IOException {

		String aliurl = httpServletRequest.getParameter("aliurl");

		Document doc = Jsoup.connect(aliurl).get();

		Elements titles = doc.select("div.price-item");
		Elements imgs = doc.getElementsByClass("image-view");
		String src = imgs.select("img").attr("src");

		System.out.println(doc);
		
		model.addAttribute("titles", titles);
		model.addAttribute("src", src);

		mav.setViewName("jsoup");// view page name
		return mav;
	}
}
