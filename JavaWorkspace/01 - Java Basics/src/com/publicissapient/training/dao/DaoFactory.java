package com.publicissapient.training.dao;

public class DaoFactory {

	private static String discriminator = "csv";

	public static ProductDao getProductDao(String discriminator) throws DaoException {
		DaoFactory.discriminator = discriminator;
		return getProductDao();
	}

	public static ProductDao getProductDao() throws DaoException {
		switch (discriminator) {
		case "csv":
			return new CsvProductDao();
		case "dummy":
			return new DummyProductDao();
		case "jdbc":
			throw new DaoException("No implementation for jdbc yet");
		case "hibernate":
			throw new DaoException("No implementation for hibernate yet");
		default:
			throw new DaoException("Unknown type for discriminator: " + discriminator);
		}
	}

}
