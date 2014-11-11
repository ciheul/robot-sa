package com.ciheul.robotsa.xml.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;

public class DefaultHandlerMapping extends PropertyHandlerMapping {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addHandler(String pKey, Class pClass) throws XmlRpcException {
		Map map = new HashMap();
		Method[] methods = pClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			final Method method = methods[i];
			if (!isHandlerMethod(method)) {
				continue;
			}
			String name;
			if (pKey != null) {
				name = pKey + "." + method.getName();
			} else {
				name = method.getName();
			}
			Method[] mArray;
			Method[] oldMArray = (Method[]) map.get(name);
			if (oldMArray == null) {
				mArray = new Method[] { method };
			} else {
				mArray = new Method[oldMArray.length + 1];
				System.arraycopy(oldMArray, 0, mArray, 0, oldMArray.length);
				mArray[oldMArray.length] = method;
			}
			map.put(name, mArray);
		}

		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			String name = (String) entry.getKey();
			Method[] mArray = (Method[]) entry.getValue();
			handlerMap.put(name, newXmlRpcHandler(pClass, mArray));
		}
	}

	@SuppressWarnings("rawtypes")
	public void addHandler(Class pClass) throws XmlRpcException {
		this.addHandler(null, pClass);
	}

}
