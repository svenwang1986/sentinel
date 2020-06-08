package com.alibaba.csp.sentinel.dashboard.ConcurrentAccess;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class MultiThreads {


	
	
	public static void main(String[] args) throws InterruptedException {
		
		while (true){
			
			for(int i = 0;i < 3;i++){
				Thread t = new Thread(new Runnable(){@Override
					public void run() {
						try {
							RestTemplate restTemplate = new RestTemplate();
							String result = restTemplate.getForObject("http://book.easou.com:8080/ta/show.m?esid=3l5sFd-meUvasFd-meUoUn6&gid=HOKdgaizY6z4Vs9yaTVoDXf&nid=177452&st=1&gst=1", String.class);
							System.out.println("success !" );
						} catch (RestClientException e) {
							System.out.println("error ! " + e.getMessage());
						}
						
					}});
					t.start();
			}
			
			Thread.sleep(500);
		}
		
		
		
	}
	
}
