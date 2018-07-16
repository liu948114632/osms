package com.itecheasy.common.picture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.itecheasy.common.SystemConfig;
import com.itecheasy.common.po.FTPUploadLogPO;
import com.itecheasy.common.po.PictureStorePO;
import com.itecheasy.common.po.PictureStoreRule;
import com.itecheasy.common.po.PictureUrlRule;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DeployProperties;
import com.itecheasy.common.util.PictureUtils;

public class PictureServiceImpl implements PictureService {
	private static Logger logger = Logger.getLogger(PictureServiceImpl.class);
	private List<PictureStoreRule> pictureStoreRule;
	private List<PictureUrlRule> pictureUrlRule;
	private PictureDAO pictureDAO;
	private FTPUploadLogDao ftpUploadLogDao;
	

	public void setFtpUploadLogDao(FTPUploadLogDao ftpUploadLogDao) {
		this.ftpUploadLogDao = ftpUploadLogDao;
	}

	public PictureDAO getPictureDAO() {
		return this.pictureDAO;
	}

	public void setPictureDAO(PictureDAO pictureDAO) {
		this.pictureDAO = pictureDAO;
	}

	public void initialize() {
		this.pictureStoreRule = this.pictureDAO.getAllPictureStoreRule();
		this.pictureUrlRule = this.pictureDAO.getAllPictureUrlRule();
	}

	@Override
	public String addPicture(String modelType, String modelId, String pictureName, String description, File file) {
		try {
			if (file == null) {
				logger.error("file is null, picture " + modelType + "," + modelId + "," + pictureName);
				return "";
				// throw new RuntimeException("file is null.");
			}
			/*
			 * PictureStorePO pictureStore = getPictureInfo(modelType,
			 * modelId,pictureName); if (pictureStore != null) { throw new
			 * RuntimeException("picture " + modelType + "," + modelId + "," +
			 * pictureName + " already exists."); }
			 */

			String code = UUID.randomUUID().toString();

			PictureStorePO info = new PictureStorePO();
			info.setModelType(modelType);
			info.setModelId(modelId);
			info.setPictureCode(code);
			info.setCreateTime(new Date());
			String tmpFilename = file.getName();
			int pos = tmpFilename.lastIndexOf(".");
			String ext = tmpFilename.substring(pos + 1);

			if (StringUtils.isEmpty(pictureName)) {
				pictureName = code + "." + ext;
			}
			info.setPictureName(pictureName);
			info.setFilename(pictureName);
			info.setDescription(description);
			/*
			 * try { BufferedImage image = ImageIO.read(file);
			 * info.setWidth(Integer.valueOf(image.getWidth()));
			 * info.setHeight(Integer.valueOf(image.getHeight())); } catch
			 * (IOException e) { logger.error(e); }
			 */
			this.pictureDAO.addObject(info);

			File destFile = new File(getPictureStorePath(modelType, modelId, info.getCreateTime()) + info.getFilename());
			FileUtils.copyFile(file, destFile);
			// ftp upload
			FTPImage(destFile.getAbsolutePath(), modelType, modelId, pictureName);
			return info.getPictureCode();
		} catch (IOException e) {
			throw new RuntimeException("can not copy file " + file.getAbsolutePath(), e);
		}

	}

