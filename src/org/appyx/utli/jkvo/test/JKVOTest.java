package org.appyx.utli.jkvo.test;

import org.appyx.utli.jkvo.JKVObserver;


class JKVOTest implements JKVObserver {

	public static void main(String[] args){
		JKVOTest test = new JKVOTest();

	}

	public JKVOTest(){
		JKVOTestModel model = new JKVOTestModel();
		model.addObserverForKey(this, "integer");
		model.addObserverForKey(this, "floateger");
		model.setFloateger(1.333f);
		model.addObserverForKey(this, "integer");
		model.setInteger(10);
		model.setInteger(11);
		model.removeObserver(this);

	}


	@Override
	public void valueWillChange(Object oldValue, String tag){
		System.out.println("old tag: " + tag + " object: " + oldValue);
	}

	@Override
	public void valueDidChange(Object newValue, String tag){
		System.out.println("new tag: " + tag + " object: " + newValue);
	}
}
