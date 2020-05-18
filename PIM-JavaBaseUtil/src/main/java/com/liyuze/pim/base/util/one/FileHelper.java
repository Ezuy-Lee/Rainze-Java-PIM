package com.liyuze.pim.base.util.one;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

import org.apache.commons.io.FilenameUtils;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *   
 * 
 * @Title: FileHelper.java
 * @Package com.jarvis.base.util
 * @Description:文件工具类
 * @author Jack 
 * @date 2017年9月2日 下午2:39:29
 * @version V1.0  
 */
public class FileHelper {

	/**
	 * 1kb
	 */
	private final static int KB_1 = 1024;

	/**
	 * 获得文件的CRC32校验和
	 *
	 * @param file
	 *            要进行校验的文件
	 * @return
	 * @throws Exception
	 */
	public static String getFileCRCCode(File file) throws Exception {
		FileInputStream is = new FileInputStream(file);
		CRC32 crc32 = new CRC32();
		CheckedInputStream cis = new CheckedInputStream(is, crc32);
		byte[] buffer = null;
		buffer = new byte[KB_1];
		while (cis.read(buffer) != -1) {
		}
		is.close();
		buffer = null;
		return Long.toHexString(crc32.getValue());
	}

	/**
	 * 获得字串的CRC32校验和
	 *
	 * @param string
	 *            要进行校验的字串
	 * @return
	 * @throws Exception
	 */
	public static String getStringCRCCode(String string) throws Exception {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(string.getBytes());
		CRC32 crc32 = new CRC32();
		CheckedInputStream checkedinputstream = new CheckedInputStream(inputStream, crc32);
		byte[] buffer = null;
		buffer = new byte[KB_1];
		while (checkedinputstream.read(buffer) != -1) {
		}
		inputStream.close();
		buffer = null;
		return Long.toHexString(crc32.getValue());
	}

	/**
	 * 连接路径和文件名称，组成最后的包含路径的文件名
	 *
	 * @param basePath
	 *            文件路径
	 * @param fullFilenameToAdd
	 *            文件名称
	 * @return
	 */
	public static String concat(String basePath, String fullFilenameToAdd) {
		return FilenameUtils.concat(basePath, fullFilenameToAdd);
	}

	/**
	 * 获得不带文件扩展名的文件名称
	 *
	 * @param filename
	 *            文件完整路径
	 * @return 不带扩展名的文件名称
	 */
	public static String getBaseName(String filename) {
		return FilenameUtils.getBaseName(filename);
	}

	/**
	 * 获得带扩展名的文件名称
	 *
	 * @param filename
	 *            文件完整路径
	 * @return 文件名称
	 */
	public static String getFileName(String filename) {
		return FilenameUtils.getName(filename);
	}

	/**
	 * 获得文件的完整路径，包含最后的路径分隔条
	 *
	 * @param filename
	 *            文件完整路径
	 * @return 目录结构
	 */
	public static String getFullPath(String filename) {
		return FilenameUtils.getFullPath(filename);
	}

	/**
	 * 获得文件的完整路径，不包含最后的路径分隔条
	 *
	 * @param filename
	 *            文件完整路径
	 * @return
	 */
	public static String getFullPathNoEndSeparator(String filename) {
		return FilenameUtils.getFullPathNoEndSeparator(filename);
	}

	/**
	 * 判断文件是否有某扩展名
	 *
	 * @param filename
	 *            文件完整路径
	 * @param extension
	 *            扩展名名称
	 * @return 若是，返回true，否则返回false
	 */
	public static boolean isExtension(String filename, String extension) {
		return FilenameUtils.isExtension(filename, extension);
	}

	/**
	 * 判断文件的扩展名是否是扩展名数组中的一个
	 *
	 * @param filename
	 *            文件完整路径
	 * @param extensions
	 *            扩展名名称
	 * @return 若是，返回true，否则返回false
	 */
	public static boolean isExtension(String filename, String[] extensions) {
		return FilenameUtils.isExtension(filename, extensions);
	}

	/**
	 * 规范化路径，合并其中的多个分隔符为一个,并转化为本地系统路径格式
	 *
	 * @param filename
	 *            文件完整路径
	 * @return
	 */
	public static String normalize(String filename) {
		return FilenameUtils.normalize(filename);
	}

