# JKVO
Key-Value-Observing in Java

This project is an implementation of the KVO provided by ObjectiveC in Java.

#### How to use?

*  Let your model class extend this class


*  Replace your setter methods with:<dl>
<code> setValue(Object newValue){<br>
this.value=setKVOValue("identifier", this.value, newValue);<br>}
</code></dl>
*  Call addObserver and removeObserver at any place
*  Make sure to always use the same identifiers ;)

#### Setup
* Just copy/paste the java files


* Import the Jar file