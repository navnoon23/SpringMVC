package poc.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

	private static ArrayList<String> list = new ArrayList<String>();
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");

	@RequestMapping(value ="todo/list.do", method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
		model.put("curtime", sdf.format(new Date()));
		model.put("list", list);

		return "/WEB-INF/jsp/todo.jsp";
	}
	
	@RequestMapping(value = "todo/add.do", method = RequestMethod.POST)
	public String add( @RequestParam String item, Map<String, Object> model) {
		model.put("curtime", sdf.format(new Date()));
		item = item.trim().replace('"', ' ');
		item = item.trim().replace('\'', ' ');
		// verify item is not already in the list before adding
		if(item.trim().length() > 0 && !list.contains(item)) {
			list.add(item);
		}
		model.put("list", list);
		
		return "/WEB-INF/jsp/todo.jsp";
	}

	@RequestMapping(value = "todo/delete.do", method = RequestMethod.POST)
	public String delete( @RequestParam String item, Map<String, Object> model) {
		model.put("curtime", sdf.format(new Date()));
		// remove item if exists, ignore if not
		list.remove(item);
		model.put("list", list);
		
		return "/WEB-INF/jsp/todo.jsp";
	}
}
