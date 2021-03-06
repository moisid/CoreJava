/*
 * Created on 10 Jan 2017 ( Time 17:58:54 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.Review;
import org.demo.web.common.ListItem;

public class ReviewListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ReviewListItem(Review review) {
		super();

		this.value = ""
			 + review.getCustomerCode()
			 + "|"  + review.getBookId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = review.toString();
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
