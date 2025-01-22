package com.rays.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.MarksheetDTO;
import com.rays.dto.UserDTO;

/**
 * Base controller class contains get, search, save, delete REST APIs.
 * 
 * Suraj Sahu
 */
public abstract class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

    /**
     * Form operations
     */
    protected static final String OP_SAVE = "Save";
    protected static final String OP_NEW = "New";
    protected static final String OP_DELETE = "Delete";
    protected static final String OP_CANCEL = "Cancel";
    protected static final String OP_ERROR = "Error";
    protected static final String OP_NEXT = "Next";
    protected static final String OP_PREVIOUS = "Previous";
    protected static final String OP_LOGOUT = "Logout";
    protected static final String OP_GO = "Go";
    protected static final String OP_GET = "Get";

    @Autowired
    protected S baseService;

    @Value("${page.size}")
    private int pageSize = 0;

    /**
     * Contains context of logged-in user.
     */
    protected UserContext userContext = null;

    /**
     * Retrieves the user context from the HTTP session. If the user context is not present,
     * it initializes a default user context with predefined values.
     * 
     * @param session The HTTP session from which the user context is retrieved.
     */
    @ModelAttribute
    public void setUserContext(HttpSession session) {
        System.out.println("inside setUserContext  inside BaseCtl --");
        userContext = (UserContext) session.getAttribute("userContext");
        if (userContext == null) {
            UserDTO dto = new UserDTO();
            dto.setLoginId("root@sunilos.com");
            dto.setFirstName("demo firstName");
            dto.setLastName("demo lastName");
            dto.setOrgId(0L);
            dto.setRoleId(1L);
            dto.setOrgName("root");
            userContext = new UserContext(dto);
        }
    }

    /**
     * Default get mapping.
     * 
     * @return An ORSResponse object containing a success message and current date.
     */
    @GetMapping
    public ORSResponse get() {
        System.out.println("BaseCtl Get() method run");
        ORSResponse res = new ORSResponse(true);
        res.addData("I am okay " + this.getClass() + " --" + new Date());
        return res;
    }

    /**
     * Get entity by primary key ID.
     * 
     * @param id The primary key ID of the entity to retrieve.
     * @return An ORSResponse object containing the retrieved entity or an error message if not found.
     */
    @GetMapping("get/{id}")
    public ORSResponse get(@PathVariable long id) {
        System.out.println("BaseCtl Get() method run.......Suraj");
        ORSResponse res = new ORSResponse(true);
        T dto = baseService.findById(id, userContext);

        if (dto != null) {
            res.addData(dto);
        } else {
            res.setSuccess(false);
            res.addMessage("Record not found");
        }
        System.out.println("Edit response :" + res);
        return res;
    }

    /**
     * Delete entities by primary key IDs.
     * 
     * @param ids Array of primary key IDs to delete.
     * @param pageNo Page number for pagination.
     * @param form Form data containing search criteria.
     * @return An ORSResponse object containing the result of the deletion operation.
     */
    @PostMapping("deleteMany/{ids}")
    public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo, @RequestBody F form) {
        System.out.println("BaseCtl DeleteMany() method....Suraj... run");
        ORSResponse res = new ORSResponse(true);
        try {
            for (String id : ids) {
                System.out.println("Records To be Deleted :: " + id);
                baseService.delete(Long.parseLong(id), userContext);
            }
            T dto = (T) form.getDto();
            List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);
            res.addData(list);
            res.setSuccess(true);
            res.addMessage("Records Deleted Successfully");
            System.out.println("Records Deleted Successfully by Suraj");
        } catch (Exception e) {
            System.out.println("Exception in deleteMany: " + e.getMessage());
            e.printStackTrace();
            res.setSuccess(false);
            res.addMessage(e.getMessage());
        }
        return res;
    }

    /**
     * Search entities by form attributes.
     * 
     * @param form The form data containing search criteria.
     * @return An ORSResponse object containing the search results.
     */
    @RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
    public ORSResponse search(@RequestBody F form) {
        System.out.println("BaseCtl Search Running");
        // Calculate next page number
        String operation = form.getOperation();
        int pageNo = form.getPageNo();

        if (OP_NEXT.equals(operation)) {
            pageNo++;
        } else if (OP_PREVIOUS.equals(operation)) {
            pageNo--;
        }

        // 0 is first page index
        pageNo = (pageNo < 0) ? 0 : pageNo;
        form.setPageNo(pageNo);
        System.out.println("Page No is :: " + pageNo + "   Page size is :: " + pageSize);
        T dto = (T) form.getDto();
        ORSResponse res = new ORSResponse(true);
        res.addData(baseService.search(dto, pageNo, pageSize, userContext));
        return res;
    }

    /**
     * Search entities with pagination using the provided page number.
     * 
     * @param form The form data containing search criteria.
     * @param pageNo The page number for pagination.
     * @return An ORSResponse object containing the search results and the size of the next page.
     */
    @RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
    public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {
        /* Called on loading, next, previous and search operation * */
        System.out.println("BaseCtl Search method with pageNo :: " + pageNo + "   Page size is :: " + pageSize);

        // 0 is first page index
        pageNo = (pageNo < 0) ? 0 : pageNo;

        System.out.println("Operation :: " + form.getOperation());

        T dto = (T) form.getDto();

        ORSResponse res = new ORSResponse(true);

        res.addData(baseService.search(dto, pageNo, pageSize, userContext));

        List nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);
        res.addResult("nextList", nextList.size());
        return res;
    }

    /**
     * Save or update the entity.
     * 
     * @param form The form data containing the entity to be saved or updated.
     * @param bindingResult The result of binding form data to the entity, including validation errors.
     * @return An ORSResponse object containing the result of the save or update operation.
     */
    @PostMapping("/save")
	public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {
		System.out.println("228save() run in BaseCtl :: +Suraj " + form);
		ORSResponse res = validate(bindingResult);
		if (res.isSuccess() == false) {
			return res;
		}
		try {
			System.out.println("try block in save.>>>>>>>");
			T dto = (T) form.getDto();
			System.out.println("237----------->" + dto);
			if (dto.getId() != null && dto.getId() > 0) {
				System.out.println();
				String uniqueKey = dto.getUniqueKey();
			    String uniqueValue = dto.getUniqueValue();
			    T existDto1 = null ;
			    if (uniqueValue != null && !"null".equals(uniqueValue)) {
			        existDto1 = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
			    }
			    
				System.out.println("If block in save >>>>>>" + existDto1);
				if (existDto1 != null && dto.getId() != existDto1.getId()) {
					System.out.println("if block already exist");
					res.addData(dto);
					res.addMessage(dto.getLabel() + " already exist");
					res.setSuccess(false);
					return res;
				}
				baseService.update(dto, userContext);
			} else {
				System.out.println("before calling add of baseservice");
				if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {
					System.out.println("else block>>>>>>" + dto.getUniqueKey()+"="+dto.getUniqueValue());
				    String uniqueValue = dto.getUniqueValue();
				    T existDto = null ;
				    if (uniqueValue != null && !"null".equals(uniqueValue)) {
				        existDto = (T) baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
				    }
					if (existDto != null) {
						System.out.println("247----------->" + existDto);
						res.addData(dto);
						res.addMessage(dto.getLabel() + " already exist");
						res.setSuccess(false);
						return res;
					}
				}
				baseService.add(dto, userContext);
			}
			res.addData(dto.getId());
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

    /**
     * Gets input error messages and puts them into the REST response.
     * 
     * @param bindingResult The result of binding form data to the entity, including validation errors.
     * @return An ORSResponse object containing input errors if validation fails.
     */
    public ORSResponse validate(BindingResult bindingResult) {
        ORSResponse res = new ORSResponse(true);
        System.out.println("inside the validate method of baseCtl");
        if (bindingResult.hasErrors()) {
            System.out.println("BaseCtl ki validate ke error block me");
            res.setSuccess(false);
            Map<String, String> errors = new HashMap<String, String>();
            List<FieldError> list = bindingResult.getFieldErrors();
            // Lambda expression Java 8 feature
            list.forEach(e -> {
                errors.put(e.getField(), e.getDefaultMessage());
                System.out.println("Field :: " + e.getField() + "  Message :: " + e.getDefaultMessage());
            });
            res.addInputErrors(errors);
        }
        return res;
    }
}
