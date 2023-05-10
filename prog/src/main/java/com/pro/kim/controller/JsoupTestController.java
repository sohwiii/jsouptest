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
	public ModelAndView JsoupTest(ModelAndView mav, Model model, HttpServletRequest httpServletRequest)
			throws IOException {

		String aliurl = httpServletRequest.getParameter("aliurl");
		// 자료를 가져올 사이트에 연결하기
		// Document doc =
		// Jsoup.connect("https://korean.alibaba.com/p-detail/detail-1600579259098.html?__sceneInfo=%7B%22cacheTime%22%3A%221800000%22%2C%22type%22%3A%22appDetailShare%22%7D&from=Android").get();
		Document doc = Jsoup.connect(aliurl).get();
		// System.out.println(doc.data()); // html 코드를 가져온다.

		Elements titles = doc.select("div.product-title");
		Elements img = doc.getElementsByClass("image-view");
		Elements detailimg = doc.select("div.magic-8");
		String src = img.select("img").get(0).attr("src");
		List<String> srcList = new ArrayList<String>();
		System.out.println(titles.size());
		System.out.println(detailimg.size());
		for(int i = 0; i < detailimg.size() ; i++) {
			String detailsrc = detailimg.select("img").get(i).attr("src");
			srcList.add(detailsrc);
			System.out.println(srcList.get(i));
			System.out.println("아아아아");
		}
		// 묶기전 큰 묶음부터 묶어주는게 좋다.
		// Elements percents = doc.select("div.box-contents div.score strong.percent
		// span");
		/*
		 * for (int i = 0; i < 7; i++) { Element title = titles.get(i); Element percent
		 * = percents.get(i); System.out.println(title.text() + " : "+ percent.text());
		 * // 보고있는 사이트의 영화 제목을 다 가져온다. model.addAttribute("title", title);
		 * model.addAttribute("percent", percent);
		 * 
		 * }
		 */

		model.addAttribute("titles", titles);
		model.addAttribute("src", src);
		model.addAttribute("srcList", srcList);

		mav.setViewName("jsoup");// view page name
		return mav;
	}
}