	private void FTPImage(String localFile, String modelType, String modelId, String pictureName) {
		StringBuffer sb = new StringBuffer("/");
		sb.append(modelType).append("/").append(modelId).append("/").append(pictureName);
		
		FTPUploadLogPO po=new FTPUploadLogPO();
		po.setIp(DeployProperties.getInstance().getProperty("ftp.url"));
		po.setPort(DeployProperties.getInstance().getProperty("ftp.port"));
		po.setName(DeployProperties.getInstance().getProperty("ftp.name"));
		po.setPwd(DeployProperties.getInstance().getProperty("ftp.pwd"));
		po.setLocalName(localFile);
		po.setRemoteName(sb.toString());
		po.setObjectId(Integer.valueOf(modelId));
		po.setType(FTPType.UPLOAD);
		po.setStatus(FTPStatus.FAILED);
		
		ftpUploadLogDao.addObject(po);
		
//		ContinueFTP ftp = new ContinueFTP(DeployProperties.getInstance().getProperty("ftp.url"), DeployProperties
//				.getInstance().getProperty("ftp.name"), DeployProperties.getInstance().getProperty("ftp.pwd"),
//				DeployProperties.getInstance().getProperty("ftp.port"), localFile, sb.toString());
//		ftp.run();
//		if (ftp.getStatus() == UploadStatus.Upload_From_Break_Success
//				|| ftp.getStatus() == UploadStatus.Upload_New_File_Success) {
//			return true;
//		}
//		return false;
	}

	private void FTPDeleteImage(String modelType, String modelId, String pictureName) {
		StringBuffer sb = new StringBuffer("/");
		sb.append(modelType).append("/").append(modelId).append("/").append(pictureName);
//		ContinueFTP ftp = new ContinueFTP(DeployProperties.getInstance().getProperty("ftp.url"), DeployProperties
//				.getInstance().getProperty("ftp.name"), DeployProperties.getInstance().getProperty("ftp.pwd"),
//				DeployProperties.getInstance().getProperty("ftp.port"), "", "");
		
		FTPUploadLogPO po=new FTPUploadLogPO();
		po.setIp(DeployProperties.getInstance().getProperty("ftp.url"));
		po.setPort(DeployProperties.getInstance().getProperty("ftp.port"));
		po.setName(DeployProperties.getInstance().getProperty("ftp.name"));
		po.setPwd(DeployProperties.getInstance().getProperty("ftp.pwd"));
		po.setLocalName("");
		po.setRemoteName(sb.toString());
		po.setObjectId(Integer.valueOf(modelId));
		po.setType(FTPType.DELETE);
		po.setStatus(FTPStatus.FAILED);
		
		ftpUploadLogDao.addObject(po);
//		try {
//			boolean isSuccess = ftp.deleteFile(sb.toString());
//			return isSuccess;
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ftp.disconnect();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
	}

	@Override
	public String[] addPictureList(String modelType, String modelId, String[] pictureName, String[] description,
			File[] file) {
		int count = file.length;
		String[] ret = new String[count];
		for (int i = 0; i < count; i++) {
			ret[i] = addPicture(modelType, modelId, pictureName[i], description[i], file[i]);
		}
		return ret;
	}

	@Override
	public File getPictureFile(String pictureCode) {
		PictureStorePO info = getPictureInfo(pictureCode);
		if (info == null) {
			return null;
		}
		File file = new File(getPictureStorePath(info.getModelType(), info.getModelId(), info.getCreateTime())
				+ info.getFilename());
		if (!file.exists()) {
			file = getNewFile(info.getModelType(), info.getModelId(), info.getFilename(), info.getCreateTime());
		}
		return file;
	}

