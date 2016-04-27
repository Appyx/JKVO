package org.appyx.utli.jkvo;

/**
 * This interface is used in combination with JKVObservable
 */
public interface JKVObserver {

	String KVO_WILL_CHANGE = "org.appyx.util.jkvo.kvo.will.change";
	String KVO_DID_CHANGE = "org.appyx.util.jkvo.kvo.did.change";

	/**
	 * This method is triggered if an observed value will/did change
	 *
	 * @param value  The observed value
	 * @param tag    The observing identifier
	 * @param change can either be KVO_WILL_CHANGE or KVO_DID_CHANGE
	 */
	void observeValue(Object value, String tag, String change);
}
