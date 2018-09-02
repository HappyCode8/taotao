package com.wyj.jedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wyj.content.jedis.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;*/

public class JedisTest {

	/*@Test
	public void testJedisSingle() {
		Jedis jedis=new Jedis("192.168.25.128",6379);
		jedis.set("mytest", "200");
		String result=jedis.get("mytest");
		System.out.println(result);
		jedis.close();
	}
	
	@Test
	public void testJedisPool(){
		JedisPool jedisPool=new JedisPool("192.168.25.128",6379);
		Jedis jedis=jedisPool.getResource();
		String result=jedis.get("mytest");
		System.out.println(result);
		jedis.close();
		jedisPool.close();
	}*/

	/*@Test
	public void testJedisCluster() throws IOException{
		Set<HostAndPort> nodes=new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.25.128",7001));
		nodes.add(new HostAndPort("192.168.25.128",7002));
		nodes.add(new HostAndPort("192.168.25.128",7003));
		nodes.add(new HostAndPort("192.168.25.128",7004));
		nodes.add(new HostAndPort("192.168.25.128",7005));
		nodes.add(new HostAndPort("192.168.25.128",7006));
		JedisCluster jedisCluster=new JedisCluster(nodes);
		jedisCluster.set("jcluster","123456");
		String result=jedisCluster.get("jcluster");
		System.out.println(result);
		jedisCluster.close();
	}*/
	/*@Test
	public void testJedisClientSingle(){
		ApplicationContext applicationContext=new 
				ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-redis.xml");
		JedisClient jedisClient=applicationContext.getBean(JedisClient.class);
		jedisClient.set("client","hello");
		String result=jedisClient.get("client");
		System.out.println(result);

	}*/
}
