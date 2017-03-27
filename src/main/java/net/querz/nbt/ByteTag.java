package net.querz.nbt;

import java.io.IOException;

public class ByteTag extends NumberTag<Byte> {
	private byte value;
	
	protected ByteTag() {
		this((byte) 0);
	}
	
	public ByteTag(byte value) {
		this("", value);
	}
	
	public ByteTag(boolean value) {
		this("", value);
	}
	
	public ByteTag(String name, byte value) {
		super(TagType.BYTE, name);
		setValue(value);
	}
	
	public ByteTag(String name, boolean value) {
		super(TagType.BYTE, name);
		setValue(value);
	}
	
	public void setValue(byte value) {
		this.value = value;
	}
	
	public void setValue(boolean value) {
		this.value = value ? (byte) 1 : 0;
	}
	
	public boolean getBoolean() {
		return value != 0;
	}
	
	@Override
	public Byte getValue() {
		return value;
	}

	@Override
	protected void serialize(NBTOutputStream nbtOut, int depth) throws IOException {
		nbtOut.dos.writeByte(value);
	}
	
	@Override
	protected ByteTag deserialize(NBTInputStream nbtIn, int depth) throws IOException {
		value = nbtIn.dis.readByte();
		return this;
	}

	@Override
	public String toTagString() {
		return NBTUtil.createNamePrefix(this) + valueToTagString(0);
	}
	
	@Override
	protected String valueToTagString(int depth) {
		return value + "b";
	}
	
	@Override
	public String toString() {
		return "<byte:" + getName() + ":" + value + ">";
	}
	
	@Override
	public ByteTag clone() {
		return new ByteTag(getName(), value);
	}
}