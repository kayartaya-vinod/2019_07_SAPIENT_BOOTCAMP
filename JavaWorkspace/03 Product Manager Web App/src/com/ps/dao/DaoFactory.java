package com.ps.dao;

public final class DaoFactory {

	private DaoFactory() {
	}

	public static ProductDao getProductDao(String discriminator) throws DaoException {
		switch (discriminator.toLowerCase()) {
		case "hibernate":
			return new HibernateProductDao();
		case "jdbc":
			return new JdbcProductDao();
		case "arraylist":
			throw new DaoException("ArrayListProductDao not avaialble yet");
		case "map":
			throw new DaoException("MapProductDao not avaialble yet");
		case "csv":
			throw new DaoException("CsvProductDao not avaialble yet");
		case "serialized":
			throw new DaoException("SerializedProductDao not avaialble yet");
		default:
			throw new DaoException("Invalid type for DAO implementation");
		}
	}
}