# JKVO
Key-Value-Observing in Java

This project is an implementation of the KVO provided by ObjectiveC in Java.

#### How to use?

*  Make your model class extend JKVObservable
*  Replace your setter methods with:<dl>
<code> setValue(Object newValue){<br>this.value=setKVOValue("identifier", this.value, newValue);<br>}</code></dl>
*  Make your target class implement JKVObserver
*  Call addObserver and removeObserver at any place
*  Make sure to always use the setters and the corresponding identifiers ;)

#### Setup
* Just copy/paste the java files


* Import the Jar file