package com.itecheasy.core.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.itecheasy.common.PageList;
import com.itecheasy.common.dao.Criteria;
import com.itecheasy.common.dao.Restriction;
import com.itecheasy.common.dao.Order.OrderType;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.CollectionUtils.Equaltor;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.po.DepartmentPO;
import com.itecheasy.core.po.LicencePO;
import com.itecheasy.core.po.RightGroupPO;
import com.itecheasy.core.po.RightPO;
import com.itecheasy.core.po.RolePO;
import com.itecheasy.core.po.RoleRightPO;
import com.itecheasy.core.po.UserDepartmentPO;
import com.itecheasy.core.po.UserPO;
import com.itecheasy.core.po.UserRolePO;
import com.itecheasy.core.user.dao.DepartmentDAO;
import com.itecheasy.core.user.dao.LicenceDAO;
import com.itecheasy.core.user.dao.RightDAO;
import com.itecheasy.core.user.dao.RightGroupDAO;
import com.itecheasy.core.user.dao.RoleDAO;
import com.itecheasy.core.user.dao.RoleRightDAO;
import com.itecheasy.core.user.dao.UserDAO;
import com.itecheasy.core.user.dao.UserDepartmentDAO;
import com.itecheasy.core.user.dao.UserRoleDAO;
import com.itecheasy.webservice.client.OAWebService;
import com.itecheasy.webservice.oa.UserModel;

/**
 * @author wanghw
 * @date 2014-9-2 下午3:01:43
 * @description TODO
 */
public class ProfileServiceImpl implements ProfileService {
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private RightDAO rightDAO;
	private RightGroupDAO rightGroupDAO;
	private DepartmentDAO departmentDAO;
	private UserDepartmentDAO userDepartmentDAO;
	private UserRoleDAO userRoleDAO;
	private RoleRightDAO roleRightDAO;
	private LicenceDAO licenceDAO;

	public final void setLicenceDAO(LicenceDAO licenceDAO) {
		this.licenceDAO = licenceDAO;
	}

	public final void setRoleRightDAO(RoleRightDAO roleRightDAO) {
		this.roleRightDAO = roleRightDAO;
	}

	public final void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	public final void setUserDepartmentDAO(UserDepartmentDAO userDepartmentDAO) {
		this.userDepartmentDAO = userDepartmentDAO;
	}

	public final void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public final void setRightGroupDAO(RightGroupDAO rightGroupDAO) {
		this.rightGroupDAO = rightGroupDAO;
	}

	public final void setRightDAO(RightDAO rightDAO) {
		this.rightDAO = rightDAO;
	}

	public final void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public final void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public String getUserNameById(int userId){
		User u=this.getUserByID(userId);
		if(u!=null)
			return u.getName();
		return null;
	}

	@Override
	public int addUser(String code) throws BussinessException {
		User user = this.getUserByCode(code);
		if (user == null) {
			UserModel userModel = OAWebService.getUserModel(code);
			if (userModel != null && userModel.getIsValid() == 2) {
				UserPO po = new UserPO();
				po.setCode(code);
				po.setEmail(userModel.getEmail());
				po.setName(userModel.getName());
				int id = userDAO.addObject(po);
				return id;
			} else {
				throw new BussinessException(ERROR_WORKNO_IS_NOT_EXISTS);
			}
		} else {
			throw new BussinessException(ERROR_USER_IS_EXISTS);
		}
	}
	
	@Override
	public int addUser(String code, boolean disabled) {
		User user = this.getUserByCode(code);
		if (user == null) {
			UserModel userModel = OAWebService.getUserModel(code);
			if (userModel != null) {
				UserPO po = new UserPO();
				po.setCode(code);
				po.setEmail(userModel.getEmail());
				po.setName(userModel.getName());
				po.setDisabled(disabled);
				int id = userDAO.addObject(po);
				return id;
			} else {
				return 0;
			}
		} else {
		}
		return user.getId();
	}

	@Override
	public void setUserDisabled(int userId, boolean disabled) {
		UserPO user = userDAO.getObject(userId);
		user.setDisabled(disabled);
	}
	
