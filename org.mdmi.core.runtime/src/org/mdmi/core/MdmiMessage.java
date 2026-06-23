/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.io.File;
import java.util.ArrayList;

import org.mdmi.core.engine.UnspecifiedNode;
import org.mdmi.core.util.FileUtil;
import org.mdmi.core.util.StringUtil;

/**
 * Message wrapper class.
 *
 * @author goancea
 */
public final class MdmiMessage {
	private byte[] m_originalData;

	private byte[] m_currentData;

	ArrayList<UnspecifiedNode> unspecifiedNodes = new ArrayList<>();

	public ArrayList<UnspecifiedNode> getUnspecifiedNodes() {
		return unspecifiedNodes;
	}

	private static final byte[] BOM_UTF8 = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };

	private static final byte[] BOM_UTF16BE = new byte[] { (byte) 0xFE, (byte) 0xFF };

	private static final byte[] BOM_UTF16LE = new byte[] { (byte) 0xFF, (byte) 0xFE };

	/**
	 * Construct a new message from the given bytes.
	 *
	 * @param data
	 *            The message data bytes.
	 */
	public MdmiMessage(byte[] data) {
		setDataImpl(data);
	}

	/**
	 * Construct a new message from the given string data. UTF-8 encoding is assumed.
	 *
	 * @param data
	 *            The string message data.
	 */
	public MdmiMessage(String data) {
		setDataImpl(StringUtil.getBytes(data));
	}

	/**
	 * Construct a new message from the given string data, with the specified encoding.
	 *
	 * @param data
	 *            The string message data.
	 * @param encoding
	 *            the encoding to use.
	 */
	public MdmiMessage(String data, String encoding) {
		setDataImpl(StringUtil.getBytes(data, encoding));
	}

	/**
	 * Construct a new message from the file bytes.
	 *
	 * @param file
	 *            The file to read, must exist and must be a file.
	 */
	public MdmiMessage(File file) {
		if (file == null || !file.exists() || !file.isFile()) {
			throw new IllegalArgumentException("Invalid or missing file " + file);
		}
		setDataImpl(FileUtil.readFileBytes(file));
	}

	/**
	 *
	 */
	public MdmiMessage() {
	}

	/**
	 * Get the data bytes.
	 *
	 * @return The data bytes.
	 */
	public byte[] getData() {
		return m_currentData;
	}

	/**
	 * Get the message data as string. UTF-8 encoding is assumed.
	 *
	 * @return The message data as string.
	 */
	public String getDataAsString() {
		return StringUtil.getString(m_currentData);
	}

	/**
	 * Get the message data as string using the specified encoding.
	 *
	 * @param encoding
	 *            The encoding to use.
	 * @return The string data for the message.
	 */
	public String getDataAsString(String encoding) {
		return StringUtil.getString(m_currentData, encoding);
	}

	/**
	 * Set the message data as bytes. The original data is maintained as a copy.
	 *
	 * @param data
	 *            The new data.
	 */
	public void setData(byte[] data) {
		if (m_originalData == null) {
			m_originalData = m_currentData;
		}
		setDataImpl(data);
	}

	/**
	 * Set the message data as string, UTF-8 is assumed. The original data is maintained as a copy.
	 *
	 * @param data
	 *            The new data.
	 */
	public void setData(String data) {
		if (m_originalData == null) {
			m_originalData = m_currentData;
		}
		setDataImpl(StringUtil.getBytes(data));
	}

	/**
	 * Set the message data as string, using the given encoding. The original data is maintained as a copy.
	 *
	 * @param data
	 *            The new data.
	 * @param encoding
	 *            The encoding to use.
	 */
	public void setData(String data, String encoding) {
		if (m_originalData == null) {
			m_originalData = m_currentData;
		}
		setDataImpl(StringUtil.getBytes(data, encoding));
	}

	private void setDataImpl(byte[] data) {
		if (data != null && 2 < data.length) {
			if (data[0] == BOM_UTF8[0] && data[1] == BOM_UTF8[1] && data[2] == BOM_UTF8[2]) {
				m_currentData = new byte[data.length - 3];
				System.arraycopy(data, 3, m_currentData, 0, data.length - 3);
				return; // UTF-8 BOM
			} else if (data[0] == BOM_UTF16BE[0] && data[1] == BOM_UTF16BE[1] ||
					data[0] == BOM_UTF16LE[0] && data[1] == BOM_UTF16LE[1]) {
				m_currentData = new byte[data.length - 2];
				System.arraycopy(data, 2, m_currentData, 0, data.length - 2);
				return; // UTF-16 BOM
			}
		}
		m_currentData = data;
	}

	/**
	 * Get the original message data.
	 *
	 * @return The original message data.
	 */
	public byte[] getOriginalData() {
		return m_originalData;
	}

	/**
	 * Return true if the message was modified since its creation.
	 *
	 * @return True if the message was modified since its creation.
	 */
	public boolean isModified() {
		return m_originalData != null;
	}
} // MdmiMessage
