package com.itecheasy.core.user;

import java.util.List;
import java.util.Map;

import com.itecheasy.common.PageList;
import com.itecheasy.core.BussinessException;

public interface ProfileService {
	/**
	 * 添加用户异常信息 (用户已经存在)
	 */
	public static String ERROR_USER_IS_EXISTS = "ERROR_USER_IS_EXISTS";
	
	/**
	 * 用户登录一次 (用户不存在)
	 */
	public static String ERROR_USER_NOT_IS_EXISTS = "ERROR_USER_NOT_IS_EXISTS";
	/**
	 * 角色名称重复
	 */
	public final static String ERROR_PROFILE_ROLE_SAME_NAME = "ERROR_PROFILE_ROLE_SAME_NAME";
	/**
	 * 机器未授权
	 */
	public final static String ERROR_PROFILE_MACHINE_UN_AUTHORIZED = "ERROR_PROFILE_MACHINE_UN_AUTHORIZED";
	/**
	 * 登录失败，用户名或者密码错误
	 */
	public final static String ERROR_PROFILE_LOGIN_FAIL = "ERROR_PROFILE_LOGIN_FAIL";

	/**
	 * 增加mac时，mac已经存在
	 */
	public final static String ERROR_MAC_IS_EXIST = "ERROR_MAC_IS_EXIST";
	/**
	 * 工号不存在
	 */
	public final static String ERROR_WORKNO_IS_NOT_EXISTS = "ERROR_WORKNO_IS_NOT_EXISTS";

	/**
	 * 搜索licence
	 * 
	 * @author Administrator
	 * 
	 */
	public enum LicenceSearchCriteria {
		/**
		 * 用户工号
		 */
		USERCODE,
		/**
		 * mac地址
		 */
		MAC

	}

	/*********************************** 用户对象方法 **************************************/

	/**
	 * 根据用户id获取姓名
	 * @param userId
	 * @return
	 */
	public String getUserNameById(int userId);
	
	/**
	 * 添加用户
	 * 
	 * @param code
	 *            员工编号
	 * @param operator
	 *            操作人
	 * @return
	 * @desc 调用oa的webservice 检测用户信息
	 * @throws BussinessException
	 *             <p>
	 *             {@link #ERROR_USER_IS_EXISTS}
	 *             <p>
	 *             {@link #ERROR_USER_IS_EXISTS}
	 */
	public int addUser(String code) throws BussinessException;
	
	public int addUser(String code,boolean disabled);
	/**
	 * 设置用户是否不可用
	 * @param userId
	 * @param disabled
	 */
	void setUserDisabled(int userId,boolean disabled);

	/**
	 * 获取所有用户，默认按名称正序排列
	 * 
	 * @return List<User> 返回User列表
	 */
	public List<User> getAllUser();
	
	/**
	 * 获取所有可用的用户，默认按名称正序排列
	 * @return
	 */
	List<User> getAllEnableUser();

	/**
	 * 根据userID获取一个用户对象
	 * 
	 * @param userID
	 *            用户ID
	 * @return 返回用户对象
	 */
	public User getUserByID(Integer userID);

	/**
	 * 根据用户工号获取一个用户对象
	 * 
	 * @param code
	 *            工号
	 * @return 返回一个用户对象
	 */
	public User getUserByCode(String code);
	
	/**
	 * 根据用户工号获取一个用户对象
	 * 
	 * @param code
	 *            工号
	 * @return 返回一个用户对象
	 */
	public User getUserByName(String name);

	/**
	 * 根据userID，删除用户及关联的物理MAC地址
	 * 
	 * @param userID
	 *            用户ID
	 */
	public void deleteUser(Integer userID);

	/*********************************** 角色对象方法 **************************************/

	/**
	 * 获取所有角色，默认按角色名称正序排列
	 * 
	 * @return List<Role> 角色列表
	 */
	public List<Role> getAllRole();

	/**
	 * 根据roleID获取一个角色对象
	 * 
	 * @param roleID
	 *            角色ID
	 * @return 返回一个角色对象
	 */
	public Role getRoleByID(Integer roleID);

	/**
	 * 增加一个角色
	 * 
	 * @param role
	 *            角色对象
	 * @return 返回添加后的角色的ID
	 * @throws BussinessException
	 *             <p>
	 *             {@link #ERROR_PROFILE_ROLE_SAME_NAME} :如果角色名称相同则抛出异常
	 */
	public Integer addRole(Role role) throws BussinessException;