	@Override
	public List<User> getAllUser() {
		String hql = "FROM UserPO o ORDER BY o.id ASC";
		List<UserPO> users = userDAO.findListByHql(hql);
		List<User> uList = BeanUtils.copyList(users, User.class);
		return uList;
	}
	
	@Override
	public List<User> getAllEnableUser() {
		String hql = "FROM UserPO o where o.disabled=false ORDER BY o.id ASC";
		List<UserPO> users = userDAO.findListByHql(hql);
		List<User> uList = BeanUtils.copyList(users, User.class);
		return uList;
	}

	@Override
	public User getUserByID(Integer userID) {
		UserPO user = userDAO.getObject(userID);
		User u = BeanUtils.copyProperties(user, User.class);
		return u;
	}

	@Override
	public User getUserByCode(String code) {
		String hql = "FROM UserPO o WHERE o.code = ? ";
		UserPO user = userDAO.findByHql(hql, code);
		User u = BeanUtils.copyProperties(user, User.class);
		return u;
	}

	@Override
	public User getUserByName(String name) {
		String hql = "FROM UserPO o WHERE o.name = ? ";
		UserPO user = userDAO.findByHql(hql, name);
		if (user!=null) {
			return BeanUtils.copyProperties(user, User.class);
		}
		return null;
	}

	@Override
	public void deleteUser(Integer userID) {
		userDAO.deleteObjectById(userID);
	}

	@Override
	public List<Role> getAllRole() {
		String hql = "FROM RolePO o ORDER BY o.id ASC";
		List<RolePO> roles = roleDAO.findListByHql(hql);
		return BeanUtils.copyList(roles, Role.class);
	}

	@Override
	public Role getRoleByID(Integer roleID) {
		RolePO role = roleDAO.getObject(roleID);
		return BeanUtils.copyProperties(role, Role.class);
	}

	@Override
	public Integer addRole(Role role) throws BussinessException {
		// 判断是否role的名称是否存在存在，如果存在则抛出异常
		String hql = "select * from role where lower(name)=lower(?)";
		List<Object> paramsList=new ArrayList<Object>();
		paramsList.add(role.getName());
		List<RolePO> roles = roleDAO.findListBySql(hql, paramsList);
		if (CollectionUtils.isNotEmpty(roles))
			throw new BussinessException(ERROR_PROFILE_ROLE_SAME_NAME);
		// 添加角色
		RolePO newRole = new RolePO();
		BeanUtils.copyProperties(role, newRole);
		newRole.setId(null);
		Integer newRoleId = roleDAO.addObject(newRole);
		// 返回添加后的角色ID
		return newRoleId;
	}

	@Override
	public void updateRole(Role role) throws BussinessException {
		// 判断角色名称是否已存在，排除role.getId() 如果存在则抛出异常
		String hql = "FROM RolePO o WHERE o.name = ? and o.id <> ?";
		List<RolePO> roles = roleDAO.findListByHql(hql, new Object[] { role.getName(), role.getId() });
		if (CollectionUtils.isNotEmpty(roles))
			throw new BussinessException(ERROR_PROFILE_ROLE_SAME_NAME);

		RolePO updateRole = roleDAO.getObject(role.getId());
		if (updateRole == null) {
			return;
		}
		updateRole.setName(role.getName());
		updateRole.setDescription(role.getDescription());
		roleDAO.updateObject(updateRole);
	}

	@Override
	public void deleteRole(Integer roleID)throws BussinessException {
		String hql = "FROM UserRolePO o WHERE o.roleID = ? ";
		List<UserRolePO> userRoles = userRoleDAO.findListByHql(hql, roleID);
		if (CollectionUtils.isNotEmpty(userRoles)) {
			throw new BussinessException("该角色还有关联的用户，请先解除关联关系！");
		}
		// 删除角色与权限的关联
		clearAllBindedRightFromRole(roleID);
		// 删除角色与用户的关联
		clearAllUserBindedFromRole(roleID);
		// 删除角色
		roleDAO.deleteObjectById(roleID);
	}

