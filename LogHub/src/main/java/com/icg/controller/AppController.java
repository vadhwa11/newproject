package com.icg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icg.model.Currency;
import com.icg.model.CurrencyDTO;
import com.icg.model.Depot;
import com.icg.model.Inventory;
import com.icg.model.NacItemDTO;
import com.icg.model.RefrenceForLLP;
import com.icg.model.Uom;
import com.icg.model.User;
import com.icg.service.AddCurrencyService;
import com.icg.service.DeleteCurrencyService;
import com.icg.service.DuplicateNameService;
import com.icg.service.EditCurrencyService;
import com.icg.service.InventoryService;
import com.icg.service.RefrenceForLLPService;
import com.icg.service.SearchCurrencyService;
import com.icg.service.SearchNacService;
import com.icg.service.UserService;
import com.icg.service.UtilsService;
import com.icg.util.MessageExtension;




@Controller
@RequestMapping(value="/")
//@SessionAttributes("useraName")
public class AppController {

	@Autowired 
	UserService userService;
	
	@Autowired 
	InventoryService inventoryService;
	
	@Autowired
	UtilsService utilsService;
	
	@Autowired
	DuplicateNameService duplicateNameService;
	
	@Autowired
	AddCurrencyService addCurrencyService;
	
	@Autowired
	EditCurrencyService  editCurrencyService;
	
	@Autowired
	DeleteCurrencyService deleteCurrencyService;
	/*Login process*/
	@Autowired
	RefrenceForLLPService refrenceForLLPService;

	@Autowired
	SearchCurrencyService searchCurrencyService;
	
	@Autowired
	SearchNacService searchNacService; 
	
