package com.cherrypicks.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

/**
 * FileUtil, do file operation.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class FileUtil {

	private static final int FILESIZE = 4 * 1024;
	private static final String SD_BASE_PATH = "CherryLib";

	/**
	 * Whether the sd card exist
	 */
	public static boolean hasSdcard() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * get the SD card path
	 */
	public static String getBasePath() {

		String basePath;
		if (hasSdcard()) {
			basePath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/".concat(SD_BASE_PATH).concat("/");
			createPath(basePath);
		} else {
			basePath = null;
		}

		return basePath;
	}

	/**
	 * Create Folder
	 * 
	 * @Title: createPath
	 * @param @param path
	 * @return void
	 * @throws
	 */
	public static void createPath(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * Whether the File is existed
	 * 
	 * @Title: isFileExist
	 * @param @param path
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isFileExist(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Delete the file
	 * 
	 * @Title: deleteFile
	 * @param @param path
	 * @return void
	 * @throws
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * delete floder
	 * 
	 * @Title: delete
	 * @param @param path
	 * @return void
	 * @throws
	 */
	public static void deleteFloder(String path) {

		File file = new File(path);

		if (!file.exists()) {
			return;
		}

		if (file.isFile()) {
			file.delete();
			return;
		}

		if (file.isDirectory()) {
			File[] childFiles = file.listFiles();
			if (childFiles == null || childFiles.length == 0) {
				file.delete();
				return;
			}

			for (int i = 0; i < childFiles.length; i++) {
				deleteFloder(childFiles[i].getPath());
			}
			file.delete();
		}
	}

	/**
	 * delete floder content
	 * 
	 * @Title: delete
	 * @param @param path
	 * @return void
	 * @throws
	 */
	public static void deleteFolderContent(String path) {

		File file = new File(path);

		if (!file.exists()) {
			return;
		}

		if (file.isDirectory()) {
			File[] childFiles = file.listFiles();
			if (childFiles == null || childFiles.length == 0) {
				file.delete();
				return;
			}

			for (int i = 0; i < childFiles.length; i++) {
				deleteFloder(childFiles[i].getPath());
			}
		}
	}

	/**
	 * Write a inputstream to sd card.
	 * 
	 * @param path
	 * @param fileName
	 * @param input
	 * @return
	 */
	public static File write2SDFromInput(String path, String fileName,
			InputStream input) {
		File file = null;
		OutputStream output = null;
		try {
			createPath(path);
			file = new File(path + fileName);
			output = new FileOutputStream(file);
			byte[] buffer = new byte[FILESIZE];

			int length;
			while ((length = (input.read(buffer))) > 0) {
				output.write(buffer, 0, length);
			}

			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * Get text from file.
	 * 
	 * @param path
	 *            FilePath
	 * @return text of the file
	 */
	public static String readSDFile(String path) {

		StringBuffer sb = new StringBuffer();

		File file = new File(path);

		try {

			FileInputStream fis = new FileInputStream(file);

			int c;

			while ((c = fis.read()) != -1) {

				sb.append((char) c);

			}

			fis.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return sb.toString();

	}
}
