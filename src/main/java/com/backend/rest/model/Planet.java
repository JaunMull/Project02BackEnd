package com.backend.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planets")
public class Planet {
	
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private double density;
	@Column
	private double gravity;
	@Column
	private double size;
	@Column
	private long moons;
	@Column
	private double sundistance;
	@Column
	private long planetyears;
	
	@Id
	@GeneratedValue
	private long id;

	public Planet() {
		super();
	}

	public Planet(String name, String type, double density, double gravity, double size, long moons, double sundistance,
			long planetyears) {
		super();
		this.name = name;
		this.type = type;
		this.density = density;
		this.gravity = gravity;
		this.size = size;
		this.moons = moons;
		this.sundistance = sundistance;
		this.planetyears = planetyears;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public long getMoons() {
		return moons;
	}

	public void setMoons(long moons) {
		this.moons = moons;
	}

	public double getSundistance() {
		return sundistance;
	}

	public void setSundistance(double sundistance) {
		this.sundistance = sundistance;
	}

	public long getPlanetyears() {
		return planetyears;
	}

	public void setPlanetyears(long planetyears) {
		this.planetyears = planetyears;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", type=" + type + ", density=" + density + ", gravity=" + gravity + ", size="
				+ size + ", moons=" + moons + ", sundistance=" + sundistance + ", planetyears=" + planetyears + ", id="
				+ id + "]";
	}

	
}
