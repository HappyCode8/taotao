package com.wyj.solrj;

/*import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrCloud {

	@Test
	public void testSolrCloudAdDocument() throws Exception {
		//创建一个CloudSolrServer对象，构造方法中需要制定zookeeper的地址列表,新版建议CloudSolrClient
		CloudSolrServer cloudSolrServer = new CloudSolrServer("192.168.25.129:2181,192.168.25.129:2182,192.168.25.129:2183");
		//需要设置默认的Collection
		cloudSolrServer.setDefaultCollection("collection2");
		//创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		//向文档中添加域
		document.addField("id", "test001");
		document.addField("item_title", "测试商品名称");
		document.addField("item_price", 100);
		//把文档写入索引库
		cloudSolrServer.add(document);
		//提交
		cloudSolrServer.commit();
		
	}
	// 删除文档
	@Test
	public void testDeleteDocument() throws Exception {
	    // 第一步，创建一个SolrServer对象，应该使用CloudSolrServer对象，它有一个构造方法，
	    // 构造方法有一个参数，叫做zkHost，是一个字符串类型，也即zookeeper的地址列表
	    CloudSolrServer solrServer = new CloudSolrServer("192.168.25.129:2181,192.168.25.129:2182,192.168.25.129:2183");
	    // 第二步，需要指定默认的collection
	    solrServer.setDefaultCollection("collection2");
	    solrServer.deleteByQuery("*:*");
	    solrServer.commit();
	}
}
*/