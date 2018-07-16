package com.itecheasy.core.product;

/**
 * @author wanghw
 * @date 2015-3-25
 * @description 导出图片返回对象
 * @version
 */
public class ExportPic {
	private int prodcutId;
	private String exportName;
	private String pictureCode;
	private byte[] pic;

	public int getProdcutId() {
		return prodcutId;
	}

	public void setProdcutId(int prodcutId) {
		this.prodcutId = prodcutId;
	}

	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	public String getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exportName == null) ? 0 : exportName.hashCode());
		result = prime * result + prodcutId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExportPic other = (ExportPic) obj;
		if (exportName == null) {
			if (other.exportName != null)
				return false;
		} else if (!exportName.equals(other.exportName))
			return false;
		if (prodcutId != other.prodcutId)
			return false;
		return true;
	}

	
	
}
