package com.cherrypicks.lib.network;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpStatus;

import com.cherrypicks.lib.error.AuthorisationError;
import com.cherrypicks.lib.error.HttpError;
import com.cherrypicks.lib.error.JsonError;
import com.cherrypicks.lib.model.Member;
import com.cherrypicks.lib.protocol.Callback;
import com.cherrypicks.lib.protocol.IQueuing;
import com.cherrypicks.lib.protocol.Imember;
import com.cherrypicks.lib.utils.CherryConfig;
import com.cherrypicks.lib.utils.ParserUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

/**
 * Implementation of {@link com.cherrypicks.protocol.Imember} NetworkManager
 * handler all the network request and return the entities through callback.
 * 
 * @see com.cherrypicks.protocol.Imember
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class NetworkManager implements Imember,IQueuing {

	private AsyncHttpClient client = new AsyncHttpClient();

//	// Prevent direct access to the constructor
//	private NetworkManager() {
//	};
//
//	/**
//	 * NetworkManagerHolder is loaded on the first execution of
//	 * NetworkManager.getInstance() or the first access to
//	 * NetworkManagerHolder.instance, not before.
//	 */
//	private static class NetworkManagerHolder {
//		private static final NetworkManager instance = new NetworkManager();
//	}
//
//	public static NetworkManager getInstance() {
//		return NetworkManagerHolder.instance;
//	}

	@Override
	public void getMembers(final RequestParams params,
			final Callback<List<Member>> onSuccess,
			final Callback<Exception> onFailure) {

		/**
		 * Get response from the server,and parse to entities. Note, the parse
		 * should be move to a separated thread,here just demonstrate the
		 * network request only.
		 */
		get(CherryConfig.MEMBER_URL, params, new Callback<String>() {

			@Override
			public void execute(String response) {

				try {
					List<Member> memberList = new ParserUtil<Member>()
							.getMemberList(response);
					
					onSuccess.execute(memberList);
				} catch (Exception e) {
					onFailure.equals(new JsonError(
							"JSON parse error when getMembers", e));
				}
			}
		}, onFailure);
	}

	/**
	 * Http Get method.
	 * 
	 * @param url
	 *            Request url
	 * @param params
	 *            Request params
	 * @param onSuccess
	 *            Success callback
	 * @param onFailure
	 *            Failure callback
	 * @return RequestHandle
	 */
	protected RequestHandle get(final String url, final RequestParams params,
			Callback<String> onSuccess, final Callback<Exception> onFailure) {
		return client.get(url, params, new CherryPicksResponseHandler(
				onSuccess, onFailure));

	}

	/**
	 * Http Post method.
	 * 
	 * @param url
	 *            Request url
	 * @param params
	 *            Request params
	 * @param onSuccess
	 *            Success callback
	 * @param onFailure
	 *            Failure callback
	 * @return RequestHandle
	 */
	protected RequestHandle post(final String url, final RequestParams params,
			Callback<String> onSuccess, final Callback<Exception> onFailure) {
		return client.post(url, params, new CherryPicksResponseHandler(
				onSuccess, onFailure));
	}

	/**
	 * Custom ResponseHandler which will caught the exception and generate our
	 * own error message to the Callback, the error message will be received and
	 * handled by the Caller.
	 */
	private static class CherryPicksResponseHandler extends
			AsyncHttpResponseHandler {
		final Callback<String> onSuccessCallback;
		final Callback<Exception> onFailureCallback;

		CherryPicksResponseHandler(final Callback<String> onSuccess,
				final Callback<Exception> onFailure) {
			this.onSuccessCallback = onSuccess;
			this.onFailureCallback = onFailure;
		}

		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			// TODO Auto-generated method stub
			super.onFailure(arg0, arg1, arg2, arg3);

			switch (arg0) {
			case HttpStatus.SC_FORBIDDEN:
				onFailureCallback.execute(new AuthorisationError(
						"Forbidden. Access is denied.", arg3));
				break;
			case HttpStatus.SC_UNAUTHORIZED:
				onFailureCallback.execute(new AuthorisationError(
						"Authentication failed.", arg3));
				break;
			default:
				onFailureCallback.execute(new HttpError(
						"Unable to connect to remote service.", arg3));
				break;
			}
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			// TODO Auto-generated method stub
			super.onSuccess(arg0, arg1, arg2);
			String result = null;
			try {
				result = new String(arg2, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			onSuccessCallback.execute(result);
		}

	}

	/* (non-Javadoc)
	 * @see com.cherrypicks.lib.protocol.IQueuing#getBranchStatus(com.loopj.android.http.RequestParams, com.cherrypicks.lib.protocol.Callback, com.cherrypicks.lib.protocol.Callback)
	 */
	@Override
	public void getBranchStatus(RequestParams params,
			Callback<List<Member>> onSuccess, Callback<Exception> onFailure) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cherrypicks.lib.protocol.IQueuing#getTicket(com.loopj.android.http.RequestParams, com.cherrypicks.lib.protocol.Callback, com.cherrypicks.lib.protocol.Callback)
	 */
	@Override
	public void getTicket(RequestParams params,
			Callback<List<Member>> onSuccess, Callback<Exception> onFailure) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cherrypicks.lib.protocol.IQueuing#updateTicket(com.loopj.android.http.RequestParams, com.cherrypicks.lib.protocol.Callback, com.cherrypicks.lib.protocol.Callback)
	 */
	@Override
	public void updateTicket(RequestParams params,
			Callback<List<Member>> onSuccess, Callback<Exception> onFailure) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cherrypicks.lib.protocol.IQueuing#cancelTicket(com.loopj.android.http.RequestParams, com.cherrypicks.lib.protocol.Callback, com.cherrypicks.lib.protocol.Callback)
	 */
	@Override
	public void cancelTicket(RequestParams params,
			Callback<List<Member>> onSuccess, Callback<Exception> onFailure) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cherrypicks.lib.protocol.IQueuing#retrieveTicket(com.loopj.android.http.RequestParams, com.cherrypicks.lib.protocol.Callback, com.cherrypicks.lib.protocol.Callback)
	 */
	@Override
	public void retrieveTicket(RequestParams params,
			Callback<List<Member>> onSuccess, Callback<Exception> onFailure) {
		// TODO Auto-generated method stub
		
	}

}
