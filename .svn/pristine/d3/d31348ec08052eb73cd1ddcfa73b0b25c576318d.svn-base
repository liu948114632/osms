package com.itecheasy.osms.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.user.Department;
import com.itecheasy.core.user.Licence;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.core.user.Right;
import com.itecheasy.core.user.RightGroup;
import com.itecheasy.core.user.Role;
import com.itecheasy.core.user.User;
import com.itecheasy.core.user.ProfileService.LicenceSearchCriteria;
import com.itecheasy.osms.user.ProfileWebService;

/**
 * @author wanghw
 * @date 2014-9-3 上午8:59:16
 * @description
 */
public class ProfileWebServiceImpl implements ProfileWebService {
	private ProfileService profileService;

	public final void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	@Override
	public Role addRole(Role role) throws BussinessException {
		Integer roleID = profileService.addRole(role);
		return profileService.getRoleByID(roleID);
	}

	@Override
	public List<User> getAllEnableUser() {
		return profileService.getAllEnableUser();
	}

	@Override
	public void setUserDisabled(int userId, boolean disabled) {
		profileService.setUserDisabled(userId, disabled);
	}

	@Override
	public void deleteRole(int roleID) throws BussinessException {
		profileService.deleteRole(roleID);
	}

	@Override
	public List<Department> getAllDepartment() {
		return profileService.getAllDepartment();
	}

	@Override
	public List<Right> getAllRight() {
		return profileService.getAllRight();
	}

	@Override
	public List<RightGroup> getAllRightGroup() {
		return profileService.getAllRightGroup();
	}

	@Override
	public List<Role> getAllRole() {
		return profileService.getAllRole();
	}

	@Override
	public List<User> getAllUser() {
		return profileService.getAllUser();
	}
	
	@Override
	public List<User> findUsers(int disabled) {
		return null;
	}

	@Override
	public List<Right> getBindedRightByRole(int roleID) {
		return profileService.getBindedRightByRole(roleID);
	}

	@Override
	public List<User> getBindedUserByRole(int roleID) {
		return profileService.getBindedUserByRole(roleID);
	}

	@Override
	public List<User> getBindedUsersByDepartment(int departmentID) {
		return profileService.getBindedUsersByDepartment(departmentID);
	}

	@Override
	public Department getDepartmentByID(int departmentID) {
		return profileService.getDepartmentByID(departmentID);
	}

	@Override
	public List<Department> getBindedDepartmentByUser(int userID) {
		return profileService.getBindedDepartmentByUser(userID);
	}

	@Override
	public Role getRoleByID(int roleID) {
		return profileService.getRoleByID(roleID);
	}

	@Override
	public List<Role> getRoleByUserBinded(int userID) {
		return profileService.getBindedRoleByUser(userID);
	}

	@Override
	public User getUserByCode(String code) {
		return profileService.getUserByCode(code);
	}

	@Override
	public List<Right> getRightByUser(int userID) {
		List<Role> roles = profileService.getBindedRoleByUser(userID);
		List<Right> rights = new ArrayList<Right>();
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				List<Right> roleRights = profileService.getBindedRightByRole(role.getId());
				for (Right right : roleRights) {
					rights.add(right);
				}
			}
		}
		return rights;
	}

	@Override
	public List<User> getUserByRight(int rightID) {
		return profileService.getUserByRight(rightID);
	}

	@Override
	public void isMachineAuthorized(String macAddress) throws BussinessException {
		profileService.isMachineAuthorized(macAddress);

	}

	@Override
	public User login(String code, String password, String mac) throws BussinessException {
		profileService.login(code, password, mac);
		return profileService.getUserByCode(code);
	}

	@Override
	public void setRightToRole(int roleID, int[] rightIDs) {
		List<Integer> rightIDList = CollectionUtils.array2List(rightIDs);
		profileService.setRightToRole(roleID, rightIDList);
	}

	@Override
	public void setUserToRole(int roleID, int[] userIDs) {
		List<Integer> userIDList = CollectionUtils.array2List(userIDs);
		profileService.setUserToRole(roleID, userIDList);
	}

	@Override
	public void setUserToDepartment(int userID, int[] departmentIDs) {
		List<Integer> departmentIDList = CollectionUtils.array2List(departmentIDs);
		profileService.setUserToDepartment(userID, departmentIDList);
	}

	@Override
	public void setRoleToUser(int userID, int[] roleIDs) {
		List<Integer> roleIDList = CollectionUtils.array2List(roleIDs);
		profileService.setRoleToUser(userID, roleIDList);
	}

	@Override
	public void updateRole(Role role) throws BussinessException {
		profileService.updateRole(role);

	}

	@Override
	public List<User> getUserByRightCode(String rightCode) {
		return profileService.getUserByRightCode(rightCode);
	}

	@Override
	public void copyUserRole(int originalUserId, int newUserId) throws BussinessException {
		// 1.角色
		List<Role> roles = profileService.getBindedRoleByUser(originalUserId);
		if (CollectionUtils.isNotEmpty(roles)) {
			List<Integer> roleIDs = new ArrayList<Integer>();
			for (Role role : roles) {
				roleIDs.add(role.getId());
			}
			profileService.setRoleToUser(newUserId, roleIDs);
		}
		// 2.部门
		List<Department> departments = profileService.getBindedDepartmentByUser(originalUserId);
		if (CollectionUtils.isNotEmpty(departments)) {
			List<Integer> departmentIDs = new ArrayList<Integer>();
			for (Department d : departments) {
				departmentIDs.add(d.getId());
			}
		}

	}

	@Override
	public Licence getLicenceById(Integer id) {
		return profileService.getLicenceById(id);
	}

	@Override
	public Licence getLicenceByMac(String mac) {
		return profileService.getLicenceByMac(mac);
	}

	@Override
	public PageList<Licence> findLicence(int pageSize, int currentPage, String userCode, String mac) {
		Map<LicenceSearchCriteria, Object> searchCriteria = new HashMap<ProfileService.LicenceSearchCriteria, Object>();

		if (!StringUtils.isEmpty(userCode)) {
			searchCriteria.put(LicenceSearchCriteria.USERCODE, userCode);
		}
		if (!StringUtils.isEmpty(mac)) {
			searchCriteria.put(LicenceSearchCriteria.MAC, mac);
		}
		return profileService.findLicence(pageSize, currentPage, searchCriteria);
	}

	@Override
	public void addLicence(Licence licence) throws BussinessException {
		profileService.addLicence(licence);
	}

	@Override
	public int addUser(String code) throws BussinessException {
		return profileService.addUser(code);
	}

	@Override
	public User getUserByID(Integer userID) {
		return profileService.getUserByID(userID);
	}

	@Override
	public void deleteUser(Integer userID) {
		profileService.deleteUser(userID);
	}

	@Override
	public List<User> getUnBindedUserBuRole(int roleId) {
		return profileService.getUnBindedUserBuRole(roleId);
	}

	@Override
	public void deleteLicence(int licenceId) {
		profileService.deleteLicence(licenceId);
	}

	@Override
	public void updateLicence(Licence licence) {
		profileService.updateLicence(licence);
	}
}