	private File getNewFile(String modelType, String modelId, String filename, Date time) {
		InputStream is = null;
		try {
			StringBuilder ub = new StringBuilder();
			ub.append(SystemConfig.getDownURL());
			if (StringUtils.isNotEmpty(modelType)) {
				ub.append("/");
				ub.append(modelType);
			}
			if (StringUtils.isNotEmpty(modelId)) {
				ub.append("/");
				ub.append(modelId);
			}
			ub.append("/" + filename);
			URL url = new URL(ub.toString().replaceAll(" ", "%20"));
			URLConnection uc = url.openConnection();
			is = uc.getInputStream();
			String path = SystemConfig.getTempPictureFilePath();
			if (!path.endsWith("/")) {
				path = path + "/";
			}
			File file = new File(path + filename);
			FileOutputStream out = new FileOutputStream(file);
			int i = 0;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			out.flush();
			out.close();
			File destFile = new File(getPictureStorePath(modelType, modelId, time) + filename);
			FileUtils.copyFile(file, destFile);
			if (file.exists()) {
				file.delete();
			}
			return destFile;
		} catch (Exception e) {
			logger.error(e.getMessage());
			// throw new RuntimeException(e.getMessage());
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}

	@Override
	public File getPictureFile(String pictureCode, int width, int height) {
		String filename = getPictureFileName(pictureCode, width, height);
		if (filename == null) {
			return null;
		}
		File file = new File(filename);
		if (file.exists()) {
			return file;
		}
		resizePicture(pictureCode, width, height);
		return file;
	}

	@Override
	public File getPictureFile(String modelType, String modelId, String pictureName) {
		return getPictureFile(getPictureCode(modelType, modelId, pictureName));
	}

	@Override
	public File getPictureFile(String modelType, String modelId, String pictureName, int width, int height) {
		return getPictureFile(getPictureCode(modelType, modelId, pictureName), width, height);
	}

	@Override
	public File getPictureFile(String modelType, String pictureName, int width, int height) {
		return getPictureFile(getPictureCode(modelType, pictureName), width, height);
	}

	@Override
	public List<File> getPictureFileList(String modelType, String modelId) {
		List<PictureStorePO> infoList = getPictureInfoList(modelType, modelId);
		List<File> ret = new LinkedList<File>();
		for (PictureStorePO info : infoList) {
			ret.add(getPictureFile(info.getPictureCode()));
		}
		return ret;
	}

	@Override
	public List<File> getPictureFileList(String modelType, String modelId, int width, int height) {
		List<PictureStorePO> infoList = getPictureInfoList(modelType, modelId);
		List<File> ret = new LinkedList<File>();
		for (PictureStorePO info : infoList) {
			ret.add(getPictureFile(info.getPictureCode(), width, height));
		}
		return ret;
	}

	@Override
	public PictureStorePO getPictureInfo(String pictureCode) {
		if (StringUtils.isEmpty(pictureCode)) {
			return null;
		}
		PictureStorePO ret = this.pictureDAO.getObject(pictureCode);

		if (ret != null) {
			File pictureFile = new File(getPictureStorePath(ret.getModelType(), ret.getModelId(), ret.getCreateTime())
					+ ret.getFilename());
			if (!pictureFile.exists()) {
				pictureFile = getNewFile(ret.getModelType(), ret.getModelId(), ret.getFilename(), ret.getCreateTime());
			}
		}
		return ret;
	}

	@Override
	public PictureStorePO getPictureInfo(String modelType, String modelId, String pictureName) {
		return getPictureInfo(getPictureCode(modelType, modelId, pictureName));
	}

	@Override
	public PictureStorePO getPictureInfo(String modelType, String pictureName) {
		return getPictureInfo(getPictureCode(modelType, pictureName));
	}

	@Override
	public List<PictureStorePO> getPictureInfoList(String modelType, String modelId) {
		return this.pictureDAO.findListByHql("from PictureStorePO p where p.modelType = ? and p.modelId = ?",
				new Object[] { modelType, modelId });
	}

	@Override
	public String getPictureURL(String pictureCode) {
		PictureStorePO info = getPictureInfo(pictureCode);
		return getPictureUrlPath(info.getModelType(), info.getModelId()) + info.getFilename();
	}

	@Override
	public String getPictureURL(String pictureCode, int width, int height) {
		getPictureFile(pictureCode, width, height);
		return getPictureUrlName(pictureCode, width, height);
	}

	@Override
	public String getPictureURL(String modelType, String modelId, String pictureName) {
		return getPictureURL(getPictureCode(modelType, modelId, pictureName));
	}

	@Override
	public String getPictureURL(String modelType, String modelId, String pictureName, int width, int height) {
		return getPictureURL(getPictureCode(modelType, modelId, pictureName), width, height);
	}

	@Override
	public List<String> getPictureURLList(String modelType, String modelId) {
		List<PictureStorePO> infoList = getPictureInfoList(modelType, modelId);
		List<String> ret = new LinkedList<String>();
		for (PictureStorePO info : infoList) {
			ret.add(getPictureURL(info.getPictureCode()));
		}
		return ret;
	}

	@Override
	public List<String> getPictureURLList(String modelType, String modelId, int width, int height) {
		List<PictureStorePO> infoList = getPictureInfoList(modelType, modelId);
		List<String> ret = new LinkedList<String>();
		for (PictureStorePO info : infoList) {
			ret.add(getPictureURL(info.getPictureCode(), width, height));
		}
		return ret;
	}

	@Override
	public void deletePicture(String pictureCode) {
		PictureStorePO info = getPictureInfo(pictureCode);
		if (info != null) {
//			File file = new File(getPictureStorePath(info.getModelType(), info.getModelId(), info.getCreateTime())
//					+ info.getFilename());
//			deltePictureFile2Min(pictureCode,file.getAbsolutePath(), 40, 40);
			this.pictureDAO.deleteObject(info);

			// ftp 删除图片
			FTPDeleteImage(info.getModelType(), info.getModelId(), info.getPictureName());
		}
		deletePictureFile(pictureCode);
	}
	
//	public void deltePictureFile2Min(String pictureCode,String filename, int width, int height) {
//		int pos = filename.lastIndexOf(".");
//		String fileType = filename.substring(pos + 1);
//		String minname= filename.substring(0, pos) + "." + width + "-" + height + "." + fileType;
//		
//		File file = new File(minname);
//		if (!file.exists()) {
//			return ;
//		}
//		file.delete();
//	}

	
	@Override
	public void deletePicture(String modelType, String modelId, String pictureName) {
		deletePicture(getPictureCode(modelType, modelId, pictureName));
	}

	@Override
	public void deletePictureList(String[] pictureCode) {
		for (String code : pictureCode)
			deletePicture(code);
	}

	@Override
	public void deletePictureList(String modelType, String modelId, String[] pictureName) {
		for (String name : pictureName)
			deletePicture(modelType, modelId, name);
	}

	@Override
	public int deleteModelId(String modelType, String modelId) {
		throw new RuntimeException("under construction.");
	}

	@Override
	public void updatePictureInfo(String pictureCode, String description) {
		PictureStorePO info = getPictureInfo(pictureCode);
		info.setDescription(description);
		this.pictureDAO.updateObject(info);
	}

	@Override
	public void updatePictureInfo(String modelType, String modelId, String pictureName, String description) {
		updatePictureInfo(getPictureCode(modelType, modelId, pictureName), description);
	}

	@Override
	public void updatePictureInfoList(String[] pictureCode, String[] description) {
		int count = pictureCode.length;
		for (int i = 0; i < count; i++)
			updatePictureInfo(pictureCode[i], description[i]);
	}

	@Override
	public void updatePictureInfoList(String modelType, String modelId, String[] pictureName, String[] description) {
		int count = pictureName.length;
		for (int i = 0; i < count; i++)
			updatePictureInfo(modelType, modelId, pictureName[i], description[i]);
	}

	private void resizePicture(String pictureCode, int width, int height) {
		String destFile = getPictureFileName(pictureCode, width, height);
		File f = new File(destFile);
		if ((f.exists()) && (!f.delete())) {
			throw new RuntimeException(f.getAbsolutePath() + " can not be deleted.");
		}

		PictureUtils.resizePicture(getPictureFile(pictureCode), destFile, width, height);
	}

	private String getPictureCode(String modelType, String modelId, String pictureName) {
		PictureStorePO info = this.pictureDAO.findByHql(
				"from PictureStorePO p where p.modelType = ? and p.modelId = ? and p.pictureName = ?", new Object[] {
						modelType, modelId, pictureName });
		if (info == null) {
			return null;
		}
		return info.getPictureCode();
	}

	private void deletePictureFile(String pictureCode) {
		File file = getPictureFile(pictureCode);
		if (file != null) {
			file.delete();
			PictureStorePO info = getPictureInfo(pictureCode);
			String path = getPictureStorePath(info.getModelType(), info.getModelId(), info.getCreateTime());

			String filename = file.getName();
			int pos = filename.lastIndexOf(".");
			final String s = filename.substring(0, pos);
			File[] resizedFile = new File(path).listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.startsWith((new StringBuilder(String.valueOf(s))).append(".").toString());
				}
			});
			if (resizedFile != null)
				for (File f : resizedFile)
					f.delete();
		}
	}

	private String getPictureUrlPath(String modelType, String modelId) {
		if (this.pictureUrlRule.size() > 0) {
			String path = ((PictureUrlRule) this.pictureUrlRule.get(0)).getUrlPath();
			if (!path.endsWith("/")) {
				path = path + "/";
			}
			StringBuilder ub = new StringBuilder();
			ub.append(path);
			if (StringUtils.isNotEmpty(modelType)) {
				ub.append("/");
				ub.append(modelType);
			}
			if (StringUtils.isNotEmpty(modelId)) {
				ub.append("/");
				ub.append(modelId);
			}
			ub.append("/");
			return ub.toString();
		}
		throw new RuntimeException("can not find picture url rule.");
	}

	private String getPictureStorePath(String modelType, String modelId, Date createDate) {
		if (CollectionUtils.isEmpty(this.pictureStoreRule)) {
			throw new RuntimeException("can not find picture store rule.");
		}
		// long createTime = createDate.getTime();
		String path = StringUtils.EMPTY;
		for (PictureStoreRule rule : this.pictureStoreRule) {
			path = rule.getStorePath();
			break;
			/*
			 * //按时间规则 String[] ruleTimes = rule.getPictureRule().split(",");
			 * long startRuleTime =
			 * DateUtils.convertDate(ruleTimes[0]).getTime(); long endRuleTime =
			 * Long.MAX_VALUE; if(!"Max".equalsIgnoreCase(ruleTimes[1])){
			 * endRuleTime = DateUtils.convertDate(ruleTimes[1]).getTime(); }
			 * if(startRuleTime <= createTime && createTime < endRuleTime){ path
			 * = rule.getStorePath(); break; }
			 */
		}
		if (StringUtils.isEmpty(path)) {
			throw new RuntimeException("can not find picture store rule.");
		}
		if (!path.endsWith("/")) {
			path = path + "/";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(path);
		if (StringUtils.isNotEmpty(modelType)) {
			sb.append("/");
			sb.append(modelType);
		}
		if (StringUtils.isNotEmpty(modelId)) {
			sb.append("/");
			sb.append(modelId);
		}
		sb.append("/");
		return sb.toString();

	}

	private String getPictureFileName(String pictureCode, int width, int height) {
		File file = getPictureFile(pictureCode);
		if (file == null) {
			return null;
		}
		String filename = file.getAbsolutePath();
		int pos = filename.lastIndexOf(".");
		if (pos == -1) {
			return null;
		}
		String fileType = filename.substring(pos + 1);
		return filename.substring(0, pos) + "." + width + "-" + height + "." + fileType;
	}

	private String getPictureUrlName(String pictureCode, int width, int height) {
		String url = getPictureURL(pictureCode);
		int pos = url.lastIndexOf(".");
		String fileType = url.substring(pos + 1);
		return url.substring(0, pos) + "." + width + "-" + height + "." + fileType;
	}

	@Override
	public File getPictureFile(String modelType, String pictureName) {
		return getPictureFile(getPictureCode(modelType, pictureName));
	}

	private String getPictureCode(String modelType, String pictureName) {
		String hql = "from PictureStorePO p where 1=1 ";

		if (!StringUtils.isEmpty(pictureName)) {
			hql += " and pictureName = '" + pictureName + "'";
		}
		if (!StringUtils.isEmpty(modelType)) {
			hql += " and modelType = '" + modelType + "'";
		}
		PictureStorePO info = pictureDAO.findByHql(hql);

		if (info == null) {
			return null;
		}
		return info.getPictureCode();
	}
}