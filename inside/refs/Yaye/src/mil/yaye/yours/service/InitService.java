package mil.yaye.yours.service;

import mil.yaye.yours.factory.BeanFactory;


public interface InitService {

	public abstract void setDAO(BeanFactory daoFactory);

	public abstract int initDataSource();

}