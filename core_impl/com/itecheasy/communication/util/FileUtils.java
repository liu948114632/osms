package com.itecheasy.communication.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {
	public static final String Encoding_UTF8 = "utf-8";

	public static enum SortType {
		LastModifiedDate, LastModifiedDate_Desc
	}

	public static String readFile(String fileName, String charsetName) {
		BufferedReader reader = null;
		FileInputStream fr = null;
		StringBuilder sb = new StringBuilder();
		try {
			fr = new FileInputStream(fileName);
			InputStreamReader is = new InputStreamReader(fr, charsetName);
			reader = new BufferedReader(is);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return sb.toString();
	}

	public static void writeFile(String fileName, String content,
			boolean isAppend, String charsetName) {
		FileOutputStream stream = null; // provides file access
		OutputStreamWriter writer = null; // writes to the file
		try {
			stream = new FileOutputStream(fileName, isAppend);
			writer = new OutputStreamWriter(stream, charsetName);
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	/**
	 * 移动文件
	 * 
	 * @param sourceFilePath
	 *            源文件完整路径
	 * @param targetFilePath
	 *            目标文件完整路径
	 */
	public static void moveFile(String sourceFilePath, String targetFilePath) {
		File sourceFile = new File(sourceFilePath);
		File targetFile = new File(targetFilePath);
		if (!sourceFile.exists()) {
			throw new RuntimeException("Cannot find the file(" + sourceFile
					+ ").");
		}
		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		} else if (targetFile.exists()) {
			throw new RuntimeException("Failed to move file. The file("
					+ targetFile.getPath() + ") has exits.");
		}
		sourceFile.renameTo(targetFile);
		// sourceFile.delete();
	}

	public static void copyFile(String sourceFilePath, String targetFilePath,
			boolean overwrite) throws IOException {
		File sourceFile = new File(sourceFilePath);
		File targetFile = new File(targetFilePath);
		copyFile(sourceFile, targetFile, overwrite);
	}

	public static void copyFile(File filefrom, File fileto, boolean overwrite)
			throws IOException {
		if (!filefrom.exists()) {
			throw new FileNotFoundException("Cannot find the file("
					+ filefrom.getPath() + ").");
		}
		if (!fileto.getParentFile().exists()) {
			fileto.getParentFile().mkdirs();
		}
		if (fileto.exists()) {
			if (overwrite) {
				fileto.delete();
			} else {
				throw new IOException("Failed to copy. The file has exits.("
						+ fileto.getPath() + ").");
			}
		}

		// 新建文件输入流并对它进行缓冲
		FileInputStream input = new FileInputStream(filefrom);
		BufferedInputStream inBuff = new BufferedInputStream(input);
		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(fileto);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);

		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();
		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
		input.close();
	}

	public static boolean existFile(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static void deleteFile(String filePath) {
		File sourceFile = new File(filePath);
		if (sourceFile.exists()) {
			sourceFile.delete();
		}
	}

	public static void remaneFile(String sourceFilePath, String newFileName) {
		File sourceFile = new File(sourceFilePath);
		File targetFile = new File(sourceFile.getParent() + File.separator
				+ newFileName);
		if (targetFile.exists()) {
			throw new RuntimeException("Failed to remane. The file("
					+ targetFile.getPath() + ") has exits.");
		}
		sourceFile.renameTo(targetFile);
	}

	/**
	 * 获取目录下所有文件
	 * 
	 * @param sourcePath
	 *            文件夹路径
	 */
	public static File[] getFiles(String sourcePath) {
		return getFiles(sourcePath, null, null);
	}

	/**
	 * 获取目录下所有文件
	 * 
	 * @param sourcePath
	 *            文件夹路径
	 * @param extension
	 *            文件的扩展名(如：.xml)
	 * @return
	 */
	public static File[] getFiles(String sourcePath, final String extension) {
		return getFiles(sourcePath, extension, null);
	}

	/**
	 * 获取目录下所有文件
	 * 
	 * @param sourcePath
	 *            文件夹路径
	 * @param extension
	 *            文件的扩展名(如：.xml)
	 * @return
	 */
	public static File[] getFiles(String sourcePath, final String extension,
			SortType sortType) {
		File file = new File(sourcePath);
		if (!file.isDirectory()) {
			throw new RuntimeException("is not directory.");
		}
		File[] files = null;
		if (extension == null) {
			file.listFiles();
		} else {
			files = file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File acceptFile) {
					return extension
							.equalsIgnoreCase(getFileExtension(acceptFile
									.getName()));
				}
			});
		}
		if (files == null) {
			return new File[0];
		}
		if (sortType == null) {
			return files;
		}
		if (SortType.LastModifiedDate == sortType) {
			Arrays.sort(files, new Comparator<File>() {
				@Override
				public int compare(File o1, File o2) {
					return o1.lastModified() > o2.lastModified() ? 1 : 0;
				}
			});
		} else if (SortType.LastModifiedDate_Desc == sortType) {
			Arrays.sort(files, new Comparator<File>() {
				@Override
				public int compare(File o1, File o2) {
					return o1.lastModified() > o2.lastModified() ? 0 : 1;
				}
			});
		}
		return files;
	}

	public static String getDirectionPath(String directionPath) {
		if (directionPath.endsWith("\\") || directionPath.endsWith("/")) {
			return directionPath;
		} else {
			return directionPath + "\\";
		}
	}

	public static String getFileName(String filePath) {
		filePath = filePath.replace("\\", "/");
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}

	public static String getFileNameWithoutExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return fileName;
		}
		return fileName.substring(0, index);
	}

	/**
	 * 获取文件后缀，带点
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return fileName;
		}
		return fileName.substring(index);
	}

	public static void main(String[] args) {

	}
}
