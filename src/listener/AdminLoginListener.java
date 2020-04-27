package listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.systop.dao.AdminLoginDao;
import com.systop.daoimpl.AdminLoginDaoImpl;
import com.systop.entity.Admin;

/**
 * Application Lifecycle Listener implementation class AdminLoginListener
 *
 */
@WebListener
public class AdminLoginListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public AdminLoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	if("admin".equals(arg0.getName())) {
    		Admin admin=(Admin)arg0.getValue();
    		AdminLoginDao ald= new AdminLoginDaoImpl();
    		int row=ald.adminLoginAdd(admin.getAdmin(),admin.getIp().toString(), new Date());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