	/**
	 * 规范化路径，合并其中的多个分隔符为一个,并转化为本地系统路径格式,若是路径，则不带最后的路径分隔符
	 *
	 * @param filename
	 *            文件完整路径
	 * @return
	 */
	public static String normalizeNoEndSeparator(String filename) {
		return FilenameUtils.normalizeNoEndSeparator(filename);
	}

	/**
	 * 把文件路径中的分隔符转换为unix的格式，也就是"/"
	 *
	 * @param path
	 *            文件完整路径
	 * @return 转换后的路径
	 */
	public static String separatorsToUnix(String path) {
		return FilenameUtils.separatorsToUnix(path);
	}

	/**
	 * 把文件路径中的分隔符转换为window的格式，也就是"\"
	 *
	 * @param path
	 *            文件完整路径
	 * @return 转换后的路径
	 */
	public static String separatorsToWindows(String path) {
		return FilenameUtils.separatorsToWindows(path);
	}

	/**
	 * 把文件路径中的分隔符转换当前系统的分隔符
	 *
	 * @param path
	 *            文件完整路径
	 * @return 转换后的路径
	 */
	public static String separatorsToSystem(String path) {
		return FilenameUtils.separatorsToSystem(path);
	}

	/**
	 * 提取文件的扩展名
	 *
	 * @param filename
	 *            文件名称
	 * @return 文件扩展名，若没有扩展名，则返回空字符串
	 */
	public static String getExtension(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	/**
	 * 移出文件的扩展名
	 *
	 * @param filename
	 *            文件名称
	 * @return 若文件存在扩展名，则移出扩展名，然后返回移出后的值
	 */
	public static String removeExtension(String filename) {
		return FilenameUtils.removeExtension(filename);
	}

	/**
	 * 清除一个目录的内容，但不删除此目录
	 *
	 * @param directory
	 *            需要清除的目录
	 * @return true:清除成功 false:清除失败
	 */
	public static boolean cleanDirectory(File directory) {
		try {
			org.apache.commons.io.FileUtils.cleanDirectory(directory);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("清除目录出错");
		}
		return false;
	}

	/**
	 * 拷贝一个目录的内容到另外一个目录中
	 *
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyDirectory(File srcDir, File destDir) {
		return copyDirectory(srcDir, destDir, true);
	}

	/**
	 * 拷贝一个目录的内容到另外一个目录中
	 *
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyDirectory(String srcDir, String destDir) {
		return copyDirectory(new File(srcDir), new File(destDir));
	}

	/**
	 * 拷贝一个目录的内容到另外一个目录中
	 *
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @param preserveFileDate
	 *            是否保持文件日期
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyDirectory(File srcDir, File destDir, boolean preserveFileDate) {
		try {
			org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir, preserveFileDate);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("复制目录出错");
		}
		return false;
	}

	/**
	 * 拷贝源目录的内容到目的目录中(注：是拷贝到目的目录的里面)
	 *
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyDirectoryToDirectory(File srcDir, File destDir) {
		try {
			org.apache.commons.io.FileUtils.copyDirectoryToDirectory(srcDir, destDir);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("复制目录出错");
		}
		return false;
	}

	/**
	 * 拷贝源目录的内容到目的目录中(注：是拷贝到目的目录的里面)
	 *
	 * @param srcDir
	 *            源目录
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyDirectoryToDirectory(String srcDir, String destDir) {
		return copyDirectoryToDirectory(new File(srcDir), new File(destDir));
	}

	/**
	 * 拷贝文件
	 *
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目的文件
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyFile(File srcFile, File destFile) {
		return copyFile(srcFile, destFile, true);
	}

	/**
	 * 拷贝文件
	 *
	 * @param srcFile
	 *            源文件路径
	 * @param destFile
	 *            目的文件路径
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyFile(String srcFile, String destFile) {
		return copyFile(new File(srcFile), new File(destFile));
	}

	/**
	 * 拷贝文件
	 *
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目的文件
	 * @param preserveFileDate
	 *            是否保留文件日期
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyFile(File srcFile, File destFile, boolean preserveFileDate) {
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, destFile, preserveFileDate);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("复制文件出错");
		}
		return false;
	}

	/**
	 * 拷贝文件到某目录中
	 *
	 * @param srcFile
	 *            源文件
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyFileToDirectory(File srcFile, File destDir) {
		try {
			org.apache.commons.io.FileUtils.copyFileToDirectory(srcFile, destDir);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("复制文件出错");
		}
		return false;
	}

	/**
	 * 拷贝文件到某目录中
	 *
	 * @param srcFile
	 *            源文件
	 * @param destDir
	 *            目的目录
	 * @return true:拷贝成功 false:拷贝失败
	 */
	public static boolean copyFileToDirectory(String srcFile, String destDir) {
		return copyFileToDirectory(new File(srcFile), new File(destDir));
	}

	/**
	 * 删除一个目录和该目录下的所有内容
	 *
	 * @param directory
	 *            需要删除的目录
	 * @return true:删除成功 false:删除失败
	 */
	public static boolean deleteDirectory(String directory) {
		try {
			org.apache.commons.io.FileUtils.deleteDirectory(new File(directory));
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("删除目录出错");
		}
		return false;
	}

	/**
	 * 删除文件
	 *
	 * @param file
	 *            需要删除的文件路径
	 * @return true:删除成功 false:删除失败
	 */
	public static boolean deleteFile(String file) {
		try {
			org.apache.commons.io.FileUtils.forceDelete(new File(file));
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("删除文件出错");
		}
		return false;
	}

	/**
	 * 递归创建目录
	 *
	 * @param directory
	 *            目录
	 * @return
	 */
	public static boolean createDirectory(String directory) {
		try {
			org.apache.commons.io.FileUtils.forceMkdir(new File(directory));
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("创建目录出错");
		}
		return false;
	}

	/**
	 * 读入文件到字节数组中
	 *
	 * @param file
	 *            需要读取的文件路径
	 * @return 读取的字节数组，若读入失败，则返回null
	 */
	public static byte[] readFileToByteArray(String file) {
		try {
			byte[] bytes = org.apache.commons.io.FileUtils.readFileToByteArray(new File(file));
			return bytes;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("读取文件出错");
		}
		return null;
	}

	/**
	 * 读入文件到字串中
	 *
	 * @param file
	 *            需要读取的文件路径
	 * @return 读取的文件内容，若读入失败，则返回空字串
	 */
	public static String readFileToString(String file, String encoding) {
		try {
			if (StringHelper.isEmpty(encoding)) {
				encoding = "GBK";
			}
			String content = org.apache.commons.io.FileUtils.readFileToString(new File(file), encoding);
			return content;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("读取文件出错");
		}
		return "";
	}

	/**
	 * 读入文件到字串中
	 *
	 * @param file
	 *            需要读取的文件路径
	 * @return 读取的文件内容，若读入失败，则返回空字串
	 */
	public static String readFileToString(String file) {
		return readFileToString(file, "GBK");
	}

	/**
	 * 读入文本文件到一个按行分开的List中
	 *
	 * @param file
	 *            需要读取的文件路径
	 * @return 按行内容分开的List
	 */
	@SuppressWarnings("rawtypes")
	public static List readLines(String file) {
		return readLines(file, "GBK");
	}

	/**
	 * 读入文本文件到一个按行分开的List中
	 *
	 * @param file
	 *            需要读取的文件路径
	 * @return 按行内容分开的List
	 */
	@SuppressWarnings("rawtypes")
	public static List readLines(String file, String encoding) {

		try {
			if (StringHelper.isEmpty(encoding)) {
				encoding = "GBK";
			}
			List lineList = org.apache.commons.io.FileUtils.readLines(new File(file), encoding);
			return lineList;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("读取文件出错");
		}
		return null;

	}

	/**
	 * 递归求一个目录的容量大小
	 *
	 * @param directory
	 *            需要计算容量的目录路径
	 * @return 容量的大小(字节数)
	 */
	public static long sizeOfDirectory(String directory) {
		return org.apache.commons.io.FileUtils.sizeOfDirectory(new File(directory));
	}

	/**
	 * 写字节数组到文件中，若文件不存在，则建立新文件
	 *
	 * @param file
	 *            需要写的文件的路径
	 * @param data
	 *            需要写入的字节数据
	 * @return true:写入成功 false:写入失败
	 */
	public static boolean writeToFile(String file, byte[] data) {
		try {
			org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(file), data);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("写文件出错");
		}
		return false;
	}

