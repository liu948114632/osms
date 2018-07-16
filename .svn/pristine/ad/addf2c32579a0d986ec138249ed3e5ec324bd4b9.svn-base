package com.itecheasy.common.picture;

import java.io.File;
import java.util.List;

import com.itecheasy.common.po.PictureStorePO;

public interface PictureService {

	public abstract String addPicture(String modelType, String modelId,
			String pictureName, String description, File file);

	public abstract String[] addPictureList(String modelType, String modelId,
			String[] pictureName, String[] description, File[] file);

	public abstract File getPictureFile(String pictureCode);

	public abstract File getPictureFile(String pictureCode, int width,
			int height);

	public abstract File getPictureFile(String modelType, String modelId,
			String pictureName);
	
	public abstract File getPictureFile(String modelType,String pictureName);

	public abstract File getPictureFile(String modelType, String modelId,
			String pictureName, int width, int height);
	
	public abstract File getPictureFile(String modelType,
			String pictureName, int width, int height);

	public abstract List<File> getPictureFileList(String modelType,
			String modelId);

	public abstract List<File> getPictureFileList(String modelType,
			String modelId, int width, int height);

	public abstract PictureStorePO getPictureInfo(String pictureCode);

	public abstract PictureStorePO getPictureInfo(String modelType,
			String modelId, String pictureName);
	
	public abstract PictureStorePO getPictureInfo(String modelType,String pictureName);

	public abstract List<PictureStorePO> getPictureInfoList(String modelType,
			String modelId);

	public abstract String getPictureURL(String pictureCode);

	public abstract String getPictureURL(String pictureCode, int width,
			int height);

	public abstract String getPictureURL(String modelType, String modelId,
			String pictureName);

	public abstract String getPictureURL(String modelType, String modelId,
			String pictureName, int width, int height);

	public abstract List<String> getPictureURLList(String modelType,
			String modelId);

	public abstract List<String> getPictureURLList(String modelType,
			String modelId, int width, int height);

	public abstract void deletePicture(String pictureCode);

	public abstract void deletePicture(String modelType, String modelId,
			String pictureName);

	public abstract void deletePictureList(String[] pictureCode);

	public abstract void deletePictureList(String modelType, String modelId,
			String[] pictureName);

	public abstract int deleteModelId(String modelType, String modelId);

	public abstract void updatePictureInfo(String pictureCode,
			String description);

	public abstract void updatePictureInfo(String modelType, String modelId,
			String pictureName, String description);

	public abstract void updatePictureInfoList(String[] pictureCode,
			String[] description);

	public abstract void updatePictureInfoList(String modelType,
			String modelId, String[] pictureName, String[] description);
}
