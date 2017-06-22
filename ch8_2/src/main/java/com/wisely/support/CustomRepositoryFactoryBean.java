package com.wisely.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {// 1 继承JPA 仓库 工厂 Bean

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new CustomRepositoryFactory(entityManager);		// 2 实例化 下面这个 自定义仓库工厂
	}

	private static class CustomRepositoryFactory extends JpaRepositoryFactory { // 3 继承JPA 仓库 工厂


		public CustomRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
		}

		@Override
		@SuppressWarnings({"unchecked"})
		protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
				RepositoryInformation information, EntityManager entityManager) {
			return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
				// 4 返回自定义的仓库
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return CustomRepositoryImpl.class;	// 5 返回自定义的仓库的类型。
		}
	}
}