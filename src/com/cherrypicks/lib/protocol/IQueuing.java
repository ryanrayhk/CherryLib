/** 
 *IQueuing.java,
 *
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
package com.cherrypicks.lib.protocol;

import java.util.List;

import com.cherrypicks.lib.model.Member;
import com.loopj.android.http.RequestParams;

/**
 * IQueuing,
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public interface IQueuing {

	void getBranchStatus(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

	void getTicket(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

	void updateTicket(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

	void cancelTicket(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

	void retrieveTicket(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

}
