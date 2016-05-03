package cn.ck.edm.bean;

import java.io.Serializable;

/** 
* @ClassName: Contacts 
* @Description: 联系人实体类
* @author Conkis-ac
* @date 2016年5月3日 下午8:27:01 
*  
*/
public class Contacts implements Serializable {
	public String no; // 工号
	public String dep; // 部门
	public String depChild; // 子部门
	public String post; // 岗位&职务
	public String name; // 姓名
	public int sex; // 性别
	public String workPhone; // 直线
	public String ext; // 分机
	public String phone; // 手机
	public String eEmail; // 企业邮箱
	public String backupEmail; // 备用邮箱
	public String qq; // QQ号
	public String addUserId; // 创建用户Id
	public String addUserName; // 创建用户名称
	public String addDate; // 创建时间
	public String upUserId; // 修改用户Id
	public String upUserName; // 修改用户名称
	public String upDate; // 修改时间
	
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * @return the dep
	 */
	public String getDep() {
		return dep;
	}
	/**
	 * @param dep the dep to set
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}
	/**
	 * @return the depChild
	 */
	public String getDepChild() {
		return depChild;
	}
	/**
	 * @param depChild the depChild to set
	 */
	public void setDepChild(String depChild) {
		this.depChild = depChild;
	}
	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}
	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	/**
	 * @return the ext
	 */
	public String getExt() {
		return ext;
	}
	/**
	 * @param ext the ext to set
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the eEmail
	 */
	public String geteEmail() {
		return eEmail;
	}
	/**
	 * @param eEmail the eEmail to set
	 */
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	/**
	 * @return the backupEmail
	 */
	public String getBackupEmail() {
		return backupEmail;
	}
	/**
	 * @param backupEmail the backupEmail to set
	 */
	public void setBackupEmail(String backupEmail) {
		this.backupEmail = backupEmail;
	}
	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * @return the addUserId
	 */
	public String getAddUserId() {
		return addUserId;
	}
	/**
	 * @param addUserId the addUserId to set
	 */
	public void setAddUserId(String addUserId) {
		this.addUserId = addUserId;
	}
	/**
	 * @return the addUserName
	 */
	public String getAddUserName() {
		return addUserName;
	}
	/**
	 * @param addUserName the addUserName to set
	 */
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	/**
	 * @return the addDate
	 */
	public String getAddDate() {
		return addDate;
	}
	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	/**
	 * @return the upUserId
	 */
	public String getUpUserId() {
		return upUserId;
	}
	/**
	 * @param upUserId the upUserId to set
	 */
	public void setUpUserId(String upUserId) {
		this.upUserId = upUserId;
	}
	/**
	 * @return the upUserName
	 */
	public String getUpUserName() {
		return upUserName;
	}
	/**
	 * @param upUserName the upUserName to set
	 */
	public void setUpUserName(String upUserName) {
		this.upUserName = upUserName;
	}
	/**
	 * @return the upDate
	 */
	public String getUpDate() {
		return upDate;
	}
	/**
	 * @param upDate the upDate to set
	 */
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
}
