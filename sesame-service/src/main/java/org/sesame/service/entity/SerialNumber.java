package org.sesame.service.entity;

public class SerialNumber {
	private long version;
	private long type;
	private long machineId;
	private long millisecond;
	private long sequence;

	public SerialNumber(long version, long type, long machineId, long millisecond, long sequence) {
		this.version = version;
		this.type = type;
		this.machineId = machineId;
		this.millisecond = millisecond;
		this.sequence = sequence;
	}

	public SerialNumber() {
	}
	
	public long getVersion() {
		return this.version;
		
	}
	
	public long getType() {
		return this.type;
	}
	
	public long getMachineId() {
		return this.machineId;
	}
	
	public long getMillisecond() {
		return this.millisecond;
	}
	
	public long getSequence() {
		return this.sequence;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append("{version:").append(version).append(",").append("type:").append(type).append(",")
				.append("machineId").append(machineId).append(",").append("millisecond").append(millisecond).append(",")
				.append("sequence").append(sequence).append("}");
		
		return sBuilder.toString();
	}

	public static class Builder {
		private SerialNumber sNumber = new SerialNumber();

		public Builder version(long v) {
			sNumber.version = v;
			return this;
		}

		public Builder type(long t) {
			sNumber.type = t;
			return this;
		}

		public Builder machineId(long m) {
			sNumber.machineId = m;
			return this;
		}

		public Builder millisecond(long m) {
			sNumber.machineId = m;
			return this;
		}

		public Builder sequence(long s) {
			sNumber.sequence = s;
			return this;
		}

		public SerialNumber build() {
			return sNumber;
		}

	}

}