	/**
	 * 写字串到文件中，若文件不存在，则建立新文件
	 *
	 * @param file
	 *            需要写的文件的路径
	 * @param data
	 *            需要写入的字串
	 * @return true:写入成功 false:写入失败
	 */
	public static boolean writeToFile(String file, String data) {
		return writeToFile(file, data, "GBK");
	}

	/**
	 * 写字串到文件中，若文件不存在，则建立新文件
	 *
	 * @param file
	 *            需要写的文件的路径
	 * @param data
	 *            需要写入的字串
	 * @param dncoding
	 *            文件编码，默认为GBK
	 * @return true:写入成功 false:写入失败
	 */
	public static boolean writeToFile(String file, String data, String encoding) {
		try {
			if (encoding == null || "".equals(encoding)) {
				encoding = "GBK";
			}
			org.apache.commons.io.FileUtils.writeStringToFile(new File(file), data, encoding);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("写文件出错");
		}
		return false;
	}

	/**
	 * 建立由filePathName指定的文件，若文件路径中的目录不存在，则先建立目录
	 *
	 * @param filePathName
	 *            文件路径全名
	 * @return
	 */
	public static boolean createNewFile(String filePathName) {
		String filePath = FileHelper.getFullPath(filePathName);
		// 若目录不存在，则建立目录
		if (!FileHelper.exists(filePath)) {
			if (!createDirectory(filePath)) {
				return false;
			}
		}

		try {
			File file = new File(filePathName);
			return file.createNewFile();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("创建文件出错");
			return false;
		}
	}

