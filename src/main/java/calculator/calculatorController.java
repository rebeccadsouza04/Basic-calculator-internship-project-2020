package calculator;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class calculatorController 
{

	@GetMapping("/calculator-json")
	  @ResponseBody
	  public calculator getcalculator(@RequestParam(name="operation", required=false, defaultValue="Enter") String operation,
			  @RequestParam(value="num1", required=false, defaultValue="0") double num1, 
			  @RequestParam(value="num2", required=false, defaultValue="0") double num2, 
			  @RequestParam(value="result", required=false, defaultValue="0") double result,
			  @RequestParam(value="operator", required=false, defaultValue="_") char operator) 

	  {   
		calculator calculator = new calculator();
		  
		
		  calculator.setNum1(num1);
		  calculator.setNum2(num2);
		  		  
		  switch(operation)
		  {
		  
		     case"add":
		    	 result = num1 + num2;
		    	 operator = '+';
		    	 break;
		     case"subtract":
		    	 result= num1 - num2;
		    	 operator = '-';
		         break;
		     case"divide":
		         result = num1 / num2;
		         operator = '/';
		         break;
		     case"multiply":
		    	 result = num1 * num2;
		    	 operator = '*';
		    	 break;
		     
		  }		  
	      calculator.setResult(result);
		  calculator.setOperation(operation);
		  calculator.setOperator(operator);
		  
		  
	    return calculator;
	
	 }
	
	@GetMapping("/calculator-html")
    public ModelAndView htmlView(@RequestParam(name="operation", required=false, defaultValue="Enter") String operation,
			  @RequestParam(value="num1", required=false, defaultValue="0") double num1, 
			  @RequestParam(value="num2", required=false, defaultValue="0") double num2, 
			  @RequestParam(value="result", required=false, defaultValue="0") double result,
			  @RequestParam(value="operator", required=false, defaultValue="_") char operator, Model model)
  {    
	   calculator calculator = new calculator();
		  
	      calculator.setNum1(num1);
	      calculator.setNum2(num2);
	      
	      switch(operation)
		  {
		  
		     case"add":
		    	 result = num1 + num2;
		    	 operator = '+';
		    	 break;
		     case"subtract":
		    	 result = num1 - num2;
		    	 operator = '-';
		    	 break;
		     case"divide":
		    	 result = num1 / num2;
		    	 operator = '/';
		    	 break;
		     case"multiply":
		    	 result = num1 * num2;
		    	 operator = '*';
		    	 break;
		     default:
		    	 System.out.println("Invalid Operation");
		  }
	      
	      calculator.setResult(result);
	      calculator.setOperator(operator);
	   
      
        ModelAndView mav = new ModelAndView();
        mav.addObject("calculator", calculator);
        mav.setViewName("mycalculator.html");   
        return mav;
  }

	  }
	  

