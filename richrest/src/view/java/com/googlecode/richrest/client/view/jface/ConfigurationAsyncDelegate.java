package com.googlecode.richrest.client.view.jface;

import com.googlecode.richrest.client.event.PropertyEvent;
import com.googlecode.richrest.client.event.PropertyListener;

/**
 * 连接事件监听器UI线程执行委托，如果UI线程非空闲，则等待。
 * @author <a href="mailto:liangfei0201@gmail.com">liangfei</a>
 */
public class ConfigurationAsyncDelegate implements PropertyListener {

	private final PropertyListener listener;

	private final boolean runOnUI;

	private final boolean runOnNonUI;

	public ConfigurationAsyncDelegate(PropertyListener listener) {
		this(listener, true, true);
	}

	public ConfigurationAsyncDelegate(PropertyListener listener, boolean runOnUI, boolean runOnNonUI) {
		this.listener = listener;
		this.runOnUI = runOnUI;
		this.runOnNonUI = runOnNonUI;
	}

	public void onPropertyChanged(final PropertyEvent event) {
		try {
			if (UIUtils.isUIThread()) {
				if (runOnUI) {
					listener.onPropertyChanged(event);
				}
			} else {
				if (runOnNonUI) {
					UIUtils.asyncExecute(new Runnable() { // 在UI线程内执行
						public void run() {
							listener.onPropertyChanged(event);
						}
					});
				}
			}
		} catch (Throwable e) {
			// ignore
		}
	}

	public boolean isAsync() {
		return listener.isAsync();
	}

}
