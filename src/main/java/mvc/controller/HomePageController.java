package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomePageController {

	@GetMapping("/last5")
	@ResponseBody
	public String getLastFive() {
		return "HomePage";
	}
}
