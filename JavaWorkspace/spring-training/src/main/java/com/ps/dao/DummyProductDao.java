package com.ps.dao;

public class DummyProductDao implements ProductDao {
	
	public DummyProductDao() {
		System.out.println("DummyProductDao instantiated!");
	}

	@Override
	public int count() throws DaoException {
		return 2000;
	}

}