	/**
	 * 更新一个角色
	 * 
	 * @param role
	 *            角色对象
	 * @throws BussinessException
	 *             <p>
	 *             {@link #ERROR_PROFILE_ROLE_SAME_NAME} :如果更新的角色名称已存在则抛出异常
	 */
	public void updateRole(Role role) throws BussinessException;

	/**
	 * 删除一个角色，同时删除角色与权限关联，角色与用户的关联
	 * 
	 * @param roleID
	 *            角色ID
	 */
	public void deleteRole(Integer roleID)throws BussinessException;

	/*********************************** 权限、权限分组对象方法 **************************************/

	/**
	 * 返回所有权限，默认先按权限分组ID正序排列，再按权限ID正序排列
	 * 
	 * @return List<Right> 权限列表
	 */
	public List<Right> getAllRight();


	/**
	 * 获取所有权限分组，默认按权限分组父级到子级正序排序，再按名称正序排列
	 * 
	 * @return List<Right> 返回权限分组列表
	 */
	public List<RightGroup> getAllRightGroup();





	/*********************************** 部门对象方法 **************************************/

	/**
	 * 获取所有部门，默认按部门ID正序排列
	 * 
	 * @return List<Department>返回部门列表
	 */
	public List<Department> getAllDepartment();

	/**
	 * 根据departmentID获取一个部门对象
	 * 
	 * @param departmentID
	 *            部门ID
	 * @return 返回部门对象
	 */
	public Department getDepartmentByID(Integer departmentID);



	/*********************************** 用户、部门关联方法 **************************************/

	/**
	 * 获取用户已绑定的部门，默认按部门ID正序排列
	 * 
	 * @param userID
	 *            用户ID
	 * @return List<Department> 返回部门列表
	 */
	public List<Department> getBindedDepartmentByUser(Integer userID);

	/**
	 * 根据departmentID， 获取当前已绑定到该部门的所有用户，默认按用户名称正序排列
	 * 
	 * @param departmentID
	 *            部门ID
	 * @return List<User> 返回用户列表
	 */
	public List<User> getBindedUsersByDepartment(Integer departmentID);

	/**
	 * 为用户绑定部门,根据departmentIDs替换用户已绑定的所有部门
	 * <p>
	 * 如：用户原先绑定了部门 {1, 2},本次方法调用中 departmentIDs 为 {3,4},则最终结果用户绑定的部门为{3,4}
	 * 
	 * @param userID
	 *            用户ID
	 * @param departmentIDs
	 *            部门ID列表
	 */
	public void setUserToDepartment(Integer userID, List<Integer> departmentIDs);

	/**
	 * 根据 userID 清除一个用户与所有部门的关联关系
	 * 
	 * @param userID
	 *            用户ID
	 */
	public void clearAllUserBindedFromDepartment(Integer userID);

	/*********************************** 用户、角色关联方法 **************************************/

	/**
	 * 获取用户已绑定的角色列表，默认按角色名称正序排列
	 * 
	 * @param userID
	 *            用户ID
	 * @return List<Role> 返回角色列表
	 */
	public List<Role> getBindedRoleByUser(Integer userID);

	/**
	 * 根据 roleID ，获取已经绑定到该角色的用户列表，默认按用户名称正序排列
	 * 
	 * @param roleID
	 *            角色ID
	 * @return List<User> 返回用户列表
	 */
	public List<User> getBindedUserByRole(Integer roleID);

	/**
	 * 获取该角色未绑定的用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<User> getUnBindedUserBuRole(int roleId);

	/**
	 * 根据rightID ，获取拥有该权限的所有用户，默认按用户名称正序排列
	 * 
	 * @param rightID
	 *            权限ID
	 * @return List<User> 返回用户列表
	 */
	public List<User> getUserByRight(Integer rightID);

	/**
	 * 根据rightCode ，获取拥有该权限的所有用户，默认按用户名称正序排列
	 * 
	 * @param rightCode
	 *            权限code
	 * @return List<User> 返回用户列表
	 */
	public List<User> getUserByRightCode(String rightCode);

