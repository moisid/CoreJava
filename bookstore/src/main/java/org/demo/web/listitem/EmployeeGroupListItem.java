/*
 * Created on 10 Jan 2017 ( Time 17:58:54 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.EmployeeGroup;
import org.demo.web.common.ListItem;

public class EmployeeGroupListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public EmployeeGroupListItem(EmployeeGroup employeeGroup) {
		super();

		this.value = ""
			 + employeeGroup.getEmployeeCode()
			 + "|"  + employeeGroup.getGroupId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = employeeGroup.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
