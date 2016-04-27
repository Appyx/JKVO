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
	public void observeValue(Object newValue, String tag, String change){
		if(change == KVO_DID_CHANGE){
			System.out.println(tag + " did: " + newValue);
		}
		if(change == KVO_WILL_CHANGE){
			System.out.println(tag + " will: " + newValue);
		}
	}
}
