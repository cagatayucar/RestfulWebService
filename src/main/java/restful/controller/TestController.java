package restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.service.PersonelService;
import spring.service.pojo.Personel;
import spring.service.pojo.PersonelType;

@Controller
@RequestMapping("/testcontroller")
public class TestController{
	
	@Autowired
	PersonelService personelService;
	
	
	
	
    public TestController() {
    	
	}
	
	@ResponseBody
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView getTypeList(){
 		List<PersonelType> typelist = personelService.getAllType();	
		return new ModelAndView("list", "typelist", typelist);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerType" , method = RequestMethod.GET)
	public ModelAndView registerTypePage(){
		
		ModelAndView mav = new ModelAndView("typeform");
		mav.addObject("pType" , new PersonelType());
		return mav;
		
	}
	@ResponseBody
	@RequestMapping(value="/registerType", method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)    
    public Long registerType(@RequestBody PersonelType personelType) {
        return (Long) personelService.addType(personelType);
    }
	
	@ResponseBody
	@RequestMapping(value = "/editType/{type_id}" , method = RequestMethod.GET)
	public ModelAndView editTypePage(@PathVariable Long type_id){
		
		ModelAndView mav = new ModelAndView("editform");
		PersonelType personelType = personelService.getType(type_id);
		mav.addObject("pType" , new PersonelType());
		return mav;
		
	}
	
	@RequestMapping(value="/editType/{type_id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void editType(@PathVariable Long type_id, @RequestBody PersonelType personelType) {
        personelType.setType_id(type_id);
        personelService.editType(personelType);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete/{type_id}" , method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long type_id){
	personelService.deleteType(type_id);	
		return new ModelAndView("redirect:../list");
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public String add(){
		
		if(personelService==null){
			System.out.println("hata");
		}
		
		PersonelType personelType = new PersonelType();
		personelType.setType_id(1L);
		
		Personel personel = new Personel();
		personel.setName("asd");
		personel.setSurname("aaa");
		personel.setAddress("asd");
		personel.setPhonenumber("2222222");
		personel.setPersonelType(personelType);
		personelService.addPersonel(personel);
//		personel.setPersonelType(personelType);
		
		
		return "Ekleme Basarili";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update" , method = RequestMethod.GET)
	public String update(){
		
		
		
		
		
		return "update basarili";
		}
	
	@ResponseBody
	@RequestMapping(value="/listType" , method = RequestMethod.GET)
	public String listTypes(){
		
		return "PersonelType";
		}
	
		@ResponseBody
		@RequestMapping(value="/addtype" , method = RequestMethod.POST)
		public String addType(@ModelAttribute(value="type") PersonelType type, BindingResult result){
			
			
			
//			PersonelType type1 = new PersonelType();
//			type1.setType_name("yenibirtip");
//			personelService.addType(type1);
			
			return "type eklendi";
		}
	
	
	
	
	
	
	
	
	
}