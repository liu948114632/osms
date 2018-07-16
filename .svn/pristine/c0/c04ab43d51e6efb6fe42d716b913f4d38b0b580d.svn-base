package com.itecheasy.osms.user;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.user.Department;
import com.itecheasy.core.user.Licence;
import com.itecheasy.core.user.Right;
import com.itecheasy.core.user.RightGroup;
import com.itecheasy.core.user.Role;
import com.itecheasy.core.user.User;

/**
 * @author wanghw
 * @date 2014-9-3 上午8:44:08
 * @description TODO
 */
@WebService
public interface ProfileWebService {

	public List<User> getUnBindedUserBuRole(@WebParam(name = "roleId") int roleId);

	public Role addRole(@WebParam(name = "role") Role role) throws BussinessException;

	void setUserDisabled(@WebParam(name = "userId")int userId,@WebParam(name = "disabled")boolean disabled);
	public void deleteRole(@WebParam(name = "roleId") int roleID)throws BussinessException;
	
	List<User> getAllEnableUser();
	
	public List<Department> getAllDepartment();

	public List<Right> getAllRight();

	public List<RightGroup> getAllRightGroup();

	public List<Role> getAllRole();

	public List<User> getAllUser();
	
	public List<User> findUsers(@WebParam(name = "disabled")int disabled);

	public List<Right> getBindedRightByRole(@WebParam(name = "roleId") int roleID);

	public List<User> getBindedUserByRole(@WebParam(name = "roleId") int roleID);

	public List<User> getBindedUsersByDepartment(@WebParam(name = "departmentID") int departmentID);

	public Department getDepartmentByID(@WebParam(name = "departmentID") int departmentID);

	public List<Department> getBindedDepartmentByUser(@WebParam(name = "userID") int userID);

	public Role getRoleByID(@WebParam(name = "roleID") int roleID);

	public List<Role> getRoleByUserBinded(@WebParam(name = "userID") int userID);

	public User getUserByCode(@WebParam(name = "code") String code);

	public List<Right> getRightByUser(@WebParam(name = "userID") int userID);

	public List<User> getUserByRight(@WebParam(name = "rightID") int rightID);

	public void isMachineAuthorized(@WebParam(name = "macAddress") String macAddress) throws BussinessException;

	public User login(@WebParam(name = "code") String code, @WebParam(name = "password") String password,
			@WebParam(name = "mac") String mac) throws BussinessException;

	public void setRightToRole(@WebParam(name = "roleID") int roleID, @WebParam(name = "rightIDs") int[] rightIDs);

	public void setUserToRole(@WebParam(name = "roleID") int roleID, @WebParam(name = "userIDs") int[] userIDs);

	public void setUserToDepartment(@WebParam(name = "userID") int userID,
			@WebParam(name = "departmentIDs") int[] departmentIDs);

	public void setRoleToUser(@WebParam(name = "userID") int userID, @WebParam(name = "roleIDs") int[] roleIDs);

	public void updateRole(@WebParam(name = "role") Role role) throws BussinessException;

	public List<User> getUserByRightCode(@WebParam(name = "rightCode") String rightCode);

	public void copyUserRole(@WebParam(name = "originalUserId") int originalUserId,
			@WebParam(name = "newUserId") int newUserId) throws BussinessException;

	public Licence getLicenceById(@WebParam(name = "id") Integer id);

	public Licence getLicenceByMac(@WebParam(name = "mac") String mac);

	public PageList<Licence> findLicence(@WebParam(name = "pageSize") int pageSize,
			@WebParam(name = "currentPage") int currentPage,
			@WebParam(name = "userCode") String userCode, @WebParam(name = "mac") String mac);

	public void addLicence(@WebParam(name = "licence") Licence licence) throws BussinessException;

	public int addUser(@WebParam(name = "code") String code) throws BussinessException;

	public User getUserByID(@WebParam(name = "userID") Integer userID);

	public void deleteUser(@WebParam(name = "userID") Integer userID);
	
	public void deleteLicence(int licenceId);

	public void updateLicence(Licence licence);

}