	@Override
	public List<Right> getAllRight() {
		String hql = "FROM RightPO o ORDER BY o.rightGroupID ASC,o.id ASC";
		List<RightPO> rights = rightDAO.findListByHql(hql);
		return BeanUtils.copyList(rights, Right.class);
	}

	@Override
	public List<RightGroup> getAllRightGroup() {
		String hql = "FROM RightGroupPO o ORDER BY o.parentID ASC,o.name ASC";
		List<RightGroupPO> rightGroups = rightGroupDAO.findListByHql(hql);
		return BeanUtils.copyList(rightGroups, RightGroup.class);
	}

	@Override
	public List<Department> getAllDepartment() {
		List<DepartmentPO> departments = departmentDAO.getAll();
		return BeanUtils.copyList(departments, Department.class);
	}

	@Override
	public Department getDepartmentByID(Integer departmentID) {
		DepartmentPO department = departmentDAO.getObject(departmentID);
		return BeanUtils.copyProperties(department, Department.class);
	}

	@Override
	public List<Department> getBindedDepartmentByUser(Integer userID) {
		String hql = "SELECT c FROM DepartmentPO c,UserDepartmentPO o where o.userID = ? and c.id = o.departmentID ORDER BY c.id ASC";
		List<DepartmentPO> departments = departmentDAO.findListByHql(hql, userID);
		return BeanUtils.copyList(departments, Department.class);
	}

	@Override
	public List<User> getBindedUsersByDepartment(Integer departmentID) {
		String hql = "SELECT DISTINCT c  FROM UserPO c,UserDepartmentPO o where o.departmentID = ? and c.id = o.userID ORDER BY c.name ASC";
		List<UserPO> users = userDAO.findListByHql(hql, departmentID);
		List<User> uList = BeanUtils.copyList(users, User.class);
		return uList;
	}

	@Override
	public void setUserToDepartment(Integer userID, List<Integer> departmentIDs) {
		String hql = "FROM UserDepartmentPO o WHERE o.userID = ? ";
		List<UserDepartmentPO> userDepartments = userDepartmentDAO.findListByHql(hql, userID);
		List<Integer> addValues = CollectionUtils.sub(departmentIDs, userDepartments,
				new Equaltor<Integer, UserDepartmentPO>() {
					public boolean equal(Integer o1, UserDepartmentPO o2) {
						return o2.getDepartmentID().equals(o1);
					}
				});
		List<UserDepartmentPO> deleteValues = CollectionUtils.sub(userDepartments, departmentIDs,
				new Equaltor<UserDepartmentPO, Integer>() {
					public boolean equal(UserDepartmentPO o1, Integer o2) {
						return o1.getDepartmentID().equals(o2);
					}
				});
		List<UserDepartmentPO> updateValues = CollectionUtils.intersect(userDepartments, departmentIDs,
				new Equaltor<UserDepartmentPO, Integer>() {
					public boolean equal(UserDepartmentPO o1, Integer o2) {
						return o1.getDepartmentID().equals(o2);
					}
				});

		for (Integer departmentID : addValues) {
			UserDepartmentPO userDepartment = new UserDepartmentPO();
			userDepartment.setId(null);
			userDepartment.setUserID(userID);
			userDepartment.setDepartmentID(departmentID);
			userDepartmentDAO.addObject(userDepartment);
		}
		userDepartmentDAO.deleteObjects(deleteValues);
		userDepartmentDAO.updateObject(updateValues);
	}

	@Override
	public void clearAllUserBindedFromDepartment(Integer userID) {
		String hql = "FROM UserDepartmentPO o WHERE o.userID = ? ";
		List<UserDepartmentPO> userDepartments = userDepartmentDAO.findListByHql(hql, userID);
		if (userDepartments != null && !userDepartments.isEmpty()) {
			for (UserDepartmentPO userDepartmentPO : userDepartments) {
				userDepartmentDAO.deleteObject(userDepartmentPO);
			}
		}

	}

