package com.cherrypicks.lib.protocol;

import java.util.List;

import com.cherrypicks.lib.model.Member;
import com.loopj.android.http.RequestParams;

/**
 * This interface is for getting Member information from Server.
 * It provider several kinds of filter, you can add the conditions inside params.
 *
 * Generally fetching of configuration parameters is asynchronous and therefore requires callback parameters.
 *
 * @since 1.1.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public interface Imember {

	void getMembers(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			Callback<Exception> onFailure);

}
