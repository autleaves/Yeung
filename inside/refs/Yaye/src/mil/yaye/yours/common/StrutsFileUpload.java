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
	
	
	private FormFile uploadFile = null;                       //�ϴ����ļ�����;
	private int fileSize = 0;                                 //�ļ���С;
	private String fileName = null;                           //�ļ�����������չ��;
	private String filenameExtension = null;                  //�ļ���չ��;
	private String allowFileType = null;                      //�����ϴ����ļ�������չ��������Զ���","�ָ�;
	private int maxSize = GlobalNames.UPLOAD_FILE_SIZE;       //�����ϴ����ļ���С���ֵ����λbyte;
	private String fileSavePath = GlobalNames.UPLOAD_PATH;    //�ļ�������ļ���·�����������ļ���
	
	public StrutsFileUpload(FormFile uploadFile) throws AppException {
		super();
		this.uploadFile = uploadFile;
		this.fileSize = uploadFile.getFileSize();
		this.fileName = uploadFile.getFileName();
		this.filenameExtension = this.getFilenameExtension(uploadFile.getFileName());
		this.allowFileType = this.filenameExtension;
	}
	
	/**
	 * �����ļ������ڷ������ϵľ���·��,������Ϊnull��ʹ��Ĭ��ֵ��GlobalNames.UPLOAD_PATH;
	 * @param fileSavePath
	 */
	public void setFileSavePath(String fileSavePath) {
		if( fileSavePath!=null )
			this.fileSavePath = fileSavePath;
		else
			this.fileSavePath = GlobalNames.UPLOAD_PATH;
	}
	
	
	/**
	 * ���������ϴ����ļ����ͣ������ļ������ö���","�ָ�;�磺
	 * �ı��ļ���".txt";   word�ļ�: ".doc";
	 * ͼƬ�ļ���".jpg,.jpeg,.gif,.png,.bmp";
	 * .rar�ļ���".rar";
	 * @param allowFileType
	 */
	public void setAllowFileType(String allowFileType) {
		this.allowFileType = allowFileType;
	}

	/**
	 * ��ȡ�����ϴ��ļ������ֵ
	 * @return int:��λ��byte
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * ���������ϴ��ļ������ֵ����λ��byte
	 * ��С�ڵ���0����Ĭ��ֵ��GlobalNames.UPLOAD_FILE_SIZE;
	 * @param maxSize
	 */
	public void setMaxSize(int maxSize) {
		if( maxSize>0 )
			this.maxSize = maxSize;
		else
			this.maxSize = GlobalNames.UPLOAD_FILE_SIZE;
	}

	/**
	 * ��ȡ�ļ���С
	 * @return int:��λ��byte
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
			errorMessage = "�ϴ��ļ�ʧ�ܣ�δ�ҵ���Ҫ�ϴ����ļ�·��������ȷѡ����Ҫ�ϴ����ļ���";
			log.error(errorMessage);
			throw new AppException( errorMessage );
		}else if( fileSize>maxSize )
		{
			errorMessage = "�ϴ��ļ�ʧ�ܣ����ϴ����ļ������ϴ��ļ����ܴ��ڣ�" + (maxSize/1024) + "KB";
			log.info(errorMessage);
			throw new AppException( errorMessage );
		}else if( !this.validateFileType(allowFileType, filenameExtension) )
		{
			errorMessage = "�ϴ��ļ�ʧ�ܣ����ϴ����ļ���ʽ������Ҫ��!";
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
				errorMessage = "�ϴ��ļ�ʧ�ܣ�δ�ҵ��ļ������ڷ������ϵ�·��������ϵͳ����Ա��ϵ��";
				log.error(errorMessage, e);
				throw new AppException( errorMessage );
			} catch (IOException e) {
				errorMessage = "�ϴ��ļ�ʧ�ܣ����ϴ����ļ���ʽ������Ҫ�󣬻������æ�����Ժ����ԣ�"+e.getMessage();
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
					throw new AppException( "�ر�IO�����ִ���"+ie.getMessage() );
				}
			}
		}
		
		return filePathReturn;
	}
	
	
	/**
	 * ��ȡ�ļ���չ�����磺".jpg";
	 * @param filename:�ļ������磺"123.jpg";
	 * @return String�������ļ���չ�����磺".jpg"��
	 * @throws AppException 
	 */
	public String getFilenameExtension(String filename) throws AppException
	{
		String extensiveName = null;
		
		int index = filename.lastIndexOf(".");
		if( index>=0 )
			extensiveName = (filename.substring(index)).toLowerCase();
		else{
			throw new AppException("�ļ����ʹ��󣡸��ļ����ļ���δ����ȷ����չ������");
		}
		return extensiveName;
	}
	
	/**
	 * ��֤�����ϴ����ļ����ͣ�
	 * @param allowFileType�������ϴ����ļ����ͣ�
	 * @param fileType����ǰҪ�ϴ����ļ����ļ����ͣ��磺".jpeg";
	 * @return boolean: allowFileType�к���fileType����true,���򷵻�false.
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
	 * ���������ϴ����ļ����ͣ������ļ������ö���","�ָ�;
	 * �ı��ļ���text/plain; word�ļ�: application/msword;
	 * ͼƬ�ļ���image/pjpeg, image/gif, image/x-png, image/bmp;
	 * .rar�ļ���application/octet-stream;
	 * @param allowFileType
	 */

}
