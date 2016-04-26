package org.appyx.utli.jkvo.test;

import org.appyx.utli.jkvo.JKVObservable;

class JKVOTestModel extends JKVObservable {

	public int getInteger(){
		return integer;
	}

	public void setInteger(int integer){
		this.integer = (int) setKVOValue("integer", this.integer, integer);
	}

	public float getFloateger(){
		return floateger;

	}

	public void setFloateger(float floateger){
		this.floateger = (float) setKVOValue("floateger", this.floateger, floateger);
	}

	public Object getObject(){
		return object;
	}

	public void setObject(Object object){
		this.object = object;
	}

	int integer = 0;
	float floateger = 0;
	Object object = null;

}