	/**
	 * 为用户绑定角色，roleIDs替换，用户已绑定的所有角色
	 * <p>
	 * 如：用户原先绑定了角色 {1, 2},本次方法调用中 roleIDs 为 {2，3},则最终结果用户绑定的角色为{2,3}
	 * 
	 * @param userID
	 *            用户ID
	 * @param roleIDs
	 *            角色ID列表
	 */
	public void setRoleToUser(Integer userID, List<Integer> roleIDs);


	/**
	 * 根据 userID 接触与该用户，与所有角色的绑定关系
	 * 
	 * @param userID
	 */
	public void clearAllRoleBindedFromUser(Integer userID);

	/**
	 * 为角色绑定用户，userIDs替换所有已绑定到该角色的所有用户
	 * <p>
	 * 如：角色原先绑定了用户 {1, 2},本次方法调用中 userIDs 为 {2,3,4},则最终结果角色绑定的用户为{2,3,4}
	 * 
	 * @param userIDs
	 *            用户ID列表
	 * @param roleID
	 *            角色ID
	 */
	public void setUserToRole(Integer roleID, List<Integer> userIDs);

	/**
	 * 根据 roleID ，清除与该角色，与所有用户的绑定关系
	 * 
	 * @param roleID
	 *            角色ID
	 */
	public void clearAllUserBindedFromRole(Integer roleID);

	/*********************************** 权限、角色关联方法 **************************************/

	/**
	 * 根据roleID，获取某个角色已绑定的所有权限，默认按权限ID正序排列
	 * 
	 * @param roleID
	 *            角色ID
	 * @return List<Right> 返回权限列表
	 */
	public List<Right> getBindedRightByRole(Integer roleID);

	/**
	 * 根据rightID，获取已绑定该权限的角色的列表，默认按角色名称正序排列
	 * 
	 * @param rightID
	 *            角色ID
	 * @return List<Role> 返回角色列表
	 */
	public List<Role> getBindedRoleByRight(Integer rightID);

	/**
	 * 为角色绑定权限，根据rightIDs替换角色已绑定的所有权限
	 * <p>
	 * 如：角色原先绑定了权限 {1, 2},本次方法调用中 rightIDs 为 {2,3,4},则最终结果角色绑定的权限为{2,3,4}
	 * 
	 * @param roleID
	 *            角色ID
	 * @param rightIDs
	 *            权限ID列表
	 */
	public void setRightToRole(Integer roleID, List<Integer> rightIDs);

	/**
	 * 根据 roleID 清除角色与所有权限的绑定关系
	 * 
	 * @param roleID
	 *            角色ID
	 */
	public void clearAllBindedRightFromRole(Integer roleID);

	/*********************************** 用户登录方法 **************************************/

	/**
	 * 根据macAddress验证机器是否已授权，
	 * 
	 * @param macAddress
	 *            客户端机器的MAC地址
	 * @throws BussinessException
	 *             <p>
	 *             {@link #ERROR_PROFILE_MACHINE_UN_AUTHORIZED} : 如果机器未授权会抛出异常
	 */
	public void isMachineAuthorized(String macAddress) throws BussinessException;

	/**
	 * 
	 * @param code
	 *            用户工号
	 * @param password
	 *            用户密码
	 * @throws BussinessException
	 *             <p>
	 *             {@link #ERROR_PROFILE_LOGIN_FAIL} : 如果用户名或者密码错误，会抛出异常
	 *             <p>
	 *             {@link #ERROR_PROFILE_USER_IS_INVALID} : 如果用户已被屏蔽，会抛出异常
	 */
	public void login(String code, String password, String mac) throws BussinessException;
	
	public void updateLicence(Licence licence);

	public void addLicence(Licence licence) throws BussinessException;

	/**
	 * 获取licence
	 * 
	 * @param id
	 * @return
	 */
	public Licence getLicenceById(Integer id);

	/**
	 * 获取licence
	 * 
	 * @param id
	 * @return
	 */
	public Licence getLicenceByMac(String mac);

	/**
	 * 查询licence
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @param searchCriteria
	 * @return
	 */
	public PageList<Licence> findLicence(int pageSize, int currentPage,
			Map<LicenceSearchCriteria, Object> searchCriteria);

	public void deleteLicence(Integer licenceId);
	
	/**
	 * 得到操作人的部门
	 * @param operator
	 * @return
	 */
	public int getDepartmentByOperator(int operator);
}
