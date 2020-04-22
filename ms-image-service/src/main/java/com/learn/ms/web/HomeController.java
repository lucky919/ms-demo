package com.learn.ms.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ms.domain.Image;

@RestController
@RequestMapping
public class HomeController {

	@Autowired
	private Environment env;
	
	@GetMapping
	public List<Image> getImages() {
		return Arrays.asList(
				new Image(1L, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
				new Image(2L, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
				new Image(3L, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
	}
	
	@GetMapping("/status/check")
	public String statusCheck() {
		return "Image service running on Port : " + env.getProperty("local.server.port");
	}
	
	@GetMapping("/admin/status/check")
	public String adminStatusCheck() {
		return "Protected Image service running on port : " + env.getProperty("local.server.port");
	}
}
