package com.wyj.fdfs;

import static org.junit.Assert.*;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.wyj.utils.FastDFSClient;

public class TestFastDfs {

	/*@Test
	public void testUpload() throws Exception {
        // 1.先创建一个配置文件——fast_dfs.conf，配置文件的内容就是指定TrackerServer的地址

        // 2.使用全局方法加载配置文件
        ClientGlobal.init("D:/project/JAVA/taotao-manager-web/src/main/resources/resource/fast_dfs.conf");
        // 3.创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        // 4.通过TrackerClient对象获得TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5.创建StorageServer的引用，null就可以了
        StorageServer storageServer = null;
        // 6.创建一个StorageClient对象，其需要两个参数，一个是TrackerServer，一个是StorageServer
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7.使用StorageClient对象上传文件(图片)
        // 参数1：文件名，参数名：扩展名，不能包含"."，参数3：文件的元数据，保存文件的原始名、大小、尺寸等，如果没有可为null
        String[] strings = storageClient.upload_file("D:/project/JAVA/taotao-manager-web/src/test/java/com/wyj/fdfs/scenery.bmp", "bmp", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }*/
	@Test
	public void testFastDfsClient() throws Exception {
	    FastDFSClient fastDFSClient = new FastDFSClient("D:/project/JAVA/taotao-manager-web/src/main/resources/resource/fast_dfs.conf");
	    String string = fastDFSClient.uploadFile("D:/project/JAVA/taotao-manager-web/src/test/java/com/wyj/fdfs/tiger.jpg");
	    // 注意，你再上传一遍，刚才你上传的那个图片就已经丢了，它已经存在服务器上了，你再也访问不到了
	    System.out.println(string);
	}

}
