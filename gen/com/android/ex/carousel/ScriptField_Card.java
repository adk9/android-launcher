/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source RenderScript file: /Users/hugh/Downloads/CarouselExample/src/com/android/ex/carousel/carousel.rs
 */
package com.android.ex.carousel;

import android.renderscript.*;
import android.content.res.Resources;

/**
 * @hide
 */
public class ScriptField_Card extends android.renderscript.Script.FieldBase {
    static public class Item {
        public static final int sizeof = 160;

        Allocation texture;
        Allocation detailTexture;
        Float2 detailTextureOffset;
        Float2 detailLineOffset;
        Float2[] detailTexturePosition;
        Mesh geometry;
        Matrix4f matrix;
        int textureState;
        int detailTextureState;
        int geometryState;
        int cardVisible;
        int detailVisible;
        int shouldPrefetch;
        long textureTimeStamp;
        long detailTextureTimeStamp;
        long geometryTimeStamp;

        Item() {
            detailTextureOffset = new Float2();
            detailLineOffset = new Float2();
            detailTexturePosition = new Float2[2];
            for (int $ct = 0; $ct < 2; $ct++) {
                detailTexturePosition[$ct] = new Float2();
            }

            matrix = new Matrix4f();
        }

    }

    private Item mItemArray[];
    private FieldPacker mIOBuffer;
    public static Element createElement(RenderScript rs) {
        Element.Builder eb = new Element.Builder(rs);
        eb.add(Element.ALLOCATION(rs), "texture");
        eb.add(Element.ALLOCATION(rs), "detailTexture");
        eb.add(Element.F32_2(rs), "detailTextureOffset");
        eb.add(Element.F32_2(rs), "detailLineOffset");
        eb.add(Element.F32_2(rs), "detailTexturePosition", 2);
        eb.add(Element.MESH(rs), "geometry");
        eb.add(Element.MATRIX_4X4(rs), "matrix");
        eb.add(Element.I32(rs), "textureState");
        eb.add(Element.I32(rs), "detailTextureState");
        eb.add(Element.I32(rs), "geometryState");
        eb.add(Element.I32(rs), "cardVisible");
        eb.add(Element.I32(rs), "detailVisible");
        eb.add(Element.I32(rs), "shouldPrefetch");
        eb.add(Element.U32(rs), "#padding_1");
        eb.add(Element.I64(rs), "textureTimeStamp");
        eb.add(Element.I64(rs), "detailTextureTimeStamp");
        eb.add(Element.I64(rs), "geometryTimeStamp");
        return eb.create();
    }

    public  ScriptField_Card(RenderScript rs, int count) {
        mItemArray = null;
        mIOBuffer = null;
        mElement = createElement(rs);
        init(rs, count);
    }

    public  ScriptField_Card(RenderScript rs, int count, int usages) {
        mItemArray = null;
        mIOBuffer = null;
        mElement = createElement(rs);
        init(rs, count, usages);
    }

    private void copyToArray(Item i, int index) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        mIOBuffer.reset(index * Item.sizeof);
        mIOBuffer.addObj(i.texture);
        mIOBuffer.addObj(i.detailTexture);
        mIOBuffer.addF32(i.detailTextureOffset);
        mIOBuffer.addF32(i.detailLineOffset);
        for (int ct2 = 0; ct2 < 2; ct2++) {
            mIOBuffer.addF32(i.detailTexturePosition[ct2]);
        }

