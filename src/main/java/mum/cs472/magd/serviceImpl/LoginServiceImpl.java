package mum.cs472.magd.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mum.cs472.magd.dao.GenericDao;
import mum.cs472.magd.entity.Login;
import mum.cs472.magd.service.LoginService;

@Controller
public class LoginServiceImpl implements LoginService{

	@Autowired 
	private GenericDao dao;
	@Override
	public List<Login> getLoginDetails(Login login) {
		String query = "SELECT USERNAME,PASSWORD FROM LOGIN WHERE USERNAME=? AND PASSWORD = ? ";
		List<Login> loginList = new ArrayList<>();
		
		loginList = dao.getData(query,new Object[]{login.getUserName(),login.getPassword()});
		return loginList;
	}

}
