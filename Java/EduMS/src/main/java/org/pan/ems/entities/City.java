package org.pan.ems.entities;


public class City {
	// id
	private Integer cityId;
	// 城市名
	private String cityName;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(Integer cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

}