	private static final Logger logger = Logger.getLogger(AppController.class);
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("user", new User());
	    return mav;
	  }
	 
	 
	 @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	    ModelAndView mav = null;
	    
	    try {
	    	System.out.println("user.getUserName() :: "+user.getUserId());
	    	System.out.println("user.getPassword() :: "+user.getPassword());
	    	System.out.println("user.getUserType() :: "+user.getUserType());
	    	String userName=user.getUserId();
	    	String password=user.getPassword();

	      
	        	User userList = userService.validateUser(user);
	            System.out.println(" orgunit from api :: "+userList.getOrgUnit());
	            System.out.println("user name from api :: "+userList.getUserName());
	            System.out.println("user type from api :: "+user.getUserType());
	               session.setAttribute("userName", "Aman Singh");
	       	       session.setAttribute("orgUnit", "D(IT)");
	       	       session.setAttribute("userType", "admin");
	            if (userList.getOrgUnit()!=null)
		           {
		        	   /*session.setAttribute("userName", userList.getUserName());
		       	       session.setAttribute("orgUnit", userList.getOrgUnit());
		       	       session.setAttribute("userType", userList.getUserType());*/
	            	
		       	       session.setAttribute("loginId", userName);
		       	       System.out.println("userName in session :: "+session.getAttribute("userName"));
		       	       System.out.println("orgunit in session :: "+session.getAttribute("orgUnit"));
		       	       System.out.println("userType in session :: "+session.getAttribute("userType"));
		        	   mav = new ModelAndView("home");
		        	 } else {
		       	    	mav = new ModelAndView("error");
		       	    	mav.addObject("message", MessageExtension.LOGIN_MESSAGE_ERROR);
		       
		       } 
	            mav = new ModelAndView("home");
	        
	    } 
	   // catch (LoginException e) {
	    catch (Exception e) {
	    	logger.info(e);
	    	logger.error(e);
	        e.printStackTrace();
	    }
	    return mav;
	  }
	  
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	  public ModelAndView loginProcess1(HttpServletRequest request, HttpServletResponse response,HttpSession session,
	  @ModelAttribute("user") User user) {
		 ModelAndView mav=new ModelAndView("login");
		return mav;
	 }
	  
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if(request.getSession(false).getAttribute("orgUnit")!=null){
		 ModelAndView mav=new ModelAndView("home");
		return mav;
	}
	else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    mav.addObject("error","Session Timeout !!! , Please Login Again");
		    
		    return mav;
	
		}
	}
	
	/* favourite process */
		@RequestMapping(value = { "/favourite"}, method = RequestMethod.GET)
		public String favPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
			
			return "redirect:/home";
		}
			
			else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    redirectAttributes.addFlashAttribute("error","Session Timeout !!! , Please Login Again");
		    
		    return "redirect:/";
		}
		
		}
	
	 @RequestMapping(value = "/loggedOut", method = RequestMethod.GET)
	  public String showReLogin(HttpServletRequest request, HttpServletResponse response) {
	  
	    return "loggedOut";
	  }
	 
	 
	 //Search Inventory Details
	/* @RequestMapping(value="/searchInventoryTypes", method=RequestMethod.GET)
	 public ModelAndView searchInventoryTypes(HttpServletRequest request, HttpServletResponse response) {
		 System.out.println("searchInventoryTypes=============================================>");
		 List<Depot> depotList=utilsService.getDepot();
		  ModelAndView mav = new ModelAndView("searchInventoryTypes");
		  mav.addObject("depotList",depotList);
		  return mav;
	 }*/
	 
	 //Status of inventory

	 
	 
	 @RequestMapping(value = { "/searchInventoryStatus"}, method = RequestMethod.GET)
		public ModelAndView searchInventoryStatus(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
			
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 List<Depot> depotList=utilsService.getDepot();
			 ModelAndView mav = new ModelAndView("searchInventoryStatus");
			 mav.addObject("depotList",depotList);
			return mav;
		}else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 
	 
	 @RequestMapping(value = { "/searchInventoryStatusProcess"}, method = RequestMethod.GET)
		public ModelAndView searchInventoryStatusL(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
			
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 List<Depot> depotList=utilsService.getDepot();
			 ModelAndView mav = new ModelAndView("searchInventoryStatus");
			 mav.addObject("depotList",depotList);
			return mav;
		}else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 
	 
	 @RequestMapping(value = { "/searchInventoryStatusProcess"}, method = RequestMethod.POST)
		public ModelAndView searchInventoryStatusProcess(ModelMap model,HttpSession session,HttpServletRequest request,@ModelAttribute("inventory") Inventory inventory) {
			System.out.println("searchInventoryStatus=============================================>");
			if(request.getSession(false).getAttribute("orgUnit")!=null){
				/*	List<Inventory> searchInventoryResult = inventoryService.searchInventoryStatus(inventory.getPartNo(), 
							inventory.getsPartNo(),inventory.getDescr(), inventory.getDepot(), inventory.getEquipment());*/
					
					List<Inventory> searchInventoryResult = inventoryService.searchInventoryStatus(inventory.getPartNo(), 
							inventory.getDescr(),inventory.getDepot(),inventory.getSku(), inventory.getEquipment(), inventory.getLedgerNo());
					
					List<Depot> depotList=utilsService.getDepot();
					 ModelAndView mav = new ModelAndView("searchInventoryStatus");
					  //ModelAndView mav = new ModelAndView("searchInventoryTypes");
					mav.addObject("partNo", inventory.getPartNo());
					mav.addObject("descr", inventory.getDescr());
					mav.addObject("depot", inventory.getDepot());
					mav.addObject("sku", inventory.getSku());
					mav.addObject("equipment", inventory.getEquipment());
					mav.addObject("depotList",depotList);
					mav.addObject("ledgerNo", inventory.getLedgerNo());					
					mav.addObject("searchInventoryResult",searchInventoryResult);
					return mav;
			}
			else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 
	 //advancedSearchInventoryStatusProcess
	 
	 @RequestMapping(value = { "/advancedSearchInventoryStatusProcess"}, method = RequestMethod.GET)
		public ModelAndView advancedSearchInventoryStatusProcessL(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
			
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 List<Depot> depotList=utilsService.getDepot();
			 ModelAndView mav = new ModelAndView("searchInventoryStatus");
			 mav.addObject("depotList",depotList);
			return mav;
		}else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 
	 @RequestMapping(value = { "/advancedSearchInventoryStatusProcess"}, method = RequestMethod.POST)
		public ModelAndView advancedSearchInventoryStatusProcess(ModelMap model,HttpSession session,HttpServletRequest request,@ModelAttribute("inventory") Inventory inventory) {
			System.out.println("advancedSearchInventoryStatusProcess=============================================>");
			if(request.getSession(false).getAttribute("orgUnit")!=null){
					String advancePartNo = request.getParameter("advancePartNo");
					String advDescr = request.getParameter("advDescr");
					String partRadio = request.getParameter("partRadio");
					
					System.out.println("rajdeo inventory.getAdvancePartNo() :: "+advancePartNo);
					System.out.println("rajdeo inventory.getAdvDescr() :: "+advDescr);
					System.out.println("rajdeo inventory.getPartRadio() :: "+partRadio);
					
					//List<Inventory> searchInventoryResult = inventoryService.advnacedSearchInventoryStatus(inventory.getAdvancePartNo(), inventory.getAdvDescr(), inventory.getPartRadio());
					List<Inventory> searchInventoryResult = inventoryService.advnacedSearchInventoryStatus(advancePartNo, advDescr, partRadio);
					
					/*for(int i=0; i<searchInventoryResult.size();i++) {
						System.out.println("searchInventoryResult :: "+searchInventoryResult.get(i));
					}*/
					
					List<Depot> depotList=utilsService.getDepot();
					 ModelAndView mav = new ModelAndView("searchInventoryStatus");
					mav.addObject("partNo", inventory.getPartNo());
					mav.addObject("descr", inventory.getDescr());
					mav.addObject("depot", inventory.getDepot());
					mav.addObject("sku", inventory.getSku());
					mav.addObject("equipment", inventory.getEquipment());
					mav.addObject("depotList",depotList);
					mav.addObject("ledgerNo", inventory.getLedgerNo());
					mav.addObject("advancePartNo", inventory.getAdvancePartNo());
					mav.addObject("advDescr", inventory.getAdvDescr());
					mav.addObject("partRadio",inventory.getPartRadio());
					
					mav.addObject("searchInventoryResult",searchInventoryResult);
					return mav;
			}
			else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
		
	 
	 	 
	 //Inventory Details
	 
	 
	 @RequestMapping(value = { "/searchInventoryDetails"}, method = RequestMethod.GET)
	 public ModelAndView searchInventoryDetails(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
					 List<Depot> depotList=utilsService.getDepot();
					 ModelAndView mav = new ModelAndView("searchInventoryDetails");
					 mav.addObject("depotList",depotList);
					return mav;
			}else{
					System.out.println("session invalidate ");
					session.invalidate();
				    ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    mav.addObject("error","Session Timeout !!! , Please Login Again");
				    return mav;
					
			}
			
		}
	 
	 
	 @RequestMapping(value = { "/searchInventoryDetailsProcess"}, method = RequestMethod.GET)
	 public ModelAndView searchInventoryDetailsP(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
					 List<Depot> depotList=utilsService.getDepot();
					 ModelAndView mav = new ModelAndView("searchInventoryDetails");
					 mav.addObject("depotList",depotList);
					return mav;
			}else{
					System.out.println("session invalidate ");
					session.invalidate();
				    ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    mav.addObject("error","Session Timeout !!! , Please Login Again");
				    return mav;
					
			}
			
		}
	 
	 
	 
	 
	 @RequestMapping(value = { "/searchInventoryDetailsProcess"}, method = RequestMethod.POST)
		public ModelAndView searchInventoryDetailsProcess(ModelMap model,HttpSession session,HttpServletRequest request,@ModelAttribute("inventory") Inventory inventory) {
		 System.out.println("searchInventoryDetails=============================================>");
			if(request.getSession(false).getAttribute("orgUnit")!=null){
					List<Inventory> searchInventoryResult = inventoryService.searchInventoryDetails(inventory.getPartNo(), 
							inventory.getDescr(), inventory.getDepot());
					 List<Depot> depotList=utilsService.getDepot();
					 ModelAndView mav = new ModelAndView("searchInventoryDetails");
					 mav.addObject("partNo", inventory.getPartNo());
					 mav.addObject("descr", inventory.getDescr());
					 mav.addObject("depot", inventory.getDepot());
					// mav.addObject("sPartNo", inventory.getsPartNo());
					// mav.addObject("equipment", inventory.getEquipment());
					 mav.addObject("depotList",depotList);
					 mav.addObject("searchInventoryResult",searchInventoryResult);
					return mav;
			}
			else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 
	
	 
	 //Inventory Last Purchase Price
	 
	 
	@RequestMapping(value = { "/searchInventoryLpp"}, method = RequestMethod.GET)
	public ModelAndView searchInventoryLpp(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 ModelAndView mav = new ModelAndView("searchInventoryLpp");
			 return mav;
		}else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
			
	}
	
	@RequestMapping(value = { "/searchInventoryLppProcess"}, method = RequestMethod.GET)
	public ModelAndView searchInventoryLppL(ModelMap model,HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 ModelAndView mav = new ModelAndView("searchInventoryLpp");
			 return mav;
		}else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
			
	}
	 
	 @RequestMapping(value = { "/searchInventoryLppProcess"}, method = RequestMethod.POST)
		public ModelAndView searchInventoryLppProcess(ModelMap model,HttpSession session,HttpServletRequest request,@ModelAttribute("inventory") Inventory inventory) {
		 System.out.println("searchInventoryLpp=============================================>");
			
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
				List<Inventory> searchInventoryResult = inventoryService.searchInventoryLpp(inventory.getPartNo(), 
						inventory.getDescr(), inventory.getEquipment(),inventory.getLedgerNo());
				ModelAndView mav = new ModelAndView("searchInventoryLpp");
				mav.addObject("partNo", inventory.getPartNo());
				mav.addObject("descr", inventory.getDescr());
				mav.addObject("equipment", inventory.getEquipment());
				mav.addObject("ledgerNo", inventory.getLedgerNo());
				mav.addObject("searchInventoryResult",searchInventoryResult);
				return mav;
		}
		 else{
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
				
		}
	}
	 

	 //Inventory Last Purchase Price
	 @RequestMapping(value="/searchInventoryLpp1", method=RequestMethod.GET)
	 public ModelAndView searchInventoryLpp1(HttpServletRequest request, HttpServletResponse response) {
		  ModelAndView mav = new ModelAndView("searchInventoryLpp");
		  return mav;
	 }
	 
	@RequestMapping(value="/searchCurrency", method=RequestMethod.GET)
	 public ModelAndView searchCurrency(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
		  ModelAndView mav = new ModelAndView("searchCurrency");
		  return mav;
		 }else{
			 System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
		 }
	 }
	 
	 @RequestMapping(value="/search_currency_page", method=RequestMethod.GET)
	 public ModelAndView searchCurrencyPage(HttpServletRequest request, HttpServletResponse response,HttpSession session, ModelMap model) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){	
		String currencyName =  request.getParameter("currencyName");
		System.out.println("currencyName :: "+currencyName);
		String currencyValue = request.getParameter("currencyValue");
		System.out.println("currencyValue :: "+currencyValue);
		
		List<CurrencyDTO> listObject =  searchCurrencyService.getSearchCurrency(currencyName);
		 ModelAndView mav = new ModelAndView("searchCurrency");
		 mav.addObject("listObject",listObject);
		 mav.addObject("currencyName",currencyName);
		 
		 return mav;
		 }else{
			 System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
		 }
	 }
	 
	 
	 @RequestMapping(value = { "/searchAllCurrency"}, method = RequestMethod.POST)
		public ModelAndView searchCurrencyAllProcess(
				RedirectAttributes redirectAttributes,
				HttpSession session,HttpServletRequest request) {
		 
		System.out.println("in search ALL currency controller .......");
		if(request.getSession(false).getAttribute("orgUnit")!=null){
		List<Currency> currencyList=utilsService.getCurrency();
		 
		ModelAndView mav = new ModelAndView("searchCurrency");
		mav.addObject("currencyList",currencyList);
		 
		return mav;
		}
		
		else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
		    
		    return mav;
		}
	 
	}
	 
	@RequestMapping(value = { "/searchAllCurrency"}, method = RequestMethod.GET)
		public ModelAndView searchCurrencyAllProcess1(
				RedirectAttributes redirectAttributes,
				HttpSession session,HttpServletRequest request) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
		  ModelAndView mav = new ModelAndView("searchCurrency");
		  return mav;
		 }
	 
		 
		 else {
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
			    
			    return mav;
			}
		 
		 
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = { "/deleteCurrencyPage"}, method = RequestMethod.GET)
		public String deleteCurrencyPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
			
		 System.out.println(" currency name in delete :: "+request.getParameter("currencyName"));
			 
		 String status = deleteCurrencyService.deleteCurrency(request.getParameter("currencyName"));
		 System.out.println("status in app controller :: "+status);
		 
		 if(status.equalsIgnoreCase("true")) {
			 redirectAttributes.addFlashAttribute("success"," Currency is deleted. ");
			 
			 return "redirect:/searchCurrency";
		 }else {
			 redirectAttributes.addFlashAttribute("error"," Currency will not deleted because it is already associated ");
			 return "redirect:/searchCurrency";
		 }
			 
		}
	 
	 @RequestMapping(value="/searchNAC", method=RequestMethod.GET)
	 public ModelAndView searchNAC(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
		 List<Depot> depotList=utilsService.getDepot();
		 ModelAndView mav = new ModelAndView("searchNAC");
		 mav.addObject("depotList", depotList);
		 return mav;
		 }else{
			 System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
		 }
	 }
	 
	 @RequestMapping(value="/search_NAC_Page", method=RequestMethod.GET)
		public ModelAndView searchNACPage1(HttpServletRequest request, HttpServletResponse response,HttpSession session, ModelMap model) {
			if(request.getSession(false).getAttribute("orgUnit")!=null){
				List<Depot> depotList=utilsService.getDepot();
			ModelAndView mav = new ModelAndView("searchNAC");
			mav.addObject("depotList", depotList);
			return mav;
		}else{
			System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error","Session Timeout !!! , Please Login Again");
			    return mav;
			}
		}
	 @RequestMapping(value="/search_NAC_Page", method=RequestMethod.POST)
	 public ModelAndView searchNACPage(HttpServletRequest request, HttpServletResponse response,HttpSession session, ModelMap model) {
		 if(request.getSession(false).getAttribute("orgUnit")!=null){
		
		 String partNo = request.getParameter("partNo");
		 String depot = request.getParameter("depot");
		 String fromDate = request.getParameter("fromDate");
		 String toDate = request.getParameter("toDate");
		 
		 List<NacItemDTO> listObjNacItemDTO =  searchNacService.getNacDetails(partNo, depot, fromDate, toDate);
	
		 List<Depot> depotList=utilsService.getDepot();
		 for(int i=0;i<listObjNacItemDTO.size();i++){
       System.out.println("Description ::: "+listObjNacItemDTO.get(i).getDepot());
       //System.out.println("Size ::: "+listObjNacItemDTO.get(i).getDescription().length());
		 }
		 ModelAndView mav = new ModelAndView("searchNAC");
		 mav.addObject("depotList", depotList);
		 mav.addObject("partNo", partNo);
		 mav.addObject("listObjNacItemDTO", listObjNacItemDTO);
		 mav.addObject("depot", depot);
		 mav.addObject("fromDate", fromDate);
		 mav.addObject("toDate", toDate);
		 return mav;
	 }else{
		 System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    mav.addObject("error","Session Timeout !!! , Please Login Again");
		    return mav;
		 }
	 }
	 

	 @RequestMapping(value = { "/addInventory"}, method = RequestMethod.GET)
	public ModelAndView addInventoryPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		
		if(request.getSession(false).getAttribute("orgUnit")!=null){
			
			List<Depot> depotList=utilsService.getDepot();
			List<Currency> currencyList=utilsService.getCurrency();
			List<Uom> uomList=utilsService.getUom();
			String sku=utilsService.getMaxSku();
			
			
			 ModelAndView mav=new ModelAndView("addInventory");
			 
			 mav.addObject("sku",sku);
		     mav.addObject("depotList",depotList);
			 mav.addObject("currencyList",currencyList);
			 mav.addObject("uomList",uomList);
			 mav.addObject("inventory",new Inventory());
			 System.out.println("ïnv ::  "+new Inventory());
			return mav;
		
	}
		
		else {
		System.out.println("session invalidate ");
		session.invalidate();
	    ModelAndView mav=new ModelAndView("login");
	    mav.addObject("user", new User());
	    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
	    
	    return mav;
	}
		//return "addInventory";
	}
	
	@RequestMapping(value = { "/addInventoryProcess"}, method = RequestMethod.POST)
	public ModelAndView addInventoryProcess(
			 RedirectAttributes redirectAttributes, @ModelAttribute("inventory") Inventory inventory,
			 HttpSession session,HttpServletRequest request) {
		
		System.out.println("inventory add process");
		List<Depot> depotList=utilsService.getDepot();
		List<Currency> currencyList=utilsService.getCurrency();
		List<Uom> uomList=utilsService.getUom();
		
		if(request.getSession(false).getAttribute("orgUnit")!=null){
		System.out.println("inventry.. "+inventory.getCurrency());
		System.out.println("currency .... "+request.getParameter("currency"));
		
		 int status = inventoryService.addInventory(inventory);
		   if(status==1)
		   {
			   ModelAndView mav=new ModelAndView("addInventory");
			     mav.addObject("depotList",depotList);
				 mav.addObject("currencyList",currencyList);
				 mav.addObject("uomList",uomList);
				// mav.addObject("inventory",new Inventory());
			   mav.addObject("success",MessageExtension.SUCCESS_UPDATE_MESSAGE);
       	    //redirectAttributes.addFlashAttribute("success",MessageExtension.SUCCESS_UPDATE_MESSAGE);
       	    //return "redirect:/addInventory";
       	    return mav;
		   } if(status==2) {
			   //List<Inventory> inv = new ArrayList<Inventory>();
			   //inv.add(inventory);
			     ModelAndView mav=new ModelAndView("addInventory");
			     System.out.println("inv size :: "+inventory.getSku());
			     mav.addObject("depotList",depotList);
				 mav.addObject("currencyList",currencyList);
				 mav.addObject("uomList",uomList);
			     mav.addObject("inventory",inventory);
			     System.out.println(inventory.getUom());
			     System.out.println(inventory.getDepot());
			     System.out.println(inventory.getCurrency());
			     mav.addObject("error",MessageExtension.DUPLICATE_MESSAGE);
			   //redirectAttributes.addFlashAttribute("error",MessageExtension.DUPLICATE_MESSAGE);
			   return mav;
	            //return "redirect:/addInventory";
       	    
       	    } else {
       	    	ModelAndView mav=new ModelAndView("addInventory");
       	    	mav.addObject("depotList",depotList);
				 mav.addObject("currencyList",currencyList);
				 mav.addObject("uomList",uomList);
       	    	mav.addObject("error",MessageExtension.ERROR_UPDATE_MESSAGE);
       	    // redirectAttributes.addFlashAttribute("error",MessageExtension.ERROR_UPDATE_MESSAGE);
       	     return mav;
       	    //return "redirect:/addInventory";
       }
		}
		
else {
			
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    mav.addObject("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
		    //return  "redirect:/";
		    return mav;
			}
			           
	}
	 @RequestMapping(value = { "/addInventoryProcess"}, method = RequestMethod.GET)
		public ModelAndView addInventoryPageProcee(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
				
				List<Depot> depotList=utilsService.getDepot();
				List<Currency> currencyList=utilsService.getCurrency();
				List<Uom> uomList=utilsService.getUom();
				
				String sku=utilsService.getMaxSku();
				
				
				 ModelAndView mav=new ModelAndView("addInventory");
				 
				 mav.addObject("sku",sku);
			     mav.addObject("depotList",depotList);
				 mav.addObject("currencyList",currencyList);
				 mav.addObject("uomList",uomList);
				 mav.addObject("inventory",new Inventory());
				 System.out.println("ïnv ::  "+new Inventory());
				return mav;
			
		}
			
			else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
		    
		    return mav;
		}
			//return "addInventory";
		}
	 
		@RequestMapping(value = { "/searchInventory"}, method = RequestMethod.GET)
		public String searchInventoryPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
			
			return "searchInventory";
		}
			
			else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
		    
		    return "redirect:/";
		}
			//return "searchInventory";
		}

		@RequestMapping(value = "/searchInventoryProcess", method = RequestMethod.GET)
		  public String searchInventoryProcess(Model model,HttpSession session,HttpServletRequest request,
				  RedirectAttributes redirectAttributes) {
		 
			 System.out.println("inventory search in process");
			 
			 
			 if(request.getSession(false).getAttribute("orgUnit")!=null){
					
					return "searchInventory";
				}
					
					else {
					System.out.println("session invalidate ");
					session.invalidate();
				    ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
				    
				    return "redirect:/";
				}
			
		}
		
		@RequestMapping(value = "/searchInventoryProcess", method = RequestMethod.POST)
		  public ModelAndView searchInventoryProcess(Model model,HttpSession session,HttpServletRequest request,
		 @ModelAttribute("inventory") Inventory inventory) {
		 
			 System.out.println("inventory search in process");
			 
			 
			 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 
				 System.out.println("inventory search in process :: " + inventory.getSku());
			 
	         List<Inventory> inventoryResult = inventoryService.viewInventory(inventory.getSku());
	         
	         
	         System.out.println("Size of inventoryResult :: "+inventoryResult.size());
		     ModelAndView mav = new ModelAndView("searchInventory");
		     mav.addObject("sku", inventory.getSku());
		     mav.addObject("inventoryResult",inventoryResult);
		  
		     return mav;
		     	   
		  }
			 
			 
			 else {
					
					System.out.println("session invalidate ");
					session.invalidate();
				    ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    mav.addObject("error","Session Timeout !!! , Please Login Again");
				    //redirectAttributes.addFlashAttribute("error","Session Timeout !!! , Please Login Again");
				    return mav;
					}
			
		}
		@RequestMapping(value = { "/updateInventory"}, method = RequestMethod.GET)
		public ModelAndView updateInventoryPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
				
				List<Depot> depotList=utilsService.getDepot();
				List<Currency> currencyList=utilsService.getCurrency();
				List<Uom> uomList=utilsService.getUom();
				
				 ModelAndView mav=new ModelAndView("updateInventory");
				 mav.addObject("depotList",depotList);
				 mav.addObject("currencyList",currencyList);
				 mav.addObject("uomList",uomList);
				return mav;
			
		}
			
			else {
			System.out.println("session invalidate ");
			session.invalidate();
		    ModelAndView mav=new ModelAndView("login");
		    mav.addObject("user", new User());
		    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
		    
		    return mav;
		}
			//return "addInventory";
		}
		
		@RequestMapping(value = { "/updateInventoryProcess"}, method = RequestMethod.POST)
		public String updateInventoryProcess(
				 RedirectAttributes redirectAttributes, @ModelAttribute("inventory") Inventory inventory,
				 HttpSession session,HttpServletRequest request) {
			
			System.out.println("inventory update process");
			
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
			
			 int status = inventoryService.updateInventory(inventory);
			   if(status==1)
			   {
	       	    redirectAttributes.addFlashAttribute("success",MessageExtension.SUCCESS_UPDATE_MESSAGE);
	       	    return "redirect:/searchInventory";
	       	 
	       	    } else {
	       	     redirectAttributes.addFlashAttribute("error",MessageExtension.ERROR_UPDATE_MESSAGE);
	       	    return "redirect:/updateInventory";
	       }
			}
			
	else {
				
				System.out.println("session invalidate ");
				session.invalidate();
			    ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    mav.addObject("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
			    return  "redirect:/";
				}
				       
		}
			
			
			@RequestMapping(value = { "/addCurrencyPage"}, method = RequestMethod.GET)
			public ModelAndView addCurrencyPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
				
			  System.out.println(" in add currency page ..");
			
			  if(request.getSession(false).getAttribute("orgUnit")!=null){
			 // String ip = request.getRemoteAddr();
			 
				 ModelAndView mav=new ModelAndView("addCurrencyPage");
				return mav;
			
			  }
			  
			  else {
					
					System.out.println("session invalidate ");
					session.invalidate();
					ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
				    return mav;
			
			  
				}
			}


		@RequestMapping(value = { "/addCurrencyPageProcess"}, method = RequestMethod.POST)
			public  String addCurrencyPageProcess(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
				
			 System.out.println(" in add currency page process ..");
			 
			 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 String currencyName = request.getParameter("currencyName");
				String currencyValue = request.getParameter("currencyValue");
			 System.out.println("....currencyName "+currencyName);
			 System.out.println("c name :: "+currencyValue);
				Currency currency =new Currency();
				currency.setCurrencyName(currencyName);
				
				
				currency.setCurrencyValue(currencyValue);
				
				System.out.println("....currencyName "+currency.getCurrencyName());
				 System.out.println("c name :: "+currency.getCurrencyValue());
			 
			 String status = addCurrencyService.addCurrency(currency);
			 
			 System.out.println("status :: "+status);
			 
			 int statusint=	Integer.parseInt(status);
			 
			 if(statusint==1) {
					System.out.println(" in status ==1 ");
					redirectAttributes.addFlashAttribute("success"," Data has been successfully Added ");
					 return "redirect:/addCurrencyPage";
					
				}
			 else{
				redirectAttributes.addFlashAttribute("error"," Data Not Added ");
				 return "redirect:/addCurrencyPage";
			 }
			 
			 }
			 
			 else{

					System.out.println("session invalidate ");
					session.invalidate();
					ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
				    return  "redirect:/";
			
				 
			 }
			
			 
			 
			
				}


		@RequestMapping(value = { "/editCurrencyPage"}, method = RequestMethod.GET)
			public ModelAndView editCurrencyPage(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
				
			 System.out.println(" in edit currency page ..");
			 
			 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 
			 System.out.println(" currency name in edit page :: "+request.getParameter("currencyName"));
			 System.out.println(" currency value  in edit page :: "+request.getParameter("currencyValue"));
				 ModelAndView mav=new ModelAndView("editCurrencyPage");
				 mav.addObject("currencyName", request.getParameter("currencyName"));
				 mav.addObject("currencyValue", request.getParameter("currencyValue"));
				return mav;
			
				}
		  
		  
		  else {
				
				System.out.println("session invalidate ");
				session.invalidate();
				ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
			    return mav;
		
		  
			}
		}


		@RequestMapping(value = { "/editCurrencyPageProcess"}, method = RequestMethod.POST)
			public String editCurrencyPageProcess(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {
				
			 System.out.println(" in add currency page process ..");
			 
			 if(request.getSession(false).getAttribute("orgUnit")!=null){
			 
			 String status=null;
			 
			 String jsp="";
			Map<String, Object> map = new HashMap<String, Object>();
				ModelAndView modelAndView = new ModelAndView(jsp);
				System.out.println("actual currency name :: "+request.getParameter("actualCurrencyName"));
			String actualCurrencyName=request.getParameter("actualCurrencyName");
				String currencyName = request.getParameter("currencyName");
				System.out.println("currency name :: "+currencyName);
				String currencyValue = request.getParameter("currencyValue");
				
				Currency currency =new Currency();
				currency.setCurrencyName(currencyName);
				
				
				currency.setCurrencyValue(currencyValue);
				
				System.out.println("currency value :: "+currencyValue);
				
				String status1 = editCurrencyService.editCurrency(currency);
				 
				 System.out.println("status :: "+status1);
				 int statusint=	Integer.parseInt(status1);
				 if(statusint==1) {
						System.out.println(" in status ==1 ");
						redirectAttributes.addFlashAttribute("success"," Data has been successfully Updated ");
						 return "redirect:/searchCurrency";
						
					}
					redirectAttributes.addFlashAttribute("error"," Data Not Updated ");
					 return "redirect:/searchCurrency";
					
			 }
			 else{

					System.out.println("session invalidate ");
					session.invalidate();
					ModelAndView mav=new ModelAndView("login");
				    mav.addObject("user", new User());
				    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
				    return  "redirect:/";
			
				 
			 }
				
		}
		
		
		@RequestMapping(value = "/duplicateCurrencyName", method = RequestMethod.GET)
		public @ResponseBody String getAllmilestoneStagesForContract(@RequestParam(value="name",required=true)String name1,HttpSession session ,HttpServletRequest request,HttpServletResponse response,@ModelAttribute("searchparameters") Currency searchparameters,RedirectAttributes redirectAttributes){
			
			
			//System.out.println(" in all milestone @@@@@@    app coontroller "+request.getParameter("id"));
			
			System.out.println("name .. "+name1);
			
			if(request.getSession(false).getAttribute("orgUnit")!=null){
			
	String name2[]=name1.split(",");
	System.out.println(" name2[1] .... "+name2[1]);
			
	System.out.println(" milestone for contract type ..   "+name1);
	
			List<String> status=duplicateNameService.DuplicateName(request.getParameter("name1"));
			System.out.println(" list size of milestone... :: "+status.size());
			for(int i=0;i<status.size();i++){
				System.out.println("nnnnn .......... "+status);
				//if(name2[1].equalsIgnoreCase(name2[1])){
				
				String name3 = name2[1].toUpperCase();
				
				if(status.contains(name3)){
					
				
					System.out.println("duplicate currency ignore case  .... "+name2[1].equalsIgnoreCase(name2[1]));
						System.out.println("duplicate currency status.get(i) .... "+status.get(i));
					System.out.println("duplicate currency .... "+name2[1]);
					return "yes";
					//}
				//}
				}
				else{
					System.out.println(" NO duplicate currency .... ");
				return "no";
				}
			}return "no";
			}
			else{

				System.out.println("session invalidate ");
				session.invalidate();
				ModelAndView mav=new ModelAndView("login");
			    mav.addObject("user", new User());
			    redirectAttributes.addFlashAttribute("error",MessageExtension.SESSION_TIMEOUT_MESSAGE);
			    return  "redirect:/";
		
			 
		 }
		}
		
			
		@RequestMapping(value="/refrenceForLPP", method= RequestMethod.GET)	
		 public ModelAndView refrenceForLPP(ModelMap model,HttpSession session,HttpServletRequest request,RedirectAttributes redirectAttributes) {		 
			 
			 String sku = request.getParameter("sku");
			 
			 System.out.println("sku :: "+sku);
			 List<RefrenceForLLP> listOfRefForLLP = refrenceForLLPService.refrenceForLPP(sku);
			 System.out.println("referenceForLLP si :: "+listOfRefForLLP.size());
			 ModelAndView mav = new ModelAndView("refrenceForLPP");
			
			 mav.addObject("listOfRefForLLP", listOfRefForLLP);				 
		
			 return mav;
		 }

		
		}
		
