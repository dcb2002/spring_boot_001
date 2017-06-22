package com.wisely.support;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * 
 * 
 * JpaRepository<T, ID> 				具备基本CRUD功能
 * JpaSpecificationExecutor<T>		具备准则Specificatin查询功能
 * 
 * @author Administrator
 * 
 * 
 */
@NoRepositoryBean	//【1】指明这个接口不是领域类 的接口。
public interface CustomRepository<T, ID extends Serializable>extends JpaRepository<T, ID> ,JpaSpecificationExecutor<T>{
	
	Page<T> findByAuto(T example,Pageable pageable);
	

}
