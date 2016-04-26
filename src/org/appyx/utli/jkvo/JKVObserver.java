package org.appyx.utli.jkvo;

public interface JKVObserver {

	void valueWillChange(Object oldValue, String tag);

	void valueDidChange(Object newValue, String tag);
}
