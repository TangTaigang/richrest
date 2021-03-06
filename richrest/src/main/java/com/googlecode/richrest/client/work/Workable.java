package com.googlecode.richrest.client.work;

/**
 * 工作接口
 * @author <a href="mailto:liangfei0201@gmail.com">liangfei</a>
 */
public interface Workable {

	/**
	 * 工作
	 * @param work 工作信息
	 * @throws Exception 工作出错时抛出
	 */
	void run(Work work) throws Exception;

}
