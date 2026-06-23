/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.mdmi.core.MdmiException;

/**
 * Static file and folder utility functions.
 *
 * @author goancea
 */
public final class FileUtil {
	private static final int BUFSIZE = 0xFFFF;

	private static final String INVALID_FILE_NAME_CHARS = "\\|/:*?\"<>,'`; ";

	/**
	 * Read the contents of the specified file into a string and return it. Uses UTF-8 encoding.
	 *
	 * @param f
	 *            The file to read
	 * @return The contents of the file as string.
	 */
	public static String readFile(File f) {
		return readFile(f, null);
	}

	/**
	 * Read the contents of the specified file into a string and return it. Uses the specified encoding.
	 *
	 * @param f
	 *            The file to read
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @return The contents of the file as string.
	 */
	public static String readFile(File f, String enc) {
		if (f == null) {
			throw new IllegalArgumentException("null file in Util.readFile()");
		}
		return StringUtil.getString(readFileBytes(f), enc);
	}

	/**
	 * Read the contents of the specified file into a string and return it.
	 *
	 * @param f
	 *            The file to read
	 * @return The contents of the file as string.
	 */
	public static byte[] readFileBytes(File f) {
		if (f == null || !f.exists()) {
			return null;
		}

		byte[] raw = null;
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(f);
			raw = new byte[fi.available()];
			fi.read(raw);
		} catch (IOException ex) {
			throw new MdmiException(ex, "Invalid read IO " + f.getAbsolutePath());
		} finally {
			try {
				if (fi != null) {
					fi.close();
				}
			} catch (Exception ignored) {
			}
		}
		return raw;
	}

	/**
	 * Write the contents of the specified string into the file. If the file exists, a backup will be made. It will use
	 * UTF-8 encoding.
	 *
	 * @param f
	 *            The file to write to.
	 * @param s
	 *            The contents of the file as string.
	 */
	public static void writeFile(File f, String s) {
		writeFile(f, s, true, null);
	}

	/**
	 * Write the contents of the specified string into the file. If the file exists, a backup will be made. It will use
	 * the specified encoding.
	 *
	 * @param f
	 *            The file to write to.
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 * @param s
	 *            The contents of the file as string.
	 */
	public static void writeFile(File f, String s, String enc) {
		writeFile(f, s, true, null);
	}

	/**
	 * Write the contents of the specified string into the file. It will use UTF-8 encoding.
	 *
	 * @param f
	 *            The file to write to.
	 * @param s
	 *            The contents of the file as string.
	 * @param backup
	 *            If true and the file exists, it will be backed up.
	 */
	public static void writeFile(File f, String s, boolean backup) {
		writeFile(f, s, backup, null);
	}

	/**
	 * Write the contents of the specified string into the file. It will use the specified encoding.
	 *
	 * @param f
	 *            The file to write to.
	 * @param s
	 *            The contents of the file as string.
	 * @param backup
	 *            If true and the file exists, it will be backed up.
	 * @param enc
	 *            Encoding to use, if null will use UTF-8.
	 */
	public static void writeFile(File f, String s, boolean backup, String enc) {
		if (f == null) {
			throw new IllegalArgumentException("null file in Util.writeFile()");
		}
		if (s == null) {
			return;
		}
		writeFileBytes(f, StringUtil.getBytes(s, enc), backup);
	}

	/**
	 * Write the contents of the specified string into the file. If the file exists, a backup will be made.
	 *
	 * @param f
	 *            The file to write to.
	 * @param s
	 *            The contents of the file as string.
	 */
	public static void writeFileBytes(File f, byte[] data) {
		writeFileBytes(f, data, true);
	}

	/**
	 * Write the contents of the specified string into the file.
	 *
	 * @param f
	 *            The file to write to.
	 * @param s
	 *            The contents of the file as string.
	 * @param backup
	 *            If true and the file exists, it will be backed up.
	 */
	public static void writeFileBytes(File f, byte[] data, boolean backup) {
		if (f == null || data == null || data.length <= 0) {
			return;
		}
		if (backup && f.exists()) {
			FileUtil.backup(f);
		} else if (f.exists()) {
			f.delete();
		}
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(f);
			fout.write(data);
		} catch (IOException ex) {
			throw new MdmiException(ex, "Invalid write IO " + f.getAbsolutePath());
		} finally {
			try {
				if (fout != null) {
					fout.close();
				}
			} catch (Exception ignored) {
			}
		}
	}

	/**
	 * Return true if the file is writable. If the file does not exist, it will attempt to create it.
	 *
	 * @param f
	 *            The file to write to.
	 * @return True if it can write to it, false otherwise.
	 */
	public static boolean canWrite(File f) {
		if (f == null) {
			throw new IllegalArgumentException("null argument in Util.canWrite()");
		}
		boolean canWrite = false;
		if (f.exists()) {
			canWrite = f.canWrite();
		} else {
			FileOutputStream fout = null;
			try {
				fout = new FileOutputStream(f);
				fout.write(' ');
				fout.close();
				fout = null;
				canWrite = true;
			} catch (Exception ignored) {
			} finally {
				try {
					if (fout != null) {
						fout.close();
					}
				} catch (Exception ignored) {
				}
				try {
					f.delete();
				} catch (Exception ignored) {
				}
			}
		}
		return canWrite;
	}

	/**
	 * Make a backup copy of the specified file, if the file exists. The backup file has the same name with a ".bak"
	 * extension added. If there already exists a file with the same name and a ".bak" extension it will be deleted.
	 *
	 * @param file
	 *            The file to backup
	 */
	public static void backup(File file) {
		if (file == null) {
			throw new IllegalArgumentException("Null file in FileUtil.backup()");
		}
		if (file.exists()) {
			File backup = new File(file.getAbsolutePath() + ".bak");
			if (backup.exists()) {
				backup.delete();
			}
			file.renameTo(backup);
		}
	}

	public static ArrayList<ArrayList<String>> readCsvFile(String fileName) {
		if (null == fileName || fileName.length() <= 0) {
			throw new IllegalArgumentException("Null fileName in FileUtil.readCsvFile()");
		}
		return readCsvFile(new File(fileName));
	}

	public static ArrayList<ArrayList<String>> readCsvFile(File file) {
		if (null == file || !file.exists() || !file.isFile()) {
			throw new IllegalArgumentException("FileUtil.readCsvFile() file is null or inaccessible!");
		}
		ArrayList<ArrayList<String>> a = new ArrayList<>();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				for (String line; (line = br.readLine()) != null;) {
					a.add(readOneLine(line));
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException("FileUtil.readCsvFile() fails", ex);
		}
		return a;
	}

	private static ArrayList<String> readOneLine(String line) {
		ArrayList<String> a = new ArrayList<>();
		if (null == line) {
			return a;
		}
		line = line.trim();
		StringBuffer s = new StringBuffer(line);
		while (0 < s.length()) {
			char c = s.charAt(0);
			if ('"' == c) {
				a.add(readField(s));
			} else if (',' == c) {
				a.add("");
				s.deleteCharAt(0);
			} else {
				a.add(readField(s));
			}
		}
		return a;
	}

	private static String readField(StringBuffer s) {
		boolean quoted = false;
		if ('"' == s.charAt(0)) {
			quoted = true;
			s.deleteCharAt(0);
		}
		StringBuffer item = new StringBuffer();
		while (0 < s.length()) {
			char c = s.charAt(0);
			s.deleteCharAt(0);
			if (quoted) {
				if ('"' == c) {
					if (s.length() <= 0 || '"' != s.charAt(0)) {
						break;
					}
					item.append('"');
					s.deleteCharAt(0);
				} else {
					item.append(c);
				}
			} else {
				if (',' == c) {
					break;
				} else {
					item.append(c);
				}
			}
		}
		return item.toString();
	}

	/**
	 * Compare the two specified files byte-wise, return true if they are identical. If any of the files is null, or does
	 * not exist, or cannot be opened for reading, false is returned. No exceptions are thrown.
	 *
	 * @param f
	 *            The first file
	 * @param g
	 *            The second file
	 * @return True if the files exist and are identical, false otherwise
	 */
	public static boolean compareFiles(File f, File g) {
		if (f == null || g == null || !(f.exists() && g.exists())) {
			return false;
		}
		FileInputStream fis = null;
		FileInputStream gis = null;
		try {
			fis = new FileInputStream(f);
			gis = new FileInputStream(g);

			int n = BUFSIZE;
			byte[] bf = new byte[BUFSIZE];
			byte[] bg = new byte[BUFSIZE];
			while (n > 0) {
				int fn = fis.read(bf, 0, BUFSIZE);
				int gn = gis.read(bg, 0, BUFSIZE);
				if (fn != gn) {
					return false;
				}
				if (fn > 0) {
					if (!compareBytes(bf, bg)) {
						return false;
					}
				}
				n = fn;
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Compare files fails!");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception ignored) {
			}
			try {
				if (gis != null) {
					gis.close();
				}
			} catch (Exception ignored) {
			}
		}
		return true;
	}

	private static boolean compareBytes(byte[] a, byte[] b) {
		if (a == null || b == null || (a.length != b.length)) {
			return false;
		}
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Copy a source file to another location (target). Returns true if the file was successfully copied, false if the
	 * copy failed for any reason. If the target exists a backup copy is made with extension ".bak". No exceptions are
	 * thrown.
	 *
	 * @param src
	 *            Source file.
	 * @param trg
	 *            Target file.
	 * @return True if the copy succeeded, false otherwise.
	 */
	public static void copyFile(File src, File trg) {
		if (src == null || trg == null || !src.exists() || !src.isFile()) {
			throw new IllegalArgumentException("Null of invalid arguments in FileUtil.copyFile()");
		}

		boolean trgExists = false;
		if (trg.exists()) {
			backup(trg);
			trgExists = true;
		}

		FileInputStream sis = null;
		FileOutputStream tos = null;
		try {
			sis = new FileInputStream(src);
			if (!trg.exists()) {
				trg.createNewFile();
			}
			tos = new FileOutputStream(trg);

			int n = BUFSIZE;
			byte[] b = new byte[BUFSIZE];
			while (n > 0) {
				n = sis.read(b, 0, BUFSIZE);
				if (n > 0) {
					tos.write(b, 0, n);
				}
			}
		} catch (Exception ex) {
			if (trgExists) { // attempt to restore trg, if it was renamed
				try {
					File file = new File(trg.getAbsolutePath() + ".bak");
					file.renameTo(trg);
				} catch (Exception ignored) {
				}
			}
			throw new MdmiException(ex, "Copy file fails");
		} finally {
			try {
				if (sis != null) {
					sis.close();
				}
			} catch (Exception ignored) {
			}
			try {
				if (tos != null) {
					tos.close();
				}
			} catch (Exception ignored) {
			}
		}
	}

	/**
	 * Copy all the files from source directory to another location (target). Returns true if the directory was copied
	 * successfully, false if the copy failed for any reason. If the target dir exists a backup copy is made with
	 * extension ".bak". No exceptions are thrown.
	 *
	 * @param src
	 *            File Source directory.
	 * @param trg
	 *            File Target directory.
	 * @return True if the copy succeeded, false otherwise.
	 */
	public static void copyFolder(File src, File trg) {
		if (src == null || trg == null || !src.exists() || !src.isDirectory()) {
			throw new IllegalArgumentException("Null of invalid arguments in FileUtil.copyFile()");
		}

		boolean trgRenamed = false;
		if (trg.exists()) {
			backup(trg);
			trgRenamed = true;
		}
		trg.mkdir();

		try {
			File[] fileList = src.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				File srcFile = fileList[i];
				File trgFile = new File(trg, srcFile.getName());
				if (srcFile.isDirectory()) {
					copyFolder(srcFile, trgFile);
				} else {
					copyFile(srcFile, trgFile);
				}
			}
		} catch (Exception ex) {
			if (trgRenamed) { // attempt to restore trg, if it was renamed
				try {
					trg.delete();
					File file = new File(trg.getAbsolutePath() + ".bak");
					file.renameTo(trg);
				} catch (Exception ignored) {
				}
			}
			throw new MdmiException(ex, "Copy folder fails");
		}
	}

	/**
	 * Delete a file. Just like File.delete(), but logs failure.
	 *
	 * @return <code>true</code> if successfully deleted
	 */
	public static boolean deleteFile(File file) {
		if (!file.exists()) {
			return true;
		}
		int count = 0;
		boolean success = false;
		while (!success && count++ < 3) {
			success = file.delete();
			if (!success) {
				try {
					Thread.sleep(1000);
				} catch (Exception ignored) {
				}
			}
		}
		return success;
	}

	/**
	 * Rename a file. Just like File.renameTo(), but logs failure.
	 *
	 * @return <code>true</code> if successfully renamed
	 */
	public static boolean renameFile(String origPath, String destPath) {
		File orig = new File(origPath);
		File dest = new File(destPath);
		if (!orig.exists() || dest.exists()) {
			return false;
		}
		return orig.renameTo(dest);
	}

	/**
	 * Delete all files and sub-folders of the specified path, and then the specified path itself. All exceptions are
	 * ignored.
	 *
	 * @param path
	 *            The path to delete (normally a folder).
	 */
	public static boolean deletePath(File path) {
		if (path == null) {
			throw new IllegalArgumentException("Null path in FileUtil.deletePath()");
		}
		boolean ok = true;
		try {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length && ok; i++) {
				if (files[i].exists() && files[i].isDirectory()) {
					ok = deletePath(files[i]);
				}
			}
			for (int i = 0; i < files.length && ok; i++) {
				if (files[i].exists() && !files[i].isDirectory()) {
					ok = files[i].delete();
				}
			}
			if (ok) {
				if (!path.delete()) {
					ok = false;
				}
			}
		} catch (Exception ex) {
			return false;
		}
		return ok;
	}

	/**
	 * Remove all files from a folder, return false if at least one file could not be deleted. It WILL attempt to remove
	 * all files, even if some fail. Does NOT attempt to remove or empty and sub-folders.
	 *
	 * @param dir
	 *            Folder to empty
	 * @return false if at least one file could not be deleted, true otherwise.
	 */
	public static boolean emptyFolder(File dir) {
		if (dir == null) {
			throw new IllegalArgumentException("Null path in FileUtil.emptyFolder()");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(
				"Invalid path " + dir.getAbsolutePath() + ": not a directory, in FileUtil.emptyFolder()");
		}
		boolean ok = true;
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length && ok; i++) {
			if (files[i].isFile()) {
				ok &= files[i].delete();
			}
		}
		return ok;
	}

	/**
	 * Move a source file to another location (target). Returns true if the file was successfully moveed, false if the
	 * move failed for any reason. If the target exists a backup copy is made with extension ".bak". No exceptions are
	 * thrown.
	 *
	 * @param src
	 *            Source file.
	 * @param trg
	 *            Target file.
	 * @return True if the copy succeeded, false otherwise.
	 */
	public static void moveFile(File src, File trg) {
		if (src == null || trg == null || !src.exists() || !src.isFile()) {
			throw new IllegalArgumentException("Invalid or null arguments in FileUtil.moveFile()");
		}
		try {
			boolean trgExists = false;
			if (trg.exists()) {
				backup(trg);
				trgExists = true;
			}
			copyFile(src, trg);
			if (!src.delete()) {
				try { // attempt to remove the copied file
					trg.delete();
				} catch (Exception ignored) {
				}
				if (trgExists) { // attempt to restore trg, if it was renamed
					try {
						File file = new File(trg.getAbsolutePath() + ".bak");
						file.renameTo(trg);
					} catch (Exception ignored) {
					}
				}
			}
		} catch (Exception ex) {
			throw new MdmiException(ex, "Move file fails");
		}
	}

	/**
	 * Return the file name without path or extension. If the file is one of the special '.', '..' will return it as
	 * such. If the file name begins with '.' return it as such. Otherwise will remove the last '.' and anything
	 * following after it. For example:
	 *
	 * <pre>
	* <p><code>File Name       Returned value</code>
	* <p><code>null            null </code>
	* <p><code>"."             "." </code>
	* <p><code>".."            ".." </code>
	* <p><code>".hidden"       ".hidden" </code>
	* <p><code>"some"          "some" </code>
	* <p><code>"some.txt"      "some" </code>
	* <p><code>"some.file.txt" "some.file" </code>
	 * </pre>
	 *
	 * No checks are made if the file exists, or is a file/directory, etc.
	 *
	 * @param f
	 *            The file
	 * @return The file name with no path or extension
	 */
	public static String getFileName(File f) {
		if (f == null) {
			return null;
		}
		String fn = f.getName();
		if (fn.length() <= 0 || fn.equals(".") || fn.equals("..")) {
			return fn;
		}
		int p = fn.lastIndexOf('.');
		if (p < 0) {
			return fn;
		}
		if (p == 0) {
			return "";
		}
		return fn.substring(0, p);
	}

	/**
	 * Return the file extension (the last part of the name after the last '.').
	 *
	 * @param f
	 *            The file
	 * @return The file extension
	 */
	public static String getFileExtension(File f) {
		if (f == null) {
			return null;
		}
		String fn = f.getName();
		if (fn.length() <= 0 || fn.startsWith(".")) {
			return fn;
		}
		int p = fn.lastIndexOf('.');
		if (p < 0) {
			return "";
		}
		if (p == 0) {
			return fn.substring(1);
		}
		if (p == fn.length() - 1) {
			return "";
		}
		return fn.substring(p + 1);
	}

	/**
	 * Return the relative path of file relative to the directory dir. For example, given the arguments:
	 * <p>
	 * <code>c:/project/temp/src/file.txt</code>, and
	 * <p>
	 * <code>c:/project/temp</code>, it will return:
	 * <p>
	 * <code>src/file.txt</code>
	 *
	 * @param file
	 *            The file
	 * @param dir
	 *            The directory
	 * @return The relative path
	 */
	public static String getPathRelativeToDir(File file, File dir) {
		String filePath = file.getAbsolutePath();
		String dirPath = dir.getAbsolutePath();
		if ((dirPath.length() >= filePath.length()) || filePath.startsWith(dirPath)) {
			throw new MdmiException("Path " + dirPath + " not a subset of " + filePath);
		}
		return filePath.substring(dirPath.length() + 1);
	}

	/**
	 * Return true if it is a valid file name. Windows valid fine names cannot contain: "\ | / : * ? " < > " UNIX valid
	 * fine names cannot contain: "\ \0" We will restrict also " , ' ` ; " and space
	 *
	 * @param s
	 *            Incoming string to be verified.
	 * @return True if the string passed in is a valid file name.
	 */
	public static boolean isValidFileName(String s) {
		if (s == null || s.length() <= 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (INVALID_FILE_NAME_CHARS.indexOf(c) >= 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return a valid file name, replacing all invalid characters with '_'.
	 *
	 * @param s
	 *            Incoming string to be sanitized.
	 * @return A valid file name.
	 */
	public static String sanitizeFileName(String s) {
		if (s == null || s.length() <= 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (INVALID_FILE_NAME_CHARS.indexOf(c) >= 0) {
				sb.setCharAt(i, '_');
			}
		}
		return sb.toString();
	}

	/**
	 * Get a temporary file name, optionally prefixed by the base (if specified) and also optionally using the given
	 * extension (if specified, otherwise ".tmp" will be used). The file folder will be the one specified in the
	 * "java.io.tmpdir" environment variable. The file name will look something like:
	 * <p>
	 * <code>baseRANDOM_UUID.tmp</code>
	 *
	 * @param base
	 *            The prefix for the file name to use (if not specified, none is used).
	 * @param ext
	 *            File extension to use, if not specified ".tmp" will be used.
	 * @return The temporary file name to use.
	 */
	public static File getTempFileName(String base, String ext) {
		if (base == null || base.length() <= 0) {
			base = "";
		}
		if (ext == null || ext.length() <= 0) {
			ext = "tmp";
		}
		UUID uuid = UUID.randomUUID();
		String tmpName = sanitizeFileName(base + uuid.toString() + '.' + ext);
		return new File(System.getProperty("java.io.tmpdir"), tmpName);
	}

	/**
	 * Creates the directory named by this abstract dirName, including any necessary but nonexistent parent directories.
	 *
	 * @param dirName
	 * @throws IOException
	 */
	public static void createDir(final String dirName) throws IOException {
		final File dir = new File(dirName);
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException("Unable to create " + dir.getAbsolutePath());
		}
	}
} // FileUtil
