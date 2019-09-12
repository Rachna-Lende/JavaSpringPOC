package com.poc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poc.dao.EmployeeDao;

@Controller  
public class EmployeeController {  
  
	@Autowired    
	 EmployeeDao dao;
	 
    @RequestMapping("/hello")  
    public String display(Model m)  
    {  
        m.addAttribute("emp", new Employee());  
        return "viewpage";  
    }  
    @RequestMapping(value="/helloagain",method = RequestMethod.POST)  
    public String submitForm( @Valid @ModelAttribute("emp") Employee e, BindingResult br)  
    {  
        if(br.hasErrors())  
        {  
            return "viewpage";  
        }  
        else  
        {  
        dao.save(e);
        return "redirect:/";  
        }  
    }
    
    @RequestMapping(value="/show", method=RequestMethod.GET)  
    public String viewemp(Model m){    
        List<Employee> list=dao.getEmployees();    
        m.addAttribute("list",list);  
        return "show";    
    }    
    
    
    @RequestMapping(value="/editemp/{name}")    
    public String edit(@PathVariable String name, Model m){
    	Employee emp = null;
    	try{
    		emp=dao.getEmployeeByName(name); 
    	}
    	catch(Exception e){
    		  System.out.println("Failed to get employee by name"+e.getMessage());
    	}
        m.addAttribute("command",emp);  
          return "empeditform";    
    }    
    
    
    @RequestMapping(value="/editSave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("command") Employee emp){   
        dao.update(emp);    
        return "redirect:/show";    
    }    
    
    @RequestMapping(value="/delete", method = RequestMethod. POST)
    public String delete(@RequestParam() String[] checkbox) {
        if (checkbox!=null) {
        	for(int i=0;i<checkbox.length;i++){
        		dao.delete(checkbox[i]);
        	}
        	return "redirect:/";
        }

        return "show";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)  
    public String index() {  
        return "index";  
    }  
      
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     } 
    
}  