	@Override
	public List<Role> getBindedRoleByUser(Integer userID) {
		String hql = "SELECT c FROM RolePO c,UserRolePO o where o.userID = ? and c.id = o.roleID ORDER BY c.name ASC";
		List<RolePO> roles = roleDAO.findListByHql(hql, userID);
		return BeanUtils.copyList(roles, Role.class);
	}

	@Override
	public List<User> getBindedUserByRole(Integer roleID) {
		String hql = "SELECT DISTINCT c FROM UserPO c,UserRolePO o where o.roleID = ? and c.id = o.userID ORDER BY c.id ASC";
		List<UserPO> users = userDAO.findListByHql(hql, roleID);
		List<User> uList = BeanUtils.copyList(users, User.class);
		return uList;
	}

	@Override
	public List<User> getUnBindedUserBuRole(int roleId) {
		String hql = "SELECT DISTINCT c FROM UserPO c,UserRolePO o where o.roleID <> ? and c.id = o.userID ORDER BY c.id ASC";
		List<UserPO> users = userDAO.findListByHql(hql, roleId);
		List<User> uList = BeanUtils.copyList(users, User.class);
		return uList;
	}

	@Override
	public List<User> getUserByRight(Integer rightID) {
		StringBuilder hql = new StringBuilder();
		hql.append(" Select DISTINCT o from UserPO as o , UserRolePO as a,RolePO as b , RoleRightPO as c");
		hql.append(" Where o.id=a.userID AND b.id=a.roleID AND b.id=c.roleID and c.rightID=?");
		List<UserPO> userList = userDAO.findListByHql(hql.toString(), rightID);
		List<User> uList = BeanUtils.copyList(userList, User.class);
		return uList;
	}

	@Override
	public List<User> getUserByRightCode(String rightCode) {
		StringBuilder hql = new StringBuilder();
		hql.append(" Select DISTINCT o from UserPO as o , UserRolePO as a,RolePO as b , RoleRightPO as c , RightPO d");
		hql.append(" Where o.id=a.userID AND b.id=a.roleID AND b.id=c.roleID and c.rightID=d.id  and d.code=?");
		List<UserPO> userList = userDAO.findListByHql(hql.toString(), rightCode);
		List<User> uList = BeanUtils.copyList(userList, User.class);
		return uList;
	}

	@Override
	public void setRoleToUser(Integer userID, List<Integer> roleIDs) {
		String hql = "FROM UserRolePO o WHERE o.userID = ? ";
		List<UserRolePO> userRoles = userRoleDAO.findListByHql(hql, userID);
		List<Integer> addValues = CollectionUtils.sub(roleIDs, userRoles, new Equaltor<Integer, UserRolePO>() {
			public boolean equal(Integer o1, UserRolePO o2) {
				return o1.equals(o2.getRoleID());
			}
		});
		List<UserRolePO> deleteValues = CollectionUtils.sub(userRoles, roleIDs, new Equaltor<UserRolePO, Integer>() {
			public boolean equal(UserRolePO o1, Integer o2) {
				return o1.getRoleID().equals(o2);
			}
		});

		for (Integer roleID : addValues) {
			UserRolePO userRole = new UserRolePO();
			userRole.setId(null);
			userRole.setUserID(userID);
			userRole.setRoleID(roleID);
			userRoleDAO.addObject(userRole);
		}
		for (UserRolePO userRole : deleteValues) {
			userRoleDAO.deleteObject(userRole);
		}

	}

	@Override
	public void clearAllRoleBindedFromUser(Integer userID) {
		String hql = "FROM UserRolePO o WHERE o.userID = ? ";
		List<UserRolePO> userRoles = userRoleDAO.findListByHql(hql, userID);
		if (userRoles != null && !userRoles.isEmpty()) {
			for (UserRolePO userRolePO : userRoles) {
				userRoleDAO.deleteObject(userRolePO);
			}
		}
	}