        mIOBuffer.addObj(i.geometry);
        mIOBuffer.addMatrix(i.matrix);
        mIOBuffer.addI32(i.textureState);
        mIOBuffer.addI32(i.detailTextureState);
        mIOBuffer.addI32(i.geometryState);
        mIOBuffer.addI32(i.cardVisible);
        mIOBuffer.addI32(i.detailVisible);
        mIOBuffer.addI32(i.shouldPrefetch);
        mIOBuffer.skip(4);
        mIOBuffer.addI64(i.textureTimeStamp);
        mIOBuffer.addI64(i.detailTextureTimeStamp);
        mIOBuffer.addI64(i.geometryTimeStamp);
    }

    public void set(Item i, int index, boolean copyNow) {
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        mItemArray[index] = i;
        if (copyNow)  {
            copyToArray(i, index);
            mAllocation.setFromFieldPacker(index, mIOBuffer);
        }

    }

    public Item get(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index];
    }

    public void set_texture(int index, Allocation v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].texture = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 0, fp);
        }

    }

    public void set_detailTexture(int index, Allocation v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTexture = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 4);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 1, fp);
        }

    }

    public void set_detailTextureOffset(int index, Float2 v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureOffset = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 8);
            mIOBuffer.addF32(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addF32(v);
            mAllocation.setFromFieldPacker(index, 2, fp);
        }

    }

    public void set_detailLineOffset(int index, Float2 v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailLineOffset = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 16);
            mIOBuffer.addF32(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addF32(v);
            mAllocation.setFromFieldPacker(index, 3, fp);
        }

    }

    public void set_detailTexturePosition(int index, Float2[] v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTexturePosition = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 24);
            for (int ct1 = 0; ct1 < 2; ct1++) {
                mIOBuffer.addF32(v[ct1]);
            }

            FieldPacker fp = new FieldPacker(16);
            for (int ct1 = 0; ct1 < 2; ct1++) {
                fp.addF32(v[ct1]);
            }

            mAllocation.setFromFieldPacker(index, 4, fp);
        }

    }

    public void set_geometry(int index, Mesh v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometry = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 40);
            mIOBuffer.addObj(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addObj(v);
            mAllocation.setFromFieldPacker(index, 5, fp);
        }

    }

    public void set_matrix(int index, Matrix4f v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].matrix = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 44);
            mIOBuffer.addMatrix(v);
            FieldPacker fp = new FieldPacker(64);
            fp.addMatrix(v);
            mAllocation.setFromFieldPacker(index, 6, fp);
        }

    }

    public void set_textureState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].textureState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 108);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 7, fp);
        }

    }

    public void set_detailTextureState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 112);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 8, fp);
        }

    }

    public void set_geometryState(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometryState = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 116);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 9, fp);
        }

    }

    public void set_cardVisible(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].cardVisible = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 120);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 10, fp);
        }

    }

    public void set_detailVisible(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailVisible = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 124);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 11, fp);
        }

    }

    public void set_shouldPrefetch(int index, int v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].shouldPrefetch = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 128);
            mIOBuffer.addI32(v);
            FieldPacker fp = new FieldPacker(4);
            fp.addI32(v);
            mAllocation.setFromFieldPacker(index, 12, fp);
        }

    }

    public void set_textureTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].textureTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 136);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 14, fp);
        }

    }

    public void set_detailTextureTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].detailTextureTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 144);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 15, fp);
        }

    }

    public void set_geometryTimeStamp(int index, long v, boolean copyNow) {
        if (mIOBuffer == null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
        if (mItemArray == null) mItemArray = new Item[getType().getX() /* count */];
        if (mItemArray[index] == null) mItemArray[index] = new Item();
        mItemArray[index].geometryTimeStamp = v;
        if (copyNow)  {
            mIOBuffer.reset(index * Item.sizeof + 152);
            mIOBuffer.addI64(v);
            FieldPacker fp = new FieldPacker(8);
            fp.addI64(v);
            mAllocation.setFromFieldPacker(index, 16, fp);
        }

    }

    public Allocation get_texture(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].texture;
    }

    public Allocation get_detailTexture(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTexture;
    }

    public Float2 get_detailTextureOffset(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTextureOffset;
    }

    public Float2 get_detailLineOffset(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailLineOffset;
    }

    public Float2[] get_detailTexturePosition(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].detailTexturePosition;
    }

    public Mesh get_geometry(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].geometry;
    }

    public Matrix4f get_matrix(int index) {
        if (mItemArray == null) return null;
        return mItemArray[index].matrix;
    }

    public int get_textureState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].textureState;
    }

    public int get_detailTextureState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailTextureState;
    }

    public int get_geometryState(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].geometryState;
    }

    public int get_cardVisible(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].cardVisible;
    }

    public int get_detailVisible(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailVisible;
    }

    public int get_shouldPrefetch(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].shouldPrefetch;
    }

    public long get_textureTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].textureTimeStamp;
    }

    public long get_detailTextureTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].detailTextureTimeStamp;
    }

    public long get_geometryTimeStamp(int index) {
        if (mItemArray == null) return 0;
        return mItemArray[index].geometryTimeStamp;
    }

    public void copyAll() {
        for (int ct = 0; ct < mItemArray.length; ct++) copyToArray(mItemArray[ct], ct);
        mAllocation.setFromFieldPacker(0, mIOBuffer);
    }

    public void resize(int newSize) {
        if (mItemArray != null)  {
            int oldSize = mItemArray.length;
            int copySize = Math.min(oldSize, newSize);
            if (newSize == oldSize) return;
            Item ni[] = new Item[newSize];
            System.arraycopy(mItemArray, 0, ni, 0, copySize);
            mItemArray = ni;
        }

        mAllocation.resize(newSize);
        if (mIOBuffer != null) mIOBuffer = new FieldPacker(Item.sizeof * getType().getX()/* count */);
    }

}

