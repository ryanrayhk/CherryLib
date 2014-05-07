package com.cherrypicks.lib.protocol;

import android.view.View;

/**
 * IListItemClick help us handle click event inside the list item.
 * 
 * @since 1.1.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public interface IListItemClick {

	void onClick(View item, View group, int position, int id);

}
