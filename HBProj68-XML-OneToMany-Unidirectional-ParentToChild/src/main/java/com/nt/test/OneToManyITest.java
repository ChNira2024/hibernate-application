package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOImpl;

public class OneToManyITest {
	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=new OneToManyDAOImpl();
		//use DAO
		//dao.saveDataUsingParent();
		dao.loadDataUsingParent();
		//dao.addNewChildToExistingParent();
		//dao.deletingAParentAndItsChilds();
		//dao.deleteAllParentsAndTheirChilds();
		//dao.deleteAllParentsAndTheirChilds1();
		//dao.deleteAllChildsOfAParent();
		//dao.deleteOneChildFromCollectionOfChildsFromAParent();
		//dao.transferOneChildOfOneParentToAnotherParent();
		
	}//main
}//class
