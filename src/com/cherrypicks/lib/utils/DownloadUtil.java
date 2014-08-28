package com.cherrypicks.lib.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.cherrypicks.lib.error.HttpError;
import com.cherrypicks.lib.protocol.IDownload;

/**
 * DownloadUtil,download files from internet.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class DownloadUtil {

	public static enum Status {
		Error, Success, Exist
	}

	private URL url = null;
	
	public void download(String urlStr, String path, String fileName,IDownload iDownload)
	{
		InputStream inputStream = null;
		try {

			if (FileUtil.isFileExist(path + fileName)) {
				iDownload.onError(new Exception("File already exist."));
			} else {
				inputStream = getInputStreamFromURL(urlStr);
				File resultFile = FileUtil.write2SDFromInput(path, fileName,
						inputStream);
				if (resultFile == null) {
					iDownload.onError(new Exception("Write stream to file error!"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			iDownload.onError(new HttpError("Http error!"));
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * According to URL, the content of the file is text,and the return value is
	 * the value of the text.
	 * 
	 * 1.Create a URL object
	 * 
	 * 2.According to the URL object,Create a HttpURLConnection object.
	 * 
	 * 3.Get InputStream
	 * 
	 * 4.Read data from InputStream.
	 * 
	 * @param urlStr
	 * @return
	 */
	public String download(String urlStr) {
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection urlConn = (HttpURLConnection) url
					.openConnection();
			buffer = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * Download file from URL
	 * 
	 * @param urlStr
	 * @param path
	 * @param fileName
	 * @return -1:download error 0:download success 1:file already exist
	 */
	public Status download(String urlStr, String path, String fileName) {
		InputStream inputStream = null;
		try {

			if (FileUtil.isFileExist(path + fileName)) {
				return Status.Exist;
			} else {
				inputStream = getInputStreamFromURL(urlStr);
				File resultFile = FileUtil.write2SDFromInput(path, fileName,
						inputStream);
				if (resultFile == null) {
					return Status.Error;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Status.Error;
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Status.Success;
	}

	/**
	 * Get InputStream from url.
	 * 
	 * @param urlStr
	 * @return
	 */
	public InputStream getInputStreamFromURL(String urlStr) {
		HttpURLConnection urlConn = null;
		InputStream inputStream = null;
		try {
			url = new URL(urlStr);
			urlConn = (HttpURLConnection) url.openConnection();
			inputStream = urlConn.getInputStream();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputStream;
	}

}
