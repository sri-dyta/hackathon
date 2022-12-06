package com.usbank.hackathon.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usbank.hackathon.constants.constants;
import com.usbank.hackathon.model.customer;
import com.usbank.hackathon.service.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class WelcomeController extends constants{
	
	@Autowired
	private ClientService service;

  //  TomcatServletWebServerFactory
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("<Acc nickname> Checking", "<Acc nickname> Savings", "<Acc nickname> savings", "Automobile Loan", "Home Loan");

    @GetMapping("/welcome")
    public String main(Model model) {
        model.addAttribute("message",getcustomerDetails());
        model.addAttribute("tasks", tasks);
       // model.addAttribute("tasks", customer);
        
        

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }
    
  public   String  getcustomerDetails(){
	  
	 // Flux<String> cust= null;
	  String cust="";
	  try{
	 //RestTemplate restTemplate = new RestTemplate();
	  cust = service.getCustomerDetails();
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  return cust.toString();
    	
    }

}