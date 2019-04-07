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
				.append("machineId:").append(machineId).append(",").append("millisecond:").append(millisecond)
				.append(",").append("sequence:").append(sequence).append("}");

		return sBuilder.toString();
	}

	public static class Builder {
		private long version;
		private long type;
		private long machineId;
		private long millisecond;
		private long sequence;

		public Builder version(long v) {
			this.version = v;
			return this;
		}

		public Builder type(long t) {
			this.type = t;
			return this;
		}

		public Builder machineId(long m) {
			this.machineId = m;
			return this;
		}

		public Builder millisecond(long m) {
			this.millisecond = m;
			return this;
		}

		public Builder sequence(long s) {
			this.sequence = s;
			return this;
		}

		public SerialNumber build() {
			return new SerialNumber(version, type, machineId, millisecond, sequence);
		}

	}

}