	@Override
	public void setUserToRole(Integer roleID, List<Integer> userIDs) {
		String hql = "FROM UserRolePO o WHERE o.roleID = ? ";
		List<UserRolePO> userRoles = userRoleDAO.findListByHql(hql, roleID);
		List<Integer> addValues = CollectionUtils.sub(userIDs, userRoles, new Equaltor<Integer, UserRolePO>() {
			public boolean equal(Integer o1, UserRolePO o2) {
				return o2.getUserID().equals(o1);
			}
		});
		List<UserRolePO> deleteValues = CollectionUtils.sub(userRoles, userIDs, new Equaltor<UserRolePO, Integer>() {
			public boolean equal(UserRolePO o1, Integer o2) {
				return o1.getUserID().equals(o2);
			}
		});

		for (Integer userID : addValues) {
			UserRolePO userRole = new UserRolePO();
			userRole.setId(null);
			userRole.setUserID(userID);
			userRole.setRoleID(roleID);
			userRoleDAO.addObject(userRole);
		}
		for (UserRolePO userRole : deleteValues) {
			userRoleDAO.deleteObject(userRole);
		}
	}

	@Override
	public void clearAllUserBindedFromRole(Integer roleID) {
		String hql = "FROM UserRolePO o WHERE o.roleID = ? ";
		List<UserRolePO> userRoles = userRoleDAO.findListByHql(hql, roleID);
		if (userRoles != null && !userRoles.isEmpty()) {
			for (UserRolePO userRolePO : userRoles) {
				userRoleDAO.deleteObject(userRolePO);
			}
		}
	}

	@Override
	public List<Right> getBindedRightByRole(Integer roleID) {
		String hql = "SELECT DISTINCT c FROM RightPO c,RoleRightPO o where o.roleID = ? and c.id = o.rightID ORDER BY c.id ASC";
		List<RightPO> rights = rightDAO.findListByHql(hql, roleID);
		return BeanUtils.copyList(rights, Right.class);
	}

	@Override
	public List<Role> getBindedRoleByRight(Integer rightID) {
		String hql = "SELECT c FROM RolePO c,RoleRightPO o where o.rightID = ? and c.id = o.roleID ORDER BY c.name ASC";
		List<RolePO> roles = roleDAO.findListByHql(hql, rightID);
		return BeanUtils.copyList(roles, Role.class);
	}

	@Override
	public void setRightToRole(Integer roleID, List<Integer> rightIDs) {
		String hql = "FROM RoleRightPO o WHERE o.roleID = ? ";
		List<RoleRightPO> roleRights = roleRightDAO.findListByHql(hql, roleID);
		List<Integer> addValues = CollectionUtils.sub(rightIDs, roleRights, new Equaltor<Integer, RoleRightPO>() {
			public boolean equal(Integer o1, RoleRightPO o2) {
				return o1.equals(o2.getRightID());
			}
		});
		List<RoleRightPO> deleteValues = CollectionUtils.sub(roleRights, rightIDs,
				new Equaltor<RoleRightPO, Integer>() {
					public boolean equal(RoleRightPO o1, Integer o2) {
						return o1.getRightID().equals(o2);
					}
				});

		for (Integer rightID : addValues) {
			RoleRightPO roleRight = new RoleRightPO();
			roleRight.setId(null);
			roleRight.setRightID(rightID);
			roleRight.setRoleID(roleID);
			roleRightDAO.addObject(roleRight);
		}
		if (CollectionUtils.isNotEmpty(deleteValues)) {
			for (RoleRightPO roleRight : deleteValues) {
				roleRightDAO.deleteObject(roleRight);
			}
		}

	}

	@Override
	public void clearAllBindedRightFromRole(Integer roleID) {
		String hql = "FROM RoleRightPO o WHERE o.roleID = ? ";
		List<RoleRightPO> roleRights = roleRightDAO.findListByHql(hql, roleID);
		if (roleRights != null && !roleRights.isEmpty()) {
			for (RoleRightPO roleRightPO : roleRights) {
				roleRightDAO.deleteObject(roleRightPO);
			}
		}
	}

