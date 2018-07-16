package com.itecheasy.communication.util;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Operater {
	private static final String encoding = "gbk";

	public static List<CData> readDatas(String directionPath) {
		File[] files = FileUtils.getFiles(directionPath, ".xml");
		List<CData> datas = new LinkedList<CData>();
		if (files.length == 0) {
			return datas;
		}
		List<FileDate> fileDateList = new LinkedList<FileDate>();
		for (File f : files) {
			fileDateList.add(new FileDate(f, UuidHelp.getDateFromUuid(FileUtils
					.getFileNameWithoutExtension(f.getName()))));
		}
		Collections.sort(fileDateList, new Comparator<FileDate>() {
			@Override
			public int compare(FileDate o1, FileDate o2) {
				return o1.getCreateDate().compareTo(o2.getCreateDate());
			}
		});
		for (FileDate fd : fileDateList) {
			datas.add(readData(fd.getFile().getPath()));
		}
		return datas;
	}

	public static CData readData(String filePath) {
		String xml = FileUtils.readFile(filePath, encoding);
		CData cData = XmlUtils.xmlToEntity(XmlUtils.HEADER + xml);
		cData.setFilePath(filePath);
		cData.setFileName(FileUtils.getFileName(filePath));
		return cData;
	}

	public static void moveData(CData cData, String targetDirectionPath) {
		String targetFileName = FileUtils.getDirectionPath(targetDirectionPath)
				+ cData.getFileName();
		FileUtils.moveFile(cData.getFilePath(), targetFileName);
		cData.setFilePath(targetFileName);
	}

	public static void copyDataTo(CData cData, String targetDirectionPath) {
		String targetFilePath = FileUtils.getDirectionPath(targetDirectionPath)
				+ cData.getFileName();
		try {
			FileUtils.copyFile(cData.getFilePath(), targetFilePath, false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void deleteData(CData cData) {
		FileUtils.deleteFile(cData.getFilePath());
	}

	public static void writeData(CData cData, String targetDirectionPath) {
		if (cData == null) {
			throw new NullPointerException("cData is null.");
		}
		String fileName = UuidHelp.getDateUuid() + ".xml";
		String filePath = FileUtils.getDirectionPath(targetDirectionPath)
				+ fileName;
		String tempFilePath = filePath + ".temp";
		File file = new File(filePath);
		if (file.exists()) {
			throw new RuntimeException("The file(" + filePath + ") has exsits.");
		}
		String content = XmlUtils.getCDataXml(cData);
		FileUtils.writeFile(tempFilePath, content, false, encoding);
//		File tempFile = new File(tempFilePath);
		
//		tempFile.renameTo(file);
		cData.setTempFilePath(tempFilePath);
		cData.setFilePath(filePath);
		cData.setFileName(fileName);
	}

	public static void main(String[] args) {
		String path = "C:\\";
		CData cData = new CData("test1", 1, "a");
		cData.addOperateData("dd", 1);
		cData.addOperateData("a", "b");
		cData.addOperateData("dd", "Форма");
		cData.addOperateData("dbb","中国,Beutelgröße");
		 cData.writeData(path);

		CData cData2 = new CData("test2", 1, "a");
		cData2.addOperateData("dd", 1);
		// cData2.writeData(path);

		List<CData> datas = readDatas(path);
		for (CData c : datas) {
			System.out.println(c.getFileName());
		}
	}

}
