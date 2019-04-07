package org.sesame.service.entity;

public class SerialNumberMeta {
	private byte versionBits;
	private byte typeBits;
	private byte machineIdBits;
	private byte millisecondBits;
	private byte sequenceBits;

	public SerialNumberMeta(byte versionBits, byte typeBits, byte machineIdBits, byte millisecondBits,
			byte sequenceBits) {
		this.versionBits = versionBits;
		this.typeBits = typeBits;
		this.machineIdBits = machineIdBits;
		this.millisecondBits = millisecondBits;
		this.sequenceBits = sequenceBits;
	}

	public byte getVersionBits() {
		return this.versionBits;
	}

	public long getVersionBitsMask() {
		return -1L ^ -1L << versionBits;
	}

	public long getVersionBitsStartPosition() {
		return typeBits + machineIdBits + millisecondBits + sequenceBits;
	}

	public byte getTypeBits() {
		return this.typeBits;
	}

	public long getTypeBitsMask() {
		return -1L ^ -1L << typeBits;
	}

	public long getTypeBitsStartPosition() {
		return machineIdBits + millisecondBits + sequenceBits;
	}

	public byte getMachineIdBits() {
		return this.machineIdBits;
	}

	public long getMachineIdBitsMask() {
		return -1L ^ -1L << machineIdBits;
	}

	public long getMachineIdBitsStartPosition() {
		return millisecondBits + sequenceBits;
	}

	public byte getMillisecondBits() {
		return this.millisecondBits;
	}

	public long getMillisecondBitsMask() {
		return -1L ^ -1L << millisecondBits;
	}

	public long getgetMillisecondBitsStartPosition() {
		return sequenceBits;
	}

	public byte getSequenceBits() {
		return this.sequenceBits;
	}

	public long getSequenceBitsMask() {
		return -1L ^ -1L << sequenceBits;
	}

	// start from the low bit;
	public long getSequenceBitsStartPosition() {
		return 0;
	}

	public static class Builder {
		private byte versionBits;
		private byte typeBits;
		private byte machineIdBits;
		private byte millisecondBits;
		private byte sequenceBits;

		public Builder versionBits(byte versionBits) {
			this.versionBits = versionBits;
			return this;
		}

		public Builder typeBits(byte typeBits) {
			this.typeBits = typeBits;
			return this;
		}

		public Builder machineIdBits(byte machineIdBits) {
			this.machineIdBits = machineIdBits;
			return this;
		}

		public Builder millisecondBits(byte millisecondBits) {
			this.millisecondBits = millisecondBits;
			return this;
		}

		public Builder sequenceBits(byte sequenceBits) {
			this.sequenceBits = sequenceBits;
			return this;
		}

		public SerialNumberMeta build() {
			return new SerialNumberMeta(versionBits, typeBits, machineIdBits, millisecondBits, sequenceBits);
		}
	}

}