	@Override
	public void isMachineAuthorized(String macAddress) throws BussinessException {
		// 检查macAddress 是否已授权，如果未授权则抛出异常
		String hql = "FROM LicencePO o WHERE o.macAddress = ?";
		List<LicencePO> licences = licenceDAO.findListByHql(hql, macAddress);
		if (CollectionUtils.isEmpty(licences))
			throw new BussinessException(ERROR_PROFILE_MACHINE_UN_AUTHORIZED);
	}

	@Override
	public void login(String code, String password, String mac) throws BussinessException {
		// 检查mac地址是否授权
		Licence licence = getLicenceByMac(mac);
		if (licence == null) {
			throw new BussinessException(ERROR_PROFILE_MACHINE_UN_AUTHORIZED);
		}
		// 检查用户是否已被屏蔽，如果被屏蔽则抛出异常
		User u = getUserByCode(code);
		if (u == null||u.isDisabled()) {
			throw new BussinessException(ERROR_USER_NOT_IS_EXISTS);
		}
		// 检查用户和密码，如果用户不存在或者密码错误，则抛出异常
		int loginResponseCode = OAWebService.authorizationLogin(code, password);
		if (loginResponseCode == 0)
			throw new BussinessException(ERROR_PROFILE_LOGIN_FAIL);
	}
	
	@Override
	public void updateLicence(Licence licence) {
		LicencePO po = licenceDAO.getObject(licence.getId());
		if (po != null) {
			po.setUserCode(licence.getUserCode());
		}
	}
	@Override
	public void addLicence(Licence licence) throws BussinessException {
		Licence lic = getLicenceByMac(licence.getMacAddress());
		if (lic != null) {
			throw new BussinessException(ERROR_MAC_IS_EXIST);
		}
		licenceDAO.addObject(BeanUtils.copyProperties(licence, LicencePO.class));
	}

	@Override
	public Licence getLicenceById(Integer id) {
		LicencePO po = licenceDAO.getObject(id);
		return convertLicencePO2BO(po);
	}

	@Override
	public Licence getLicenceByMac(String mac) {
		String	hql="from LicencePO where lower(macAddress)=lower(?)";
		LicencePO po=licenceDAO.findByHql(hql, mac);
		if (po!=null) {
			return BeanUtils.copyProperties(po, Licence.class);
		}
		return null;
	}

	private Licence convertLicencePO2BO(LicencePO po) {
		if (po != null) {
			Licence licence = BeanUtils.copyProperties(po, Licence.class);
			User user = getUserByCode(licence.getUserCode());
			if (user != null) {
				licence.setUserName(user.getName());
			}
			return licence;
		} else {
			return null;
		}
	}

	@Override
	public PageList<Licence> findLicence(int pageSize, int currentPage,
			Map<LicenceSearchCriteria, Object> searchCriteria) {
		Criteria c = new Criteria(LicencePO.class);
		for (Entry<LicenceSearchCriteria, Object> entry : searchCriteria.entrySet()) {
			if (entry.getKey().equals(LicenceSearchCriteria.MAC)) {
				c.and(Restriction.like("macAddress", "%" + entry.getValue() + "%"));
			} else if (entry.getKey().equals(LicenceSearchCriteria.USERCODE)) {
				c.and(Restriction.like("userCode", "%" + entry.getValue() + "%"));
			}
		}
		c.order("macAddress", OrderType.asc);
		PageList<Licence> licences = BeanUtils.copyPageList(licenceDAO.pageList(c, currentPage, pageSize),
				Licence.class);
		for (Licence licence : licences.getData()) {
			User user = getUserByCode(licence.getUserCode());
			if (user != null)
				licence.setUserName(user.getName());
		}
		return licences;
	}
	@Override
	public void deleteLicence(Integer licenceId) {
		LicencePO po = licenceDAO.getObject(licenceId);
		if (po != null) {
			licenceDAO.deleteObject(po);
		}
	}
	
	/**
	 * 得到操作人的部门
	 * @param operator
	 * @return
	 */
	public int getDepartmentByOperator(int operator) {
		int department=getBindedDepartmentByUser(operator).get(0).getId();
		return department;
	}
}
