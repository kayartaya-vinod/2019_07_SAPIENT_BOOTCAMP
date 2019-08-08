package com.ps.dao;

import java.util.logging.Logger;

public class DummyProductDao implements ProductDao {
	Logger logger = Logger.getLogger("DummyProductDao");

	public DummyProductDao() {
		logger.info("DummyProductDao instantiated!");
	}

	@Override
	public int count() throws DaoException {
		return 2000;
	}

}
