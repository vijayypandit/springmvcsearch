package springmvcsearch;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	
	@RequestMapping("/home")
	public String home() {
		
		System.out.println("goung to home ...");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView redirectView = new RedirectView();
		String url="https://www.google.com/search?q=";
		if(query == "") {
			redirectView.setUrl("localhost:8080/springmvcsearch/home");
			JOptionPane.showMessageDialog(null, "Please enter a Search Value");
			
		}
		
		else {
			url=url+query;
			redirectView.setUrl(url);	
		}
//		
//		url=url+query;
//		redirectView.setUrl(url);
		return redirectView;
	}
	
}
