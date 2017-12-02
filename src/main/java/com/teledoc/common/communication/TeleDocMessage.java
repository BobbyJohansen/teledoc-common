package com.teledoc.common.communication;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeleDocMessage {
	@Id
    private UUID uuid = UUID.randomUUID();
    
    private long timestamp = System.currentTimeMillis();
    private UUID person;
    private DataType dataType;
    private double[] data;

    public UUID getUuid() {
        return uuid;
    }

    public List<Double> getData() {
        return DoubleStream.of(data).boxed().collect(Collectors.toList());
    }

    public void setData(List<Double> data) {
        this.data = data.stream().mapToDouble(d -> d.doubleValue()).toArray();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

	public UUID getPerson() {
		return person;
	}

	public void setPerson(UUID person) {
		this.person = person;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