	/**
	 * 判断文件和目录是否已存在
	 *
	 * @param filePath
	 *            文件和目录完整路径
	 * @return tru:存在 false：不存在
	 */
	public static boolean exists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	/**
	 * 判断特定的路径是否为文件
	 *
	 * @param filePath
	 *            文件完整的路径
	 * @return 若是文件，则返回true，否则返回false
	 */
	public static boolean isFile(String filePath) {
		File file = new File(filePath);
		return file.isFile();
	}

	/**
	 * 判断特定的路径是否为目录
	 *
	 * @param filePath
	 *            文件完整的路径
	 * @return 若是目录，则返回true，否则返回false
	 */
	public static boolean isDirectory(String filePath) {
		File file = new File(filePath);
		return file.isDirectory();
	}

	/**
	 * 更改文件的名称，若不在同一个目录下,则系统会移动文件
	 *
	 * @param srcFile
	 *            源文件路径名称
	 * @param destFile
	 *            目的文件路径名称
	 * @return
	 */
	public static boolean renameTo(String srcFile, String destFile) {
		File file = new File(srcFile);
		return file.renameTo(new File(destFile));
	}

	/**
	 * 
	 * 描述：根据document生成Xml文件 作者：刘宝 时间：Jun 9, 2010 3:16:11 PM
	 * 
	 * @param fileName
	 *            生成文件的路径
	 * @param document
	 * @param encoding
	 *            编码格式
	 * @return
	 */
	public static boolean WriteToXMLFile(String fileName, Document document, String encoding) {
		createNewFile(fileName);
		boolean success = false;
		/** 格式化输出,类型IE浏览一样 */
		OutputFormat format = OutputFormat.createPrettyPrint();
		/** 指定XML编码 */
		format.setEncoding(encoding);
		XMLWriter writer = null;
		try {
			/** 将document中的内容写入文件中 */
			writer = new XMLWriter(new FileOutputStream(new File(fileName)), format);
			writer.write(document);
			writer.flush();
			success = true;
			/** 执行成功,需返回true */
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("写文件出错");
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Convert code Error");
				}
			}
		}
		return success;
	}

	/** 
     * 获取文件的后缀名并转化成大写 
     *  
     * @param fileName 
     *            文件名 
     * @return 
     */  
    public String getFileSuffix(String fileName) throws Exception {  
        return fileName.substring(fileName.lastIndexOf(".") + 1,  
                fileName.length()).toUpperCase();  
    }  
  
    /** 
     * 创建多级目录 
     *  
     * @param path 
     *            目录的绝对路径 
     */  
    public void createMultilevelDir(String path) {  
        try {  
            StringTokenizer st = new StringTokenizer(path, "/");  
            String path1 = st.nextToken() + "/";  
            String path2 = path1;  
            while (st.hasMoreTokens()) {  
  
                path1 = st.nextToken() + "/";  
                path2 += path1;  
                File inbox = new File(path2);  
                if (!inbox.exists())  
                    inbox.mkdir();  
  
            }  
        } catch (Exception e) {  
            System.out.println("目录创建失败" + e);  
            e.printStackTrace();  
        }  
  
    }  
  
    /** 
     * 删除文件/目录(递归删除文件/目录) 
     *  
     * @param path 
     *            文件或文件夹的绝对路径 
     */  
    public void deleteAll(String dirpath) {  
        if (dirpath == null) {  
            System.out.println("目录为空");  
        } else {  
            File path = new File(dirpath);  
            try {  
                if (!path.exists())  
                    return;// 目录不存在退出  
                if (path.isFile()) // 如果是文件删除  
                {  
                    path.delete();  
                    return;  
                }  
                File[] files = path.listFiles();// 如果目录中有文件递归删除文件  
                for (int i = 0; i < files.length; i++) {  
                    deleteAll(files[i].getAbsolutePath());  
                }  
                path.delete();  
  
            } catch (Exception e) {  
                System.out.println("文件/目录 删除失败" + e);  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * 文件/目录 重命名 
     *  
     * @param oldPath 
     *            原有路径（绝对路径） 
     * @param newPath 
     *            更新路径 
     * @author lyf 注：不能修改上层次的目录 
     */  
    public void renameDir(String oldPath, String newPath) {  
        File oldFile = new File(oldPath);// 文件或目录  
        File newFile = new File(newPath);// 文件或目录  
        try {  
            boolean success = oldFile.renameTo(newFile);// 重命名  
            if (!success) {  
                System.out.println("重命名失败");  
            } else {  
                System.out.println("重命名成功");  
            }  
        } catch (RuntimeException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    /** 
     * 新建目录 
     */  
    public static boolean newDir(String path) throws Exception {  
        File file = new File(path);  
        return file.mkdirs();//创建目录  
    }  
      
    /** 
     * 删除目录 
     */  
    public static boolean deleteDir(String path) throws Exception {  
        File file = new File(path);  
        if (!file.exists())  
            return false;// 目录不存在退出  
        if (file.isFile()) // 如果是文件删除  
        {  
            file.delete();  
            return false;  
        }  
        File[] files = file.listFiles();// 如果目录中有文件递归删除文件  
        for (int i = 0; i < files.length; i++) {  
            deleteDir(files[i].getAbsolutePath());  
        }  
        file.delete();  
          
        return file.delete();//删除目录  
    }  
  
    /** 
     * 更新目录 
     */  
    public static boolean updateDir(String path, String newPath) throws Exception {  
        File file = new File(path);  
        File newFile = new File(newPath);  
        return file.renameTo(newFile);  
    }
    
 // 删除文件夹  
    // param folderPath 文件夹完整绝对路径  
    public static void delFolder(String folderPath) {  
        try {  
            delAllFile(folderPath); // 删除完里面所有内容  
            String filePath = folderPath;  
            filePath = filePath.toString();  
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    // 删除指定文件夹下所有文件  
    // param path 文件夹完整绝对路径  
    public static boolean delAllFile(String path) {  
        boolean flag = false;  
        File file = new File(path);  
        if (!file.exists()) {  
            return flag;  
        }  
        if (!file.isDirectory()) {  
            return flag;  
        }  
        String[] tempList = file.list();  
        File temp = null;  
        for (int i = 0; i < tempList.length; i++) {  
            if (path.endsWith(File.separator)) {  
                temp = new File(path + tempList[i]);  
            } else {  
                temp = new File(path + File.separator + tempList[i]);  
            }  
            if (temp.isFile()) {  
                temp.delete();  
            }  
            if (temp.isDirectory()) {  
                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件  
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹  
                flag = true;  
            }  
        }  
        return flag;  
    }  
  
    
    
      
    public static void main(String d[]) throws Exception{  
        //deleteDir("d:/ff/dddf");  
        updateDir("D:\\TOOLS\\Tomcat 6.0\\webapps\\BCCCSM\\nationalExperiment/22222", "D:\\TOOLS\\Tomcat 6.0\\webapps\\BCCCSM\\nationalExperiment/224222");  
    }  
      
}
