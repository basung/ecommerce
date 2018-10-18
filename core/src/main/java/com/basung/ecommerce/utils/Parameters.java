package com.basung.ecommerce.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * Date: 2018-10-17-下午7:39
 */
public interface Parameters extends Cloneable {
    String getString(String var1);

    String getString(String var1, String var2);

    byte getByte(String var1);

    byte getByte(String var1, byte var2);

    char getChar(String var1);

    char getChar(String var1, char var2);

    boolean getBoolean(String var1);

    boolean getBoolean(String var1, boolean var2);

    short getShort(String var1);

    short getShort(String var1, short var2);

    int getInt(String var1);

    int getInt(String var1, int var2);

    float getFloat(String var1);

    float getFloat(String var1, float var2);

    double getDouble(String var1);

    double getDouble(String var1, double var2);

    long getLong(String var1);

    long getLong(String var1, long var2);

    Object getObject(String var1);

    Object getObject(String var1, Object var2);

    void setByte(String var1, byte var2);

    void setChar(String var1, char var2);

    void setShort(String var1, short var2);

    void setInt(String var1, int var2);

    void setBoolean(String var1, boolean var2);

    void setLong(String var1, long var2);

    void setFloat(String var1, float var2);

    void setDouble(String var1, double var2);

    String setString(String var1, String var2);

    Object setObject(String var1, Object var2);

    Iterator<String> getNames();

    Iterator getValues();

    Object remove(String var1);

    void putAll(Parameters var1);

    void putAll(Map<String, ?> var1);

    boolean isEmpty();

    int size();

    void clear();

    boolean[] getBooleanArray(String var1);

    boolean[] getBooleanArray(String var1, boolean[] var2);

    byte[] getByteArray(String var1);

    byte[] getByteArray(String var1, byte[] var2);

    char[] getCharArray(String var1);

    char[] getCharArray(String var1, char[] var2);

    double[] getDoubleArray(String var1);

    double[] getDoubleArray(String var1, double[] var2);

    float[] getFloatArray(String var1);

    float[] getFloatArray(String var1, float[] var2);

    int[] getIntArray(String var1);

    int[] getIntArray(String var1, int[] var2);

    long[] getLongArray(String var1);

    long[] getLongArray(String var1, long[] var2);

    Object[] getObjectArray(String var1);

    Object[] getObjectArray(String var1, Object[] var2);

    short[] getShortArray(String var1);

    short[] getShortArray(String var1, short[] var2);

    String[] getStringArray(String var1);

    String[] getStringArray(String var1, String[] var2);
}
