package mil.yaye.yours.common;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

public class StrutsFileUpload {
	
	private static final Log log = LogFactory.getLog(StrutsFileUpload.class);

	private String errorMessage = null;
	
	
	private FormFile uploadFile = null;                       //上传的文件对象;
	private int fileSize = 0;                                 //文件大小;
	private String fileName = null;                           //文件名，包含扩展名;
	private String filenameExtension = null;                  //文件扩展名;
	private String allowFileType = null;                      //允许上传的文件类型扩展名，多个以逗号","分隔;
	private int maxSize = GlobalNames.UPLOAD_FILE_SIZE;       //允许上传的文件大小最大值，单位byte;
	private String fileSavePath = GlobalNames.UPLOAD_PATH;    //文件保存的文件夹路径，不包含文件名
	
	public StrutsFileUpload(FormFile uploadFile) throws AppException {
		super();
		this.uploadFile = uploadFile;
		this.fileSize = uploadFile.getFileSize();
		this.fileName = uploadFile.getFileName();
		this.filenameExtension = this.getFilenameExtension(uploadFile.getFileName());
		this.allowFileType = this.filenameExtension;
	}
	
	/**
	 * 设置文件保存在服务器上的绝对路径,若设置为null则使用默认值：GlobalNames.UPLOAD_PATH;
	 * @param fileSavePath
	 */
	public void setFileSavePath(String fileSavePath) {
		if( fileSavePath!=null )
			this.fileSavePath = fileSavePath;
		else
			this.fileSavePath = GlobalNames.UPLOAD_PATH;
	}
	
	
	/**
	 * 设置允许上传的文件类型，多种文件类型用逗号","分隔;如：
	 * 文本文件：".txt";   word文件: ".doc";
	 * 图片文件：".jpg,.jpeg,.gif,.png,.bmp";
	 * .rar文件：".rar";
	 * @param allowFileType
	 */
	public void setAllowFileType(String allowFileType) {
		this.allowFileType = allowFileType;
	}

	/**
	 * 获取允许上传文件的最大值
	 * @return int:单位：byte
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * 设置允许上传文件的最大值，单位：byte
	 * 若小于等于0则用默认值：GlobalNames.UPLOAD_FILE_SIZE;
	 * @param maxSize
	 */
	public void setMaxSize(int maxSize) {
		if( maxSize>0 )
			this.maxSize = maxSize;
		else
			this.maxSize = GlobalNames.UPLOAD_FILE_SIZE;
	}

	/**
	 * 获取文件大小
	 * @return int:单位：byte
	 */
	public int getFileSize() {
		return fileSize;
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String saveFile() throws AppException
	{
		String filePathReturn = null;
		OutputStream fOutStream = null;
		BufferedOutputStream bOutStream = null;
		
		if( uploadFile==null )
		{
			errorMessage = "上传文件失败！未找到您要上传的文件路径！请正确选择您要上传的文件！";
			log.error(errorMessage);
			throw new AppException( errorMessage );
		}else if( fileSize>maxSize )
		{
			errorMessage = "上传文件失败！您上传的文件过大！上传文件不能大于：" + (maxSize/1024) + "KB";
			log.info(errorMessage);
			throw new AppException( errorMessage );
		}else if( !this.validateFileType(allowFileType, filenameExtension) )
		{
			errorMessage = "上传文件失败！您上传的文件格式不符合要求!";
			log.info(errorMessage);
			throw new AppException( errorMessage );
		}else
		{
			try {
				byte[] fileData = uploadFile.getFileData();
				
				fOutStream = new FileOutputStream(fileSavePath+fileName);
				bOutStream = new BufferedOutputStream(fOutStream);
				bOutStream.write(fileData);
				fOutStream.flush();
				
				uploadFile.destroy();
				filePathReturn = fileName;
				
			} catch (FileNotFoundException e) {
				errorMessage = "上传文件失败！未找到文件保存在服务器上的路径！请与系统管理员联系！";
				log.error(errorMessage, e);
				throw new AppException( errorMessage );
			} catch (IOException e) {
				errorMessage = "上传文件失败！您上传的文件格式不符合要求，或服务器忙！请稍后再试！"+e.getMessage();
				log.error(errorMessage, e);
				throw new AppException( errorMessage );
			} finally{
				try {
					if( fOutStream!=null ){
						fOutStream.close();
					}
					if( bOutStream!=null ){
						bOutStream.close();
					}
				} catch (IOException ie) {
					throw new AppException( "关闭IO流出现错误！"+ie.getMessage() );
				}
			}
		}
		
		return filePathReturn;
	}
	
	
	/**
	 * 获取文件扩展名；如：".jpg";
	 * @param filename:文件名，如："123.jpg";
	 * @return String：返回文件扩展名，如：".jpg"。
	 * @throws AppException 
	 */
	public String getFilenameExtension(String filename) throws AppException
	{
		String extensiveName = null;
		
		int index = filename.lastIndexOf(".");
		if( index>=0 )
			extensiveName = (filename.substring(index)).toLowerCase();
		else{
			throw new AppException("文件类型错误！该文件的文件名未以正确的扩展名结束");
		}
		return extensiveName;
	}
	
	/**
	 * 验证允许上传的文件类型；
	 * @param allowFileType：允许上传的文件类型；
	 * @param fileType：当前要上传的文件的文件类型，如：".jpeg";
	 * @return boolean: allowFileType中含有fileType返回true,否则返回false.
	 */
	private boolean validateFileType(String allowFileType, String fileType)
	{
		boolean booReturn = false;
		String[] types = null;
		
		if( allowFileType!=null ){
			types = allowFileType.split(",");
			for (int i = 0; i < types.length; i++) {
				if( types[i].equals(fileType) ){
					booReturn = true;
					break;
				}
			}
		}
		
		return booReturn;
	}
	
	
	/*
	 * 设置允许上传的文件类型，多种文件类型用逗号","分隔;
	 * 文本文件：text/plain; word文件: application/msword;
	 * 图片文件：image/pjpeg, image/gif, image/x-png, image/bmp;
	 * .rar文件：application/octet-stream;
	 * @param allowFileType
	 */

}
