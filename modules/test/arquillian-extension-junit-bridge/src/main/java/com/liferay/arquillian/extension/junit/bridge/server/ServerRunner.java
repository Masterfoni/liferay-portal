/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.arquillian.extension.junit.bridge.server;

import java.util.concurrent.TimeUnit;

import org.junit.AssumptionViolatedException;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

/**
 * @author Shuyang Zhou
 */
public class ServerRunner extends Runner {

	public ServerRunner(Class<?> clazz, String methodName) {
		_clazz = clazz;
		_methodName = methodName;
	}

	@Override
	public Description getDescription() {
		return Description.createSuiteDescription(
			_clazz.getName(), _clazz.getAnnotations());
	}

	@Override
	public void run(RunNotifier runNotifier) {
		TestClass testClass = new TestClass(_clazz);

		for (FrameworkMethod frameworkMethod :
				testClass.getAnnotatedMethods(Test.class)) {

			String methodName = frameworkMethod.getName();

			if (!methodName.equals(_methodName)) {
				continue;
			}

			Description description = Description.createTestDescription(
				_clazz, methodName, frameworkMethod.getAnnotations());

			try {
				Statement statement = _withTimeout(
					frameworkMethod,
					new ServerExecutorStatement(
						testClass, _clazz, frameworkMethod.getMethod()));

				statement.evaluate();
			}
			catch (AssumptionViolatedException ave) {
				runNotifier.fireTestAssumptionFailed(
					new Failure(description, ave));
			}
			catch (MultipleFailureException mfe) {
				Throwable throwable = null;

				for (Throwable t : mfe.getFailures()) {
					if (throwable == null) {
						throwable = t;
					}
					else {
						throwable.addSuppressed(t);
					}
				}

				if (throwable != null) {
					runNotifier.fireTestFailure(
						new Failure(description, throwable));
				}
			}
			catch (Throwable t) {
				runNotifier.fireTestFailure(new Failure(description, t));
			}
		}
	}

	private Statement _withTimeout(
		FrameworkMethod frameworkMethod, Statement statement) {

		Test test = frameworkMethod.getAnnotation(Test.class);

		if ((test == null) || (test.timeout() <= 0)) {
			return statement;
		}

		FailOnTimeout.Builder builder = FailOnTimeout.builder();

		builder.withTimeout(test.timeout(), TimeUnit.MILLISECONDS);

		return builder.build(statement);
	}

	private final Class<?> _clazz;
	private final String _methodName;

}