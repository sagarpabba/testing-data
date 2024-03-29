/* 
	Purpose:
		
	Description:
		
	History:
		2013/7/10, Created by dennis

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.zss.app.repository;

import java.io.File;

import org.zkoss.zss.app.repository.impl.SimpleRepository;

/**
 * The book repository
 * @author dennis
 *
 */
public class BookRepositoryFactory {

	static BookRepositoryFactory instance;
	
	/**
	 * Gets the default instance of {@link BookRepositoryFactory}
	 * @return
	 */
	public static BookRepositoryFactory getInstance(){
		if(instance==null){
			synchronized(BookRepositoryFactory.class){
				//TODO read configuration
				if(instance==null){
					instance = new BookRepositoryFactory();
				}
			}
		}
		return instance;
	}
	
	BookRepository repository;
	/**
	 * Gets the {@link BookRepository}
	 * @return
	 */
	public BookRepository getRepository(){
		if(repository==null){
			synchronized(BookRepositoryFactory.class){
				if(repository==null){
					//String path = "C:/Users/huchan/Desktop/PAF_Automation_QTP/Test_Data/";
					String path="C:/PAF_Automation/Test_Data/";
							//Library.getProperty("zssapp.repository.root",WebApps.getCurrent().getRealPath("/books/"));
					File root = new File(path);
					if(!root.exists()){
						root.mkdirs();
					}
					if(!root.exists()||root.isFile()){
						throw new RuntimeException("root folder "+path+" is not a directory or doesn't not exist");
					}
					repository = new SimpleRepository(root);
				}
			}
		}
		return repository;
	}
}
