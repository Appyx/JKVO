package org.appyx.utli.jkvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class simulates the Key-Value-Observing mechanism of ObjectiveC
 * To observe values:
 * 1) let your model class extend this class
 * 2) replace your setter methods with: this.value=setKVOValue("identifier", this.value, newValue);
 * 3) call addObserver and removeObserver at any place
 */

public class JKVObservable {

	HashMap<String, ArrayList<JKVObserver>> mObserverMap = new HashMap<>();


	/**
	 * Adds an observer for the specified key
	 *
	 * @param target The callback target
	 * @param key    The identifier
	 */
	public void addObserverForKey(JKVObserver target, String key){
		ArrayList<JKVObserver> observers = mObserverMap.get(key);
		if(observers != null){
			if(!observers.contains(target)){
				observers.add(target);
			}
		} else{
			observers = new ArrayList<>();
			observers.add(target);
			mObserverMap.put(key, observers);
		}
	}

	/**
	 * Removes all observers for this target
	 *
	 * @param target The callback target
	 */
	public void removeObserver(JKVObserver target){
		Set<Entry<String, ArrayList<JKVObserver>>> entrySet = mObserverMap.entrySet();
		ArrayList<String> removableKeys = new ArrayList<>();

		for(Entry<String, ArrayList<JKVObserver>> entry : entrySet){
			entry.getValue().remove(target);
			if(entry.getValue().size() == 0){
				removableKeys.add(entry.getKey());
			}
		}

		for(String key : removableKeys){
			mObserverMap.remove(key);
		}

	}

	/**
	 * Removes one specific property observer
	 *
	 * @param target The callback target
	 * @param key    The identifier
	 */
	public void removeObserver(JKVObserver target, String key){
		ArrayList<JKVObserver> observers = mObserverMap.get(key);
		String removableKey = null;
		if(observers != null){
			observers.remove(target);
			if(observers.size() == 0){
				removableKey = key;

			}
		}
		if(removableKey != null){
			mObserverMap.remove(key);
		}
	}

	private void didSetKVO(String key, Object value){
		ArrayList<JKVObserver> observers = mObserverMap.get(key);
		if(observers == null){
			return;
		}
		for(JKVObserver observer : observers){
			observer.valueDidChange(value, key);
		}
	}

	private void willSetKVO(String key, Object value){
		ArrayList<JKVObserver> observers = mObserverMap.get(key);
		if(observers == null){
			return;
		}
		for(JKVObserver observer : observers){
			observer.valueWillChange(value, key);
		}
	}

	/**
	 * Always use this method to make the property observable.
	 * Integrate this in your setter.
	 * The returning value have to be set on the property.
	 *
	 * @param key       The identifier
	 * @param oldObject The old value
	 * @param newObject The new value
	 * @return The new value
	 */
	protected Object setKVOValue(String key, Object oldObject, Object newObject){
		willSetKVO(key, oldObject);
		try{
			return newObject;
		} catch(Exception e){
			//never used
		} finally{
			didSetKVO(key, newObject);
		}
		return null; //never used
	}


}
