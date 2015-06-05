/**
 * 
 */
package com.semika.autoac.persist.api.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author root
 *
 */
public interface GenericDAO<T, ID extends Serializable> {
	
	T findById(ID id, boolean lock);
	 
    List<T> findAll();
 
    List<T> findByExample(T exampleInstance,  String[] excludeProperty);
 
    T makePersistent(T entity);
 
    void makeTransient(T entity);

}
