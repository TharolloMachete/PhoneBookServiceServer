package za.co.phonebook.ws;

import java.util.List;
import za.co.phonebook.db.impl.DatabaseControl;
import za.co.phonebook.model.PhoneBook;

public class PhoneBookWebService {
	
	public String addPhoneBook(String name , String phoneNumber) {
		
		DatabaseControl dbc = new DatabaseControl();
		PhoneBook pb = new PhoneBook(name , phoneNumber);
        dbc.insertData(pb);
        
		return pb.toString();
	}
	
	public List<PhoneBook> viewPhoneBook(String name) {

        DatabaseControl dbc = new DatabaseControl();

		return dbc.viewData(name);
	}
}
